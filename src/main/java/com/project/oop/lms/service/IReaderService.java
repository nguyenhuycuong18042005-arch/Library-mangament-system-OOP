package com.project.oop.lms.service;
import com.project.oop.lms.entity.DocGia;
import java.util.List;

public interface IReaderService {
    List<DocGia> getAllDocGia();
    void themDocGia();
    void thayDoiThongTinDocGia();
    void xoaDocGia();
    //TODO: có thể thêm sửa xoá các hàm để phù hợp với thiết kế
}
