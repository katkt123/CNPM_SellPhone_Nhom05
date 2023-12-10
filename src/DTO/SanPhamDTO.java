/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author PC
 */
public class SanPhamDTO {
    private float MucGiamGia,GiaSauGiam;
    private int SoLuong,DonGia;
    private String MaSP, Hang, TenSP, HinhAnh, DungLuong,stt;

    public SanPhamDTO(int SoLuong, int DonGia, String MaSP, String Hang, String TenSP, String HinhAnh, String DungLuong,String stt, float MucGiamGia, long GiaSauGiam) {
        this.SoLuong = SoLuong;
        this.DonGia = DonGia;
        this.MaSP = MaSP;   
        this.Hang = Hang;
        this.TenSP = TenSP;
        this.HinhAnh = HinhAnh;
        this.DungLuong = DungLuong;
        this.MucGiamGia= MucGiamGia;
        this.GiaSauGiam= GiaSauGiam;
    }

    public SanPhamDTO() {
    }

    public int getDonGia() {
        return DonGia;
    }

    public String getDungLuong() {
        return DungLuong;
    }

    public String getHang() {
        return Hang;
    }

    public String getHinhAnh() {
        return HinhAnh;
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

    public void setDonGia(int DonGia) {
        this.DonGia = DonGia;
    }

    public void setDungLuong(String DungLuong) {
        this.DungLuong = DungLuong;
    }

    public void setHang(String Hang) {
        this.Hang = Hang;
    }

    public void setHinhAnh(String HinhAnh) {
        this.HinhAnh = HinhAnh;
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

    public String getStt() {
        return stt;
    }

    public void setStt(String stt) {
        this.stt = stt;
    }

    public float getGiaSauGiam() {
        return GiaSauGiam;
    }

    public float getMucGiamGia() {
        return MucGiamGia;
    }

    public void setGiaSauGiam(float GiaSauGiam) {
        this.GiaSauGiam = GiaSauGiam;
    }

    public void setMucGiamGia(float MucGiamGia) {
        this.MucGiamGia = MucGiamGia;
    }
    
    public int getDonGiaNhap() {
        return DonGia * 100 / 110 ;
    }
}
