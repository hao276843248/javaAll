package cn.bdqn.camera.dao.brand;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import cn.bdqn.camera.entity.Brand;
import cn.bdqn.camera.util.HibernateUtil;

public class BrandDAOImpl implements IBrandDAO{
	
	private Logger logger=Logger.getLogger(BrandDAOImpl.class);
	
	@Override
	public List<Brand> findBrand() {
		List<Brand> brands=null;
		Session session=null;
		try {
			session=HibernateUtil.getSession();
			brands=session.createQuery("from Brand order by id")
						  .list();
		} catch (Exception e) {
			logger.error("获取品牌列表时发生错误",e);
		}
		finally{
			session.close();
		}
		return brands;
	}

}






