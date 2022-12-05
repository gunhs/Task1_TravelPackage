import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        System.out.println("Программа для управления путешествиями");
        while (true) {
            System.out.println("""
                    ----------------------------------------------------
                    Введите номер команды:
                    1. Добавить тур
                    2. Купить путёвку
                    3. Отменить покупку
                    4. Показать информацию о путёвках по туру
                    5. Показать количество оставшихся путёвок по туру
                    6. Показать все туры с количеством путёвок
                    7. Возврат в главное меню
                    0. Выход из программы""");
            
            try {
                int a = new Scanner(System.in).nextInt();
                if (a == 0) {
                    break;
                }
                ServiceFactory.processing(a);
                
            } catch (InputMismatchException exception) {
                System.out.println("Ошибка ввода. Введите команду от 1 до 6");
            }
        }
    }
}
