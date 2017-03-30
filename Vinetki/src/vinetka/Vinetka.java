package vinetka;

import vinetka.Vinetka.Color;
import vinetka.Vinetka.Period;

public abstract class Vinetka implements Comparable<Vinetka> {
	public enum Period {
		DAY, MONTH, YEAR
	};

	public enum Color {
		GREEN, RED, BLUE
	};

	protected String startDate;
	protected Color color;
	protected Period period;

	public Vinetka(String startDate, Color color, Period period) {
		if (startDate != null && !startDate.isEmpty()) {
			this.startDate = startDate;
		} else {
			this.startDate = "01.01.2017";
		}

		this.color = color;
		this.period = period;
	}

	public abstract int getOnTheWindowSec();

	public abstract int getPrice();

	public String getStartDate() {
		return this.startDate;
	}

	public Color getColor() {
		return this.color;
	}

	public Period getPeriod() {
		return this.period;
	}
	
	@Override
	public int compareTo(Vinetka o) {
		return this.getPrice() - o.getPrice();
	}

	
}
