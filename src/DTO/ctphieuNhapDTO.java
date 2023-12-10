package DTO;

public class ctphieuNhapDTO {
    private String maPn;
    private String maNcc;
    private int soLuong;
    private long donGia;
    private long tamTinh;

    public ctphieuNhapDTO(){
        this.maPn=null;
        this.maNcc=null;
        this.soLuong=0;
        this.donGia=0;
        this.tamTinh=0;
    }

    public ctphieuNhapDTO(String ticketID,String providerID, int quantity ,long pricePeritem, long tmpPrice){
        this.maPn=ticketID;
        this.maNcc=providerID;
        this.soLuong=quantity;
        this.donGia=pricePeritem;
        this.tamTinh=tmpPrice;
    }

    public String getmaPn(){
        return this.maPn;
    }

    public String getmaNcc(){
        return this.maNcc;
    }

   public int getsoLuong(){
       return this.soLuong;
   }

    public long getdonGia(){
        return this.donGia;
    }

    public long gettamTinh(){
        return this.tamTinh;
    }



    public void setmaPn(String id){
        this.maPn=id;
    }

    public void setmaSp(String id){
        this.maNcc=id;
    }

    public void setsoLuong(int quantity){
        this.soLuong=quantity;
    }

    public void setdonGia(int tmpPrice){
        this.donGia=tmpPrice;
    }

    public void settamTinh(int tmpPrice){
        this.tamTinh=tmpPrice;
    }

    public void setctphieuNhap(String ticketID,String providerID, int quantity ,long pricePeritem, long tmpPrice){
        this.maPn=ticketID;
        this.maNcc=providerID;
        this.soLuong=quantity;
        this.donGia=pricePeritem;
        this.tamTinh=tmpPrice;
    }
   
}
