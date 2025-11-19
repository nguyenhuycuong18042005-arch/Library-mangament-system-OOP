package com.project.oop.lms.service;
import com.project.oop.lms.entity.Sach;
import java.util.List;

public interface IBookService {
    List<Sach> getAllDauSach();
    void themDauSach(Sach sach);
    void nhapSachVatLy(String isbn, int soLuong);
    // TODO: Thêm các hàm tìm kiếm...
}
