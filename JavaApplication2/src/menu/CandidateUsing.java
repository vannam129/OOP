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
public class CandidateUsing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        CandidateManagement cm = new CandidateManagement();
        int choice = 0;
        do {
            Utils.printMenu();
            choice = Utils.getInt("Input your choice:");
            Candidate cand = null;
            boolean check = false;
            String id = "";
            int index = 0;

            switch(choice)
            {

            
          case 1:
                    cand= new Experience();
                    cand.createCandidate();
                    check= cm.add(cand);
                    if (check) {System.out.println("Experience added !");}
                    break;
                case 2:  
                    cand= new Intern();
                    cand.createCandidate();
                    check= cm.add(cand);
                    if (check){ System.out.println("Intern added !");}
                    break;
                case 3:
                    id =Utils.getString("Intput the ID that you want to find:");
                    cand= cm.findByID(id);
                if(cand!= null){
                    System.out.println("found candidate:"+cand.toString());
            }
                break;
                case 4:
                index = Utils.getInt("Input the Index that you want to find:");
                cand= cm.findByIndex(index);
                if (cand!= null){
                System.out.println("Found candidate:"+cand.toString());
            }
                break;
                case 5:
                id =Utils.getString("Intput the ID that you want to update:");
                check=cm.updateByID(id);
                if(check){
                    System.out.println("Update!");
            }
                break;
                case 6:
                index= Utils.getInt("Intput the Index that you want to update:");
                check = cm.updateByIndex(index);
                if(check){
                    System.out.println("Update!");}
                    break;
                case 7:
                index =Utils.getInt("Intput the Index that you want to remove:");
                check =cm.remove(index);
                if(check){
                    System.out.println("Remove!");}
                    break;
                case 8:
                cm.displayExperience();
                break;
                case 9:
                cm.displayIntern();
                break;
                case 10:
                cm.display();
                break;
                default:
                    System.err.println("QUIT PROGRAM");
                 
                  

        }
    
    
        }while(choice < 11);
        
    }
}
