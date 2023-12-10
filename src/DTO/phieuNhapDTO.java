package DTO;
import java.util.*;

public class phieuNhapDTO {
    private String maPn;
    private String maKho;
    private String ngayNhap;
    private long tongTien;
    private int thue;
    
    public phieuNhapDTO(){
        this.maPn=null;
        this.maKho = null;
        this.ngayNhap=null;
        this.tongTien=0;
        this.thue=0;
    }
    
    public phieuNhapDTO(String ticketID, String storedID, String dateModifier, long total, int tax){
        this.maPn=ticketID;
        this.maKho=storedID;
        this.ngayNhap=dateModifier;
        this.tongTien=total;
        this.thue=tax;
    }
    
    public String getmaPn(){
        return this.maPn;
    }
    public void setmaPn(String ID){
        this.maPn=ID;
    }
    
    public String getngayNhap(){
        return this.ngayNhap;
    }
    public void setngayNhap(String date){
        this.ngayNhap=date;
    }
    
    public String getmaKho(){
        return this.maKho;
    }
    public void setmaNcc(String ID){
        this.maKho=ID;
    }
    
    public long gettongTien(){
        return this.tongTien;
    }
    public void settongTien(ArrayList<ctphieuNhapDTO> ctpnLst){
        this.tongTien=0;
        for(ctphieuNhapDTO ctpn : ctpnLst){
            this.tongTien+=ctpn.gettamTinh();
        }
        this.tongTien = this.tongTien - this.tongTien*this.thue;
    }

    public int getthue(){
        return this.thue;
    }
    public void setthue(int tax){
        this.thue=tax;
    }
    
    public void setphieuNhap(String ticketID, String storedID, String dateModifier,long total, int tax){
        this.maPn=ticketID;
        this.maKho=storedID;
        this.ngayNhap=dateModifier;
        this.tongTien=total;
        this.thue=tax;
    }

    @Override
    public String toString(){
        return this.maPn+this.maKho+this.ngayNhap+Long.toString(this.tongTien)+Integer.toString(this.thue);
    }
}
