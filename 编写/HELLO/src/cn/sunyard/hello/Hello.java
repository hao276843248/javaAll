package cn.sunyard.hello;

import org.w3c.dom.Node;

import com.sunyard.cbif.etp.base.Context;
import com.sunyard.cbif.etp.base.ETPException;
import com.sunyard.cbif.etp.base.ETPObject;
import com.sunyard.cbif.etp.base.TransactionFailException;
import com.sunyard.cbif.etp.base.TransactionStep;

public class Hello implements Ba{


	public static void main(String[] args) {
		String hao="hello !!!!~~~~~~";
		System.out.println(hao);
	}

	@Override
	public int execute(Context context) throws TransactionFailException,
			Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
