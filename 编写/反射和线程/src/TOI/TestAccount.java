package TOI;

public class TestAccount implements Runnable{
	private Account acct=new Account();
	@Override
	public void run() {
		
		for (int i = 0; i < 5; i++) {
			makeWithdrawal(100);
			if(acct.getBalance()<0){
				System.out.println("账胡透支了");
			}
		}
	}
	public void makeWithdrawal(int amt){
		if(acct.getBalance()>=amt){
			System.out.println(Thread.currentThread().getName()+"准备取款");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				
			}
			acct.withdraw(amt);
			System.out.println(Thread.currentThread().getName()+"完成取款");
		}else {
			System.out.println("余额不足"+Thread.currentThread().getName()+"的取款,余额为"+acct.getBalance());
		}
	}

}
