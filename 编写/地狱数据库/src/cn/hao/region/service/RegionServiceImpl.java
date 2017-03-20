package cn.hao.region.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.hao.region.dao.IRegionDAO;
import cn.hao.region.entity.Region;
@Repository("regionService")
public class RegionServiceImpl implements IRegionService{


	private IRegionDAO regionDAO;
	@Autowired
	public void setRegionDAO(IRegionDAO regionDAO) {
		this.regionDAO = regionDAO;
	}
	@Override
	public List<Region> findRegions(Integer parentId) {
		
		return regionDAO.findRegions(parentId);
	}

	
}
