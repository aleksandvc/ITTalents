package vinetka;

public class VinetkaForCar extends Vinetka {

	public VinetkaForCar(String startDate, Period period) {
		super(startDate, Color.GREEN, period);

	}

	@Override
	public int getOnTheWindowSec() {
		return 5;

	}

	@Override
	public int getPrice() {
		int price = 0;
		switch (period) {
		case DAY:
			price = 5;
			break;
		case MONTH:
			price = 5 * 10;
			break;
		case YEAR:
			price = 50 * 6;
			break;
		default:
			price = 0;
			break;
		}
		return price;

	}
	@Override
	public String toString() {
		return "VinetkaForCar [color - " + color + ", price - " + this.getPrice() + "]";
	}

}
