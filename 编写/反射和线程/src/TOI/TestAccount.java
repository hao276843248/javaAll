package TOI;

public class TestAccount implements Runnable{
	private Account acct=new Account();
	@Override
	public void run() {
		
		for (int i = 0; i < 5; i++) {
			makeWithdrawal(100);
			if(acct.getBalance()<0){
				System.out.println("�˺�͸֧��");
			}
		}
	}
	public void makeWithdrawal(int amt){
		if(acct.getBalance()>=amt){
			System.out.println(Thread.currentThread().getName()+"׼��ȡ��");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				
			}
			acct.withdraw(amt);
			System.out.println(Thread.currentThread().getName()+"���ȡ��");
		}else {
			System.out.println("����"+Thread.currentThread().getName()+"��ȡ��,���Ϊ"+acct.getBalance());
		}
	}

}
