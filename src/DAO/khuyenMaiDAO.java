package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import GUI.khuyenMaiGUI;
import DTO.khuyenMaiDTO;
import java.util.Date;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement; 

public class khuyenMaiDAO {
    private sqlConnect sqlConn;

    public khuyenMaiDAO() {
        sqlConn = new sqlConnect();
    }

    public void loadKhuyenMaiData(JTable jTable1) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Xóa hết dữ liệu trong jTable1

        try {
            String query = "SELECT MaCTKM, TenCTKM, MucGiamGia, LoaiSanPhamDuocApDung, ThoiGianBatDau, ThoiGianKetThuc, ThoiGianTaoKM FROM ChuongTrinhKhuyenMai"; // Thay thế bằng tên bảng thực tế
            ResultSet resultSet = sqlConn.getSta().executeQuery(query);

            while (resultSet.next()) {
                String maCTKM = resultSet.getString("MaCTKM");
                String tenCTKM = resultSet.getString("TenCTKM");
                int mucGiamGia = resultSet.getInt("MucGiamGia");
                String loaiKhuyenMai = resultSet.getString("LoaiSanPhamDuocApDung");
                Date ngayBatDau = resultSet.getDate("ThoiGianBatDau");
                Date ngayKetThuc = resultSet.getDate("ThoiGianKetThuc");
                String thoiGianTao = resultSet.getString("ThoiGianTaoKM");
                // Thêm dữ liệu vào model của jTable1
                model.addRow(new Object[]{maCTKM, tenCTKM, mucGiamGia, loaiKhuyenMai, ngayBatDau, ngayKetThuc, thoiGianTao});
            }

            resultSet.close();
        } catch (SQLException e) {
            System.out.println("Lỗi truy vấn cơ sở dữ liệu: " + e);
        }
    }

    public void searchKhuyenMai(JTable jTable1, String keyword, Date from, Date to) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Xóa hết dữ liệu trong jTable1

        try {
            Connection connection = sqlConn.getConnection();

            if (connection != null) {
                String query;
                PreparedStatement preparedStatement;

                if ((keyword == null || keyword.isEmpty()) && from != null && to != null) {
                    // Tìm theo ngày
                    query = "SELECT * FROM ChuongTrinhKhuyenMai WHERE ThoiGianBatDau >= ? AND ThoiGianKetThuc <= ?";
                    preparedStatement = connection.prepareStatement(query);
                    preparedStatement.setObject(1, from);
                    preparedStatement.setObject(2, to);
                } else if (keyword != null && !keyword.isEmpty() && from != null && to != null) {
                    // Tìm theo cả mã và ngày
                    query = "SELECT * FROM ChuongTrinhKhuyenMai WHERE MaCTKM = ? AND ThoiGianBatDau >= ? AND ThoiGianKetThuc <= ?";
                    preparedStatement = connection.prepareStatement(query);
                    preparedStatement.setString(1, keyword);
                    preparedStatement.setObject(2, from);
                    preparedStatement.setObject(3, to);
                } else if (keyword != null && !keyword.isEmpty()) {
                    // Tìm theo mã
                    query = "SELECT * FROM ChuongTrinhKhuyenMai WHERE MaCTKM = ?";
                    preparedStatement = connection.prepareStatement(query);
                    preparedStatement.setString(1, keyword);
                } else {
                    // Lấy toàn bộ dữ liệu
                    query = "SELECT * FROM ChuongTrinhKhuyenMai";
                    preparedStatement = connection.prepareStatement(query);
                }

                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    String maCTKM = resultSet.getString("MaCTKM");
                    String tenCTKM = resultSet.getString("TenCTKM");
                    int mucGiamGia = resultSet.getInt("MucGiamGia");
                    String loaiKhuyenMai = resultSet.getString("LoaiSanPhamDuocApDung");
                    Date ngayBatDau = resultSet.getDate("ThoiGianBatDau");
                    Date ngayKetThuc = resultSet.getDate("ThoiGianKetThuc");
                    String thoiGianTao = resultSet.getString("ThoiGianTaoKM");

                    model.addRow(new Object[]{maCTKM, tenCTKM, mucGiamGia, loaiKhuyenMai, ngayBatDau, ngayKetThuc, thoiGianTao});
                }

                resultSet.close();
                preparedStatement.close();
            } else {
                System.out.println("Không thể kết nối đến cơ sở dữ liệu.");
            }
        } catch (SQLException e) {
            System.out.println("Lỗi truy vấn cơ sở dữ liệu: " + e);
        }
    }


    public String initIDKM(){
        int tmp = 1;
        String id = null;
        ResultSet rs = null;
        String query=null;
        
        try {
            while(true){
                if(tmp < 10){
                    query="select count(*) as 'quantity' from ChuongTrinhKhuyenMai where MaCTKM='KM00"+tmp+"';";
                }else if(tmp >= 10 && tmp < 100){
                    query="select count(*) as 'quantity' from ChuongTrinhKhuyenMai where MaCTKM='KM0"+tmp+"';";
                }else{
                    query="select count(*) as 'quantity' from ChuongTrinhKhuyenMai where MaCTKM='KM"+tmp+"';";
                }
                rs = this.sqlConn.getSta().executeQuery(query);
                rs.next();
                if(rs.getInt(1)!= 0){
                    tmp+=1;
                }
                else{
                    if(tmp < 10){
                        id="KM00"+tmp;
                    }else if(tmp >= 10 && tmp < 100){
                        id="KM0"+tmp;
                    }else{
                        id="KM"+tmp;
                    }
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Loi tao id khuyen mai: "+e);
        }
        return id;
    }



    public boolean themKhuyenMai(khuyenMaiDTO khuyenMai) {
        try {
            if (khuyenMai.getNgayBatDau().after(khuyenMai.getNgayKetThuc()) || khuyenMai.getNgayBatDau().equals(khuyenMai.getNgayKetThuc())) {
                JOptionPane.showMessageDialog(null, "Ngày bắt đầu và kết thúc không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return false; // Ngày bắt đầu mới không hợp lệ
            } else if (maKhuyenMaiDaTonTai(khuyenMai.getMaKhuyenMai())) {
                JOptionPane.showMessageDialog(null, "Mã khuyến mãi đã tồn tại", "Lỗi mã đã tồn tại", JOptionPane.ERROR_MESSAGE);
             return false; // Mã khuyến mãi đã tồn tại trong cơ sở dữ liệu.
            } else if (loaiSanPhamDaApDung(khuyenMai.getLoaiKhuyenMai(), khuyenMai.getNgayBatDau())) {
                JOptionPane.showMessageDialog(null, "Hãng này đang có chương trình khuyến mãi khác", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return false; // Loại sản phẩm đã được áp dụng cho chương trình khuyến mãi khác.
            }

                String query = "INSERT INTO ChuongTrinhKhuyenMai (MaCTKM, TenCTKM, MucGiamGia, LoaiSanPhamDuocApDung, ThoiGianBatDau, ThoiGianKetThuc, ThoiGianTaoKM, MaSP) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                Connection connection = sqlConn.getConnection();

                if (connection != null) {
                    PreparedStatement preparedStatement = connection.prepareStatement(query);
                    preparedStatement.setString(1, khuyenMai.getMaKhuyenMai());
                    preparedStatement.setString(2, khuyenMai.getTenKhuyenMai());
                    preparedStatement.setInt(3, khuyenMai.getMucGiamGia());
                    preparedStatement.setString(4, khuyenMai.getLoaiKhuyenMai());
                    preparedStatement.setDate(5, new java.sql.Date(khuyenMai.getNgayBatDau().getTime()));
                    preparedStatement.setDate(6, new java.sql.Date(khuyenMai.getNgayKetThuc().getTime()));
                    preparedStatement.setDate(7, new java.sql.Date(System.currentTimeMillis()));
                    preparedStatement.setString(8, null);
                    int rowsInserted = preparedStatement.executeUpdate();

                    preparedStatement.close();
                    return rowsInserted > 0;
                } else {
                    return false; // Không thể kết nối đến cơ sở dữ liệu.
                }
            
        } catch (SQLException e) {
            return false; // Lỗi truy vấn cơ sở dữ liệu.
        }
    }
    

    public boolean maKhuyenMaiDaTonTai(String maKhuyenMai) {
        try {
            String query = "SELECT MaCTKM FROM ChuongTrinhKhuyenMai WHERE MaCTKM = ?";
            Connection connection = sqlConn.getConnection();

            if (connection != null) {
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, maKhuyenMai);
                ResultSet resultSet = preparedStatement.executeQuery();

                boolean tonTai = resultSet.next();

                resultSet.close();
                preparedStatement.close();

                return tonTai;
            } else {
                return false; // Không thể kết nối đến cơ sở dữ liệu.
            }
        } catch (SQLException e) {
            return false; // Lỗi truy vấn cơ sở dữ liệu.
        }
    }
    private boolean loaiSanPhamDaApDung(String loaiSanPham, java.util.Date ngayBatDauMoi) {
        try {
            String query = "SELECT ThoiGianKetThuc FROM ChuongTrinhKhuyenMai WHERE LoaiSanPhamDuocApDung = ?";
            Connection connection = sqlConn.getConnection();

            if (connection != null) {
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, loaiSanPham);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    java.sql.Date thoiGianKetThuc = resultSet.getDate("ThoiGianKetThuc");

                    // Kiểm tra xem ngày bắt đầu mới có sau ngày kết thúc của bất kỳ chương trình khuyến mãi nào hay không
                    if (ngayBatDauMoi.before(thoiGianKetThuc) || ngayBatDauMoi.equals(thoiGianKetThuc)) {
                        resultSet.close();
                        preparedStatement.close();
                        return true; // Loại sản phẩm vẫn còn hạn
                    }
                }

                resultSet.close();
                preparedStatement.close();
                return false; // Không tìm thấy chương trình khuyến mãi đang áp dụng loại sản phẩm này hoặc đã hết hạn
            } else {
                return false; // Không thể kết nối đến cơ sở dữ liệu.
            }
        } catch (SQLException e) {
            return false; // Lỗi truy vấn cơ sở dữ liệu.
        }
    }



    public boolean xoaKhuyenMai(String maKhuyenMai) {
        try {
            String query = "DELETE FROM ChuongTrinhKhuyenMai WHERE MaCTKM = ?";
            Connection connection = sqlConn.getConnection();

            if (connection != null) {
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, maKhuyenMai);

                int rowsDeleted = preparedStatement.executeUpdate();

                preparedStatement.close();
                return rowsDeleted > 0;
            } else {
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
    }
    
    public void loadValidData(JTable jTable1) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Xóa hết dữ liệu trong jTable1

        try {
            String query = "SELECT MaCTKM, TenCTKM, MucGiamGia, LoaiSanPhamDuocApDung, ThoiGianBatDau, ThoiGianKetThuc, ThoiGianTaoKM FROM ChuongTrinhKhuyenMai WHERE ThoiGianKetThuc >= ?";
            Connection connection = sqlConn.getConnection();

            if (connection != null) {
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setDate(1, new java.sql.Date(System.currentTimeMillis())); // Lấy ngày hiện tại

                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    String maCTKM = resultSet.getString("MaCTKM");
                    String tenCTKM = resultSet.getString("TenCTKM");
                    int mucGiamGia = resultSet.getInt("MucGiamGia");
                    String loaiKhuyenMai = resultSet.getString("LoaiSanPhamDuocApDung");
                    Date ngayBatDau = resultSet.getDate("ThoiGianBatDau");
                    Date ngayKetThuc = resultSet.getDate("ThoiGianKetThuc");
                    String ThoiGianTao = resultSet.getString("ThoiGianTaoKM");

                    // Thêm dữ liệu vào model của jTable1
                    model.addRow(new Object[]{maCTKM, tenCTKM, mucGiamGia, loaiKhuyenMai, ngayBatDau, ngayKetThuc, ThoiGianTao});
                }

                resultSet.close();
                preparedStatement.close();
            } else {
                System.out.println("Không thể kết nối đến cơ sở dữ liệu.");
            }
        } catch (SQLException e) {
            System.out.println("Lỗi truy vấn cơ sở dữ liệu: " + e);
        }
    }

    public void loadExpiredData(JTable jTable1) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Xóa hết dữ liệu trong jTable1

        try {
            String query = "SELECT MaCTKM, TenCTKM, MucGiamGia, LoaiSanPhamDuocApDung, ThoiGianBatDau, ThoiGianKetThuc, ThoiGianTaoKM FROM ChuongTrinhKhuyenMai WHERE ThoiGianKetThuc < ?";
            Connection connection = sqlConn.getConnection();

            if (connection != null) {
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setDate(1, new java.sql.Date(System.currentTimeMillis())); // Lấy ngày hiện tại

                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    String maCTKM = resultSet.getString("MaCTKM");
                    String tenCTKM = resultSet.getString("TenCTKM");
                    int mucGiamGia = resultSet.getInt("MucGiamGia");
                    String loaiKhuyenMai = resultSet.getString("LoaiSanPhamDuocApDung");
                    Date ngayBatDau = resultSet.getDate("ThoiGianBatDau");
                    Date ngayKetThuc = resultSet.getDate("ThoiGianKetThuc");
                    String ThoiGianTao = resultSet.getString("ThoiGianTaoKM");

                    // Thêm dữ liệu vào model của jTable1
                    model.addRow(new Object[]{maCTKM, tenCTKM, mucGiamGia, loaiKhuyenMai, ngayBatDau, ngayKetThuc, ThoiGianTao});
                }

                resultSet.close();
                preparedStatement.close();
            } else {
                System.out.println("Không thể kết nối đến cơ sở dữ liệu.");
            }
        } catch (SQLException e) {
            System.out.println("Lỗi truy vấn cơ sở dữ liệu: " + e);
        }
    }
   
}
