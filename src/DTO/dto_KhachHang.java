/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.sql.Date;

/**
 *
 * @author USER
 */
public class dto_KhachHang {

    private Integer MaKH;
    private Integer Lop;
    private String HoTen;
    private String NgaySinh;
    private Integer GioiTinh;
    private String DiaChi;
    private String Sdt;
    private String DiemDauVao;
    private Integer ChungChi;

    public dto_KhachHang() {
    }

    public dto_KhachHang(Integer MaKH, Integer Lop, String HoTen, String NgaySinh, Integer GioiTinh, String DiaChi, String Sdt, String DiemDauVao, Integer ChungChi) {
        this.MaKH = MaKH;
        this.Lop = Lop;
        this.HoTen = HoTen;
        this.NgaySinh = NgaySinh;
        this.GioiTinh = GioiTinh;
        this.DiaChi = DiaChi;
        this.Sdt = Sdt;
        this.DiemDauVao = DiemDauVao;
        this.ChungChi = ChungChi;
    }

    public dto_KhachHang(String HoTen, String NgaySinh, Integer GioiTinh, String DiaChi, String Sdt, String DiemDauVao, Integer ChungChi) {
        this.HoTen = HoTen;
        this.NgaySinh = NgaySinh;
        this.GioiTinh = GioiTinh;
        this.DiaChi = DiaChi;
        this.Sdt = Sdt;
        this.DiemDauVao = DiemDauVao;
        this.ChungChi = ChungChi;
    }

    public dto_KhachHang(Integer MaKH, String HoTen, Integer GioiTinh, String DiaChi, String Sdt, String DiemDauVao, Integer ChungChi) {
        this.MaKH = MaKH;
        this.HoTen = HoTen;
        this.GioiTinh = GioiTinh;
        this.DiaChi = DiaChi;
        this.Sdt = Sdt;
        this.DiemDauVao = DiemDauVao;
        this.ChungChi = ChungChi;
    }

    public dto_KhachHang(Integer MaKH, String HoTen, String NgaySinh, Integer GioiTinh, String DiaChi, String Sdt, String DiemDauVao, Integer ChungChi) {
        this.MaKH = MaKH;
        this.HoTen = HoTen;
        this.NgaySinh = NgaySinh;
        this.GioiTinh = GioiTinh;
        this.DiaChi = DiaChi;
        this.Sdt = Sdt;
        this.DiemDauVao = DiemDauVao;
        this.ChungChi = ChungChi;
    }

    public Integer getMaKH() {
        return MaKH;
    }

    public void setMaKH(Integer MaKH) {
        this.MaKH = MaKH;
    }

    public Integer getLop() {
        return Lop;
    }

    public void setLop(Integer Lop) {
        this.Lop = Lop;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public Integer getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(Integer GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String Sdt) {
        this.Sdt = Sdt;
    }

    public String getDiemDauVao() {
        return DiemDauVao;
    }

    public void setDiemDauVao(String DiemDauVao) {
        this.DiemDauVao = DiemDauVao;
    }

    public Integer getChungChi() {
        return ChungChi;
    }

    public void setChungChi(Integer ChungChi) {
        this.ChungChi = ChungChi;
    }

}
