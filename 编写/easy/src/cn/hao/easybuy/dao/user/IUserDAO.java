package cn.hao.easybuy.dao.user;

import cn.hao.easybuy.entity.EasybuyUser;
import cn.hao.easybuy.util.PageBean;

public interface IUserDAO {

	
	public void deleteUser(String userName);
	
	public void updateUser(EasybuyUser user);
	
	public EasybuyUser getUsers(String userName);
	
	public PageBean findUsers(Integer pageIndex,Integer pageSize);
	
	public void addUser(EasybuyUser user);
}
