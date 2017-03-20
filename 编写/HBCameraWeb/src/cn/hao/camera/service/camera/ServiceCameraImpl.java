package cn.hao.camera.service.camera;


import cn.hao.camera.Dao.camera.CameraImpl;
import cn.hao.camera.Dao.camera.MapperCamera;
import cn.hao.camera.util.Fanwei;
import cn.hao.camera.util.PageBean;

public class ServiceCameraImpl implements IServiceCamera{
	MapperCamera ic=new CameraImpl();
	@Override
	public PageBean findCamera(int pageIndex, int pageSize, Long typeId,
			Long brandId, Fanwei pixel, Fanwei zoom, String color, Fanwei lcd,
			Fanwei price, String title) {
		
		return ic.findCamera(pageIndex, pageSize, typeId, brandId, pixel, zoom, color, lcd, price, title);
	}

}
