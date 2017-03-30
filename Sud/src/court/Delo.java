package court;

import java.util.HashSet;
import java.util.Random;

import citizen.Accuser;
import citizen.Defendant;
import citizen.Witness;
import iurist.Judge;
import iurist.Lawyer;
import iurist.Zasedatel;

public class Delo {

	public enum Type{GRAJDANSKO,NAKAZATELNO};
	
	private Type type;
	private Judge judge;
	private Court court;
	private HashSet<Zasedatel> zasedateli;
	private Defendant defendant;
	private Accuser accuser;
	private HashSet<Witness> svideteli;
	
	public Delo(Type type,Court court,HashSet<Defendant> defs,HashSet<Accuser> accs,HashSet<Witness> wits ){
		this.type = type;
		this.court = court;
		this.zasedateli = new HashSet<>(3);
		this.svideteli = new HashSet<>();
		int temp = new Random().nextInt(this.court.getJudges().size());
		int v = 0;
		for (Judge judge :this.court.getJudges()) {
			if (v == temp) {
				this.setJudge(judge);
				break;
			}
			v++;
		}
		int temp1 = new Random().nextInt(defs.size());
		int p = 0;
		for (Defendant def : defs) {
			if (p == temp1) {
				this.setDefendant(def);
				break;
			}
			p++;
		}
		int temp2 = new Random().nextInt(accs.size());
		int t = 0;
		for (Accuser acc : accs) {
			if (t == temp2) {
				this.setAccuser(acc);
				break;
			}
			t++;
		}
		
			for (Zasedatel zasedatel : this.court.getZasedateli()) {
				if(this.zasedateli.size() == 3){
					break;
				}
				this.zasedateli.add(zasedatel);
			}
			for (Witness svidetel : wits) {
				if(this.svideteli.size() == 3){
					break;
				}
				this.svideteli.add(svidetel);
			}
			for (Lawyer l : this.court.getLawyers()) {
				if(this.defendant.getLawyers().size() == 2){
					break;
				}
				this.defendant.addLawyer(l);
			}
			for (Lawyer l : this.court.getLawyers()) {
				if(this.accuser.getLawyers().size() == 2){
					break;
				}
				this.accuser.addLawyer(l);
			}
			

	}
	
	public void hold(){
		this.judge.increaseCases();
		for(Lawyer l : this.defendant.getLawyers()){
			l.increaseCases();
			System.out.println("Questions from lawyer of the defendant:");
			for(Witness wit : this.svideteli){
				l.askQuestion(wit);
			}
		}
		for(Lawyer l : this.accuser.getLawyers()){
			l.increaseCases();
			System.out.println("Questions from lawyer of the accuser:");
			l.askQuestion(this.defendant);
			for(Witness wit : this.svideteli){
				l.askQuestion(wit);
			}
		}
		for(Zasedatel z : this.zasedateli){
			z.increaseCases();
			z.isGuilty(this.defendant);
		}
		if(this.defendant.isGuilty()){
			this.judge.isGuilty(this.defendant);
			System.out.println("You will lay in prison for : " + (new Random().nextInt(38) + 3) + " years." );
		}
		else{
			System.out.println("You are free to go my friend!!!");
		}
		
		
		
	}

	public void setJudge(Judge judge) {
		this.judge = judge;
	}
	public Judge getJudge(){
		return this.judge;
	}
	public Defendant getDefendant(){
		return this.defendant;
	}
	public Accuser getAccuser(){
		return this.accuser;
	}
	public void setDefendant(Defendant defendant) {
		this.defendant = defendant;
	}

	public void setAccuser(Accuser accuser) {
		this.accuser = accuser;
	}
	
	

	public HashSet<Zasedatel> getZasedateli() {
		return zasedateli;
	}

	public HashSet<Witness> getSvideteli() {
		return svideteli;
	}
}
