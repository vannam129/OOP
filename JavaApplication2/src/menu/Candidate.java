/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;



/**
 *
 * @author Nguyen Dinh
 */
public abstract class Candidate {
    protected String firstName;
    protected String lastName;
    protected String birthDate;
    protected String address;
    protected String phone;
    protected String email;
    protected String id;

    public Candidate() {
    }

    public Candidate(String firstName, String lastName, String birthDate, String address, String phone, String email, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }

    public void createCandidate() {
        System.out.println(" Create Candidate:");
        this.id = Utils.getString("ID:");
        this.firstName = Utils.getString("first Name:");
        this.lastName = Utils.getString("Last Name:");
        this.phone = Utils.getString("phone:");
        this.address = Utils.getString("Address:");
        this.email = Utils.getString("Email:");
        this.birthDate = Utils.getString("Birth Date:");
    }

    public void updateCandidate() {
        System.out.println(" update Candidate:");
        this.id = Utils.updateString(this.id, "ID:");
        this.firstName = Utils.updateString(this.firstName, "First Name:");
        this.lastName = Utils.updateString(this.lastName, "Last Name:");
        this.address = Utils.updateString(this.address, "Address:");
        this.phone = Utils.updateString(this.phone, "Phone:");
        this.email = Utils.updateString(this.email, "Email:");
        this.birthDate = Utils.updateString(this.birthDate, "Birth Date:");

    }

    @Override
    public String toString() {
        return this.id + ", " + this.firstName + ", " + this.lastName + ", " + this.address + ", " + this.phone + ", " + this.birthDate + ", " + this.email;
    }
}

