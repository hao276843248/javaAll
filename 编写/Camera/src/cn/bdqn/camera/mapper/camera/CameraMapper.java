package cn.bdqn.camera.mapper.camera;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.bdqn.camera.entity.Camera;
import cn.bdqn.camera.util.Range;
import cn.bdqn.mybatis.plugin.PageParam;

public interface CameraMapper {

	public List<Camera> findCamera(
		@Param("pageParam")PageParam param,	//分页参数	
		@Param("typeId")Long typeId,		//类型编号
		@Param("brandId")Long brandId,		//品牌编号
		@Param("pixel")Range pixel,			//像素数范围
		@Param("zoom")Range zoom,			//变焦倍数范围
		@Param("color")String color,		//机身颜色
		@Param("lcd")Range lcd,				//液晶屏尺寸范围
		@Param("price")Range price,			//价格范围
		@Param("title")String title			//标题关键字
	);
	
}






