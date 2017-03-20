package cn.bdqn.dvd.DAO;

import cn.bdqn.dvd.entity.DVD;



public interface IDVDDAO {
	
	//查看数组
	public DVD[] find();
	
	public void add(DVD dvd);
	//插找单个数组元素
	public DVD get(String name);
	//根据元素名称删除元素
	public void delete(String name);

	
}
