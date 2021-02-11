package Bank;

public class Account {

	private String name;
	private String ssn;
	private double balance;
	
	public Account(String name, String ssn) {
		this.name = name;
		this.ssn = ssn;
		balance = 0.0;
	}
	
	public String getName() {
		return name;
	}
	
	public String getSSN() {
		return ssn;
	}
	
	public boolean depositMoney(double amount) {
		if (amount > 0.0) {
			balance += amount;
			balance = Math.round(balance * 100) / 100.00;
			System.out.println("Deposit successful!");
			return true;
		} else if (amount == 0) {
			System.out.println("Nothing deposited.");
		} else {
			System.out.println("Invalid input.");
		}
		return false;
	}
	
	public boolean withdrawMoney(double amount) {
		if (amount > 0.0) {
			balance -= amount;
			balance = Math.round(balance * 100) / 100.00;
			System.out.println("Withdrawal successful!");
			if (balance < 0) {
				System.out.println("You are now in debt :(");
			}
			return true;
		} else if (amount == 0) {
			System.out.println("Nothing withdrawn");
		} else {
			System.out.println("Invalid input.");
		}
		return false;
	}
	
	@Override
	public String toString() {
		return name + ", SSN: " + ssn + ", " + "Balance: $" + balance;
	}
	
}
