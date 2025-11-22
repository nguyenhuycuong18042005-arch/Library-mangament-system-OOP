package com.project.oop.lms.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = true)
public class ThuThu extends TaiKhoan implements Serializable {
    private String maThuThu;

    //constructor
    public ThuThu(String maThuThu, String tenDangNhap, String matKhau, String hoTen,
                  String trangThai, String vaiTro){
        super( tenDangNhap,  matKhau, hoTen,  trangThai,  vaiTro);
        this.maThuThu = maThuThu;
    }

    public ThuThu(){
        super();
    }

}
