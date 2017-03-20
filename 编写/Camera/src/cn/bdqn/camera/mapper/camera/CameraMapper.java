package cn.bdqn.camera.mapper.camera;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.bdqn.camera.entity.Camera;
import cn.bdqn.camera.util.Range;
import cn.bdqn.mybatis.plugin.PageParam;

public interface CameraMapper {

	public List<Camera> findCamera(
		@Param("pageParam")PageParam param,	//��ҳ����	
		@Param("typeId")Long typeId,		//���ͱ��
		@Param("brandId")Long brandId,		//Ʒ�Ʊ��
		@Param("pixel")Range pixel,			//��������Χ
		@Param("zoom")Range zoom,			//�佹������Χ
		@Param("color")String color,		//������ɫ
		@Param("lcd")Range lcd,				//Һ�����ߴ緶Χ
		@Param("price")Range price,			//�۸�Χ
		@Param("title")String title			//����ؼ���
	);
	
}






