package client;

import java.util.ArrayList;

import bank.Bank;
import product.Credit;
import product.Deposit;
import product.Product;

public class Client {

	private String name;
	private String adress;
	private double money;
	private int salary;

	private ArrayList<Deposit> deps;
	private ArrayList<Credit> creds;

	public Client(String name, double money, int salary) {
		if (name != null && !name.isEmpty()) {
			this.name = name;
		} else {
			this.name = "no name";
		}
		if (money > 0) {
			this.money = money;
		}
		if (salary > 0) {
			this.salary = salary;
		}
		this.deps = new ArrayList<>();
		this.creds = new ArrayList<>();
	}

	public double getMoney() {
		return money;
	}

	public int getSalary() {
		return salary;
	}

	public void makeDeposit(Bank bank, Deposit deposit, double money) {
		if (this.deps == null) {
			this.deps.add(deposit);
		}
		if (bank.acceptDeposit(this, deposit, money)) {

			this.money -= deposit.getMoney();
			this.deps.add(deposit);
		} else {
			System.out.println(this.name + " doesnt have enough money to make deposit!");
		}
	}

	public int calcPayments() {
		int payments = 0;
		for (int i = 0; i < creds.size(); i++) {
			payments += this.creds.get(i).getPaymentInMonth();
		}
		return payments;
	}

	public void wantCredit(Bank bank, Credit credit,double money) {
		if (this.creds == null) {
			this.creds.add(credit);
		}
		if (bank.giveCredit(this, credit,money)) {
			this.money += credit.getMoney();
			this.creds.add(credit);
		} else {
			System.out.println("The bank cant give a credit to " + this.name);
		}

	}

	public void insertMoneyOnCredit(Credit credit) {
		if (this.creds.contains(credit)) {
			this.money -= credit.getPaymentInMonth();
			credit.payPayments();
			if (credit.payAllPayments()) {
				this.creds.remove(credit);
			}
		} else {
			System.out.println("You dont have this credit anymore");
		}
	}

	@Override
	public int hashCode() {
		return this.name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public String getName() {
		return name;
	}

	public void setPeriodOnCredit(Credit credit, int period) {
		credit.setPeriod(period);
	}

	public void setMoneyOnProduct(Product product, double money) {
		if (this.money > money) {
			product.setMoney(money);
		}
	}
	public void showInfo(){
		System.out.println(this.name + " has " + this.money + " lv.");
	}
}
