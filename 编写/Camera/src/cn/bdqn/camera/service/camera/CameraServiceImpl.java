package cn.bdqn.camera.service.camera;

import cn.bdqn.camera.dao.camera.CriteriaCameraDAOImpl;
import cn.bdqn.camera.dao.camera.HQLCameraDAOImpl;
import cn.bdqn.camera.dao.camera.ICameraDAO;
import cn.bdqn.camera.util.PageBean;
import cn.bdqn.camera.util.Range;

public class CameraServiceImpl implements ICameraService {

	private ICameraDAO cameraDAO=new CriteriaCameraDAOImpl();
	
	@Override
	public PageBean findCamera(int pageIndex, int pageSize, Long typeId,
			Long brandId, Range pixel, Range zoom, String color, Range lcd,
			Range price, String title) {
		return cameraDAO.findCamera(pageIndex, pageSize, typeId, brandId, pixel, zoom, color, lcd, price, title);
	}
	
}
