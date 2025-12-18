package com.project.oop.lms.service.impl;

import com.project.oop.lms.entity.DocGia;
import com.project.oop.lms.entity.Sach;
import com.project.oop.lms.repository.LibraryData;
import com.project.oop.lms.entity.PhieuMuon;
import com.project.oop.lms.service.IReportService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Date;



@Service 
public class ReportServiceImpl implements IReportService {
    @Autowired
    private LibraryData libraryData;

    // THỐNG KÊ SÁCH ĐƯỢC MƯỢN NHIỀU NHẤT
     
    @Override
    public Sach sachDuocMuonNhieuNhat() {

        // Lấy toàn bộ danh sách phiếu mượn từ LibraryData
        List<PhieuMuon> list = libraryData.getDsPhieuMuon();

        // Nếu chưa có phiếu mượn nào thì không có thống kê
        if (list == null || list.isEmpty()) {
            return null;
        }
        Map<String, Integer> bookCount = new HashMap<>();
        Map<String, Sach> bookMap = new HashMap<>();

        // Duyệt từng phiếu mượn
        for (PhieuMuon pm : list) {

            // Nếu phiếu mượn không có sách → bỏ qua
            if (pm.getDsSach() == null) continue;

            // Duyệt từng sách trong phiếu mượn
            for (Sach s : pm.getDsSach()) {

                String isbn = s.getIsbn();

                // Nếu chưa có sách này trong map → lưu lại
                bookMap.putIfAbsent(isbn, s);

                // Tăng số lần mượn của sách
                // Nếu chưa tồn tại → mặc định là 0
                bookCount.put(isbn, bookCount.getOrDefault(isbn, 0) + 1);
            }
        }

        // Tìm ISBN có số lần mượn lớn nhất
        String maxIsbn = bookCount.entrySet()
                .stream()                              
                .max(Map.Entry.comparingByValue())    
                .map(Map.Entry::getKey)                
                .orElse(null);                          

        // Trả về sách tương ứng với ISBN tìm được
        return maxIsbn == null ? null : bookMap.get(maxIsbn);
    }
      //TÌM ĐỘC GIẢ CÓ SÁCH QUÁ HẠN
     
    @Override
    public DocGia thongKeDocGiaQuaHan() {

        // Lấy ngày hiện tại
        Date today = new Date();

        // Lấy danh sách phiếu mượn
        List<PhieuMuon> list = libraryData.getDsPhieuMuon();

        // Nếu không có dữ liệu → return null
        if (list == null) return null;

        // Duyệt từng phiếu mượn
        for (PhieuMuon pm : list) {

            // Nếu ngày trả dự kiến trước ngày hôm nay → quá hạn
            if (pm.getNgayTraDuKien().before(today)) {

                return pm.getDocGia();
            }
        }

        return null;
    }
}