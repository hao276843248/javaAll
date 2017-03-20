package cn.hao.reserve.service.reserve;

import java.util.Date;
import java.util.List;

import cn.hao.reserve.entitiy.Reserve;

public interface IReserveService {

	public List<Reserve> listReserve(Date date,Integer beginTime,Integer endTime,String name);
	
	public Reserve getReserve(Integer id);
	
	public void deleteResetve(Reserve Reserve);

	public void updateResetve(Reserve Reserve);
}
