package court;

import java.util.HashSet;

import iurist.Iurist;
import iurist.Judge;
import iurist.Lawyer;
import iurist.Prosecutor;
import iurist.Zasedatel;

public class Court {

	private String name;
	private String adress;
	private HashSet<Judge> judges;
	private HashSet<Lawyer> lawyers;
	private HashSet<Prosecutor> prosecutors;
	private HashSet<Zasedatel> zasedateli;
	private HashSet<Delo> dela;
	
	public Court(String name){
		if(name != null && !name.isEmpty()){
			this.name = name;
		}
		else{
			this.name = "Nqkvo sudche";
		}
		this.judges = new HashSet<>();
		this.lawyers = new HashSet<>();
		this.prosecutors = new HashSet<>();
		this.zasedateli = new HashSet<>();
		
		this.dela = new HashSet<>();
	}
	
	public void addDelo(Delo a){
		if(a != null){
			this.dela.add(a);
		}
	}
	public void addJudge(Judge a){
		if(a != null){
			this.judges.add(a);
		}
	}
	public void addLawyer(Lawyer a){
		if(a != null){
			this.lawyers.add(a);
		}
	}
	public void addZasedatel(Zasedatel a){
		if(a != null){
			this.zasedateli.add(a);
		}
	}
	public void addProsecutor(Prosecutor a){
		if(a != null){
			this.prosecutors.add(a);
		}
	}
	public void showInfo(){
		System.out.println(this.judges);
		System.out.println(this.lawyers);
		System.out.println(this.prosecutors);
		System.out.println(this.zasedateli);
		
	}

	public HashSet<Prosecutor> getProsecutors() {
		return prosecutors;
	}

	public void setProsecutors(HashSet<Prosecutor> prosecutors) {
		this.prosecutors = prosecutors;
	}

	public HashSet<Judge> getJudges() {
		return judges;
	}

	public HashSet<Lawyer> getLawyers() {
		return lawyers;
	}

	public HashSet<Zasedatel> getZasedateli() {
		return zasedateli;
	}
}
