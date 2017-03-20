package cn.bdqn.camera.test;

import java.util.List;

import org.junit.Test;

import cn.bdqn.camera.dao.camera.HQLCameraDAOImpl;
import cn.bdqn.camera.dao.camera.ICameraDAO;
import cn.bdqn.camera.entity.Camera;
import cn.bdqn.camera.util.PageBean;
import cn.bdqn.camera.util.Range;

public class CameraDAOTest {

	@Test
	public void testFindCamera(){
		ICameraDAO cameraDAO=new HQLCameraDAOImpl();
		
		PageBean p=cameraDAO.findCamera(1,10, 1L, 1L, null, null, null, null, new Range("1000~2000"), null);
		
		System.out.println(p.getRowCount());
		System.out.println(p.getPageCount());
		List<Camera> cameras=p.getResults();
		for(Camera camera:cameras){
			System.out.println(camera.getTitle());
		}
		
		
	}
	
	
}







