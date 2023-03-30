import java.util.HashMap;
import java.util.HashSet;

public class Tour {
    private String name;
    private HashMap<String, HashSet<Voucher>> vouchers = new HashMap<>(); //в одном туре может быть несколько путёвок
     private double price;
    private int count; // количество путёвок

    public Tour(String name, double price, int count) {
        this.count = count;
        this.name = name;
        this.price = price;
    }

    public void addTraveler(String name, Voucher voucher) {
        if (vouchers.get(name).size() == count) {
            System.out.println("Невозможно приобрести путёвку. Мест нет");
            return;
        }
        vouchers.get(name).add(voucher);
    }

    public void removeTraveler(String name, Voucher voucher) {
        vouchers.get(name).remove(voucher);
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public HashMap<String, HashSet<Voucher>> getVouchers() {
        return new HashMap<>(vouchers);
    }
}
