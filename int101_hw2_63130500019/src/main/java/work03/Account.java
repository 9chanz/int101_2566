package work03;

import work01.Utilitor;
import work02.Person;

/**
 * 
 * @author Chan Thongjerm 63130500019
 */
public class Account {

    private static long nextNo = 100_000_000;
    private final long no;
    private Person owner;
    private double balance;

    public Account(Person owner) {
        if (owner == null) {
            throw new NullPointerException("Owner cannot be null.");
        }

        this.owner = owner;
        this.balance = 0.0;

        /*
         * 1) Let result = Utilitor.computeIsbn10(nextNo).
         * 2) If result is 10, increment the value of "nextNo" by 1 
         *    and try Step 1) again until the result is not 10. 
         * 3) Set the value of "no" filed to be 10 * nextNo + the result.
         * 4) Increment the value of "nextNo" by 1.
         */
        do {
            long result = Utilitor.computeIsbn10(nextNo);
            if (result != 10) {
                this.no = 10 * nextNo + result;
                nextNo++;
                break;
            }
            nextNo++;
        } while (true);
    }

    public long getNo() {
        return no;
    }

    public Person getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public double deposit(double amount) {
        if (amount < 0) {
            Utilitor.testPositive(amount);
        }
        return balance += amount;
    }

    public double withdraw(double amount) {
        if (amount < 0) {
            Utilitor.testPositive(amount);
        }
        return balance -= amount;
    }

    public void transfer(double amount, Account account) {
        if (account == null) {
            throw new IllegalArgumentException("Invalid transfer.");
        }
        
        balance -= amount;
        account.deposit(amount);
    }

    @Override
    public String toString() {
        return "Account(" + no + "," + balance + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return false;
    }
}
