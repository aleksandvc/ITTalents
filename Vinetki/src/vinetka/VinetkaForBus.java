package vinetka;

import vinetka.Vinetka.Color;
import vinetka.Vinetka.Period;

public class VinetkaForBus extends Vinetka {

	public VinetkaForBus(String startDate, Period period) {
		super(startDate, Color.RED, period);

	}

	@Override
	public int getOnTheWindowSec() {

		return 10;

	}

	@Override
	public int getPrice() {
		int price = 0;
		switch (period) {
		case DAY:
			price = 7;
			break;
		case MONTH:
			price = 7 * 10;
			break;
		case YEAR:
			price = 70 * 6;
			break;
		default:
			price = 0;
			break;
		}
		return price;
	}

	@Override
	public String toString() {
		return "VinetkaForBus [color - " + color + ", price - " + this.getPrice() + "]";
	}
}
