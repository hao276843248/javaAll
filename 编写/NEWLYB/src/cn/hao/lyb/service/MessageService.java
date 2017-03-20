package cn.hao.lyb.service;

import java.util.List;

import cn.hao.lyb.dao.IMessageDAO;
import cn.hao.lyb.dao.MessageDAO;
import cn.hao.lyb.entity.Message;

public class MessageService implements IMessageService{

	private IMessageDAO DAO=new MessageDAO();
	public void addMessage(Message message) {
		DAO.addMessage(message);
	}

	@Override
	public List<Message> findMessage() {
		return DAO.findMessage();
	}

	@Override
	public void deleteMessage(int id) {
		DAO.deleteMessage(id);
	}

}
