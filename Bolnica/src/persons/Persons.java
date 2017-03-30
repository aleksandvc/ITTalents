package persons;

public abstract class Persons {
	
	String firstName;
	String lastName;
	String phoneNumber;
	public Persons(String firstName, String lastName, String phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	@Override
	public String toString() {
		return firstName + " " + lastName;
	}
	
	
	
	
	

}
