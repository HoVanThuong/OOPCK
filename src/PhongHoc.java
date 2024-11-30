/*
 * @ Ho Van Thuong.java    1.0 27
 * Copyright (c) 2024 IUH. All rights reserved
 *
 */


/*
 * @description: IUHER
 * @author: Ho Van Thuong
 * @date: 27/11/2024
 * @version: 1.0
 */

public abstract class PhongHoc {
    protected  String maPhong;
    protected String dayNha;
    protected double dienTich;
    protected int soBongDen;

    public PhongHoc() {
        this.maPhong = "";
        this.dayNha = "";
        this.dienTich = 0;
        this.soBongDen = 0;
    }

    public PhongHoc(String maPhong, String dayNha, double dienTich, int soBongDen) {
        this.setMaPhong(maPhong);
        this.setSoBongDen(soBongDen);
        this.setDayNha(dayNha);
        this.setDienTich(dienTich);
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        if(maPhong == null || maPhong.isEmpty())
            throw new IllegalArgumentException("Ma phong khong hop le !!!");
        this.maPhong = maPhong;
    }

    public String getDayNha() {
        return dayNha;
    }

    public void setDayNha(String dayNha) {
        if(dayNha == null || dayNha.isEmpty())
            throw new IllegalArgumentException("Day nha khong hop le !!!");
        this.dayNha = dayNha;
    }

    public double getDienTich() {
        return dienTich;
    }

    public void setDienTich(double dienTich) {
        if(dienTich < 0)
            throw new IllegalArgumentException("Dien tich khong hop le !!!");
        this.dienTich = dienTich;
    }

    public int getSoBongDen() {
        return soBongDen;
    }

    public void setSoBongDen(int soBongDen) {
        if(soBongDen < 0)
            throw new IllegalArgumentException("So bong den khong hop le !!!");
        this.soBongDen = soBongDen;
    }

    public abstract boolean kiemDatChuan();

    @Override
    public String toString() {
        return String.format("%-20s %-10s %-10f %-10d",maPhong,dayNha,dienTich,soBongDen);
    }
}
