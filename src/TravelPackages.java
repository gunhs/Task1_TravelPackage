import java.util.HashMap;
import java.util.Map;

public class TravelPackages implements SaleOfVouchers {
    HashMap<String, Tour> vouchers = new HashMap<>();

    @Override
    public void addTour(String name, Tour tour) {

        if (vouchers.containsKey(name)) {
            System.out.println("Тур с таким именем существует. Создайте другой тур");
            return;
        }
        vouchers.put(name, tour);
        System.out.println("Добавлен тур: " + name);
    }

    @Override
    public void getTour(String name) {
        if (checkTour(name)) return;
        if (vouchers.get(name).getTravelers().isEmpty()) {
            System.out.println(vouchers.get(name) + "\nНет активных путёвок по данному туру");
        } else {
            System.out.println(vouchers.get(name));
            System.out.println("Список туристов купивыших тур:");
            for (Traveler v : vouchers.get(name).getTravelers()) {
                System.out.println(v);
            }
        }
    }

    @Override
    public void bayTour(String name, Traveler traveler) {
        if (checkTour(name)) return;
        for (Traveler v : vouchers.get(name).getTravelers()) {
            if (v.getNameOfTheTraveler().equals(traveler.getNameOfTheTraveler())
                    && v.getPassportNumber().equals(traveler.getPassportNumber())) {
                System.out.println("Данный путешественник уже покупал тур");
                return;
            }
        }
        vouchers.get(name).addTraveler(traveler);
    }

    @Override
    public void cancelTour(String name, String nameOfTraveler) {
        if (checkTour(name)) return;
        if (vouchers.get(name).getTravelers().isEmpty()){
            System.out.println("В туре отсутвуют путёвки");
            return;
        }
        for (Traveler v : vouchers.get(name).getTravelers()) {
            if (v.getNameOfTheTraveler().equals(nameOfTraveler)) {
                vouchers.get(name).removeTraveler(v);
                System.out.println("Отмена покупки \"" + name + "\" прошла успешно");
            } else {
                System.out.println("Путешественник с таким именем не покупал данный тур." +
                        " Проверьте правильность вводимых данных");
            }
        }
    }

    @Override
    public void getInformation(String name) {
        if (checkTour(name)) return;
        System.out.println("Количество мест в туре " + name +
                ": " + (vouchers.get(name).getCount() - vouchers.get(name).getTravelers().size()));
    }

    public void getTours() {
        if (vouchers.isEmpty()) {
            System.out.println("Нет доступных туров");
            return;
        }
        for (Map.Entry<String, Tour> entry : vouchers.entrySet()) {
            System.out.println(entry.getValue().getName() +
                    ": количество путёвок - " + entry.getValue().getCount());
        }
    }

    private boolean checkTour(String name) {
        if (!vouchers.containsKey(name)) {
            System.out.println("Неверно указано название тура");
            return true;
        } else return false;
    }
}
