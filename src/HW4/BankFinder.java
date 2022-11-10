package HW4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*BankFinder class finds loan provider by collecting three pieces of information--> loan amount, annual interest, and number of years to pay back in installments,
 * prints the loan providers by sorting providers in alphabetical order or ascending order of annualInterestRate
 * prints the loan providers whose annualInterestRate is less than or equal to the requested rate*/
public class BankFinder {

    /*Finds loan providers based on supplied information*/
    public BankFinder() {
        Scanner input = new Scanner(System.in);

        System.out.print("With how many banks you want to check: ");
        int howMany = input.nextInt();

        Bank[] banks = new Bank[howMany];
        banks = Arrays.stream(banks).map(i -> new Bank()).toList().toArray(new Bank[0]);

        /*sort banks in alphabetical order based on bank names */
        sortBank(banks, SortType.NAME);
        for (int i = 1; i < 96; i++)
            System.out.print("_");
        System.out.printf("\n|%-30s|%10s|%20s|%30s|\n", "Banks", "Codes", "AnnualInterestRate", "Date");
        for (int i = 1; i < 96; i++)
            System.out.print("_");
        Arrays.stream(banks).forEach(Bank::printBanksCode);
        System.out.println();
        for (int i = 1; i < 96; i++)
            System.out.print("_");
        System.out.println();

        System.out.print("Enter annual interest rate within (1.00-10.00): ");
        double annualInterestRate = input.nextDouble();
        System.out.print("Enter number of years as an integer: ");
        int numberOfYears = input.nextInt();
        System.out.print("Enter loan amount, for example, 120000.95: ");
        double loanAmount = input.nextDouble();

        /*sort banks in ascending order based on AnnualInterestRate */
        sortBank(banks, SortType.INTEREST_RATE);

        /*Display bank name, bank code, AnnualInterestRate, loan amount, monthly payment, numberOfMonths, total payment, quote created date*/
        for (int i = 1; i < 180; i++)
            System.out.print("_");
        System.out.printf("\n|%-30s|%10s|%20s|%20s|%20s|%20s|%20s|%30s|\n", "Banks", "Codes", "AnnualInterestRate", "LoanAmount", "monthlyPayment", "numberOfYears", "totalPayment", "Date");
        for (int i = 1; i < 180; i++)
            System.out.print("_");

        ArrayList<Bank> matchedBanks = new ArrayList<>();

        /*find loan providers*/
        Arrays.stream(banks).filter(bank -> bank.getLoanInfo().getAnnualInterestRate() <= annualInterestRate)
                .forEach(bank -> matchedBanks.add(findMatch(bank, annualInterestRate, numberOfYears, loanAmount)));

        System.out.println();
        for (int i = 1; i < 180; i++)
            System.out.print("_");
        /*print total match found-->count of loan providers*/
        System.out.println("\n" + matchedBanks.size() + " Match found");
    }

    /* get each loan provider matches the criteria --> AnnualInterestRate less than or equal to user requested AnnualInterestRate */
    public Bank findMatch(Bank bank, double annualInterestRate, int numberOfYears, double loanAmount) {
        bank.getLoanInfo().setAnnualInterestRate(annualInterestRate)
                .setNumberOfYears(numberOfYears)
                .setLoanAmount(loanAmount);
        System.out.printf("\n|%-30s|%10s|%20s|%20s|%20s|%20s|%20s|%30s|",
                bank.getBankName(),
                bank.getBankCode(),
                bank.getLoanInfo().getAnnualInterestRate(),
                bank.getLoanInfo().getLoanAmount(),
                bank.getLoanInfo().getMonthlyPayment(),
                bank.getLoanInfo().getNumberOfYears(),
                bank.getLoanInfo().getTotalPayment(),
                bank.getLoanInfo().getLoanDate());
        return bank;
    }

    public void sortBank(Bank[] b, SortType typeValue) {
        if (typeValue == SortType.NAME) {
            Arrays.stream(b).sorted(Comparator.comparing(Bank::getBankName).thenComparing(Bank::getLoanInfo)).toList().toArray(b);
        } else {
            Arrays.stream(b).sorted(Comparator.comparing(Bank::getLoanInfo).thenComparing(Bank::getBankName)).toList().toArray(b);
        }
    }

    private enum SortType {
        NAME,
        INTEREST_RATE
    }
}