package cn.bdqn.mail.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bdqn.mail.dao.IEmailDAO;
import cn.bdqn.mail.entity.Email;
import cn.bdqn.mail.entity.User;

@Service("emailService")
public class EmailServiceImpl implements IEmailService {
	
	private IEmailDAO emailDAO;
	
	@Autowired
	public void setEmailDAO(IEmailDAO emailDAO) {
		this.emailDAO = emailDAO;
	}

	@Override
	public User getUser(String userName) {
		return emailDAO.getUser(userName);
	}

	@Override
	public void saveEmail(Email email) {
		emailDAO.saveEmail(email);
	}

	@Override
	public List<Email> findEmail(Integer send) {
		return emailDAO.findEmail(send);
	}

	@Override
	public void updateSend(Integer id) {
		emailDAO.updateSend(id);
	}

	@Override
	public void deleteEmail(Integer id) {
		emailDAO.deleteEmail(id);
	}

	@Override
	public void updateSending() {
		emailDAO.updateSending();
	}
	
	

}
