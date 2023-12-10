package BLL;

import DAO.KhachHangDAO;
import DAO.TaiKhoanDAO;
import DTO.KhachHangDTO;
import DTO.TaiKhoanDTO;
import javax.swing.JOptionPane;

public class DangKyBLL {
    private TaiKhoanDAO tkdao ;
    private KhachHangDAO khdao;
    public DangKyBLL(){
        this.tkdao= new TaiKhoanDAO();
        this.khdao = new KhachHangDAO();
    }
    public void xuLyDangKy(String un, String pw, String fn,String phone, String dr){
        if(tkdao.SearchTK(un).isEmpty()){
            String idtk = tkdao.initIDtk();
            TaiKhoanDTO tk = new TaiKhoanDTO(idtk, un, pw, 0);
            tkdao.addTk(tk);
            khdao.addKh(new KhachHangDTO(khdao.initIDkh(),fn,dr,phone,idtk));
            
            JOptionPane.showMessageDialog(null, "Đăng kí thành công");
        }else{
            JOptionPane.showMessageDialog(null, "Đã tồn tại tài khoản");
        }
    }
}