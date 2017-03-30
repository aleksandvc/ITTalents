import java.util.HashSet;
import java.util.Random;

import citizen.Accuser;
import citizen.Citizen;
import citizen.Defendant;
import citizen.Witness;
import court.Court;
import court.Delo;
import court.Delo.Type;
import iurist.Judge;
import iurist.Lawyer;
import iurist.Prosecutor;
import iurist.Zasedatel;

public class SudDemo {

	public static void main(String[] args) {

		Court sud = new Court("Veliko Turnovo");

		sud.addJudge(new Judge("Petko Slavqnov", 7, 10));
		sud.addJudge(new Judge("Mihail Petrov", 6, 6));
		sud.addJudge(new Judge("Borislav Mitev", 9, 11));

		for (int i = 0; i < 10; i++) {
			sud.addZasedatel(new Zasedatel());
		}
		sud.addLawyer(new Lawyer("Ivan Ivanov", 5, 15));
		sud.addLawyer(new Lawyer("Mihail Mihailov", 6, 12));
		sud.addLawyer(new Lawyer("Todor Todorov", 7, 13));
		sud.addLawyer(new Lawyer("Alexander Topalov", 4, 16));
		sud.addLawyer(new Lawyer("Krasimir Stoev", 15, 11));

		sud.addProsecutor(new Prosecutor("Choko Kalchev", 11, 11));
		sud.addProsecutor(new Prosecutor("Milen Geranov", 16, 14));

		HashSet<Defendant> defendants = new HashSet<>();
		defendants.add(new Defendant("Marin Marinov"));
		defendants.add(new Defendant("Svetlin Tomov"));
		defendants.add(new Defendant("Tosho Toshev"));
		defendants.add(new Defendant("Miglen Iskrenov "));
		defendants.add(new Defendant("Shisho Bakshisho"));

		HashSet<Accuser> accusers = new HashSet<>();
		accusers.add(new Accuser("Tihomir Pepev"));
		accusers.add(new Accuser("Rosen Gacov"));
		accusers.add(new Accuser("Ivo Andonov"));
		accusers.add(new Accuser("Tisho Bliznaka "));
		accusers.add(new Accuser("Petar Tudjarov"));

		HashSet<Witness> witnesses = new HashSet<>();
		for (int i = 0; i < 11; i++) {
			witnesses.add(new Witness());
		}

		Delo grajdansko1 = new Delo(Type.GRAJDANSKO, sud,defendants,accusers,witnesses);
		Delo grajdansko2 = new Delo(Type.GRAJDANSKO,sud,defendants,accusers,witnesses);
		Delo grajdansko3 = new Delo(Type.GRAJDANSKO,sud,defendants,accusers,witnesses);
		sud.addDelo(grajdansko1);
		sud.addDelo(grajdansko2);
		sud.addDelo(grajdansko3);
		
		grajdansko1.hold();
		
		sud.showInfo();
			
	}

}
