package cn.hao.chartroom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.hao.chartroom.dao.IChartRoomDAO;
import cn.hao.chartroom.entity.Chartroom;

@Repository("chartRoomService")
public class ChartRoomServiceImpl implements IChartRoomService{

	private IChartRoomDAO chartRoomDAO;
	
	@Autowired
	public void setChartRoomDAO(IChartRoomDAO chartRoomDAO) {
		this.chartRoomDAO = chartRoomDAO;
	}
	
	@Override
	public List<Chartroom> findContentById(Integer id) {
		return chartRoomDAO.findContentById(id);
	}

	@Override
	public void addContent(Chartroom chartroom) {
		chartRoomDAO.addContent(chartroom);
	}

	@Override
	public List<Chartroom> findContentBySize(Integer size) {
		return chartRoomDAO.findContentBySize(size);
	}

}
