/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAO.TaiKhoanDAO;
import DTO.PhanQuyenDTO;
import DTO.TaiKhoanDTO;
import java.util.ArrayList;

/**
 *
 * @author Trung Hiếu
 */
public class TaiKhoanBLL {
    TaiKhoanDAO tkDAO = new TaiKhoanDAO();
    
    public TaiKhoanBLL(){
        
    }
    public ArrayList<TaiKhoanDTO> getListTaiKhoan(){
        return tkDAO.getListall();
    }        
    public String AddTK(TaiKhoanDTO t){       
       if(tkDAO.addTk(t))
           return "Thêm thành công";
       return "Thêm thất bại";
    }
        public String delTK(String id){
        if(tkDAO.delTK(id))
            return "Xoá thành công";
        else 
            return "Xóa thất bại";
    }
    
    public String UpTK(  TaiKhoanDTO t){
       if(tkDAO.UpTK(t))
            return "Cap nhat thanh cong";
        return "Cap nhat that bai";
    }
     public ArrayList<TaiKhoanDTO> timKiemTK(String username) {
        return tkDAO.SearchTK(username);
    }
    
}
