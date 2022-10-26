/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

/**
 *
 * @author Nguyen Dinh
 */
public class Lab2 {
    protected String phone;
    protected String mail;
    protected String date;

    public Lab2() {

    }

    public Lab2(String phone, String mail, String date) {
        this.phone = phone;
        this.mail = mail;
        this.date = date;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void phone() {
        this.phone = Utils.getPhone();
        String ph;
        ph = getPhone();
        System.out.println("phone:" + phone);
    }

    public void date() {
        this.date = Utils.getDate();
        String dateOfBirth = getDate();

    }

    public void mail() {
        this.mail = Utils.getMail();
        String email;
        email = getMail();
        System.out.println("email:" + email);
    }
}


