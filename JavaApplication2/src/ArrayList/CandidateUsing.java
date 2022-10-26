package ArrayList;

import java.util.ArrayList;
import java.util.List;
import menu.Candidate;

public class CandidateUsing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        List<Candidate> list = new ArrayList<>();
        int choice = 0;
        try {

            do {
                Utils.printMenu();
                choice = Utils.getInt("Input your choice:");
                Candidate cd = null;
                boolean check = false;
                String id = "";
                int index = 0;

                switch (choice) {

                    case 1:
                        cd = new Experience();
                        cd.createCandidate();
                        check = list.add(cd);
                        if (check) {
                            System.out.println("Experience added !");
                        } else {
                            System.out.println("Duplicate ID!");
                        }
                        break;
                    case 2:
                        cd = new Intern();
                        cd.createCandidate();
                        check = list.add(cd);
                        if (check) {
                            System.out.println("Intern added !");
                        } else {
                            System.out.println("Duplicate ID!");
                        }
                        break;
                    case 3:
                        id = Utils.getString("Intput the ID that you want to find:");
                        index = list.indexOf(new Experience(id));
                        if (index != -1) {
                            System.out.println("found :" + list.get(index).toString());
                        } else {
                            System.out.println("not found :");
                        }
                        break;
                    case 4:
                        index = Utils.getInt("Input the Index that you want to find:");

                        if (index > -1 && index < list.size()) {
                            System.out.println("Found candidate:" + list.get(index).toString());
                        } else {
                            System.out.println("Not Found candidate:");
                        }
                        break;
                    case 5:
                        id = Utils.getString("Intput the ID that you want to update:");
                        index = list.indexOf(new Experience(id));

                        if (index != -1) {
                            cd = list.get(index);
                            cd.updateCandidate();
                            list.set(index, cd);
                            System.out.println("Update!");
                        } else {
                            System.out.println("Not Found !");
                        }
                        break;
                    case 6:
                        index = Utils.getInt("Intput the Index that you want to update:");

                        if (index > -1 && index < list.size()) {
                            cd = list.get(index);
                            cd.updateCandidate();
                            list.set(index, cd);
                            System.out.println("Update!");
                        } else {
                            System.out.println("Not Found !");
                        }
                        break;
                    case 7:
                        id = Utils.getString("Intput the ID that you want to remove:");
                        check = list.remove(new Experience(id));
                        if (check) {
                            System.out.println("Remove!");
                        } else {
                            System.out.println("Not Found !");
                        }
                        break;
                    case 8:
                        index = Utils.getInt("Intput the Index that you want to remove:");

                        if (index > -1 && index < list.size()) {
                            list.remove(index);
                            System.out.println("Remove!");
                        } else {
                            System.out.println("Not Found !");
                        }
                        break;
                    case 9:
                        System.out.println("Experience List:");
                        list.stream().filter((candidate) -> (candidate instanceof Experience)).forEachOrdered((candidate) -> {
                            System.out.println("Experience:" + candidate.toString());
                });
                        break;
                    case 10:
                        System.out.println("Intern List:");
                        list.stream().filter((candidate) -> (candidate instanceof Intern)).forEachOrdered((candidate) -> {
                            System.out.println("Intern:" + candidate.toString());
                });
                        break;

                    case 11:
                        System.out.println("Candidate List:");
                        list.forEach((candidate) -> {
                            System.out.println("Candidate:" + candidate.toString());
                });
                        break;
                    default:
                        System.err.println("In put again:");

                }

            } while (choice != 12);
        } catch (Exception e) {

        }
    }
}
