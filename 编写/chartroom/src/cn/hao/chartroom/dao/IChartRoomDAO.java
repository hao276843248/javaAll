package cn.hao.chartroom.dao;

import java.util.List;

import cn.hao.chartroom.entity.Chartroom;

public interface IChartRoomDAO {

	
	public List<Chartroom>  findContentById(Integer id);
	
	public void addContent(Chartroom chartroom);
	
	public List<Chartroom> findContentBySize(Integer size);
}
