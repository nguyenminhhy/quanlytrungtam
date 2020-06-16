/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import DAL.dal_ChuongTrinh;
import DTO.dto_ChungChi;
import DTO.dto_ChuongTrinh;
import DTO.dto_ChuongTrinh_ChungChi;
import UI.ChuongTrinh.UI_ChuongTrinh;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class bus_ChuongTrinh {
    
    
    // HÀM LÂY GIÁ TRỊ HIỂN THỊ LÊN BẢNG.
    public void layDsChuongTrinh(int trangThai){
        
        ArrayList<dto_ChuongTrinh> dsChuongTrinh = new dal_ChuongTrinh().layDsChuongTrinh(trangThai);
        
        UI_ChuongTrinh.reloadTable(dsChuongTrinh);
    }
    
    
    // HÀM LẤY DANH SÁCH TÌM KIẾM HIỂN THỊ LÊN BẢNG
    public void layDsTimKiem(String text){
        ArrayList<dto_ChuongTrinh> dsChuongTrinh = new dal_ChuongTrinh().timChuongTrinh(text);
        UI_ChuongTrinh.reloadTable(dsChuongTrinh);    
    }
    
    
    // HÀM LẤY CHỨNG CHỈ
    public ArrayList<dto_ChungChi> layDsChungChi(){
        
        return new dal_ChuongTrinh().layDsChungChi();
    }
    
    // HÀM THÊM CHƯƠNG TRÌNH
    public int themChuongTrinh(dto_ChuongTrinh ct){
        return new dal_ChuongTrinh().themChuongTrinh(ct);
    }
    
    // HÀM LẤY GIÁ TRỊ CHƯƠNG TRÌNH + CHỨNG CHỈ
    public dto_ChuongTrinh_ChungChi layChuongTrinhChungChi(dto_ChuongTrinh ct){
        return new dal_ChuongTrinh().layThongTinCtCc(ct);
    }
    
    // HÀM CẬP NHẬT CHƯƠNG TRÌNH
    public int capNhatChuongTrinh(dto_ChuongTrinh ct){
        
        return new dal_ChuongTrinh().capNhatChuongTrinh(ct);
    }
    
    // HÀM XÓA CHƯƠNG TRÌNH
    public int xoaChuongTrinh(int ma_ct){
        
        return new dal_ChuongTrinh().xoaChuongTrinh(ma_ct);
    }
    
}
