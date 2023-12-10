/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.KhachHangDTO;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement; 
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author toica
 */
public class KhachHangDAO {
    private sqlConnect sqlConn;
    public KhachHangDAO(){
        this.sqlConn = new sqlConnect();
    }
    public ArrayList<KhachHangDTO> getListall(){
        ArrayList<KhachHangDTO> resultList = new ArrayList<>();
        ResultSet rs = null;
        String query="select * from KhachHang";
        try {
            rs = this.sqlConn.getSta().executeQuery(query);
            while(rs.next()){
                resultList.add(new KhachHangDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
        } catch (Exception e) {
            System.out.println("Loi lay danh sach tai khoan(r:24,DAO): "+e);
        }
        return resultList;
    }
    public boolean addKh(KhachHangDTO kh){
       try{
            String query = "INSERT INTO KhachHang (MaKH, TenKH, DiaChi, SDT,MaTK) VALUES (?, ?, ?, ?,?)";
            Connection connection = sqlConn.getConnection();

            if(connection != null){                               
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setString(1,kh.getMaKH());
                ps.setString(2,kh.getTenKH());
                ps.setString(3,kh.getDiaChi());
                ps.setString(4,kh.getSDT());     
                ps.setString(5,kh.getMaTK());
                int rowInserted = ps.executeUpdate();
                ps.close();
                connection.commit();  
                return rowInserted> 0;
            }else{
                System.out.println("Không thể kết nối cơ sở dữ liệu");
                return false;                
            }
       }catch(SQLException e){
           System.out.println("Lỗi truy vấn cơ sở dữ liệu" + e);
           return false;
       }              
     }
    public boolean UpKH(KhachHangDTO t){
        boolean result =false;
        Connection connection = sqlConn.getConnection();
        if(connection != null){
            try {
                String sql = "Update KhachHang set TenKH=?, DiaChi=?, SDT=? where MaKH=?";
                PreparedStatement stmt = connection.prepareCall(sql);                
                stmt.setString(1, t.getTenKH());
                stmt.setString(2, t.getDiaChi());
                stmt.setString(3, t.getSDT());
                stmt.setString(4, t.getMaKH());
                if(stmt.executeUpdate()>=1)
                    result=true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    public ArrayList<KhachHangDTO> SearchKH(String username){
        ArrayList<KhachHangDTO> arr = new ArrayList<>();
        Connection connection = sqlConn.getConnection();
        if(connection != null){
            try {                
                String sql = "SELECT * FROM KhachHang WHERE MaKH LIKE '"+ username + "'";
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(sql);                
                while (rs.next()) {
                    KhachHangDTO kh = new KhachHangDTO();
                    kh.setMaKH(rs.getString(1));
                    kh.setTenKH(rs.getString(2));
                    kh.setDiaChi(rs.getString(3));
                    kh.setSDT(rs.getString(4));
                    arr.add( kh);
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            } 
        }
        return arr;
    }
    
    public String initIDkh(){
        int tmp = 1;
        String id = null;
        ResultSet rs = null;
        String query=null;
        
        try {
            while(true){
                if(tmp < 10){
                    query="select count(*) as 'quantity' from KhachHang where MaKH='KH00"+tmp+"';";
                }else if(tmp >= 10 && tmp < 100){
                    query="select count(*) as 'quantity' from KhachHang where MaKH='KH0"+tmp+"';";
                }else{
                    query="select count(*) as 'quantity' from KhachHang where MaKH='KH"+tmp+"';";
                }
                rs = this.sqlConn.getSta().executeQuery(query);
                rs.next();
                if(rs.getInt(1)!= 0){
                    tmp+=1;
                }
                else{
                    if(tmp < 10){
                        id="KH00"+tmp;
                    }else if(tmp >= 10 && tmp < 100){
                        id="KH0"+tmp;
                    }else{
                        id="KH"+tmp;
                    }
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Loi tao id tai khoan: "+e);
        }
        return id;
    }
}
