package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import BLL.phieuNhapBLL;
import DTO.phieuNhapDTO;
import DTO.ctphieuNhapDTO;

public class phieuNhapGUI extends javax.swing.JPanel {
    private phieuNhapBLL bus;
    private ArrayList<phieuNhapDTO> dspn;

    public phieuNhapGUI() {
        this.bus = new phieuNhapBLL();
        dspn = this.bus.showAll();
        initComponents();
        solveEvent();
    }

    private void solveEvent(){
        this.searchBtn.addFocusListener(new FocusAdapter(){
            @Override
            public void focusGained(FocusEvent e){
                searchBtn.setBackground(Color.LIGHT_GRAY);
            }
            @Override
            public void focusLost(FocusEvent e){
                searchBtn.setBackground(Color.WHITE);
            }
        });
        
//sự kiện search
        this.searchInp.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                if(searchInp.getText().equals("Tìm kiếm phiếu nhập")){
                    searchInp.setText("");
                }
            }
        });
        
        this.searchInp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                dspn=bus.showSearch(searchInp.getText(), searchType.getSelectedItem().toString());
                show(dspn);
            }
        });
        
        this.searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                dspn=bus.showSearch(searchInp.getText(), searchType.getSelectedItem().toString());
                show(dspn);
            }
        });
        
// Hiện dialog chi tiết phiếu nhập
        this.tablePhieunhap.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent m){
        //lay dong va cot theo vi tri chuot
                int row = tablePhieunhap.rowAtPoint(m.getPoint());
                int col = tablePhieunhap.columnAtPoint(m.getPoint());
                if(col!=6){
                    showCt(bus.showCtpn(tablePhieunhap.getModel().getValueAt(row, 1).toString()));
                    ctpnDialog.setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Đã xóa phiếu nhập "+tablePhieunhap.getValueAt(row, 1).toString());
                    bus.xoaCtpn(tablePhieunhap.getValueAt(row, 1).toString());
                    bus.xoaPn(tablePhieunhap.getValueAt(row, 1).toString());
                    tablePhieunhap.repaint();
                    tablePhieunhap.revalidate();
                }
            }
        });
    
