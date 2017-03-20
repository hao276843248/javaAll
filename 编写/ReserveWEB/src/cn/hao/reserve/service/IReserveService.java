package cn.hao.reserve.service;

import java.sql.Timestamp;

import cn.hao.reserve.entity.Reserve;
import cn.hao.reserve.entity.Room;
import cn.hao.reserve.util.PageBean;

public interface IReserveService {

	public PageBean findReserve(int pageIndex,int pageSize,Timestamp reserveDate,Integer beginTime,Integer endTime,Integer status);

	public Room getRoom(Integer id);
	
	public void addReserve(Reserve reserve);
}
