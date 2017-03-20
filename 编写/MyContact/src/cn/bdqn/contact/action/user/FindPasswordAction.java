package cn.bdqn.contact.action.user;


import cn.bdqn.contact.action.BaseAction;
import cn.bdqn.contact.entity.User;
import cn.bdqn.mail.ws.IMailWebService;
import cn.bdqn.mail.ws.MailParam;

public class FindPasswordAction extends BaseAction{
	
	private String userName;
	private String email;
	
	
	private IMailWebService mailService;
	
	
	
	
	
	
	@Override
	public String execute() throws Exception {
		//�����û��������û�����
		User user=userService.getUser(userName);
		
		if(user==null){
			addFieldError("userName",getText("username.invalid"));
			return INPUT;
		}
		//�ж��ύ�������ַ�Ƿ����û�ע��ʱ��д�������ַһ��
		else if(!user.getEmail().equals(email)){
			addFieldError("email", getText("email.notregist"));
			return INPUT;
		}
		
		//�������6λ������
		String newPwd=getRandomPwd();
		//�����û�����
		userService.updatePassword(user.getId(), newPwd);
		//���û��������ú������
		MailParam param=new MailParam();
		param.setUserName("CONTACT");
		param.setPassword("abc123");
		param.setSubject("�һ�����");
		param.setText(user.getUserName()+"��ã������������:"+newPwd+",���ڵ�¼�����и�������");
		
		param.setSender("jcwlxsh@sina.com");
		param.setReceiver(user.getEmail());
		
		//�����ʼ�
		int result=mailService.sendMail(param);
		if(result==1){
			return SUCCESS;
		}
		else{
			return ERROR;
		}

	}
	
	private String getRandomPwd(){
		int min=48;
		int max=122;
		StringBuilder newPwd=new StringBuilder();
		for(int i=1;i<=6;i++){
			int r=(int)(Math.random()*(max-min+1)+min);
			newPwd.append((char)r);
		}
		return newPwd.toString();
	}

	public void setMailService(IMailWebService mailService) {
		this.mailService = mailService;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
}









