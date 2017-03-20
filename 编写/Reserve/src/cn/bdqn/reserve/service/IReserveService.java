package cn.bdqn.reserve.service;

import java.sql.Timestamp;
import java.util.Date;

import cn.bdqn.reserve.entity.Reserve;
import cn.bdqn.reserve.entity.Room;
import cn.bdqn.reserve.util.PageBean;

public interface IReserveService{

	public PageBean findReserve(int pageIndex,int pageSize,Timestamp reserveDate,Integer beginTime,Integer endTime,Integer status);
	
	public Room getRoom(Integer id);
	
	public void addReserve(Reserve reserve);
}
