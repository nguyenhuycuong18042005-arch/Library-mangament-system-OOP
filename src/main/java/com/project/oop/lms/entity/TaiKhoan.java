package com.project.oop.lms.entity;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "loai_tk"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = ThuThu.class, name = "THU_THU"),
        // @JsonSubTypes.Type(value = DocGia.class, name = "DOC_GIA")
})
public abstract class TaiKhoan {
    protected String tenDangNhap;
    protected String matKhau;
    protected String trangThai;
    protected String vaiTro;
    protected String hoTen;

    //Constructor
    public TaiKhoan(){

    }

    public TaiKhoan(String tenDangNhap, String matKhau, String hoTen, String trangThai, String vaiTro){
        this.matKhau = matKhau;
        this.tenDangNhap = tenDangNhap;
        this.trangThai = trangThai;
        this.vaiTro = vaiTro;
        this.hoTen = hoTen;
    }


}
