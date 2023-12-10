/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAO.NhaCungCapDAO;
import DTO.NhaCungCapDTO;
import java.util.ArrayList;

/**
 *
 * @author Dao Khanh
 */
public class NhaCungCapBLL {
    NhaCungCapDAO nccDAO =new NhaCungCapDAO();
    
    public ArrayList<NhaCungCapDTO> getListNhaCungCap(){
        return nccDAO.getListNCC();
    }
    
    public String addNCC(NhaCungCapDTO d){
        if(nccDAO.hasNhaCungCapID(d.getMaNCC()))
            return "Mã đã tồn tại";
        if(nccDAO.addNCC(d))
            return "Thêm thành công";
        return "Thêm thất bại";
    }
    
    public String delNCC(String id){
        if(nccDAO.delNCC(id))
            return "Xoá thành công";
        else 
            return "Xóa thất bại";
    }
    
    public String UpNCC(NhaCungCapDTO n )
    {
       if(nccDAO.UpNCC(n))
            return "Cap nhat thanh cong";
        return "Cap nhat that bai";
    }
    
    public ArrayList<NhaCungCapDTO> getListAll(){
        return this.nccDAO.getListNCC();
    }
    public NhaCungCapDTO getNccById(String id){
        return nccDAO.getNccById(id);
    }
}
