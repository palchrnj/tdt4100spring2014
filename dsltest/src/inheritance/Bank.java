package inheritance;

import java.util.ArrayList;

public class Bank {
	
	public static void main(String[] args) {
		Account bsu = new BSU("Per", 0, 0.045, 20000);
		Account foreldrespar = new ForeldreSpar("Egil", 0, 0.035, 4);
		ArrayList<Account> accounts = new ArrayList<Account>();
		accounts.add(bsu);
		accounts.add(foreldrespar);
		bsu.deposit(15000);
		bsu.deposit(5000);
		foreldrespar.deposit(10000);
		foreldrespar.withdraw(10);
		foreldrespar.withdraw(10);
		foreldrespar.withdraw(10);
		foreldrespar.withdraw(10);
		foreldrespar.withdraw(10);
		
		for (Account account : accounts) {
			
		}
	}
	
}
	