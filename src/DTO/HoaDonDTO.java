/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HAO KIET
 */
public class HoaDonDTO {
    private String MaHD;
    private String MaKH;
    private String MaNV;
    private String NgayLap;
    private String NgayGiao;
    private float TongTienGoc;
    private float TongTienSauGiam;
    private List<CTHoaDonDTO> dsCTHD;
    
    public HoaDonDTO(){
        MaHD="";
        MaKH="";
        MaNV="";
        NgayLap="";
        NgayGiao="";
        TongTienGoc=0;
        TongTienSauGiam=0;
        dsCTHD = new ArrayList<>();
    }

    public HoaDonDTO(String MaHD, String MaKH, String MaNV, String NgayLap, String NgayGiao, int TongTienGoc,int TongTienSauGiam) {
        this.MaHD = MaHD;
        this.MaKH = MaKH;
        this.MaNV = MaNV;
        this.NgayLap = NgayLap;
        this.NgayGiao = NgayGiao;
        this.TongTienGoc = TongTienGoc;
        this.TongTienSauGiam = TongTienSauGiam;

    }

    public float getTongTienSauGiam() {
        return TongTienSauGiam;
    }

    public void setTongTienSauGiam(int TongTienSauGiam) {
        this.TongTienSauGiam = TongTienSauGiam;
    }

    public void setTongTienGoc(int TongTienGoc) {
        this.TongTienGoc = TongTienGoc;
    }

    public float getTongTienGoc() {
        return TongTienGoc;
    }

    public String getMaHD() {
        return MaHD;
    }

    public String getMaKH() {
        return MaKH;
    }

    public String getMaNV() {
        return MaNV;
    }

    public String getNgayGiao() {
        return NgayGiao;
    }

    public String getNgayLap() {
        return NgayLap;
    }

   

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public void setNgayGiao(String NgayGiao) {
        this.NgayGiao = NgayGiao;
    }

    public void setNgayLap(String NgayLap) {
        this.NgayLap = NgayLap;
    }

    public void setTongTienGoc(float TongTienGoc) {
        this.TongTienGoc = TongTienGoc;
    }

    public void setTongTienSauGiam(float TongTienSauGiam) {
        this.TongTienSauGiam = TongTienSauGiam;
    }
    

    

    

  
    
    public List<CTHoaDonDTO> getDsCTHD() {
        return dsCTHD;
    }

    public void setDsCTHD(List<CTHoaDonDTO> dsCTHD) {
        this.dsCTHD = dsCTHD;
    }
    
}