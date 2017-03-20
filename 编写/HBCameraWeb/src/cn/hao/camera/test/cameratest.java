package cn.hao.camera.test;

import java.util.List;

import oracle.net.aso.b;

import org.junit.Test;
import cn.hao.camera.Dao.camera.CameraImpl;
import cn.hao.camera.Dao.camera.MapperCamera;
import cn.hao.camera.entity.Brand;
import cn.hao.camera.entity.Camera;
import cn.hao.camera.service.brand.BrandServiceImpl;
import cn.hao.camera.service.brand.IBrandService;
import cn.hao.camera.util.Fanwei;
import cn.hao.camera.util.PageBean;

public class cameratest {
	@Test
	public void find(){
	MapperCamera cameraDAO=new CameraImpl();
		
		PageBean p=cameraDAO.findCamera(1,10, 1L, 1L, null, null, null, null, new Fanwei("1000~2000"), null);
		
		System.out.println(p.getRowCount());
		System.out.println(p.getPageCount());
		List<Camera> cameras=p.getResult();
		for(Camera camera:cameras){
			System.out.println(camera.getTitle());
		}
	}
}
