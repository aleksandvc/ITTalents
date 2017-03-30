package bolnica;

import java.util.ArrayList;

import persons.Pacient;


public class Carton {
	
	Pacient pacient;
	String diagnoza;
	int daysTreatment;
	ArrayList<String> lekarstva;
	int staq;
	int leglo;
	
	
	public Carton(Pacient p, String diagn, int dni, ArrayList<String> lekarstva, int room, int bed ){
		this.pacient=p;
		this.diagnoza=diagn;
		this.daysTreatment = dni;
		this.lekarstva=lekarstva;
		this.staq=room;
		this.leglo=bed;
	}
	public void nulirane(){
		this.pacient=null;
		this.lekarstva=null;
		
	}

	public int getDaysTreatment() {
		return daysTreatment;
	}


	public void reduceDaysTreatment() {
		this.daysTreatment--;
	}


	public Pacient getPacient() {
		return pacient;
	}


	public ArrayList<String> getLekarstva() {
		return lekarstva;
	}


	public int getStaq() {
		return staq;
	}


	public int getLeglo() {
		return leglo;
	}


	public String getdiagnoza() {
		return this.diagnoza;
	}


	@Override
	public String toString() {
		return pacient + ", diagnoza=" + diagnoza + ", dni za lechenie" + daysTreatment
				+ ", lekarstva=" + lekarstva + ", staq=" + staq + ", leglo=" + leglo + "]";
	}
	
	
	
	

}
