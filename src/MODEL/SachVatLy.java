package model;

import java.io.Serializable;

public class SachVatLy implements Serializable {
    private static final long serialVersionUID = 1L;

    // Enum mô tả tình trạng sách
    public enum TinhTrang { 
        SAN_SANG,   // Sẵn sàng để mượn
        DANG_MUON,  // Đang được mượn
        HONG        // Hư hỏng
    }

    private String maVach;   // Mã vạch riêng của từng cuốn sách vật lý
    private String isbn;     // Liên kết đến đầu sách (Sach)
    private TinhTrang tinhTrang;

    public SachVatLy(String maVach, String isbn) {
        this.maVach = maVach;
        this.isbn = isbn;
        this.tinhTrang = TinhTrang.SAN_SANG;
    }

    public String getMaVach() {
        return maVach;
    }

    public String getIsbn() {
        return isbn;
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
