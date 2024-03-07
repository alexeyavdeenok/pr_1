import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    private static final Scanner input = new Scanner(System.in);
    private static final ArrayList<Person> list = new ArrayList<>();
    public static void main(String[] args) {

        while (true) {
            System.out.println("1. Добавить элемент");
            System.out.println("2. Удалить элемент по индексу");
            System.out.println("3. Вывод всех элементов в консоль");
            System.out.println("4. Сравнение двух элементов на равенство (по индексам)");
            System.out.println("5. Завершение работы программы");

            int choice = 0;
            if (input.hasNextInt()) {
                choice = input.nextInt();
            } else {
                input.next();
            }
            switch (choice) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                    System.out.println("Программа завершена");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Ошибка ввода");
            }
        }
    }
}