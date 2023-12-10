/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.SanPhamNCCDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Dao Khanh
 */
public class SanPhamNCCDAO {
    private sqlConnect SQLCon = new sqlConnect();
    private Connection conn = SQLCon.getConnection();
    
   
    
    public ArrayList<SanPhamNCCDTO> getListSPNCC()
    {
        ArrayList<SanPhamNCCDTO> list = new ArrayList<SanPhamNCCDTO>();
        String sql = "SELECT * FROM SanPhamNCC";
        try {
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPhamNCCDTO spncc = new SanPhamNCCDTO();
                String maNCC = rs.getString("MaNCC");
                if (!maNCC.startsWith("NCC")) {
                    continue;
                }
                spncc.setMaNCC(rs.getString("MaNCC"));
                spncc.setMaSP(rs.getString("MaSP"));
//                ncc.setLoaiHang(rs.getString("loaiHang"));      
                list.add(spncc);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
    public boolean addSPNCC(SanPhamNCCDTO emp){
        boolean result= false;
        
            try {
                String sql = "Insert into SanPhamNCC values(?,?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, emp.getMaNCC());
                stmt.setString(2, emp.getMaSP());
//                stmt.setString(4, emp.getLoaiHang());
                if(stmt.executeUpdate()>=1)
                    result=true;
            } catch (Exception e) {
                System.out.println(e);
            }
        
        return result;
    }
    
    public boolean hasSanPhamNCC(String id){
        boolean result = false;
        
            try {
                String sql = "Select * from SanPhamNCC where MaNCC=" +id;
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                result = rs.next();
            } catch (Exception e) {
                System.out.println(e);
            }
        
        return result;
    }
    
    public ArrayList<SanPhamNCCDTO> getListByNccId(String id){
        ArrayList<SanPhamNCCDTO> lst = new ArrayList<>();
        String query = "Select * from SanPhamNCC where MaNCC = '" +id+"';";
        ResultSet rs=null;
        try {
            rs = this.SQLCon.getSta().executeQuery(query);
            while(rs.next()){
                lst.add(new SanPhamNCCDTO(rs.getString(1), rs.getString(2)));
            }
        } catch (Exception e) {
            System.out.println("loi lay san pham ncc: "+e);
        }
        return lst;
    }
}
