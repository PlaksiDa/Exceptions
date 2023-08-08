import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) {
        // Создаем экземпляр класса Bank для управления счетами
        Bank bank = new Bank();

        // Создаем несколько счетов
        bank.createAccount(1, 1000, 2000);
        bank.createAccount(2, 1500, 3000);
        bank.createAccount(3, 2000, 2500);

        // Создаем ExecutorService для многопоточной обработки транзакций
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Запускаем несколько транзакций для проверки функциональности
        for (int i = 0; i < 10; i++) {
            final int accountId = (i % 3) + 1;
            final double amount = 200;

            // Пополнение счета
            executor.execute(() -> {
                try {
                    bank.deposit(accountId, amount);
                    System.out.println("Счет " + accountId + ": Пополнение на " + amount + " рублей. Новый баланс: " + bank.getAccountBalance(accountId));
                } catch (MaxBalanceExceededException e) {
                    System.out.println("Ошибка: " + e.getMessage());
                }
            });

            // Снятие денег со счета
            executor.execute(() -> {
                try {
                    bank.withdraw(accountId, amount);
                    System.out.println("Счет " + accountId + ": Снятие " + amount + " рублей. Новый баланс: " + bank.getAccountBalance(accountId));
                } catch (InsufficientFundsException e) {
                    System.out.println("Ошибка: " + e.getMessage());
                }
            });
        }

        // Завершение ExecutorService
        executor.shutdown();

        try {
            // Ожидание завершения всех транзакций
            executor.awaitTermination(30, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}