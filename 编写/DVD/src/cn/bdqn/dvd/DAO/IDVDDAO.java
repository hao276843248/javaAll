package cn.bdqn.dvd.DAO;

import cn.bdqn.dvd.entity.DVD;



public interface IDVDDAO {
	
	//�鿴����
	public DVD[] find();
	
	public void add(DVD dvd);
	//���ҵ�������Ԫ��
	public DVD get(String name);
	//����Ԫ������ɾ��Ԫ��
	public void delete(String name);

	
}
