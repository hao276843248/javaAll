package cn.bdqn.camera.service.cameras;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bdqn.camera.dao.camera.ICameraDAO;
import cn.bdqn.camera.entity.Camera;
import cn.bdqn.camera.util.PageBean;

@Service("cameraService")
public class CameraServiceImpl implements ICameraService{
	
	private ICameraDAO cameraDAO;
	@Autowired
	public void setCameraDAO(ICameraDAO cameraDAO) {
		this.cameraDAO = cameraDAO;
	}
	
	
	@Override
	public PageBean find(int pageIndex, int pageSize, Long brandId,
			Long typeId, Double maxPrice, Integer minPixel,
			String title,String sort,String order) {
		return cameraDAO.find(pageIndex, pageSize, brandId, typeId, maxPrice, minPixel, title,sort,order);
	}
	
	@Override
	public Camera get(Long id) {
		return cameraDAO.get(id);
	}

}
