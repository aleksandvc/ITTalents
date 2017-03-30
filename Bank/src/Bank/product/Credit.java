package product;

public class Credit extends Product{

	private double paymentInMonth;
	
	public Credit(String name, int lihvaPerYear, int period) {
		super(name, lihvaPerYear, period);
		
	}

	public double getPaymentInMonth() {
		return paymentInMonth;
	}
	public void payPayments(){
		super.money -= this.paymentInMonth;
	}
	public boolean payAllPayments(){
		if(this.money <= 0){
		return true;
		}
		return false;
	}

	@Override
	public void showInfo() {
		System.out.println(this.name + " has " + this.money + " levs to close the credit.");
		
	}
	
	
}
