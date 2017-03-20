package cn.bdqn.reserve.action;

import cn.bdqn.reserve.entity.Reserve;

import com.opensymphony.xwork2.ModelDriven;

public class AddReserveAction extends BaseAction implements ModelDriven<Reserve>{
	
	private Reserve reserve=new Reserve();
	
	@Override
	public Reserve getModel() {
		return reserve;
	}
	
	@Override
	public String execute() throws Exception {		
		reserveService.addReserve(reserve);
		return SUCCESS;
	}
	
	

}
