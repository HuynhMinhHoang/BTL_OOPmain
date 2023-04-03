/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.btl_oopmain;

import java.text.ParseException;

/**
 *
 * @author Huỳnh Minh Hoàng
 */
public class demo {

    public static void main(String[] args) throws ParseException {
        int chon;
        boolean flag = true;
        QuanLyKhachHang qkKH = new QuanLyKhachHang();

        do {
            System.out.println("***** MENU *****");
            System.out.print("1. Nhap thong tin khach hang\n"
                    + "2. Xuat thong tin Khach Hang\n"
                    + "3. Tinh tien lai theo STK Khach Hang\n"
                    + "4. Tra cuu Khach Hang theo Ho&ten, STK Khach Hang\n"
                    + "5. Tra cuu danh sach TK, theo STK Khach Hang\n"
                    + "6. Sap xep Khach Hang giam dan\n"
                    + "7. DANG NHAP\n"
                    + "8. Thoat chuong trinh\n"
                    + "Ban chon?: ");
            chon = DungChung.sc.nextInt();
            switch (chon) {
                case 1: {
                    System.out.print("==== NHAP THONG TIN KHACH HANG ==== \n");
                    KhachHang kh = new KhachHang();
                    kh.nhapKH();
                    Account acc = new TaiKhoan(kh.getSoTienGui());
                    kh.themAccount(acc);
                    qkKH.themKH(kh);
                    System.out.printf("*Password: %d\n", acc.matKhau);
                    break;
                }//cs1

                case 2: {
                    System.out.println("==== DANH SACH THONG TIN KHACH HANG ====");
                    qkKH.xuatDSKH();
                    break;
                }//cs2
                
                case 3:{
                    DungChung.sc.nextLine();
                    System.out.print("Nhap STK: ");
                    String stk = DungChung.sc.nextLine();
                    qkKH.tinhLaiTheoSTK(stk);
                }//cs3
                
                case 4: {
                    int chon2;
                    System.out.println("=== TIM KIEM ===");
                    System.out.print("1. Tim kiem Khach Hang theo Ho & ten\n"
                            + "2. Tim kiem Khach Hang theo STK Khach Hang\n"
                            + "3. Tim kiem Danh sach tai khoan cua Khach Hang\n"
                            + "4. Thoat\n"
                            + "Ban chon?: ");
                    chon2 = DungChung.sc.nextInt();
                    switch (chon2) {
                        case 1: {
                            DungChung.sc.nextLine();
                            System.out.print("Nhap ten Khach Hang can tim kiem: ");
                            String s = DungChung.sc.nextLine();
                            KhachHang kh = qkKH.timKHTheoTen(s);
                            System.out.println("==== THONG TIN KHACH HANG THEO TEN ====");
                            kh.hienThiKH();
                            break;
                        }
                        case 2:{
                            DungChung.sc.nextLine();
                            System.out.print("Nhap ma so Khach Hang can tim kiem: ");
                            String s = DungChung.sc.nextLine();
                            KhachHang kh = qkKH.timKHTheoSTK(s);
                            System.out.println("==== THONG TIN KHACH HANG THEO STK ====");
                            kh.hienThiKH();
                            break;
                        }
                        case 3:{
                            DungChung.sc.nextLine();
                            System.out.print("Nhap ma so Khach Hang can tim kiem: ");
                            String s = DungChung.sc.nextLine();
                            KhachHang kh = qkKH.timDSTKKH(s);
                            System.out.println("==== THONG TIN DS KHACH HANG THEO STK ====");
                            kh.xuatAccount();
                            break;
                        }
                    }//sw2                           
                }//cs4
            }//sw1

        } while (true);

    }//main
}
