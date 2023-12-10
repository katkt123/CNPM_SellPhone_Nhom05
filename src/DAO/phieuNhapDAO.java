package DAO;

import DTO.ctphieuNhapDTO;
import DTO.phieuNhapDTO;
import java.sql.*;
import java.util.*;

public class phieuNhapDAO {
    private sqlConnect sql;
    
    public phieuNhapDAO(){
        this.sql=new sqlConnect();
    }
    
    public ArrayList<phieuNhapDTO> getListall(){
        ArrayList<phieuNhapDTO> resultList = new ArrayList<>();
        ResultSet rs = null;
        String query="select * from PhieuNhapKho";
        try {
            rs = this.sql.getSta().executeQuery(query);
            while(rs.next()){
                resultList.add(new phieuNhapDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
            }
        } catch (Exception e) {
            System.out.println("Loi lay danh sach phieu nhap: "+e);
        }
        return resultList;
    }
    
    public void themPn(phieuNhapDTO pn){
        String query = "insert into PhieuNhapKho(MaPhieuNhap, MaKho,NgayNhap,TongTien,Thue) values('"+pn.getmaPn()+"','"+pn.getmaKho()+"','"+pn.getngayNhap()+"',"+pn.gettongTien()+","+pn.getthue()+");";
        try {
            this.sql.getSta().executeUpdate(query);
        } catch (Exception e) {
            System.out.println("Loi them phieu nhap: "+e);
        }
    }
    
    public void xoaPn(String id){
        String query = "delete from PhieuNhapKho where MaPhieuNhap='"+id+"';";
        try {
            this.sql.getSta().executeUpdate(query);
        } catch (Exception e) {
            System.out.println("Loi xoa phieu nhap "+e);
        }
    }
    
    public void suaPn(String idPn, String id, String day, int total, int tax){
        String query="update PhieuNhapKho set MaKho='"+id+"', NgayNhap='"+day+"', TongTien="+total+",Thue="+tax+" where MaPhieuNhap='"+idPn+"';";
        try {
            this.sql.getSta().executeUpdate(query);
        } catch (Exception e) {
            System.out.println("Loi sua phieu nhap: "+e);
        }
    }
    
    public String initIDpn(){
        int tmp = 0;
        String id = null;
        ResultSet rs = null;
        String query="select count(*) as 'quantity' from PhieuNhapKho";
        
        try {
            rs = this.sql.getSta().executeQuery(query);
            rs.next();
            while(true){
                ResultSet rs1 = this.sql.getSta().executeQuery("select count(*) as 'quantity' from PhieuNhapKho where MaPhieuNhap='PN"+tmp+"';");
                rs1.next();
                if(rs1.getInt(1)!=0){
                    tmp+=1;
                }
                else{
                    id="PN"+tmp;
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Loi tao id phieu nhap: "+e);
        }
        return id;
    }
    
    
//    CHI TIẾT PHIẾU NHẬP
    public ArrayList<ctphieuNhapDTO> getListCt(String idpn){
        ArrayList<ctphieuNhapDTO> resultList = new ArrayList<>();
        ResultSet rs = null;
        String query="select * from CTPhieuNhapKho where MaPhieuNhap='"+idpn+"';";
        try {
            rs = this.sql.getSta().executeQuery(query);
            while(rs.next()){
                resultList.add(new ctphieuNhapDTO(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5)));
            }
        } catch (Exception e) {
            System.out.println("Loi lay danh sach phieu nhap: "+e);
        }
        return resultList;
    }
    
    public void themCtpn(ctphieuNhapDTO pn){
        String query = "insert into CTPhieuNhapKho(MaPhieuNhap, MaNcc,SoLuong,DonGia,TamTinh) values('"+pn.getmaPn()+"','"+pn.getmaNcc()+"','"+ pn.getsoLuong() +"',"+pn.getdonGia()+","+ pn.gettamTinh()+");";
        try {
            this.sql.getSta().executeUpdate(query);
        } catch (Exception e) {
            System.out.println("Loi them chi tiet phieu nhap: "+e);
        }
    }
    
    public void xoaCtpn(String id){
        String query = "delete from CTPhieuNhapKho where MaPhieuNhap='"+id+"';";
        try{
            this.sql.getSta().executeUpdate(query);
        } catch (Exception e) {
            System.out.println("Loi xoa ct phieu nhap: "+e);
        }
    }
    
    public void suaCtpn(String idPn, String idncc, int quantity, int pricePer, int tmpPrice){
        String query="update CTPhieuNhapKho set MaNcc='"+idncc+"', SoLuong='"+quantity+"', DonGia="+pricePer+",TamTinh="+tmpPrice+" where MaPhieuNhap='"+idPn+"';";
        try {
            this.sql.getSta().executeUpdate(query);
        } catch (Exception e) {
            System.out.println("Loi sua phieu nhap: "+e);
        }
    }
    
    public ArrayList<phieuNhapDTO> getSearch(String data, String type){
        ResultSet rs = null;
        ArrayList<phieuNhapDTO> dspn = new ArrayList<>();
        String query = "select * from PhieuNhapKho where ";
        try{
            switch (type) {
                case "Mã Phiếu":
                    query += "MaPhieuNhap='"+data+"';";
                    break;
                case "Mã Kho":
                    query += "MaKho='"+data+"';";
                    break;
                case "Tổng Tiền":
                    query += "TongTien="+Integer.parseInt(data)+";";
                    break;
                default:
                    query += "MaPhieuNhap like '%"+data+"%' or MaKho like '%"+data+"%' or NgayNhap like '%"+data+"%';";
            }
            rs = this.sql.getSta().executeQuery(query);
            while(rs.next()){
                dspn.add(new phieuNhapDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
            }
        }catch(Exception e){
            System.out.println("Loi tim kiem phieu nhap: "+e);
        }
        return dspn;
    }
}