import java.util.Scanner;

public class GradingSystem{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int examScore, assesmentScore, feesPaid;
        System.out.println("Enter your Exam Score: ");
        examScore = input.nextInt();
        System.out.println("Enter your Assesment Score: ");
        assesmentScore = input.nextInt();
        System.out.println("Enter your Fees paid: ");
        feesPaid = input.nextInt();

        boolean passed_exams = (examScore >= 25);
        boolean passed_assessment = (assesmentScore >= 15);
        
        if(passed_exams && passed_assessment){
            if(feesPaid == 100){
                System.out.println("You have paid your fees in full go ahead to recieve your certificate.");
            }else{
                System.out.println("You have not paid your fees in full.");
            }
        }else if(examScore + assesmentScore == 39){
            System.out.println("You have been condoned");
        }else{
            if(!passed_exams && passed_assessment){
                System.out.println("You have failed the exams.");
            }
            if(passed_exams && !passed_assessment){
                System.out.println("You have failed the assessment");
            }
            if(!passed_exams && !passed_assessment){
                System.out.println("You have been repeated");
            }
        }
    }
}