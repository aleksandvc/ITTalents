package citizen;

import java.util.HashSet;

import iurist.Lawyer;

public class Accuser extends Citizen{

	private HashSet<Lawyer> lawyers;
	
	public Accuser(String names) {
		super(names,Type.ACCUSER);
		this.lawyers = new HashSet<>();
	}

	public void addLawyer(Lawyer a){
		if(a != null){
			this.lawyers.add(a);
		}
	}
	public HashSet<Lawyer> getLawyers() {
		return lawyers;
	}
}
