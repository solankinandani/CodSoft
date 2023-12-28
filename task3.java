import java.util.Scanner;

class ATM 
{
    private UserBankAccount userAccount;

    public ATM(UserBankAccount userAccount)
   {
        this.userAccount = userAccount;
    }

    public void displayMenu()
   {
        System.out.println("ATM Menu:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void processOption(int option) 
  {
        Scanner scanner = new Scanner(System.in);

        switch (option)
	{
            case 1:
                System.out.print("Enter the amount to withdraw: ");
                double withdrawAmount = scanner.nextDouble();
                if (validateWithdrawal(withdrawAmount))
		 {
                    withdraw(withdrawAmount);
                    System.out.println("Withdrawal successful. Remaining balance: " + userAccount.getBalance());
                } 
		else 
		{
                    System.out.println("Invalid withdrawal amount or insufficient funds. Withdrawal failed.");
                }
                break;

            case 2:
                System.out.print("Enter the amount to deposit: ");
                double depositAmount = scanner.nextDouble();
                if (validateDeposit(depositAmount)) {
                    deposit(depositAmount);
                    System.out.println("Deposit successful. New balance: " + userAccount.getBalance());
                } else {
                    System.out.println("Invalid deposit amount. Deposit failed.");
                }
                break;

            case 3:
                checkBalance();
                break;
            case 4:
                System.out.println("Exiting ATM. Thank you!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    private boolean validateWithdrawal(double amount) {
        return amount > 0 && amount <= userAccount.getBalance();
    }

    private boolean validateDeposit(double amount) {
        return amount > 0;
    }

    private void withdraw(double amount) {
        userAccount.withdraw(amount);
    }

    private void deposit(double amount) {
        userAccount.deposit(amount);
    }

    private void checkBalance() {
        System.out.println("Current Balance: " + userAccount.getBalance());
    }
}

class UserBankAccount {
    private double balance;

    public UserBankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }
}

public class task3
 {
    public static void main(String[] args)
   {
        // Create a user's bank account with an initial balance of 1000
        UserBankAccount userAccount = new UserBankAccount(1000);

        // Create an ATM instance with the user's bank account
        ATM atm = new ATM(userAccount);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Display the ATM menu
            atm.displayMenu();

            // Get the user's choice
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            // Process the user's choice
            atm.processOption(choice);
        }
    }
}
