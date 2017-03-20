package cn.bdqn.camera.service.brand;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bdqn.camera.dao.brand.IBrandDAO;
import cn.bdqn.camera.entity.Brand;

@Service("brandService")
public class BrandServiceImpl implements IBrandService{
	
	private IBrandDAO brandDAO;
	@Autowired
	public void setBrandDAO(IBrandDAO brandDAO) {
		this.brandDAO = brandDAO;
	}
	
	@Override
	public List<Brand> find() {
		return brandDAO.find();
	}

}
