/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.dto_LopHoc;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author ThinkPro
 */
public class dal_LopHoc extends DBConnect {

    public ArrayList<dto_LopHoc> layDsLop(int trangThai) {

        ArrayList<dto_LopHoc> dsLop = new ArrayList<dto_LopHoc>();

        dto_LopHoc lop = null;

        String sql = "";

        if (trangThai == 0) {

            sql = "SELECT ma_lop, lop.ma_ct, ma_nv, ten_lop, ngay_bd, ngay_kt, gv, phong, lop.trang_thai,chuong_trinh.ten_ct "
                    + "FROM lop, chuong_trinh "
                    + "WHERE lop.ma_ct = chuong_trinh.ma_ct AND lop.trang_thai = 1";
        } else if (trangThai == 1) {
            sql = "SELECT ma_lop, lop.ma_ct, ma_nv, ten_lop, ngay_bd, ngay_kt, gv, phong, lop.trang_thai,chuong_trinh.ten_ct "
                    + "FROM lop, chuong_trinh "
                    + "WHERE lop.ma_ct = chuong_trinh.ma_ct "
                    + "ORDER BY lop.trang_thai DESC";
        }

        try {

            PreparedStatement preStmt = conn.prepareStatement(sql);
            ResultSet rs = preStmt.executeQuery();

            while (rs.next()) {

                lop = new dto_LopHoc();

                lop.setMaLop(rs.getInt(1));
                lop.setMaCT(rs.getInt(2));
                lop.setMaNV(rs.getInt(3));
                lop.setTenLop(rs.getString(4));
                lop.setNgayBD(rs.getDate(5));
                lop.setNgayKT(rs.getDate(6));
                lop.setGiaoVien(rs.getString(7));
                lop.setPhong(rs.getString(8));
                lop.setTrangThai(rs.getInt(9));
                //lop.setTenCt(rs.getString(10));

                dsLop.add(lop);
            }
            conn.close();
            return dsLop;
        } catch (Exception ex) {
            ex.printStackTrace();
            return dsLop;
        }
    }
}
