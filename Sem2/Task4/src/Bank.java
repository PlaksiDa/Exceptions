import java.util.HashMap;
import java.util.Map;

public class Bank {
    private final Map<Integer, BankAccount> accounts;

    public Bank() {
        this.accounts = new HashMap<>();
    }

    // Метод для создания нового счета
    public synchronized void createAccount(int accountId, double initialBalance, double maxBalance) {
        if (!accounts.containsKey(accountId)) {
            BankAccount account = new BankAccount(accountId, initialBalance, maxBalance);
            accounts.put(accountId, account);
        }
    }

    // Метод для пополнения счета
    public void deposit(int accountId, double amount) throws MaxBalanceExceededException {
        if (accounts.containsKey(accountId)) {
            BankAccount account = accounts.get(accountId);
            account.deposit(amount);
        }
    }

    // Метод для снятия денег со счета
    public void withdraw(int accountId, double amount) throws InsufficientFundsException {
        if (accounts.containsKey(accountId)) {
            BankAccount account = accounts.get(accountId);
            account.withdraw(amount);
        }
    }

    // Метод для получения текущего баланса счета
    public double getAccountBalance(int accountId) {
        if (accounts.containsKey(accountId)) {
            BankAccount account = accounts.get(accountId);
            return account.getBalance();
        }
        return -1; // Вернуть значение -1 или null, если счет не существует
    }
}