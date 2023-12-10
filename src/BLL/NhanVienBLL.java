/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAO.NhanVienDAO;
import DTO.NhanVienDTO;
import java.util.ArrayList;

/**
 *
 * @author HAO KIET
 */
public class NhanVienBLL {
    NhanVienDAO nvDAO =new NhanVienDAO();
    
    public ArrayList<NhanVienDTO> getListNhanVien(){
        return nvDAO.getListNhanVien();
    }
    
    public String addNV(NhanVienDTO d){
        if(nvDAO.hasNhanVienID(d.getMaNV()))
            return "Mã đã tồn tại";
        if(nvDAO.addNV(d))
            return "Thêm thành công";
        return "Thêm thất bại";
    }
    
    public String delNV(String id,String idtk){
        if(nvDAO.delNV(id,idtk))
            return "Xoá thành công";
        else 
            return "Xóa thất bại";
    }
    
    public String UpNV(String id,String name,String gioiTinh,String diachi,String sdt,String idtk){
       if(nvDAO.UpNV(id, name, gioiTinh, diachi, sdt,idtk))
            return "Cap nhat thanh cong";
        return "Cap nhat that bai";
    }
    
}
