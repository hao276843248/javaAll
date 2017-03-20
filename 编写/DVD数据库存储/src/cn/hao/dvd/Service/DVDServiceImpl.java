package cn.hao.dvd.Service;

import java.util.List;

import cn.hao.dvd.DAO.DVDDAOImpl;
import cn.hao.dvd.DAO.IDVDDAO;
import cn.hao.dvd.entity.DVD;

public class DVDServiceImpl implements IDVDService {

	public static IDVDDAO DVDDAO=new DVDDAOImpl();
	
	@Override
	public void addDVD(DVD dvd) {
		DVDDAO.addDVD(dvd);
		
	}

	@Override
	public void deleteDVD(int id) {
		DVDDAO.deleteDVD(id);
		
	}

	@Override
	public void updateDVD(DVD dvd) {
		DVDDAO.upDateDVD(dvd);
	}

	@Override
	public DVD getDVD(int id) {
		
		return DVDDAO.getDVD(id);
	}

	@Override
	public List<DVD> findDVD() {
		// TODO Auto-generated method stub
		return DVDDAO.findDVD();
	}
	
}
