/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.dto_ChungChi;
import DTO.dto_ChuongTrinh;
import DTO.dto_ChuongTrinh_ChungChi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Types;
import java.util.Vector;

/**
 *
 * @author USER
 */
public class dal_ChuongTrinh extends DBConnect {

    // HÀM LẤY DỮ LIỆU TRONG BẢNG CHUONGTRINH CÓ THAM SỐ
    public ArrayList<dto_ChuongTrinh> layDsChuongTrinh(int trangThai) {

        ArrayList<dto_ChuongTrinh> dsChuongTrinh = new ArrayList<dto_ChuongTrinh>();

        dto_ChuongTrinh ct = null;

        String sql = "";
        if (trangThai == 0) {
            sql = "SELECT ma_ct, ten_ct, ten_chung_chi, chuong_trinh.diem_dau_vao, chuong_trinh.diem_dau_ra, chuong_trinh.noi_dung, chuong_trinh.trang_thai "
                    + "FROM chuong_trinh, chung_chi "
                    + "WHERE chuong_trinh.ma_chung_chi = chung_chi.ma_chung_chi AND chuong_trinh.trang_thai = 1";
        } else {
            sql = "SELECT ma_ct, ten_ct, ten_chung_chi, chuong_trinh.diem_dau_vao, chuong_trinh.diem_dau_ra,  chuong_trinh.noi_dung, chuong_trinh.trang_thai "
                    + "FROM chuong_trinh, chung_chi "
                    + "WHERE chuong_trinh.ma_chung_chi = chung_chi.ma_chung_chi "
                    + "ORDER BY trang_thai DESC";
        }
        try {
            PreparedStatement preStmt = conn.prepareStatement(sql);
            ResultSet rs = preStmt.executeQuery();

            while (rs.next()) {

                ct = new dto_ChuongTrinh();

                ct.setMaCt(rs.getInt(1));
                ct.setTenCt(rs.getString(2));
                ct.setTenCc(rs.getString(3));
                ct.setDiemDauVao(rs.getFloat(4));
                ct.setDiemDauRa(rs.getFloat(5));
                ct.setNoiDung(rs.getString(6));
                ct.setTrangThai(rs.getInt(7));

                dsChuongTrinh.add(ct);
            }

            conn.close();
            return dsChuongTrinh;
        } catch (Exception e) {
            e.printStackTrace();
            return dsChuongTrinh;
        }

    }

