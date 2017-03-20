package cn.bdqn.camera.dao.camera;

import cn.bdqn.camera.util.PageBean;
import cn.bdqn.camera.util.Range;

public interface ICameraDAO {

	public PageBean findCamera(
		int pageIndex,
		int pageSize,
		Long typeId,
		Long brandId,
		Range pixel,
		Range zoom,
		String color,
		Range lcd,
		Range price,
		String title	
	);
	
}
