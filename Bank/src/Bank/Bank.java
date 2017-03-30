package bank;

import java.util.ArrayList;
import java.util.HashSet;

import client.Client;
import product.Credit;
import product.Deposit;

public class Bank {

	private String name;
	private String adress;
	private double reserv;
	private ArrayList<Credit> credits;
	private ArrayList<Deposit> deposits;
	private HashSet<Client> clients;

	public Bank(String name, double reserv) {
		if (name != null && !name.isEmpty()) {
			this.name = name;
		} else {
			this.name = "OBB";
		}
		this.reserv = reserv;
		this.credits = new ArrayList<>();
		this.deposits = new ArrayList<>();
		this.clients = new HashSet<>();
	}

	public double getReserv() {
		return reserv;
	}

	public void addClients(Client client) {
		if (client != null) {
			this.clients.add(client);
		}
	}

	public void addCredit(Credit credit) {
		if (credit != null) {
			this.credits.add(credit);
		}
	}

	public void addDeposit(Deposit deposit) {
		if (deposit != null) {
			this.deposits.add(deposit);
		}
	}
	public boolean acceptDeposit(Client client, Deposit deposit,double money){
		if(client.getMoney() > 0){
			client.setMoneyOnProduct(deposit, money);
			this.reserv += deposit.getMoney();
			deposits.add(deposit);
			clients.add(client);
			return true;
		}
		return false;
	}
	public boolean giveCredit(Client client, Credit credit,double money) {
			client.setMoneyOnProduct(credit, money);
		if (client.calcPayments() <= client.getSalary() / 2 && credit.getMoney() < this.reserv) {
			this.reserv -= credit.getMoney();
			credits.add(credit);
			clients.add(client);
			return true;
		}
		return false;
	}
	public void payLihvi(){
		for (int i = 0; i < this.deposits.size(); i++) {
			this.deposits.get(i).addLihva();
		}
	}
	public void showInfo(){
		System.out.println(this.name + " has " + this.reserv + " levs left." );
	}

}
