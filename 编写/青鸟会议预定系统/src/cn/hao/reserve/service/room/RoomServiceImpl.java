package cn.hao.reserve.service.room;

import java.util.List;

import cn.hao.reserve.dao.room.IRoomDAO;
import cn.hao.reserve.entitiy.Room;

public class RoomServiceImpl implements IRoomService{

	private IRoomDAO roomDAO;
	
	public void setRoomDAO(IRoomDAO roomDAO) {
		this.roomDAO = roomDAO;
	}
	
	@Override
	public List<Room> findRoom() {
		return roomDAO.findRoom();
	}
	
}
