package vehicle;

import driver.Driver;
import vinetka.Vinetka;

public class Vehicle {

	protected String model;
	protected Vinetka vinetka;
	protected Driver driver;
	protected int year;
	
	public Vehicle(String model){
		if(model != null && !model.isEmpty()){
			this.model = model;
		}
		else{
			this.model = "NO model";
		}
		
	}

	public Vinetka getVinetka() {
		return vinetka;
	}

	public void setVinetka(Vinetka vinetka) {
		this.vinetka = vinetka;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	

	

	
}
