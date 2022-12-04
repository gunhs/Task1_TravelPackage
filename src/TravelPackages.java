import java.util.HashMap;
import java.util.Map;

public class TravelPackages implements SaleOfVouchers {
    HashMap<String, Tour> vouchers = new HashMap<>();

    @Override
    public void addTour(String name, Tour tour) {
        if (vouchers.containsKey(name)){
            System.out.println("Такой тур уже существует. Введите другое название");
            return;
        }
        vouchers.put(name, tour);
        System.out.println("Добавлен тур: " + name);
    }

    @Override
    public void getVoucher(String name) {
        if (checkTour(name)) return;
        if (vouchers.get(name).getVouchers().isEmpty()) {
            System.out.println("Нет активных путёвок по данному туру");
            return;
        }
        System.out.println("Список путёвок по туру " + name + ":");
        for (Voucher v : vouchers.get(name).getVouchers()) {
            System.out.println(v);
        }
    }

    @Override
    public void bayTour(String name, Voucher voucher) {
        if (checkTour(name)) return;
        vouchers.get(name).addTraveler(voucher);
        vouchers.get(name).setCount(vouchers.get(name).getCount() - 1);
        System.out.println("Покупка \"" + name + "\" прошла успешно");
    }

    @Override
    public void cancelTour(String name, String nameOfTraveler) {
        if (checkTour(name)) return;
        for (Voucher v : vouchers.get(name).getVouchers()) {
            if (v.getNameOfTheTraveler().equals(nameOfTraveler)) {
                vouchers.get(name).removeTraveler(v);
            } else {
                System.out.println("Путешественник с таким именем не покупал данный тур." +
                        " Проверьте правильность вводимых данных");
            }
        }
        vouchers.get(name).setCount(vouchers.get(name).getCount() + 1);
        System.out.println("Отмена покупки \"" + name + "\" прошла успешно");
    }

    @Override
    public void getInformation(String name) {
        
        if (checkTour(name)) return;
        System.out.println("Количество мест в туре " + name +
                ": " + vouchers.get(name).getCount());
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
