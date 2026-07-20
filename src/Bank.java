// Bank class contains all banking operations.
import java.util.ArrayList;
import java.util.Scanner;

public class Bank {

    ArrayList<Account> accounts = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    int accountNumber = 1001;

    public void registerAccount() {

        System.out.println("\n===== Create New Account =====");

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Mobile Number: ");
        String mobile = sc.nextLine();
        if (!mobile.matches("[6-9]\\d{9}")) {
    System.out.println("Invalid mobile number! Please enter a valid 10-digit Indian mobile number.");
    return;
}

        System.out.print("Enter Initial Deposit: ");
        double balance = sc.nextDouble();
        sc.nextLine();

        if (balance < 0) {
    System.out.println("Initial deposit cannot be negative.");
    return;
}

        Account account = new Account(accountNumber++, name, mobile, balance);

        accounts.add(account);
        FileManager.saveAccount(account);

        System.out.println("\n==================================");
System.out.println("ACCOUNT CREATED SUCCESSFULLY");
System.out.println("==================================");
        System.out.println("Account Number : " + account.getAccountNumber());
        System.out.println("Account Holder : " + account.getName());
        System.out.println("Balance        : ₹" + account.getBalance());
    }
    public Account login() {

    System.out.print("\nEnter Account Number: ");
    int accNo = sc.nextInt();
    sc.nextLine();

    for (Account account : accounts) {

        if (account.getAccountNumber() == accNo) {

            System.out.println("\nLogin Successful!");
            System.out.println("Welcome " + account.getName());

            return account;
        }
    }

    System.out.println("Account Not Found!");

    return null;
}
public void deposit(Account account) {

    System.out.print("\nEnter Amount to Deposit: ₹");
    double amount;

    try {

        amount = sc.nextDouble();
        sc.nextLine();   // Only ONE nextLine()

    } catch (Exception e) {

        System.out.println("Invalid amount!");
        sc.nextLine();
        return;

    }

    if (amount <= 0) {
        System.out.println("Deposit amount must be greater than zero.");
        return;
    }

    account.setBalance(account.getBalance() + amount);
    account.addTransaction(new Transaction("Deposit", amount));

    System.out.println("₹" + amount + " deposited successfully.");
    System.out.println("Updated Balance: ₹" + account.getBalance());
}
public void withdraw(Account account) {

    System.out.print("\nEnter Amount to Withdraw: ₹");
    double amount;

try {

    amount = sc.nextDouble();

} catch (Exception e) {

    System.out.println("Invalid amount!");

    sc.nextLine();

    return;

}

sc.nextLine();

    if (amount <= 0) {
    System.out.println("Withdrawal amount must be greater than zero.");
    return;
}
    if (amount > account.getBalance()) {

        System.out.println("Insufficient Balance!");

    } else {

        account.setBalance(account.getBalance() - amount);
        account.addTransaction(new Transaction("Withdraw", amount));

        System.out.println("₹" + amount + " withdrawn successfully.");
        System.out.println("Remaining Balance: ₹" + account.getBalance());
    }
}
public void checkBalance(Account account) {

    System.out.println("\nCurrent Balance: ₹" + account.getBalance());

}

public void transactionHistory(Account account) {

    System.out.println("\n===== Transaction History =====");

    if (account.getTransactions().isEmpty()) {
        System.out.println("No transactions found.");
        return;
    }

    for (Transaction t : account.getTransactions()) {

        System.out.println(
                t.getType() + " : ₹" + t.getAmount());

    }

}
public void updateMobile(Account account) {

    System.out.print("\nEnter New Mobile Number: ");
    String newMobile = sc.nextLine();

    if (!newMobile.matches("[6-9]\\d{9}")) {
        System.out.println("Invalid mobile number! Please enter a valid 10-digit Indian mobile number.");
        return;
    }

    account.setMobile(newMobile);

    System.out.println("Mobile number updated successfully!");
}

}