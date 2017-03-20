package cn.hao.chartroom.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import cn.hao.chartroom.entity.Chartroom;
import cn.hao.chartroom.service.IChartRoomService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AddContentAction extends ActionSupport implements ModelDriven<Chartroom>{
	
	private Chartroom chartroom=new Chartroom();

	@Override
	public Chartroom getModel() {
		return chartroom;
	}
	@Autowired
	private IChartRoomService chartRoomService;
	
	public void setChartRoomService(IChartRoomService chartRoomService) {
		this.chartRoomService = chartRoomService;
	}
	@Override
	public String execute() throws Exception {
		HttpServletRequest request=ServletActionContext.getRequest();
		chartroom.setIp(request.getRemoteAddr());
		chartRoomService.addContent(chartroom);
		return NONE;
	}
	

}
