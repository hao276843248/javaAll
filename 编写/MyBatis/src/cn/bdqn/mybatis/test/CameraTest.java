package cn.bdqn.mybatis.test;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import cn.bdqn.mybatis.entity.Camera;
import cn.bdqn.mybatis.mapper.CameraMapper;
import cn.bdqn.mybatis.plugin.PageParam;
import cn.bdqn.mybatis.util.MyBatisUtil;

public class CameraTest {
	
	@Test
	public void testFindCamera(){
		List<Camera> cameras=null;
		SqlSession session=null;
		
		PageParam pageParam=new PageParam(3,10);
		try {
			session=MyBatisUtil.openSession();
			CameraMapper mapper=session.getMapper(CameraMapper.class);
			cameras=mapper.findCamear(pageParam);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		System.out.println(pageParam.getRowCount());
		System.out.println(pageParam.getPageCount());
		for (Camera camera:cameras) {
			System.out.println(camera.getBrand().getName()+"\t"+camera.getType().getName()+"\t"+camera.getTitle());
		}
	}
	
	@Test
	public void testFindCamera2(){
		List<Camera> cameras=null;
		SqlSession session=null;
		try {
			session=MyBatisUtil.openSession();
			cameras=session.selectList(
				"cn.bdqn.mybatis.mapper.CameraMapper.findCamear",
				null,
				new RowBounds(20,10)
			);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			session.close();
		}
		for (Camera camera:cameras) {
			System.out.println(camera.getBrand().getName()+"\t"+camera.getType().getName()+"\t"+camera.getTitle());
		}
	}
}










