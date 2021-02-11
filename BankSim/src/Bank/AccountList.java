package Bank;

import java.util.ArrayList;

public class AccountList {
	private ArrayList<Account> accounts;

	public AccountList() {
		accounts = new ArrayList<>();
	}

	public boolean register(String name, String ssn) {		
		if(validSSN(ssn) && !contains(name, ssn)) {
			Account account = new Account(name, ssn);
			
			if (accounts.size() > 0) {
				for (int i = 0; i < accounts.size(); i++) {
					if (name.compareTo(accounts.get(i).getName()) < 0) {
						accounts.add(i, account);
						System.out.println("Account as been registered.");
						System.out.println("Type \"display\" to view account details.");
						return true;
					} else if (name.compareTo(accounts.get(i).getName()) == 0) {
						sortSSN(name, ssn, i, account);
						System.out.println("Account has been registered.");
						System.out.println("Type \"display\" to view account details.");
						return true;
					} else if (i == accounts.size() - 1) {
						accounts.add(account);
						System.out.println("Account has been registered.");
						System.out.println("Type \"display\" to view account details.");
						return true;
					}
				}
			} else {
				accounts.add(account);
				System.out.println("Account has been registered.");
				System.out.println("Type \"display\" to view account details.");
				return true;
			}

		} else {
			System.out.println("Account already registered or invalid SSN.");
		}	
		
		return false;
	}

	public void removeAcc(String name, String ssn) {
		if (contains(name, ssn)) {
			for (int i = 0; i < accounts.size(); i++) {
				if (accounts.get(i).getName().compareTo(name) == 0 &&
					accounts.get(i).getSSN().compareTo(ssn) == 0) {
					accounts.remove(i);
					System.out.println("Account has been removed.");
				}
			}
		} else {
			System.out.println("Account must be registered first.");
			System.out.println("Type \"register\" to register account.");
		}
	}

	public void deposit(String name, String ssn, double amount) {
		if (contains(name, ssn)) {
			for (Account curr : accounts) {
				if (curr.getName().compareTo(name) == 0 &&
					curr.getSSN().compareTo(ssn) == 0) {
					curr.depositMoney(amount);
				}
			}
		} else {
			System.out.println("Account must be registered first.");
			System.out.println("Type \"register\" to register account.");
		}
	}

	public void withdraw(String name, String ssn, double amount) {
		if (contains(name, ssn)) {
			for (Account curr : accounts) {
				if (curr.getName().compareTo(name) == 0 &&
					curr.getSSN().compareTo(ssn) == 0) {
					curr.withdrawMoney(amount);
				}
			}
		} else {
			System.out.println("Account must be registered first.");
			System.out.println("Type \"register\" to register account.");		
		}
	}
	
	public void display(String name, String ssn) {
		if (contains(name, ssn)) {
			for (int i = 0; i < accounts.size(); i++) {
				if (accounts.get(i).getName().compareTo(name) == 0 &&
					accounts.get(i).getSSN().compareTo(ssn) == 0) {
					System.out.println(accounts.get(i).toString());
				}
			}
		} else {
			System.out.println("Account must be registered first.");
			System.out.println("Type \"register\" to register account.");
		}
	}

	public void displayAll() {
		if (accounts.size() > 0) {
			for (Account curr : accounts) {
				System.out.println(curr.toString());
			}
		} else {
			System.out.println("No existing accounts.");
		}
	}

	public int total() {
		return accounts.size();
	}
	
	private boolean contains(String name, String ssn) {
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getName().compareTo(name) == 0 &&
				accounts.get(i).getSSN().compareTo(ssn) == 0) {
				return true;
			}
		}
		return false;
	}

	private boolean validSSN(String ssn) {
		if (ssn.length() == 11) {
			for (int i = 0; i < ssn.length(); i++) {
				if ((i >= 0 && i <= 2) || (i == 4 || i == 5) ||
					(i >= 7 && i <= 10)) {
					if (!Character.isDigit(ssn.charAt(i))) {
						return false;
					}
				} else if (ssn.charAt(i) != '-') {
					return false;
				} 
			}
		} else {
			return false;
		}
		return true;
	}
	
	// Sorts SSN as they are being registered (if name is the same).
	private boolean sortSSN(String name, String ssn, int index, Account acc) {
		for (int i = index; i < accounts.size(); i++) {
			if (accounts.get(i).getName().compareTo(name) == 0) {
				if (ssn.compareTo(accounts.get(i).getSSN()) < 0) {
					accounts.add(i, acc);
					return true;
				} else if (i == accounts.size() - 1){
					accounts.add(acc);
					return true;
				}
			} else {
				accounts.add(i, acc);
				return true;
			}
		}
		return false;
	}
	
}
