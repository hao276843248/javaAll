package cn.hao.camera.dao.camera;

import cn.hao.camera.entity.Camera;
import cn.hao.camera.util.PageBean;

public interface ICameraDAO {

	public PageBean find(
			int pageIndex,//页号
				int pageSize,//每页行数
			Long brandId,//品牌编号
			Long typeId,//类型编号
			Double maxPrice,//最高价			
			Integer minPixel,//最小像素数
			String title,//标题关键字
			String sort,//排序字段
			String order//排序规则
	);
	
	public Camera get(Long id);
	
}
