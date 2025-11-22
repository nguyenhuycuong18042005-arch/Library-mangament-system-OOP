package com.project.oop.lms.repository;
import com.project.oop.lms.entity.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class LibraryData {
    //Các danh sách được lưu trong csdl
    private List<TaiKhoan> dsTaiKhoan = new ArrayList<>();
    private List<DocGia> dsDocGia = new ArrayList<>();
    private List<Sach> dsSach = new ArrayList<>();
    private List<PhieuMuon> dsPhieuMuon = new ArrayList<>();
    private List<SachVatLy> dsSachVatLy = new ArrayList<>();
    private List<TacGia> dsTacGia = new ArrayList<>();

}
