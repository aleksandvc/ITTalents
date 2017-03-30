import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

import bank.Bank;
import client.Client;
import product.Credit;
import product.Deposit;

public class BankDemo {

	public static void main(String[] args) {
		
		Deposit shortDep = new Deposit("Short Deposit",3,3);
		Deposit longDep = new Deposit("Long Deposit",5,12);
		
		Credit home = new Credit("Home Credit" ,6,24);
		Credit consumer = new Credit("Consumer Credit" ,10,24);

		Bank ktb = new Bank("KTB",10000);
		
		Client sasho = new Client("Sasho",10000,5000);
		Client pesho = new Client("Pesho",10000,5000);
		Client gosho = new Client("Gosho",10000,5000);
		Client tosho = new Client("Tosho",10000,5000);
		Client misho = new Client("Misho",10000,5000);
		
		ktb.addClients(sasho);
		
		HashSet<Client> clients = new HashSet<>();
		clients.add(sasho);
		clients.add(pesho);
		clients.add(gosho);
		clients.add(tosho);
		clients.add(misho);
		for (Iterator<Client> it = clients.iterator();it.hasNext();) {
			Client e = it.next();
			e.makeDeposit(ktb, shortDep, new Random().nextInt((int) (e.getMoney() - (80*e.getMoney())%100)) + (80*e.getMoney())%100);
			
		}
		ktb.showInfo();
		System.out.println();
		for (Iterator<Client> it = clients.iterator();it.hasNext();) {
			Client e = it.next();
			e.wantCredit(ktb, home, new Random().nextInt((int) (e.getMoney() + 1)));
			e.showInfo();
		}
		System.out.println();
		ktb.showInfo();
	}

}
