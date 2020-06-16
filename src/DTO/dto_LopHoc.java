/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.sql.Date;

/**
 *
 * @author ThinkPro
 */
public class dto_LopHoc {

    private int MaLop;
    private int MaCT;
    private int MaNV;
    private String tenLop;
    private Date ngayBD;
    private Date ngayKT;
    private String soLuong;
    private String giaoVien;
    private String phong;
    private int trangThai;

    public dto_LopHoc(int MaLop, int MaCT, int MaNV, String tenLop, Date ngayBD, Date ngayKT, String soLuong, String giaoVien, String phong, int trangThai) {
        this.MaLop = MaLop;
        this.MaCT = MaCT;
        this.MaNV = MaNV;
        this.tenLop = tenLop;
        this.ngayBD = ngayBD;
        this.ngayKT = ngayKT;
        this.soLuong = soLuong;
        this.giaoVien = giaoVien;
        this.phong = phong;
        this.trangThai = trangThai;
    }

    public dto_LopHoc() {
    }

    public int getMaLop() {
        return MaLop;
    }

    public void setMaLop(int MaLop) {
        this.MaLop = MaLop;
    }

    public int getMaCT() {
        return MaCT;
    }

    public void setMaCT(int MaCT) {
        this.MaCT = MaCT;
    }

    public int getMaNV() {
        return MaNV;
    }

    public void setMaNV(int MaNV) {
        this.MaNV = MaNV;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public Date getNgayBD() {
        return ngayBD;
    }

    public void setNgayBD(Date ngayBD) {
        this.ngayBD = ngayBD;
    }

    public Date getNgayKT() {
        return ngayKT;
    }

    public void setNgayKT(Date ngayKT) {
        this.ngayKT = ngayKT;
    }

    public String getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(String soLuong) {
        this.soLuong = soLuong;
    }

    public String getGiaoVien() {
        return giaoVien;
    }

    public void setGiaoVien(String giaoVien) {
        this.giaoVien = giaoVien;
    }

    public String getPhong() {
        return phong;
    }

    public void setPhong(String phong) {
        this.phong = phong;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

}
