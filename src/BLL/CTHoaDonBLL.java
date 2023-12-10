/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAO.CTHoaDonDAO;
import DTO.CTHoaDonDTO;
import java.util.ArrayList;

/**
 *
 * @author HAO KIET
 */
public class CTHoaDonBLL {
    CTHoaDonDAO cthdDAO= new CTHoaDonDAO();
    
    public ArrayList<CTHoaDonDTO> getListCTHoaDon(){
        return cthdDAO.getListCTHoaDon();
    }
}
