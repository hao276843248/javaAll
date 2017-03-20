package cn.hao.region.dao;

import java.util.List;

import cn.hao.region.entity.Region;

public interface IRegionDAO {

	public List<Region> findRegions(Integer parentId);
	
}

