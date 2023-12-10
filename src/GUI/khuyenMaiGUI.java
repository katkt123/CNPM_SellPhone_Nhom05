package GUI;
import DAO.khuyenMaiDAO;
import BLL.KhuyenMaiBLL;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JOptionPane;
import DTO.khuyenMaiDTO;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class khuyenMaiGUI extends javax.swing.JPanel {
    khuyenMaiDAO kmdao = new khuyenMaiDAO();
    private KhuyenMaiBLL KhuyenMaiBLL;

    public khuyenMaiGUI() {
        initComponents();

        KhuyenMaiBLL = new KhuyenMaiBLL();
        showALL(); 
        jTextField3.setVisible(false);
        Formdcs.setDateFormatString("yyyy-MM-dd");
        Todcs.setDateFormatString("yyyy-MM-dd");
        jTextField1.setText(kmdao.initIDKM());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        buttonGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        searchkmtf = new javax.swing.JTextField();
        searchkmbtn = new javax.swing.JButton();
        createbtn = new javax.swing.JButton();
        deletebtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        Formdcs = new com.toedter.calendar.JDateChooser();
        Todcs = new com.toedter.calendar.JDateChooser();

        jDialog1.setTitle("Tạo Khuyến Mãi");
        jDialog1.setMinimumSize(new java.awt.Dimension(445, 315));

        jLabel1.setText("Hãng:");

        jLabel2.setText("Mã khuyến mãi:");

        jLabel3.setText("Tên khuyến mãi:");

        jTextField1.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(153, 153, 153));
        jTextField1.setEnabled(false);
        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField1FocusLost(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Iphone", "Samsung", "Xiaomi", "Oppo", "Nokia" }));

        jButton1.setText("LÀM MỚI");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("TẠO ");

        jLabel5.setText("Mức giảm giá:");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10%", "20%", "30%", "40%", "50%", "60%", "70%", "80%", "90%" }));

        jLabel6.setText("Thời gian áp dụng:");

        jDateChooser1.setToolTipText("");
        jDateChooser1.setDateFormatString("dd/MM/yyyy");

        jDateChooser2.setDateFormatString("dd/MM/yyyy");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jDialog1Layout.createSequentialGroup()
                        .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                            .addComponent(jTextField1)))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))
                    .addGroup(jDialog1Layout.createSequentialGroup()
                        .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDialog1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jDialog1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(3, 3, 3)))
                .addGroup(jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        buttonGroup.add(jRadioButton1);
        buttonGroup.add(jRadioButton2);
        buttonGroup.add(jRadioButton3);

        setMaximumSize(new java.awt.Dimension(1000, 700));
        setMinimumSize(new java.awt.Dimension(1000, 700));
        setPreferredSize(new java.awt.Dimension(1000, 700));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        searchkmtf.setForeground(new java.awt.Color(153, 153, 153));
        searchkmtf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchkmtfFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchkmtfFocusLost(evt);
            }
        });

        searchkmbtn.setBackground(new java.awt.Color(35, 134, 54));
        searchkmbtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        searchkmbtn.setForeground(new java.awt.Color(255, 255, 255));
        searchkmbtn.setText("Tìm kiếm");

        createbtn.setBackground(new java.awt.Color(35, 134, 54));
        createbtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        createbtn.setForeground(new java.awt.Color(255, 255, 255));
        createbtn.setText("Thêm khuyến mãi");

        deletebtn.setBackground(new java.awt.Color(35, 134, 54));
        deletebtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        deletebtn.setForeground(new java.awt.Color(255, 255, 255));
        deletebtn.setText("Xóa khuyến mãi");

        jScrollPane1.setEnabled(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã CTKM", "Tên CTKM", "Mức giảm giá", "Loại sản phẩm", "Thời gian bắt đầu", "Thời gian kết thúc", "Thời gian tạo"
            }
        )
        {
            public boolean isCellEditable(int row, int column){
                return false;
            }
        }
    );
    jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    jScrollPane1.setViewportView(jTable1);

    jPanel2.setBackground(new java.awt.Color(255, 255, 255));
    jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

    jLabel8.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
    jLabel8.setText("Trạng thái");

    jRadioButton1.setBackground(new java.awt.Color(255, 255, 255));
    jRadioButton1.setText("Tất cả");

    jRadioButton2.setBackground(new java.awt.Color(255, 255, 255));
    jRadioButton2.setText("Hết hiệu lực");

    jRadioButton3.setBackground(new java.awt.Color(255, 255, 255));
    jRadioButton3.setText("Còn hiệu lực");

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jRadioButton1)
                .addComponent(jRadioButton2)
                .addComponent(jRadioButton3))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanel2Layout.setVerticalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup()
            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jRadioButton1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jRadioButton3)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jRadioButton2)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(24, 24, 24)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 942, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(searchkmtf, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(searchkmbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(56, 56, 56)
                            .addComponent(createbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(deletebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(Formdcs, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(Todcs, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))))
            .addContainerGap(32, Short.MAX_VALUE))
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(searchkmtf, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(searchkmbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(deletebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(createbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(24, 24, 24)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(Formdcs, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                        .addComponent(Todcs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(49, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 33, Short.MAX_VALUE))
    );
    }// </editor-fold>//GEN-END:initComponents

    private void searchkmtfFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchkmtfFocusGained
//        if (searchkmtf.getText().equals("Tìm kiếm khuyến mãi")) {
//            searchkmtf.setText("");
//            searchkmtf.setForeground(Color.BLACK); // Đổi màu về đen khi tập trung
//        }
    }//GEN-LAST:event_searchkmtfFocusGained

    private void searchkmtfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchkmtfFocusLost
//        if (searchkmtf.getText().isEmpty()) {
//            searchkmtf.setForeground(Color.GRAY); // Đổi màu về màu placeholder
//            searchkmtf.setText("Tìm kiếm khuyến mãi"); // Đặt văn bản placeholder
//        }
    }//GEN-LAST:event_searchkmtfFocusLost

    private void jTextField1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusGained
//        if (jTextField1.getText().equals("00001(5 số)")) {
//            jTextField1.setText("");
//            jTextField1.setForeground(Color.BLACK); // Đổi màu về đen khi tập trung
//        }
    }//GEN-LAST:event_jTextField1FocusGained

    private void jTextField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusLost
//        if (jTextField1.getText().isEmpty()) {
//            jTextField1.setForeground(Color.GRAY); // Đổi màu về màu placeholder
//            jTextField1.setText("00001(5 số)"); // Đặt văn bản placeholder
//        }
    }//GEN-LAST:event_jTextField1FocusLost

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jTextField1.setText(null);
        if (jTextField1.getText().isEmpty()) {
            jTextField1.setForeground(Color.GRAY); // Đổi màu về màu placeholder
            jTextField1.setText("00001(5 số)"); // Đặt văn bản placeholder
        }
        jTextField2.setText(null);
        jTextField3.setText(null);
        jComboBox1.setSelectedItem("Iphone");
        jComboBox2.setSelectedItem("10%");   
        jDateChooser1.setDate(null);
        jDateChooser2.setDate(null);
    }//GEN-LAST:event_jButton1ActionPerformed
       
    
   
    
    private void taokhuyemai() {
        createbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                // Đặt jDialog1 thành cửa sổ modal
                jDialog1.setModal(true);

                // Đặt vị trí của JDialog ở giữa màn hình
                jDialog1.setLocationRelativeTo(null);

                // Hiển thị jDialog1
                jDialog1.setVisible(true);
            }
        });
    }
    
    private void tao() {
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                // Lấy dữ liệu từ các trường nhập liệu và tạo đối tượng DTO
                
                String maKhuyenMai = jTextField1.getText();
                String tenKhuyenMai = jTextField2.getText();
                int mucGiamGia = Integer.parseInt(jComboBox2.getSelectedItem().toString().replace("%", ""));
                String loaiKhuyenMai = jComboBox1.getSelectedItem().toString();
                Date ngayBatDau = jDateChooser1.getDate();
                Date ngayKetThuc = jDateChooser2.getDate();
                String MaSanPham = jTextField3.getText();
                khuyenMaiDTO khuyenMai = new khuyenMaiDTO(maKhuyenMai, tenKhuyenMai, mucGiamGia, loaiKhuyenMai, ngayBatDau, ngayKetThuc, MaSanPham);

                // Gọi phương thức DAO để thêm dữ liệu vào cơ sở dữ liệu
                boolean themThanhCong = KhuyenMaiBLL.themKhuyenMai(khuyenMai);

                if (themThanhCong) {
//                    JOptionPane.showMessageDialog(khuyenMaiGUI.this, "Đã tạo khuyến mãi: " + khuyenMai.getTenKhuyenMai(), "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    jLabel4.setText("Đã tạo khuyến mãi thành công");
                    // Xóa dữ liệu sau khi thêm thành công (nếu cần)
                    jTextField1.setText("");
                    jTextField2.setText("");
                    jComboBox1.setSelectedIndex(0);
                    jComboBox2.setSelectedIndex(0);
                    jDateChooser1.setDate(null);
                    jDateChooser2.setDate(null);
//                    jTextField3.setText("");
                    KhuyenMaiBLL.loadKhuyenMaiData(jTable1);
                }
//                else {
//                    JOptionPane.showMessageDialog(khuyenMaiGUI.this, "Vui lòng nhập lại thông tin", "Thông báo", JOptionPane.ERROR_MESSAGE);
//                }
            }
        });
    }
    
    
    
    private void xoa() {
        deletebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String maKhuyenMaiCanXoa = searchkmtf.getText(); // Lấy mã khuyến mãi cần xóa từ giao diện
                
                if(maKhuyenMaiCanXoa.equals("")){
                    JOptionPane.showMessageDialog(khuyenMaiGUI.this, "Vui lòng chọn khuyến mãi cần xóa" + maKhuyenMaiCanXoa, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                } else{
                    // Hiển thị hộp thoại xác nhận
                    int option = JOptionPane.showConfirmDialog(khuyenMaiGUI.this, "Bạn có chắc chắn muốn xóa khuyến mãi có mã: " + maKhuyenMaiCanXoa + "?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);

                    if (option == JOptionPane.YES_OPTION) {
                        // Gọi phương thức DAO để xóa khuyến mãi
                        boolean xoaThanhCong = KhuyenMaiBLL.xoaKhuyenMai(maKhuyenMaiCanXoa);

                        if (xoaThanhCong) {
                            JOptionPane.showMessageDialog(khuyenMaiGUI.this, "Đã xóa khuyến mãi có mã: " + maKhuyenMaiCanXoa, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                            // Cập nhật giao diện hoặc làm bất kỳ điều gì cần thiết sau khi xóa thành công
                            KhuyenMaiBLL.loadKhuyenMaiData(jTable1);
                        } else {
                            JOptionPane.showMessageDialog(khuyenMaiGUI.this, "Lỗi khi xóa khuyến mãi", "Thông báo", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        });
    }

    private void timkiem() {
        searchkmbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String timkiem = searchkmtf.getText();
//                String from = sdf.format(Formdcs.getDate());
//                String to = sdf.format(Todcs.getDate());
                // Lấy ngày từ JDateChooser
                Date from = Formdcs.getDate();
                if(from != null){
                    // Chuyển đổi Date thành LocalDate
                    LocalDate localFromDate = new java.sql.Date(from.getTime()).toLocalDate();

                    // Lùi ngày đi một ngày
                    LocalDate previousDay = localFromDate.minusDays(1);

                    // Chuyển đổi lại thành kiểu Date
                    Date newFromDate = java.sql.Date.valueOf(previousDay);
                    
                    Date to = Todcs.getDate();

                    KhuyenMaiBLL.searchKhuyenMai(jTable1, timkiem, newFromDate, to); 
                }else{
                    Date to = Todcs.getDate();

                    KhuyenMaiBLL.searchKhuyenMai(jTable1, timkiem, from, to); 
                }



            }
        });
    }
    
    private void chon(){
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    int selectedRow = jTable1.getSelectedRow();
                    if (selectedRow != -1) {
                        // Lấy giá trị "Mã CTKM" từ dòng được chọn
                        Object maCTKM = jTable1.getValueAt(selectedRow, 0);
                        // Đặt giá trị "Mã CTKM" vào JTextField
                        searchkmtf.setText(maCTKM.toString());
                        searchkmtf.setForeground(Color.BLACK); // Đổi màu về màu placeholder
                    } else {
                        // Nếu không có dòng nào được chọn, làm mới JTextField
                        searchkmtf.setText("");
                        searchkmtf.setForeground(Color.GRAY); // Đổi màu về màu placeholder
                    }
                }
            }
        });
    }
    
    private void trangthai(){
        jRadioButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                KhuyenMaiBLL.loadKhuyenMaiData(jTable1);
                searchkmtf.setText(null);
                Formdcs.setDate(null);
                Todcs.setDate(null);
            }
        });

        jRadioButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Hiển thị khuyến mãi còn hạn
                KhuyenMaiBLL.loadExpiredData(jTable1);
                searchkmtf.setText(null);
                Formdcs.setDate(null);
                Todcs.setDate(null);
            }
        });

        jRadioButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Hiển thị khuyến mãi đã hết hạn
                KhuyenMaiBLL.loadValidData(jTable1);
                searchkmtf.setText(null);
                Formdcs.setDate(null);
                Todcs.setDate(null);
            }
        });
    }
    
    private void apdung(){

    }
    
    private void showALL(){
        KhuyenMaiBLL.loadKhuyenMaiData(jTable1);
        taokhuyemai();
        tao();
        xoa();
        timkiem();
        chon();
        trangthai();
    }







    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser Formdcs;
    private com.toedter.calendar.JDateChooser Todcs;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JButton createbtn;
    private javax.swing.JButton deletebtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JButton searchkmbtn;
    private javax.swing.JTextField searchkmtf;
    // End of variables declaration//GEN-END:variables
}
