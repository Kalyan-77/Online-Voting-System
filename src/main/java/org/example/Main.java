package org.example;

import org.example.DAO.CandidateDAO;
import org.example.Model.Candidate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CandidateDAO candidateDAO = new CandidateDAO();

        int choice;

        do {
            System.out.println("\n Menu");
            System.out.println("1.Add Candidate");
            System.out.println("2.Vote for Candidate");
            System.out.println("3.View All Candidate");
            System.out.println("4.Exit");

            System.out.print("Enter Your Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1:
                    System.out.print("Enter Candidate Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Parth Name: ");
                    String party = sc.nextLine();

                    Candidate candidate = new Candidate(name,party);
                    candidateDAO.addCandidate(candidate);
                    break;
                case 2:
                    System.out.print("Enter Candidate Name: ");
                    String name1 = sc.nextLine();
                    //sc.nextLine();

                    boolean isVoted = candidateDAO.voteForCandidate(name1);
                    if(isVoted){
                        System.out.println("Vote Recorded Successfully");
                    }else{
                        System.out.println("Candidate Not Found.");
                    }
                    break;
                case 3:
                    List<Candidate> candidates = candidateDAO.displayAllCandidates();
                    if(candidates.isEmpty()){
                        System.out.println("No Candidates Found");
                    }else{
                        System.out.println("-------Candidates List-------");
                        for(Candidate c : candidates){
                            System.out.println("ID: " + c.getCandidateId() + " | " + "Name " + c.getName() + " | " + "Party " + c.getParty() + " | " + "Votes " + c.getVoteCount());
                        }
                    }
                    break;
                default:
                    System.out.println("Invalid Choice.......");
            }
        }while(choice != 0);
    }
}