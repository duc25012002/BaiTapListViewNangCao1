package com.hdcompany.listviewnangcao.duc.model;

public class LoaiSach {
    private String tenSach;
    private int hinhAnh;

    public LoaiSach(String tenSach, int hinhAnh) {
        this.tenSach = tenSach;
        this.hinhAnh = hinhAnh;
    }

    public LoaiSach() {
    }


    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public int getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(int hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
}
