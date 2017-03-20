package cn.bdqn.reserve.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.bdqn.reserve.entity.Reserve;
import cn.bdqn.reserve.entity.Room;
import cn.bdqn.reserve.util.PageBean;

public class ReserveDAOImpl extends HibernateDaoSupport implements IReserveDAO{

	@Override
	public PageBean findReserve(int pageIndex, int pageSize, Timestamp reserveDate,
			Integer beginTime, Integer endTime, Integer status) {
		Session session=getSession();
	
	
		String countSql="select COUNT(*) as count from Room r LEFT JOIN (select * from Reserve where reserveDate=:reserveDate and beginTime>=:beginTime and endTime<=:endTime) t ON r.id=t.roomId";
		if(status==1){
			countSql+=" where t.id is null";
		}
		else{
			countSql+=" where t.id is not null";
		}
		int rowCount=((Number)session.createSQLQuery(countSql)
			   .setDate("reserveDate",reserveDate)
			   .setInteger("beginTime",beginTime)
			   .setInteger("endTime",endTime)
			   .uniqueResult()).intValue();
		
		int pageCount=(rowCount%pageSize==0)?(rowCount/pageSize):(rowCount/pageSize+1);
		int firstResult=(pageIndex-1)*pageSize;
		
		
		String listSql="select {r.*},{t.*} from Room r LEFT JOIN (select * from Reserve where reserveDate=:reserveDate and beginTime>=:beginTime and endTime<=:endTime) t ON r.id=t.roomId";
		if(status==1){
			listSql+=" where t.id is null";
		}
		else{
			listSql+=" where t.id is not null";
		}
		listSql+=" ORDER BY r.id";
		
		SQLQuery query=session.createSQLQuery(listSql);
		query.setDate("reserveDate",reserveDate)
		   	 .setInteger("beginTime",beginTime)
		   	 .setInteger("endTime",endTime);
		
		query.addEntity("r",Room.class);
		query.addEntity("t",Reserve.class);
		
		query.setFirstResult(firstResult);
		query.setMaxResults(pageSize);
		List<Object[]> results=query.list();
		
		PageBean pageBean=new PageBean();
		pageBean.setPageIndex(pageIndex);
		pageBean.setPageSize(pageSize);
		pageBean.setRowCount(rowCount);
		pageBean.setPageCount(pageCount);
		pageBean.setResults(results);
		return pageBean;
	}

	
	@Override
	public Room getRoom(Integer id) {
		return getHibernateTemplate().get(Room.class, id);
	}
	
	@Override
	public void addReserve(Reserve reserve) {
		getHibernateTemplate().save(reserve);
	}
}












