import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Введите первое число: ");
            int num1 = scanner.nextInt();
            if (num1 > 100) {
                throw new NumberOutOfRangeException("Первое число вне допустимого диапазона");
            }

            System.out.print("Введите второе число: ");
            int num2 = scanner.nextInt();
            if (num2 < 0) {
                throw new NumberOutOfRangeException("Второе число вне допустимого диапазона");
            }

            int sum = num1 + num2;
            if (sum < 10) {
                throw new NumberSumException("Сумма первого и второго чисел слишком мала");
            }

            System.out.print("Введите третье число: ");
            int num3 = scanner.nextInt();
            if (num3 == 0) {
                throw new DivisionByZeroException("Деление на ноль недопустимо");
            }

            System.out.println("Проверка пройдена успешно");
        } catch (NumberOutOfRangeException e) {
            System.out.println(e.getMessage());
        } catch (NumberSumException e) {
            System.out.println(e.getMessage());
        } catch (DivisionByZeroException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Ошибка: Введено некорректное значение");
        } finally {
            scanner.close();
        }
    }
}