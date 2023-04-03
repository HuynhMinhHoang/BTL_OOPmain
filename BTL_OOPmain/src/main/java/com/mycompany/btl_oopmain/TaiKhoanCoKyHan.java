/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.btl_oopmain;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Huỳnh Minh Hoàng
 */
public class TaiKhoanCoKyHan extends Account {

    private Calendar ngayDaoHan;
    private KyHan kyHan;

    public TaiKhoanCoKyHan(Calendar ngayDaoHan, KyHan kyHan, double soDu, String loaiTK) {
        this.ngayDaoHan = this.kyHan.tinhDaoHan(new GregorianCalendar());
        this.kyHan = kyHan;
        this.setLoaiTK("TAI KHOAN CO KY HAN");
    }

//    public TaiKhoanCoKyHan(KyHan kyHan, double st) {
//        this.setSoDu(st);
//        this.kyHan = kyHan;
//        this.ngayDaoHan = this.kyHan.tinhDaoHan(new GregorianCalendar());
//        this.setLoaiTK("Tài khoản kỳ hạn");
//    }

    @Override
    public double tinhTienLai() {
        return this.kyHan.tinhTienLai(this.soDu);
    }

    public boolean isKTDaoHan() {
        Calendar dmy = new GregorianCalendar();
        String d1 = DungChung.f.format(dmy.getTime());
        String d2 = DungChung.f.format(this.ngayDaoHan.getTime());
        return d1.equals(d2);
        
    }

//    @Override
//    public void withDrawMoney(double money) {
//        if (money <= this.getMoney()) {
//            if (!isDueDate()) {
//                System.out.println("Chưa đến hạn rút tiền! Gõ 1 để rút tiền gốc hoặc phím khác để không rút tiền:");
//                int s = Static.sc.nextInt();
//                if (s == 1) {
//                    if (money == this.getMoney()) {
//                        this.withDrawMoney();
//                    } else {
//                        this.term = KyHan.origin;
//                        this.money = super.sumMoney();
//                        super.withDrawMoney(money);
//                    }
//                }
//            } else {
//                this.money = super.sumMoney();
//                super.withDrawMoney(money);
//            }
//        } else
//            System.out.println("Số tiền lớn hơn số tiền hiện có trong tài khoản");
//    }

//    @Override
//    public void withDrawMoney() {
//        if (isDueDate()) {
//            this.money = super.sumMoney();
//            super.withDrawMoney();
//        }
//    }
    
    @Override
    public void hienThiTK() {
        super.hienThiTK();
        System.out.printf("Ky han = %s\n", this.kyHan);
    }
    
    
    
    
    //=============================================
    /**
     * @return the ngayDaoHan
     */
    public Calendar getNgayDaoHan() {
        return ngayDaoHan;
    }

    /**
     * @param ngayDaoHan the ngayDaoHan to set
     */
    public void setNgayDaoHan(Calendar ngayDaoHan) {
        this.ngayDaoHan = ngayDaoHan;
    }

    /**
     * @return the kyHan
     */
    public KyHan getKyHan() {
        return kyHan;
    }

    /**
     * @param kyHan the kyHan to set
     */
    public void setKyHan(KyHan kyHan) {
        this.kyHan = kyHan;
    }
    
    
}
