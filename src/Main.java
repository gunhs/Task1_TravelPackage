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
                    0. Выход из команды""");
            
            try {
                //int a = getS();
                if (getS() == 0) {
                    ServiceFactory.processing();
                }
                
            } catch (InputMismatchException exception) {
                System.out.println("Ошибка ввода. Введите команду от 1 до 6");
            }
        }
    }
    public static int getS() {
        
        
        return new Scanner(System.in).nextInt();
    }
}