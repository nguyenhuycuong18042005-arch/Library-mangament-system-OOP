package com.project.oop.lms.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "sach")
public class Sach {

    @Id
    @Column(name = "isbn", nullable = false)
    private String isbn;

    @Column(name = "ten_sach", nullable = false)
    private String tenSach;

    @Column(name = "the_loai", nullable = false)
    private String theLoai;

    @ElementCollection
    @CollectionTable(
        name = "sach_tac_gia",
        joinColumns = @JoinColumn(name = "isbn")
    )
    @Column(name = "ma_tg", nullable = false)
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
}
