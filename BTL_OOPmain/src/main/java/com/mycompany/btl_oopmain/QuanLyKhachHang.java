/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.btl_oopmain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Huỳnh Minh Hoàng
 */
public class QuanLyKhachHang {
    private List<KhachHang> dsKH = new ArrayList<>();
    
    //them KH
    public void themKH(KhachHang kh) {
        this.dsKH.add(kh);
    }
    
    //hien thi KH
    public void xuatDSKH() {
        this.dsKH.forEach(KhachHang::hienThiKH);
    }
    
    //tim kiem STK
    public KhachHang timSTK(String stk) {
        return this.dsKH.stream().filter(h -> h.getMaSoKH().equals(stk)).findFirst().get();
    }
    
    //tinh lai suat theo STK
    public void tinhLaiTheoSTK(String stk) {
        KhachHang kh = timSTK(stk);
        for (Account ac : kh.getDsAC()) {
            ac.hienThiTK();
            System.out.printf("Tien lai = %.0fVND\n", ac.tinhTienLai());
        }
    }
    
    
    //tim KH theo Ten
    public KhachHang timKHTheoTen(String ht) {
       return this.dsKH.stream().filter(t -> t.getHoTen().equalsIgnoreCase(ht)).findFirst().get();
    }
    
    //tim KH theo STK
    public KhachHang timKHTheoSTK(String stk) {
        return this.dsKH.stream().filter(t -> t.getMaSoKH().equalsIgnoreCase(stk)).findFirst().get();
    }
    
    //hien thi danh sach tai khoan cua KH dang co
    public KhachHang timDSTKKH(String stk) {
        return this.dsKH.stream().filter(t -> t.getMaSoKH().equals(stk)).findFirst().get();
    }
    
    
    
    
    
    
    
    
    
    
    
    //==============================================
    /**
     * @return the dsKH
     */
    public List<KhachHang> getDsKH() {
        return dsKH;
    }

    /**
     * @param dsKH the dsKH to set
     */
    public void setDsKH(List<KhachHang> dsKH) {
        this.dsKH = dsKH;
    }
    
    
    
}
