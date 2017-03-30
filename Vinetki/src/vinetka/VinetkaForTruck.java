package vinetka;

import vinetka.Vinetka.Color;
import vinetka.Vinetka.Period;

public class VinetkaForTruck extends Vinetka {

	public VinetkaForTruck(String startDate, Period period) {
		super(startDate, Color.BLUE, period);

	}

	@Override
	public int getOnTheWindowSec() {

		return 20;

	}

	@Override
	public int getPrice() {
		int price = 0;
		switch (period) {
		case DAY:
			price = 9;
			break;
		case MONTH:
			price = 9 * 10;
			break;
		case YEAR:
			price = 90 * 6;
			break;
		default:
			price = 0;
			break;
		}
		return price;
	}

	@Override
	public String toString() {
		return "VinetkaForTruck [color - " + color + ", price - " + this.getPrice() + "]";
	}

}
