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

public class PhongLyThuyet extends PhongHoc{
    private boolean mayChieu;

    public PhongLyThuyet(String maPhong, String dayNha, double dienTich, int soBongDen, boolean mayChieu) {
        super(maPhong, dayNha, dienTich, soBongDen);
        this.mayChieu = mayChieu;
    }

    public boolean isMayChieu() {
        return mayChieu;
    }

    public void setMayChieu(boolean mayChieu) {
        this.mayChieu = mayChieu;
    }

    public boolean kiemDatChuan(){
        boolean anhSang;
        if(dienTich / 10 >= soBongDen)
            anhSang = true;
        else anhSang = false;
        return anhSang && mayChieu ? true : false;
    }

    @Override
    public String toString() {
        String text = mayChieu ? "Co May Chieu" : "Khong Co May Chieu";
        return super.toString() + String.format("%-20s",text);
    }
}
