package GUI;

import DAO.HoaDonDAO;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class mainGUI extends javax.swing.JFrame {
    private int working = -1;
    private String manvLogined;
    private NhanVienGUI nvGUI = new NhanVienGUI();
    private nhapHangGUI QLNhapHang = new nhapHangGUI();
    private phieuNhapGUI QLPhieuNhap = new phieuNhapGUI();
    private HoaDonDAO hdDAO = new HoaDonDAO();
    
   
    public mainGUI() {
        
        initComponents();
//thêm nút vào thanh công cụ và set màn hình được hiển thị khi nhấn nút
        //lưu file trong thư mục Comp xong ghi tên file vào đây → → → → ↓
        addComponent("TÀI KHOẢN", new TaiKhoanGUI(), "account.png");
        addComponent("KHÁCH HÀNG", new KhachHangGUI(), "steward.png");
//        addComponent("Thống Kê", new thongKeGUI(), "empty.png");
        addComponent("THỐNG KÊ SP", new thongKeSanPhamGUI(), "stats.png");
        addComponent("KHUYẾN MÃI", new khuyenMaiGUI(), "discount.png");
        addComponent("NHÂN VIÊN", new NhanVienGUI(), "customer.png");
        addComponent("HÓA ĐƠN", new HoaDonGUI(), "bill.png");
        addComponent("NHÀ CUNG CẤP", new NhaCungCapGUI(), "steward.png");
        addComponent("SẢN PHẨM", new SanPhamGUI(), "product.png");
        addComponent("NHẬP HÀNG", QLNhapHang, "import.png");

        
        solveEvent();
    }

//hàm thêm phần tử
    private void addComponent(String buttonName, JPanel panelName, String path) {
        int compQuantity = this.toolsPanel.getComponentCount();
        this.toolsPanel.setPreferredSize(new Dimension(this.toolsPanel.getWidth(), 50 * (compQuantity + 1)));
        JButton btn = new JButton(buttonName);
        btn.setPreferredSize(new Dimension(200, 50));
        btn.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        btn.setBackground(new Color(80, 130, 100));
        btn.setForeground(Color.white);
        btn.setFont(new Font(btn.getFont().getName(), Font.BOLD, 14));
        btn.setFocusPainted(false);
        btn.setContentAreaFilled(false);
        btn.setHorizontalAlignment(SwingConstants.LEFT);
        btn.setIconTextGap(30);
        if (path == null) {
            btn.setIcon(null);
        } else {
            btn.setIcon(new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource("Comp/" + path)).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
        }

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainDisplay.removeAll();
                mainDisplay.add(panelName);
                mainDisplay.repaint();
                mainDisplay.revalidate();
                title.setText(buttonName);
            }
        });
        
        btn.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            btn.setBackground(Color.WHITE); // Màu nền khi rê chuột vào
            btn.setForeground(new Color(80, 130, 100)); // Màu chữ khi rê chuột vào
        }

        @Override
        public void mouseExited(MouseEvent e) {
            btn.setBackground(new Color(80, 130, 100)); // Màu nền ban đầu
            btn.setForeground(Color.WHITE); // Màu chữ ban đầu
        }
    });
        this.toolsPanel.add(btn);
//        this.logo.requestFocusInWindow();
    }

    private void addComponent(String buttonName, JPanel panelName) {
        addComponent(buttonName, panelName, null);
    }

//xử lý sự kiện
    private void solveEvent() {
        String tendangnhap = Login.user;
        String matkhau = Login.pass;
        if(hdDAO.idactive(tendangnhap, matkhau)){
            this.manvLogined = hdDAO.getIDactive(tendangnhap, matkhau);//đổi thành phương thức get mã nhân viên
        }
        this.labelManv.setText(this.labelManv.getText() + this.manvLogined);

        logOut.setPreferredSize(new Dimension(50, 50));
        logOut.setForeground(Color.white);
        logOut.setFont(new Font(logOut.getFont().getName(), Font.BOLD, 14));
        logOut.setFocusPainted(false);
        logOut.setContentAreaFilled(false);

        logOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(mainGUI.this, "Bạn có muốn đăng xuất không", "Xác nhận đăng xuất", JOptionPane.YES_NO_OPTION);

                if (option == JOptionPane.YES_OPTION) {
                    String tendangnhap = Login.user;
                    String matkhau = Login.pass;
                    if(hdDAO.idUnactive1(tendangnhap, matkhau)){
                        SwingUtilities.windowForComponent(logoContainer).dispose();
                        Login lg = new Login();
                        lg.setLocationRelativeTo(null); // Đặt JFrame ra giữa màn hình
                        lg.setVisible(true);
                    }
                    
                }else{

                }

            }
        });

        for (int i = 0; i < this.toolsPanel.getComponentCount(); i++) {
            int tmp = i;
            this.toolsPanel.getComponent(i).addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (working >= 0) {
                        ((JButton) toolsPanel.getComponent(working)).setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
                    }
                    working = tmp;
                    ((JButton) toolsPanel.getComponent(tmp)).setBorder(BorderFactory.createMatteBorder(0, 5, 0, 0, Color.green));
                }
            });
        }

