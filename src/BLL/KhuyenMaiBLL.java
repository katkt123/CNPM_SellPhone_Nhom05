/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import DAO.khuyenMaiDAO;
import DTO.khuyenMaiDTO;
import javax.swing.JOptionPane;
import java.util.Date;
/**
 *
 * @author loc01
 */

public class KhuyenMaiBLL {
    private khuyenMaiDAO kmDAO;
    
    public KhuyenMaiBLL() {
        kmDAO = new khuyenMaiDAO(); // Khởi tạo đối tượng DAO ở đây
    }
    
    public void loadKhuyenMaiData(JTable jTable1) {
        kmDAO.loadKhuyenMaiData(jTable1);
        }
    

    public void searchKhuyenMai(JTable jTable1, String keyword, Date from, Date to) {
        kmDAO.searchKhuyenMai(jTable1, keyword, from, to);
    }
   
    public boolean themKhuyenMai(khuyenMaiDTO khuyenMai) {
        boolean result = kmDAO.themKhuyenMai(khuyenMai);
//        if (!result) {
//            JOptionPane.showMessageDialog(null, "Lỗi khi thêm khuyến mãi", "Lỗi", JOptionPane.ERROR_MESSAGE);
//        }
        return result;
    }
    
    public boolean xoaKhuyenMai(String maKhuyenMai) {
        boolean result = kmDAO.xoaKhuyenMai(maKhuyenMai);
        if (!result) {
            // Xử lý lỗi ở đây, ví dụ: hiển thị thông báo lỗi.
            System.out.println("Lỗi khi xóa khuyến mãi");
        }
        return result;
    }
    
    public void loadValidData(JTable jTable1) {
        kmDAO.loadValidData(jTable1);
    }
    
    public void loadExpiredData(JTable jTable1) {
        kmDAO.loadExpiredData(jTable1);
    }
}
