/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;


import BLL.CTHoaDonBLL;
import BLL.HoaDonBLL;
import BLL.SanPhamBLL;
import DAO.SanPhamDAO;
import DAO.HoaDonDAO;
import DTO.CTHoaDonDTO;
import DTO.HoaDonDTO;
import DTO.SanPhamDTO;
import java.awt.Image;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author PC
 */
public class MuaBanGUI extends javax.swing.JFrame {
    SanPhamBLL mbBLL=new SanPhamBLL();
 
    HoaDonBLL hdBLL = new HoaDonBLL();

    CTHoaDonBLL cthdBLL = new CTHoaDonBLL();
    
    HoaDonDAO hdDAO = new HoaDonDAO();

    ArrayList<CTHoaDonDTO> arrCTHD=new ArrayList<CTHoaDonDTO>();

    ArrayList<SanPhamDTO> arrSP=new ArrayList<SanPhamDTO>();

    ArrayList<HoaDonDTO> arrHD= hdBLL.getListHoaDon();

    DefaultTableModel modelMB = new DefaultTableModel() {
    @Override
    public boolean isCellEditable(int row, int column) {
        return false; // không cho phép chỉnh sửa giá trị các ô trong bảng
    }
    };

    DefaultTableModel modelGH = new DefaultTableModel() {
    @Override
    public boolean isCellEditable(int row, int column) {
        return false; // không cho phép chỉnh sửa giá trị các ô trong bảng
    }
    };
    /**
     * Creates new form MuaBan
     */
    public MuaBanGUI() {
        initComponents();
        //Khởi tạo bảng danh sách điện thoại
        jTable_DS.setModel(modelMB);
        modelMB.addColumn("STT");
        modelMB.addColumn("Mã điện thoại");
        modelMB.addColumn("Tên điện thoại");
        modelMB.addColumn("Hãng");
        modelMB.addColumn("Dung lượng");
        modelMB.addColumn("Số lượng");
        modelMB.addColumn("Đơn giá");
        modelMB.addColumn("Hình ảnh");
        modelMB.addColumn("Mức giảm giá");
        modelMB.addColumn("Giá sau giảm");
        //ẩn cột hình ảnh
        TableColumnModel columnModel = jTable_DS.getColumnModel();
        TableColumn column = columnModel.getColumn(7);
        column.setMinWidth(0);
        column.setMaxWidth(0);
        column.setPreferredWidth(0);
        column.setResizable(false);
        loadMBlist();
        //Khởi tạo bảng danh sách giỏ hàng
        
        jTable_GH.setModel(modelGH);
        modelGH.addColumn("STT");
        modelGH.addColumn("Mã điện thoại");
        modelGH.addColumn("Tên điện thoại");
        modelGH.addColumn("Hãng");
        modelGH.addColumn("Dung lượng");
        modelGH.addColumn("Số lượng");
        modelGH.addColumn("Mức giảm giá");
        modelGH.addColumn("Giá trước giảm");
        modelGH.addColumn("Giá sau giảm");
        modelGH.addColumn("Thành tiền trước giảm");
        modelGH.addColumn("Thành tiền sau giảm");

        TableColumnModel columnModelGH = jTable_GH.getColumnModel();
        TableColumn columnGH = columnModelGH.getColumn(1);
        columnGH.setMinWidth(0);
        columnGH.setMaxWidth(0);
        columnGH.setPreferredWidth(0);
        columnGH.setResizable(false);

     
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelHang = new javax.swing.JLabel();
        jLabelDungLuong = new javax.swing.JLabel();
        jLabelSoLuongMua = new javax.swing.JLabel();
        jLabelGia = new javax.swing.JLabel();
        jTextField_MDT = new javax.swing.JTextField();
        jTextField_TDT = new javax.swing.JTextField();
        jTextField_DL = new javax.swing.JTextField();
        jTextField_Gia = new javax.swing.JTextField();
        jSpinner_SL = new javax.swing.JSpinner();
        jButton_TVG = new javax.swing.JButton();
        jLabel_Anh = new javax.swing.JLabel();
        jButton_Xoa = new javax.swing.JButton();
        jLabelCTSP = new javax.swing.JLabel();
        jButton_XHD = new javax.swing.JButton();
        jLabelMucGiamGia = new javax.swing.JLabel();
        jTextField_MucGiamGia = new javax.swing.JTextField();
        jComboBox_Hang = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_GH = new javax.swing.JTable();
        jLabelGH = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_DS = new javax.swing.JTable();
        jLabelDSDT = new javax.swing.JLabel();
        jLabelMaDT = new javax.swing.JLabel();
        jLabelTenDT = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(1020, 770));

