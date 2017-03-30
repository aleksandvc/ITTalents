package iurist;

import citizen.Citizen;

public abstract class Iurist {

	public enum Type{JUDGE,ZASEDATEL,LAWYER,PROSECUTOR};
	
	protected String name;
	protected Type type;
	protected int internship;
	protected int numOfCases;
	
	public Iurist(String name,Type type,int internship,int numOfCases){
		if(name != null && !name.isEmpty()){
			this.name = name;
		}
		else{
			this.name = "Slujitelche";
		}
		this.type = type;
		this.internship = internship;
		this.numOfCases = numOfCases;
	}

	@Override
	public String toString() {
		return "Iurist  - name: " + name + ", type: " + type + ",  -----  numOfCases: " + numOfCases
				+ ".";
	}

	@Override
	public int hashCode() {
		return this.name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Iurist other = (Iurist) obj;
		if (internship != other.internship)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (numOfCases != other.numOfCases)
			return false;
		return true;
	}

	public void increaseCases(){
		this.numOfCases++;
	}
	public int getNumOfCases(){
		return this.numOfCases;
	}

	public abstract void askQuestion(Citizen a);
	
	
}
