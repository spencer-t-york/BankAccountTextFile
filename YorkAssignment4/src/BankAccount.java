import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.Locale;

public abstract class BankAccount {
    // For currency formatting
    final Locale locale = new Locale.Builder().setLanguage("en").setRegion("US").build();
    NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);

    // VARIABLES
    private String owner;
    private int number;
    private double balance;


    // SETTERS
    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // GETTERS
    public String getOwner() {
        return owner;
    }
    public int getNumber() {
        return number;
    }
    public double getBalance() {
        return balance;
    }

    // Constructors
    public BankAccount() throws IOException {
    }

    public BankAccount(String owner, int number, double balance) throws IOException {
        this.owner = owner;
        this.number = number;
        this.balance = balance;
    }

    // Display Bank Account Info
    FileWriter output = new FileWriter("accounts_reversed.txt");
    public void printBankAccount(PrintWriter pw) {
        pw.write(owner + ",");
        pw.write(number + ",");
        pw.write(Double.toString(balance));
        pw.write("\n");
    }


}