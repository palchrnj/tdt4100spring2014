package inheritance;

public class SavingsAccount implements Account{
	
	protected String name;
	protected double balance;
	protected double interest;
	
	public SavingsAccount(String name, double balance, double interest) {
		this.name = name;
		this.balance = balance;
		this.interest = interest;
	}
	
	public void deposit(double amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("Can only deposit positive monetary amount.");
		} else {
			balance += amount;
		}
	}

	public void withdraw(double amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("Can only withdraw positive monetary amount.");
		} else if (balance - amount < 0) {
			throw new IllegalStateException("Insufficient funds for withdrawal.");
		} else {
			balance -= amount;
		}
	}

	public double getBalance() {
		return balance;
	}
	
	public double getInterest() {
		return interest;
	}
	
	public void setInterest(double interest) {
		this.interest = interest;
	}
	
	public void accrueInterest() {
		balance *= (1+interest);
	}
}