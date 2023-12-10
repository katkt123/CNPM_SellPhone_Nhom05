/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author toica
 */
public class TaiKhoanDTO {
    private String MaTK;
    private String TenDangNhap;
    private String MatKhau; 
    private int TrangThai;
    public TaiKhoanDTO(String MaTK, String TenDangNhap, String MatKhau, int TrangThai){
        this.MaTK = MaTK;
        this.TenDangNhap = TenDangNhap;
        this.MatKhau = MatKhau;
        this.TrangThai = TrangThai;
    }

    public TaiKhoanDTO() {
        MaTK = null;
        TenDangNhap = null;
        MatKhau = null;
        TrangThai = 0;       
    }

    public String getMaTK() {
        return MaTK;
    }

    public String getTenDangNhap() {
        return TenDangNhap;
    }

    public String getMatKhau() {
        return MatKhau;
    }


    public int getTrangThai() {
        return TrangThai;
    }

    public void setMaTK(String MaTK) {
        this.MaTK = MaTK;
    }

    public void setTenDangNhap(String TenDangNhap) {
        this.TenDangNhap = TenDangNhap;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }
    
}
