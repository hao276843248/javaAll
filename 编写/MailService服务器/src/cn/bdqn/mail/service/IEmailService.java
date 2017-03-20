package cn.bdqn.mail.service;

import java.util.List;

import cn.bdqn.mail.entity.Email;
import cn.bdqn.mail.entity.User;

public interface IEmailService {
	//根据用户名加载用户数据，用于身份验证
	public User getUser(String userName);
	
	//添加待发送邮件数据
	public void saveEmail(Email email);
	
	//根据状态加载邮件列表
	public List<Email> findEmail(Integer send);
	
	//更新邮件发送状态
	public void updateSend(Integer id);
	
	//根据ID删除邮件
	public void deleteEmail(Integer id);
	
	//批量将未发送邮件更新为发送中状态
	public void updateSending();
}
