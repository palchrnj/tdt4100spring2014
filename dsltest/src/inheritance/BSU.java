package inheritance;

public class BSU extends SavingsAccount {
	
	protected double availableBalance;
	protected double depositLimit;
	
	public BSU(String name, double balance, double interest, double depositLimit) {
		super(name, balance, interest);
		availableBalance = balance;
		this.depositLimit = depositLimit;
	}
	
	public void deposit(double amount) {
		if (availableBalance + amount > depositLimit) {
			throw new IllegalStateException("Cannot deposit more than the limit of "+ depositLimit + " per year.");
		} else {
			super.deposit(amount);
			availableBalance += amount;
		}
	}
	
	public void withdraw(double amount) {
		if (amount > availableBalance) {
			throw new IllegalStateException("Insufficient available funds for withdrawal.");
		} else {
			super.withdraw(amount);
			availableBalance -= amount;
		}
	}
	
	public void accrueInterest() {
		super.accrueInterest();
		availableBalance = 0;
	}
	
	public double getTaxDeduction() {
		return availableBalance * 0.20;
	}
}
