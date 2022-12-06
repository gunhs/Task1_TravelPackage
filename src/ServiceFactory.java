import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ServiceFactory {
    static TravelPackages travelPackages = new TravelPackages();

    public static void processing(int command) {
        switch (command) {
            case 1 -> addTour();
            case 2 -> bayTour();
            case 3 -> cancelTour();
            case 4 -> getVoucherByTour();
            case 5 -> getVoucherCount();
            case 6 -> getTourCountVoucher();
            default -> System.out.println("Неверный номер команды. Введите команду от 0 до 6");
        }
    }

    private static void addTour() {
        try {
            System.out.println("Введите данные о туре через запятую.\n" +
                    "Например: Бали, 23.11.2021, 14, 150000, 5");
            String input = new Scanner(System.in).nextLine().trim();
            while (!input.matches("[А-я\\s]+, \\d{2}\\.\\d{2}\\.\\d{4}, \\d+, \\d+, \\d+")
                    && !input.equals("7")) {
                System.out.println("""
                        Ошибка. Введите корректно!
                        Например: Бали, 23.11.2021, 14, 150000, 5""");
                input = new Scanner(System.in).nextLine().trim();
            }
            if (input.equals("7")) return;
            String[] components = input.split(",");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDate date = LocalDate.parse(components[1].trim(), formatter);
            travelPackages.addTour(components[0].trim(), new Tour(components[0].trim(),
                    date,
                    Integer.parseInt(components[2].trim()),
                    Double.parseDouble(components[3]),
                    Integer.parseInt(components[4].trim())));
        }catch (DateTimeParseException dtEx){
            System.out.println("""
                    Некорректно введена дата.\s
                    Введите дату в следующем формате:
                    День, месяц, год""");
        }
    }

    private static void bayTour() {
        System.out.println("""
                Введите данные тура и путешественника.
                Название, дата начала, количество дней, ФИО, номер паспорта.
                Например: Бали, Горохов Иван Дмитриевич, 8977090809""");
        String input2 = new Scanner(System.in).nextLine().trim();
        while (!input2.matches("[А-я\\s]+, [А-Я][а-я] ([A-Я][а-я])? [А-Я][а-я], \\d{10}")
                && input2.equals("7")) {
            System.out.println("""
                    Ошибка. Введите корректно!
                    Например: Бали, Горохов Иван Дмитриевич, 8977090809""");
            input2 = new Scanner(System.in).nextLine().trim();
        }
        if (input2.equals("7")) return;
        String[] components2 = input2.split(",");
        travelPackages.bayTour(components2[0].trim(), new Traveler(components2[1].trim(),
                components2[2].trim()));
    }

    private static void cancelTour() {
        System.out.println("Введите название тура и ФИО путешественника.\n" +
                "Например: Бали, Горохов Иван Дмитриевич");
        String input3 = new Scanner(System.in).nextLine().trim();
        while (!input3.matches("[А-я\\s]+, [А-я\\s]+") && !input3.equals("7")) {
            System.out.println("""
                    Ошибка. Введите корректно!
                    Например: Бали, Горохов Иван Дмитриевич""");
            input3 = new Scanner(System.in).nextLine().trim();
        }
        if (input3.equals("7")) return;
        String[] components3 = input3.split(",");
        travelPackages.cancelTour(components3[0].trim(), components3[1].trim());
    }

    private static void getVoucherByTour() {
        System.out.println("Введите название тура");
        String input4 = new Scanner(System.in).nextLine().trim();
        if (input4.equals("7")) return;
        travelPackages.getTour(input4);
    }

    private static void getVoucherCount() {
        System.out.println("Введите название тура");
        String input5 = new Scanner(System.in).nextLine().trim();
        if (input5.equals("7")) return;
        travelPackages.getInformation(input5);
    }

    private static void getTourCountVoucher() {
        travelPackages.getTours();
    }
}
