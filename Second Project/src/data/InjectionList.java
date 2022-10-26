/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import tools.Color;
import java.io.File;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import tools.Validation;
/**
 *
 * @author PC
 */
public class InjectionList implements FileOperation {

    ArrayList<Injection> injectionList;
    StudentList stdl = new StudentList();
    VaccineList vl = new VaccineList();
    File i = new File("injection.txt");

    public InjectionList() {
        injectionList = new ArrayList<>();
        if (stdl.s.exists() == false) {
            stdl.saveFile();
        } else {
            stdl.readFile();
        }

        if (vl.v.exists() == false) {
            vl.saveFile();
        } else {
            vl.readFile();
        }

        if (i.exists() == false) {
            saveFile();
        } else {
            readFile();
        }
    }

    public void displayByStudentId(String studentId) {
        System.out.println(Color.GREEN_BACKGROUND + Color.WHITE + "==============================INJJECTION INFORMATION=======================================" + Color.RESET);
        System.out.println("| ID|     1st place      |      2nd place     |  1st date  |  2nd date  |Student ID| Vaccine ID |");
        for (Injection injection : injectionList) {
            if (injection.getStudentId().equals(studentId)) {
                injection.output();
                System.out.println("\n");
            }
        }
    }

    public int findInjectionReturnId(int id) {
        for (Injection injection : injectionList) {
            if (injection.getInjectionId() == id) {
                return injection.getInjectionId();
            }
        }
        return -1;
    }

    public Injection findInjectionReturnObj(int id) {
        for (Injection injection : injectionList) {
            if (injection.getInjectionId() == id) {
                return injection;
            }
        }
        return null;
    }

    public Injection findInjectionReturnObjByStudentId(String studentId) {
        for (Injection injection : injectionList) {
            if (injection.getStudentId().equalsIgnoreCase(studentId)) {
                return injection;
            }
        }
        return null;
    }

    public void displayInjectionList() {
        System.out.println(Color.GREEN_BACKGROUND + Color.WHITE + "==============================INJJECTION INFORMATION=======================================" + Color.RESET);
        System.out.println("| ID|     1st place      |      2nd place     |  1st date  |  2nd date  |Student ID| Vaccine ID |");
        for (Injection injection : injectionList) {
            injection.output();
            System.out.println("\n");
        }
    }

