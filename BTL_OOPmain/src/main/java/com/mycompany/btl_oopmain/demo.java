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
        boolean f = true;
        int chon1 = 0;
        QuanLyKhachHang qkKH = new QuanLyKhachHang();

        while (f) {
            System.out.println("*********** MENU ***********");
            System.out.print("1. Nhap thong tin khach hang\n"
                    + "2. Xuat thong tin Khach Hang\n"
                    + "3. Tinh tien lai theo STK Khach Hang\n"
                    + "4. Tim kiem Khach Hang\n"
                    + "5. Sap xep Khach Hang giam dan theo so tien\n"
                    + "6. DANG NHAP\n"
                    + "7. Thoat chuong trinh\n"
                    + "Ban chon?: ");
            chon1 = DungChung.sc.nextInt();
            switch (chon1) {
                case 1: {
                    System.out.print("\n==== NHAP THONG TIN KHACH HANG ==== \n");
                    KhachHang kh = new KhachHang();
                    kh.nhapKH();
                    Account acc = new TaiKhoan(kh.getSoTienGui());
                    kh.themAccount(acc);
                    qkKH.themKH(kh);
                    System.out.printf("*Password: %d\n", acc.matKhau);
                    break;
                }//cs1

                case 2: {
                    System.out.println("\n==== DANH SACH THONG TIN KHACH HANG ====");
                    qkKH.xuatDSKH();
                    break;
                }//cs2

                case 3: {
                    DungChung.sc.nextLine();
                    System.out.print("Nhap STK: ");
                    String stk = DungChung.sc.nextLine();

                    qkKH.tinhLaiTheoSTK(stk);
                    break;
                }//cs3

                case 4: {
                    int chon2;
                    System.out.println("\n=== TIM KIEM ===");
                    System.out.print("1. Tim kiem Khach Hang theo Ho & ten\n"
                            + "2. Tim kiem Khach Hang theo STK Khach Hang\n"
                            + "3. Tim kiem danh sach tai khoan cua Khach Hang\n"
                            + "4. Thoat\n"
                            + "Ban chon?: ");
                    chon2 = DungChung.sc.nextInt();
                    switch (chon2) {
                        case 1: {
                            DungChung.sc.nextLine();
                            System.out.print("Nhap ho va ten Khach Hang can tim kiem: ");
                            String s = DungChung.sc.nextLine();
                            KhachHang kh = qkKH.timKHTheoTen(s);

                            if (kh != null) {
                                System.out.println("\n==== THONG TIN KHACH HANG THEO HO&TEN ====");
                                kh.hienThiKH();
                            } else {
                                System.out.println("Khong tim thay khach hang nao!");
                            }
                            break;
                        }
                        case 2: {
                            DungChung.sc.nextLine();
                            System.out.print("Nhap ma so Khach Hang can tim kiem: ");
                            String s = DungChung.sc.nextLine();
                            KhachHang kh = qkKH.timKHTheoSTK(s);

                            if (kh != null) {
                                System.out.println("\n==== THONG TIN KHACH HANG THEO STK ====");
                                kh.hienThiKH();
                            } else {
                                System.out.println("Khong tim thay khach hang nao!");
                            }
                            break;
                        }
                        case 3: {
                            DungChung.sc.nextLine();
                            System.out.print("Nhap ma so Khach Hang can tim kiem: ");
                            String s = DungChung.sc.nextLine();
                            KhachHang kh = qkKH.timDSTKKH(s);

                            if (kh != null) {
                                System.out.println("\n==== THONG TIN DS TAI KHOAN CUA KHACH HANG THEO STK ====");
                                kh.xuatAccount();
                            } else {
                                System.out.println("Khong tim thay khach hang nao!");
                            }
                            break;
                        }
                        case 4: {
                            break;
                        }
                    }//sw2                   
                    break;
                }//cs4

                case 5: {
                    qkKH.sapXepKH();
                    System.out.println("\n===== SAP XEP KHACH HANG =====");
                    qkKH.xuatDSKH();
                    break;
                }//cs5
                case 6: {
                    KhachHang kh;
                    String username;
                    int password;

                    DungChung.sc.nextLine();
                    System.out.print("Username: ");
                    username = DungChung.sc.nextLine();

                    System.out.print("Password: ");
                    password = DungChung.sc.nextInt();

                    kh = qkKH.dangNhap(username, password);
                    if (kh == null) {
                        System.out.println("SAI tai khoan hoac mat khau!!");
                        break;
                    }

                    int chon3;
                    do {
                        System.out.printf("\n=== MENU KHACH HANG ===\n*STK: %s\n*Ho & ten: %s\n", kh.getMaSoKH(), kh.getHoTen());
                        System.out.print("1. Mo Tai Khoan Co Ky Han\n"
                                + "2. Nop tien\n"
                                + "3. Rut tien\n"
                                + "4. Rut tien TK co ky han\n"
                                + "5. Doi mat khau\n"
                                + "6. Thoat!\n"
                                + "Ban chon?: ");
                        chon3 = DungChung.sc.nextInt();

                        switch (chon3) {
                            case 6: {
                            }
                            
                            
                            
                            
                        }//sw3
                    } while (chon3 < 6);

                }//cs6
                case 7: {
                    System.out.println("Tam biet!");
                    f = false;
                    break;
                }
                default: {
                    System.out.println("Vui long nhap lai!!");
                }
            }//sw1

        }

    }//main
}
