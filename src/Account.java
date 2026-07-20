// Account class stores customer details and account balance.
import java.util.ArrayList;
public class Account {

    private int accountNumber;
    private String name;
    private String mobile;
    private double balance;
    private ArrayList<Transaction> transactions = new ArrayList<>();

    public Account(int accountNumber, String name, String mobile, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.mobile = mobile;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setMobile(String mobile) {
    this.mobile = mobile;
}

    public ArrayList<Transaction> getTransactions() {
    return transactions;
}

public void addTransaction(Transaction transaction) {
    transactions.add(transaction);
}


}
