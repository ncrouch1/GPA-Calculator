import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int classCount = 0;
        Scanner input = new Scanner(System.in);
        System.out.print("Welcome to the GPA Calculator. This calculator takes in the number of subjects you are taking" +
                "\n and how much credits they are worth and prints out the calculated GPA ");
        System.out.print("\n\nHow many classes did you take?   ");
        while (classCount == 0) {
            try {
                classCount = Integer.parseInt(input.nextLine());
            } catch (Exception e) {
                System.out.print("Sorry that input was invalid, please enter a valid answer");
            }
        }
        System.out.print("\nYour calculated GPA is " + calculateGPA(classCount, input));
    }

    public static double calculateGPA(int count, Scanner input) {
        int totalCredits = 0;
        double gpaSum = 0;
        for (int i = 0; i < count; i++) {
            System.out.print("How many credits was this class worth?   ");
            int credits = Integer.parseInt(input.nextLine());
            totalCredits += credits;
            System.out.print("What was your grade for this class?   ");
            gpaSum += Double.parseDouble(input.nextLine()) * credits;
        }
        return gpaSum / totalCredits;
    }
}
