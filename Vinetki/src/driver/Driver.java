package driver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import gasstation.GasStation;
import vehicle.Bus;
import vehicle.Car;
import vehicle.Truck;
import vehicle.Vehicle;
import vinetka.Vinetka;
import vinetka.Vinetka.Period;
import vinetka.VinetkaForBus;
import vinetka.VinetkaForCar;
import vinetka.VinetkaForTruck;

public class Driver {

	private String name;
	private ArrayList<Vehicle> vehicles;
	private double money;
	private GasStation station;
	
	public Driver(String name, double money,GasStation station){
		
		if(name != null && !name.isEmpty()){
			this.name = name;
		}
		else{
			this.name = "Ebati shofera";
		}
		if(money > 0){
			this.money = money;
		}
		else{
			this.money = 100;
		}
		if(station != null){
			this.station = station;
		}
		else{
			this.station = new GasStation();
		}
		this.vehicles = new ArrayList<>();
		
	}

	public ArrayList<Vehicle> getVehicles(){
		return this.vehicles;
	}
	public String getName() {
		return name;
	}

	public double getMoney() {
		return money;
	}
	
	
	public GasStation getStation() {
		return station;
	}
	public void addVehicle(Vehicle vehicle){
		this.vehicles.add(vehicle);
	}
	public void buyVinetka(Vinetka vinetka){
		this.money -= vinetka.getPrice();
	}
	public void buyVinetkaForVehicle(Vehicle vehicle,Vinetka vinetka){
		String date = vinetka.getStartDate();
		Period p = vinetka.getPeriod();
		if(this.money >= vinetka.getPrice()){
			
			if (vehicle instanceof Car) {
				this.buyVinetka(new VinetkaForCar(date,p));
				return;
			}
			if (vehicle instanceof Bus) {
				this.buyVinetka(new VinetkaForBus(date,p));
				return;
			}
			if (vehicle instanceof Truck) {
				this.buyVinetka(new VinetkaForTruck(date,p));
				return;
			}
			
		}
		else{
			System.out.println("The driver dont have enough money.");
			return;
		}
			
	}
		public void buyForAll(Vinetka vinetka){
		String date = vinetka.getStartDate();
		Period p = vinetka.getPeriod();
			for (Iterator<Vehicle> it = vehicles.iterator();it.hasNext();) {
				Vehicle v = it.next();
				if( v instanceof Car){
					vinetka = new VinetkaForCar(date,p);	
					this.buyVinetkaForVehicle(v, vinetka);
				}
				if( v instanceof Bus){
					vinetka = new VinetkaForBus(date,p);	
					this.buyVinetkaForVehicle(v, vinetka);
				}
				if( v instanceof Truck){
					vinetka = new VinetkaForTruck(date,p);	
					this.buyVinetkaForVehicle(v, vinetka);
				}
				
			}
		}
		public void showInfo(){
			System.out.println(this.name + " drives " + vehicles.size() + " vehicles.");
			System.out.println(this.name + " has " + this.money + " money.");
			System.out.println(vehicles);
		}
			
	
}
