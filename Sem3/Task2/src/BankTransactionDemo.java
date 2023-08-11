public class BankTransactionDemo {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount(1000);
        BankAccount account2 = new BankAccount(2000);

        try {
            account1.transfer(account2, 500);
            System.out.println("Перевод выполнен успешно");
            System.out.println("Баланс счета 1: " + account1.getBalance());
            System.out.println("Баланс счета 2: " + account2.getBalance());
        } catch (InvalidAmountException | InsufficientFundsException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}