package cn.hao.camera.service.camera;

import java.util.List;
import cn.hao.camera.entity.Camera;
import cn.hao.camera.util.Fanwei;
import cn.hao.camera.util.PageBean;

public interface IServiceCamera {
	public PageBean findCamera(
			int pageIndex,
			int pageSize,	//��ҳ����	
			Long typeId,		//���ͱ��
			Long brandId,		//Ʒ�Ʊ��
			Fanwei pixel,			//��������Χ
			Fanwei zoom,			//�佹������Χ
			String color,		//������ɫ
			Fanwei lcd,				//Һ�����ߴ緶Χ
			Fanwei price,			//�۸�Χ
			String title		//����ؼ���
			);
}
