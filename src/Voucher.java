public class Voucher {
	private final String nameOfTheTraveler;
	private final String date;
	private final int dayCount;
	private final String passportNumber;
	
	public Voucher(String date, int dayCount, String nameOfTheTraveler, String passportNumber) {
		this.nameOfTheTraveler = nameOfTheTraveler;
		this.date = date;
		this.dayCount = dayCount;
		this.passportNumber = passportNumber;
	}
	
	public String getNameOfTheTraveler() {
		return nameOfTheTraveler;
	}
	
	@Override
	public String toString() {
		return "Имя путешественника: " + nameOfTheTraveler +
					   ", номер паспорта: " + passportNumber +
					   ", дата начала путешествия: " + date +
					   ", количество дней: " + dayCount;
	}
}
