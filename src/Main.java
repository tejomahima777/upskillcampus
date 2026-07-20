import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();

        while (true) {

            System.out.println("**********************************************");
System.out.println("*      WELCOME TO BANKING INFO MANAGEMENT        *");
System.out.println("**********************************************");
            System.out.println("1. Register Account");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    bank.registerAccount();
                    break;

                case 2:

    Account currentUser = bank.login();

    if (currentUser != null) {

        int option;

        do {

            System.out.println("\n===== BANK MENU =====");
            System.out.println("1. Deposit");
System.out.println("2. Withdraw");
System.out.println("3. Check Balance");
System.out.println("4. Transaction History");
System.out.println("5. Update Mobile Number");
System.out.println("6. Logout");
System.out.print("Enter Choice: ");

            option = sc.nextInt();

            switch (option) {

    case 1:
        bank.deposit(currentUser);
        break;

    case 2:
        bank.withdraw(currentUser);
        break;

    case 3:
        bank.checkBalance(currentUser);
        break;

    case 4:
        bank.transactionHistory(currentUser);
        break;

    case 5:
    bank.updateMobile(currentUser);
    break;

case 6:
    System.out.println("Logged Out Successfully!");
    break;

    default:
        System.out.println("Invalid Choice!");
}
        } while(option != 6);

    }

    break;

                case 3:
                    System.out.println("Thank you for using our Banking System!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice! Please try again.");
            }
        }
    }
}