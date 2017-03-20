package cn.hao.lyb.dao;

import java.util.List;

import cn.hao.lyb.entity.Message;

public interface IMessageDAO {
	public void addMessage(Message message);
	
	public List<Message> findMessage();
	
	public void deleteMessage(int id);
}
