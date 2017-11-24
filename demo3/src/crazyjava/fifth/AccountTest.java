package crazyjava.fifth;

public class AccountTest extends Thread{

	private AccountSyn account;
	private double drawAmount;
	
	public AccountTest(String name,AccountSyn account,double drawAmount){
		super(name);
		this.account = account;
		this.drawAmount = drawAmount;
	}
	
	public void run(){
		account.draw(drawAmount);
	}
	
	public static void main(String args[]){
		
		AccountSyn name = new AccountSyn("123456",1000);
		new AccountTest("allen",name,800).start();
		new AccountTest("jasper",name,800).start();
		
		
	}
}
