/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAL.dal_KhachHang;
import DTO.dto_KhachHang;
import DTO.dto_LichSuKH;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class bus_Khachhang {

    static ArrayList<dto_KhachHang> listKH = new ArrayList<dto_KhachHang>();
    static ArrayList<dto_LichSuKH> listLSKH = new ArrayList<dto_LichSuKH>(); // danh sách lịch sử khách hàng

    // dùng để gọi các hàm ở lớp DAL-KhachHang
    dal_KhachHang khService = new dal_KhachHang();

    static DefaultTableModel model = new DefaultTableModel(); // Bảng khách hàng
    static DefaultTableModel modelLSKH = new DefaultTableModel(); // Bảng lịch sử khách hàng

    static int stt = 0;

    // hàm hiển thị danh sách khách hàng lên bảng
    public void hienThiDanhSachKH(JTable tbl) {
        listKH = khService.layToanBoKhachHang();
        if (model != null) {
            model.setRowCount(0);
            model.setColumnCount(0);
            model.addColumn("STT");
            model.addColumn("Mã KH");
            model.addColumn("Họ Tên");
            model.addColumn("Giới Tính");
            model.addColumn("Ngày Sinh");
            model.addColumn("Địa Chỉ");
            model.addColumn("Số Điện Thoại");
            model.addColumn("Điểm Đầu Vào");
            model.addColumn("Chứng Chỉ");
            model.addColumn("Lớp");
            tbl.setModel(model);
        } else {
            tbl.setModel(model);
        }
        if (listKH != null) {
            stt = 0;
            for (dto_KhachHang kh : listKH) {
                stt++;
                Vector<Object> vec = new Vector<Object>();
                vec.add(stt);
                vec.add(kh.getMaKH());
                vec.add(kh.getHoTen());
                if (kh.getGioiTinh() == 1) {
                    vec.add("Nam");
                } else {
                    vec.add("Nữ");
                }
                //vec.add(kh.getGioiTinh());
                vec.add(kh.getNgaySinh());
                vec.add(kh.getDiaChi());
                vec.add(kh.getSdt());
                vec.add(kh.getDiemDauVao());
                vec.add(kh.getChungChi());
                if (kh.getLop() == 0) {
                    vec.add("");
                } else {
                    vec.add(kh.getLop());
                }
                model.addRow(vec);
            }
        }
    }

    // hiển thị danh sachs khách hàng lên form Lịch sử
    public void hienThiLichSuKH(JTable tbl, int MaKH) {
        listLSKH = khService.layLichSuKH(MaKH);
        if (modelLSKH != null) {
            modelLSKH.setRowCount(0);
            modelLSKH.setColumnCount(0);
            modelLSKH.addColumn("Mã Lớp");
            modelLSKH.addColumn("Tên Lớp");
            modelLSKH.addColumn("Chương Trình");
            modelLSKH.addColumn("Bắt Đầu");
            modelLSKH.addColumn("Kết Thúc");
            modelLSKH.addColumn("Nghe");
            modelLSKH.addColumn("Nói");
            modelLSKH.addColumn("Đọc");
            modelLSKH.addColumn("Viết");
            modelLSKH.addColumn("Trung Bình");
            tbl.setModel(modelLSKH);
        } else {
            tbl.setModel(modelLSKH);
        }
        if (listLSKH != null) {
            for (dto_LichSuKH lsKH : listLSKH) {
                stt++;
                Vector<Object> vec = new Vector<Object>();
                vec.add(lsKH.getMaLop());
                vec.add(lsKH.getTenLop());
                vec.add(lsKH.getTenCT());
                vec.add(lsKH.getNgBD());
                vec.add(lsKH.getNgKT());
                vec.add(lsKH.getDiemNghe());
                vec.add(lsKH.getDiemNoi());
                vec.add(lsKH.getDiemDoc());
                vec.add(lsKH.getDiemViet());
                vec.add(lsKH.getDiemTB());
                modelLSKH.addRow(vec);
            }
        }
    }

    // hiển thị những khách hàng tìm kiếm
    public void hienThiDSTimKiem(JTable tbl, String txt) {
        listKH = khService.timKhachHang(txt);
        if (model != null) {
            model.setRowCount(0);
            model.setColumnCount(0);
            model.addColumn("STT");
            model.addColumn("Mã Khách Hàng");
            model.addColumn("Họ Tên");
            model.addColumn("Giới Tính");
            model.addColumn("Ngày Sinh");
            model.addColumn("Số Điện Thoại");
            model.addColumn("Địa Chỉ");
            model.addColumn("Điểm Đầu Vào");
            model.addColumn("Cấp Độ");
            model.addColumn("Lớp");
            tbl.setModel(model);
        } else {
            tbl.setModel(model);
        }
        if (listKH != null) {
            stt = 0;
            for (dto_KhachHang kh : listKH) {
                stt++;
                Vector<Object> vec = new Vector<Object>();
                vec.add(stt);
                vec.add(kh.getMaKH());
                vec.add(kh.getHoTen());
                vec.add(kh.getGioiTinh());
                vec.add(kh.getNgaySinh().substring(0, 10));
                vec.add(kh.getSdt());
                vec.add(kh.getDiaChi());
                vec.add(kh.getDiemDauVao());
                vec.add(kh.getChungChi());
                vec.add(kh.getLop());
                model.addRow(vec);
            }
        }
    }

    public void HienThiDSKHDangHoc(JTable tbl) {
        listKH = khService.layKHDangHoc();
        if (model != null) {
            model.setRowCount(0);
            model.setColumnCount(0);
            model.addColumn("STT");
            model.addColumn("Mã KH");
            model.addColumn("Họ Tên");
            model.addColumn("Giới Tính");
            model.addColumn("Ngày Sinh");
            model.addColumn("Địa Chỉ");
            model.addColumn("Số Điện Thoại");
            model.addColumn("Điểm Đầu Vào");
            model.addColumn("Chứng Chỉ");
            model.addColumn("Lớp");
            tbl.setModel(model);
        } else {
            tbl.setModel(model);
        }
        if (listKH != null) {
            stt = 0;
            for (dto_KhachHang kh : listKH) {
                stt++;
                Vector<Object> vec = new Vector<Object>();
                vec.add(stt);
                vec.add(kh.getMaKH());
                vec.add(kh.getHoTen());
                if (kh.getGioiTinh() == 1) {
                    vec.add("Nam");
                } else {
                    vec.add("Nữ");
                }
                //vec.add(kh.getGioiTinh());
                vec.add(kh.getNgaySinh());
                vec.add(kh.getDiaChi());
                vec.add(kh.getSdt());
                vec.add(kh.getDiemDauVao());
                vec.add(kh.getChungChi());
                if (kh.getLop() == 0) {
                    vec.add("");
                } else {
                    vec.add(kh.getLop());
                }
                model.addRow(vec);
            }
        }
    }

    public ArrayList<dto_KhachHang> getList() {
        return listKH;
    }

    public boolean themKH(dto_KhachHang kh) {
        return khService.themKhachHang(kh);
    }

    public boolean xoaKH(int ma) {
        return khService.xoaKhachHang(ma);
    }

    public boolean capnhatKH(dto_KhachHang kh) {
        return khService.capNhatKhachHang(kh);
    }

    public void dsTimKH(String txt) {
        ArrayList<dto_KhachHang> list = new ArrayList<dto_KhachHang>();
        list = new dal_KhachHang().timKhachHang(txt);
    }

    public ArrayList<String> layDS_ChungChi() {
        return khService.layDS_ChungChi();
    }
}
