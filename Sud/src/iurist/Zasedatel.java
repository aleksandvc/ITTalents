package iurist;

import java.util.Random;

import citizen.Citizen;
import citizen.Defendant;

public class Zasedatel extends Iurist {

	static String[] names = { "Misho Mishov", "Tisho Tishov", "Sasho Sashov", "Chenko Chenkov", "Petko Petkov" };

	public Zasedatel() {
		super(names[new Random().nextInt(names.length)], Type.ZASEDATEL, new Random().nextInt(5) + 1,
				new Random().nextInt(5) + 1);

	}

	@Override
	public void askQuestion(Citizen a) {
		System.out.println("I Dont have questions.");
		
	}
	public void isGuilty(Defendant a){
		a.setGuilty(new Random().nextBoolean());
	}

}
