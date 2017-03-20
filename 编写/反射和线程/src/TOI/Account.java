package TOI;

public class Account {
	private int balance=500;
	public int getBalance(){
		return balance;
	}
	public void withdraw(int amount){
		balance=balance-amount;
	}
	
	
}
