package com.project.oop.lms.entity;

import java.util.ArrayList;
import java.util.List;

public class DocGia {
    // TODO: Thêm các thuộc tính, getter, setter, constructor
    // --- 1. Thuộc tính (Attributes) ---
    private String maDocGia;
    private String hoTen;
    private String email;
    private String soDienThoai;
    private String diaChi;

    // --- 2. Các mối quan hệ (Relationships) ---
    // Quan hệ 1 - n với PhieuMuon
    private List<PhieuMuon> danhSachPhieuMuon = new ArrayList<>();

    // Quan hệ với SachVatLy
    private List<SachVatLy> sachDangMuon = new ArrayList<>();

    // --- 3. Constructors ---
    // Constructor rỗng
    public DocGia() {
    }

    // Constructor đầy đủ tham số
    public DocGia(String maDocGia, String hoTen, String email, String soDienThoai, String diaChi) {
        this.maDocGia = maDocGia;
        this.hoTen = hoTen;
        this.email = email;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
    }

    // --- 4. Methods ---
    public void capNhatThongTin() {
        // TODO: Logic cập nhật thông tin sẽ viết ở đây hoặc gọi sang Service
        System.out.println("Đang cập nhật thông tin độc giả: " + this.hoTen);
    }

    public void sachYeuThich() {
        // TODO: Logic xử lý sách yêu thích
        System.out.println("Danh sách sách yêu thích của: " + this.hoTen);
    }

    // --- 5. Getters và Setters ---
    public String getMaDocGia() {
        return maDocGia;
    }

    public void setMaDocGia(String maDocGia) {
        this.maDocGia = maDocGia;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public List<PhieuMuon> getDanhSachPhieuMuon() {
        return danhSachPhieuMuon;
    }

    public void setDanhSachPhieuMuon(List<PhieuMuon> danhSachPhieuMuon) {
        this.danhSachPhieuMuon = danhSachPhieuMuon;
    }

    public List<SachVatLy> getSachDangMuon() {
        return sachDangMuon;
    }

    public void setSachDangMuon(List<SachVatLy> sachDangMuon) {
        this.sachDangMuon = sachDangMuon;
    }
}
