package com.project.oop.lms.service;
import com.project.oop.lms.entity.PhieuMuon;
import com.project.oop.lms.entity.SachVatLy;

import java.util.List;

public interface IBorrowService {
    List<PhieuMuon> getAllPhieuMuon();
    void lichSuMuonSach();
    void kiemTraHan();
    void taoPhieuMuon();
    //TODO: có thể thêm sửa xoá các hàm để phù hợp với thiết kế
}
