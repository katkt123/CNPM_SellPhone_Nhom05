/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAO.PhanQuyenDAO;
import DTO.PhanQuyenDTO;
import java.util.ArrayList;

/**
 *
 * @author toica
 */
public class PhanQuyenBLL {
    PhanQuyenDAO daoPQ = new PhanQuyenDAO();
    
        
    public String AddPQ(PhanQuyenDTO p){       
       if(daoPQ.addPhanQuyen(p))
           return "Thêm thành công";
       return "Thêm thất bại";
    }
    public ArrayList<PhanQuyenDTO> getListPhanQuyen(){
       return daoPQ.getListall();
    }
    public String UpPQ(  PhanQuyenDTO p){
       if(daoPQ.updatePhanQuyen(p))
            return "Cap nhat thanh cong";
        return "Cap nhat that bai";
    }
}
