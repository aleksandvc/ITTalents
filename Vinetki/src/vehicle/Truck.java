package vehicle;

public class Truck extends Vehicle{

	public Truck(String model) {
		super(model);
		
	}

	@Override
	public String toString() {
		return "Truck [model - " + this.model + " ]";
	}
}