    public boolean validateDate(Date firstDate, Date secondDate) {
        //Đổi Date -> String
        String date1 = Validation.convertDateToString(firstDate);
        String date2 = Validation.convertDateToString(secondDate);
        //Đổi String thành LocalDate
        LocalDate ld1 = LocalDate.parse(date1, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate ld2 = LocalDate.parse(date2, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        //xác định khoảng tg giữa 2 ngày này
        Duration periodTime = Duration.between(ld1.atStartOfDay(), ld2.atStartOfDay());
        //đổi khoảng tg đó ra ngày
        long conditionTime = periodTime.toDays();
        //so sánh khoảng tg đó có trong 4-12 tuần ko
        if (conditionTime >= 28 && conditionTime <= 84) {
            return true;
        }
        return false;
    }

    public void displayStudentList() {
        stdl.displayStudentList();
    }

    public void displayVaccineList() {
        vl.displayVaccineList();
    }

    public void addNewInjectionInfo() {
        Injection i = new Injection();
        do {
            System.out.print("Injection ID : ");
            i.setInjectionId(Validation.checkInteger(100, "ID must between 1 to 100"));
            if (findInjectionReturnId(i.getInjectionId()) != -1) {
                System.out.println(Color.RED + "Id existed! Please input again!" + Color.RESET);
            }
        } while (findInjectionReturnId(i.getInjectionId()) != -1);

        displayStudentList();

        System.out.print("\nStudent ID : ");
        i.setStudentId(Validation.checkPattern("^[S]{1}[E]{1}\\d{6}$", "Invalid Student ID!!"));

        if (stdl.takeCode(i.getStudentId()) == 2) {
            System.out.println(Color.GREEN + "\nStudent has compeleted 2 injections" + Color.RESET);
            return;
        } else if (stdl.takeCode(i.getStudentId()) == 1) {
            System.out.println(Color.YELLOW + "\nThis Student already have 1 injection!" + Color.RESET);
            System.out.println(Color.YELLOW + "If you want to update 2nd information. Go to Update Function <3>\n" + Color.RESET);
            return;
        } else if (stdl.takeCode(i.getStudentId()) == 0) {
            System.out.print("Injection 1st place : ");
            i.setFirstPlace(Validation.checkAnString("1st place must be filled!!"));
            System.out.print("Injection 1st date : ");
            i.setFirstDate(Validation.CheckTime(""));
            i.setSecondPlace("null");
            i.setSecondDate(null);

            displayVaccineList();
            System.out.print("Vaccine ID : ");

            i.setVaccineId(Validation.checkPattern("^[cC]{1}[oO]{1}[vV]{1}[iI]{1}[dD]{1}[-]{1}[vV]{1}[0]{1}[0]{1}[1-5]{1}$",
                    "Invalid Vaccine ID!!"));
            stdl.takeStudent(i.getStudentId()).setCode(1);
        }

        if (injectionList.add(i)) {
            System.out.println(Color.GREEN + "\nAdd Successfully" + Color.RESET);
        } else {
            System.out.println(Color.RED + "Add Fail!! Try again" + Color.RESET);
        }
    }

    public void updateInjectionInfo() {
        int injectionId;
        do {
            System.out.println("");
            displayInjectionList();
            System.out.print("Input the Injection ID to update : ");
            injectionId = Validation.checkInteger(100, "ID must between 1 to 100");

            if (findInjectionReturnId(injectionId) == -1) {
                System.out.println(Color.RED + "Injection does not exist!!" + Color.RESET);
            }
        } while (findInjectionReturnId(injectionId) == -1);

        if (!findInjectionReturnObj(injectionId).getSecondPlace().equalsIgnoreCase("null") && findInjectionReturnObj(injectionId).getSecondDate() != null) {
            System.out.println(Color.GREEN + "\nStudent has compeleted 2 injections" + Color.RESET);
            return;
        } else if (findInjectionReturnObj(injectionId).getSecondPlace().equalsIgnoreCase("null") && findInjectionReturnObj(injectionId).getSecondDate() == null) {
            System.out.print("Input the Injection 2nd place to update : ");
            findInjectionReturnObj(injectionId).setSecondPlace(Validation.checkAnString("2nd place must be filled!!"));
            do {
                System.out.print("Input the Injection 2nd date to update : ");
                findInjectionReturnObj(injectionId).setSecondDate(Validation.CheckTime(""));
                if (validateDate(findInjectionReturnObj(injectionId).getFirstDate(), findInjectionReturnObj(injectionId).getSecondDate()) == false) {
                    System.out.println(Color.RED + "The second injection must be after 4-12 weeks!!" + Color.RESET);
                } else {
                    break;
                }
            } while (validateDate(findInjectionReturnObj(injectionId).getFirstDate(), findInjectionReturnObj(injectionId).getSecondDate()) == false);
            stdl.takeStudent(findInjectionReturnObj(injectionId).getStudentId()).setCode(2);
            System.out.println(Color.GREEN + "\nUpdate success!!" + Color.RESET);
        }
    }

    public void deleteInjection() {
        int injectionId, confirm;
        do {
            System.out.print("\nInput the Injection ID to delete : ");
            injectionId = Validation.checkInteger(100, "ID must between 1 to 100");
            if (findInjectionReturnId(injectionId) == -1) {
                System.out.println(Color.RED + "Injection does not exist!!" + Color.RESET);
            }
        } while (findInjectionReturnId(injectionId) == -1);

        System.out.println("\nDo you really want to delete? (1: yes || 2: no)");
        System.out.print(">>Your choice: ");
        confirm = Validation.checkInteger(2, "Your choice must be 1 or 2");
        
        if (confirm == 1) {
            stdl.takeStudent(findInjectionReturnObj(injectionId).getStudentId()).setCode(0);
            if (injectionList.remove(findInjectionReturnObj(injectionId))) {
                System.out.println(Color.GREEN + "\nDelete Successfully" + Color.RESET);           
            } else {
                System.out.println(Color.RED + "\nDelete fail!" + Color.RESET);
            }
        }
    }
    String studentId;

    public Injection searchByStudentId(String studentId) {
        for (Injection injection : injectionList) {
            if (injection.getStudentId().contains(studentId)) {
                return injection;
            }
        }
        return null;
    }

    public void searchInjectionByStudentId() {
        String studentId;
        System.out.print("Input the Student ID to search : ");
        studentId = Validation.checkPattern("^[S]{1}[E]{1}[0-9]{6}$", "Invalid ID");
        if (searchByStudentId(studentId) == null) {
            System.out.println(Color.RED + "\nCan not find the infomation!!" + Color.RESET);
        } else {
            displayByStudentId(studentId);
        }
    }

    @Override
    public void saveFile() {
        try {
            //FileOutputStream fos = new FileOutputStream(i);
            //ObjectOutputStream oos = new ObjectOutputStream(fos);
            FileOutputStream fo = new FileOutputStream(i);
            OutputStreamWriter osw = new OutputStreamWriter(fo, "UTF8");
            FileWriter fw = new FileWriter(i);
            PrintWriter pw=new  PrintWriter(fw);

            if (injectionList.isEmpty()) {
                injectionList.add(new Injection(1, "bv Gò Vấp", "null",
                        Validation.convertStringToDate("21/2/2021"), null, "SE150934", "Covid-V001"));
                injectionList.add(new Injection(2, "bv Thống Nhất", "null",
                        Validation.convertStringToDate("13/5/2021"), null, "SE151109", "Covid-V002"));
                injectionList.add(new Injection(3, "bv Bình Thạnh", "bv Nhân Sinh",
                        Validation.convertStringToDate("9/3/2021"), Validation.convertStringToDate("9/5/2021"), "SE151170", "Covid-V003"));
            }
            

            for (Injection injection : injectionList) {
                pw.println(injection.getInjectionId()+","+injection.getFirstPlace()+","+Validation.convertDateToString(injection.getFirstDate())
                        +","+injection.getSecondPlace()+","+Validation.convertDateToString(injection.getSecondDate())+","+injection.getStudentId()+","+injection.getVaccineId());
            }
        fo.close();
        osw.close();
        fw.close();
        pw.close();
            System.out.println(Color.GREEN + "Saved!!" + Color.RESET);
        } catch (Exception e) {
            System.out.println(Color.RED + e.getMessage() + Color.RESET);
        }
    }

    @Override
    public void readFile() {
        try {
            FileInputStream fis = new FileInputStream(i);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while (fis.available() > 0) {
                Injection injection = (Injection) ois.readObject();
                injectionList.add(injection);
            }
            System.out.println(Color.GREEN + "Read success!!" + Color.RESET);
            ois.close();
            fis.close();
        } catch (Exception e) {
            System.out.println(Color.RED + e.getMessage() + Color.RESET);
        }
    }

}
