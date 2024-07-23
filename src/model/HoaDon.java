package model;

import java.util.List;

public class HoaDon {
    private int soHD;
    private List<SanPham> dssp;

    public HoaDon(int soHD, List<SanPham> dssp) {
        this.soHD = soHD;
        this.dssp = dssp; // Không cần clone danh sách sản phẩm
    }

    public int getSoHD() {
        return soHD;
    }

    public List<SanPham> getDssp() {
        return dssp;
    }
}