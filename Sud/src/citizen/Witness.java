package citizen;

import java.util.Random;

public class Witness extends Citizen{

	static String [] names = {"Rosen Kolarov","Vasil Kolarov","Maksim Haralampiev","Irena Borisova","Teodora Toteva","Venelin Isaev"};
	
	public Witness() {
		super(names[new Random().nextInt(names.length)],Type.WITNESS);
		
	}

}
