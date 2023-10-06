import java.io.IOException;
import java.io.PrintWriter;

public class CheckingAccount extends BankAccount {
    private int checkLimit;

    public CheckingAccount() throws IOException {
        super();
    }

    public CheckingAccount(String owner, int number, double balance, int checkLimit) throws IOException {
        super();
        setOwner(owner);
        setNumber(number);
        setBalance(balance);
        this.checkLimit = checkLimit;

    }

    @Override
    public void printBankAccount(PrintWriter pw) {
        pw.write(getOwner() + ",");
        pw.write(getNumber() + ",");
        pw.write(getBalance() + ",");
        pw.write("checking,");
        pw.write(Integer.toString(checkLimit));
        pw.write("\n");
    }
}