package persons;

public class Pacient extends Persons {
	
	
	int age;
	char gender;
	
	public Pacient(String firstName, String lastName, String phoneNumber, int age, char gender) {
		super(firstName, lastName, phoneNumber);
		this.age=age;
		this.gender=gender;
	}
	
	
	public char getGender(){
		return this.gender;
	}


	@Override
	public String toString() {
		
		return super.toString()+"[age=" + age + ", gender=" + gender + "]";
	}
	
	
	

}
