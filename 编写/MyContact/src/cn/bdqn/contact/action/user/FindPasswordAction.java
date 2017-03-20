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
		//根据用户名查找用户对象
		User user=userService.getUser(userName);
		
		if(user==null){
			addFieldError("userName",getText("username.invalid"));
			return INPUT;
		}
		//判断提交的邮箱地址是否与用户注册时填写的邮箱地址一致
		else if(!user.getEmail().equals(email)){
			addFieldError("email", getText("email.notregist"));
			return INPUT;
		}
		
		//随机生成6位新密码
		String newPwd=getRandomPwd();
		//重置用户密码
		userService.updatePassword(user.getId(), newPwd);
		//向用户发送重置后的密码
		MailParam param=new MailParam();
		param.setUserName("CONTACT");
		param.setPassword("abc123");
		param.setSubject("找回密码");
		param.setText(user.getUserName()+"你好，你的新密码是:"+newPwd+",请在登录后自行更新密码");
		
		param.setSender("jcwlxsh@sina.com");
		param.setReceiver(user.getEmail());
		
		//发送邮件
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









