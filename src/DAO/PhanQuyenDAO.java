/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.PhanQuyenDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Trung Hiếu
 */
public class PhanQuyenDAO {
    private sqlConnect sqlConn;
    public PhanQuyenDAO(){
        this.sqlConn = new sqlConnect();
    }
    public ArrayList<PhanQuyenDTO> getListall(){
        ArrayList<PhanQuyenDTO> resultList = new ArrayList<>();
        ResultSet rs = null;
        String query="select * from Quyen";
        try {
            rs = this.sqlConn.getSta().executeQuery(query);
            while(rs.next()){
                resultList.add(new PhanQuyenDTO(rs.getString(1), rs.getInt(2)));
            }
        } catch (Exception e) {
            System.out.println("Loi lay danh sach phan quyeb(line 30,DAO): "+e);
        }
        
        return resultList;
    }
    public boolean addPhanQuyen(PhanQuyenDTO pq) {
    try {
        String query = "INSERT INTO Quyen (MaTK, PhanQuyen) VALUES (?, ?)";
        Connection connection = sqlConn.getConnection();

        if (connection != null) {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, pq.getMaTK());
            ps.setInt(2, pq.getQuyen());

            int rowInserted = ps.executeUpdate();
            ps.close();

            return rowInserted > 0;
        } else {
            System.out.println("Không thể kết nối cơ sở dữ liệu");
            return false;
        }
    } catch (SQLException e) {
        System.out.println("Lỗi truy vấn cơ sở dữ liệu" + e);
        return false;
    }

    }
    public boolean delPhanQuyen(String id) {
        boolean result = false;
        Connection connection = sqlConn.getConnection();
        if (connection != null) {
            try {
                String deleteQuyenSQL = "DELETE FROM Quyen WHERE MaTK=?";
                PreparedStatement quyenStmt = connection.prepareStatement(deleteQuyenSQL);
                quyenStmt.setString(1, id);
                int quyenDeleted = quyenStmt.executeUpdate();

                if (quyenDeleted >= 1) {
                    result = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    public boolean updatePhanQuyen(PhanQuyenDTO p) {
    boolean result = false;
    Connection connection = sqlConn.getConnection();
    if (connection != null) {
        try {
            String updateQuyenSQL = "UPDATE Quyen SET PhanQuyen=? WHERE MaTK=?";
            PreparedStatement quyenStmt = connection.prepareCall(updateQuyenSQL);
            quyenStmt.setInt(1, p.getQuyen());
            quyenStmt.setString(2, p.getMaTK());

            int quyenUpdated = quyenStmt.executeUpdate();

            if (quyenUpdated >= 1) {
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    return result;
    }
    public PhanQuyenDTO getQuyen(String matk){
        PhanQuyenDTO phanQuyenDTO = null;

        try {
            String sql = "SELECT q.PhanQuyen " +
                         "FROM TaiKhoan tk " +
                         "INNER JOIN Quyen q ON tk.MaTK = q.MaTK " +
                         "WHERE tk.MaTK = ?";
            
            Connection con = sqlConn.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, matk);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int phanQuyen = rs.getInt("PhanQuyen");
                phanQuyenDTO = new PhanQuyenDTO(matk, phanQuyen);
            }

            rs.close();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            // Xử lý exception nếu cần thiết
            ex.printStackTrace();
        }

        return phanQuyenDTO;
    }
}
