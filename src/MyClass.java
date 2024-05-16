import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyClass extends JFrame {
    public static final double housingPerc = 0.25;
    public static final double insurancePerc = 0.10;
    public static final double foodPerc = 0.10;
    public static final double savingsPerc = 0.10;
    public static final double transportationPerc = 0.10;
    public static final double utilitiesPerc = 0.05;
    public static final double entertainmentPerc = 0.05;
    public static final double personalPerc = 0.05;
    public static final double clothingPerc = 0.05;

    private final JTextField incomeField;
    private final JTextArea outputArea;
    private final JTextField expenseField;
    private final JTextField costField;
    private final JTextField additionalIncomeField;

    private double income;
    private double house;
    private double insurance;
    private double food;
    private double savings;
    private double transportation;
    private double utilities;
    private double entertainment;
    private double personal;
    private double clothing;

    public MyClass() {
        setTitle("Expense Tracker");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel incomeLabel = new JLabel("Enter your income: ");
        incomeField = new JTextField();
        JButton submitIncomeButton = new JButton("Submit Income");

        JLabel expenseLabel = new JLabel("Enter expense category: ");
        expenseField = new JTextField();
        JLabel costLabel = new JLabel("Enter cost: ");
        costField = new JTextField();
        JButton submitExpenseButton = new JButton("Submit Expense");

        JLabel additionalIncomeLabel = new JLabel("Enter additional income: ");
        additionalIncomeField = new JTextField();
        JButton addIncomeButton = new JButton("Add Income");

        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(incomeLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        inputPanel.add(incomeField, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        inputPanel.add(submitIncomeButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        inputPanel.add(expenseLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        inputPanel.add(expenseField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        inputPanel.add(costLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        inputPanel.add(costField, gbc);
        gbc.gridx = 1;
        gbc.gridy = 4;
        inputPanel.add(submitExpenseButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        inputPanel.add(additionalIncomeLabel, gbc);
        gbc.gridx = 1;
        gbc.gridy = 5;
        inputPanel.add(additionalIncomeField, gbc);
        gbc.gridx = 1;
        gbc.gridy = 6;
        inputPanel.add(addIncomeButton, gbc);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        submitIncomeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleIncomeSubmission();
            }
        });

        submitExpenseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleExpenseSubmission();
            }
        });

        addIncomeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleAddIncome();
            }
        });
    }

    private void handleIncomeSubmission() {
        try {
            income = Double.parseDouble(incomeField.getText());
            house = income * housingPerc;
            insurance = income * insurancePerc;
            food = income * foodPerc;
            savings = income * savingsPerc;
            transportation = income * transportationPerc;
            utilities = income * utilitiesPerc;
            entertainment = income * entertainmentPerc;
            personal = income * personalPerc;
            clothing = income * clothingPerc;

            outputArea.setText("Income: $" + income + "\n" + getBudgetString());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number for income.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void handleExpenseSubmission() {
        try {
            String expense = expenseField.getText().trim();
            double cost = Double.parseDouble(costField.getText());

            switch (expense.toLowerCase()) {
                case "house":
                    if (cost > house) {
                        showError("House");
                        return;
                    }
                    house -= cost;
                    break;
                case "insurance":
                    if (cost > insurance) {
                        showError("Insurance");
                        return;
                    }
                    insurance -= cost;
                    break;
                case "food":
                    if (cost > food) {
                        showError("Food");
                        return;
                    }
                    food -= cost;
                    break;
                case "savings":
                    if (cost > savings) {
                        showError("Savings");
                        return;
                    }
                    savings -= cost;
                    break;
                case "transportation":
                    if (cost > transportation) {
                        showError("Transportation");
                        return;
                    }
                    transportation -= cost;
                    break;
                case "utilities":
                    if (cost > utilities) {
                        showError("Utilities");
                        return;
                    }
                    utilities -= cost;
                    break;
                case "entertainment":
                    if (cost > entertainment) {
                        showError("Entertainment");
                        return;
                    }
                    entertainment -= cost;
                    break;
                case "personal":
                    if (cost > personal) {
                        showError("Personal");
                        return;
                    }
                    personal -= cost;
                    break;
                case "clothing":
                    if (cost > clothing) {
                        showError("Clothing");
                        return;
                    }
                    clothing -= cost;
                    break;
                default:
                    JOptionPane.showMessageDialog(this, "Invalid expense category. Please enter a valid category.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    return;
            }

            income -= cost;
            outputArea.setText("Income: $" + income + "\n" + getBudgetString());

            if (income <= 0) {
                JOptionPane.showMessageDialog(this, "You've run out of money for today.", "Budget Exceeded", JOptionPane.WARNING_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number for cost.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void handleAddIncome() {
        try {
            double additionalIncome = Double.parseDouble(additionalIncomeField.getText());
            income += additionalIncome;

            // Recalculate the budgets for each category
            house += additionalIncome * housingPerc;
            insurance += additionalIncome * insurancePerc;
            food += additionalIncome * foodPerc;
            savings += additionalIncome * savingsPerc;
            transportation += additionalIncome * transportationPerc;
            utilities += additionalIncome * utilitiesPerc;
            entertainment += additionalIncome * entertainmentPerc;
            personal += additionalIncome * personalPerc;
            clothing += additionalIncome * clothingPerc;

            outputArea.setText("Income: $" + income + "\n" + getBudgetString());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number for additional income.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void showError(String category) {
        JOptionPane.showMessageDialog(this, "Error: Expense exceeds available budget for " + category + ".", "Budget Exceeded", JOptionPane.ERROR_MESSAGE);
    }

    private String getBudgetString() {
        return String.format("House: $%.2f\nInsurance: $%.2f\nFood: $%.2f\nSavings: $%.2f\nTransportation: $%.2f\nUtilities: $%.2f\nEntertainment: $%.2f\nPersonal: $%.2f\nClothing: $%.2f",
                house, insurance, food, savings, transportation, utilities, entertainment, personal, clothing);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MyClass().setVisible(true);
            }
        });
    }
}
