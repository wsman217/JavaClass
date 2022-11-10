package HW4;

import java.util.Random;

/*Loan class serves as a part of Bank class to maintain loan information and to calculate monthly installments and total paid amount*/
public class Loan implements Comparable<Loan> {
    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;
    private java.util.Date loanDate;

    /* Default constructor */
    public Loan() {
        Random ranValue = new Random();
        this.annualInterestRate = ranValue.nextInt(1, 1000) / 100.0;
        loanDate = new java.util.Date();

    }

    /* Return annualInterestRate */
    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    /* Set a new annualInterestRate */
    public Loan setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
        return this;
    }

    /* Return numberOfYears */
    public int getNumberOfYears() {
        return numberOfYears;
    }

    /* Set a new numberOfYears */
    public Loan setNumberOfYears(int numberOfYears) {
        this.numberOfYears = numberOfYears;
        return this;
    }

    /* Return loanAmount */
    public double getLoanAmount() {
        return loanAmount;
    }

    /* Set a new loanAmount */
    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    /* Find monthly payment */
    public double getMonthlyPayment() {
        double monthlyInterestRate = annualInterestRate / 1200;
        return loanAmount * monthlyInterestRate / (1 - (1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));
    }


    /* Find total payment */
    public double getTotalPayment() {
        return getMonthlyPayment() * numberOfYears * 12;
    }

    /* Return loan date */
    public java.util.Date getLoanDate() {
        return loanDate;
    }

    /* Set a new loan date */
    public Loan setLoanDate(java.util.Date loanDate) {
        this.loanDate = loanDate;
        return this;
    }

    @Override
    public int compareTo(Loan o) {
        return Double.compare(annualInterestRate, o.annualInterestRate);
    }
}