package work04;

/**
 * 
 * @author Chan Thongjerm 63130500019
 */
public class BankAccount {
    private int number;
    private Person owner;
    private double balance;
    
    public BankAccount(int number, Person owner) {
        this.number = number;
        this.owner = owner;
    }

    public Person getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }
    
    public double deposit(double amount) {
        return balance = balance + amount;
    }
    
    public double withdraw(double amount) {
        return balance = balance - amount;
    }
    
    public void transfer(double amount, BankAccount account) {
        balance = balance - amount;
        account.deposit(amount);
    }

    @Override
    public String toString() {
        return "BankAccount(" + number + ")";
    }
}
