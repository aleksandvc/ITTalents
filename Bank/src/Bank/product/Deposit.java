package product;

public class Deposit extends Product {

	
	private double payedSum;
	
	public Deposit(String name, int lihvaPerYear, int period) {
		super(name, lihvaPerYear, period);
		
	}
	public Deposit(double money,int period){
		super(money,period);
	}
	public double calcLihva(){
		
		this.payedSum = (this.lihvaPerYear*this.money)%100;
		return payedSum;
	}
	public void addLihva(){
		this.money += this.calcLihva();
	}
	@Override
	public void showInfo() {
		System.out.println(this.name + " has " + this.money + " levs like deposit.");
	}
	
}
