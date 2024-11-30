import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ToaNhaTest {

    // Khởi tạo trước mỗi test
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        // Có thể khởi tạo các đối tượng cần thiết ở đây, nếu cần
    }

    // Dọn dẹp sau mỗi test
    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        // Có thể dọn dẹp các tài nguyên ở đây nếu cần
    }

    // Kiểm tra khi truyền null vào phương thức themPhong
    @org.junit.jupiter.api.Test
    void themPhong_NULL() {
        ToaNha toaNha = new ToaNha();
        //PhongHoc phongHoc = new PhongLyThuyet("1","da",2,2,true);
        assertFalse(toaNha.themPhong(null), "Phong Khong NULL");
    }

    @org.junit.jupiter.api.Test
    void themPhong_MaPhongRong() {
        ToaNha toaNha = new ToaNha();
        PhongHoc phongHoc = new PhongLyThuyet();
        assertFalse(toaNha.themPhong(phongHoc), "Phong Ma Khong Rong");
    }

    @org.junit.jupiter.api.Test
    void themPhong_CheckIndex() {
        ToaNha toaNha = new ToaNha();
        PhongHoc phongHoc = new PhongLyThuyet("2","da",2,2,true);
        PhongHoc phongHoc1 = new PhongLyThuyet("3","da",2,2,true);
        PhongHoc phongHoc2 = new PhongLyThuyet("1","da",2,2,true);
        PhongHoc phongHoc3 = new PhongLyThuyet("4","da",2,2,true);
        toaNha.themPhong(phongHoc);
        toaNha.themPhong(phongHoc1);
        toaNha.themPhong(phongHoc2);
        toaNha.themPhong(phongHoc3);
        assertEquals(toaNha.getIndex("1"),2);
    }

    @org.junit.jupiter.api.Test
    void themPhong_Correct() {
        ToaNha toaNha = new ToaNha();
        PhongHoc phongHoc = new PhongLyThuyet("2","da",2,2,true);
        PhongHoc phongHoc1 = new PhongLyThuyet("3","da",2,2,true);
        toaNha.themPhong(phongHoc);
        assertTrue(toaNha.themPhong(phongHoc1),"Phong Hoc Hop Le Phai Duoc Them");
    }
    @org.junit.jupiter.api.Test
    void themPhong_False(){
        ToaNha toaNha = new ToaNha();
        PhongHoc phongHoc = new PhongLyThuyet("2","da",2,2,true);
        PhongHoc phongHoc1 = new PhongLyThuyet("2","da",2,2,true);
        toaNha.themPhong(phongHoc);
        assertFalse(toaNha.themPhong(phongHoc1),"Phong Khong Hop Le Khong Duoc Them");
    }

    @org.junit.jupiter.api.Test
    void timPhong_TonTai(){
        ToaNha toaNha = new ToaNha();
        PhongHoc phongHoc = new PhongLyThuyet("2","da",2,2,true);
        PhongHoc phongHoc1 = new PhongLyThuyet("3","da",2,2,true);
        toaNha.themPhong(phongHoc);
        toaNha.themPhong(phongHoc1);
       assertNotNull(toaNha.timPhong("2"),"Phong co ton tai");
    }

    @org.junit.jupiter.api.Test
    void timPhong_KhongTonTai(){
        ToaNha toaNha = new ToaNha();
        PhongHoc phongHoc = new PhongLyThuyet("2","da",2,2,true);
        PhongHoc phongHoc1 = new PhongLyThuyet("3","da",2,2,true);
        toaNha.themPhong(phongHoc);
        toaNha.themPhong(phongHoc1);
        assertNull(toaNha.timPhong("4"),"Phong khong ton tai");
    }

    @org.junit.jupiter.api.Test
    void danhSachPhongDatChuan_KhongCoPhanTuNao() {
        ToaNha toaNha = new ToaNha();
        PhongHoc phongHoc = new PhongLyThuyet("2","da",100,2,true);
        PhongHoc phongHoc1 = new PhongLyThuyet("3","da",100,2,true);
        toaNha.themPhong(phongHoc);
        toaNha.themPhong(phongHoc1);
        List<PhongHoc> temp = toaNha.danhSachPhongDatChuan();
        assertTrue(temp.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void danhSachPhongDatChuan_CoMotPhanTu(){
        ToaNha toaNha = new ToaNha();
        PhongHoc phongHoc = new PhongLyThuyet("2","da",100,50,true);
        PhongHoc phongHoc1 = new PhongLyThuyet("3","da",100,2,true);
        toaNha.themPhong(phongHoc);
        toaNha.themPhong(phongHoc1);
        assertEquals(1, toaNha.danhSachPhongDatChuan().size());
        assertTrue(toaNha.danhSachPhongDatChuan().get(0).kiemDatChuan());
    }

    @org.junit.jupiter.api.Test
    void danhSachPhongDatChuan_TatCaPhanTu(){
        ToaNha toaNha = new ToaNha();
        PhongHoc phongHoc = new PhongLyThuyet("2","da",100,50,true);
        PhongHoc phongHoc1 = new PhongLyThuyet("3","da",100,40,true);
        toaNha.themPhong(phongHoc);
        toaNha.themPhong(phongHoc1);
        List<PhongHoc> danhSach = toaNha.danhSachPhongDatChuan();
        assertEquals(2, danhSach.size());
        assertTrue(danhSach.stream()
                .allMatch(ph -> ph.kiemDatChuan()));
    }

    @org.junit.jupiter.api.Test
    void sapXepTangDanTheoDayNha(){
        PhongHoc phongHoc = new PhongLyThuyet("2","d",100,50,true);
        PhongHoc phongHoc1 = new PhongLyThuyet("3","c",100,40,true);
        PhongHoc phongHoc2 = new PhongLyThuyet("4","b",100,40,true);
        PhongHoc phongHoc3 = new PhongLyThuyet("5","a",100,40,true);
        List<PhongHoc> sapXep = List.of(phongHoc3,phongHoc2,phongHoc1,phongHoc);
        ToaNha toaNha = new ToaNha();
        toaNha.themPhong(phongHoc);
        toaNha.themPhong(phongHoc1);
        toaNha.themPhong(phongHoc2);
        toaNha.themPhong(phongHoc3);
        List<PhongHoc> canKiemTra = toaNha.sapXepTangDanTheoDayNha();
        assertEquals("a",canKiemTra.get(0).getDayNha());
        assertEquals("b",canKiemTra.get(1).getDayNha());
        assertEquals("c",canKiemTra.get(2).getDayNha());
        assertEquals("d",canKiemTra.get(3).getDayNha());
    }

    @org.junit.jupiter.api.Test
    void sapXepGiamDanTheoDienTich(){
        PhongHoc phongHoc = new PhongLyThuyet("2","d",101,50,true);
        PhongHoc phongHoc1 = new PhongLyThuyet("3","c",102,40,true);
        PhongHoc phongHoc2 = new PhongLyThuyet("4","b",103,40,true);
        PhongHoc phongHoc3 = new PhongLyThuyet("5","a",104,40,true);
        List<PhongHoc> sapXep = List.of(phongHoc3,phongHoc2,phongHoc1,phongHoc);
        ToaNha toaNha = new ToaNha();
        toaNha.themPhong(phongHoc);
        toaNha.themPhong(phongHoc1);
        toaNha.themPhong(phongHoc2);
        toaNha.themPhong(phongHoc3);
        List<PhongHoc> canKiemTra = toaNha.sapXepGiamDanTheoDienTich();
        assertEquals(104,canKiemTra.get(0).getDienTich());
        assertEquals(103,canKiemTra.get(1).getDienTich());
        assertEquals(102,canKiemTra.get(2).getDienTich());
        assertEquals(101,canKiemTra.get(3).getDienTich());
    }

    @org.junit.jupiter.api.Test
    void capNhatMayTinh_KhongTonTaiMaPhong(){
        ToaNha toaNha = new ToaNha();
        PhongHoc phongHoc = new PhongMayTinh("2","d",101,50, 10);
        toaNha.themPhong(phongHoc);
        assertFalse(toaNha.capNhatMayTinh2("1",20),"Ma Khong Ton Tai");
    }

    @org.junit.jupiter.api.Test
    void capNhatMayTinh_KhongCoPhongMayTinh() {
        ToaNha toaNha = new ToaNha();
        PhongHoc phongHoc = new PhongLyThuyet("2","d",101,50, true);
        toaNha.themPhong(phongHoc);
        assertFalse(toaNha.capNhatMayTinh2("2",20),"Khong Phai La Phong May Tinh");
    }

    @org.junit.jupiter.api.Test
    void capNhatMayTinh_SoMayTinhMoiKhongHopLe() {
        ToaNha toaNha = new ToaNha();
        PhongHoc phongHoc = new PhongMayTinh("2","d",101,50, 10);
        toaNha.themPhong(phongHoc);
        assertFalse(toaNha.capNhatMayTinh2("2",-1),"So May Tinh Khong Hop Le");
    }

    @org.junit.jupiter.api.Test
    void capNhatMayTinh_ThanhCong() {
        ToaNha toaNha = new ToaNha();
        PhongHoc phongHoc = new PhongMayTinh("2","d",101,50, 10);
        toaNha.themPhong(phongHoc);
        assertTrue(toaNha.capNhatMayTinh2("2",20),"Phai Them Thanh Cong");
    }

    @org.junit.jupiter.api.Test
    void xoaPhong_MaPhongNULL() {
        ToaNha toaNha = new ToaNha();
        PhongHoc phongHoc = new PhongMayTinh("2","d",101,50, 10);
        toaNha.themPhong(phongHoc);
        assertFalse(toaNha.xoaPhong(null),"Ma Phong NULL");
    }

    @org.junit.jupiter.api.Test
    void xoaPhong_MaPhongRong() {
        ToaNha toaNha = new ToaNha();
        PhongHoc phongHoc = new PhongMayTinh("2","d",101,50, 10);
        toaNha.themPhong(phongHoc);
        assertFalse(toaNha.xoaPhong(""),"Ma Phong NULL");
    }

    @org.junit.jupiter.api.Test
    void xoaPhong_MaPhongKhongTonTai() {
        ToaNha toaNha = new ToaNha();
        PhongHoc phongHoc = new PhongMayTinh("2","d",101,50, 10);
        toaNha.themPhong(phongHoc);
        assertFalse(toaNha.xoaPhong("3"),"Ma Phong Khong Ton Tai");
    }

    @org.junit.jupiter.api.Test
    void xoaPhong_ThanhCong() {
        ToaNha toaNha = new ToaNha();
        PhongHoc phongHoc = new PhongMayTinh("2","d",101,50, 10);
        PhongHoc phongHoc2 = new PhongMayTinh("3","d",101,50, 10);
        toaNha.themPhong(phongHoc);
        toaNha.themPhong(phongHoc2);
        assertTrue(toaNha.xoaPhong("3"),"Phai Xoa Thanh Cong");
        assertEquals(1,toaNha.tongPhongHoc());
    }

    @org.junit.jupiter.api.Test
    void danhSachPhongMay60_Rong() {
        ToaNha toaNha = new ToaNha();
        PhongHoc phongHoc = new PhongMayTinh("2","d",101,50, 10);
        PhongHoc phongHoc2 = new PhongMayTinh("3","d",101,50, 10);
        toaNha.themPhong(phongHoc);
        toaNha.themPhong(phongHoc2);
        List<PhongHoc> temp = toaNha.danhSachPhongMay60();
        assertTrue(temp.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void danhSachPhongMay60_CoMotPhong() {
        ToaNha toaNha = new ToaNha();
        PhongHoc phongHoc = new PhongMayTinh("2","d",101,50, 60);
        PhongHoc phongHoc2 = new PhongMayTinh("3","d",101,50, 10);
        toaNha.themPhong(phongHoc);
        toaNha.themPhong(phongHoc2);
        List<PhongHoc> temp = toaNha.danhSachPhongMay60();
        assertEquals(1,temp.size());
        assertEquals(60,((PhongMayTinh)temp.get(0)).getSoMayTinh());
    }

    @org.junit.jupiter.api.Test
    void danhSachPhongMay60_DaPhanTu() {
        ToaNha toaNha = new ToaNha();
        PhongHoc phongHoc = new PhongMayTinh("2","d",101,50, 60);
        PhongHoc phongHoc2 = new PhongMayTinh("3","d",101,50, 60);
        PhongHoc phongHoc3 = new PhongMayTinh("4","d",101,50, 60);
        PhongHoc phongHoc4 = new PhongMayTinh("5","d",101,50, 61);
        toaNha.themPhong(phongHoc);
        toaNha.themPhong(phongHoc2);
        toaNha.themPhong(phongHoc3);
        toaNha.themPhong(phongHoc4);
        List<PhongHoc> temp = toaNha.danhSachPhongMay60();
        assertEquals(3,temp.size());
        temp.stream()
                .forEach((phong)->{
                        assertTrue(phong instanceof PhongMayTinh,"No La Phong May Tinh");
                        assertEquals(60,((PhongMayTinh)phong).getSoMayTinh());
                });
        //assertFalse(temp.contains(phongHoc4),"Phong Khong Du 60 May Tinh");
        assertTrue(temp.stream()
                .noneMatch(ph -> ((PhongMayTinh)ph).getMaPhong().equalsIgnoreCase("5")),"Phong So 4 Khong Du 60 may");
    }
}
