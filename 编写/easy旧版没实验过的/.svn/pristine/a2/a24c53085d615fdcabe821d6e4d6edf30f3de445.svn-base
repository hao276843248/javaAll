package cn.hao.easybuy.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.hao.easybuy.dao.user.IUserDAO;
import cn.hao.easybuy.entity.EasybuyUser;
import cn.hao.easybuy.util.PageBean;

@Service("userServiceImpl")
public class UserServiceImpl implements IUserService{

	private IUserDAO userDAOImpl;
	
	
	@Autowired
	public void setUserDAOImpl(IUserDAO userDAOImpl) {
		this.userDAOImpl = userDAOImpl;
	}

	@Override
	public void deleteUser(Integer id) {
		userDAOImpl.deleteUser(id);
	}

	@Override
	public void updateUser(EasybuyUser user) {
		userDAOImpl.updateUser(user);
	}

	@Override
	public EasybuyUser getUsers(String userName) {
		
		return userDAOImpl.getUsers(userName);
	}

	@Override
	public PageBean findUsers(Integer pageIndex,Integer pageSize) {
		
		return userDAOImpl.findUsers(pageIndex, pageSize);
	}

	@Override
	public void addUser(EasybuyUser user) {
		userDAOImpl.addUser(user);
	}

}