    // HÀM TÌM KIẾM CHƯƠNG TRÌNH HỌC
    public ArrayList<dto_ChuongTrinh> timChuongTrinh(String txt) {

        txt = txt.toLowerCase();
        ArrayList<dto_ChuongTrinh> dsChuongTrinh = new ArrayList<dto_ChuongTrinh>();
        dto_ChuongTrinh ct = null;

        try {
            String sql = "SELECT ma_ct, ten_ct, chung_chi.ten_chung_chi, chuong_trinh.diem_dau_vao, chuong_trinh.diem_dau_ra, chuong_trinh.noi_dung, chuong_trinh.trang_thai "
                    + "FROM chuong_trinh JOIN chung_chi ON chuong_trinh.ma_chung_chi = chung_chi.ma_chung_chi "
                    + "WHERE LOWER(chuong_trinh.ten_ct) like N'%" + txt + "%' "
                    + "OR LOWER(chuong_trinh.ma_ct) like N'" + txt + "%'";

            PreparedStatement preStmt = conn.prepareStatement(sql);
            ResultSet rs = preStmt.executeQuery();

            while (rs.next()) {
                ct = new dto_ChuongTrinh();

                ct.setMaCt(rs.getInt(1));
                ct.setTenCt(rs.getString(2));
                ct.setTenCc(rs.getString(3));
                ct.setDiemDauVao(rs.getFloat(4));
                ct.setDiemDauRa(rs.getFloat(5));
                ct.setNoiDung(rs.getString(6));
                ct.setTrangThai(rs.getInt(7));

                dsChuongTrinh.add(ct);
            }
            conn.close();
            return dsChuongTrinh;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsChuongTrinh;
    }

    // HÀM LẤY CHỨNG CHỈ
    public ArrayList<dto_ChungChi> layDsChungChi() {

        ArrayList<dto_ChungChi> dsChungChi = new ArrayList<dto_ChungChi>();
        dto_ChungChi cc = null;
        try {
            String sql = "SELECT ma_chung_chi, ten_chung_chi, diem_toi_da, noi_dung, src_img "
                    + "FROM chung_chi";

            PreparedStatement preStmt = conn.prepareStatement(sql);
            ResultSet rs = preStmt.executeQuery();

            for (int i = 0; rs.next() == true; i++) {
                cc = new dto_ChungChi();
                cc.setMaCc(rs.getInt(1));
                cc.setTenCc(rs.getString(2));
                cc.setDiemToiDa(rs.getFloat(3));
                cc.setNoiDung(rs.getString(4));
                cc.setSrcImg(rs.getString(5));
                dsChungChi.add(cc);
            }

            conn.close();
            return dsChungChi;
        } catch (Exception ex) {
            ex.printStackTrace();
            return dsChungChi;
        }
    }

    // HÀM THÊM CHUONG TRÌNH
    public int themChuongTrinh(dto_ChuongTrinh ct) {

        try {
            String sql = "INSERT INTO chuong_trinh VALUES (chuong_trinh_sequence.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement preStmt = conn.prepareStatement(sql);
            preStmt.setInt(1, ct.getMaCc());
            preStmt.setString(2, ct.getTenCt());
            preStmt.setFloat(3, ct.getDiemDauVao());
            preStmt.setFloat(4, ct.getDiemDauRa());
            preStmt.setString(5, ct.getNoiDung());
            preStmt.setInt(6, ct.getTrangThai());
            preStmt.setInt(7, ct.getTinhNghe());
            preStmt.setInt(8, ct.getTinhNoi());
            preStmt.setInt(9, ct.getTinhDoc());
            preStmt.setInt(10, ct.getTinhViet());
            preStmt.setInt(11, ct.getCachTinhDiem());

            int rs = preStmt.executeUpdate();

            conn.close();
            return rs;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    // HÀM LẤY THÔNG TIN CHƯƠNG TRÌNH + CHỨNG CHỈ
    public dto_ChuongTrinh_ChungChi layThongTinCtCc(dto_ChuongTrinh ct) {

        dto_ChuongTrinh_ChungChi ct_cc_return = null;

        try {
            String sql = "SELECT chuong_trinh.ten_ct, chuong_trinh.diem_dau_vao, chuong_trinh.diem_dau_ra, chuong_trinh.trang_thai, chuong_trinh.noi_dung, chuong_trinh.tinh_diem_nghe, chuong_trinh.tinh_diem_noi, chuong_trinh.tinh_diem_doc, chuong_trinh.tinh_diem_viet, chuong_trinh.cach_tinh_diem ,chung_chi.ma_chung_chi, chung_chi.ten_chung_chi, chung_chi.diem_toi_da, chuong_trinh.ma_ct, chung_chi.src_img "
                    + "FROM chuong_trinh, chung_chi "
                    + "WHERE chuong_trinh.ma_chung_chi = chung_chi.ma_chung_chi AND chuong_trinh.ma_ct = ?";

            PreparedStatement preStmt = conn.prepareStatement(sql);
            preStmt.setInt(1, ct.getMaCt());

            ResultSet rs = preStmt.executeQuery();

            while (rs.next()) {
                ct_cc_return = new dto_ChuongTrinh_ChungChi();

                ct_cc_return.setTenCt(rs.getString(1));
                ct_cc_return.setDiemDauVao(rs.getFloat(2));
                ct_cc_return.setDiemDauRa(rs.getFloat(3));
                ct_cc_return.setTrangThai(rs.getInt(4));
                ct_cc_return.setNoiDung(rs.getString(5));
                ct_cc_return.setTinhNghe(rs.getInt(6));
                ct_cc_return.setTinhNoi(rs.getInt(7));
                ct_cc_return.setTinhDoc(rs.getInt(8));
                ct_cc_return.setTinhViet(rs.getInt(9));
                ct_cc_return.setCachTinhDiem(rs.getInt(10));
                ct_cc_return.setMaCc(rs.getInt(11));
                ct_cc_return.setTenCc(rs.getString(12));
                ct_cc_return.setDiemToiDa(rs.getFloat(13));
                ct_cc_return.setMaCt(rs.getInt(14));
                ct_cc_return.setSrcImg(rs.getString(15));
            }
            conn.close();

            return ct_cc_return;

        } catch (Exception ex) {
            ex.printStackTrace();

            return ct_cc_return;
        }
    }

    // HÀM CẬP NHẬT LẠI CHƯƠNG TRÌNH
    public int capNhatChuongTrinh(dto_ChuongTrinh ct) {

        try {
            String sql = "UPDATE chuong_trinh "
                    + "SET ten_ct = ?,"
                    + "diem_dau_vao = ?,"
                    + "diem_dau_ra = ?,"
                    + "trang_thai = ?,"
                    + "noi_dung=?,"
                    + "tinh_diem_nghe=?,"
                    + "tinh_diem_noi=?,"
                    + "tinh_diem_doc=?,"
                    + "tinh_diem_viet=?,"
                    + "cach_tinh_diem=? "
                    + "WHERE ma_ct=?";

            PreparedStatement preStmt = conn.prepareStatement(sql);
            preStmt.setString(1, ct.getTenCt());
            preStmt.setFloat(2, ct.getDiemDauVao());
            preStmt.setFloat(3, ct.getDiemDauRa());
            preStmt.setInt(4, ct.getTrangThai());
            preStmt.setString(5, ct.getNoiDung());
            preStmt.setInt(6, ct.getTinhNghe());
            preStmt.setInt(7, ct.getTinhNoi());
            preStmt.setInt(8, ct.getTinhDoc());
            preStmt.setInt(9, ct.getTinhViet());
            preStmt.setInt(10, ct.getCachTinhDiem());
            preStmt.setInt(11, ct.getMaCt());

            int rs = preStmt.executeUpdate();

            conn.close();
            return rs;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    // HÀM XÓA CHƯƠNG TRÌNH
    public int xoaChuongTrinh(int ma_ct) {

        try {

            String sql = "DELETE FROM chuong_trinh "
                    + "WHERE ma_ct = " + ma_ct;

            PreparedStatement preStmt = conn.prepareStatement(sql);
            int rs = preStmt.executeUpdate();

            conn.close();
            return rs;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    //MAIN
    public static void main(String[] args) {
        ArrayList<dto_ChuongTrinh> dsChuongTrinh = new dal_ChuongTrinh().layDsChuongTrinh(0);

        for (dto_ChuongTrinh ct : dsChuongTrinh) {
            System.out.println("Ma: " + ct.getMaCt());
            System.out.println("Ten: " + ct.getTenCt());
        }
    }
}
