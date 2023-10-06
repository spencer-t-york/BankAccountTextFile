import java.io.IOException;
import java.io.PrintWriter;

public class SavingsAccount extends BankAccount {
    private double interest;

    public SavingsAccount() throws IOException {
        super();
    }

    public SavingsAccount(String owner, int number, double balance, double interest) throws IOException {
        super();
        setOwner(owner);
        setNumber(number);
        setBalance(balance);
        this.interest = interest;

    }

    @Override
    public void printBankAccount(PrintWriter pw) {
        pw.write(getOwner() + ",");
        pw.write(getNumber() + ",");
        pw.write(getBalance() + ",");
        pw.write("savings,");
        pw.write(Double.toString(interest));
        pw.write("\n");
    }
}
