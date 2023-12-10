package GUI;

import DTO.NhaCungCapDTO;
import DTO.SanPhamNCCDTO;
import BLL.NhaCungCapBLL;
import BLL.SanPhamBLL;
import BLL.SanPhamNCCBLL;
import BLL.phieuNhapBLL;
import DTO.ctphieuNhapDTO;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.time.Clock;
import java.util.*;
import javax.swing.*;

public class nhapHangGUI extends javax.swing.JPanel {
    private NhaCungCapBLL nccBLL = new NhaCungCapBLL();
    private phieuNhapBLL pnBLL = new phieuNhapBLL();
    private SanPhamNCCBLL spnccBLL = new SanPhamNCCBLL();
    private SanPhamBLL spBLL = new SanPhamBLL();
    private ArrayList<NhaCungCapDTO> dsncc = new ArrayList<>();
    private ArrayList<PanelRound> listItemBox = new ArrayList<>();
    private ArrayList<SanPhamNCCDTO> dsspncc = new ArrayList<>();
    private ArrayList<SanPhamNCCDTO> dsChon = new ArrayList<>();
    private ArrayList<SanPhamNCCDTO> dsXoa = new ArrayList<>();
    private ArrayList<Integer> dssl = new ArrayList<>();
    private ArrayList<PanelRound> ctpnBox = new ArrayList<>();
    private ArrayList<ctphieuNhapDTO> dsctpn = new ArrayList<>();
    private ArrayList<PanelRound> delBox = new ArrayList<>();
    private ArrayList<Integer> dsslDel = new ArrayList<>();
    
    
    public nhapHangGUI() {
        initComponents();
        solveEvents();
    }
        
