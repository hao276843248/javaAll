package cn.bdqn.reserve.action;

import java.sql.Timestamp;

import cn.bdqn.reserve.entity.Room;

public class EditReserveAction extends BaseAction{

	//ª·“È “±‡∫≈
	private Integer id;
	private Timestamp reserveDate;
	private Integer beginTime;
	private Integer endTime;
	
	private Room room;
	
	@Override
	public String execute() throws Exception {
		room=reserveService.getRoom(id);
		return SUCCESS;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getReserveDate() {
		return reserveDate;
	}

	public void setReserveDate(Timestamp reserveDate) {
		this.reserveDate = reserveDate;
	}

	public Integer getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Integer beginTime) {
		this.beginTime = beginTime;
	}

	public Integer getEndTime() {
		return endTime;
	}

	public void setEndTime(Integer endTime) {
		this.endTime = endTime;
	}
	
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	
	
	
}
