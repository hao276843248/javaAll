package cn.hao.reserve.dao;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.hao.reserve.entity.Reserve;
import cn.hao.reserve.entity.Room;
import cn.hao.reserve.util.PageBean;

public class ReserveDAOImpl extends HibernateDaoSupport implements IReserveDAO{

	@Override
	public PageBean findReserve(int pageIndex, int pageSize, Timestamp reserveDate,
			Integer beginTime, Integer endTime,Integer status) {
		Session session=getSession();
		String countSql="Select count(*) from room r left join (select * from reserve where reserveDate=:reserveDate and beginTime>=:beginTime and endTime<=:endTime) t on r.id=t.roomId ";
		if(status==1){
			countSql+=" where t.id is null";
		}else{
			countSql+=" where t.id is not null";
		}
		int rowCount=((Number)session.createSQLQuery(countSql)
					.setTimestamp("reserveDate",reserveDate)
					.setInteger("beginTime", beginTime)
					.setInteger("endTime",endTime)
					.uniqueResult()).intValue();
		
		int pageCount=(rowCount%pageSize==0)?(rowCount/pageSize):(rowCount/pageSize+1);
		int firstResult=(pageIndex-1)*pageSize;	
		
		
		String listSql="Select {r.*},{t.*} from room r left join (select * from reserve where reserveDate=:reserveDate and beginTime>=:beginTime and endTime<=:endTime) t on r.id=t.roomId";
		if(status==1){
			listSql+=" where t.id is null";
		}else{
			listSql+=" where t.id is not null";
		}
		listSql+=" order by r.id ";
		SQLQuery query=session.createSQLQuery(listSql);
		query.setTimestamp("reserveDate",reserveDate)
			 .setInteger("beginTime", beginTime)
			 .setInteger("endTime",endTime);
		query.addEntity("r",Room.class);
		query.addEntity("t",Reserve.class);
		query.setFirstResult(firstResult);
		query.setMaxResults(pageSize);			   
		
		List<Object[]> result=query.list();
		PageBean pageBean=new PageBean();
		pageBean.setPageCount(pageCount);
		pageBean.setPageIndex(pageIndex);
		pageBean.setPageSize(pageSize);
		pageBean.setResults(result);
		pageBean.setRowCount(rowCount);
		return pageBean;
	}

	@Override
	public Room getRoom(Integer id) {
		return getHibernateTemplate().get(Room.class,id);
	}

	@Override
	public void addReserve(Reserve reserve) {
		getHibernateTemplate().save(reserve);
	}

	
	
	
}

