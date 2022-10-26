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
public class Experience extends Candidate {

    private int expIntYear;
    private String proSkill;

    public Experience() {
    }

    public Experience(int expIntYear, String proSkill, String firstName, String lastName, String birthDate, String address, String phone, String email, String id) {
        super(firstName, lastName, birthDate, address, phone, email, id);
        this.expIntYear = expIntYear;
        this.proSkill = proSkill;
    }

    public int getExpIntYear() {
        return expIntYear;
    }

    public void setExpIntYear(int expIntYear) {
        this.expIntYear = expIntYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + this.expIntYear + ", " + this.proSkill;
    }

    @Override
    public void updateCandidate() {
        super.updateCandidate();
        //  this.expIntYear = Integer.parseInt(Utils.updateString(this.expIntYear+"", "New Exp Year:"));
        this.expIntYear = Utils.updateInt(this.expIntYear, "New Exp Year:");
        this.proSkill =Utils.updateString(this.proSkill, "Professional Skill:");
    }

    @Override
    public void createCandidate() {
        super.createCandidate();
        //   this.expIntYear = Integer.parseInt(Utils.getString("Experience year:"));
        this.expIntYear = Utils.getInt("Experience year:");
        this.proSkill = Utils.getString("Professional Skill:");

    }
}