//Sự kiện lọc danh sách phiếu nhập
        this.sortFilter.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                show(bus.showSort(dspn, sortFilter.getSelectedItem().toString(), sortType.getSelectedItem().toString()));
            }
        });
        
        this.sortType.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                show(bus.showSort(dspn, sortFilter.getSelectedItem().toString(), sortType.getSelectedItem().toString()));
            }
        });
    }

    public void show(ArrayList<phieuNhapDTO> dto){
        dto = bus.showSort(dto, sortFilter.getSelectedItem().toString(), sortType.getSelectedItem().toString());

        int n = 0;
        DefaultTableModel model = (DefaultTableModel) this.tablePhieunhap.getModel();
        model.setRowCount(0);   
        
        for(phieuNhapDTO i : dto){
            n++;
            Object[] data = {n, i.getmaPn(), i.getmaKho(), i.getngayNhap(), i.gettongTien(), "Xóa"};
            model.addRow(data);
        }
        this.tablePhieunhap.updateUI();
    }
    
    public void showCt(ArrayList<ctphieuNhapDTO> dto){
        int n = 0;
        DefaultTableModel model = (DefaultTableModel) this.tableChitiet.getModel();
        model.setRowCount(0);
        
        for(ctphieuNhapDTO i : dto){
            n++;
            Object[] data = {n, i.getmaPn(), i.getmaNcc(), i.getsoLuong(), i.getdonGia(), i.gettamTinh()};
            model.addRow(data);
        }
        this.tableChitiet.updateUI();
    }
    
    public void Reupdate(){
        dspn = this.bus.showAll();
        show(dspn);
    }
    
    public JButton troVe(){
        return this.backBtn;
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ctpnDialog = new javax.swing.JDialog();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableChitiet = new javax.swing.JTable();
        searchBar = new javax.swing.JPanel();
        searchInp = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        panelPhieunhap = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePhieunhap = new javax.swing.JTable();
        sortFilter = new javax.swing.JComboBox<>();
        searchType = new javax.swing.JComboBox<>();
        sortType = new javax.swing.JComboBox<>();
        backBtn = new javax.swing.JButton();

        ctpnDialog.setLocationRelativeTo(panelPhieunhap);
        ctpnDialog.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        ctpnDialog.setTitle("Chi Tiết Phiếu Nhập");
        ctpnDialog.setAlwaysOnTop(true);
        ctpnDialog.setMaximumSize(new java.awt.Dimension(500, 600));
        ctpnDialog.setMinimumSize(new java.awt.Dimension(500, 600));
        ctpnDialog.setName("Chi Tiết Phiếu Nhập"); // NOI18N
        ctpnDialog.setPreferredSize(new java.awt.Dimension(500, 600));

        tableChitiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {
                "STT", "Mã Phiếu","Mã NCC",  "Số Lượng", "Đơn Giá", "Tạm Tính"
            }
        ));
        tableChitiet.setEnabled(false);
        jScrollPane2.setViewportView(tableChitiet);

        ctpnDialog.getContentPane().add(jScrollPane2, java.awt.BorderLayout.CENTER);

        ctpnDialog.getAccessibleContext().setAccessibleParent(panelPhieunhap);

        setBackground(new java.awt.Color(51, 51, 51));
        setMaximumSize(new java.awt.Dimension(1000, 700));
        setMinimumSize(new java.awt.Dimension(1000, 700));
        setPreferredSize(new java.awt.Dimension(1000, 700));

        searchBar.setPreferredSize(new java.awt.Dimension(350, 30));
        searchBar.setLayout(new java.awt.GridBagLayout());

        searchInp.setText("Tìm kiếm phiếu nhập");
        searchInp.setToolTipText("");
        searchInp.setPreferredSize(new java.awt.Dimension(300, 30));
        searchBar.add(searchInp, new java.awt.GridBagConstraints());

        searchBtn.setIcon(new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource("Comp/search.png")).getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
        searchBtn.setBorderPainted(false);
        searchBtn.setContentAreaFilled(false);
        searchBtn.setFocusPainted(false);
        searchBtn.setMargin(new java.awt.Insets(2, 2, 2, 2));
        searchBtn.setMaximumSize(new java.awt.Dimension(200, 200));
        searchBtn.setPreferredSize(new java.awt.Dimension(50, 30));
        searchBar.add(searchBtn, new java.awt.GridBagConstraints());

        panelPhieunhap.setPreferredSize(new java.awt.Dimension(450, 600));
        panelPhieunhap.setLayout(new java.awt.BorderLayout());

        tablePhieunhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object[][]{},
            new String [] {
                "STT","Mã Phiếu", "Mã Kho", "Ngày Nhập", "Tổng Tiền", "Xóa"
            }
        ));
        tablePhieunhap.setEnabled(false);
        jScrollPane1.setViewportView(tablePhieunhap);

        panelPhieunhap.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        sortFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã Phiếu", "Ngày Nhập" }));
        sortFilter.setName(""); // NOI18N
        sortFilter.setPreferredSize(new java.awt.Dimension(150, 30));

        searchType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tìm Theo", "Mã Phiếu", "Mã Kho", "Tổng Tiền" }));
        searchType.setPreferredSize(new java.awt.Dimension(80, 30));
        searchType.setSelectedIndex(0);

        sortType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tăng Dần", "Giảm Dần" }));
        sortType.setPreferredSize(new java.awt.Dimension(150, 30));

        backBtn.setBackground(new java.awt.Color(35, 134, 54));
        backBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        backBtn.setForeground(new java.awt.Color(255, 255, 255));
        backBtn.setText("Trở về");
        backBtn.setPreferredSize(new java.awt.Dimension(100, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(sortFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sortType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))))
            .addComponent(panelPhieunhap, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(searchType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sortFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sortType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(panelPhieunhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JDialog ctpnDialog;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panelPhieunhap;
    private javax.swing.JPanel searchBar;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField searchInp;
    private javax.swing.JComboBox<String> searchType;
    private javax.swing.JComboBox<String> sortFilter;
    private javax.swing.JComboBox<String> sortType;
    private javax.swing.JTable tableChitiet;
    private javax.swing.JTable tablePhieunhap;
    // End of variables declaration//GEN-END:variables
}
