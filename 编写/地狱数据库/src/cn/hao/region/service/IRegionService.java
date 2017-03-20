package cn.hao.region.service;

import java.util.List;

import cn.hao.region.entity.Region;

public interface IRegionService {

	public List<Region> findRegions(Integer parentId);
}
