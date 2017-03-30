package persons;

import java.util.ArrayList;
import java.util.Random;

import bolnica.Carton;

public class Doctor extends Persons{
	
	private String specialization;
	private ArrayList<Carton> pacienti;
	private int countOfPacients;
	private final static int MAX_NUMBER_OF_PACIENTS = 10;
	private boolean isAvailable;

	public Doctor(String firstName, String lastName, String phoneNumber, String spec) {
		super(firstName, lastName, phoneNumber);
		this.specialization=spec;
		this.pacienti= new ArrayList<>();
		this.countOfPacients=0;
		this.isAvailable=true;
	}
	
	public void addPacient(Pacient b, String diagnoza, int staq, int leglo){
		if(this.checkIfAvailable()){
			String[] lekarstva = {"Analgin", "Aspirin","Paracetamol","Morphin","Lopedium","Uspokoitelni","AntiDepresanti","Antibiotik","BetaBlokeri","Viagra" };
			Random r = new Random();
			ArrayList<String> prescription = new ArrayList<>();
			for(int i=0; i<3; i++){
				prescription.add(lekarstva[r.nextInt(lekarstva.length)]);
			}
			this.pacienti.add(new Carton(b, diagnoza, (r.nextInt(3)+3), prescription, staq, leglo));
			this.countOfPacients++;
		}
		else{
			System.out.println("Doctor "+this.firstName+" "+this.lastName+" is not available.");
		}
	}
	
	public  boolean checkIfAvailable(){
		if(this.countOfPacients>=MAX_NUMBER_OF_PACIENTS){
			this.isAvailable=false;
		}
		else{
			this.isAvailable=true;
		}
		return isAvailable;
	}

	public ArrayList<Carton> getPacienti() {
		return pacienti;
	}

	
	

}

