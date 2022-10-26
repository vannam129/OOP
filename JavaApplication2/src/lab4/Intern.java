/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

public class Intern extends Candidate {

    private String major;
    private String semester;
    private String universityName;

    public Intern() {
    }

    public Intern(String major, String semester, String universityName, String firstName, String lastName, String birthDate, String address, String phone, String email, String id) {
        super(firstName, lastName, birthDate, address, phone, email, id);
        this.major = major;
        this.semester = semester;
        this.universityName = universityName;
    }

    public String getMajor() {
        return major;
    }

    public String getSemester() {
        return semester;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + this.major + ", " + this.semester + ", " + this.universityName;
    }

    @Override
    public void updateCandidate() {
        super.updateCandidate();
        this.major = Utils.updateString(this.major, "Major:");
        this.semester = Utils.updateString(this.semester, "Semester:");
        this.universityName = Utils.updateString(this.universityName, "what is the name of your university?:");

    }

    @Override
    public void createCandidate() {
        super.createCandidate();
        this.major = Utils.getString("Major:");
        this.semester = Utils.getString("Semester:");
        this.universityName = Utils.getString("what is the name of your university?:");
    }

}


