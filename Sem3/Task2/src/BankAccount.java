public class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void transfer(BankAccount targetAccount, double amount)
            throws InvalidAmountException, InsufficientFundsException {
        if (amount <= 0) {
            throw new InvalidAmountException("Некорректная сумма перевода");
        }

        if (balance < amount) {
            throw new InsufficientFundsException("Недостаточно средств на счете");
        }

        balance -= amount;
        targetAccount.balance += amount;
    }
}