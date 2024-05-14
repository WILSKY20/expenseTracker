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
            System.out.println("\nDay: " + day);

            while (true) {
                System.out.println("What will you be spending your money on? (Type 'N' to move to the next day)");
                String expense = scan.next();
                if (expense.equalsIgnoreCase("N")) {
                    break;
                } else if(expense.equalsIgnoreCase("exit")) {
                    System.out.println("Thank you for using our expense tracker!");
                    return;
                }

                double cost;

                switch (expense) {
                    case "House":
                        System.out.println("How much will you be spending on House?");
                        cost = scan.nextDouble();
                        if (cost > house) {
                            System.out.println("Error: Expense exceeds available budget for House.");
                            continue;
                        }
                        house -= cost;
                        break;
                    case "Insurance":
                        System.out.println("How much will you be spending on Insurance?");
                        cost = scan.nextDouble();
                        if(cost > insurance) {
                            System.out.println("Error: Expense exceeds available budget for Insurance.");
                            continue;
                        }
                        insurance -= cost;
                        break;
                    case "Food":
                        System.out.println("How much will you be spending on Food?");
                        cost = scan.nextDouble();
                        if(cost > food) {
                            System.out.println("Error: Expense exceeds available budget for Food.");
                            continue;
                        }
                        food -= cost;
                        break;
                    case "Savings":
                        System.out.println("How much will you be spending on Savings?");
                        cost = scan.nextDouble();
                        if(cost > savings) {
                            System.out.println("Error: Expense exceeds available budget for Savings.");
                            continue;
                        }
                        savings -= cost;
                        break;
                    case "Transportation":
                        System.out.println("How much will you be spending on Transportation?");
                        cost = scan.nextDouble();
                        if(cost > transportation) {
                            System.out.println("Error: Expense exceeds available budget for Transportation.");
                            continue;
                        }
                        transportation -= cost;
                        break;
                    case "Entertainment":
                        System.out.println("How much will you be spending on Entertainment?");
                        cost = scan.nextDouble();
                        if(cost > entertainment) {
                            System.out.println("Error: Expense exceeds available budget for Entertainment.");
                            continue;
                        }
                        entertainment -= cost;
                        break;
                    case "Personal":
                        System.out.println("How much will you be spending on Personal?");
                        cost = scan.nextDouble();
                        if(cost > personal) {
                            System.out.println("Error: Expense exceeds available budget for Personal.");
                            continue;
                        }
                        personal -= cost;
                        break;
                    case "Utilities":
                        System.out.println("How much will you be spending on Utilities?");
                        cost = scan.nextDouble();
                        if(cost > utilities) {
                            System.out.println("Error: Expense exceeds available budget for Utilities.");
                            continue;
                        }
                        utilities -= cost;
                        break;
                    case "Clothing":
                        System.out.println("How much will you be spending on Clothing?");
                        cost = scan.nextDouble();
                        if(cost > clothing) {
                            System.out.println("Error: Expense exceeds available budget for Clothing.");
                            continue;
                        }
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
