/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.ChuongTrinh;

import BUS.bus_ChuongTrinh;
import DTO.dto_ChuongTrinh;
import DTO.dto_ChuongTrinh_ChungChi;
import UI.ChungChi.UI_ChungChi;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class UI_ChuongTrinh extends javax.swing.JPanel {

    /**
     * Creates new form ChuongTrinhUI
     */
    public UI_ChuongTrinh() {
        initComponents();
        setupTable();
        hienThiDsChuongTrinh(0);
    }

    /**
     * Khu vực của Tân WARNING: Do NOT modify this code.
     */
    public void hideBtnCt() {
        btnCapNhatChuongTrinh.setVisible(false);
        btnThemChuongTrinh.setVisible(false);
        btnXoaChuongTrinh.setVisible(false);
    }

    // LẤY TRẠNG THÁI CỦA checkbox hiển thị trương trình đóng
    public boolean isCkChuongTrinhDong() {
        return ckBoxCtDong.isSelected();
    }

    
    //Biến tự định nghĩa
    
    static dto_ChuongTrinh static_chuongTrinh = new dto_ChuongTrinh();
    static DefaultTableModel static_dtmChuongTrinh = new DefaultTableModel();
    static ArrayList<dto_ChuongTrinh> static_dsChuongTrinh = new ArrayList<dto_ChuongTrinh>();
    private dto_ChuongTrinh ct_trans;


    // HÀM XÓA CHƯƠNG TRÌNH
    public void xoaChuongTrinh() {

        dto_ChuongTrinh_ChungChi chuongTrinh_chungChi = new dto_ChuongTrinh_ChungChi();

        chuongTrinh_chungChi = layThongTinChon();

        if (chuongTrinh_chungChi != null) {

            int rs = new bus_ChuongTrinh().xoaChuongTrinh(chuongTrinh_chungChi.getMaCt());

            if (rs > 0) {

                hienThiDsChuongTrinh(0);
                JOptionPane.showMessageDialog(null, "Thành Công");

            } else {

                JOptionPane.showMessageDialog(null, "Thất Bại");
            }
        }
    }

    // HÀM LẤY THÔNG TIN CỦA CHƯƠNG TRÌNH ĐƯỢC CHỌN
    public dto_ChuongTrinh_ChungChi layThongTinChon() {

        dto_ChuongTrinh_ChungChi ct_cc = null;

        int row = tbChuongTrinh.getSelectedRow();

        if (row >= 0) {
            this.ct_trans = new dto_ChuongTrinh();

            this.ct_trans = (dto_ChuongTrinh) static_dsChuongTrinh.get(row);

            ct_cc = new dto_ChuongTrinh_ChungChi();

            ct_cc = new bus_ChuongTrinh().layChuongTrinhChungChi(ct_trans);

        } else {

            JOptionPane.showMessageDialog(null, "Chưa chọn dòng dữ liệu");
        }
        return ct_cc;
    }

    // HÀM HIỂN THỊ THÔNG TIN TÌM KIẾM
    public void hienThiDsTimKiem(String text) {
        new bus_ChuongTrinh().layDsTimKiem(text);
    }

    // HÀM HIỂN THỊ THÔNG TIN LÊN BẢNG
    public static void hienThiDsChuongTrinh(int trangThai) {
        new bus_ChuongTrinh().layDsChuongTrinh(trangThai);
        
    }

    // HÀM LOAD DỮ LIỆU LÊN BẢNG
    public static void reloadTable(ArrayList<dto_ChuongTrinh> dsChuongTrinh) {

        static_dsChuongTrinh = new ArrayList<dto_ChuongTrinh>();
        static_dsChuongTrinh = dsChuongTrinh;

        int stt = 0;

        static_dtmChuongTrinh.setRowCount(0);

        for (dto_ChuongTrinh ct : dsChuongTrinh) {

            stt++;
            Vector<Object> vc = new Vector<Object>();

            vc.add(stt);
            vc.add(ct.getMaCt());
            vc.add(ct.getTenCt());
            vc.add(ct.getTenCc());
            vc.add(ct.getDiemDauVao());
            vc.add(ct.getDiemDauRa());
            vc.add(ct.getNoiDung());

            if (ct.getTrangThai() == 0) {
                vc.add("Đóng");
            } else {
                vc.add("Mở");
            }

            static_dtmChuongTrinh.addRow(vc);
        }
        
    }

    // HÀM TẠO BẢNG
    public void setupTable() {
        static_dtmChuongTrinh = new DefaultTableModel();

        static_dtmChuongTrinh.addColumn("STT");
        static_dtmChuongTrinh.addColumn("Mã CT");
        static_dtmChuongTrinh.addColumn("Tên Chương Trình");
        static_dtmChuongTrinh.addColumn("Chứng Chỉ");
        static_dtmChuongTrinh.addColumn("Đầu Vào");
        static_dtmChuongTrinh.addColumn("Đầu Ra");
        static_dtmChuongTrinh.addColumn("Nội Dung");
        static_dtmChuongTrinh.addColumn("Trạng Thái");

        tbChuongTrinh.setModel(static_dtmChuongTrinh);

        tbChuongTrinh.getColumnModel().getColumn(0).setMaxWidth(50);
        tbChuongTrinh.getColumnModel().getColumn(1).setMinWidth(80);
        tbChuongTrinh.getColumnModel().getColumn(1).setMaxWidth(80);
        tbChuongTrinh.getColumnModel().getColumn(2).setMinWidth(150);
        tbChuongTrinh.getColumnModel().getColumn(2).setMaxWidth(150);
        tbChuongTrinh.getColumnModel().getColumn(3).setMinWidth(100);
        tbChuongTrinh.getColumnModel().getColumn(3).setMaxWidth(80);
        tbChuongTrinh.getColumnModel().getColumn(4).setMaxWidth(80);
        tbChuongTrinh.getColumnModel().getColumn(4).setMinWidth(80);
        tbChuongTrinh.getColumnModel().getColumn(5).setMaxWidth(80);
        tbChuongTrinh.getColumnModel().getColumn(5).setMinWidth(80);
        tbChuongTrinh.getColumnModel().getColumn(6).setMinWidth(300);
        tbChuongTrinh.getColumnModel().getColumn(7).setMaxWidth(80);

        tbChuongTrinh.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 12));
        tbChuongTrinh.getTableHeader().setOpaque(false);
        tbChuongTrinh.getTableHeader().setForeground(new Color(0, 0, 0));
        tbChuongTrinh.setSelectionBackground(new Color(0, 64, 128));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnChuongTrinh = new javax.swing.JPanel();
        lblTimLop = new javax.swing.JLabel();
        txtTimChuongTrinh = new javax.swing.JTextField();
        btnThemChuongTrinh = new javax.swing.JButton();
        btnXoaChuongTrinh = new javax.swing.JButton();
        btnCapNhatChuongTrinh = new javax.swing.JButton();
        ckBoxCtDong = new javax.swing.JCheckBox();
        btnChungChi = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbChuongTrinh = new javax.swing.JTable();

        setBackground(new java.awt.Color(230, 245, 255));
        setPreferredSize(new java.awt.Dimension(1200, 620));

        pnChuongTrinh.setBackground(new java.awt.Color(230, 245, 255));
        pnChuongTrinh.setPreferredSize(new java.awt.Dimension(1200, 620));

        lblTimLop.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTimLop.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTimLop.setText("Tìm Kiếm");

        txtTimChuongTrinh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTimChuongTrinh.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 153, 153)));
        txtTimChuongTrinh.setMargin(new java.awt.Insets(10, 10, 10, 10));
        txtTimChuongTrinh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimChuongTrinhKeyReleased(evt);
            }
        });

        btnThemChuongTrinh.setBackground(new java.awt.Color(230, 245, 255));
        btnThemChuongTrinh.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnThemChuongTrinh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/taomoi.png"))); // NOI18N
        btnThemChuongTrinh.setToolTipText("Tạo Mới");
        btnThemChuongTrinh.setContentAreaFilled(false);
        btnThemChuongTrinh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThemChuongTrinh.setFocusable(false);
        btnThemChuongTrinh.setOpaque(true);
        btnThemChuongTrinh.setPreferredSize(new java.awt.Dimension(183, 40));
        btnThemChuongTrinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemChuongTrinhActionPerformed(evt);
            }
        });

        btnXoaChuongTrinh.setBackground(new java.awt.Color(230, 245, 255));
        btnXoaChuongTrinh.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnXoaChuongTrinh.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaChuongTrinh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/xoa.png"))); // NOI18N
        btnXoaChuongTrinh.setToolTipText("Xóa");
        btnXoaChuongTrinh.setContentAreaFilled(false);
        btnXoaChuongTrinh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXoaChuongTrinh.setFocusable(false);
        btnXoaChuongTrinh.setMaximumSize(new java.awt.Dimension(129, 49));
        btnXoaChuongTrinh.setMinimumSize(new java.awt.Dimension(129, 49));
        btnXoaChuongTrinh.setOpaque(true);
        btnXoaChuongTrinh.setPreferredSize(new java.awt.Dimension(129, 49));
        btnXoaChuongTrinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaChuongTrinhActionPerformed(evt);
            }
        });

        btnCapNhatChuongTrinh.setBackground(new java.awt.Color(230, 245, 255));
        btnCapNhatChuongTrinh.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCapNhatChuongTrinh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/capnhat.png"))); // NOI18N
        btnCapNhatChuongTrinh.setToolTipText("Cập Nhật");
        btnCapNhatChuongTrinh.setContentAreaFilled(false);
        btnCapNhatChuongTrinh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCapNhatChuongTrinh.setFocusable(false);
        btnCapNhatChuongTrinh.setMaximumSize(new java.awt.Dimension(129, 49));
        btnCapNhatChuongTrinh.setMinimumSize(new java.awt.Dimension(129, 49));
        btnCapNhatChuongTrinh.setOpaque(true);
        btnCapNhatChuongTrinh.setPreferredSize(new java.awt.Dimension(129, 49));
        btnCapNhatChuongTrinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatChuongTrinhActionPerformed(evt);
            }
        });

        ckBoxCtDong.setBackground(new java.awt.Color(230, 245, 255));
        ckBoxCtDong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ckBoxCtDong.setText("Hiển thị chương trình đã đóng");
        ckBoxCtDong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ckBoxCtDongMouseClicked(evt);
            }
        });
        ckBoxCtDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckBoxCtDongActionPerformed(evt);
            }
        });

        btnChungChi.setBackground(new java.awt.Color(230, 245, 255));
        btnChungChi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/chungchi.png"))); // NOI18N
        btnChungChi.setToolTipText("Quản Lý Chứng Chỉ");
        btnChungChi.setBorderPainted(false);
        btnChungChi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnChungChi.setFocusPainted(false);
        btnChungChi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChungChiActionPerformed(evt);
            }
        });

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tbChuongTrinh.setAutoCreateRowSorter(true);
        tbChuongTrinh.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tbChuongTrinh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã CT", "Tên Chương Trình", "Level", "Điểm Đầu Vào", "Nội Dung", "Trạng Thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbChuongTrinh.setToolTipText("");
        tbChuongTrinh.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tbChuongTrinh.setDoubleBuffered(true);
        tbChuongTrinh.setFocusable(false);
        tbChuongTrinh.setGridColor(new java.awt.Color(0, 102, 102));
        tbChuongTrinh.setMaximumSize(new java.awt.Dimension(2147483647, 999999));
        tbChuongTrinh.setMinimumSize(new java.awt.Dimension(665, 1000));
        tbChuongTrinh.setOpaque(false);
        tbChuongTrinh.setRequestFocusEnabled(false);
        tbChuongTrinh.setRowHeight(50);
        tbChuongTrinh.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbChuongTrinh.getTableHeader().setReorderingAllowed(false);
        tbChuongTrinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tbChuongTrinhMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(tbChuongTrinh);
        if (tbChuongTrinh.getColumnModel().getColumnCount() > 0) {
            tbChuongTrinh.getColumnModel().getColumn(0).setMinWidth(50);
            tbChuongTrinh.getColumnModel().getColumn(0).setMaxWidth(50);
            tbChuongTrinh.getColumnModel().getColumn(1).setMinWidth(100);
            tbChuongTrinh.getColumnModel().getColumn(1).setMaxWidth(100);
            tbChuongTrinh.getColumnModel().getColumn(2).setMinWidth(200);
            tbChuongTrinh.getColumnModel().getColumn(2).setMaxWidth(200);
            tbChuongTrinh.getColumnModel().getColumn(3).setMinWidth(50);
            tbChuongTrinh.getColumnModel().getColumn(3).setMaxWidth(50);
            tbChuongTrinh.getColumnModel().getColumn(4).setMinWidth(100);
            tbChuongTrinh.getColumnModel().getColumn(4).setMaxWidth(100);
            tbChuongTrinh.getColumnModel().getColumn(6).setMinWidth(150);
            tbChuongTrinh.getColumnModel().getColumn(6).setMaxWidth(150);
        }

        javax.swing.GroupLayout pnChuongTrinhLayout = new javax.swing.GroupLayout(pnChuongTrinh);
        pnChuongTrinh.setLayout(pnChuongTrinhLayout);
        pnChuongTrinhLayout.setHorizontalGroup(
            pnChuongTrinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnChuongTrinhLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(pnChuongTrinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(pnChuongTrinhLayout.createSequentialGroup()
                        .addComponent(lblTimLop)
                        .addGap(18, 18, 18)
                        .addComponent(txtTimChuongTrinh, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ckBoxCtDong)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 268, Short.MAX_VALUE)
                        .addComponent(btnChungChi, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnThemChuongTrinh, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnCapNhatChuongTrinh, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnXoaChuongTrinh, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)))
                .addGap(35, 35, 35))
        );
        pnChuongTrinhLayout.setVerticalGroup(
            pnChuongTrinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnChuongTrinhLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnChuongTrinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnChungChi, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemChuongTrinh, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCapNhatChuongTrinh, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaChuongTrinh, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnChuongTrinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTimChuongTrinh, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblTimLop, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ckBoxCtDong))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnChuongTrinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnChuongTrinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemChuongTrinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemChuongTrinhActionPerformed
        new FormThemChuongTrinh().show();
    }//GEN-LAST:event_btnThemChuongTrinhActionPerformed

    private void btnXoaChuongTrinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaChuongTrinhActionPerformed

        int rs = JOptionPane.showConfirmDialog(null, "Đồng ý xóa ?", "Xác Nhận Xóa", JOptionPane.YES_NO_OPTION);

        if (rs == 0) {
            xoaChuongTrinh();
        }
    }//GEN-LAST:event_btnXoaChuongTrinhActionPerformed

    private void btnCapNhatChuongTrinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatChuongTrinhActionPerformed

        dto_ChuongTrinh_ChungChi chuongTrinh_chungChi = layThongTinChon();
        if (chuongTrinh_chungChi != null) {
            new FormCapNhatChuongTrinh(chuongTrinh_chungChi).show();
        }

    }//GEN-LAST:event_btnCapNhatChuongTrinhActionPerformed

    private void ckBoxCtDongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ckBoxCtDongMouseClicked

    }//GEN-LAST:event_ckBoxCtDongMouseClicked

    private void ckBoxCtDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckBoxCtDongActionPerformed

        if (ckBoxCtDong.isSelected()) {
            hienThiDsChuongTrinh(1);
        } else {
            hienThiDsChuongTrinh(0);
        }
    }//GEN-LAST:event_ckBoxCtDongActionPerformed

    private void txtTimChuongTrinhKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimChuongTrinhKeyReleased

        String text = txtTimChuongTrinh.getText();

        if (text.isEmpty() == false) {
            hienThiDsTimKiem(text);
        } else {

            if (ckBoxCtDong.isSelected() == true) {
                hienThiDsChuongTrinh(1);
            } else {
                hienThiDsChuongTrinh(0);
            }
        }

    }//GEN-LAST:event_txtTimChuongTrinhKeyReleased

    private void tbChuongTrinhMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbChuongTrinhMouseEntered

    }//GEN-LAST:event_tbChuongTrinhMouseEntered

    private void btnChungChiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChungChiActionPerformed
        new UI_ChungChi().show();
    }//GEN-LAST:event_btnChungChiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhatChuongTrinh;
    private javax.swing.JButton btnChungChi;
    private javax.swing.JButton btnThemChuongTrinh;
    private javax.swing.JButton btnXoaChuongTrinh;
    private javax.swing.JCheckBox ckBoxCtDong;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTimLop;
    private javax.swing.JPanel pnChuongTrinh;
    private javax.swing.JTable tbChuongTrinh;
    private javax.swing.JTextField txtTimChuongTrinh;
    // End of variables declaration//GEN-END:variables
}
