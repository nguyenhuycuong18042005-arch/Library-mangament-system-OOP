package com.project.oop.lms.repository;
import com.project.oop.lms.entity.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component

public class LibraryData {
    //Các danh sách được lưu trong csdl
    private List<DocGia> dsDocGia = new ArrayList<>();
    private List<Sach> dsSach = new ArrayList<>();
    private List<PhieuMuon> dsPhieuMuon = new ArrayList<>();
    private List<SachVatLy> dsSachVatLy = new ArrayList<>();
    private List<TacGia> dsTacGia = new ArrayList<>();

    // Getter - setter cho các danh sách trên
    public List<DocGia> getDsDocGia() {
        return dsDocGia;
    }

    public void setDsDocGia(List<DocGia> dsDocGia) {
        this.dsDocGia = dsDocGia;
    }

    public List<Sach> getDsSach() {
        return dsSach;
    }

    public void setDsSach(List<Sach> dsSach) {
        this.dsSach = dsSach;
    }

    public List<PhieuMuon> getDsPhieuMuon() {
        return dsPhieuMuon;
    }

    public void setDsPhieuMuon(List<PhieuMuon> dsPhieuMuon) {
        this.dsPhieuMuon = dsPhieuMuon;
    }

    public List<SachVatLy> getDsSachVatLy() {
        return dsSachVatLy;
    }

    public void setDsSachVatLy(List<SachVatLy> dsSachVatLy) {
        this.dsSachVatLy = dsSachVatLy;
    }

    public List<TacGia> getDsTacGia() {
        return dsTacGia;
    }

    public void setDsTacGia(List<TacGia> dsTacGia) {
        this.dsTacGia = dsTacGia;
    }
}
