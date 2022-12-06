import java.time.LocalDate;
import java.util.HashSet;

public class Tour {
    private final String name;
    private final LocalDate beginTour;
    private final int dayCount;
    private final double price;
    private final int count; // количество путёвок
    private final HashSet<Traveler> travelers = new HashSet<>();

    public Tour(String name, LocalDate beginTour, int dayCount, double price, int count) {
        this.name = name;
        this.beginTour = beginTour;
        this.dayCount = dayCount;
        this.price = price;
        this.count = count;
    }

    public void addTraveler(Traveler traveler) {
        if (travelers.size() == count) {
            System.out.println("Невозможно приобрести путёвку. Мест нет");
            return;
        } else {
            System.out.println("Покупка \"" + name + "\" прошла успешно");
        }
        travelers.add(traveler);
    }

    public void removeTraveler(Traveler traveler) {
        travelers.remove(traveler);
    }

    public int getCount() {
        return count;
    }

    public String getName() {
        return name;
    }

    public HashSet<Traveler> getTravelers() {
        return new HashSet<>(travelers);
    }

    @Override
    public String toString() {
        return "Название тура: " + name +", дата начала тура: "+ beginTour +
                ", количество дней в туре: " + dayCount +
                ", цена тура: " + price + ", количество путёвок: " +count;
    }
}
