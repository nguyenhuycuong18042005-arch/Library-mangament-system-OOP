package com.project.oop.lms.entity;

public class SachVatLy {

    public enum TinhTrang {
        SAN_SANG,
        DANG_MUON,
        HONG
    }

    private String maVach;
    private String isbn;
    private TinhTrang tinhTrang;

    public SachVatLy() {
    }

    public SachVatLy(String maVach, String isbn) {
        this.maVach = maVach;
        this.isbn = isbn;
        this.tinhTrang = TinhTrang.SAN_SANG;
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
package com.project.oop.lms.entity;

public class SachVatLy {
    // TODO: Thêm các thuộc tính, getter, setter, constructor
}
