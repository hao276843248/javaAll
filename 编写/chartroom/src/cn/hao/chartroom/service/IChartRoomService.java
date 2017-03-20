package cn.hao.chartroom.service;

import java.util.List;

import cn.hao.chartroom.entity.Chartroom;

public interface IChartRoomService {

	
	public List<Chartroom>  findContentById(Integer id);
	
	public void addContent(Chartroom chartroom);
	
	public List<Chartroom> findContentBySize(Integer size);
}
