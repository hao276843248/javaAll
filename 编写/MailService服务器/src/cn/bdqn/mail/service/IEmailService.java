package cn.bdqn.mail.service;

import java.util.List;

import cn.bdqn.mail.entity.Email;
import cn.bdqn.mail.entity.User;

public interface IEmailService {
	//�����û��������û����ݣ����������֤
	public User getUser(String userName);
	
	//��Ӵ������ʼ�����
	public void saveEmail(Email email);
	
	//����״̬�����ʼ��б�
	public List<Email> findEmail(Integer send);
	
	//�����ʼ�����״̬
	public void updateSend(Integer id);
	
	//����IDɾ���ʼ�
	public void deleteEmail(Integer id);
	
	//������δ�����ʼ�����Ϊ������״̬
	public void updateSending();
}
