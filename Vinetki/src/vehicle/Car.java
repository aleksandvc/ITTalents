package vehicle;

public class Car extends Vehicle {

	public Car(String model) {
		super(model);
		
	}

	@Override
	public String toString() {
		return "Car [model - " + this.model + " ]";
	}
	

}
