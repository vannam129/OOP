/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queen_problem;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class N_Queen_Problem {
     int size, nqueen;
    ArrayList<QueenPosition> positions = new ArrayList();
    ArrayList<QueenPosition> solutions;

    boolean solve = false;
    boolean success = false;

    private N_Queen_Problem(int size, int nqueen) {
        this.size = size;
        this.nqueen = nqueen;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                positions.add(new QueenPosition(i, j, "O"));
            }
        }
    }

    private boolean revertValid(QueenPosition pos, int index) {
        if (index == 0) {
            return true;
        }
        for (int i = 0; i < index; i++) {
            QueenPosition p = solutions.get(i);
            if (!pos.valdi(p)) {
                return false;
            }
        }
        return true;
    }

    private void recursiveSolve(int index) {
        if (solve) {
            return;
        }
        int i, j;
        for (i = 0; i < positions.size() && !solve; i++) {
            j = solutions.size() - 1;
            while (j >= index) {
                solutions.remove(j--);
            }
            QueenPosition pos = positions.get(i);
            if (revertValid(pos, index)) {
                solutions.add(pos);
                if (index == nqueen - 1) {
                    solve = success = true;
                } else {
                    recursiveSolve(index + 1);
                }
            }
        }
    }

    private void recursiveSolve() {
        solve = success = false;
        if (size < nqueen) {
            solve = true;
        } else {
            solutions = new ArrayList();
            recursiveSolve(0);
        }
    }

    public static void main(String[] args) {
        int size = 8;
        int nqueen = 8;
        N_Queen_Problem problem = new N_Queen_Problem(size, nqueen);
        problem.recursiveSolve();
        if (problem.solve) {
            if (problem.success) {
                problem.solutions.forEach(pos -> {
                    System.out.print(pos.toString());
                });
                System.out.println("");
                System.out.println("SOLVE SUCCESS !");
            } else {
                System.out.println("SOLVE FAIL");
            }
        } else {
            System.out.println("The problem is not solved yet");
        }
    }
}
