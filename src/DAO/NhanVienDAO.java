/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.NhanVienDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author HAO KIET
 */
public class NhanVienDAO {
        private sqlConnect SQLCon = new sqlConnect();
    private Connection conn = SQLCon.getConnection();
    
    public ArrayList<NhanVienDTO> getListNhanVien() {
        ArrayList<NhanVienDTO> list = new ArrayList<NhanVienDTO>();
        String sql = "SELECT * FROM NhanVien";
        try {
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVienDTO nv = new NhanVienDTO();
                String maNV = rs.getString("MaNV");
                if (!maNV.startsWith("NV")) {
                    continue; // Chuyển sang bản ghi tiếp theo nếu MaNCC không bắt đầu bằng "NV"
                }
                nv.setMaNV(rs.getString("MaNV"));
                nv.setTenNV(rs.getString("TenNV"));
                nv.setGioiTinh(rs.getString("GioiTinh"));
                nv.setDiaChi(rs.getString("DiaChiNV"));
                nv.setSDT(rs.getString("SDTNV"));
                nv.setMaTK(rs.getString("MaTK"));
                
                list.add(nv);
            }
        } catch (Exception e) {
            System.out.println(e);
        
        }
        return list;
    } 
    public boolean hasNhanVienID(String id){
        boolean result=false;
        
            try {
                String sql = "Select * from NhanVien where MaNV="+id;
                Statement stmt = conn.createStatement();
                ResultSet rs= stmt.executeQuery(sql);
                result = rs.next();
            } catch (Exception e) {
                System.out.println(e);
            }
        
        return result;
    }
//    public boolean hasUser(String tentk){
//        boolean result=false;
//        
//            try {
//                String sql = "Select * from NhanVien where MaNV="+id;
//                Statement stmt = conn.createStatement();
//                ResultSet rs= stmt.executeQuery(sql);
//                result = rs.next();
//            } catch (Exception e) {
//                System.out.println(e);
//            }
//        
//        return result;
//    }
    public boolean addNV(NhanVienDTO emp){
        boolean result= false;
        
            try {
                String sql = "Insert into NhanVien values(?,?,?,?,?,?)";
                
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, emp.getMaNV());
                stmt.setString(2, emp.getTenNV());
                stmt.setString(3, emp.getGioiTinh());
                stmt.setString(4, emp.getDiaChi());
                stmt.setString(5, emp.getSDT());
                stmt.setString(6, emp.getMaTK());

                if(stmt.executeUpdate()>=1)
                    result=true;
            } catch (Exception e) {
                System.out.println(e);
            }
        
        return result;
    }
    public boolean delNV(String id,String idtk){
        boolean result = false;
        
            try {
                String sql = "Delete from NhanVien where MaNV=?";
                String sql1 = "Delete from Quyen where MaTK=?";
                String sql2 = "Delete from TaiKhoan where MaTK=?";
                PreparedStatement stmt = conn.prepareCall(sql);
                stmt.setString(1, id);
                PreparedStatement stmt1 = conn.prepareCall(sql1);
                stmt.setString(1, idtk);
                PreparedStatement stmt2 = conn.prepareCall(sql2);
                stmt.setString(1, idtk);
                
                if(stmt.executeUpdate()>=1 && stmt1.executeUpdate()>=1 && stmt2.executeUpdate()>=1)
                    result = true;
                } catch (Exception e) {
            }
       
        return result;
    }
    public boolean UpNV(String id,String name,String gioiTinh, String diachi, String sdt,String MaTK){
        boolean result =false;
        
            try {
                String sql = "Update NhanVien set TenNV=?, GioiTinh=?, DiaChiNV=?, SDTNV=?, MaTK=?  where MaNV=?";
                PreparedStatement stmt = conn.prepareCall(sql);
                stmt.setString(1, name);
                stmt.setString(2, gioiTinh);
                stmt.setString(3, diachi);
                stmt.setString(4, sdt);
                stmt.setString(5, MaTK);
                stmt.setString(6, id);
                
                if(stmt.executeUpdate()>=1)
                    result=true;
                
            } catch (Exception e) {
            }
        
        return result;
    }
     
}
