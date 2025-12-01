package com.project.oop.lms.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sach_vat_ly")
public class SachVatLy {

    public enum TinhTrang {
        SAN_SANG,
        DANG_MUON,
        HONG
    }

    @Id
    @Column(name = "ma_vach", nullable = false)
    private String maVach;

    @Column(name = "isbn", nullable = false)
    private String isbn;

    @Enumerated(EnumType.STRING)
    @Column(name = "tinh_trang", nullable = false)
    private TinhTrang tinhTrang;

    public SachVatLy() {
        // JPA bắt buộc phải có constructor rỗng
    }

    public SachVatLy(String maVach, String isbn) {
        this.maVach = maVach;
        this.isbn = isbn;
        this.tinhTrang = TinhTrang.SAN_SANG;  // mặc định như bản của bạn
    }

    public String getMaVach() {
        return maVach;
    }

    public void setMaVach(String maVach) {
        this.maVach = maVach;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public TinhTrang getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(TinhTrang tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    @Override
    public String toString() {
        return "SachVatLy{" +
                "maVach='" + maVach + '\'' +
                ", isbn='" + isbn + '\'' +
                ", tinhTrang=" + tinhTrang +
                '}';
    }
}
