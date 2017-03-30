
import bolnica.Hospital;
import persons.Pacient;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Hospital pirogov = new Hospital("Pirogov");
		//pirogov.showHospitalInfo();
		
		Pacient pesho = new Pacient("Pesho", "Peshev", "0878123456", 25, 'M');
		Pacient gosho = new Pacient("Grigor", "Dimitrov", "0878123456", 26, 'M');
		Pacient sasho = new Pacient("Aleksandyr", "Tomov", "0878123456", 25, 'M');
		Pacient sashka = new Pacient("Sashka", "Pesheva", "0878123456", 25, 'F');
		Pacient pena = new Pacient("Pena", "Dimitrova", "0878123456", 25, 'F');
		
		pirogov.addPacient(pesho, "Broken leg");
		pirogov.addPacient(gosho, "Heart attack");
		pirogov.addPacient(sasho, "Broken leg");
		pirogov.addPacient(sashka, "Broken leg");
		pirogov.addPacient(pena, "Broken leg");
		pirogov.addPacient(pena, "aksjd");
		pirogov.addPacient(gosho, "Plague");
		pirogov.addPacient(pena, "Plague");
		int days=1;
		//pirogov.showHospitalInfo();
		for (int i = 0; i < 10; i++) {
			pirogov.showHospitalInfo();
			System.out.println("Day "+days++);
			pirogov.izpisvane();
			pirogov.razdavaneLekarstva();
			pirogov.vizitaciq();
			pirogov.predstoqshtoIzpisvane();
		}
		
		

	}

}
