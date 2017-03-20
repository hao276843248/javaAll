package cn.hao.camera.service.camera;

import java.util.List;
import cn.hao.camera.entity.Camera;
import cn.hao.camera.util.Fanwei;
import cn.hao.camera.util.PageBean;

public interface IServiceCamera {
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
