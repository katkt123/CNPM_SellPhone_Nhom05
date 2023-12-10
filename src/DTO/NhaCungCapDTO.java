/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Dao Khanh
 */
public class NhaCungCapDTO {
    private String MaNCC;
    private String TenNCC;
    private String DiaChiNCC;
    private String SDTNCC;

    public NhaCungCapDTO(String MaNCC, String TenNCC, String DiaChiNCC, String SDTNCC) {
        this.MaNCC = MaNCC;
        this.TenNCC = TenNCC;
        this.DiaChiNCC = DiaChiNCC;
        this.SDTNCC = SDTNCC;
    }

    public NhaCungCapDTO(){
        MaNCC=null;
        TenNCC=null; 
        DiaChiNCC=null;
        SDTNCC=null;
    }

    public String getMaNCC() {
        return MaNCC;
    }

    public void setMaNCC(String MaNCC) {
        this.MaNCC = MaNCC;
    }

    public String getTenNCC() {
        return TenNCC;
    }

    public void setTenNCC(String TenNCC) {
        this.TenNCC = TenNCC;
    }

    public String getDiaChiNCC() {
        return DiaChiNCC;
    }

    public void setDiaChiNCC(String DiaChiNCC) {
        this.DiaChiNCC = DiaChiNCC;
    }

    public String getSDTNCC() {
        return SDTNCC;
    }

    public void setSDTNCC(String SDTNCC) {
        this.SDTNCC = SDTNCC;
    }
    
    
}
