/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author ThinkPro
 */
public class dto_LichSuKH {

    int MaLop;
    String TenLop;
    String TenCT;
    String NgBD;
    String NgKT;
    int diemNghe;
    int diemNoi;
    int diemDoc;
    int diemViet;
    float diemTB;
    String TrangThai;

    public dto_LichSuKH(int MaLop, String TenLop, String TenCT, String NgBD, String NgKT, int diemNghe, int diemNoi, int diemDoc, int diemViet, float diemTB, String TrangThai) {
        this.MaLop = MaLop;
        this.TenLop = TenLop;
        this.TenCT = TenCT;
        this.NgBD = NgBD;
        this.NgKT = NgKT;
        this.diemNghe = diemNghe;
        this.diemNoi = diemNoi;
        this.diemDoc = diemDoc;
        this.diemViet = diemViet;
        this.diemTB = diemTB;
        this.TrangThai = TrangThai;
    }

    public dto_LichSuKH() {
    }

    public int getMaLop() {
        return MaLop;
    }

    public void setMaLop(int MaLop) {
        this.MaLop = MaLop;
    }

    public String getTenLop() {
        return TenLop;
    }

    public void setTenLop(String TenLop) {
        this.TenLop = TenLop;
    }

    public String getTenCT() {
        return TenCT;
    }

    public void setTenCT(String TenCT) {
        this.TenCT = TenCT;
    }

    public String getNgBD() {
        return NgBD;
    }

    public void setNgBD(String NgBD) {
        this.NgBD = NgBD;
    }

    public String getNgKT() {
        return NgKT;
    }

    public void setNgKT(String NgKT) {
        this.NgKT = NgKT;
    }

    public int getDiemNghe() {
        return diemNghe;
    }

    public void setDiemNghe(int diemNghe) {
        this.diemNghe = diemNghe;
    }

    public int getDiemNoi() {
        return diemNoi;
    }

    public void setDiemNoi(int diemNoi) {
        this.diemNoi = diemNoi;
    }

    public int getDiemDoc() {
        return diemDoc;
    }

    public void setDiemDoc(int diemDoc) {
        this.diemDoc = diemDoc;
    }

    public int getDiemViet() {
        return diemViet;
    }

    public void setDiemViet(int diemViet) {
        this.diemViet = diemViet;
    }

    public float getDiemTB() {
        return diemTB;
    }

    public void setDiemTB(float diemTB) {
        this.diemTB = diemTB;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

}
