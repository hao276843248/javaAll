package cn.hao.reserve.test;

import java.util.List;

import cn.hao.reserve.dao.reserve.IReserveDAO;
import cn.hao.reserve.entitiy.Room;
import cn.hao.reserve.service.room.IRoomService;

public class test1 {
	private static IRoomService RoomService;
	
	
	public static void main(String[] args) {
		List<Room> r=RoomService.findRoom();
		for(Object o:r){
			Room ra=(Room) o;
			System.out.println(ra.getId());
			System.out.println(ra.getName());
		}
	}
	

	public void setRoomService(IRoomService roomService) {
		RoomService = roomService;
	}
}

