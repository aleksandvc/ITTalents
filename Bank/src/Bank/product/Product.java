package product;

public abstract class Product {

	protected String name;
	protected int lihvaPerYear;
	protected int period;
	protected double money;
	
	public Product(String name, int lihvaPerYear, int period) {
		if(name != null && !name.isEmpty()){
		this.name = name;
		}
		else{
			this.name = "Credit";
		}
		if(lihvaPerYear > 0){
		this.lihvaPerYear = lihvaPerYear;
		}
		if(period > 0){
		this.period = period;
		}
		
	}
	public Product(double money,int period){
		this.money = money;
		this.period = period;
	}
	public void setPeriod(int period){
		this.period = period;
	}
	public void setMoney(double money){
		this.money = money;
	}
	public int getLihvaPerYear() {
		return lihvaPerYear;
	}
	public int getPeriod() {
		return period;
	}
	public double getMoney() {
		return money;
	}
	public abstract void showInfo();
}
