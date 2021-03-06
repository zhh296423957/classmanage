package com.test.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/******************************************************************************
 * @Package:      [.MailSendUtils.java]  
 * @ClassName:    [MailSendUtils]   
 * @Description:  []   
 * @Author:       [kundian.huo]   
 * @CreateDate:   [2014-2-24 上午10:29:05]   
 * @UpdateUser:   [kundian.huo(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateDate:   [2014-2-24 上午10:29:05，(如多次修改保留历史记录，增加修改记录)]   
 * @UpdateRemark: [说明本次修改内容,(如多次修改保留历史记录，增加修改记录)]  
 * @Version:      [v1.0] 
 */

public class MailSendUtils {

	public static void sendHtmlMail(MailInfo info)throws Exception{
		Message message = getMessage(info);
		message.setContent(info.getContent(), "text/html;charset=utf-8");
		Transport.send(message);
	}
	
	public static void sendTextMail(MailInfo info)throws Exception{
		info.setHost("smtp.163.com");
		info.setFormName("zhhandwangyi@163.com");
		info.setFormPassword("zhh15623790232");   //网易邮箱的授权码~不一定是密码
		info.setReplayAddress("zhhandwangyi@163.com");
		info.setSubject("酷开开发者平台");
		System.out.println("info");
		Message message = getMessage(info);
		message.setText(info.getContent());
		Transport.send(message);
	}
	
	private static Message getMessage(MailInfo info) throws Exception{
		final Properties  p = System.getProperties() ;
		p.setProperty("mail.smtp.host", info.getHost());
		p.setProperty("mail.smtp.auth", "true");
		p.setProperty("mail.smtp.user", info.getFormName());
		p.setProperty("mail.smtp.pass", info.getFormPassword());
		
		Session session = Session.getInstance(p, new Authenticator(){
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(p.getProperty("mail.smtp.user"),p.getProperty("mail.smtp.pass"));
			}
		});
		session.setDebug(true);
		Message message = new MimeMessage(session);
		message.setSubject(info.getSubject());
		message.setReplyTo(InternetAddress.parse(info.getReplayAddress()));
		message.setFrom(new InternetAddress(p.getProperty("mail.smtp.user"),"张宏浩"));
		message.setRecipient(RecipientType.TO,new InternetAddress(info.getToAddress()));
		
		return message ;
	}
	
	public static void main(String[] args) throws Exception{
		MailInfo info = new MailInfo();
		info.setToAddress("296423957@qq.com");

		info.setContent("这是一封测试邮件");
		sendTextMail(info);
	}
}
