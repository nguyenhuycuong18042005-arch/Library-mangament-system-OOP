package com.project.oop.lms.service;
import com.project.oop.lms.entity.DocGia;
import java.util.List;

public interface IReaderService {
    // Thêm độc giả mới
    DocGia themDocGia(DocGia docGia);

    // Sửa thông tin (Tên và SĐT) theo mã thẻ
    DocGia suaThongTinDocGia(String maDocGia, String tenMoi, String sdtMoi);

    // Kiểm tra thẻ có hợp lệ (không bị khóa) hay không
    boolean checkDocGiaHopLe(String maDocGia);

    // Hàm phụ: Lấy tất cả để xem danh sách (cho View)
    List<DocGia> getAllDocGia();
    
    // Hàm phụ: Tìm độc giả theo ID
    DocGia timDocGiaTheoMa(String maDocGia);

    // Khóa thẻ độc giả
    void khoaTheDocGia(String maDocGia);

    // Mở khóa thẻ độc giả
    void moKhoaTheDocGia(String maDocGia);
}
