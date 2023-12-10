/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAO.KhachHangDAO;
import DTO.KhachHangDTO;
import java.util.ArrayList;

/**
 *
 * @author toica
 */
public class KhachHangBLL {
    KhachHangDAO khDAO = new KhachHangDAO();
    public KhachHangBLL(){
        
    }
    public ArrayList<KhachHangDTO> getListKhachHang(){
        return khDAO.getListall();
    }
    public String AddKH(KhachHangDTO k){
        if(khDAO.addKh(k))
            return "Them thanh cong";
        return "Them that bai";
    }
     public String UpTK(  KhachHangDTO t){
       if(khDAO.UpKH(t))
            return "Cap nhat thanh cong";
        return "Cap nhat that bai";
    }
    public ArrayList<KhachHangDTO> timKiemKH(String username) {
        return khDAO.SearchKH(username);
    }
}
