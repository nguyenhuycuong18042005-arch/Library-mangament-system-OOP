package com.project.oop.lms.service;
import com.project.oop.lms.entity.Sach;
import com.project.oop.lms.entity.Tacgia;
import com.project.oop.lms.entity.SachVatLy;
import java.util.List;

public interface IBookService {
    List<Sach> getAllDauSach();
    void themDauSach(Sach sach);
    void nhapSachVatLy(String isbn, int soLuong);
    // TODO: Thêm các hàm tìm kiếm...
    public void themDauSach(String isbn, String tieuDe, List<String> maTacGiaList) {
        if (db.dsDauSach.containsKey(isbn)) {
            System.out.println("!! Lỗi: ISBN đã tồn tại."); return;
        }
        db.dsDauSach.put(isbn, new Sach(isbn, tieuDe, maTacGiaList));
        System.out.println(">> Đã thêm đầu sách.");
    }
    public void nhapSachVatLy(String isbn, int soLuong) {
        if (!db.dsDauSach.containsKey(isbn)) {
            System.out.println("!! Lỗi: ISBN không tồn tại."); return;
        }
        for (int i = 0; i < soLuong; i++) {
            String maVach = isbn + "-N" + (System.currentTimeMillis() % 10000 + i);
            db.dsSachVatLy.put(maVach, new SachVatLy(maVach, isbn));
        }
        System.out.println(">> Đã nhập " + soLuong + " cuốn.");
    }
}
