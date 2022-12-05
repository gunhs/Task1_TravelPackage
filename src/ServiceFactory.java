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
        System.out.println("""
                Введите данные о туре через запятую.
                Название, стоимость, количество путевок
                Например: Бали, 150000, 5""");
        String input = new Scanner(System.in).nextLine().trim();
        if (input.equals("7")) return;
        while (!input.matches("[А-я\\s]+, \\d+, \\d+")) {
            System.out.println("""
                    Ошибка. Введите корректно!
                    Например: Бали, 150000, 5""");
            input = new Scanner(System.in).nextLine().trim();
            if (input.equals("7")) return;
        }
        String[] components = input.split(",");
        travelPackages.addTour(components[0].trim(), new Tour(components[0].trim(),
                Double.parseDouble(components[1]),
                Integer.parseInt(components[2].trim())));
    }

    private static void bayTour() {
        System.out.println("""
                Введите данные тура и путешественника.
                Название, дата начала, количество дней, ФИО, номер паспорта
                Например: Бали, 23.11.2021, 10, Горохов Иван Дмитриевич, 8977090809""");
        String input2 = new Scanner(System.in).nextLine().trim();
        if (input2.equals("7")) return;
        while (!input2.matches("[А-я\\s]+, [\\d.]+, \\d+, [А-я\\s]+, \\d{10}")) {
            System.out.println("""
                    Ошибка. Введите корректно!
                    Например: Бали, 23.11.2021, 10, Горохов Иван Дмитриевич, 8977090809""");
            input2 = new Scanner(System.in).nextLine().trim();
            if (input2.equals("7")) return;
        }
        String[] components2 = input2.split(",");
        travelPackages.bayTour(components2[0].trim(), new Voucher(components2[1].trim(),
                Integer.parseInt(components2[2].trim()),
                components2[3].trim(),
                components2[4].trim()));
    }

    private static void cancelTour() {
        System.out.println("Введите название тура и ФИО путешественника.\n" +
                "Например: Бали, Горохов Иван Дмитриевич");
        String input3 = new Scanner(System.in).nextLine().trim();
        if (input3.equals("7")) return;
        while (!input3.matches("[А-я\\s]+, [А-я\\s]+")) {
            System.out.println("""
                    Ошибка. Введите корректно!
                    Например: Бали, Горохов Иван Дмитриевич""");
            input3 = new Scanner(System.in).nextLine().trim();
            if (input3.equals("7")) return;
        }
        String[] components3 = input3.split(",");
        travelPackages.cancelTour(components3[0].trim(), components3[1].trim());
    }

    private static void getVoucherByTour() {
        System.out.println("Введите название тура");
        String input4 = new Scanner(System.in).nextLine().trim();
        travelPackages.getVoucher(input4);
    }

    private static void getVoucherCount() {
        System.out.println("Введите название тура");
        String input5 = new Scanner(System.in).nextLine().trim();
        travelPackages.getInformation(input5);
    }

    private static void getTourCountVoucher() {
        travelPackages.getTours();
    }
}
