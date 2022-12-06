import java.time.LocalDate;

public class Voucher {
    private final String nameOfTheTraveler;
    private final LocalDate date;
    private final int dayCount;
    private final String passportNumber;

    public Voucher(LocalDate date, int dayCount, String nameOfTheTraveler, String passportNumber) {
        this.nameOfTheTraveler = nameOfTheTraveler;
        this.date = date;
        this.dayCount = dayCount;
        this.passportNumber = passportNumber;
    }

    public String getNameOfTheTraveler() {
        return nameOfTheTraveler;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    @Override
    public String toString() {
        return "\nФИО путешественника: " + nameOfTheTraveler + "\n" +
                "Номер паспорта: " + passportNumber + "\n" +
                "Дата начала путешествия: " + date + "\n" +
                "Количество дней: " + dayCount;
    }
}
