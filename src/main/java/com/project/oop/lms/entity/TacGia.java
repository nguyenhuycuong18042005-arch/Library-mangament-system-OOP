package com.project.oop.lms.entity;

public class TacGia {

    private String maTG;
    private String hoTen;
    private String quocTich;

    public TacGia() {
    }

    public TacGia(String maTG, String hoTen, String quocTich) {
        this.maTG = maTG;
        this.hoTen = hoTen;
        this.quocTich = quocTich;
    }

    public String getMaTG() {
        return maTG;
    }

    public void setMaTG(String maTG) {
        this.maTG = maTG;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }

    @Override
    public String toString() {
        return "TG[" + maTG + "]: " + hoTen + " (" + quocTich + ")";
    }
}
