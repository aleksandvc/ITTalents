package bolnica;


import java.util.ArrayList;
import java.util.Random;

import persons.Pacient;

public class Hospital {
	
	String name;
	ArrayList<Otdelenie> otdeleniq;
	
	
	public Hospital(String name) {
		this.name=name;
		otdeleniq=new ArrayList<>();
		otdeleniq.add(new Otdelenie("Ortopediq"));
		otdeleniq.add(new Otdelenie("Kardiologiq"));
		otdeleniq.add(new Otdelenie("Virusologiq"));
	}
	public void addPacient(Pacient b, String diagnoza){
		if(b!=null){
			if(diagnoza!=null && !diagnoza.isEmpty()){
				if(diagnoza.equals("Broken leg") || diagnoza.equals("Broken arm") || diagnoza.equals("Twisted ankle") ){
					this.otdeleniq.get(0).addPacient(b,diagnoza);
					return;
				}
				if(diagnoza.equals("Infarkt") || diagnoza.equals("Heart attack") || diagnoza.equals("High blood presure") ){
					this.otdeleniq.get(1).addPacient(b,diagnoza);
					return;
				}
				if(diagnoza.equals("Ebola") || diagnoza.equals("Antrax") || diagnoza.equals("Varicela") || diagnoza.equals("Plague") ){
					this.otdeleniq.get(2).addPacient(b,diagnoza);
					return;
				}
				else{
					Random r = new Random();
					int temp = r.nextInt(3);
					this.otdeleniq.get(temp).addPacient(b,"She mre");
				}
			}
			else{
				Random r = new Random();
				int temp = r.nextInt(3);
				this.otdeleniq.get(temp).addPacient(b,"She mre");
			}
		}
		else{
			System.out.println("Mai nqkoi se opitva pak da iztochva zdravnata kasa....A ???");
		}
	}
	public void izpisvane(){
		for (Otdelenie otdelenie : otdeleniq) {
			otdelenie.izpisvane();
		}
	}
	public void razdavaneLekarstva(){
		for (Otdelenie otdelenie : otdeleniq) {
			otdelenie.razdavaneLekarstva();
		}
	}
	public void vizitaciq(){
		for (Otdelenie otdelenie : otdeleniq) {
			otdelenie.vizitaciq();
		}
	}
	public void getFreeBeds(){
		for (Otdelenie otdelenie : otdeleniq) {
			otdelenie.getFreeBeds();
		}
	}
	public void getCountOfPacients(){
		for (Otdelenie otdelenie : otdeleniq) {
			otdelenie.getCountOfPacients();
		}
	}
	public void predstoqshtoIzpisvane(){
		for (Otdelenie otdelenie : otdeleniq) {
			otdelenie.predstoqshtoIzpisvane();
		}
	}
	public void showHospitalInfo(){
		System.out.println("Informaciq za bolnicata");
		for (Otdelenie otdelenie : otdeleniq) {
			otdelenie.showInfo();
		}		
	}
}