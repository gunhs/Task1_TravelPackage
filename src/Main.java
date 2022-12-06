import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Программа для управления путешествиями");
        System.out.println("Анечка, ты лучшая ❤️");
        while (true) {
            System.out.println("""
                    ----------------------------------------------------
                    Введите номер команды:
                    1. Добавить тур
                    2. Купить путёвку
                    3. Отменить покупку
                    4. Показать информацию о приобретенных путёвках
                    5. Показать количество оставшихся путёвок по туру
                    6. Показать все туры в продаже с количеством путёвок
                    7. Возврат в главное меню
                    0. Выйти из программы""");
            try {
                int a = new Scanner(System.in).nextInt();
                if (a == 0) break;
                ServiceFactory.processing(a);
            } catch (InputMismatchException exception) {
                System.out.println("Ошибка ввода. Введите команду от 1 до 6");
            }
        }
    }
}
