package cn.bdqn.camera.service.cameras;

import cn.bdqn.camera.entity.Camera;
import cn.bdqn.camera.util.PageBean;

public interface ICameraService {

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
