package cn.hao.reserve.dao.room;

import java.util.List;
import org.hibernate.Session;

import cn.hao.reserve.entitiy.Room;
import cn.hao.reserve.util.HibernateUtil;

public class RoomDAOImpl implements IRoomDAO{

	@Override
	public List<Room> findRoom() {
		Session session=null;
		List<Room> rooms=null;
		try {
			session=HibernateUtil.getSession();
			rooms=session.createQuery("from Room order by id").list();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return rooms;
	}
}










