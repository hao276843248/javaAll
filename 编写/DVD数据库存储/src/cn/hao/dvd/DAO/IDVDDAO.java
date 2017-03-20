package cn.hao.dvd.DAO;

import java.util.List;

import cn.hao.dvd.entity.DVD;

public interface IDVDDAO {
	public void addDVD(DVD dvd);

	public void upDateDVD(DVD dvd);
	
	public void deleteDVD(int id);
	
	public DVD getDVD(int id);
	
	public List<DVD>  findDVD();
}
