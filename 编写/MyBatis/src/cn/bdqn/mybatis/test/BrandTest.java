package cn.bdqn.mybatis.test;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import cn.bdqn.mybatis.entity.Brand;
import cn.bdqn.mybatis.entity.Camera;
import cn.bdqn.mybatis.mapper.BrandMapper;
import cn.bdqn.mybatis.util.MyBatisUtil;

public class BrandTest {
	
	@Test
	public void testFindBrand(){
		List<Brand> brands=null;
		SqlSession session=null;
		try {
			session=MyBatisUtil.openSession();
			BrandMapper mapper=session.getMapper(BrandMapper.class);
			brands=mapper.findBrand();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		for(Brand brand:brands){
			System.out.println(brand.getId()+"\t"+brand.getName());
			System.out.println("-----------");
			for(Camera camera:brand.getCameras()){
				System.out.println(camera.getTitle());
			}			
		}
	}

	@Test
	public void testGetBrandCamerCount(){
		List<Map<String,Object>> rows=null;
		SqlSession session=null;
		try {
			session=MyBatisUtil.openSession();
			BrandMapper mapper=session.getMapper(BrandMapper.class);
			rows=mapper.getBrandCameraCount();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		
		for (Map<String,Object> row:rows) {
			long id=(Long)row.get("id");
			String name=(String)row.get("name");
			int amount=(Integer)row.get("amount");
			System.out.println(id+"\t"+name+"\t"+amount);
		}
		
	}
}









