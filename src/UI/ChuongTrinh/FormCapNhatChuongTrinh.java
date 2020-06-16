/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.ChuongTrinh;

import BUS.bus_ChuongTrinh;
import DTO.dto_ChungChi;
import DTO.dto_ChuongTrinh;
import DTO.dto_ChuongTrinh_ChungChi;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class FormCapNhatChuongTrinh extends javax.swing.JFrame {

    /**
     * Creates new form CapNhatChuongTrinh
     */
    private dto_ChuongTrinh_ChungChi ct_cc;
    private DefaultComboBoxModel static_dfcChungChi;

    public FormCapNhatChuongTrinh() {
        initComponents();
        setResizable(false);
    }

    public FormCapNhatChuongTrinh(dto_ChuongTrinh_ChungChi ct_cc) {
        initComponents();
        setResizable(false);
        this.ct_cc = ct_cc;
        setupForm();

    }

    // HÀM CẬP NHẬT LẠI CHƯƠNG TRÌNH
    public void capNhatChuongTrinh() {

        dto_ChuongTrinh ct = new dto_ChuongTrinh();
        ct = layThongTinNhap();

        if (ct != null) {

            int rs = new bus_ChuongTrinh().capNhatChuongTrinh(ct);

            if (rs == 0) {
                JOptionPane.showMessageDialog(null, "Thất Bại");
            } else {

                UI_ChuongTrinh.hienThiDsChuongTrinh(1);
                JOptionPane.showMessageDialog(null, "Hoàn Tất");
            }
        }
    }

    // HÀM LẤY GIÁ TRỊ NHẬP VÀO
    public dto_ChuongTrinh layThongTinNhap() {

        dto_ChuongTrinh ct = null;

        String strTen = txtTenCt.getText();
        String strDiemDauVao = txtDiemDauVao.getText();
        String strDiemDauRa = txtDiemDauRa.getText();
        Float diemToiDa = Float.parseFloat(txtDiemToiDa.getText());

        boolean isCkNghe = ckNghe.isSelected();
        boolean isCkNoi = ckNoi.isSelected();
        boolean isCkDoc = ckDoc.isSelected();
        boolean isCkViet = ckViet.isSelected();

        boolean isCkTinhTong = radCong.isSelected();
        boolean isCkTinhTrungBinhCong = radTrungBinhCong.isSelected();

        boolean isCkDong = radDong.isSelected();
        boolean isCkMo = radMo.isSelected();

        String strNoiDung = txtNoiDung.getText();

        int kqkt = kiemTraThongTinNhap(diemToiDa, strTen, strDiemDauVao, strDiemDauRa, isCkNghe, isCkNoi, isCkDoc, isCkViet, isCkTinhTong, isCkTinhTrungBinhCong, strNoiDung, isCkDong, isCkMo);

        if (kqkt == 0) {
            JOptionPane.showMessageDialog(null, "Chưa nhập đủ thông tin");
        } else if (kqkt == 1) {
            JOptionPane.showMessageDialog(null, "Điểm nhập vào không hợp lệ");

        } else if (kqkt == 2) {

            Float diemDauRa = 0F;
            Float diemDauVao = 0F;

            try {

                diemDauVao = Float.parseFloat(strDiemDauVao);
                diemDauRa = Float.parseFloat(strDiemDauRa);
            } catch (Exception ex) {

                ex.printStackTrace();
            }

            ct = new dto_ChuongTrinh();

            ct.setMaCt(ct_cc.getMaCt());
            ct.setTenCt(strTen);
            ct.setDiemDauVao(diemDauVao);
            ct.setDiemDauRa(diemDauRa);
            ct.setNoiDung(strNoiDung);

            if (isCkNghe == true) {
                ct.setTinhNghe(1);
            } else {
                ct.setTinhNghe(0);
            }

            if (isCkNoi == true) {
                ct.setTinhNoi(1);
            } else {
                ct.setTinhNoi(0);
            }

            if (isCkDoc == true) {
                ct.setTinhDoc(1);
            } else {
                ct.setTinhDoc(0);
            }

            if (isCkViet == true) {
                ct.setTinhViet(1);
            } else {
                ct.setTinhViet(0);
            }

            if (isCkTinhTong == true) {
                ct.setCachTinhDiem(1);
            } else {
                ct.setCachTinhDiem(2);
            }

            if (isCkDong == true) {
                ct.setTrangThai(0);
            } else {
                ct.setTrangThai(1);
            }
        }
        return ct;

    }

    // HÀM KIỂM TRA THÔNG TIN NHẬP VÀO: 0 là thông tin nhập chưa đủ, 1-chuyển đổi số thất bại, 2-Thông tin nhập không hợp lệ, 3-thành công
    public int kiemTraThongTinNhap(Float diemToiDa, String strTen, String diemDauVao, String diemDauRa, boolean ckNghe, boolean ckNoi, boolean ckDoc, boolean ckViet, boolean ckTong, boolean ckTrungBinhCong, String noiDung, boolean ckDong, boolean ckMo) {

        if (ckNghe == ckNoi == ckDoc == ckViet == ckTong == ckTrungBinhCong == ckDong == ckMo == false) {
            return 0;
        }

        if (strTen.isEmpty() || diemDauVao.isEmpty() || diemDauRa.isEmpty() || noiDung.isEmpty()) {
            return 0;
        } else {

            Float dauRa;
            Float dauVao;

            try {
                dauVao = Float.parseFloat(diemDauVao);
                dauRa = Float.parseFloat(diemDauRa);
            } catch (Exception ex) {
                System.out.println("Chuyển đổi sang số thất bại");
                return 1; // Thông tin nhập không hợp lệ.
            }

            if (dauRa <= dauVao || dauRa > diemToiDa) {
                return 1; // thông tin nhập không hợp lệ
            }

        }

        return 2;//thanh cong

    }

    // HÀM SETUP FORM
    public void setupForm() {
        ButtonGroup btnGroup = new ButtonGroup();
        btnGroup.add(radCong);
        btnGroup.add(radTrungBinhCong);

        ButtonGroup btnGroupTrangThai = new ButtonGroup();
        btnGroupTrangThai.add(radDong);
        btnGroupTrangThai.add(radMo);
        static_dfcChungChi = new DefaultComboBoxModel();
        static_dfcChungChi.addElement(ct_cc);
        cbTenCc.setModel(static_dfcChungChi);

        cbTenCc.setSelectedItem(1);
        cbTenCc.setEnabled(false);

        txtTenCt.setText(ct_cc.getTenCt());
        txtDiemDauVao.setText(ct_cc.getDiemDauVao() + "");
        txtDiemDauRa.setText(ct_cc.getDiemDauRa() + "");
        txtNoiDung.setText(ct_cc.getNoiDung());

        if (ct_cc.getTinhNghe() == 1) {
            ckNghe.setSelected(true);
        }

        if (ct_cc.getTinhNoi() == 1) {
            ckNoi.setSelected(true);
        }

        if (ct_cc.getTinhDoc() == 1) {
            ckDoc.setSelected(true);
        }

        if (ct_cc.getTinhViet() == 1) {
            ckViet.setSelected(true);
        }

        if (ct_cc.getCachTinhDiem() == 1) {
            radCong.setSelected(true);
        } else {
            radTrungBinhCong.setSelected(true);
        }

        if (ct_cc.getTrangThai() == 1) {
            radMo.setSelected(true);
        } else {
            radDong.setSelected(true);
        }

        txtMaCc.setText(ct_cc.getMaCc() + "");
        txtDiemToiDa.setText(ct_cc.getDiemToiDa() + "");
        lblLogo.setIcon(new ImageIcon(ct_cc.getSrcImg()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnThem = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTenCt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtNoiDung = new javax.swing.JTextArea();
        btnXacNhan = new javax.swing.JButton();
        txtDiemDauVao = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDiemDauRa = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbTenCc = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        ckNghe = new javax.swing.JCheckBox();
        ckNoi = new javax.swing.JCheckBox();
        ckDoc = new javax.swing.JCheckBox();
        ckViet = new javax.swing.JCheckBox();
        radCong = new javax.swing.JRadioButton();
        radTrungBinhCong = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        txtMaCc = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtDiemToiDa = new javax.swing.JTextField();
        lblLogo = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        radDong = new javax.swing.JRadioButton();
        radMo = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cập Nhật Chương Trình");

        pnThem.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Cập Nhật");

        jLabel2.setText("Tên Chương Trình");

        jLabel3.setText("Điểm Đầu Vào");

        txtTenCt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel4.setText("Ghi Chú");

        txtNoiDung.setColumns(20);
        txtNoiDung.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        txtNoiDung.setRows(5);
        txtNoiDung.setPreferredSize(new java.awt.Dimension(150, 74));
        jScrollPane1.setViewportView(txtNoiDung);

        btnXacNhan.setBackground(new java.awt.Color(91, 155, 213));
        btnXacNhan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnXacNhan.setForeground(new java.awt.Color(255, 255, 255));
        btnXacNhan.setText("XÁC NHẬN");
        btnXacNhan.setContentAreaFilled(false);
        btnXacNhan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXacNhan.setFocusable(false);
        btnXacNhan.setOpaque(true);
        btnXacNhan.setPreferredSize(new java.awt.Dimension(209, 40));
        btnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanActionPerformed(evt);
            }
        });

        txtDiemDauVao.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtDiemDauVao.setForeground(new java.awt.Color(0, 102, 153));
        txtDiemDauVao.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel5.setText("Điểm Đầu Ra");

        txtDiemDauRa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtDiemDauRa.setForeground(new java.awt.Color(0, 102, 153));
        txtDiemDauRa.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel6.setText("Chứng Chỉ");

        cbTenCc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbTenCc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbTenCc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTenCcActionPerformed(evt);
            }
        });

        jLabel7.setText("Cách Tính Tổng Điểm Thành Phần");

        jLabel8.setText("Điểm Thành Phần");

        ckNghe.setText("Nghe");

        ckNoi.setText("Nói");

        ckDoc.setText("Đọc");

        ckViet.setText("Viết");

        radCong.setBackground(new java.awt.Color(255, 255, 255));
        radCong.setText("Cộng Tất Cả");

        radTrungBinhCong.setBackground(new java.awt.Color(255, 255, 255));
        radTrungBinhCong.setText("Trung Bình Cộng");

        jLabel9.setText("Mã Chứng Chỉ");

        txtMaCc.setEditable(false);
        txtMaCc.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel10.setText("Điểm Tối Đa");

        txtDiemToiDa.setEditable(false);
        txtDiemToiDa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtDiemToiDa.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ielts.png"))); // NOI18N
        lblLogo.setText("ẢNH");

        jLabel11.setText("Trạng Thái");

        radDong.setBackground(new java.awt.Color(255, 255, 255));
        radDong.setText("Đóng ");

        radMo.setBackground(new java.awt.Color(255, 255, 255));
        radMo.setText("Mở");

        javax.swing.GroupLayout pnThemLayout = new javax.swing.GroupLayout(pnThem);
        pnThem.setLayout(pnThemLayout);
        pnThemLayout.setHorizontalGroup(
            pnThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnThemLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(241, 241, 241))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnThemLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnThemLayout.createSequentialGroup()
                        .addGroup(pnThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnThemLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1))
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnThemLayout.createSequentialGroup()
                        .addGroup(pnThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cbTenCc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(pnThemLayout.createSequentialGroup()
                                    .addGroup(pnThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(pnThemLayout.createSequentialGroup()
                                            .addComponent(txtMaCc, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnThemLayout.createSequentialGroup()
                                            .addComponent(jLabel9)
                                            .addGap(100, 100, 100)))
                                    .addGroup(pnThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel10)
                                        .addComponent(txtDiemToiDa, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addGroup(pnThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTenCt, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnThemLayout.createSequentialGroup()
                                            .addGroup(pnThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel2)
                                                .addComponent(jLabel7)
                                                .addGroup(pnThemLayout.createSequentialGroup()
                                                    .addComponent(ckNghe)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(ckNoi)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(ckDoc)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(ckViet))
                                                .addComponent(jLabel8)
                                                .addGroup(pnThemLayout.createSequentialGroup()
                                                    .addGroup(pnThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(radCong)
                                                        .addComponent(radDong))
                                                    .addGap(18, 18, 18)
                                                    .addGroup(pnThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(radMo)
                                                        .addComponent(radTrungBinhCong))))
                                            .addGap(59, 59, 59))
                                        .addGroup(pnThemLayout.createSequentialGroup()
                                            .addGroup(pnThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel3)
                                                .addComponent(txtDiemDauVao, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(61, 61, 61)
                                            .addGroup(pnThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(pnThemLayout.createSequentialGroup()
                                                    .addComponent(txtDiemDauRa)
                                                    .addGap(24, 24, 24))
                                                .addGroup(pnThemLayout.createSequentialGroup()
                                                    .addComponent(jLabel5)
                                                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnThemLayout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(123, 123, 123)))))))
        );
        pnThemLayout.setVerticalGroup(
            pnThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnThemLayout.createSequentialGroup()
                .addGroup(pnThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnThemLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnThemLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTenCt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(pnThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnThemLayout.createSequentialGroup()
                        .addGroup(pnThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDiemDauVao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDiemDauRa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ckNghe)
                            .addComponent(ckNoi)
                            .addComponent(ckDoc)
                            .addComponent(ckViet))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7))
                    .addGroup(pnThemLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbTenCc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pnThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDiemToiDa, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaCc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radCong)
                    .addComponent(radTrungBinhCong))
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radDong)
                    .addComponent(radMo))
                .addGap(4, 4, 4)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanActionPerformed
        capNhatChuongTrinh();
    }//GEN-LAST:event_btnXacNhanActionPerformed

    private void cbTenCcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTenCcActionPerformed

    }//GEN-LAST:event_cbTenCcActionPerformed

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
            java.util.logging.Logger.getLogger(FormCapNhatChuongTrinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormCapNhatChuongTrinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormCapNhatChuongTrinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormCapNhatChuongTrinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormCapNhatChuongTrinh().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnXacNhan;
    private javax.swing.JComboBox<String> cbTenCc;
    private javax.swing.JCheckBox ckDoc;
    private javax.swing.JCheckBox ckNghe;
    private javax.swing.JCheckBox ckNoi;
    private javax.swing.JCheckBox ckViet;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JPanel pnThem;
    private javax.swing.JRadioButton radCong;
    private javax.swing.JRadioButton radDong;
    private javax.swing.JRadioButton radMo;
    private javax.swing.JRadioButton radTrungBinhCong;
    private javax.swing.JTextField txtDiemDauRa;
    private javax.swing.JTextField txtDiemDauVao;
    private javax.swing.JTextField txtDiemToiDa;
    private javax.swing.JTextField txtMaCc;
    private javax.swing.JTextArea txtNoiDung;
    private javax.swing.JTextField txtTenCt;
    // End of variables declaration//GEN-END:variables
}
