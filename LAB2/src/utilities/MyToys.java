/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class MyToys {
     /// Khai báo biến Scanner dùng static để dùng chung cho các hàm bên trong class.
    private static Scanner sc = new Scanner(System.in);

    // - mọi sự nhập không đúng format sẽ bị thông báo lỗi, ví dụ nhập chuỗi thay vì
    // nhập số
    // - chống trôi lệnh, tức là ko để lại rác Enter hay kí tự nào đó
    // trong buffer sau hốt
    // - có thể kiểm tra số nguyên trong 1 range/khoảng cho trước
    // - có câu thông báo động, tùy ngữ cảnh
    public static int getAnInteger(String inputMsg, String errorMsg, int lowerBound, int upperBound) {
        int n, tmp;
        // nếu đầu vào lower > upper thì đổi chỗ
        if (lowerBound > upperBound) {
            tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Integer.parseInt(sc.nextLine());
                if (n < lowerBound || n > upperBound) {
                    throw new Exception();
                }
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static double getADouble(String inputMsg, String errorMsg, double lowerBound, double upperBound) {
        double n, tmp;
        // nếu đầu vào lower > upper thì đổi chỗ
        if (lowerBound > upperBound) {
            tmp = lowerBound;
            lowerBound = upperBound;
            upperBound = tmp;
        }
        while (true) {
            try {
                System.out.print(inputMsg);
                n = Double.parseDouble(sc.nextLine());
                if (n < lowerBound || n > upperBound)
                    throw new Exception();
                return n;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static String getString(String inputMsg, String errorMsg) {
        String id;
        while (true) {
            System.out.print(inputMsg);
            id = sc.nextLine().trim().toUpperCase();
            if (id.length() == 0 || id.isEmpty())
                System.out.println(errorMsg);
            else
                return id;
        }
    }

    public static String inputNonBlankStr(String msg) {
        String data;
        do {
            System.out.print(msg);
            data = sc.nextLine().trim();
        } while (data.length() < 1);
        return data;
    }

    // nhập vào một chuỗi kí tự, theo định dạng đc đưa vào
    // định dạng xài Regular Expression
    public static String getID(String inputMsg, String errorMsg, String format) {
        String id;
        boolean match;
        while (true) {
            System.out.print(inputMsg);
            id = sc.nextLine().trim();
            match = id.matches(format);
            if (id.length() == 0 || id.isEmpty() || match == false)
                System.out.println(errorMsg);
            else
                return id;
        }
    }

    public static boolean getAYN(String msg) {
        if (msg.isEmpty()) {
            msg = "Do you want to continue?(Y/N) ";
        }
        String check = getID(msg, "Input invalid. Please input Y/N or y/n only", "^[YNyn]$");
        return check.equalsIgnoreCase("y");
    }

    // kiem tra id ban nhap vao xem co chac chan muon xoa hay khong
    public static boolean getCheckForRemove(String msg) {
        if (msg.isEmpty()) {
            msg = "Are you sure to remove the food ? ";
        }
        String check = getID(msg, "Input invalid. Please input Y/N or y/n only", "^[YNyn]$");
        return check.equalsIgnoreCase("n");
    }

    // Hàm nhập vào câu thông báo nhập ngày, ép kiểu String thành Date
    public static Date getDate(String msg) {
        String tmp;
        DateValidator validator = new DateValidatorUsingDateFormat("dd/MM/yyyy");
        Date tmp2;
        while (true) {
            tmp = getString(msg, "Date Is Required");
            tmp2 = validator.isValid02(tmp);
            if (tmp2 != null) {
                break;
            }
            if (tmp.isEmpty()) {
                return tmp2 = null;

            }
        }
        return tmp2;
    }

    public static Date getSecondDate(String msg) {
        String tmp;
        DateValidator validator = new DateValidatorUsingDateFormat("dd/MM/yyyy");
        Date tmp2;
        while (true) {
            tmp = getString(msg, "Date Is Required");
            tmp2 = validator.isValid02(tmp);
            if (tmp2 != null) {
                break;
            }
            if (tmp.isEmpty()) {
                return tmp2 = null;
            }
        }
        return tmp2;
    }
}
