package vehicle;

public class Bus extends Vehicle {

	public Bus(String model) {
		super(model);
		
	}

	@Override
	public String toString() {
		return "Bus [model - " + this.model + " ]";
	}

	
}
