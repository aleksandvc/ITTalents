package citizen;

import java.util.HashSet;

import iurist.Lawyer;

public class Defendant extends Citizen {

	private HashSet<Lawyer> lawyers;
	private boolean isGuilty;
	
	public Defendant(String names) {
		super(names,Type.DEFENDANT);
		this.lawyers = new HashSet<>();
		this.isGuilty = false;
	}

	public boolean isGuilty() {
		return isGuilty;
	}

	public void setGuilty(boolean isGuilty) {
		this.isGuilty = isGuilty;
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
