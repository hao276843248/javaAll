package cn.hao.camera.Dao.camera;


import cn.hao.camera.util.Fanwei;
import cn.hao.camera.util.PageBean;

public interface MapperCamera {
	public PageBean findCamera(
			int pageIndex,
			int pageSize,	//分页参数	
			Long typeId,		//类型编号
			Long brandId,		//品牌编号
			Fanwei pixel,			//像素数范围
			Fanwei zoom,			//变焦倍数范围
			String color,		//机身颜色
			Fanwei lcd,				//液晶屏尺寸范围
			Fanwei price,			//价格范围
			String title		//标题关键字
			);
}
