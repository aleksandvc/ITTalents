package bolnica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.TreeMap;

import persons.Doctor;
import persons.Nurse;
import persons.Pacient;

public class Otdelenie {
	private String name;
	private ArrayList<Doctor> doctori;
	private Nurse sestra;
	private TreeMap<Integer, HashMap<Integer, Pacient>> stai;
	
	public Otdelenie(String name) {
		this.name = name;
		this.doctori = new ArrayList<>();
		this.stai = new TreeMap<>();
		for (int i = 1; i < 11; i++) {
			this.stai.put(i, new HashMap<>());
			for (int j = 1; j < 4; j++) {
				this.stai.get(i).put(j, null);
			}
		}
		doctori.add(new Doctor("Ivan", "Ivanov", "0888123456", this.name));
		doctori.add(new Doctor("Ivan", "Petrov", "0888123456", this.name));
		sestra = new Nurse("Genka", "Shekerova", "0888123456", 15);
	}

	public void addPacient(Pacient b, String diagnoza) {
		System.out.println("Otdelenie "+this.name);
		for (int i = 1; i < 11; i++) {
			if(this.isRoomAvailable(i, b)){
				for (int j = 1; j < 4; j++) {
					if(this.stai.get(i).get(j)==null){
						this.stai.get(i).put(j, b);
						for (Doctor doctor : doctori) {
							if(doctor.checkIfAvailable()){
								doctor.addPacient(b, diagnoza,i,j);
								System.out.println("Ïàöèåíò " +b.getFirstName() +" " + b.getLastName()+" îò ïîë " +b.getGender()+ " e ïðèåò ñ äèàãíîçà "+diagnoza+". Ëåêóâàù ëåêàð: ä-ð" + doctor.getFirstName() +" " + doctor.getLastName()+".");
								break;
							}
						}
						break;
					}
				}
				break;
			}
		}
	}
	
	public boolean isRoomFree(Integer num){
		for (Entry<Integer, Pacient> bed : stai.get(num).entrySet()) {
			if(bed.getValue()!=null){
				return false;
			}
		}
		return true;
	}
	public boolean isRoomFull(Integer num){
		for (Entry<Integer, Pacient> bed : stai.get(num).entrySet()) {
			if(bed.getValue()==null){
				return false;
			}
		}
		return true;
	}
	public boolean isRoomAvailable(Integer num, Pacient b){
		if(this.isRoomFree(num))
			return true;
		if(this.isRoomFull(num))
			return false;
		boolean isAvailable = false;
		for (Entry<Integer, Pacient> bed : stai.get(num).entrySet()) {
			if(bed.getValue()!=null && bed.getValue().getGender()!=b.getGender()){
				isAvailable=false;
				break;
			}
			if(bed.getValue()!=null && bed.getValue().getGender()==b.getGender()){
				isAvailable=true;
			}
		}
		return isAvailable;
	}

	public void showInfo() {
		System.out.println("Otdelenie: "+this.name);
		for (Doctor doctor : doctori) {
			for (Carton carton : doctor.getPacienti()) {
				System.out.println(carton);
			}
		}
		
	}
	public void setBedFree(Integer room, Integer bed){
		this.stai.get(room).replace(bed, null);
	}
	public void izpisvane() {
		System.out.println("izpisvane na pacienti ot Otdelenie "+ this.name);
		for (Doctor doctor : doctori) {
			for (int i=0; i< doctor.getPacienti().size();i++) {
				Carton carton = doctor.getPacienti().get(i);
				if(carton!=null){
					if(carton.getDaysTreatment()<=0){
						System.out.println("Ïàöèåíò " +carton.getPacient().getFirstName() +" " +carton.getPacient().getLastName()+" îò ïîë " +carton.getPacient().getGender()+ " ñ äèàãíîçà "+carton.getdiagnoza()+" áåøå èçïèñàí.");
						this.setBedFree(carton.getStaq(), carton.getLeglo());
						doctor.getPacienti().remove(i);
					}
				}
				
			}
		}
		
	}

	public void razdavaneLekarstva() {
		System.out.println("Razdavane na lekarstva na pacienti v Otdelenie "+ this.name);
		for (Doctor doctor : doctori) {
			for (Carton carton : doctor.getPacienti()) {
				if(carton!=null){
					System.out.println("Ñåñòðà "+sestra.getFirstName() +" "+sestra.getLastName()+"äàäå íà ïàöèåíò " +carton.getPacient().getFirstName() +" " +carton.getPacient().getLastName()+" â ñòàÿ " +carton.staq+ " îò îòäåëåíèå "+this.name+" ëåêàðñòâî.");
				}
			}
		}
		
	}

	public void vizitaciq() {
		System.out.println("Vizitaciq na pacienti v Otdelenie "+ this.name);
		for (Doctor doctor : doctori) {
			for (Carton carton : doctor.getPacienti()) {
				if(carton!=null){
					System.out.println("Ëåêàð "+doctor.getFirstName() +" "+doctor.getLastName()+" ïîñåòè ïàöèåíò " +carton.getPacient().getFirstName() +" " +carton.getPacient().getLastName()+" â ñòàÿ " +carton.staq+ " îò îòäåëåíèå "+this.name+".");
					carton.reduceDaysTreatment();
				}
			}
		}
	}
		
	public void getFreeBeds() {
		// TODO Auto-generated method stub
		
	}

	public void getCountOfPacients() {
		// TODO Auto-generated method stub
		
	}

	public void predstoqshtoIzpisvane() {
		System.out.println("Predstoqshto izpisvane na pacienti ot Otdelenie "+ this.name);
		for (Doctor doctor : doctori) {
			for (Carton carton : doctor.getPacienti()) {
				if(carton!=null){
					if(carton.getDaysTreatment()==1){
						System.out.println("Ïàöèåíò " +carton.getPacient().getFirstName() +" " +carton.getPacient().getLastName()+" îò ïîë " +carton.getPacient().getGender()+ " ñ äèàãíîçà "+carton.getdiagnoza()+" ùå áúäå èçïèñàí ñëåä 1 äåí.");
						this.setBedFree(carton.getStaq(), carton.getLeglo());
					}
				}
			}
		}
		
	}
	
	

}