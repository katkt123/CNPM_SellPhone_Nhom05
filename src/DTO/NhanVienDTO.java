/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author HAO KIET
 */
public class NhanVienDTO {
    public String MaNV;
    public String TenNV;
    public String SDT;
    public String GioiTinh;
    public String DiaChi;
    public String MaTK;
    
    
    public NhanVienDTO(){
        this.MaNV=null;
        this.TenNV=null;
        this.DiaChi=null;
        this.SDT=null;
        this.GioiTinh=null;
        this.MaTK=null;
    }
    public NhanVienDTO(String MaNV,String TenNV,String SDT,String GioiTinh,String DiaChi,String MaTK){
        this.MaNV=MaNV;
        this.TenNV=TenNV;
        this.DiaChi=DiaChi;
        this.SDT=SDT;
        this.GioiTinh=GioiTinh;
        this.MaTK=MaTK;
    }

    public String getMaTK() {
        return MaTK;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public String getMaNV() {
        return MaNV;
    }

    public String getSDT() {
        return SDT;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public void setMaTK(String MaTK) {
        this.MaTK = MaTK;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    @Override
    public String toString() {
        return this.MaNV+this.TenNV+this.GioiTinh+this.DiaChi+this.SDT;
    }
}    