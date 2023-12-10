/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Dao Khanh
 */
public class SanPhamNCCDTO {
    private String MaNCC;
    private String MaSP;
    
    public SanPhamNCCDTO(String MaNCC, String MaSP) {
        this.MaNCC = MaNCC;
        this.MaSP = MaSP;
    }

    public SanPhamNCCDTO(){
        MaNCC=null;
        MaSP=null; 
    }
    public String getMaNCC() {
        return MaNCC;
    }

    public void setMaNCC(String MaNCC) {
        this.MaNCC = MaNCC;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }   
}
