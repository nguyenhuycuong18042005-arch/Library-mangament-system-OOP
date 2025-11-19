package com.project.oop.lms.service.impl;
import com.project.oop.lms.entity.Sach;
import com.project.oop.lms.service.IBookService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service //annotation đánh dấu đây là đoạn code dùng cho nghiệp vụ
public class BookServiceImpl implements IBookService { // implements từ class interface nghiệp vụ sách

    @Override //ghi đè phương thức từ class interface
    public List<Sach> getAllDauSach() {
        // TODO: Return list từ DataStore
        return null;
    }

    @Override
    public void themDauSach(Sach sach) {
        // TODO: Logic thêm sách và lưu JSON
    }

    @Override
    public void nhapSachVatLy(String isbn, int soLuong) {
        // TODO: Logic nhập kho
    }
}
