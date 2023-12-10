/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAO.SanPhamNCCDAO;
import DTO.SanPhamNCCDTO;
import java.util.ArrayList;

/**
 *
 * @author Dao Khanh
 */
public class SanPhamNCCBLL {
    SanPhamNCCDAO spnccDAO = new SanPhamNCCDAO();
    
    public ArrayList<SanPhamNCCDTO> getListSanPhamNCC() {
        return spnccDAO.getListSPNCC();
    }
    
    public String addSPNCC(SanPhamNCCDTO s) {
        if(spnccDAO.addSPNCC(s))
            return "Thêm thành công";
        return "Thêm thất bại";
    }
    
    public ArrayList<SanPhamNCCDTO> getListByNccId(String id){
        return this.spnccDAO.getListByNccId(id);
    }
}
