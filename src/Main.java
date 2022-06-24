import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int classCount;
        Scanner input = new Scanner(System.in);
        System.out.print("Welcome to the GPA Calculator. This calculator takes in the number of subjects you are taking" +
                "\n and how much credits they are worth and prints out the calculated GPA ");
        System.out.print("\n\nHow many classes did you take?   ");
        classCount = retrieveInteger(input, 0, 30);
        System.out.println();
        Class[] classes = new Class[classCount];
        getClasses(classes, input);
        System.out.println();
        checkClasses(classes, input);
        System.out.println();
        printReport(classes);
    }

    public static void getClasses(Class[] classes, Scanner input) {
        for (int num = 0; num < classes.length; num++) {
            System.out.println("Class #" + (num + 1));
            setClass(classes, num, input);
        }
    }

    public static void checkClasses(Class[] classes, Scanner input) {
        System.out.println("Checking inputs . . .");
        for (int num = 0; num < classes.length; num++) {
            System.out.println();
            System.out.println("Class #" + (num + 1));
            System.out.println("Name: " + classes[num].getClassName() + ", " +
                    "Credit Weight: " + classes[num].getCredWeight() + ", " +
                    "Grade Point: " + classes[num].getGradePoint());
        }
        System.out.println();
        validateInputs(classes, input);
    }

    public static void validateInputs (Class[] classes, Scanner input) {
        while (true) {
            System.out.println("Did all of those inputs look correct?");
            System.out.println("input no to change one class, all to change all of them");
            System.out.print("or yes to continue     ");
            String choice;
            while (true) {
                try {
                    choice = input.nextLine();
                    if (choice.equals("no") || choice.equals("yes") || choice.equals("all")) {
                        break;
                    }
                    throw new IllegalArgumentException();
                } catch (IllegalArgumentException e) {
                    System.out.print("Sorry that choice was invalid, please try again     ");
                }
            }
            if (choice.equals("no")) {
                System.out.print("What class do you want to change?     ");
                int classNum = retrieveInteger(input, 0, classes.length) - 1;
                setClass(classes, classNum, input);
            } else if (choice.equals("all")) {
                getClasses(classes, input);
            } else if (choice.equals("yes")) {
                break;
            }
        }
    }

    public static void setClass(Class[] classes, int classNum, Scanner input) {
        double gradePoint;
        int credWeight;
        System.out.print("What was the class name?     ");
        String className = input.nextLine();
        System.out.print("What was the credit load?     ");
        credWeight = retrieveInteger(input, 0, 5);
        System.out.print("What grade point did you receive?     ");
        gradePoint = retrieveDouble(input, 0, 4);
        classes[classNum] = new Class(className, credWeight, gradePoint);
    }

    public static void printReport(Class[] classes) {
        double gpaSum = 0.0;
        int credits = 0;
        for (int num = 0; num < classes.length; num++) {
            gpaSum += classes[num].getGradePoint() * classes[num].getCredWeight();
            credits += classes[num].getCredWeight();
            for (int i = 0; i < 60; i++) {
                System.out.print("_");
            }
            System.out.println();
            System.out.print("|     " + classes[num].getClassName());
            for (int j = 0; j < 39 - classes[num].getClassName().length(); j++) {
                System.out.print(" ");
            }
            System.out.print("|  " + classes[num].getCredWeight() + "  |  " + classes[num].getGradePoint() + "  |");
            System.out.println();
        }
        for (int i = 0; i < 60; i++) {
            System.out.print("_");
        }
        System.out.println();
        for (int k = 0; k < 37; k++) {
            System.out.print(" ");
        }
        double averageGPA = (Math.floor((gpaSum / credits) * 100) / 100);
        System.out.print("| Average GPA:  " + averageGPA + "  |");

    }
    public static double retrieveDouble(Scanner input, int lowThresh, int highThresh) {
        while (true) {
            try {
                double value = Double.parseDouble(input.nextLine());
                if (value < lowThresh) { throw new IllegalArgumentException(); }
                if (value > highThresh) { throw new IllegalArgumentException(); }
                return value;
            } catch (Exception e) {
                System.out.print("Sorry that input was invalid, please enter a valid answer     ");
            }
        }
    }

    public static int retrieveInteger(Scanner input, int lowThresh, int highThresh) {
        while (true) {
            try {
                int value = Integer.parseInt(input.nextLine());
                if (value < lowThresh) { throw new IllegalArgumentException(); }
                if (value > highThresh) { throw new IllegalArgumentException(); }
                return value;
            } catch (Exception e) {
                System.out.print("Sorry that input was invalid, please enter a valid answer     ");
            }
        }
    }
}
