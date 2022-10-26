/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package product_suggestion_problem;


import backtrack_gen.BackTrackGenerator;
import backtrack_gen.Configuration;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author PC
 */
public class ProductConsultantProblem {
    double maxBudget;
    int noProduct;
    ArrayList<ArrayList<Product>> domains;
    boolean solved = false;
    ArrayList<Suggestion> solution;
    
    public ProductConsultantProblem(double maxBudget) {
        this.maxBudget = maxBudget;
        noProduct = 0;
        domains  = new ArrayList();
        solution = new ArrayList();
    }
    
    public void addDomain(ArrayList<Product> domain) {
        noProduct++;
        domains.add(domain);
    }
    
    public Suggestion getSuggestion(Configuration conf) {
        Suggestion suggestion  = new Suggestion();
        double sumCost = 0;
        for (int i = 0; i < conf.size(); i++) {
            ArrayList<Product> domain = domains.get(i);
            int indexProduct = conf.get(i);
            Product d = domain.get(indexProduct);
            suggestion.add(d);
            sumCost += domain.get(indexProduct).price;
        }
        suggestion.setCost(sumCost);
        return suggestion;
    }
    
    public boolean isAcepted(Suggestion suggestion) {
        return suggestion.getCost()<=this.maxBudget;
    }
    
    public void solve() {
        solved = false;
        BackTrackGenerator gen = new BackTrackGenerator();
        
        for (int i = 0; i < noProduct; i++) gen.addDomain(domains.get(i));
        gen.initiated();
        Configuration conf = gen.getFirstConfiguration();
        while(conf!=null) {
            Suggestion suggestion = this.getSuggestion(conf);
            if(isAcepted(suggestion)) solution.add(suggestion);
            conf = gen.nextConfiguration();
        }
        solved = true;
    }
    
    public void printSolution() {
        if(!solved) System.out.println("The problem is not solved yet !");
        else if(solution.isEmpty()) System.out.println("No solution !");
        else {
            System.out.println("Maximum budget: " + maxBudget);
            Collections.sort(solution);
            for (int i=0; i < solution.size(); i++) {
                Suggestion suggestion = solution.get(i);
                System.out.format("Solution %d: %.0f\n", (i+1), suggestion.getCost());
                System.out.println(suggestion);
            }
            System.out.println(solution.size()+" solutions !");
        }
    }
}

