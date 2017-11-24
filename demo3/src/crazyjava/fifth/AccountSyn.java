package crazyjava.fifth;

public class AccountSyn {

	private String accountNo;
	private double balance;
	public AccountSyn(){}
	public AccountSyn(String accountNo,double balance){
		this.accountNo = accountNo;
		this.balance = balance;
	}
	public synchronized double getBalance(){
		return balance;
	}
	
	public  void draw(double drawAmount){
		if(balance>drawAmount){
			try{
				System.out.println(Thread.currentThread().getName());
				Thread.sleep(100);
			}catch(InterruptedException e){}
			System.out.println(Thread.currentThread().getName()+"ȡǮ�ɹ����³���Ʊ:"+drawAmount);

			balance = balance-drawAmount;
			System.out.println("���Ϊ��"+balance);
		}else{
			System.out.println(Thread.currentThread().getName()+"����");
		}
	}
	public int hashCode(){
		return accountNo.hashCode();
	}
	
	public boolean equals(Object obj){
		if(obj == this)
			return true;
		if(obj != null&&obj instanceof AccountSyn){
			AccountSyn syn = (AccountSyn) obj;
			return (syn.accountNo.equals(this.accountNo));
		}
		return false;
	}
}
