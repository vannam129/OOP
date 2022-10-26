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
public class CandidateManagement {

    private Candidate[] candidateList;
    private int currentIndex;
    private static final int MAX = 100;

    public CandidateManagement() {

        candidateList = new Candidate[100];
        currentIndex = 0;
    }

    public CandidateManagement(Candidate[] candidateList, int currentIndex) {
        this.candidateList = candidateList;
        this.currentIndex = currentIndex;
    }

    public Candidate[] getCandidateList() {
        return candidateList;
    }

    public void setCandidateList(Candidate[] candidateList) {
        this.candidateList = candidateList;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }
    public boolean add(Candidate cand){
        boolean result = false;
        try{
            if(this.candidateList !=null && currentIndex<MAX){
                this.candidateList[currentIndex++]=cand;
                result = true;
            }
        }catch(Exception e){
    }
        return result;
    }
    public void display(){
        System.out.println("List of candidate:");
        for (int i=0;i<currentIndex;i++){
            if(this.candidateList[i] instanceof Experience)
                System.out.println("Experience:"+candidateList[i].toString());
            else if (this.candidateList[i] instanceof Intern)
                System.out.println("Intern:"+candidateList[i].toString());
        }
    }
    public Candidate findByID(String id) {
        Candidate result = null;
        try {
            for (int i = 0; i < currentIndex; i++) {
                if (this.candidateList[i].getId().equals(id)) {
                    result = this.candidateList[i];
                    break;
                }
            }
        } catch (Exception e) {

        }
        return result;

    }

    public Candidate findByIndex(int index) {
        Candidate cand = null;
        try {
            if (index < currentIndex && index > -1) {
                cand = this.candidateList[index];
            }
        } catch (Exception e) {
        }
        return cand;
    }

    public boolean updateByID(String id) {
        boolean result = false;
        try {
            for (Candidate candidate : candidateList) {
                if (candidate.getId().equals(id)) {
                    candidate.updateCandidate();
                    result = true;
                    break;
                }
            }
        } catch (Exception e) {
        }
        return result;
    }
    public boolean updateByIndex(int index) {
        boolean result = false;
        try {
            if (index < currentIndex && index > -1) {
               this.candidateList[index].updateCandidate();
               result = true;
            }
        } catch (Exception e) {
        }
        return result;
    }
    public boolean remove (int index){
        boolean result =false;
        try{
            if (index>-1 && index<currentIndex){
                for(int i = index;i<currentIndex -1;i++){
                    this.candidateList[i]=this.candidateList[i+1];
                }
                currentIndex--;
                result=true;
            }
        }catch(Exception e){
            
        }
        return result;
    }
    public void displayExperience(){
        System.out.println("Experience Candidate:");
        for(int i=0;i<currentIndex;i++){
            if(this.candidateList[i] instanceof Experience)
                System.out.println("Experience:"+candidateList[i].toString());

        }
    }
     public void displayIntern(){
        System.out.println("Intern Candidate:");
        for(int i=0;i<currentIndex;i++){
            if(this.candidateList[i] instanceof Intern)
                System.out.println("Intern:"+candidateList[i].toString());

        }
    }
}

