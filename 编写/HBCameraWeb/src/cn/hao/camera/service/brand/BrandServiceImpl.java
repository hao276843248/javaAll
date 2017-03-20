package cn.hao.camera.service.brand;

import java.util.List;


import cn.hao.camera.Dao.brand.BrandImpl;
import cn.hao.camera.Dao.brand.BrandMapper;
import cn.hao.camera.entity.Brand;

public class BrandServiceImpl implements IBrandService{

	@Override
	public List<Brand> findBrand() {
		BrandMapper b=new BrandImpl();
		return b.findBrand();
	}

}
