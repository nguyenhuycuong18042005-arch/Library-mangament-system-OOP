package model;

import java.io.Serializable;
import java.util.List;

public class Sach implements Serializable{
    private static final long serialVersionUID = 1L;
    public String isbn;
    public String tenSach;
    public String theLoai;
    private List<String> maTacGiaList;

    public Sach(String tenSach, String isbn, String theLoai, List<String> maTacGiaList)
    {
        this.tenSach = tenSach;
        this.isbn = isbn;
        this.theLoai = theLoai;
        this.maTacGiaList = maTacGiaList;
    }
    public String getTenSach()
    {
        return tenSach;
    }
    public String getIsbn()
    {
        return isbn;
    }
    public String getTheLoai()
    {
        return theLoai;
    }
    public List<String> getMaTacGiaList()
    {
        return maTacGiaList;
    }
}
