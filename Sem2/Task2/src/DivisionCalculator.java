import java.util.Scanner;

public class DivisionCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Введите первое число: ");
            double num1 = scanner.nextDouble();

            System.out.print("Введите второе число: ");
            double num2 = scanner.nextDouble();

            if (num2 == 0) {
                throw new DivisionByZeroException("Деление на ноль недопустимо");
            } else {
                double result = num1 / num2;
                System.out.println("Результат деления: " + result);
            }
        } catch (DivisionByZeroException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Ошибка: Введено некорректное значение");
        } finally {
            scanner.close();
        }
    }
}