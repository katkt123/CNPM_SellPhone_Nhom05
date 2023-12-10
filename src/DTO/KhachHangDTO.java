/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author toica
 */
public class KhachHangDTO {
    private String MaKH;
    private String TenKH;
    private String DiaChi;
    private String SDT;
    private String MaTK;
    

    public KhachHangDTO(String MaKH, String TenKH, String DiaChi, String SDT,String MaTK){
        this.MaKH = MaKH;
        this.TenKH = TenKH;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
        this.MaTK = MaTK;
    }
    public KhachHangDTO(){
        
    }
    public String getMaKH() {
        return MaKH;
    }

    public String getTenKH() {
        return TenKH;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setMaTK(String MaTK) {
        this.MaTK = MaTK;
    }

    public String getMaTK() {
        return MaTK;
    }

    public String getSDT() {
        return SDT;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }
    
}
