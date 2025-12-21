package com.project.oop.lms.entity;

import java.util.List;

public class Sach {

    private String isbn;
    private String tenSach;
    private String theLoai;
    private List<String> maTacGiaList;

    public Sach() {
    }

    public Sach(String isbn, String tenSach, String theLoai, List<String> maTacGiaList) {
        this.isbn = isbn;
        this.tenSach = tenSach;
        this.theLoai = theLoai;
        this.maTacGiaList = maTacGiaList;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public List<String> getMaTacGiaList() {
        return maTacGiaList;
    }

    public void setMaTacGiaList(List<String> maTacGiaList) {
        this.maTacGiaList = maTacGiaList;
    }

    @Override
    public String toString() {
        return "Sach{" +
                "isbn='" + isbn + '\'' +
                ", tenSach='" + tenSach + '\'' +
                ", theLoai='" + theLoai + '\'' +
                ", maTacGiaList=" + maTacGiaList +
                '}';
    }
}
