/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6;

/**
 *
 * @author Nguyen Dinh
 */
public class UniversityProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MinistryOfEducation s1 = new FPTUni();
        System.out.println("1.Khung chương trình đại học FPT");
        s1.curriculum();

        MinistryOfEducation s2 = new TonDucThangUni();
        System.out.println("2.Khung chương trình đại học Tôn Đức Thắng");
        s2.curriculum();

        MinistryOfEducation s3 = new BachKhoaUni();
        System.out.println("3.Khung chương trình đại học Bách Khoa TP.HCM");
        s3.curriculum();

    }
}
