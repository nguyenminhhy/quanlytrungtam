/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.dto_ChungChi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class dal_ChungChi extends DBConnect {
    

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
    
    
    // HÀM THÊM CHỨNG CHỈ
    public int themChungChi(dto_ChungChi cc){
        
        try{
            String sql = "INSERT INTO chung_chi VALUES (chung_chi_sequence.NEXTVAL,?,?,?,?)";
            
            PreparedStatement preStmt = conn.prepareCall(sql);
            preStmt.setString(1, cc.getTenCc());
            preStmt.setString(2, cc.getNoiDung());
            preStmt.setFloat(3, cc.getDiemToiDa());
            preStmt.setString(4, cc.getSrcImg());
            
            int rs = preStmt.executeUpdate();
            
            conn.close();
            return rs;
        }
        catch(Exception e){
            
            e.printStackTrace();
            return 0;
        }
    }
    
    // HÀM CẬP NHẬT CHỨNG CHỈ
    public int capNhatChungChi(dto_ChungChi cc){
        
        try{
            
            String sql = "UPDATE chung_chi "
                    + "SET ten_chung_chi = ?,"
                    + "diem_toi_da = ?,"
                    + "noi_dung = ?,"
                    + "src_img = ? "
                    + "WHERE ma_chung_chi = ?";
            
            PreparedStatement preStmt = conn.prepareStatement(sql);
            preStmt.setString(1, cc.getTenCc());
            preStmt.setFloat(2, cc.getDiemToiDa());
            preStmt.setString(3, cc.getNoiDung());
            preStmt.setString(4, cc.getSrcImg());
            preStmt.setInt(5, cc.getMaCc());
            
            int rs = preStmt.executeUpdate();
            
            conn.close();
            return rs;
        }
        catch(Exception e){
            e.printStackTrace();
            return 0;
        }
    }
    
    // HÀM XÓA CHỨNG CHỈ
    public int xoaChungChi(int ma_cc){
        
        try{
            
            String sql = "DELETE FROM chung_chi WHERE ma_chung_chi=" + ma_cc;
            
            PreparedStatement preStmt = conn.prepareStatement(sql);
            int rs = preStmt.executeUpdate();
            
            conn.close();
            return rs;
           
        }
        catch(Exception ex){
            ex.printStackTrace();
            return 0;
        }
    }
}
