package com.project.oop.lms.service.impl;


import com.project.oop.lms.entity.PhieuMuon;
import com.project.oop.lms.service.IBorrowService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowServiceImpl implements IBorrowService {

    @Override
    public List<PhieuMuon> getAllPhieuMuon() {
        //TODO: trả về các phiếu mượn đã lưu
        return List.of();
    }

    @Override
    public void lichSuMuonSach() {
        //TODO: trả về lịch sử mượn sách của một DocGia hoặc SachVatLy
    }

    @Override
    public void kiemTraHan() {
        //TODO: Kiểm tra hạn trả của phiếu mượn được chọn
    }

    @Override
    public void taoPhieuMuon() {
        //TODO: tạo phiếu mượn mới
    }
}
