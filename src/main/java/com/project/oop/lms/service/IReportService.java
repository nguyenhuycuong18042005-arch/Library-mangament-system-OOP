package com.project.oop.lms.service;

import com.project.oop.lms.entity.DocGia;
import com.project.oop.lms.entity.Sach;

public interface IReportService {

    // Sách được mượn nhiều nhất
    Sach sachDuocMuonNhieuNhat();

    // Độc giả có sách quá hạn (ví dụ đơn giản)
    DocGia docGiaCoSachQuaHan();
}