    public void solveEvents(){
//        this.btnXoads.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent e){
//                dsXoa.addAll(dsChon);
//                dsslDel.addAll(dssl);
//                dsChon.clear();
//                dssl.clear();
//                dsSanphamchon.removeAll();
//                dsSanphamchon.repaint();
//                dsSanphamchon.revalidate();
//            }
//        });
        
        this.reverseAllBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                binDialog.setVisible(true);
                
                dssl.addAll(dsslDel);
                for(SanPhamNCCDTO i : dsXoa){
                    if(dsChon.isEmpty() || !isContains(i.getMaSP(), dsChon)){
                        dsChon.add(i);
                        dssl.add(dsslDel.get(dsXoa.indexOf(i)));
                        ctpnBox.add(itemBoxChoosen(30, spBLL.getSanPham(i.getMaSP()).getTenSP(), nccBLL.getNccById(i.getMaNCC()).getTenNCC(), Integer.toString(dssl.get(dsChon.indexOf(i))), Long.toString(spBLL.getSanPham(i.getMaSP()).getDonGiaNhap()), spBLL.getSanPham(i.getMaSP()).getMaSP(), spBLL.getSanPham(i.getMaSP()).getHinhAnh()));

                    }
                    else{
                        for(int j = 0; j<dsChon.size(); j++){
                            if(dsChon.get(j).getMaSP().equals(i.getMaSP())){
                                dssl.set(j, dssl.get(j)+dsslDel.get(dsXoa.indexOf(i)));
                                ctpnBox.set(j, itemBoxChoosen(30, spBLL.getSanPham(i.getMaSP()).getTenSP(), nccBLL.getNccById(i.getMaNCC()).getTenNCC(), Integer.toString(dssl.get(j)), Long.toString(spBLL.getSanPham(i.getMaSP()).getDonGiaNhap()), spBLL.getSanPham(i.getMaSP()).getMaSP(), spBLL.getSanPham(i.getMaSP()).getHinhAnh()));
                            }
                        }
                    }
                }
                dsXoa.clear();
                delBox.clear();
                dsDaXoa.removeAll();
                dsDaXoa.repaint();
                dsDaXoa.revalidate();
                
                dsSanphamchon.removeAll();
                if(dsChon.size()%2==0){
                    dsSanphamchon.setPreferredSize(new Dimension(dsSanphamchon.getPreferredSize().width, (210)*(dsChon.size()/2)));
                }
                else{
                    dsSanphamchon.setPreferredSize(new Dimension(dsSanphamchon.getPreferredSize().width, (210)*(dsChon.size()/2+1)));                    
                }
                
                for(PanelRound i : ctpnBox){
                    dsSanphamchon.add(i);
                }
                
                dsSanphamchon.repaint();
                dsSanphamchon.revalidate();
                binDialog.dispose();
                JOptionPane.showMessageDialog(null, "Đã khôi phục thành công");

            }
        });
        
        this.btnTrashbin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                binDialog.setVisible(true);
                dsDaXoa.removeAll();
                dsDaXoa.setPreferredSize(new Dimension(dsDaXoa.getPreferredSize().width, (210)*(dsXoa.size())));
                
                for(SanPhamNCCDTO i : dsXoa){
                    delBox.add(itemBoxBin(30, spBLL.getSanPham(i.getMaSP()).getTenSP(), nccBLL.getNccById(i.getMaNCC()).getTenNCC(), Integer.toString(dsslDel.get(dsXoa.indexOf(i))), Long.toString(spBLL.getSanPham(i.getMaSP()).getDonGiaNhap()), spBLL.getSanPham(i.getMaSP()).getMaSP(), spBLL.getSanPham(i.getMaSP()).getHinhAnh()));
                }
                
                for(PanelRound i : delBox){
                    dsDaXoa.add(i);
                }
                
                dsDaXoa.repaint();
                dsDaXoa.revalidate();
            }
        });

        this.btnNhaphang.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                long tongTien = 0;
                if(dsChon.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Chưa chọn hàng để nhập");
                }
                else {
                    for(SanPhamNCCDTO i : dsChon){
                        int index = dsChon.indexOf(i);
                        tongTien += spBLL.getSanPham(i.getMaSP()).getDonGiaNhap() * dssl.get(index);
                        spBLL.updateSoLuong(spBLL.getSanPham(i.getMaSP()), spBLL.getSanPham(i.getMaSP()).getSoLuong()+dssl.get(index));
                    }
                    pnBLL.createPN("KHO01", tongTien, 10);
                    for(SanPhamNCCDTO i : dsChon){
                        int index = dsChon.indexOf(i);
                        pnBLL.createCTPN(nccBLL.getNccById(i.getMaNCC()).getMaNCC(), dssl.get(index), spBLL.getSanPham(i.getMaSP()).getDonGiaNhap(), spBLL.getSanPham(i.getMaSP()).getDonGiaNhap()*dssl.get(index));
                    }
                    dsChon.clear();
                    dsXoa.clear();
                    dssl.clear();
                    ctpnBox.clear();
                    dsctpn.clear();
                    delBox.clear();
                    dsslDel.clear();
                    dsSanphamchon.removeAll();
                    dsSanphamchon.repaint();
                    dsSanphamchon.revalidate();
                    dsDaXoa.removeAll();
                    dsDaXoa.repaint();
                    dsDaXoa.revalidate();
                    JOptionPane.showMessageDialog(null, "Đã nhập hàng thành công");
                }
            }
        });
        
        this.cancelBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                chooseDialog.dispose();
                quantityInput.setText("1");
            }
        });
      
        this.addBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                ctpnBox.clear();
                dsSanphamchon.removeAll();
                if(dsChon.size()%2==0){
                    dsSanphamchon.setPreferredSize(new Dimension(dsSanphamchon.getPreferredSize().width, (210)*(dsChon.size()/2)));
                }
                else{
                    dsSanphamchon.setPreferredSize(new Dimension(dsSanphamchon.getPreferredSize().width, (210)*(dsChon.size()/2+1)));                    
                }
                
                for(SanPhamNCCDTO i: dsChon){
                    if(i.getMaSP().equals(maSpLabel.getText())){
                        if(dssl.size()<dsChon.size()){
                            dssl.add(Integer.parseInt(quantityInput.getText()));
                        }
                        else{
                            dssl.set(dsChon.indexOf(i), dssl.get(dsChon.indexOf(i)) + Integer.parseInt(quantityInput.getText()));
                        }
                        
                    }
                }
                
                for(SanPhamNCCDTO i : dsChon){
                    ctpnBox.add(itemBoxChoosen(30, spBLL.getSanPham(i.getMaSP()).getTenSP(), nccBLL.getNccById(i.getMaNCC()).getTenNCC(), Integer.toString(dssl.get(dsChon.indexOf(i))), Long.toString(spBLL.getSanPham(i.getMaSP()).getDonGiaNhap()), spBLL.getSanPham(i.getMaSP()).getMaSP(), spBLL.getSanPham(i.getMaSP()).getHinhAnh()));
                }
                for(PanelRound i : ctpnBox){
                    dsSanphamchon.add(i);
                }
                chooseDialog.dispose();
                quantityInput.setText("1");
                dsSanphamchon.repaint();
                dsSanphamchon.revalidate();
            }
        });
        
        this.quantityInput.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                tamTinhLable.setText(Integer.toString(Integer.parseInt(quantityInput.getText())*Integer.parseInt(donGiaLabel.getText())));
            }
        });
        
        for(NhaCungCapDTO ncc : this.nccBLL.getListAll()){
            JCheckBox cb = new JCheckBox(ncc.getTenNCC());            
            cb.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    dsSanphamncc.removeAll();
                    listItemBox.clear();
                    dsspncc.clear();
                    if(cb.isSelected()){
                        dsncc.add(ncc);
                    }
                    else{
                        dsncc.remove(ncc);
                    }

                    for(NhaCungCapDTO i : dsncc){
                        dsspncc.addAll(spnccBLL.getListByNccId(i.getMaNCC()));
                    }

                    for(SanPhamNCCDTO i : dsspncc){
                        listItemBox.add(itemBoxNcc(30, spBLL.getSanPham(i.getMaSP()).getTenSP(), spBLL.getSanPham(i.getMaSP()).getMaSP(), nccBLL.getNccById(i.getMaNCC()).getTenNCC(), nccBLL.getNccById(i.getMaNCC()).getMaNCC(), Long.toString(spBLL.getSanPham(i.getMaSP()).getDonGiaNhap()), spBLL.getSanPham(i.getMaSP()).getHinhAnh()));
                    }
                    
                    if(listItemBox.size()%2 == 0){
                        dsSanphamncc.setPreferredSize(new Dimension(dsSanphamncc.getPreferredSize().width, (250+10)*(listItemBox.size()/2)));dsSanphamncc.repaint();
                    }else{
                        dsSanphamncc.setPreferredSize(new Dimension(dsSanphamncc.getPreferredSize().width, (250+10)*(listItemBox.size()/2+1)));dsSanphamncc.repaint();
                    }
                    
                    for(PanelRound itb : listItemBox){
                        dsSanphamncc.add(itb);
                    }
                    dsSanphamncc.repaint();
                    dsSanphamncc.revalidate();
                }
            });
            this.dsNcc.add(cb);
        }
        
    }
    

    private PanelRound itemBoxNcc(int radius, String tsp, String msp, String tncc, String mncc, String dg, String link){
        PanelRound pr = new PanelRound();
        pr.setRoundTopLeft(radius);
        pr.setRoundTopRight(radius);
        pr.setRoundBottomLeft(radius);
        pr.setRoundBottomRight(radius);
        pr.setPreferredSize(new Dimension(400, 250));
        pr.setBackground(Color.lightGray);
        pr.setLayout(null);
        PanelRound hinhAnh = new PanelRound();
        hinhAnh.setRoundTopLeft(radius);
        hinhAnh.setRoundTopRight(radius);
        hinhAnh.setRoundBottomLeft(radius);
        hinhAnh.setRoundBottomRight(radius);
        hinhAnh.setBounds(10, 10, 100, 230);
        
        hinhAnh.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        JLabel icon = new JLabel();
        File file = new File(link);
        ImageIcon imageIcon = new ImageIcon(file.getAbsolutePath());
        Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance(100, 230, Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(scaledImage);
        icon.setIcon(scaledImageIcon);
        hinhAnh.add(icon);
        
        JLabel labelTensp = new JLabel("Tên sản phẩm");
        labelTensp.setBounds(130, 20, 120, 30);
        JLabel labelMasp = new JLabel("Mã sản phẩm");
        labelMasp.setBounds(130, 60, 120, 30);
        JLabel labelTenncc = new JLabel("Tên nhà cung cấp");
        labelTenncc.setBounds(130, 100, 120, 30);
        JLabel labelMancc = new JLabel("Mã nhà cung cấp");
        labelMancc.setBounds(130, 140, 120, 30);
        JLabel labelDongia = new JLabel("Đơn giá");
        labelDongia.setBounds(130, 180, 120, 30);
        JLabel tenSp = new JLabel(tsp);
        tenSp.setBounds(250, 20, 120, 30);
        JLabel maSp = new JLabel(msp);
        maSp.setBounds(250, 60, 120, 30);
        JLabel tenNcc = new JLabel(tncc);
        tenNcc.setBounds(250, 100, 120, 30);
        JLabel maNcc = new JLabel(mncc);
        maNcc.setBounds(250, 140, 120, 30);
        JLabel donGia = new JLabel(dg);
        donGia.setBounds(250, 180, 120, 30);
        JButton funcBtn = new JButton("Thêm");
        funcBtn.setBounds(200, 210, 100, 30);
        funcBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                for(SanPhamNCCDTO i : dsspncc){
                    if(i.getMaSP().equals(msp)){
                        if(dsChon.isEmpty() || !isContains(msp, dsChon)){ 
                            dsChon.add(i);
                        }
                    }
                }
                tonKhoLable.setText(Integer.toString(spBLL.getSanPham(msp).getSoLuong()));
                donGiaLabel.setText(dg);
                maSpLabel.setText(msp);
                tamTinhLable.setText(Integer.toString(Integer.parseInt(dg)*Integer.parseInt(quantityInput.getText())));
                chooseDialog.setVisible(true);
            }
        });
        
        pr.add(hinhAnh);
        pr.add(labelTensp);
        pr.add(labelMasp);
        pr.add(labelTenncc);
        pr.add(labelMancc);
        pr.add(labelDongia);
        pr.add(tenSp);
        pr.add(maSp);
        pr.add(maNcc);
        pr.add(tenNcc);
        pr.add(donGia);
        pr.add(funcBtn);
        return pr;
    } 

    private PanelRound itemBoxChoosen(int radius, String tsp, String tncc, String sl, String dg,String msp, String link){
        PanelRound pr = new PanelRound();
        pr.setRoundTopLeft(radius);
        pr.setRoundTopRight(radius);
        pr.setRoundBottomLeft(radius);
        pr.setRoundBottomRight(radius);
        pr.setPreferredSize(new Dimension(400, 200));
        pr.setBackground(Color.lightGray);
        pr.setLayout(null);
        PanelRound hinhAnh = new PanelRound();
        hinhAnh.setRoundTopLeft(radius);
        hinhAnh.setRoundTopRight(radius);
        hinhAnh.setRoundBottomLeft(radius);
        hinhAnh.setRoundBottomRight(radius);
        hinhAnh.setBounds(10, 10, 100, 180);
        hinhAnh.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        JLabel icon = new JLabel();
        File file = new File(link);
        ImageIcon imageIcon = new ImageIcon(file.getAbsolutePath());
        Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance(100, 180, Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(scaledImage);
        icon.setIcon(scaledImageIcon);
        hinhAnh.add(icon);
        
        JLabel labelTensp = new JLabel("Tên sản phẩm:");
        labelTensp.setBounds(130, 20, 120, 30);
        JLabel labelTenncc = new JLabel("Tên nhà cung cấp:");
        labelTenncc.setBounds(130, 50, 120, 30);
        JLabel labelSoluong = new JLabel("Số lượng nhập:");
        labelSoluong.setBounds(130, 80, 120, 30);
        JLabel labelDongia = new JLabel("Đơn giá:");
        labelDongia.setBounds(130, 110, 120, 30);
        JLabel labelTamtinh = new JLabel("Tạm tính:");
        labelTamtinh.setBounds(130, 140, 120, 30);
        JLabel tenSp = new JLabel(tsp);
        tenSp.setBounds(250, 20, 120, 30);
        JLabel tenNcc = new JLabel(tncc);
        tenNcc.setBounds(250, 50, 120, 30);
        JLabel soLuong = new JLabel(sl);
        soLuong.setBounds(250, 80, 120, 30);
        JLabel donGia = new JLabel(dg);
        donGia.setBounds(250, 110, 120, 30);
        JLabel tamTinh = new JLabel(Integer.toString(Integer.parseInt(sl)*Integer.parseInt(dg)));
        tamTinh.setBounds(250, 140, 120, 30);
        JButton funcBtn = new JButton("Xóa");
        funcBtn.setBounds(200, 170, 100, 30);
        funcBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                int tmp = 0;
                for(SanPhamNCCDTO i : dsspncc){
                    if(i.getMaSP().equals(msp)){
                        dsXoa.add(i);
                        for(SanPhamNCCDTO j : dsChon){
                            if(j.getMaSP().equals(msp)){
                                tmp = dsChon.indexOf(j);
                            }
                        }
                    }
                }
                dsSanphamchon.remove(ctpnBox.get(tmp));
                dsChon.remove(tmp);
                ctpnBox.remove(tmp);
                dsslDel.add(dssl.get(tmp));
                dssl.remove(tmp);

                if(dsChon.size()%2==0){
                    dsSanphamchon.setPreferredSize(new Dimension(dsSanphamchon.getPreferredSize().width, (210)*(dsChon.size()/2)));
                }
                else{
                    dsSanphamchon.setPreferredSize(new Dimension(dsSanphamchon.getPreferredSize().width, (210)*(dsChon.size()/2+1)));                    
                }
                dsSanphamchon.repaint();
                dsSanphamchon.revalidate();
            }
        });
        
        pr.add(hinhAnh);
        pr.add(labelTensp);
        pr.add(labelTenncc);
        pr.add(labelSoluong);
        pr.add(labelDongia);
        pr.add(labelTamtinh);
        pr.add(tenSp);
        pr.add(tenNcc);
        pr.add(soLuong);
        pr.add(donGia);
        pr.add(tamTinh);
        pr.add(funcBtn);
        return pr;
    } 
    
    private PanelRound itemBoxBin(int radius, String tsp, String tncc, String sl, String dg,String msp, String link){
        PanelRound pr = new PanelRound();
        pr.setRoundTopLeft(radius);
        pr.setRoundTopRight(radius);
        pr.setRoundBottomLeft(radius);
        pr.setRoundBottomRight(radius);
        pr.setPreferredSize(new Dimension(350, 200));
        pr.setBackground(Color.lightGray);
        pr.setLayout(null);
        PanelRound hinhAnh = new PanelRound();
        hinhAnh.setRoundTopLeft(radius);
        hinhAnh.setRoundTopRight(radius);
        hinhAnh.setRoundBottomLeft(radius);
        hinhAnh.setRoundBottomRight(radius);
        hinhAnh.setBounds(10, 10, 100, 180);
        hinhAnh.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        JLabel icon = new JLabel();
        File file = new File(link);
        ImageIcon imageIcon = new ImageIcon(file.getAbsolutePath());
        Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance(100, 180, Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(scaledImage);
        icon.setIcon(scaledImageIcon);
        hinhAnh.add(icon);
        
        JLabel labelTensp = new JLabel("Tên sản phẩm:");
        labelTensp.setBounds(130, 20, 120, 30);
        JLabel labelTenncc = new JLabel("Tên nhà cung cấp:");
        labelTenncc.setBounds(130, 50, 120, 30);
        JLabel labelSoluong = new JLabel("Số lượng nhập:");
        labelSoluong.setBounds(130, 80, 120, 30);
        JLabel labelDongia = new JLabel("Đơn giá:");
        labelDongia.setBounds(130, 110, 120, 30);
        JLabel labelTamtinh = new JLabel("Tạm tính:");
        labelTamtinh.setBounds(130, 140, 120, 30);
        JLabel tenSp = new JLabel(tsp);
        tenSp.setBounds(250, 20, 120, 30);
        JLabel tenNcc = new JLabel(tncc);
        tenNcc.setBounds(250, 50, 120, 30);
        JLabel soLuong = new JLabel(sl);
        soLuong.setBounds(250, 80, 120, 30);
        JLabel donGia = new JLabel(dg);
        donGia.setBounds(250, 110, 120, 30);
        JLabel tamTinh = new JLabel(Integer.toString(Integer.parseInt(sl)*Integer.parseInt(dg)));
        tamTinh.setBounds(250, 140, 120, 30);
        JButton funcBtn = new JButton("Khôi phục");
        funcBtn.setBounds(200, 170, 100, 30);
        funcBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                int tmp = 0;
                for(SanPhamNCCDTO i : dsspncc){
                    if(i.getMaSP().equals(msp)){
                        for(SanPhamNCCDTO j : dsXoa){
                            if(j.getMaSP().equals(msp)){
                                tmp = dsXoa.indexOf(j);
                            }
                        }
                        
                        if(dsChon.isEmpty() || !isContains(msp, dsChon)){ 
                            dsChon.add(i);
                            dssl.add(dsslDel.get(tmp));
                            ctpnBox.add(itemBoxChoosen(30, spBLL.getSanPham(i.getMaSP()).getTenSP(), nccBLL.getNccById(i.getMaNCC()).getTenNCC(), Integer.toString(dsslDel.get(dsXoa.indexOf(i))), Long.toString(spBLL.getSanPham(i.getMaSP()).getDonGiaNhap()), spBLL.getSanPham(i.getMaSP()).getMaSP(), spBLL.getSanPham(i.getMaSP()).getHinhAnh()));
                        }
                        else{
                            for(int j = 0; j<dsChon.size(); j++){
                                if(dsChon.get(j).getMaSP().equals(msp)){
                                    dssl.set(j, dssl.get(j)+dsslDel.get(tmp));
                                    ctpnBox.set(j, itemBoxChoosen(30, spBLL.getSanPham(i.getMaSP()).getTenSP(), nccBLL.getNccById(i.getMaNCC()).getTenNCC(), Integer.toString(dssl.get(j)), Long.toString(spBLL.getSanPham(i.getMaSP()).getDonGiaNhap()), spBLL.getSanPham(i.getMaSP()).getMaSP(), spBLL.getSanPham(i.getMaSP()).getHinhAnh()));
                                }
                            }
                        }

                    }
                }
                
                dsslDel.remove(tmp);
                dsXoa.remove(tmp);
                dsDaXoa.remove(tmp);
                
                dsDaXoa.setPreferredSize(new Dimension(dsDaXoa.getPreferredSize().width, (210)*(dsXoa.size())));
                
                if(dsChon.size()%2==0){
                    dsSanphamchon.setPreferredSize(new Dimension(dsSanphamchon.getPreferredSize().width, (210)*(dsChon.size()/2)));
                }
                else{
                    dsSanphamchon.setPreferredSize(new Dimension(dsSanphamchon.getPreferredSize().width, (210)*(dsChon.size()/2+1)));                    
                }
                
                dsSanphamchon.removeAll();
                for(PanelRound i : ctpnBox){
                    dsSanphamchon.add(i);
                }
                dsSanphamchon.repaint();
                dsSanphamchon.revalidate();
                dsDaXoa.repaint();
                dsDaXoa.revalidate();
            }
        });
        
        pr.add(hinhAnh);
        pr.add(labelTensp);
        pr.add(labelTenncc);
        pr.add(labelSoluong);
        pr.add(labelDongia);
        pr.add(labelTamtinh);
        pr.add(tenSp);
        pr.add(tenNcc);
        pr.add(soLuong);
        pr.add(donGia);
        pr.add(tamTinh);
        pr.add(funcBtn);
        return pr;
    } 
    
    public JButton openQlpn(){
        return this.btnQuanlypn;
    }
    
    private boolean isContains(String id, ArrayList<SanPhamNCCDTO> lst){
        for(SanPhamNCCDTO j : lst){
            if(j.getMaSP().equals(id)){
                return true;
            }
        }
        return false;
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        binDialog = new javax.swing.JDialog();
        jScrollPane4 = new javax.swing.JScrollPane();
        dsDaXoa = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        reverseAllBtn = new javax.swing.JButton();
        chooseDialog = new javax.swing.JDialog();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tonKhoLable = new javax.swing.JLabel();
        quantityInput = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        donGiaLabel = new javax.swing.JLabel();
        tamTinhLable = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        maSpLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        addBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        dsNcc = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        dsSanphamncc = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        dsSanphamchon = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnNhaphang = new javax.swing.JButton();
        btnQuanlypn = new javax.swing.JButton();
        btnTrashbin = new javax.swing.JButton();

        binDialog.setTitle("Thùng rác");
        binDialog.setResizable(false);
        binDialog.setSize(new java.awt.Dimension(400, 500));
        binDialog.setLocationRelativeTo(null);

        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane4.setPreferredSize(new java.awt.Dimension(400, 400));

        dsDaXoa.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 10));
        jScrollPane4.setViewportView(dsDaXoa);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 50));

        reverseAllBtn.setText("Khôi phục tất cả");
        reverseAllBtn.setPreferredSize(new java.awt.Dimension(150, 30));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(reverseAllBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(125, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(reverseAllBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout binDialogLayout = new javax.swing.GroupLayout(binDialog.getContentPane());
        binDialog.getContentPane().setLayout(binDialogLayout);
        binDialogLayout.setHorizontalGroup(
            binDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        binDialogLayout.setVerticalGroup(
            binDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(binDialogLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        chooseDialog.setTitle("Thêm chi tiết phiếu nhập");
        chooseDialog.setResizable(false);
        chooseDialog.setSize(new java.awt.Dimension(400, 500));
        binDialog.setLocationRelativeTo(null);
        chooseDialog.getContentPane().setLayout(new java.awt.FlowLayout());

        jPanel5.setPreferredSize(new java.awt.Dimension(400, 400));

        jLabel6.setText("Số lượng sản phẩm cần nhập:");
        jLabel6.setPreferredSize(new java.awt.Dimension(170, 45));

        jLabel4.setText("Số lượng sản phẩm trong kho:");
        jLabel4.setPreferredSize(new java.awt.Dimension(170, 45));

        tonKhoLable.setText("jLabel8");
        tonKhoLable.setPreferredSize(new java.awt.Dimension(200, 45));

        quantityInput.setText("1");
        quantityInput.setPreferredSize(new java.awt.Dimension(150, 45));

        jLabel8.setText("Đơn giá:");
        jLabel8.setPreferredSize(new java.awt.Dimension(170, 45));

        jLabel9.setText("Tạm tính: ");
        jLabel9.setPreferredSize(new java.awt.Dimension(170, 45));

        donGiaLabel.setText("jLabel10");
        donGiaLabel.setPreferredSize(new java.awt.Dimension(200, 45));

        tamTinhLable.setText("0");
        tamTinhLable.setPreferredSize(new java.awt.Dimension(200, 45));

        jLabel10.setText("Mã sản phẩm:");
        jLabel10.setPreferredSize(new java.awt.Dimension(170, 45));

        maSpLabel.setText("jLabel10");
        maSpLabel.setPreferredSize(new java.awt.Dimension(200, 45));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(quantityInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tonKhoLable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(donGiaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(maSpLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(182, 182, 182))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tamTinhLable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quantityInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tonKhoLable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(donGiaLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(maSpLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tamTinhLable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(146, Short.MAX_VALUE))
        );

        chooseDialog.getContentPane().add(jPanel5);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(400, 50));

        addBtn.setText("Thêm");
        addBtn.setPreferredSize(new java.awt.Dimension(100, 30));

        cancelBtn.setText("Hủy");
        cancelBtn.setPreferredSize(new java.awt.Dimension(100, 30));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        chooseDialog.getContentPane().add(jPanel3);

        setBackground(new java.awt.Color(51, 51, 51));
        setPreferredSize(new java.awt.Dimension(1000, 650));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(150, 600));

        dsNcc.setLayout(new javax.swing.BoxLayout(dsNcc, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(dsNcc);

        jButton1.setBackground(new java.awt.Color(35, 134, 54));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Danh sách NCC");
        jButton1.setToolTipText("");
        jButton1.setBorderPainted(false);
        jButton1.setEnabled(false);

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setPreferredSize(new java.awt.Dimension(840, 250));

        dsSanphamncc.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 10));
        jScrollPane2.setViewportView(dsSanphamncc);

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setPreferredSize(new java.awt.Dimension(840, 200));

        dsSanphamchon.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 10));
        jScrollPane3.setViewportView(dsSanphamchon);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Danh Sách Sản Phẩm Nhà Cung Cấp");
        jLabel1.setPreferredSize(new java.awt.Dimension(850, 50));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Danh Sách Sản Phẩm Đã Chọn");
        jLabel2.setPreferredSize(new java.awt.Dimension(850, 50));

        btnNhaphang.setBackground(new java.awt.Color(35, 134, 54));
        btnNhaphang.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnNhaphang.setForeground(new java.awt.Color(255, 255, 255));
        btnNhaphang.setText("Nhập hàng");
        btnNhaphang.setPreferredSize(new java.awt.Dimension(150, 30));

        btnQuanlypn.setBackground(new java.awt.Color(35, 134, 54));
        btnQuanlypn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnQuanlypn.setForeground(new java.awt.Color(255, 255, 255));
        btnQuanlypn.setText("Quản lí phiếu nhập");
        btnQuanlypn.setPreferredSize(new java.awt.Dimension(150, 30));

        btnTrashbin.setBackground(new java.awt.Color(35, 134, 54));
        btnTrashbin.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTrashbin.setForeground(new java.awt.Color(255, 255, 255));
        btnTrashbin.setText("Sản phẩm vừa xóa");
        btnTrashbin.setPreferredSize(new java.awt.Dimension(150, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(btnQuanlypn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(180, 180, 180)
                                .addComponent(btnTrashbin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(150, 150, 150)
                                .addComponent(btnNhaphang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnQuanlypn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNhaphang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTrashbin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JDialog binDialog;
    private javax.swing.JButton btnNhaphang;
    private javax.swing.JButton btnQuanlypn;
    private javax.swing.JButton btnTrashbin;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JDialog chooseDialog;
    private javax.swing.JLabel donGiaLabel;
    private javax.swing.JPanel dsDaXoa;
    private javax.swing.JPanel dsNcc;
    private javax.swing.JPanel dsSanphamchon;
    private javax.swing.JPanel dsSanphamncc;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel maSpLabel;
    private javax.swing.JTextField quantityInput;
    private javax.swing.JButton reverseAllBtn;
    private javax.swing.JLabel tamTinhLable;
    private javax.swing.JLabel tonKhoLable;
    // End of variables declaration//GEN-END:variables
}