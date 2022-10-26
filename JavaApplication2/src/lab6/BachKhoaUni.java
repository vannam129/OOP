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
public class BachKhoaUni extends MinistryOfEducation implements BasicEducation,AdvancedEducation,Major {
    @Override
    public void basicTrain() {
        System.out.println("Dạy Lập Trình Cơ Bản: Java");
    }
    @Override
    public void advanceTrain() {
        System.out.println("Dạy Phân Tích Thiết Kế Hệ Thống");
    }
    @Override
    public void majorTrain() {
        System.out.println("Dạy Data, Network,Mobile");
    }
    
    @Override
    public void curriculum() {
        System.out.print("- Basic: ");
        basicTrain();
        System.out.print("- Advance: ");
        advanceTrain();
        System.out.print("- Major:");
        majorTrain();
    }
}
