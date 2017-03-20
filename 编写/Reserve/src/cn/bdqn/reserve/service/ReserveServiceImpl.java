package cn.bdqn.reserve.service;

import java.sql.Timestamp;
import java.util.Date;

import cn.bdqn.reserve.dao.IReserveDAO;
import cn.bdqn.reserve.entity.Reserve;
import cn.bdqn.reserve.entity.Room;
import cn.bdqn.reserve.util.PageBean;

public class ReserveServiceImpl implements IReserveService{

	private IReserveDAO reserveDAO;
	
	public void setReserveDAO(IReserveDAO reserveDAO) {
		this.reserveDAO = reserveDAO;
	}
	
	@Override
	public PageBean findReserve(int pageIndex, int pageSize, Timestamp reserveDate,
			Integer beginTime, Integer endTime, Integer status) {
		return reserveDAO.findReserve(pageIndex, pageSize, reserveDate, beginTime, endTime, status);
	}
	
	@Override
	public Room getRoom(Integer id) {
		return reserveDAO.getRoom(id);
	}
	
	@Override
	public void addReserve(Reserve reserve) {
		reserveDAO.addReserve(reserve);
	}

}
