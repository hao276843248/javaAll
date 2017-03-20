package cn.bdqn.mail.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface IMailWebService {
	
	@WebMethod
	public int sendMail(MailParam mailParam);
}
