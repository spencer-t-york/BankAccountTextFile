/* Name: Spencer York
 * CSU ID: 2834131
 * CIS 265: Assignment #4
 * Description: Read bank accounts, including checking and savings accounts, from
 *              an input file, and write them in reverse order to an output file.
 */

import java.io.*;
import java.util.*;

public class YorkAssignment4 {
    public static void main(String[] args) throws IOException {

        int accountNum = 0;

        File file = new File(args[0]);
        Scanner input = new Scanner(file);
        input.useDelimiter(",");

        ArrayList<BankAccount> account = new ArrayList<>(accountNum);

        int checkLimit;
        double interest;
        try {
            while (input.hasNext()) {
                String owner = input.next();
                int number = input.nextInt();
                double balance = input.nextDouble();
                String accountType = input.next();
                if (Objects.equals(accountType, "checking")) {
                    checkLimit = Integer.parseInt(input.nextLine().replaceAll(",", ""));
                    account.add(new CheckingAccount(owner, number, balance, checkLimit)); // add object to the arraylist
                    accountNum++;
                } else if (Objects.equals(accountType, "savings")) {
                    interest = Double.parseDouble(input.nextLine().replaceAll(",", ""));
                    account.add(new SavingsAccount(owner, number, balance, interest));    // add object to the arraylist
                    accountNum -=-1;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Error reading input file: " + e.getMessage());
            return;
        }

        try {
            PrintWriter writer = new PrintWriter(args[1]);
            Collections.reverse(account);
            for (BankAccount acc : account) {
                acc.printBankAccount(writer);
            }
            writer.close();
            System.out.println("Bye!");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
