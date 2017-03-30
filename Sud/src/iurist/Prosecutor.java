package iurist;

import citizen.Citizen;
import citizen.Defendant;
import citizen.Witness;

public class Prosecutor extends Iurist {

	public Prosecutor(String name, int internship, int numOfCases) {
		super(name, Type.PROSECUTOR, internship >= 10 ? internship : 10, numOfCases);
		
	}

	@Override
	public void askQuestion(Citizen a) {
		if(a instanceof Defendant){
			System.out.println("To: " + a.getNames() + " What happened?");
			System.out.println("To: " + a.getNames() + " Why you were there?");
			System.out.println("To: " + a.getNames() + " What did you saw?");
		}
		if(a instanceof Witness){
			System.out.println("To witness " + a.getNames() + ": What did you saw?");
			System.out.println("To witness " + a.getNames() + ": How many people were there?");
		}
		
	}

}
