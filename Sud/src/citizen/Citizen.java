package citizen;

import java.util.Random;

public class Citizen {

	public enum Type{DEFENDANT,ACCUSER,WITNESS};
	
	protected Type type;
	protected String names;
	protected String adress;
	protected int age;
	
	public Citizen(String names, Type type){
		if( names != null && !names.isEmpty()){
			this.names = names;
		}
		else{
			this.names = " nqkvi imenca";
		}
		this.age = new Random().nextInt(25) + 18;
		this.type = type;
	}

	@Override
	public int hashCode() {
		return this.names.hashCode();
	}
	

	public String getNames() {
		return names;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Citizen other = (Citizen) obj;
		if (age != other.age)
			return false;
		if (names == null) {
			if (other.names != null)
				return false;
		} else if (!names.equals(other.names))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Citizen [type=" + type + ", names=" + names + ", age=" + age + "]";
	}
}
