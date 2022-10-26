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
public class FPTUni extends MinistryOfEducation implements BasicEducation,AdvancedEducation,Major {
     @Override
    public void basicTrain() {
        System.out.println("Dạy Lập Trình Cơ Bản:C++");
    }
    @Override
    public void advanceTrain() {
        System.out.println("Dạy Kiến Trúc Hệ Thống");
    }
    @Override
    public void majorTrain() {
        System.out.println("Dạy Data, Network");
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
