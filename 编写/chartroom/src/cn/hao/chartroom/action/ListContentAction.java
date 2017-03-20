package cn.hao.chartroom.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.hao.chartroom.entity.Chartroom;
import cn.hao.chartroom.service.IChartRoomService;

import com.opensymphony.xwork2.ActionSupport;

public class ListContentAction extends ActionSupport{
	
	private Integer size;
	private Integer id;
	private List<Chartroom> content;
	private String currentIP;
	
	@Autowired
	private IChartRoomService chartRoomService;
	
	@Override
	public String execute() throws Exception {
		if(size!=null){
			content=chartRoomService.findContentBySize(size);
		}else if(id!=null){
			content=chartRoomService.findContentById(id);
		}
		System.out.println();
		HttpServletRequest request=ServletActionContext.getRequest();
		currentIP=request.getRemoteAddr();
		return SUCCESS;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Chartroom> getContent() {
		return content;
	}

	public void setContent(List<Chartroom> content) {
		this.content = content;
	}

	public String getCurrentIP() {
		return currentIP;
	}

	public void setCurrentIP(String currentIP) {
		this.currentIP = currentIP;
	}

	public void setChartRoomService(IChartRoomService chartRoomService) {
		this.chartRoomService = chartRoomService;
	}
	
	
	
}
