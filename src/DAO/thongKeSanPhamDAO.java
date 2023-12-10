package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class thongKeSanPhamDAO {
    private sqlConnect sqlConn;
    
    public thongKeSanPhamDAO() {
        sqlConn = new sqlConnect();
    }
    
    // Phương thức để lấy số lượng sản phẩm của một hãng cụ thể trong ngày hiện tại
    public int getSanPhamCountByHang(String hang) {
        int tongSoLuong = 0;
        try {
            String query = "SELECT SUM(CTH.SoLuong) AS TongSoLuong " +
                           "FROM HoaDon H " +
                           "INNER JOIN CTHoaDon CTH ON H.MaHoaDon = CTH.MaHoaDon " +
                           "INNER JOIN SanPham SP ON CTH.MaSP = SP.MaSP " +
                           "WHERE SP.Hang = ? " +
                           "AND CONVERT(DATE, H.NgayXuat) = CONVERT(DATE, GETDATE())";
            Connection connection = sqlConn.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, hang);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                tongSoLuong = resultSet.getInt("TongSoLuong");
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Lỗi truy vấn cơ sở dữ liệu: " + e);
        }
        return tongSoLuong;
    }
    
//    public int getSanPhamCountByHangForWeek(String hang) {
//        int tongSoLuong = 0;
//        try {
//            // Đổi truy vấn SQL để lấy số lượng theo tuần
//            String query = "SELECT SUM(CTH.SoLuong) AS TongSoLuong " +
//                           "FROM HoaDon H " +
//                           "INNER JOIN CTHoaDon CTH ON H.MaHoaDon = CTH.MaHoaDon " +
//                           "INNER JOIN SanPham SP ON CTH.MaSP = SP.MaSP " +
//                           "WHERE SP.Hang = ? " +
//                           "AND YEAR(H.NgayLap) = YEAR(GETDATE()) " +
//                           "AND DATEPART(WEEK, H.NgayLap) = DATEPART(WEEK, GETDATE())";
//            Connection connection = sqlConn.getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setString(1, hang);
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            if (resultSet.next()) {
//                tongSoLuong = resultSet.getInt("TongSoLuong");
//            }
//
//            resultSet.close();
//            preparedStatement.close();
//        } catch (SQLException e) {
//            System.out.println("Lỗi truy vấn cơ sở dữ liệu: " + e);
//        }
//        return tongSoLuong;
//    }

    public int getSanPhamCountByHangForYear(String hang) {
        int tongSoLuong = 0;
        try {
            // Đổi truy vấn SQL để lấy số lượng theo năm
            String query = "SELECT SUM(CTH.SoLuong) AS TongSoLuong " +
                           "FROM HoaDon H " +
                           "INNER JOIN CTHoaDon CTH ON H.MaHoaDon = CTH.MaHoaDon " +
                           "INNER JOIN SanPham SP ON CTH.MaSP = SP.MaSP " +
                           "WHERE SP.Hang = ? " +
                           "AND YEAR(H.NgayLap) = YEAR(GETDATE())";
            Connection connection = sqlConn.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, hang);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                tongSoLuong = resultSet.getInt("TongSoLuong");
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Lỗi truy vấn cơ sở dữ liệu: " + e);
        }
        return tongSoLuong;
    }

    public int getSanPhamCountByHangForMonth(String hang) {
        int tongSoLuong = 0;
        try {
            // Đổi truy vấn SQL để lấy số lượng theo tháng
            String query = "SELECT SUM(CTH.SoLuong) AS TongSoLuong " +
                           "FROM HoaDon H " +
                           "INNER JOIN CTHoaDon CTH ON H.MaHoaDon = CTH.MaHoaDon " +
                           "INNER JOIN SanPham SP ON CTH.MaSP = SP.MaSP " +
                           "WHERE SP.Hang = ? " +
                           "AND YEAR(H.NgayLap) = YEAR(GETDATE()) " +
                           "AND DATEPART(MONTH, H.NgayLap) = DATEPART(MONTH, GETDATE())";
            Connection connection = sqlConn.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, hang);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                tongSoLuong = resultSet.getInt("TongSoLuong");
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Lỗi truy vấn cơ sở dữ liệu: " + e);
        }
        return tongSoLuong;
    }
    
    public List<String[]> getSalesDataForWeek() {
        List<String[]> salesData = new ArrayList<>();
        try {
            // Đoạn truy vấn bạn đã cung cấp
            String query = "WITH AllDaysOfWeek AS (" +
            "SELECT 1 AS Weekday, 'Chu nhat' AS NgayTrongTuan " +
            "UNION SELECT 2, 'Thu 2' " +
            "UNION SELECT 3, 'Thu 3' " +
            "UNION SELECT 4, 'Thu 4' " +
            "UNION SELECT 5, 'Thu 5' " +
            "UNION SELECT 6, 'Thu 6' " +
            "UNION SELECT 7, 'Thu 7' " +
            ") " +
            "SELECT " +
            "CASE " +
            "WHEN D.Weekday = DATEPART(WEEKDAY, GETDATE()) THEN 'Hôm nay' " +
            "ELSE D.NgayTrongTuan " +
            "END AS NgayTrongTuan, " +
            "ISNULL(SUM(CTH.SoLuong), 0) AS TongSoLuong " +
            "FROM " +
            "AllDaysOfWeek D " +
            "LEFT JOIN " +
            "HoaDon H ON DATEPART(WEEKDAY, H.NgayLap) = D.Weekday " +
            "LEFT JOIN " +
            "CTHoaDon CTH ON H.MaHoaDon = CTH.MaHoaDon " +
            "AND YEAR(H.NgayLap) = YEAR(GETDATE()) " +
            "AND DATEPART(WEEK, H.NgayLap) = DATEPART(WEEK, GETDATE()) " +
            "GROUP BY " +
            "CASE " +
            "WHEN D.Weekday = DATEPART(WEEKDAY, GETDATE()) THEN 'Hôm nay' " +
            "ELSE D.NgayTrongTuan " +
            "END";

            Connection connection = sqlConn.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String ngayTrongTuan = resultSet.getString("NgayTrongTuan");
                int tongSoLuong = resultSet.getInt("TongSoLuong");
                salesData.add(new String[]{ngayTrongTuan, String.valueOf(tongSoLuong)});
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Lỗi truy vấn cơ sở dữ liệu: " + e);
        }
        return salesData;
    }
    
    public List<String[]> getRecentMonthsSalesData() {
        List<String[]> salesData = new ArrayList<>();
        try {
            // Đoạn truy vấn SQL để lấy dữ liệu từ các tháng gần đây
            String query = "-- Tạo bảng tạm để lưu danh sách tháng gần đây\n" +
                            "CREATE TABLE #RecentMonths (MonthStart DATETIME, MonthEnd DATETIME)\n" +
                            "\n" +
                            "-- Lấy ngày đầu và ngày cuối của tháng hiện tại\n" +
                            "DECLARE @CurrentMonthStart DATETIME = DATEADD(MONTH, DATEDIFF(MONTH, 0, GETDATE()), 0)\n" +
                            "DECLARE @CurrentMonthEnd DATETIME = EOMONTH(GETDATE())\n" +
                            "\n" +
                            "-- Lấy 6 tháng gần đây và thêm vào bảng tạm\n" +
                            "INSERT INTO #RecentMonths (MonthStart, MonthEnd)\n" +
                            "VALUES\n" +
                            "    (@CurrentMonthStart, @CurrentMonthEnd),\n" +
                            "    (DATEADD(MONTH, -1, @CurrentMonthStart), DATEADD(DAY, -1, @CurrentMonthStart)),\n" +
                            "    (DATEADD(MONTH, -2, @CurrentMonthStart), DATEADD(DAY, -1, DATEADD(MONTH, -1, @CurrentMonthStart))),\n" +
                            "    (DATEADD(MONTH, -3, @CurrentMonthStart), DATEADD(DAY, -1, DATEADD(MONTH, -2, @CurrentMonthStart))),\n" +
                            "    (DATEADD(MONTH, -4, @CurrentMonthStart), DATEADD(DAY, -1, DATEADD(MONTH, -3, @CurrentMonthStart)))\n" +
                            "\n" +
                            "-- Lấy tổng số lượng sản phẩm bán trong từng tháng\n" +
                            "SELECT\n" +
                            "    DATENAME(MONTH, MonthStart) AS MonthName,\n" +
                            "    ISNULL(SUM(CTH.SoLuong), 0) AS TongSoLuong\n" +
                            "FROM\n" +
                            "    #RecentMonths M\n" +
                            "LEFT JOIN\n" +
                            "    HoaDon H ON H.NgayLap >= M.MonthStart AND H.NgayLap < DATEADD(DAY, 1, M.MonthEnd)\n" +
                            "LEFT JOIN\n" +
                            "    CTHoaDon CTH ON H.MaHoaDon = CTH.MaHoaDon\n" +
                            "GROUP BY\n" +
                            "    MonthStart, MonthEnd\n" +
                            "-- Xóa bảng tạm sau khi sử dụng xong\n" +
                            "DROP TABLE #RecentMonths";
            Connection connection = sqlConn.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String monthName = resultSet.getString("MonthName");
                int tongSoLuong = resultSet.getInt("TongSoLuong");
                salesData.add(new String[]{monthName, String.valueOf(tongSoLuong)});
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Lỗi truy vấn cơ sở dữ liệu: " + e);
        }
        return salesData;
    }

    public List<String[]> getRecentYearsSalesData() {
        List<String[]> salesData = new ArrayList<>();
        try {
            // Đoạn truy vấn SQL để lấy dữ liệu từ 5 năm gần đây
            String query = "-- Tạo bảng tạm để lưu danh sách các năm gần đây\n" +
                           "CREATE TABLE #RecentYears (YearStart DATETIME, YearEnd DATETIME)\n" +
                           "\n" +
                           "-- Lấy năm hiện tại và 4 năm trước đó\n" +
                           "DECLARE @CurrentYear INT = YEAR(GETDATE())\n" +
                           "\n" +
                           "-- Lấy tổng số lượng sản phẩm bán trong từng năm\n" +
                           "SELECT\n" +
                           "    YEAR(H.NgayLap) AS YearName,\n" +
                           "    ISNULL(SUM(CTH.SoLuong), 0) AS TongSoLuong\n" +
                           "FROM\n" +
                           "    HoaDon H\n" +
                           "LEFT JOIN\n" +
                           "    CTHoaDon CTH ON H.MaHoaDon = CTH.MaHoaDon\n" +
                           "WHERE\n" +
                           "    YEAR(H.NgayLap) >= @CurrentYear - 4\n" +
                           "GROUP BY\n" +
                           "    YEAR(H.NgayLap)\n" +
                           "ORDER BY\n" +
                           "    YearName ASC";
            Connection connection = sqlConn.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String yearName = resultSet.getString("YearName");
                int tongSoLuong = resultSet.getInt("TongSoLuong");
                salesData.add(new String[]{yearName, String.valueOf(tongSoLuong)});
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Lỗi truy vấn cơ sở dữ liệu: " + e);
        }
        return salesData;
    }

    public List<String[]> thongKeSanPham(String ngayBatDau, String ngayKetThuc) {
        List<String[]> result = new ArrayList<>();
        try {
            String query = "SELECT SP.TenSP, SUM(CTH.SoLuong) AS TongSoLuong " +
                           "FROM CTHoaDon CTH " +
                           "INNER JOIN SanPham SP ON CTH.MaSP = SP.MaSP " +
                           "INNER JOIN HoaDon H ON CTH.MaHoaDon = H.MaHoaDon " +
                           "WHERE H.NgayLap >= ? AND H.NgayLap <= ? " +
                           "GROUP BY SP.TenSP";

            Connection connection = sqlConn.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, ngayBatDau);
            preparedStatement.setString(2, ngayKetThuc);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String tenSP = resultSet.getString("TenSP");
                int tongSoLuong = resultSet.getInt("TongSoLuong");
                result.add(new String[]{tenSP, String.valueOf(tongSoLuong)});
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println("Lỗi truy vấn cơ sở dữ liệu: " + e);
        }
        return result;
    }



}
