package cn.bdqn.reserve.dao;

import java.sql.Timestamp;
import java.util.Date;

import cn.bdqn.reserve.entity.Reserve;
import cn.bdqn.reserve.entity.Room;
import cn.bdqn.reserve.util.PageBean;

public interface IReserveDAO {
	
	public PageBean findReserve(int pageIndex,int pageSize,Timestamp reserveDate,Integer beginTime,Integer endTime,Integer status);
	
	public Room getRoom(Integer id);
	
	public void addReserve(Reserve reserve);
}