//xử lý giao diện nhập hàng và phiếu nhập
        this.QLNhapHang.openQlpn().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                mainDisplay.removeAll();
                mainDisplay.add(QLPhieuNhap);
                QLPhieuNhap.Reupdate();
                mainDisplay.repaint();
                mainDisplay.revalidate();
                title.setText("Quản Lý Phiếu Nhập");
                QLPhieuNhap.repaint();
                QLPhieuNhap.revalidate();
            }
        });
        
        this.QLPhieuNhap.troVe().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                mainDisplay.removeAll();
                mainDisplay.add(QLNhapHang);
                mainDisplay.repaint();
                mainDisplay.revalidate();
                title.setText("Quản Lý Nhập Hàng");
            }
        });
        
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Login lg = new Login();
                lg.setVisible(true);
                lg.setResizable(false);
                lg.setLocationRelativeTo(null);
            }
        });
//            private Login DangNhap = new Login();
//
//          DangNhap.setVisible(true);
//        mainGUI display = new mainGUI();
//        display.setVisible(true);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logoContainer = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        scrollBar = new javax.swing.JScrollPane();
        toolsPanel = new javax.swing.JPanel();
        mainDisplay = new javax.swing.JPanel();
        navBar = new javax.swing.JPanel();
        logOut = new javax.swing.JButton();
        labelManv = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý cửa hàng bán điện thoại");
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1200, 700));
        setResizable(false);

        logoContainer.setBackground(new java.awt.Color(35, 134, 54));
        logoContainer.setMaximumSize(new java.awt.Dimension(200, 100));
        logoContainer.setMinimumSize(new java.awt.Dimension(200, 100));
        logoContainer.setPreferredSize(new java.awt.Dimension(200, 50));
        logoContainer.setLayout(new java.awt.CardLayout());

        title.setBounds(navBar.getWidth()/2, this.title.getHeight()/2, this.title.getPreferredSize().width, this.title.getPreferredSize().height);
        title.setBackground(new java.awt.Color(0, 0, 0));
        title.setFont(new java.awt.Font("Verdana", 2, 12)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Quản Lý Cửa Hàng Điện Thoại");
        title.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        title.setPreferredSize(new java.awt.Dimension(300, 50));
        logoContainer.add(title, "card2");

        scrollBar.setBackground(new java.awt.Color(200, 200, 200));
        scrollBar.setBorder(null);
        scrollBar.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollBar.setPreferredSize(new java.awt.Dimension(200, 650));
        JScrollBar scb = new JScrollBar(JScrollBar.VERTICAL);
        scb.setPreferredSize(new Dimension(0,0));
        scrollBar.setVerticalScrollBar(scb);

        toolsPanel.setBackground(new java.awt.Color(1, 4, 9));
        toolsPanel.setMinimumSize(new java.awt.Dimension(0, 0));
        toolsPanel.setPreferredSize(new java.awt.Dimension(0, 0));
        toolsPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 0));
        scrollBar.setViewportView(toolsPanel);

        mainDisplay.setBackground(new java.awt.Color(51, 51, 51));
        mainDisplay.setMaximumSize(new java.awt.Dimension(1000, 700));
        mainDisplay.setMinimumSize(new java.awt.Dimension(1000, 10));
        mainDisplay.setPreferredSize(new java.awt.Dimension(1000, 650));
        mainDisplay.setLayout(new java.awt.BorderLayout());

        navBar.setBackground(new java.awt.Color(35, 134, 54));
        navBar.setPreferredSize(new java.awt.Dimension(1000, 50));

        logOut.setBackground(new java.awt.Color(204, 204, 204));
        logOut.setBorderPainted(false);
        logOut.setPreferredSize(new java.awt.Dimension(50, 50));

        labelManv.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labelManv.setForeground(new java.awt.Color(255, 255, 255));
        labelManv.setText("Mã:");
        labelManv.setToolTipText("");
        labelManv.setPreferredSize(new java.awt.Dimension(100, 50));

        logOut.setIcon(new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource("Comp/logout.png")).getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));

        javax.swing.GroupLayout navBarLayout = new javax.swing.GroupLayout(navBar);
        navBar.setLayout(navBarLayout);
        navBarLayout.setHorizontalGroup(
            navBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, navBarLayout.createSequentialGroup()
                .addContainerGap(830, Short.MAX_VALUE)
                .addComponent(labelManv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(logOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );
        navBarLayout.setVerticalGroup(
            navBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navBarLayout.createSequentialGroup()
                .addGroup(navBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelManv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(logoContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(navBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(scrollBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(mainDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(navBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(mainDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(logoContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(scrollBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelManv;
    private javax.swing.JButton logOut;
    private javax.swing.JPanel logoContainer;
    private javax.swing.JPanel mainDisplay;
    private javax.swing.JPanel navBar;
    private javax.swing.JScrollPane scrollBar;
    private javax.swing.JLabel title;
    private javax.swing.JPanel toolsPanel;
    // End of variables declaration//GEN-END:variables
}
