package cn.hao.reserve.dao;

import java.sql.Timestamp;
import java.util.Date;

import cn.hao.reserve.entity.Reserve;
import cn.hao.reserve.entity.Room;
import cn.hao.reserve.util.PageBean;

public interface IReserveDAO {

	public PageBean findReserve(int pageIndex,int pageSize,Timestamp reserveDate,Integer beginTime,Integer endTime,Integer status );

	public Room getRoom(Integer id);
	
	public void addReserve(Reserve reserve);
}
