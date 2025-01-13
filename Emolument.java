/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Gwen
 */

public class Emolument {
    // Encapsulated data fields
    private double basic_salary;
    private double tax_relief;

    // Constructor to initialize basic salary and tax relief
    public Emolument(double basic_salary, double tax_relief) {
        this.basic_salary = basic_salary;
        this.tax_relief = tax_relief;
    }

    // Method to get the basic salary
    public double getBasicSalary() {
        return basic_salary;
    }

    // Method to get the tax relief
    public double getTaxRelief() {
        return tax_relief;
    }

    // Method to compute SSNIT contribution (3.5% of basic salary)
    public double SSNIT() {
        return basic_salary * 0.035;
    }

    // Method to compute the taxable income
    public double taxableIncome() {
        return basic_salary - (tax_relief + SSNIT());
    }
    
   public class MyEmolument extends Emolument {
    // Encapsulated data fields
    private double basic_salary;
    private double tax_relief;

    // Non-argument constructor with default values
    public MyEmolument() {
        super(0, 0);  // Call the super constructor with default values (0, 0)
        this.basic_salary = 0;
        this.tax_relief = 0;
    }

    // Constructor that accepts basic salary and tax relief
    public MyEmolument(double basic_salary, double tax_relief) {
        super(basic_salary, tax_relief);  // Call the parent constructor with provided values
        this.basic_salary = basic_salary;
        this.tax_relief = tax_relief;
    }

    // Method to compute the income tax based on taxable income
    public double incomeTax() {
        double taxableIncome = taxableIncome(); // Get taxable income from the parent class
        double tax = 0;

        if (taxableIncome <= 500) {
            tax = taxableIncome * 0.05; // First 500, 5% tax rate
        } else if (taxableIncome <= 1000) {
            tax = 500 * 0.05 + (taxableIncome - 500) * 0.125; // Next 500, 12.5% tax rate
        } else {
            tax = 500 * 0.05 + 500 * 0.125 + (taxableIncome - 1000) * 0.175; // Remaining, 17.5% tax rate
        }
        return tax;
    }

    // Method to compute the total deduction (SSNIT + Income Tax)
    public double totalDeduction() {
        return SSNIT() + incomeTax();
    }

    // Method to compute the net salary (Basic Salary - Total Deduction)
    public double netSalary() {
        return getBasicSalary() - totalDeduction();
    }
}


public class TestEmolument {
    public static void main(String[] args) {
        // Accept user input for basic salary and tax relief using input dialog
        String basicSalaryInput = JOptionPane.showInputDialog("Enter Basic Salary:");
        double basicSalary = Double.parseDouble(basicSalaryInput);

        String taxReliefInput = JOptionPane.showInputDialog("Enter Tax Relief:");
        double taxRelief = Double.parseDouble(taxReliefInput);

        // Create a MyEmolument object with the input values
        MyEmolument staffSalary = new MyEmolument(basicSalary, taxRelief);

        // Display the details in a dialog box
        double ssnitContribution = staffSalary.SSNIT();
        double taxableIncome = staffSalary.taxableIncome();
        double incomeTax = staffSalary.incomeTax();
        double totalDeduction = staffSalary.totalDeduction();
        double netSalary = staffSalary.netSalary();

        String message = String.format(
            "Basic Salary: %.2f\nTax Relief: %.2f\nSSNIT Contribution: %.2f\nTaxable Income: %.2f\n" +
            "Income Tax: %.2f\nTotal Deduction: %.2f\nNet Salary: %.2f",
            basicSalary, taxRelief, ssnitContribution, taxableIncome, incomeTax, totalDeduction, netSalary);

        JOptionPane.showMessageDialog(null, message);
    }
}
   
}


