/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;


public class Fresher extends Candidate {

    private String graduationDate;
    private String graduationRank;
    private String education;

    public Fresher() {
    }

    public Fresher(String graduationDate, String graduationRank, String education, String firstName, String lastName, String birthDate, String address, String phone, String email, String id) {
        super(firstName, lastName, birthDate, address, phone, email, id);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    public void setGraduationDate(String graduationDate) {
        this.graduationDate = graduationDate;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getGraduationDate() {
        return graduationDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public String getEducation() {
        return education;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + this.graduationDate + ", " + this.graduationRank + ", " + this.education;
    }

    @Override
    public void updateCandidate() {
        super.updateCandidate();
        this.graduationDate = Utils.updateString(this.graduationDate, "Graduated date: ");
        this.graduationRank = Utils.updateString(this.graduationRank, "Graduated rank: ");
        this.education = Utils.updateString(this.education, "university where student graduated: ");

    }

    @Override
    public void createCandidate() {
        super.createCandidate();
        this.graduationDate = Utils.getString("Graduated date:");
        this.graduationRank = Utils.getString("Rank of Graduation");
        this.education = Utils.getString("university where student graduated");

    }
}


