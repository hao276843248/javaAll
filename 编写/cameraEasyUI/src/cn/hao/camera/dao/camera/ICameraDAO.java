package cn.hao.camera.dao.camera;

import cn.hao.camera.entity.Camera;
import cn.hao.camera.util.PageBean;

public interface ICameraDAO {

	public PageBean find(
			int pageIndex,//ҳ��
				int pageSize,//ÿҳ����
			Long brandId,//Ʒ�Ʊ��
			Long typeId,//���ͱ��
			Double maxPrice,//��߼�			
			Integer minPixel,//��С������
			String title,//����ؼ���
			String sort,//�����ֶ�
			String order//�������
	);
	
	public Camera get(Long id);
	
}
