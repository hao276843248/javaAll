package cn.hao.dvd.Service;

import java.util.List;

import cn.hao.dvd.entity.DVD;

public interface IDVDService {

	public void addDVD(DVD dvd);
	
	public void deleteDVD(int id);
	
	public void updateDVD(DVD dvd);
	
	public DVD getDVD(int id);
	
	public List<DVD> findDVD();
}