        jLabelHang.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabelHang.setForeground(new java.awt.Color(255, 255, 255));
        jLabelHang.setText("Hãng");

        jLabelDungLuong.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabelDungLuong.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDungLuong.setText("Dung lượng");

        jLabelSoLuongMua.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabelSoLuongMua.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSoLuongMua.setText("Số lượng");

        jLabelGia.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabelGia.setForeground(new java.awt.Color(255, 255, 255));
        jLabelGia.setText("Giá");

        jTextField_MDT.setBackground(new java.awt.Color(51, 51, 51));
        jTextField_MDT.setForeground(new java.awt.Color(255, 255, 255));
        jTextField_MDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_MDTActionPerformed(evt);
            }
        });

        jTextField_TDT.setBackground(new java.awt.Color(51, 51, 51));
        jTextField_TDT.setForeground(new java.awt.Color(255, 255, 255));

        jTextField_DL.setBackground(new java.awt.Color(51, 51, 51));
        jTextField_DL.setForeground(new java.awt.Color(255, 255, 255));

        jTextField_Gia.setBackground(new java.awt.Color(51, 51, 51));
        jTextField_Gia.setForeground(new java.awt.Color(255, 255, 255));

        jSpinner_SL.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        jButton_TVG.setBackground(new java.awt.Color(35, 134, 54));
        jButton_TVG.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton_TVG.setForeground(new java.awt.Color(255, 255, 255));
        jButton_TVG.setText("Thêm vào giỏ");
        jButton_TVG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_TVGActionPerformed(evt);
            }
        });

        jLabel_Anh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel_Anh.setPreferredSize(new java.awt.Dimension(200, 200));

        jButton_Xoa.setBackground(new java.awt.Color(35, 134, 54));
        jButton_Xoa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton_Xoa.setForeground(new java.awt.Color(255, 255, 255));
        jButton_Xoa.setText("Xóa");
        jButton_Xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_XoaActionPerformed(evt);
            }
        });

        jLabelCTSP.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabelCTSP.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCTSP.setText("CHI TIẾT SẢN PHẨM");

        jButton_XHD.setBackground(new java.awt.Color(35, 134, 54));
        jButton_XHD.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton_XHD.setForeground(new java.awt.Color(255, 255, 255));
        jButton_XHD.setText("Xuất hóa đơn");
        jButton_XHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_XHDActionPerformed(evt);
            }
        });

        jLabelMucGiamGia.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabelMucGiamGia.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMucGiamGia.setText("Mức giảm giá");

        jTextField_MucGiamGia.setBackground(new java.awt.Color(51, 51, 51));
        jTextField_MucGiamGia.setForeground(new java.awt.Color(255, 255, 255));

        jComboBox_Hang.setBackground(new java.awt.Color(51, 51, 51));
        jComboBox_Hang.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox_Hang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Iphone", "Samsung", "Nokia", "Xiaomi", "OPPO" }));

        jButton1.setBackground(new java.awt.Color(35, 134, 54));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("ĐĂNG XUẤT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable_GH.setBackground(new java.awt.Color(51, 51, 51));
        jTable_GH.setForeground(new java.awt.Color(255, 255, 255));
        jTable_GH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable_GH);

        jLabelGH.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabelGH.setForeground(new java.awt.Color(255, 255, 255));
        jLabelGH.setText("GIỎ HÀNG");

        jTable_DS.setBackground(new java.awt.Color(51, 51, 51));
        jTable_DS.setForeground(new java.awt.Color(255, 255, 255));
        jTable_DS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable_DS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_DSMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable_DS);

        jLabelDSDT.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabelDSDT.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDSDT.setText("DANH SÁCH ĐIỆN THOẠI");

        jLabelMaDT.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabelMaDT.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMaDT.setText("Mã điện thoại");

        jLabelTenDT.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabelTenDT.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTenDT.setText("Tên điện thoại");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelDSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 543, Short.MAX_VALUE)
                                .addComponent(jButton1))
                            .addComponent(jLabelGH)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabelCTSP)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabelMaDT)
                                                .addGap(30, 30, 30)
                                                .addComponent(jTextField_MDT, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabelTenDT)
                                                    .addComponent(jLabelDungLuong)
                                                    .addComponent(jLabelSoLuongMua)
                                                    .addComponent(jLabelGia)
                                                    .addComponent(jLabelHang)
                                                    .addComponent(jLabelMucGiamGia))
                                                .addGap(27, 27, 27)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jTextField_TDT)
                                                    .addComponent(jTextField_DL)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                            .addComponent(jTextField_Gia)
                                                            .addComponent(jSpinner_SL)
                                                            .addComponent(jTextField_MucGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGap(0, 0, Short.MAX_VALUE))
                                                    .addComponent(jComboBox_Hang, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(112, 112, 112)
                                        .addComponent(jButton_TVG)))))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(jButton_Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton_XHD)
                                .addGap(31, 31, 31))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel_Anh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDSDT)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabelCTSP)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelMaDT)
                            .addComponent(jTextField_MDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelTenDT)
                            .addComponent(jTextField_TDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelHang)
                            .addComponent(jComboBox_Hang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelDungLuong)
                            .addComponent(jTextField_DL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelSoLuongMua)
                            .addComponent(jSpinner_SL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField_MucGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabelMucGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelGia)
                            .addComponent(jTextField_Gia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addComponent(jButton_TVG)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelGH)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel_Anh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton_XHD)
                            .addComponent(jButton_Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1026, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_MDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_MDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_MDTActionPerformed

    private void jTable_DSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_DSMouseClicked
        int selectedRow = jTable_DS.getSelectedRow();
        if (selectedRow >= 0) {
        // Lấy thông tin của dòng được chọn
        String masp = jTable_DS.getValueAt(selectedRow, 1).toString();
        String tensp = jTable_DS.getValueAt(selectedRow, 2).toString();
        String hang = jTable_DS.getValueAt(selectedRow, 3).toString();
        String dungluong = jTable_DS.getValueAt(selectedRow, 4).toString();
        String gia = jTable_DS.getValueAt(selectedRow, 9).toString();
        String hinhanh = jTable_DS.getValueAt(selectedRow, 7).toString();
        String mucgiamgia=jTable_DS.getValueAt(selectedRow, 8).toString();

        // Cập nhật các trường văn bản và trường khác với thông tin của dòng được chọn
        jTextField_MDT.setText(masp);
        jTextField_TDT.setText(tensp);
        jComboBox_Hang.setSelectedItem(hang);
        jTextField_DL.setText(dungluong);
        jTextField_Gia.setText(gia);
        jTextField_MucGiamGia.setText(mucgiamgia);
        
        // Khóa (disable) các trường văn bản và trường khác
        jTextField_MDT.setEnabled(false);
        jTextField_TDT.setEnabled(false);
        jComboBox_Hang.setEnabled(false);
        jTextField_DL.setEnabled(false);
        jTextField_Gia.setEnabled(false);
        jTextField_MucGiamGia.setEnabled(false);
                
        
        File file = new File(hinhanh);
        ImageIcon imageIcon = new ImageIcon(file.getAbsolutePath());
        Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(scaledImage);
        jLabel_Anh.setIcon(scaledImageIcon);// TODO add your handling code here:
        }
    }//GEN-LAST:event_jTable_DSMouseClicked

    private void jButton_TVGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_TVGActionPerformed
                
            // Xử lý sự kiện khi nút "Thêm vào giỏ" được nhấn
        int selectedRow = jTable_DS.getSelectedRow(); // Lấy dòng được chọn từ bảng danh sách điện thoại
        if (selectedRow >= 0) {
            // Lấy thông tin của điện thoại được chọn từ dòng
            String maDienThoai = jTable_DS.getValueAt(selectedRow, 1).toString();
            String tenDienThoai = jTable_DS.getValueAt(selectedRow, 2).toString();
            String hang = jTable_DS.getValueAt(selectedRow, 3).toString();
            String dungLuong = jTable_DS.getValueAt(selectedRow, 4).toString();
            int soLuongCH = (int) jTable_DS.getValueAt(selectedRow, 5);
            int soLuong = (int) jSpinner_SL.getValue(); // Lấy giá trị từ JSpinner_SL
            float giaTruocGiam = Float.parseFloat(jTable_DS.getValueAt(selectedRow, 6).toString());
            float mucGiamGia = Float.parseFloat(jTable_DS.getValueAt(selectedRow, 8).toString());
            float giaSauGiam = Float.parseFloat(jTable_DS.getValueAt(selectedRow, 9).toString());

            // Kiểm tra xem mã sản phẩm đã tồn tại trong giỏ hàng hay chưa
            boolean daTonTai = false;

            for (int i = 0; i < modelGH.getRowCount(); i++) {
                if (modelGH.getValueAt(i, 1).toString().equals(maDienThoai)) {
                    // Mã sản phẩm đã tồn tại, tăng số lượng
                    int soLuongHienTai = (int) modelGH.getValueAt(i, 5);
                    int soLuongMoi = soLuongHienTai + soLuong;
                    modelGH.setValueAt(soLuongMoi, i, 5);
                    modelGH.setValueAt(soLuongMoi * giaSauGiam, i, 9); // Cập nhật thành tiền
                    modelGH.setValueAt(soLuongMoi * giaTruocGiam, i, 8); // Cập nhật thành tiền
                    daTonTai = true;
                    break;
                }
            }

            if (!daTonTai && soLuongCH > 0) {
                // Mã sản phẩm chưa tồn tại và số lượng còn > 0, thêm mới
                int stt = modelGH.getRowCount() + 1;
                Object[] row = {stt, maDienThoai, tenDienThoai, hang, dungLuong, soLuong, mucGiamGia,giaTruocGiam, giaSauGiam, soLuong * giaTruocGiam, soLuong*giaSauGiam};
                modelGH.addRow(row);
            } else if (soLuongCH == 0) {
                // Số lượng trong cửa hàng đã hết
                JOptionPane.showMessageDialog(this, "Sản phẩm đã hết trong cửa hàng");
            } else if (soLuong > soLuongCH) {
                // Số lượng mua vượt quá số lượng có sẵn trong cửa hàng
                JOptionPane.showMessageDialog(this, "Số lượng bạn muốn mua đã lớn hơn số lượng có sẵn trong cửa hàng.\nVui lòng nhập số nhỏ hơn.", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            }


            // Gọi phương thức để làm sạch các trường văn bản và combo box của điện thoại được chọn
//            clearSelectedPhoneFields();
                }
    }//GEN-LAST:event_jButton_TVGActionPerformed

    private void jButton_XoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_XoaActionPerformed
        int[] selectedRows = jTable_GH.getSelectedRows(); // Lấy mảng các dòng được chọn từ bảng giỏ hàng

        // Lặp qua mảng các dòng được chọn và xóa chúng từ bảng giỏ hàng
        for (int i = selectedRows.length - 1; i >= 0; i--) {
            int selectedRow = selectedRows[i];
            modelGH.removeRow(selectedRow);
            JOptionPane.showMessageDialog(this, "Xóa sản phẩm khỏi giỏ hàng thành công");
        }
    }//GEN-LAST:event_jButton_XoaActionPerformed

    private void jButton_XHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_XHDActionPerformed
