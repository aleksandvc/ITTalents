import java.util.ArrayList;
import java.util.Random;

import driver.Driver;
import gasstation.GasStation;
import vehicle.Bus;
import vehicle.Car;
import vehicle.Truck;
import vehicle.Vehicle;
import vinetka.Vinetka.Period;
import vinetka.VinetkaForCar;

public class VinetkiDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		GasStation station = new GasStation();

		Driver gosho = new Driver("Gosho", 1000, station);
		Driver pesho = new Driver("Pesho", 1000, station);
		Driver misho = new Driver("Misho", 1000, station);

		ArrayList<Vehicle> cars = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			int r = new Random().nextInt(3) + 1;
			if (r == 1) {
				cars.add(new Car("Mercedes"));
			}
			if (r == 2) {
				cars.add(new Bus("Mercedes"));
			}
			if (r == 3) {
				cars.add(new Truck("Mercedes"));
			}
		}

	
		for (int i = 0; i < 3; i++) {
			if(i < cars.size() - 1){
			gosho.addVehicle(cars.get(0));
			pesho.addVehicle(cars.get(1));
			misho.addVehicle(cars.get(2));
			cars.remove(0);
			cars.remove(1);
			cars.remove(2);
			}
			else{
				gosho.addVehicle(cars.get(0));
				pesho.addVehicle(cars.get(1));
				misho.addVehicle(cars.get(2));
			}
		}
		
		ArrayList<Driver> drivers = new ArrayList<>();
		drivers.add(gosho);
		drivers.add(pesho);
		drivers.add(misho);
		
		//gosho.buyVinetkaForVehicle(gosho.getVehicles().get(0), new VinetkaForCar("asd",Period.DAY));
		
		
		
		for (int i = 0; i < drivers.size(); i++) {
			drivers.get(i).showInfo();
			drivers.get(i).buyVinetkaForVehicle(drivers.get(i).getVehicles().get(0), new VinetkaForCar("01.01.2017",Period.DAY));
			drivers.get(i).buyVinetkaForVehicle(drivers.get(i).getVehicles().get(1), new VinetkaForCar("01.01.2017",Period.DAY));
			drivers.get(i).showInfo();
			drivers.remove(i);
			break;
		
		}
		for (int i = 0; i < drivers.size(); i++) {
			drivers.get(i).buyForAll(new VinetkaForCar("01.01.2017",Period.MONTH));
			drivers.get(i).showInfo();
		}
	//	station.showInfo();

	}

}
