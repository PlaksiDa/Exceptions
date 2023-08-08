public class BankAccount {
    private final int accountId;
    private volatile double balance;
    private final double maxBalance;

    public BankAccount(int accountId, double initialBalance, double maxBalance) {
        this.accountId = accountId;
        this.balance = initialBalance;
        this.maxBalance = maxBalance;
    }

    public int getAccountId() {
        return accountId;
    }

    public double getBalance() {
        return balance;
    }

    public double getMaxBalance() {
        return maxBalance;
    }

    // Метод для пополнения счета
    public synchronized void deposit(double amount) throws MaxBalanceExceededException {
        double newBalance = balance + amount;
        if (newBalance > maxBalance) {
            throw new MaxBalanceExceededException("Превышение максимального допустимого баланса");
        }
        balance = newBalance;
    }

    // Метод для снятия денег со счета
    public synchronized void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Недостаточно средств на счете");
        }
        balance -= amount;
    }
}