package com.project.oop.lms.service.impl;

import com.project.oop.lms.entity.DocGia;
import com.project.oop.lms.service.IReaderService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ReaderServiceImpl implements IReaderService {
    
    // --- MOCK DATA (GIẢ LẬP DATABASE) ---
    // List này đóng vai trò như Database tạm thời
    private List<DocGia> khoDuLieuAo = new ArrayList<>();

    public ReaderServiceImpl() {
        // Tạo sẵn vài dữ liệu mẫu để test
        khoDuLieuAo.add(new DocGia("0001", "Nguyen Van A", "a@gmail.com", "0901234567", "Ha Noi"));
        khoDuLieuAo.add(new DocGia("0002", "Tran Thi B", "b@gmail.com", "0987654321", "TP HCM"));
    }

    // --- 1. HÀM THÊM ĐỘC GIẢ (Sinh mã tự động) ---
    @Override
    public DocGia themDocGia(DocGia docGia) {
        // Sinh mã thẻ tự động: Số ngẫu nhiên 4 chữ số
        Random rand = new Random();
        int randomNum = rand.nextInt(9000) + 1000; 
        String maTuDong = String.valueOf(randomNum);
        
        // Gán mã vừa sinh cho độc giả
        docGia.setMaDocGia(maTuDong);
        
        // Lưu vào "Database ảo"
        khoDuLieuAo.add(docGia);
        
        System.out.println("Đã thêm độc giả mới: " + docGia.getHoTen() + " - Mã: " + maTuDong);
        return docGia;
    }

    // --- 2. HÀM SỬA THÔNG TIN ---
    @Override
    public DocGia suaThongTinDocGia(String maDocGia, String tenMoi, String sdtMoi) {
        // Tìm độc giả trong list
        DocGia docGiaCanSua = timDocGiaTheoMa(maDocGia);

        if (docGiaCanSua != null) {
            // Cập nhật thông tin
            docGiaCanSua.setHoTen(tenMoi);
            docGiaCanSua.setSoDienThoai(sdtMoi);
            System.out.println("Đã cập nhật thông tin cho mã: " + maDocGia);
            return docGiaCanSua;
        } else {
            System.out.println("Không tìm thấy độc giả có mã: " + maDocGia);
            return null;
        }
    }

    // --- 3. HÀM KIỂM TRA HỢP LỆ (Check khóa thẻ) ---
    @Override
    public boolean checkDocGiaHopLe(String maDocGia) {
        // Tìm độc giả theo mã thẻ
        DocGia docGia = timDocGiaTheoMa(maDocGia);
        
        // Kiểm tra tồn tại
        if (docGia == null) {
            System.out.println("Mã thẻ không tồn tại!");
            return false;
        }

        // Kiểm tra trạng thái khóa
        if (docGia.isBiKhoa()) {
            System.out.println("Thẻ độc giả " + maDocGia + " đang bị khóa!");
            return false; // Thẻ bị khóa
        }
        
        System.out.println("Thẻ độc giả " + maDocGia + " đang hoạt động tốt.");
        return true; // Thẻ hợp lệ
    }

    // --- CÁC HÀM PHỤ ---
    // Lấy tất cả độc giả
    @Override
    public List<DocGia> getAllDocGia() {
        return khoDuLieuAo;
    }

    // Tìm độc giả theo mã thẻ
    @Override
    public DocGia timDocGiaTheoMa(String maDocGia) {
        for (DocGia dg : khoDuLieuAo) {
            if (dg.getMaDocGia().equals(maDocGia)) {
                return dg;
            }
        }
        return null;
    }

    // Khóa thẻ độc giả
    @Override
    public void khoaTheDocGia(String maDocGia) {
        DocGia dg = timDocGiaTheoMa(maDocGia);
        if (dg != null) {
            dg.setBiKhoa(true); // Set thành true
            System.out.println("Đã KHÓA thẻ của: " + dg.getHoTen());
        }
    }

    // Mở khóa thẻ độc giả
    @Override
    public void moKhoaTheDocGia(String maDocGia) {
        DocGia dg = timDocGiaTheoMa(maDocGia);
        if (dg != null) {
            dg.setBiKhoa(false); // Set về false
            System.out.println("Đã MỞ KHÓA thẻ cho: " + dg.getHoTen());
        }
    }
}
