/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.btl_oopmain;

import java.text.ParseException;
import java.time.Clock;

/**
 *
 * @author Huỳnh Minh Hoàng
 */
public class demo {

    public static void main(String[] args) throws ParseException {
        boolean f = true;
        int chon1 = 0;
        KhachHang kh1 = new KhachHang("hoang", "nam", "gl", "23233", "23/09/2001", 200000, "hoangou");
        Account acc1 = new TaiKhoan(kh1.getSoTienGui());
        Account acc2 = new TaiKhoanCoKyHan(KyHan.MOT_TUAN, 110000);
        kh1.themAccount(acc1, acc2);
        System.out.printf("*Password: %d\n", acc1.matKhau);
        
        QuanLyKhachHang qkKH = new QuanLyKhachHang();
        qkKH.themKH(kh1);

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
//                                acc1.hienThiTK();
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
                        System.out.print(""
                                + "1. Mo Tai Khoan Co Ky Han\n"
                                + "2. Nop tien vao TK Chinh\n"
                                + "3. Rut tien TK Chinh\n"
                                + "4. Rut tien TK co ky han\n"
                                + "5. Doi mat khau\n"
                                + "6. Dang xuat!\n"
                                + "Ban chon?: ");
                        chon3 = DungChung.sc.nextInt();

                        switch (chon3) {
                            case 1: {
                                double tiengui;
                                do
                                {
                                    System.out.print("Nhap so tien muon gui (>=100000): ");
                                    tiengui = DungChung.sc.nextDouble();
                                }while(tiengui<100000);
                                        
                                double tienconlai = acc1.soDu - tiengui;
                                acc1.soDu=tienconlai;
                                if(tienconlai <  50000 || tiengui < 100000)
                                {
                                    System.out.print("Khong du tien de mo tai khoang co ki han!");                              
                                } else {
                                    System.out.println("    Chon ky han\n"
                                            + "     1. 1 tuan \n"
                                            + "     2. 1 thang \n"
                                            + "     3. 6 thang \n"
                                            + "     4. 1 nam");
                                    int chonkyhan = DungChung.sc.nextInt();
                                    Account acc;
                                    switch (chonkyhan) {
                                        case 1: {
                                            acc = new TaiKhoanCoKyHan(KyHan.MOT_TUAN, tiengui);
                                            kh.themAccount(acc);
                                            System.out.println("=== THONG TIN TAI KHOAN VUA TAO ===");
                                            acc.hienThiTK();
                                        }
                                        break;
                                        case 2: {
                                            acc = new TaiKhoanCoKyHan(KyHan.MOT_THANG, tiengui);
                                            kh.themAccount(acc);
                                            acc.hienThiTK();
                                        }
                                        break;

                                        case 3: {
                                            acc = new TaiKhoanCoKyHan(KyHan.SAU_THANG, tiengui);
                                            kh.themAccount(acc);
                                            acc.hienThiTK();
                                        }
                                        break;

                                        case 4: {
                                            acc = new TaiKhoanCoKyHan(KyHan.MUOIHAI_THANG, tiengui);
                                            kh.themAccount(acc);
                                            acc.hienThiTK();                                            
                                        }
                                        break;
                                    }
                                }
                            break;
                            }
                            case 2: {
                                System.out.print("So tien muon nap vao TK Chinh: ");
                                double tiennapTKC = DungChung.sc.nextDouble();
                                acc1.nopTien(tiennapTKC);
                                System.out.printf("So du TKChinh sau khi nap: %.0f\n", acc1.getSoDu() );                                
                                acc1.getSoDu();
                                
                                break;
                            }
                            case 3: {
                                
                            }
                            case 4: {
                                
                            }

                        }//sw3
                    } while (chon3 < 6);
                    break;
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
