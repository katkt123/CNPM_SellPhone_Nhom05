/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAO.SanPhamDAO;
import DTO.CTHoaDonDTO;
import DTO.HoaDonDTO;
import DTO.SanPhamDTO;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class SanPhamBLL {
    SanPhamDAO spDAO =new SanPhamDAO();
    
    public ArrayList<SanPhamDTO> getListSanPham(){
        return spDAO.getListSanpham();
    }
    
    public ArrayList<SanPhamDTO> getListSanphamWithDiscount(){
        return spDAO.getListSanphamWithDiscount();
    }
    
    public String addSP(SanPhamDTO d){
        if(spDAO.hasSanPhamID(d.getMaSP()))
            return "Mã đã tồn tại";
        if(spDAO.addSP(d))
            return "Thêm thành công";
        return "Thêm thất bại";
    }
    
    public String delSP(String id){
        if(spDAO.DelSP(id))
            return "Xoá thành công";
        else 
            return "Xóa thất bại";
    }
    
    public String UpSP(String MaSP, String TenSP, String Hang, String DungLuong, int DonGia, String HinhAnh) {
        if (spDAO.UpdateDS(MaSP, TenSP, Hang, DungLuong, DonGia, HinhAnh)) {
            return "Cập nhật thành công";
        } else {
            return "Cập nhật thất bại";
        }
    }
    public SanPhamDTO getSanPham(String id){
        return this.spDAO.getSanPham(id);
    }
    
    
    public void updateSLsp(SanPhamDTO sp, int sl){
        this.spDAO.UpdateDS(sp.getMaSP(), sp.getTenSP(), sp.getHang(), sp.getDungLuong(), sp.getDonGia(), sp.getHinhAnh());
    }
    
    public void updateSoLuong(SanPhamDTO sp, int sl){
        this.spDAO.nhapHang(sp.getMaSP(), sp.getTenSP(), sp.getHang(), sp.getDungLuong(), sl, sp.getDonGia(), sp.getHinhAnh());
    }
}