if (modelGH.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Giỏ hàng trống. Vui lòng thêm sản phẩm vào giỏ hàng trước khi xuất hóa đơn.", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Tạo đối tượng Hóa đơn
        HoaDonDTO hoaDon = new HoaDonDTO();
        String maHoaDon = generateMaHD();
        hoaDon.setMaHD(maHoaDon);

        // Lấy ngày giờ hiện tại
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String ngayLap = now.format(formatter);

        hoaDon.setNgayLap(ngayLap);
        
        float tongGiaGoc = 0;
        float tongGiaSauGiam = 0;


        // Lặp qua các sản phẩm trong giỏ hàng và tạo đối tượng CTHoaDon
        arrCTHD.clear();
        for (int i = 0; i < modelGH.getRowCount(); i++) {
            CTHoaDonDTO cthd = new CTHoaDonDTO();
            cthd.setMaHD(maHoaDon);
            cthd.setMaSP(modelGH.getValueAt(i, 1).toString());
            cthd.setTenSP(modelGH.getValueAt(i, 2).toString());
            cthd.setSoLuong(Integer.parseInt(modelGH.getValueAt(i, 5).toString()));
            cthd.setDonGia(Float.parseFloat(modelGH.getValueAt(i, 9).toString()));
            float thanhTien = Integer.parseInt(modelGH.getValueAt(i, 5).toString()) * Float.parseFloat(modelGH.getValueAt(i, 9).toString());
            tongGiaGoc += thanhTien;
            float thanhTien1 = Integer.parseInt(modelGH.getValueAt(i, 5).toString()) * Float.parseFloat(modelGH.getValueAt(i, 10).toString());
            tongGiaSauGiam += thanhTien1;
            arrCTHD.add(cthd);
        }

        // Gán danh sách chi tiết hóa đơn cho hóa đơn
        hoaDon.setDsCTHD(arrCTHD);
        String ma = hdDAO.getMaTK();
        hoaDon.setMaKH(ma);
        
        hoaDon.setMaNV(null);
        hoaDon.setNgayGiao(null);
        hoaDon.setTongTienGoc(tongGiaGoc);
        hoaDon.setTongTienSauGiam(tongGiaSauGiam);


        // Thêm hóa đơn vào CSDL
        String resultMessage = hdBLL.addHoaDon(hoaDon, arrCTHD);

        // Hiển thị thông báo dựa trên kết quả từ hàm addHoaDon
        JOptionPane.showMessageDialog(this, resultMessage, "Thông báo", JOptionPane.INFORMATION_MESSAGE);

        // Nếu thêm thành công, thêm hóa đơn vào arrHD và xóa dữ liệu trong giỏ hàng
        if (resultMessage.equals("Thêm hóa đơn thành công")) {
            arrHD.add(hoaDon); // Thêm hóa đơn vào danh sách
            modelGH.setRowCount(0);
        }



    }//GEN-LAST:event_jButton_XHDActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
                int option = JOptionPane.showConfirmDialog(MuaBanGUI.this, "Bạn có muốn đăng xuất không", "Xác nhận đăng xuất", JOptionPane.YES_NO_OPTION);

                if (option == JOptionPane.YES_OPTION) {
                    String tendangnhap = Login.user;
                    String matkhau = Login.pass;
                    if(hdDAO.idUnactive1(tendangnhap, matkhau)){
                        SwingUtilities.windowForComponent(jButton1).dispose();
                        Login lg = new Login();
                        lg.setLocationRelativeTo(null); // Đặt JFrame ra giữa màn hình
                        lg.setVisible(true);
                    }
                    
                }else{

                }
    }//GEN-LAST:event_jButton1ActionPerformed
    
    public void loadMBlist(){
        arrSP = mbBLL.getListSanphamWithDiscount();
//        int a = arrSP.size();
//        System.out.print(rootPaneCheckingEnabled);
        for(int i = modelMB.getRowCount()-1;i>=0;i--)
            modelMB.removeRow(i);
        for(int i = 0; i<arrSP.size();i++){
            SanPhamDTO em= arrSP.get(i);
            int stt= i+1;
            String masp= em.getMaSP();
            String tensp = em.getTenSP();
            String hang = em.getHang();
            String dungluong = em.getDungLuong();
            int soluong=em.getSoLuong();
            long dongia=em.getDonGia();
            String hinhanh = em.getHinhAnh();
            long mucgiamgia=(long) em.getMucGiamGia();
            float giasaugiam=em.getGiaSauGiam();
            Object[] row = {stt,masp,tensp,hang,dungluong,soluong,dongia,hinhanh,mucgiamgia,giasaugiam};
            modelMB.addRow(row);
        }
    }
    
    private void clearSelectedPhoneFields() {
        // Các trường văn bản và combo box
        jTextField_MDT.setText("");
        jTextField_TDT.setText("");
        jComboBox_Hang.setSelectedIndex(0);
        jTextField_DL.setText("");
        jTextField_Gia.setText("");
        jTextField_MucGiamGia.setText("");
        jSpinner_SL.setValue(0);

        // Kích hoạt các trường để người dùng có thể chọn điện thoại mới
        jTextField_MDT.setEnabled(true);
        jTextField_TDT.setEnabled(true);
        jComboBox_Hang.setEnabled(true);
        jTextField_DL.setEnabled(true);
        jTextField_Gia.setEnabled(true);
        jTextField_MucGiamGia.setEnabled(true);
    }
    
    private String generateMaHD() {
        if (arrHD.size() == 0) {
            return "HD001";
        } else {
            HoaDonDTO lastHD = arrHD.get(arrHD.size() - 1);
            String lastMaHD = lastHD.getMaHD();
            int lastID = Integer.parseInt(lastMaHD.substring(2)); // Lấy phần số từ mã hiện tại
            int newID = lastID + 1;
            String newMaHD = "HD" + String.format("%03d", newID); // Format mã mới với đủ 3 chữ số
            return newMaHD;
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MuaBanGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MuaBanGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MuaBanGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MuaBanGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MuaBanGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton_TVG;
    private javax.swing.JButton jButton_XHD;
    private javax.swing.JButton jButton_Xoa;
    private javax.swing.JComboBox<String> jComboBox_Hang;
    private javax.swing.JLabel jLabelCTSP;
    private javax.swing.JLabel jLabelDSDT;
    private javax.swing.JLabel jLabelDungLuong;
    private javax.swing.JLabel jLabelGH;
    private javax.swing.JLabel jLabelGia;
    private javax.swing.JLabel jLabelHang;
    private javax.swing.JLabel jLabelMaDT;
    private javax.swing.JLabel jLabelMucGiamGia;
    private javax.swing.JLabel jLabelSoLuongMua;
    private javax.swing.JLabel jLabelTenDT;
    private javax.swing.JLabel jLabel_Anh;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner_SL;
    private javax.swing.JTable jTable_DS;
    private javax.swing.JTable jTable_GH;
    private javax.swing.JTextField jTextField_DL;
    private javax.swing.JTextField jTextField_Gia;
    private javax.swing.JTextField jTextField_MDT;
    private javax.swing.JTextField jTextField_MucGiamGia;
    private javax.swing.JTextField jTextField_TDT;
    // End of variables declaration//GEN-END:variables
}