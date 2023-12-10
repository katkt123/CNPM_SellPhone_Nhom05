/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.CTHoaDonDTO;
import DTO.HoaDonDTO;
import DTO.NhanVienDTO;
import DTO.PhanQuyenDTO;
import DTO.TaiKhoanDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;
/**
 *
 * @author HAO KIET
 */
public class HoaDonDAO {
    private sqlConnect SQLCon = new sqlConnect();
    private Connection conn = SQLCon.getConnection();
    
    
    public ArrayList<HoaDonDTO> getListHoaDon() {
        ArrayList<HoaDonDTO> list = new ArrayList<HoaDonDTO>();
        String sql = "SELECT * FROM HoaDon";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonDTO nv = new HoaDonDTO();
                String maHD = rs.getString("MaHoaDon");
                if (!maHD.startsWith("HD")) {
                    continue; // Chuyển sang bản ghi tiếp theo nếu MaNCC không bắt đầu bằng "NCC"
                }
                nv.setMaHD(maHD);
                nv.setMaKH(rs.getString("MaKH"));
                nv.setMaNV(rs.getString("MaNV"));
                nv.setNgayLap(rs.getString("NgayLap"));
                nv.setNgayGiao(rs.getString("NgayXuat"));
                nv.setTongTienGoc(rs.getInt("TongGiaGoc"));
                nv.setTongTienSauGiam(rs.getInt("TongGiaSauGiam"));
                
                list.add(nv);
            }
        } catch (Exception e) {
            System.out.println(e);
        
        }
        return list;
    } 
    public boolean AddNgayGiao(String id, String NgayGiao) {
        boolean result = false;
        
            try {
                String sql = "UPDATE HoaDon SET NgayXuat = ? WHERE MaHoaDon = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, NgayGiao);
                ps.setString(2, id);

                if (ps.executeUpdate() >= 1) {
                    result = true;
                }
            } catch (Exception e) {
                System.out.println(e);
            } 
//            finally {
//                closeConnection();
//            }
        
        return result;
    }
    public String getMaNV(String idtk){
        String sql = "Select * from NhanVien where MaTK = ?";
        NhanVienDTO nv = new NhanVienDTO();
        try {
            
            PreparedStatement selectStatement = conn.prepareStatement(sql);
            selectStatement.setString(1, idtk);

            ResultSet rs = selectStatement.executeQuery();
            
            while(rs.next()){
                nv.setMaNV(rs.getString("MaNV"));
                nv.setTenNV(rs.getString("TenNV"));
                nv.setGioiTinh(rs.getString("GioiTinh"));
                nv.setDiaChi(rs.getString("DiaChiNV"));
                nv.setSDT(rs.getString("SDTNV"));
                nv.setMaTK(rs.getString("MaTK"));
            }

        } catch (Exception e){
            System.out.println(e);
        }
        return nv.getMaNV();
    }
    public String getMaKH(String idtk){
        String sql = "Select * from KhachHang where MaTK = ?";
        NhanVienDTO nv = new NhanVienDTO();
        try {
            
            PreparedStatement selectStatement = conn.prepareStatement(sql);
            selectStatement.setString(1, idtk);

            ResultSet rs = selectStatement.executeQuery();
            
            while(rs.next()){
                nv.setMaNV(rs.getString("MaNV"));
                nv.setTenNV(rs.getString("TenNV"));
                nv.setGioiTinh(rs.getString("GioiTinh"));
                nv.setDiaChi(rs.getString("DiaChiNV"));
                nv.setSDT(rs.getString("SDTNV"));
                nv.setMaTK(rs.getString("MaTK"));
            }

        } catch (Exception e){
            System.out.println(e);
        }
        return nv.getMaNV();
    }
    public boolean AddMaNV(String id, String idnv) {
        boolean result = false;
        
            try {
                String sql = "UPDATE HoaDon SET MaNV = ? WHERE MaHoaDon = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, idnv);
                ps.setString(2, id);

                if (ps.executeUpdate() >= 1) {
                    result = true;
                }
            } catch (Exception e) {
                System.out.println(e);
            } 
//            finally {
//                closeConnection();
//            }
        
        return result;
    }
    public boolean DelSL(String id, int soluong) {
    boolean result = false;
   
        try {
            // Lấy số lượng hiện tại của sản phẩm với mã id
            String selectQuery = "SELECT SoLuong FROM SanPham WHERE MaSP = ?";
            PreparedStatement selectStatement = conn.prepareStatement(selectQuery);
            selectStatement.setString(1, id);
            ResultSet resultSet = selectStatement.executeQuery();

            int currentQuantity = 0;

            if (resultSet.next()) {
                currentQuantity = resultSet.getInt("SoLuong");
            }

            // Kiểm tra xem có đủ số lượng để trừ không
            if (currentQuantity >= soluong) {
                // Thực hiện phép trừ và cập nhật vào cơ sở dữ liệu
                int newQuantity = currentQuantity - soluong;
                String updateQuery = "UPDATE SanPham SET SoLuong = ? WHERE MaSP = ?";
                PreparedStatement updateStatement = conn.prepareStatement(updateQuery);
                updateStatement.setInt(1, newQuantity);
                updateStatement.setString(2, id);

                if (updateStatement.executeUpdate() >= 1) {
                    result = true;
                }
            } else {
                System.out.println("Số lượng không đủ để trừ.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    
    return result;
    }
    public boolean DelHD(String id){
        boolean result = false;
        
            try {
                String sql1 = "Delete from CTHoaDon where MaHoaDon=?";
                PreparedStatement pc1 = conn.prepareCall(sql1);
                pc1.setString(1, id);
                pc1.executeUpdate();
                
                String sql2 = "Delete from HoaDon where MaHoaDon=?";
                PreparedStatement pc2 = conn.prepareCall(sql2);
                pc2.setString(1, id);
                if(pc2.executeUpdate()>=1) {
                    result = true;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            
        
        return result;
    }
    public String idActive(){
        String sql = "Select * from TaiKhoan as tk JOIN Quyen as q on tk.MaTK = q.MaTK where TrangThai = 1 and PhanQuyen <> 3";
        TaiKhoanDTO tk = new TaiKhoanDTO();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                
                tk.setMaTK(rs.getString("MaTK"));
                tk.setTenDangNhap(rs.getString("TenDangNhap"));
                tk.setMatKhau(rs.getString("MatKhau"));
                tk.setTrangThai(rs.getInt("TrangThai"));
            
        }} catch (Exception e) {
                System.out.println(e);
       }
    
       return tk.getMaTK();
    }
    public boolean idUnactive(String id){
        boolean result = false;
        String sql = "Update TaiKhoan set TrangThai = 0 where MaTK = ?";
        try {
                PreparedStatement pc1 = conn.prepareCall(sql);
                pc1.setString(1, id);
                pc1.executeUpdate();
                if(pc1.executeUpdate()>=1) {
                    result = true;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        return result;
    }
    public String getIDactive(String user,String pass){
         String sql = "Select * from TaiKhoan where TenDangNhap = ? and MatKhau = ?";
         TaiKhoanDTO tk = new TaiKhoanDTO();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,user);
            ps.setString(2,pass);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                
                tk.setMaTK(rs.getString("MaTK"));
                tk.setTenDangNhap(rs.getString("TenDangNhap"));
                tk.setMatKhau(rs.getString("MatKhau"));
                tk.setTrangThai(rs.getInt("TrangThai"));
            
        }} catch (Exception e) {
                System.out.println(e);
       }
    
       return tk.getMaTK();
    }
    public boolean idUnactive1(String user,String pass){
        boolean result = false;
        String sql = "Update TaiKhoan set TrangThai = 0 where TenDangNhap = ? and MatKhau = ?";
        try {
                PreparedStatement pc1 = conn.prepareCall(sql);
                pc1.setString(1, user);
                pc1.setString(2, pass);
                pc1.executeUpdate();
                if(pc1.executeUpdate()>=1) {
                    result = true;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        return result;
    }
    public boolean idactive(String username,String pass){
        boolean result = false;
        String sql = "Update TaiKhoan set TrangThai = 1 where TenDangNhap = ? and MatKhau = ?";
        try {
                PreparedStatement pc1 = conn.prepareCall(sql);
                pc1.setString(1,username);
                pc1.setString(2,pass);
                pc1.executeUpdate();
                if(pc1.executeUpdate()>=1) {
                    result = true;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        return result;
    }
    
    public String getMaTK(){
        String MaKH="";
        String MaTK="";
        try {
            String sql = "Select tk.MaTK,kh.MaKH from Quyen as q  JOIN TaiKhoan as tk on q.MaTK=tk.MaTK " +
"						  JOIN KhachHang as kh on tk.MaTK = kh.MaTK " +
"						  where PhanQuyen = 3 and tk.TrangThai = 1";
            PreparedStatement selectStatement = conn.prepareStatement(sql);
            
            ResultSet rs = selectStatement.executeQuery();
            
            while (rs.next()){
                MaKH = rs.getString("MaKH");
                MaTK = rs.getString("MaTK");
            }
        } catch (Exception e) {
            System.out.println(e);
        
        }
        return MaKH;
        
    }

    public boolean addHoaDon(HoaDonDTO hoaDon, List<CTHoaDonDTO> dsCTHD) {
            PreparedStatement psHoaDon = null;
            PreparedStatement psCTHD = null;

            try {
                // Thêm hóa đơn
                String sqlHoaDon = "INSERT INTO HoaDon (MaHoaDon, MaKH, MaNV, NgayLap, NgayXuat, TongGiaGoc, TongGiaSauGiam) VALUES (?, ?, ?, ?, ?, ?, ?)";
                psHoaDon = conn.prepareStatement(sqlHoaDon);
                psHoaDon.setString(1, hoaDon.getMaHD());
                psHoaDon.setString(2, hoaDon.getMaKH());
                psHoaDon.setString(3, hoaDon.getMaNV());
                psHoaDon.setString(4, hoaDon.getNgayLap());
                psHoaDon.setString(5, hoaDon.getNgayGiao());
                psHoaDon.setFloat(6, hoaDon.getTongTienGoc());
                psHoaDon.setFloat(7, hoaDon.getTongTienSauGiam());
                psHoaDon.executeUpdate();

                // Thêm chi tiết hóa đơn
                String sqlCTHD = "INSERT INTO CTHoaDon (MaHoaDon, MaSP,TenSP, SoLuong, GiaTien) VALUES (?, ?, ?, ?,?)";
                psCTHD = conn.prepareStatement(sqlCTHD);
                for (CTHoaDonDTO cthd : dsCTHD) {
                    psCTHD.setString(1, cthd.getMaHD());
                    psCTHD.setString(2, cthd.getMaSP());
                    psCTHD.setString(3,cthd.getTenSP());
                    psCTHD.setInt(4, cthd.getSoLuong());
                    psCTHD.setFloat(5, cthd.getDonGia());
                    psCTHD.executeUpdate();
                }

                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            } finally {
                try {
                    if (psHoaDon != null) psHoaDon.close();
                    if (psCTHD != null) psCTHD.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    

    
    public boolean hasMaHoaDonID(String id){
        boolean result=false;
        
            try {
                String sql = "Select * from HoaDon where MaHoaDon="+id;
                Statement stmt = conn.createStatement();
                ResultSet rs= stmt.executeQuery(sql);
                result = rs.next();
            } catch (Exception e) {
                System.out.println(e);
            }
        
        return result;
    }
}
