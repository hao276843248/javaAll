package cn.hao.region.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.hao.region.entity.Region;
import cn.hao.region.service.IRegionService;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.regexp.internal.recompile;

public class listAction extends ActionSupport{
	
	private IRegionService regionService;
	@Autowired
	public void setRegionService(IRegionService regionService) {
		this.regionService = regionService;
	}
	private Integer parentId=0;
	
	private List<Region> regions;
	
	@Override
	public String execute() throws Exception {
		regions=regionService.findRegions(parentId);
		return SUCCESS;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public List<Region> getRegions() {
		return regions;
	}

	public void setRegions(List<Region> regions) {
		this.regions = regions;
	}

	
}
