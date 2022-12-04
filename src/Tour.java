import java.util.HashSet;

public class Tour {
    private String name;
    private HashSet<Voucher> vouchers = new HashSet<>();
    private double price;
    private int count; // количество путёвок

    public Tour(String name, double price, int count) {
        this.count = count;
        this.name = name;
        this.price = price;
    }

    public void addTraveler(Voucher voucher) {
        if (vouchers.size()==count){
            System.out.println("Невозможно приобрести путёвку. Мест нет");
            return;
        }
        vouchers.add(voucher);
    }

    public void removeTraveler(Voucher voucher) {
        vouchers.remove(voucher);
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

    public HashSet<Voucher> getVouchers() {
        return new HashSet<>(vouchers);
    }
}
