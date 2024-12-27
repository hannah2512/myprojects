
import java.util.HashMap;
import java.util.Scanner;

public class BankingSystem {
    
    static class Account {
        private String name;
        private double balance;

        Account(String name) {
            this.name = name;
            this.balance = 0.0;
        }

        void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Deposited: $" + amount);
            } else {
                System.out.println("Invalid deposit amount.");
            }
        }

        void withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.println("Withdrew: $" + amount);
            } else if (amount > balance) {
                System.out.println("Insufficient funds.");
            } else {
                System.out.println("Invalid withdrawal amount.");
            }
        }

        double getBalance() {
            return balance;
        }

        String getName() {
            return name;
        }
    }

    static class Bank {
        private HashMap<String, Account> accounts;

        Bank() {
            accounts = new HashMap<>();
        }

        void createAccount(String name) {
            if (!accounts.containsKey(name)) {
                accounts.put(name, new Account(name));
                System.out.println("Account created for " + name);
            } else {
                System.out.println("Account already exists for " + name);
            }
        }

        Account getAccount(String name) {
            return accounts.get(name);
        }

        boolean accountExists(String name) {
            return accounts.containsKey(name);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();
        int choice;

        while (true) {
            System.out.println("\n----- Banking System Menu -----");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter account holder name: ");
                    String name = scanner.nextLine();
                    bank.createAccount(name);
                    break;

                case 2:
                    System.out.print("Enter account holder name: ");
                    name = scanner.nextLine();
                    if (bank.accountExists(name)) {
                        System.out.print("Enter deposit amount: $");
                        double depositAmount = scanner.nextDouble();
                        bank.getAccount(name).deposit(depositAmount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter account holder name: ");
                    name = scanner.nextLine();
                    if (bank.accountExists(name)) {
                        System.out.print("Enter withdrawal amount: $");
                        double withdrawAmount = scanner.nextDouble();
                        bank.getAccount(name).withdraw(withdrawAmount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter account holder name: ");
                    name = scanner.nextLine();
                    if (bank.accountExists(name)) {
                        System.out.println("Balance for " + name + ": $" + bank.getAccount(name).getBalance());
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting application...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
