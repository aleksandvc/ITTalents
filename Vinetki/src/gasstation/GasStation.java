package gasstation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import vehicle.Bus;
import vehicle.Car;
import vehicle.Truck;
import vehicle.Vehicle;
import vinetka.Vinetka;
import vinetka.Vinetka.Period;
import vinetka.VinetkaForBus;
import vinetka.VinetkaForCar;
import vinetka.VinetkaForTruck;

public class GasStation {

	private double moneyPerDay;
	private ArrayList<Vinetka> vinetki;

	public GasStation() {
		this.moneyPerDay = 5000;
		this.vinetki = new ArrayList<>();

		for (int i = 0; i < 50; i++) {
			int r = new Random().nextInt(9) + 1;
			if (r == 1) {
				this.vinetki.add(new VinetkaForCar("01.01.2017", Period.DAY));

			}
			if (r == 2) {
				this.vinetki.add(new VinetkaForCar("01.01.2017", Period.MONTH));

			}
			if (r == 3) {
				this.vinetki.add(new VinetkaForCar("01.01.2017", Period.YEAR));

			}
			if (r == 4) {
				this.vinetki.add(new VinetkaForBus("01.01.2017", Period.DAY));

			}
			if (r == 5) {
				this.vinetki.add(new VinetkaForBus("01.01.2017", Period.MONTH));

			}
			if (r == 6) {
				this.vinetki.add(new VinetkaForBus("01.01.2017", Period.YEAR));

			}
			if (r == 7) {
				this.vinetki.add(new VinetkaForTruck("01.01.2017", Period.DAY));

			}
			if (r == 8) {
				this.vinetki.add(new VinetkaForTruck("01.01.2017", Period.MONTH));

			}
			if (r == 9) {
				this.vinetki.add(new VinetkaForTruck("01.01.2017", Period.YEAR));

			}
		}
		Collections.sort(this.vinetki);
		System.out.println(this.vinetki);
	}

	public double getMoney() {
		return moneyPerDay;
	}
	public void sellVinetka(Vinetka vinetka){
		this.vinetki.remove(vinetka);
		this.moneyPerDay += vinetka.getPrice();
		Collections.sort(vinetki);
	}
	public void sellVinetkaForVehicle(Vehicle vehicle, Vinetka vinetka) {
		String date = vinetka.getStartDate();
		Period p = vinetka.getPeriod();
		if (vehicle instanceof Car) {
			this.sellVinetka(new VinetkaForCar(date,p));
			return;
		}
		if (vehicle instanceof Bus) {
			this.sellVinetka(new VinetkaForBus(date,p));
			return;
		}
		if (vehicle instanceof Truck) {
			this.sellVinetka(new VinetkaForTruck(date,p));
			return;
		}
	}
	public void showInfo(){
		System.out.println(vinetki);
		System.out.println(vinetki.size());
	}
}
