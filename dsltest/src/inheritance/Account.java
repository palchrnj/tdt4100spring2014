package inheritance;

public interface Account {
	
	public String getName();
	
	public void setName(String name);
	
	public void deposit(double amount);

	public void withdraw(double amount);
	
	public double getBalance();
	
}
