package cn.hao.reserve.action;

import cn.hao.reserve.entity.Reserve;

import com.opensymphony.xwork2.ModelDriven;

public class addAction extends BaseAction implements ModelDriven<Reserve>{

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
