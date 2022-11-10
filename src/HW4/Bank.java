package HW4;

import java.util.Random;

/*Bank class maintains banks information.*/
public class Bank {
    private Loan loanInfo;
    private String bankName;
    private int bankCode;

    /* constructor to create initial banks with names, codes, and loan information with annualInterestRate, and quote created date*/
    Bank() {
        Random ranValue = new Random();
        String[] bankNames = {"Wells Fargo", "City Bank", "Chase", "Discovery", "Terra Bank", "PNC Financial Services", "Capital One Financial"};
        this.setBankName(bankNames[ranValue.nextInt(bankNames.length)]);
        this.bankCode = 1 + ranValue.nextInt(99);
        loanInfo = new Loan();
    }

    /*prints all banks with bank name, bank codes, bank annualInterestRate, and quote created date */
    public void printBanksCode() {
        System.out.printf("\n|%-30s|%10s|%20s|%30s|", this.bankName, this.bankCode, this.getLoanInfo().getAnnualInterestRate(), this.getLoanInfo().getLoanDate());
    }

    /*returns bankName */
    public String getBankName() {
        return bankName;
    }

    /*sets a new bankName*/
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    /*returns bankCode */
    public int getBankCode() {
        return bankCode;
    }

    /*sets a new bankCode*/
    public void setBankCode(int bankCode) {
        this.bankCode = bankCode;
    }

    /*returns loanInfo */
    public Loan getLoanInfo() {
        return loanInfo;
    }

    /*sets a new loanInfo*/
    public void setLoanInfo(Loan loanInfo) {
        this.loanInfo = loanInfo;
    }
}