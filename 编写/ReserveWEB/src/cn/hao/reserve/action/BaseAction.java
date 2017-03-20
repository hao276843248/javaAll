package cn.hao.reserve.action;

import cn.hao.reserve.service.IReserveService;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport{
	
	protected IReserveService reserveService;
	
	public void setReserveService(IReserveService reserveService) {
		this.reserveService = reserveService;
	}

}
