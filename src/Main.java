import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Переменные для хранения общей суммы и минимальной разницы
        int maxSum = 0;
        int minDifference = Integer.MAX_VALUE;

        try (Scanner scanner = new Scanner(new File("src\\input.txt"))) {
            while (scanner.hasNextLine()) {
                // Считываем пару чисел из строки
                String line = scanner.nextLine();
                String[] numbers = line.split(" ");
                int a = Integer.parseInt(numbers[0]);
                int b = Integer.parseInt(numbers[1]);

                // Если оба числа кратны или некратны 3, прибавляем наибольшее из них к сумме
                if (a % 3 == b % 3 || (a % 3 != 0 && b % 3 != 0)) {
                    maxSum += Math.max(a, b);
                } else {
                    // Если одно число кратно 3, а другое нет
                    if (a % 3 == 0 && a > b) {
                        int diff = a - b;
                        if (diff < minDifference) {
                            minDifference = diff;
                        }
                        maxSum += a;
                    } else if (b % 3 == 0 && b > a) {
                        int diff = b - a;
                        if (diff < minDifference) {
                            minDifference = diff;
                        }
                        maxSum += b;
                    } else {
                        maxSum += Math.max(a, b);
                    }
                }
            }

            // Проверка, делится ли сумма на 3
            if (maxSum % 3 == 0) {
                maxSum -= minDifference;
            }

            // Вывод результата
            System.out.println(maxSum);

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден.");
            e.printStackTrace();
        }
    }
}
