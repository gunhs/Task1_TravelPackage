import java.util.HashMap;
import java.util.Map;

public class TravelPackages implements SaleOfVouchers {
    HashMap<String, Tour> vouchers = new HashMap<>();
    String TOUR_NOT_FOUND = "Неверно указано название тура";

    @Override
    public String addTour(String name, Tour tour) {
        if (vouchers.containsKey(name)) {
            return "Такой тур уже существует. Введите другое название";
        }
        vouchers.put(name, tour);
        return "Добавлен тур: " + name;
    }

    @Override
    public String getVoucher(String name) {
        if (checkTour(name)) return TOUR_NOT_FOUND;
        if (vouchers.get(name).getVouchers().isEmpty()) {
            return "Нет активных путёвок по данному туру";
        }
        StringBuilder listOfVouchers = new StringBuilder("Список путёвок по туру " + name + ":");
        for (Voucher v : vouchers.get(name).getVouchers().get(name)){
            listOfVouchers.append(v).append("\n");
        }
        return listOfVouchers.toString().strip();
    }

    @Override
    public String bayTour(String name, Voucher voucher) {
        if (checkTour(name)) return TOUR_NOT_FOUND;
        vouchers.get(name).addTraveler(name, voucher);
        vouchers.get(name).setCount(vouchers.get(name).getCount() - 1);
        return "Покупка \"" + name + "\" прошла успешно";
    }

    @Override
    public String cancelTour(String name, String nameOfTraveler) {
        if (checkTour(name)) return TOUR_NOT_FOUND;

        for (Voucher v : vouchers.get(name).getVouchers().get(name)) {
            if (v.getNameOfTheTraveler().equals(nameOfTraveler)) {
                vouchers.get(name).removeTraveler(name, v);
                vouchers.get(name).setCount(vouchers.get(name).getCount() + 1);
                return "Отмена покупки \"" + name + "\" прошла успешно";
            }
        }
        return "Путешественник с таким именем не покупал данный тур." +
                " Проверьте правильность вводимых данных";
    }

    @Override
    public String getInformation(String name) {
        if (checkTour(name)) return TOUR_NOT_FOUND;
        return "Количество мест в туре " + name +
                ": " + vouchers.get(name).getCount();
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
        return !vouchers.containsKey(name);
    }
}
