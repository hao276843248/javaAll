package cn.hao.easybuy.dao.user;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import cn.hao.easybuy.entity.EasybuyUser;
import cn.hao.easybuy.util.PageBean;

@Repository("userDAOImpl")
public class UserDAOImpl implements IUserDAO{

	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}



	@Override
	public void deleteUser(Integer id) {
		hibernateTemplate.bulkUpdate("delete from EasybuyUser where euUserId=?",id);
	}

	@Override
	public void updateUser(EasybuyUser user) {
		hibernateTemplate.update(user);
	}

	@Override
	public EasybuyUser getUsers(String userName) {
		List<EasybuyUser> easybuyUsers=hibernateTemplate.find("from EasybuyUser where euUserId=?",userName);
		if (easybuyUsers.size()>0) {
			return easybuyUsers.get(0);
		}
		return null;
	}

	@Override
	public PageBean findUsers(Integer pageIndex,Integer pageSize) {
		int rowCount=hibernateTemplate.find("from EasybuyUser order by euUserId").size();
		
		//计算总页数
		int pageCount=(rowCount%pageSize==0)?(rowCount/pageSize):(rowCount/pageSize+1);
				
		//计算当前页第一行行号
		int firstResult=(pageIndex-1)*pageSize;
		DetachedCriteria detCri=DetachedCriteria.forClass(EasybuyUser.class);

		List<EasybuyUser> results=hibernateTemplate.findByCriteria(detCri, firstResult, pageSize);
		
		PageBean p=new PageBean();
		p.setPageCount(pageCount);
		p.setPageIndex(pageIndex);
		p.setPageSize(pageSize);
		p.setResults(results);
		p.setRowCount(rowCount);
		
		return p;
	}

	@Override
	public void addUser(EasybuyUser user) {
		hibernateTemplate.save(user);
	}

}
