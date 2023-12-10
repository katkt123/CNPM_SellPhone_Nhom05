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
public class CTHoaDonDTO {
    private String MaHD;
    private String MaSP;
    private String TenSP;
    private int SoLuong;
    private float DonGia;

    public CTHoaDonDTO() {
        MaHD = "";
        MaSP = "";
        TenSP = "";
        SoLuong = 0;
        DonGia = 0;
    }

    public CTHoaDonDTO(String MaHD, String MaSP, String TenSP, int SoLuong, int DonGia) {
        this.MaHD = MaHD;
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.SoLuong = SoLuong;
        this.DonGia = DonGia;
    }

    public float getDonGia() {
        return DonGia;
    }

    public String getMaHD() {
        return MaHD;
    }

    public String getMaSP() {
        return MaSP;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setDonGia(float DonGia) {
        this.DonGia = DonGia;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }
    
    
}
