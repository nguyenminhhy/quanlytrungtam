/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author USER
 */
public class dto_ChuongTrinh_ChungChi {
    private int maCt;
    private String tenCt;
    private float diemDauVao;
    private float diemDauRa;
    private String noiDung;
    private int trangThai; // 0-đóng , 1-mở
    private int tinhNghe;
    private int tinhNoi;
    private int tinhDoc;
    private int tinhViet;
    private int cachTinhDiem;
    
    private int maCc;
    private String tenCc;
    private Float diemToiDa;
    private String srcImg;

    public dto_ChuongTrinh_ChungChi() {
    }

    public int getMaCt() {
        return maCt;
    }

    public String getSrcImg() {
        return srcImg;
    }

    
    public String getTenCt() {
        return tenCt;
    }

    public float getDiemDauVao() {
        return diemDauVao;
    }

    public float getDiemDauRa() {
        return diemDauRa;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public int getTinhNghe() {
        return tinhNghe;
    }

    public int getTinhNoi() {
        return tinhNoi;
    }

    public int getTinhDoc() {
        return tinhDoc;
    }

    public int getTinhViet() {
        return tinhViet;
    }

    public int getCachTinhDiem() {
        return cachTinhDiem;
    }

    public int getMaCc() {
        return maCc;
    }

    public String getTenCc() {
        return tenCc;
    }

    public Float getDiemToiDa() {
        return diemToiDa;
    }

    public void setMaCt(int maCt) {
        this.maCt = maCt;
    }

    public void setTenCt(String tenCt) {
        this.tenCt = tenCt;
    }

    public void setDiemDauVao(float diemDauVao) {
        this.diemDauVao = diemDauVao;
    }

    public void setDiemDauRa(float diemDauRa) {
        this.diemDauRa = diemDauRa;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public void setTinhNghe(int tinhNghe) {
        this.tinhNghe = tinhNghe;
    }

    public void setTinhNoi(int tinhNoi) {
        this.tinhNoi = tinhNoi;
    }

    public void setTinhDoc(int tinhDoc) {
        this.tinhDoc = tinhDoc;
    }

    public void setTinhViet(int tinhViet) {
        this.tinhViet = tinhViet;
    }

    public void setCachTinhDiem(int cachTinhDiem) {
        this.cachTinhDiem = cachTinhDiem;
    }

    public void setMaCc(int maCc) {
        this.maCc = maCc;
    }

    public void setTenCc(String tenCc) {
        this.tenCc = tenCc;
    }

    public void setDiemToiDa(Float diemToiDa) {
        this.diemToiDa = diemToiDa;
    }

    public void setSrcImg(String srcImg) {
        this.srcImg = srcImg;
    }
    
    
    public String toString(){
        return tenCc;
    }
}
