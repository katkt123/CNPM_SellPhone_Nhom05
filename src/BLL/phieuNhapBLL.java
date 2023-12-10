package BLL;

import DAO.phieuNhapDAO;
import DTO.ctphieuNhapDTO;
import DTO.phieuNhapDTO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class phieuNhapBLL {
    private phieuNhapDAO daoPn;
    private String idPn;
    public phieuNhapBLL() {
        daoPn = new phieuNhapDAO();
    }
    
    public ArrayList<phieuNhapDTO> showAll(){
        return this.daoPn.getListall();
    }
    
    public ArrayList<phieuNhapDTO> showSort(ArrayList<phieuNhapDTO> list, String type, String way){
        ArrayList<phieuNhapDTO> tmpList = list;
        if(way.equals("Tăng Dần")){
            if(type.equals("Mã Phiếu")){
                for(int i = 0; i<tmpList.size()-1; i++){
                    for (int j = i+1; j< tmpList.size(); j++){
                        if(Integer.parseInt(tmpList.get(i).getmaPn().replace(" ", "").replace("PN", "")) > Integer.parseInt(tmpList.get(j).getmaPn().replace(" ", "").replace("PN", ""))){
                            phieuNhapDTO tmp = tmpList.get(i);
                            tmpList.set(i, tmpList.get(j));
                            tmpList.set(j, tmp);
                        }
                    }
                }
            }

            if(type.equals("Ngày Nhập")){
                for(int i = 0; i<tmpList.size()-1; i++){
                    for (int j = i+1; j< tmpList.size(); j++){
                        if(Integer.parseInt(tmpList.get(i).getngayNhap().split(" ")[0].split("-")[2])>Integer.parseInt(tmpList.get(j).getngayNhap().split(" ")[0].split("-")[2])){
                            phieuNhapDTO tmp = tmpList.get(i);
                            tmpList.set(i, tmpList.get(j));
                            tmpList.set(j, tmp);
                        }
                    }
                }
                for(int i = 0; i<tmpList.size()-1; i++){
                    for (int j = i+1; j< tmpList.size(); j++){
                        if(Integer.parseInt(tmpList.get(i).getngayNhap().split(" ")[0].split("-")[2])==Integer.parseInt(tmpList.get(j).getngayNhap().split(" ")[0].split("-")[2]) && Integer.parseInt(tmpList.get(i).getngayNhap().split("-")[1])>Integer.parseInt(tmpList.get(j).getngayNhap().split("-")[1])){
                            phieuNhapDTO tmp = tmpList.get(i);
                            tmpList.set(i, tmpList.get(j));
                            tmpList.set(j, tmp);
                        }
                    }
                }
                for(int i = 0; i<tmpList.size()-1; i++){
                    for (int j = i+1; j< tmpList.size(); j++){
if(Integer.parseInt(tmpList.get(i).getngayNhap().split(" ")[0].split("-")[2])==Integer.parseInt(tmpList.get(j).getngayNhap().split(" ")[0].split("-")[2]) &&  Integer.parseInt(tmpList.get(i).getngayNhap().split("-")[1])==Integer.parseInt(tmpList.get(j).getngayNhap().split("-")[1]) && Integer.parseInt(tmpList.get(i).getngayNhap().split("-")[0])>Integer.parseInt(tmpList.get(j).getngayNhap().split("-")[0])){
                            phieuNhapDTO tmp = tmpList.get(i);
                            tmpList.set(i, tmpList.get(j));
                            tmpList.set(j, tmp);
                        }
                    }
                }
            }
        }
        else{
            if(type.equals("Mã Phiếu")){
                for(int i = 0; i<tmpList.size()-1; i++){
                    for (int j = i+1; j< tmpList.size(); j++){
                        if(Integer.parseInt(tmpList.get(i).getmaPn().replace(" ", "").replace("PN", "")) < Integer.parseInt(tmpList.get(j).getmaPn().replace(" ", "").replace("PN", ""))){
                            phieuNhapDTO tmp = tmpList.get(i);
                            tmpList.set(i, tmpList.get(j));
                            tmpList.set(j, tmp);
                        }
                    }
                }
            }

            if(type.equals("Ngày Nhập")){
                for(int i = 0; i<tmpList.size()-1; i++){
                    for (int j = i+1; j< tmpList.size(); j++){
                        if(Integer.parseInt(tmpList.get(i).getngayNhap().split(" ")[0].split("-")[2])<Integer.parseInt(tmpList.get(j).getngayNhap().split(" ")[0].split("-")[2])){
                            phieuNhapDTO tmp = tmpList.get(i);
                            tmpList.set(i, tmpList.get(j));
                            tmpList.set(j, tmp);
                        }
                    }
                }
                for(int i = 0; i<tmpList.size()-1; i++){
                    for (int j = i+1; j< tmpList.size(); j++){
                        if(Integer.parseInt(tmpList.get(i).getngayNhap().split(" ")[0].split("-")[2])==Integer.parseInt(tmpList.get(j).getngayNhap().split(" ")[0].split("-")[2]) && Integer.parseInt(tmpList.get(i).getngayNhap().split("-")[1])<Integer.parseInt(tmpList.get(j).getngayNhap().split("")[1])){
                            phieuNhapDTO tmp = tmpList.get(i);
                            tmpList.set(i, tmpList.get(j));
                            tmpList.set(j, tmp);
                        }
                    }
                }
                for(int i = 0; i<tmpList.size()-1; i++){
                    for (int j = i+1; j< tmpList.size(); j++){
if(Integer.parseInt(tmpList.get(i).getngayNhap().split(" ")[0].split("-")[2])==Integer.parseInt(tmpList.get(j).getngayNhap().split(" ")[0].split("-")[2]) &&  Integer.parseInt(tmpList.get(i).getngayNhap().split("-")[1])==Integer.parseInt(tmpList.get(j).getngayNhap().split("-")[1]) && Integer.parseInt(tmpList.get(i).getngayNhap().split("-")[0])<Integer.parseInt(tmpList.get(j).getngayNhap().split("-")[0])){
                            phieuNhapDTO tmp = tmpList.get(i);
                            tmpList.set(i, tmpList.get(j));
                            tmpList.set(j, tmp);
                        }
                    }
                }
            }
        }
        return tmpList;
    }
    
    public ArrayList<phieuNhapDTO> showSearch(String data, String type){
        return this.daoPn.getSearch(data, type);
    }
    
    public ArrayList<ctphieuNhapDTO> showCtpn(String id){
        return this.daoPn.getListCt(id);
    }
    
    public void createPN(String makho, long tongTien, int Thue){
        this.idPn = this.daoPn.initIDpn();
        this.daoPn.themPn(new phieuNhapDTO(this.idPn, makho, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").format(new Date()), tongTien, Thue));
        
    }
    
    public void createCTPN(String mancc, int sl, long dongia, long tamtinh){
        this.daoPn.themCtpn(new ctphieuNhapDTO(idPn, mancc, sl, dongia, tamtinh));
    }
    
    public void xoaPn(String id){
        this.daoPn.xoaPn(id);
    }
    public void xoaCtpn(String id){
        this.daoPn.xoaCtpn(id);
    }
}