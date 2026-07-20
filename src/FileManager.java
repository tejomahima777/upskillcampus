import java.io.FileWriter;
import java.io.IOException;

public class FileManager {

    public static void saveAccount(Account account) {

        try {

            FileWriter writer = new FileWriter("accounts.txt", true);

            writer.write(
                    account.getAccountNumber() + "," +
                    account.getName() + "," +
                    account.getMobile() + "," +
                    account.getBalance() + "\n");

            writer.close();

        } catch (IOException e) {

            System.out.println("Error saving account.");

        }

    }
}