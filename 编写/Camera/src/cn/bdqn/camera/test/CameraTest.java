package cn.bdqn.camera.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.bdqn.camera.entity.Camera;
import cn.bdqn.camera.mapper.camera.CameraMapper;
import cn.bdqn.camera.util.MyBatisUtil;
import cn.bdqn.camera.util.Range;
import cn.bdqn.mybatis.plugin.PageParam;

public class CameraTest {
	public static void main(String[] args) {
		
		PageParam pageParam=new PageParam(2,10);
		
		
		SqlSession session=MyBatisUtil.openSession();
		CameraMapper mapper=session.getMapper(CameraMapper.class);
		
		List<Camera> cameras=mapper.findCamera(pageParam, 1L, null, new Range("1000~2000"), new Range("10~20"), null, null, null, null);
		
		session.close();
		
		System.out.println(pageParam.getRowCount());
		System.out.println(pageParam.getPageCount());
		
		for (Camera camera:cameras) {
			System.out.println(camera.getTitle());
		}
		
		
		
		
		
		
		
		
		
		
	}
}
