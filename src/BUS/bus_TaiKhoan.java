/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAL.dal_TaiKhoan;
import DTO.dto_TaiKhoan;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class bus_TaiKhoan{
    
    // HÀM LẤY DANH SÁCH TÀI KHOẢN
    public ArrayList<dto_TaiKhoan> layDsTaiKhoan(){
        return new dal_TaiKhoan().layDsTaiKhoan();
    }
    
    // HÀM MÃ HÓA BCRYPT MẬT KHẨU
    public String maHoaMatKhau(String matKhauNhap){
        return BCrypt.hashpw(matKhauNhap, BCrypt.gensalt(12));
    }
    
    // HÀM KIỂM TRA KHỚP MẬT KHẨU
    public boolean kiemTraKhopMatKhau(String matKhauNhap,String hash){
        return BCrypt.checkpw(matKhauNhap, hash);
    }
    
    // HÀM THÊM TÀI KHOẢN
    public int themTaiKhoan(dto_TaiKhoan tk){
        
        String hash = maHoaMatKhau(tk.getMatKhau());
        tk.setMatKhau(hash);
        
        return new dal_TaiKhoan().themTaiKhoan(tk);
    }

    // HÀM CẬP NHẬT TÀI KHOẢN
    public int capNhatTaiKhoan(dto_TaiKhoan tk, boolean capNhatMatKhau){
        
        if(capNhatMatKhau == true){
            String hash = maHoaMatKhau(tk.getMatKhau());
            tk.setMatKhau(hash);
        }
        
        return new dal_TaiKhoan().capNhatTaiKhoan(tk, capNhatMatKhau);
    }
   
    // HÀM XÓA TÀI KHOẢN
    public int xoaTaiKhoan(dto_TaiKhoan tk){
        
        return new dal_TaiKhoan().xoaTaiKhoan(tk);
    }
    
    // HÀM TÌM KIẾM 
    public ArrayList<dto_TaiKhoan> layDsTimKiem(String text){
        
        return new dal_TaiKhoan().layDsTimKiem(text);
    }
}
