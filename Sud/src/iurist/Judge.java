package iurist;

import citizen.Citizen;
import citizen.Defendant;

public class Judge extends Iurist {

	public Judge(String name, int internship, int numOfCases) {
		super(name, Type.JUDGE, internship >=5 ? internship : 5, numOfCases);
		
	}

	@Override
	public void askQuestion(Citizen a) {
		System.out.println(a.getNames() + " do you think you are guilty?");
		
	}
	public void isGuilty(Defendant a){
		a.setGuilty(true);
	}
	public void isNotGuilty(Defendant a){
		a.setGuilty(false);
	}

}
