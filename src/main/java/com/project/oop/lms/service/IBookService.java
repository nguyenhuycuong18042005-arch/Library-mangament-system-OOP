package com.project.oop.lms.service;

import com.project.oop.lms.entity.Sach;
import com.project.oop.lms.entity.SachVatLy;
import com.project.oop.lms.repository.LibraryData;

import java.util.ArrayList;
import java.util.List;

public class BookService implements IBookService {

    private final LibraryData db;

    public BookService(LibraryData db) {
        this.db = db;
    }

    @Override
    public List<Sach> getAllDauSach() {
        return db.getDsSach();
    }

    @Override
    public void themDauSach(String isbn, String tenSach, List<String> maTacGiaList) {

        // 1. Kiểm tra ISBN trùng
        for (Sach s : db.getDsSach()) {
            if (s.getIsbn().equals(isbn)) {
                System.out.println("!! Lỗi: ISBN đã tồn tại.");
                return;
            }
        }

        // 2. Kiểm tra dữ liệu
        if (isbn == null || isbn.isEmpty() ||
            tenSach == null || tenSach.isEmpty()) {
            System.out.println("!! Lỗi: ISBN hoặc tiêu đề không hợp lệ.");
            return;
        }

        // 3. Tạo và lưu sách
        Sach sach = new Sach(isbn, tenSach, "Không rõ", maTacGiaList);
        db.getDsSach().add(sach);

        System.out.println(">> Đã thêm đầu sách thành công!");
    }

    @Override
    public void nhapSachVatLy(String isbn, int soLuong) {

        // 1. kiểm tra ISBN tồn tại
        boolean tonTai = false;
        for (Sach s : db.getDsSach()) {
            if (s.getIsbn().equals(isbn)) {
                tonTai = true;
                break;
            }
        }
        if (!tonTai) {
            System.out.println("!! Lỗi: ISBN không tồn tại.");
            return;
        }

        // 2. Tìm số thứ tự tiếp theo
        int count = 0;
        for (SachVatLy svl : db.getDsSachVatLy()) {
            if (svl.getIsbn().equals(isbn)) {
                count++;
            }
        }

        // 3. Tạo sách vật lý
        for (int i = 1; i <= soLuong; i++) {
            int stt = count + i;
            String code = String.format("%s-%03d", isbn, stt);

            db.getDsSachVatLy().add(new SachVatLy(code, isbn));
        }

        System.out.println(">> Đã nhập " + soLuong + " cuốn.");
    }

    @Override
    public List<Sach> timKiemSach(String keyword) {
        List<Sach> ketQua = new ArrayList<>();

        if (keyword == null || keyword.isEmpty()) {
            return ketQua;
        }

        String kw = keyword.toLowerCase();

        for (Sach s : db.getDsSach()) {
            boolean matchISBN = s.getIsbn().toLowerCase().contains(kw);
            boolean matchTitle = s.getTenSach().toLowerCase().contains(kw);

            if (matchISBN || matchTitle) {
                ketQua.add(s);
            }
        }

        return ketQua;
    }
}
