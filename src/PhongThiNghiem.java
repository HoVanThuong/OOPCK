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

public class PhongThiNghiem extends PhongHoc{
    private boolean bonRua;


    public PhongThiNghiem(String maPhong, String dayNha, double dienTich, int soBongDen, boolean bonRua) {
        super(maPhong, dayNha, dienTich, soBongDen);
        this.bonRua = bonRua;
    }

    public boolean isBonRua() {
        return bonRua;
    }

    public void setBonRua(boolean bonRua) {
        this.bonRua = bonRua;
    }


    public boolean kiemDatChuan(){
        boolean anhSang;
        if(dienTich / 10 >= soBongDen)
            anhSang = true;
        else anhSang = false;
        return anhSang && bonRua ? true : false;
    }

    @Override
    public String toString() {
        String text = bonRua ? "Co Bon Rua" : "Khong Co Bon Rua";
        return super.toString() + String.format("%-20s",text);
    }
}
