import java.util.Scanner;

public class MyClass {
    public static final double housingPerc = 0.25;
    public static final double insurancePerc = 0.10;
    public static final double foodPerc = 0.10;
    public static final double savingsPerc = 0.10;
    public static final double transportationPerc = 0.10;
    public static final double utilitiesPerc = 0.05;
    public static final double entertainmentPerc = 0.05;
    public static final double personalPerc = 0.05;
    public static final double clothingPerc = 0.05;

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your income: ");
        double income = scan.nextDouble();

        expenseTracker(income);

        scan.close();
    }

    public static void expenseTracker(double income) {
        Scanner scan = new Scanner(System.in);
        int day = 1;

        while (true) {
            System.out.println("\nDay: " + day);

            double house = income * housingPerc;
            double insurance = income * insurancePerc;
            double food = income * foodPerc;
            double savings = income * savingsPerc;
            double transportation = income * transportationPerc;
            double entertainment = income * entertainmentPerc;
            double personal = income * personalPerc;
            double clothing = income * clothingPerc;
            double utilities = income * utilitiesPerc;

            while (true) {
                System.out.println("What will you be spending your money on? (Type 'N' to move to the next day)");
                String expense = scan.next();
                if (expense.equalsIgnoreCase("N")) {
                    break;
                }

                double cost;

                switch (expense) {
                    case "House":
                        System.out.println("How much will you be spending on House?");
                        cost = scan.nextDouble();
                        house -= cost;
                        break;
                    case "Insurance":
                        System.out.println("How much will you be spending on Insurance?");
                        cost = scan.nextDouble();
                        insurance -= cost;
                        break;
                    case "Food":
                        System.out.println("How much will you be spending on Food?");
                        cost = scan.nextDouble();
                        food -= cost;
                        break;
                    case "Savings":
                        System.out.println("How much will you be spending on Savings?");
                        cost = scan.nextDouble();
                        savings -= cost;
                        break;
                    case "Transportation":
                        System.out.println("How much will you be spending on Transportation?");
                        cost = scan.nextDouble();
                        transportation -= cost;
                        break;
                    case "Entertainment":
                        System.out.println("How much will you be spending on Entertainment?");
                        cost = scan.nextDouble();
                        entertainment -= cost;
                        break;
                    case "Personal":
                        System.out.println("How much will you be spending on Personal?");
                        cost = scan.nextDouble();
                        personal -= cost;
                        break;
                    case "Utilities":
                        System.out.println("How much will you be spending on Utilities?");
                        cost = scan.nextDouble();
                        utilities -= cost;
                        break;
                    case "Clothing":
                        System.out.println("How much will you be spending on Clothing?");
                        cost = scan.nextDouble();
                        clothing -= cost;
                        break;
                    default:
                        System.out.println("Invalid expense. Please enter a valid expense.");
                        continue; // Skip to the next iteration of the loop
                }

                System.out.println("Your remaining budget for today:");
                System.out.println("House: " + house + "\nInsurance: " + insurance + "\nFood: " + food +
                        "\nSavings: " + savings + "\nTransportation: " + transportation + "\nEntertainment: " +
                        entertainment + "\nPersonal: " + personal + "\nUtilities: " + utilities + "\nClothing: " +
                        clothing);

                income -= cost;

                System.out.println("New income: " + income);

                if (income <= 0) {
                    System.out.println("You've run out of money for today.");
                    break;
                }
            }

            day++;
            System.out.println("Did you get paid? [Y/N]");
            String response = scan.next();
            if (response.equalsIgnoreCase("Y")) {
                System.out.println("How much did you get paid?");
                double additionalIncome = scan.nextDouble();
                income += additionalIncome;
            } else if (response.equalsIgnoreCase("N")) {
                continue;
            } else {
                System.out.println("Invalid response. Please enter 'Y' or 'N'.");
            }
        }
    }
}
