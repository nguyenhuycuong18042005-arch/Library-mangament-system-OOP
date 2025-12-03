package com.project.oop.lms.service;
import com.project.oop.lms.entity.Sach;
import com.project.oop.lms.entity.Tacgia;
import com.project.oop.lms.entity.SachVatLy;
import com.project.oop.lms.repository.*;
import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDate;

public interface IBookService {
    List<Sach> getAllDauSach();
    void themDauSach(Sach sach);
    void nhapSachVatLy(String isbn, int soLuong);
    // TODO: Thêm các hàm tìm kiếm...
//themDauSach
public void themDauSach(String isbn, String tieuDe, List<String> maTacGiaList) {

    // 1. Kiểm tra ISBN có tồn tại hay chưa
    if (db.dsDauSach.containsKey(isbn)) {
        System.out.println("!! Lỗi: ISBN đã tồn tại.");
        return;
    }

    // 2. Kiểm tra dữ liệu đầu vào
    if (isbn == null || isbn.isEmpty() || tieuDe == null || tieuDe.isEmpty()) {
        System.out.println("!! Lỗi: ISBN hoặc tiêu đề không hợp lệ.");
        return;
    }

    if (maTacGiaList == null || maTacGiaList.isEmpty()) {
        System.out.println("!! Lỗi: Sách phải có ít nhất 1 tác giả.");
        return;
    }

    // 3. Kiểm tra tác giả có tồn tại trong hệ thống không
    for (String maTG : maTacGiaList) {
        if (!db.dsTacGia.containsKey(maTG)) {
            System.out.println("!! Lỗi: Tác giả " + maTG + " không tồn tại.");
            return;
        }
    }

    // 4. Tạo đối tượng sách
    Sach sach = new Sach(isbn, tieuDe, maTacGiaList);

    // 5. Lưu vào database (danh sách)
    db.dsDauSach.put(isbn, sach);

    // 6. Lưu xuống file JSON nếu đang dùng DataStore
    dataStore.saveData();

    System.out.println(">> Đã thêm đầu sách thành công!");
}


//
public void nhapSachVatLy(String isbn, int soLuong) {
    // 1. Kiểm tra ISBN có tồn tại không
    if (!db.dsDauSach.containsKey(isbn)) {
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
