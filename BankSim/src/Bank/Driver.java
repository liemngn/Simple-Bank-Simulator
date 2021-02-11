package Bank;

import java.util.Scanner;

// Runs bank management system through console.

public class Driver {

	public static void main(String[] args) {
		AccountList list = new AccountList();
		Scanner in = new Scanner(System.in);
		boolean cont = true;
		int input = 0;
		double amount = 0;
		
		System.out.println("Welcome to your Bank Management System!");
		do {
			boolean managing = true;
			System.out.println("Enter 1 for managing.");
			System.out.println("Otherwise, enter -1 to exit.");

			if (in.hasNextInt()) {
				input = in.nextInt();
			} else {
				in.next();
			}
			
			if (input == 1) {

				input = 0;
				System.out.println("Enter the name and SSN of the new or existing account.");
				in.nextLine();
				String name = in.nextLine();
				String ssn = in.nextLine();	
				
				do {
					System.out.println("What would you like to do?");
					System.out.println("Enter \"help\" to see commands.");
					System.out.println("Type command or number assigned to command.");
					String command = in.nextLine();
					
					switch (command) {
					case "1":
					case "register":
						list.register(name, ssn);
						break;
					case "2":
					case "remove":
						list.removeAcc(name, ssn);
						break;
					case "3":
					case "deposit":
						boolean num = true;
						do {
							System.out.println("Enter an amount to deposit.");
							if (in.hasNextDouble()) {
								amount = in.nextDouble();
								list.deposit(name, ssn, amount);
								num = false;
								in.nextLine();
							} else {
								in.next();
							}
						} while (num);
						break;
					case "4":
					case "withdraw":
						num = true;
						do {
							System.out.println("Enter an amount to withdraw.");
							if (in.hasNextDouble()) {
								amount = in.nextDouble();
								list.withdraw(name, ssn, amount);
								num = false;
								in.nextLine();
							} else {
								in.next();
							}
						} while (num);
						break;
					case "5":
					case "display":
						list.display(name, ssn);
						break;
					case "6":
					case "display all":
						list.displayAll();
						break;
					case "7":
					case "total":
						System.out.println(list.total() + " account(s).");
						break;
					case "8":
					case "back":
						managing = false;
						break;
					case "9":
					case "quit":
						System.out.println("Exiting...");
						System.out.println("See ya!");
						cont = false;
						break;
					case "help":
						System.out.println("1. register");
						System.out.println("2. remove");
						System.out.println("3. deposit");
						System.out.println("4. withdraw");
						System.out.println("5. display");
						System.out.println("6. display all");
						System.out.println("7. total");
						System.out.println("8. back");
						System.out.println("9. quit");
						break;
					default:
						System.out.println("Invalid command please try again.");
						System.out.println();
						break;
					}
					
					System.out.println();
					
				} while (managing && cont);
				
				} else if (input == -1){
					System.out.println("Exiting...");
					System.out.println("See ya!");
					cont = false;
				} else {
					System.out.println("Invalid input, please try again.");
				}

				System.out.println();
				
			} while(cont);

			in.close();
		}

	}
