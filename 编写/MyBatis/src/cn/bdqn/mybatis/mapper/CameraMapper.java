package cn.bdqn.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.bdqn.mybatis.entity.Camera;
import cn.bdqn.mybatis.plugin.PageParam;

public interface CameraMapper {

	public List<Camera> findCamear(
		@Param("pageParam")PageParam param
	);
	
}
