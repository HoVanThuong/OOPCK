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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ToaNha {
    private List<PhongHoc> dsPhong;

    public ToaNha() {
        this.dsPhong = new ArrayList<>();
    }

    public int getIndex(String maPhong){
        for(int i = 0; i < dsPhong.size(); i++){
            if(dsPhong.get(i).getMaPhong().equalsIgnoreCase(maPhong)){
                return i;
            }
        }
        return -1;
    }

    public boolean themPhong(PhongHoc phong){
        if(phong == null || phong.getMaPhong().equals(""))
            return false;
        if(getIndex(phong.getMaPhong()) != -1)
            return false;
        dsPhong.add(phong);
        return true;
    }

    public PhongHoc timPhong(String maPhong){
        int index = getIndex(maPhong);
        if(index == -1)
            return null;
        return dsPhong.get(index);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(PhongHoc phong : dsPhong){
            sb.append(phong.toString() + "\n");
        }
        return sb.toString();
    }

//    public List<PhongHoc> danhSachPhongDatChuan(){
//        List<PhongHoc> danhSachPhong = new ArrayList<>();
//        for(PhongHoc phong : dsPhong){
//            if(phong.kiemDatChuan())
//                danhSachPhong.add(phong);
//        }
//        return danhSachPhong;
//    }
    // Stream API
    public List<PhongHoc> danhSachPhongDatChuan() {
        return dsPhong.stream()
                .filter(ph -> ph.kiemDatChuan())
                .collect(Collectors.toList());
    }

    public List<PhongHoc> sapXepTangDanTheoDayNha() {
        List<PhongHoc> temp = new ArrayList<>(dsPhong); // Ban Copy
        temp.sort((ph1,ph2) -> ph1.getDayNha().compareTo(ph2.getDayNha()));
        return temp;
    }

    public List<PhongHoc> sapXepTangDanTheoDayNha2(){
        return dsPhong.stream()
                .sorted((ph1,ph2) -> ph1.getDayNha().compareTo(ph2.getDayNha()))
                .collect(Collectors.toList());
    }


    public List<PhongHoc> sapXepGiamDanTheoDienTich(){
        return dsPhong.stream()
                .sorted((ph1,ph2) -> Double.compare(ph2.getDienTich(), ph1.getDienTich()))
                .collect(Collectors.toList());
    }

    public boolean capNhatMayTinh(String maPhong, int soMayTinhMoi){
        if(maPhong.equals("") || soMayTinhMoi <= 0)
            return false;
        int index = getIndex(maPhong);
        if(index == -1)
            return false;
        PhongHoc phong = dsPhong.get(index);
        if(phong instanceof PhongMayTinh)
        {
            ((PhongMayTinh)phong).setSoMayTinh(soMayTinhMoi);
            return true;
        }
        return false;
    }

    public boolean capNhatMayTinh2(String maPhong, int soMayTinhMoi){
        PhongHoc temp = dsPhong.stream()
                .filter(ph -> ph.getMaPhong().equalsIgnoreCase(maPhong))
                .filter(ph -> ph instanceof PhongMayTinh)
                .findFirst()
                .orElse(null);
        if(temp != null && soMayTinhMoi >= 0){
            ((PhongMayTinh)temp).setSoMayTinh(soMayTinhMoi);
            return true;
        }
        return false;
    }
    public boolean xoaPhong(String maPhong){
        if(maPhong == null || maPhong.isEmpty())
            return false;
        int index = getIndex(maPhong);
        if(index == -1)
            return false;
        dsPhong.remove(index);
        return true;
    }


    public int tongPhongHoc(){
        return dsPhong.size();
    }

    public List<PhongHoc> danhSachPhongMay60(){
        return dsPhong.stream()
                .filter(ph -> ph instanceof PhongMayTinh)
                .filter(ph -> ((PhongMayTinh) ph).getSoMayTinh() == 60)
                .collect(Collectors.toList());
    }

}
