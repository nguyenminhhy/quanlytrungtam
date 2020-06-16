/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.dto_KhachHang;
import DTO.dto_LichSuKH;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author ThinkPro
 */
public class dal_KhachHang extends DBConnect {

    PreparedStatement preStatement;
    ResultSet result;

    public ArrayList<dto_KhachHang> layToanBoKhachHang() {
        try {
            ArrayList<dto_KhachHang> listKH = new ArrayList<dto_KhachHang>();
            String sql = "SELECT * FROM KHACH_HANG ORDER BY MA_KH";
            preStatement = conn.prepareStatement(sql);
            result = preStatement.executeQuery();
            System.out.println(result);
            while (result.next()) {
                dto_KhachHang kh = new dto_KhachHang();
                kh.setMaKH(result.getInt(1));
                kh.setHoTen(result.getString(2));
                kh.setNgaySinh(result.getString(3).substring(0, 10));
                kh.setGioiTinh(result.getInt(4));
                kh.setDiaChi(result.getString(5));
                kh.setSdt(result.getString(6));
                kh.setDiemDauVao(result.getString(7));
                kh.setChungChi(result.getInt(8));
                kh.setLop(result.getInt(9));

                listKH.add(kh);
            }
            return listKH;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<dto_KhachHang> layKHDangHoc() {
        try {
            ArrayList<dto_KhachHang> listKH = new ArrayList<dto_KhachHang>();
            String sql = "SELECT * FROM KHACH_HANG "
                    + "WHERE LOP_DANG_HOC IS NOT NULL "
                    + "ORDER BY MA_KH";
            preStatement = conn.prepareStatement(sql);
            result = preStatement.executeQuery();
            System.out.println(result);
            while (result.next()) {
                dto_KhachHang kh = new dto_KhachHang();
                kh.setMaKH(result.getInt(1));
                kh.setHoTen(result.getString(2));
                kh.setNgaySinh(result.getString(3).substring(0, 10));
                kh.setGioiTinh(result.getInt(4));
                kh.setDiaChi(result.getString(5));
                kh.setSdt(result.getString(6));
                kh.setDiemDauVao(result.getString(7));
                kh.setChungChi(result.getInt(8));
                kh.setLop(result.getInt(9));

                listKH.add(kh);
            }
            return listKH;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<dto_LichSuKH> layLichSuKH(int Ma) {
        try {
            ArrayList<dto_LichSuKH> listLSKH = new ArrayList<dto_LichSuKH>();
            String sql = "SELECT L.MA_LOP, L.TEN_LOP, CT.TEN_CT, L.NGAY_BD, L.NGAY_KT, KQ.NGHE, KQ.NOI, KQ.DOC, KQ.VIET, KQ.TONG "
                    + "FROM KQHT KQ, CHUONG_TRINH CT, LOP L "
                    + "WHERE KQ.MA_LOP = L.MA_LOP "
                    + "AND L.MA_CT = CT.MA_CT "
                    + "AND KQ.MA_KH = ?";
            preStatement = conn.prepareStatement(sql);
            preStatement.setInt(1, Ma);
            result = preStatement.executeQuery();
            while (result.next()) {
                dto_LichSuKH lsKH = new dto_LichSuKH();
                lsKH.setMaLop(result.getInt(1));
                lsKH.setTenLop(result.getString(2));
                lsKH.setTenCT(result.getString(3));
                lsKH.setNgBD(result.getString(4).substring(0, 10));
                lsKH.setNgKT(result.getString(5).substring(0, 10));
                lsKH.setDiemNghe(result.getInt(6));
                lsKH.setDiemNoi(result.getInt(7));
                lsKH.setDiemDoc(result.getInt(8));
                lsKH.setDiemViet(result.getInt(9));
                lsKH.setDiemTB((float) result.getDouble(10));
                listLSKH.add(lsKH);
            }
            return listLSKH;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean themKhachHang(dto_KhachHang kh) {
        try {
            String sql = "INSERT INTO KHACH_HANG (MA_KH, HO_TEN, NGAYSINH_, GIOI_TINH, DIA_CHI, SDT, DIEM_DAU_VAO, CHUNG_CHI_CAN_HOC) VALUES(KHACH_HANG_SEQUENCE.nextval,?,TO_DATE(?,'dd/MM/yyyy'),?,?,?,?,?)";
            preStatement = conn.prepareStatement(sql);
            preStatement.setString(1, kh.getHoTen());
            preStatement.setString(2, kh.getNgaySinh());
            preStatement.setInt(3, kh.getGioiTinh());
            preStatement.setString(4, kh.getDiaChi());
            preStatement.setString(5, kh.getSdt());
            preStatement.setString(6, kh.getDiemDauVao());
            preStatement.setInt(7, kh.getChungChi());

            int n = preStatement.executeUpdate();
            if (n > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Ngay sinh k hop le");
        }
        return false;
    }

    public boolean xoaKhachHang(int ma) {
        try {
            String sql = "DELETE FROM KHACH_HANG WHERE MA_KH = ?";
            preStatement = conn.prepareStatement(sql);
            preStatement.setInt(1, ma);
            int n = preStatement.executeUpdate();
            if (n > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean capNhatKhachHang(dto_KhachHang kh) {
        try {
            String sql = "UPDATE KHACH_HANG SET HO_TEN = ?, NGAYSINH_ =TO_DATE(?,'dd/MM/yyyy'), GIOI_TINH=?, DIA_CHI=?, SDT=?, DIEM_DAU_VAO=?, CHUNG_CHI_CAN_HOC =? WHERE MA_KH=? ";
            preStatement = conn.prepareStatement(sql);
            preStatement.setString(1, kh.getHoTen());
            preStatement.setString(2, kh.getNgaySinh());
            preStatement.setInt(3, kh.getGioiTinh());
            preStatement.setString(4, kh.getDiaChi());
            preStatement.setString(5, kh.getSdt());
            preStatement.setString(6, kh.getDiemDauVao());
            preStatement.setInt(7, kh.getChungChi());
            preStatement.setInt(8, kh.getMaKH());

            int n = preStatement.executeUpdate();
            if (n > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<dto_KhachHang> timKhachHang(String txt) {
        txt = txt.toLowerCase();
        ArrayList<dto_KhachHang> listKH = new ArrayList<dto_KhachHang>();
        try {
            String sql = "select * from khach_hang where "
                    + "lower(ho_ten) like N'%" + txt + "%' "
                    + "or lower(ma_kh) like N'" + txt + "%' "
                    + "or sdt like N'" + txt + "%' ";
            preStatement = conn.prepareStatement(sql);
            result = preStatement.executeQuery();

            while (result.next()) {
                dto_KhachHang kh = new dto_KhachHang();
                kh.setMaKH(result.getInt(1));
                kh.setHoTen(result.getString(2));
                kh.setNgaySinh(result.getString(3));
                kh.setGioiTinh(result.getInt(4));
                kh.setDiaChi(result.getString(5));
                kh.setSdt(result.getString(6));
                kh.setDiemDauVao(result.getString(7));
                kh.setChungChi(result.getInt(8));
                kh.setLop(result.getInt(9));
                listKH.add(kh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKH;
    }

    public ArrayList<String> layDS_ChungChi() {
        ArrayList<String> listChungChi = new ArrayList<String>();
        try {
            String sql = "SELECT TEN_CHUNG_CHI FROM CHUNG_CHI GROUP BY TEN_CHUNG_CHI";
            preStatement = conn.prepareStatement(sql);
            result = preStatement.executeQuery();
            while (result.next()) {
                listChungChi.add(result.getString(1));
            }
        } catch (Exception e) {
        }
        return listChungChi;
    }
}
