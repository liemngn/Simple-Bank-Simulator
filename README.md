# Simple-Bank-Simulator

## Project Details:
- A simple bank management simulator that **registers and removes accounts** and **processes account information** through user input from the **console**. 

- The user is prompted to enter a name and valid social security number and can add/remove an account under the given information, deposit/withdraw money in/from the account, or display the current account details.

- Additional technical commands: displaying all registered accounts in the system, tracking the total number of accounts registered, navigation commands `back` and `quit`, and of course a display of all commands using `help`.

## Classes implemented:

### 1. Account
- `Account` is a class used to hold the characteristics of each account being processed within the bank management system.

- Each account holds a name, social security number, and amount balance.

#### Methods:
`public String getName()`
- Returns the name of the account.

`public String getSSN()`
- Returns the social security number of the account.

`public boolean depositMoney(double amount)`
- If `amount` is a valid number to deposit (positive ints), add `amount` to the balance and return true; otherwise, do not change account balance and return false.

`public boolean withdrawMoney(double amount)`
- Like `depositMoney`, if `amount` is a valid number to withdraw (positive ints), reduce the balance with `amount` and return true; otherwise, do not change account balance and return false.

### 2. AccountList
- `AccountList` is the class that simulates bank management processes.

- I use an `ArrayList` named `accounts` to hold all instances of `Account` objects

#### Methods:
`public boolean register(String name, String ssn)`
- Adds a new `Account` with valid name and social security number into `accounts` and returns true; otherwise, don't add anything and return false.
`public boolean removeAcc(String name, String ssn)`
- Removes the `Account` object that has `name` and `ssn` and returns true; otherwise, don't alter the list and return false.
`public void deposit(String name, String ssn, double amount)`
- Adds `amount` to the current balance of the `Account` object with `name` and `ssn`.
`public void withdraw(String name, String ssn, double amount)`
- Removes `amount` from the current balance of the `Account` object with `name` and `ssn`.
`public void display(String name, String ssn)`
- Displays the contents of the `Account` object with `name` and `ssn`.
`public void displayAll()`
- Displays the contents of all `Account` objects.
`public int total()`
- Returns total number of `Account` objects added in `accounts` which is then printed through `Driver` class.
