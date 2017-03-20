package cn.bdqn.mybatis.mapper;

import java.util.List;
import java.util.Map;

import cn.bdqn.mybatis.entity.Brand;

public interface BrandMapper {
	
	public List<Brand> findBrand();

	public List<Map<String,Object>> getBrandCameraCount();
}
