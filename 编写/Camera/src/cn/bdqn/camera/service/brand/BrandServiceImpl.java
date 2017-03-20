package cn.bdqn.camera.service.brand;

import java.util.List;

import cn.bdqn.camera.dao.brand.BrandDAOImpl;
import cn.bdqn.camera.dao.brand.IBrandDAO;
import cn.bdqn.camera.entity.Brand;

public class BrandServiceImpl implements IBrandService{
	
	private	 IBrandDAO brandDAO=new BrandDAOImpl();
	
	@Override
	public List<Brand> findBrand() {
		return brandDAO.findBrand();
	}

}






