package cn.hao.camera.Dao.brand;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import cn.hao.camera.entity.Brand;
import cn.hao.camera.util.HibernateUtil;

public class BrandImpl implements BrandMapper{

	@Override
	public List<Brand> findBrand() {
		Session s=null;
		List<Brand> bs=null;
		try {
			s=HibernateUtil.getSession();
			bs=s.createQuery("from Brand order by id").list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			s.close();
		}
		return bs;
	}

}
