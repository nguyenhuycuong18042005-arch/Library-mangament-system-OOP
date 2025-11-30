package model;

import java.io.Serializable;

public class TacGia implements Serializable {
    private static final long serialVersionUID = 1L;

    private String maTG;
    private String hoTen;
    private String quocTich;  

    public TacGia(String maTG, String hoTen, String quocTich) {
        this.maTG = maTG;
        this.hoTen = hoTen;
        this.quocTich = quocTich;
    }

    public String getMaTG() { 
        return maTG; 
    }

    public String getHoTen() { 
        return hoTen; 
    }

    public String getQuocTich() { 
        return quocTich; 
    }

    @Override
    public String toString() {
        return "TG[" + maTG + "]: " + hoTen + " (" + quocTich + ")";
    }
}
