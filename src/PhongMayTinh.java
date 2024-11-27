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

public class PhongMayTinh extends PhongHoc{
    private int soMayTinh;

    public PhongMayTinh(String maPhong, String dayNha, double dienTich, int soBongDen, int soMayTinh) {
        super(maPhong, dayNha, dienTich, soBongDen);
        this.soMayTinh = soMayTinh;
    }

    public int getSoMayTinh() {
        return soMayTinh;
    }

    public void setSoMayTinh(int soMayTinh) {
        this.soMayTinh = soMayTinh;
    }

    public boolean kiemDatChuan(){
        boolean anhSang;
        if(dienTich / 10 >= soBongDen)
            anhSang = true;
        else anhSang = false;
        if(anhSang && dienTich / 1.5f >= soMayTinh)
            return true;
        else return false;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%-10d",soMayTinh);
    }
}
