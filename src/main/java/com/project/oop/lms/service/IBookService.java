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
//themDauSach
    public void themDauSach(String isbn, String tieuDe, List<String> maTacGiaList) {
        if (db.dsSach.containsKey(isbn)) {
            System.out.println("!! Lỗi: ISBN đã tồn tại."); return;
        }
        db.dsDauSach.put(isbn, new Sach(isbn, tieuDe, maTacGiaList));
        System.out.println(">> Đã thêm đầu sách.");
    }

//
public void nhapSachVatLy(String isbn, int soLuong) {
    // 1. Kiểm tra ISBN có tồn tại không
    if (!db.dsSach.containsKey(isbn)) {
        System.out.println("!! Lỗi: ISBN không tồn tại.");
        return;
    }

    // 2. Tìm số thứ tự hiện có để tránh trùng
    int count = 0;
    for (String key : db.dsSachVatLy.keySet()) {
        if (key.startsWith(isbn + "-")) {
            count++;
        }
    }

    // 3. Tạo các bản copy
    for (int i = 1; i <= soLuong; i++) {
        int stt = count + i;  // tăng tiếp theo
        String code = String.format("%s-%03d", isbn, stt);

        db.dsSachVatLy.put(code, new SachVatLy(code, isbn));
    }

    System.out.println(">> Đã nhập " + soLuong + " cuốn.");
}
}
