/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

/**
 *
 * @author Nguyen Dinh
 */
public class Main {

    public static void main(String[] args) {
        Candidate cd = new Candidate();

        System.out.println(" Defailt information:");
        System.out.println(cd.toString());

        System.out.println("Create Candidate:");
        cd.createCandidate();
        System.out.println(cd.toString());

        System.out.println("Update Candidate:");
        cd.updateCandidate();
        System.out.println(cd.toString());

        Experience ex = new Experience();

        System.out.println("Default experience information:");
        System.out.println(ex.toString());

        System.out.println("Create information:");
        ex.createCandidate();
        System.out.println(ex.toString());

        System.out.println("Update Information:");
        ex.updateCandidate();
        System.out.println(ex.toString());

        Fresher fr = new Fresher();

        System.out.println(" Default fresher information");
        System.out.println(fr.toString());

        System.out.println("Create information");
        fr.createCandidate();
        System.out.println(fr.toString());

        System.out.println("Update Information:");
        fr.updateCandidate();
        System.out.println(fr.toString());

        Intern it = new Intern();

        System.out.println("Default intern information");
        System.out.println(it.toString());

        System.out.println("Create information");
        it.createCandidate();
        System.out.println(it.toString());

        System.out.println("Update Information:");
        it.updateCandidate();
        System.out.println(it.toString());

    }
}
