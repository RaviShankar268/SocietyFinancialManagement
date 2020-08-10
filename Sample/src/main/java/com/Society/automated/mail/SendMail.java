package com.Society.automated.mail;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.Society.automated.mail.database.SendMailDao;
import com.Society.automated.report.Report;

/*
 * THIS CLASS IS FOR SENDING MAIL
 */
public class SendMail {
	final static Logger logger=LoggerFactory.getLogger(SendMail.class);
	
	public void mail() throws MessagingException, IOException
	{
		Properties properties=new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		String myAccount="okaytestmail@gmail.com";
		String password="societyapp";
		Session session=Session.getInstance(properties,new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication()
			{
				return new PasswordAuthentication(myAccount,password);
			}
		});
		SendMailDao sendmaildao=new SendMailDao();
		int count=sendmaildao.count();
		String apt_id="";
		String mail_id="";
		for(int i=0;i<count;i++)
		{
			String name=sendmaildao.IdnMail();
			String[] s=name.split(" ");
			apt_id=s[0];
			mail_id=s[1];
			if(sendmaildao.Checkrequest(apt_id))
			{
				String recipient=mail_id;
				Message message=prepareMessage(session,myAccount,recipient,apt_id);
				Transport.send(message);
				logger.info("MAIL SENT FOR : {}",apt_id);
				sendmaildao.setSent(apt_id);
			}
			else
			{
				
			}
		}

	}
	public static Message prepareMessage(Session session,String myAccount,String recipient,String apt_id) throws IOException
	{
		Message message=new MimeMessage(session);
		Report rp=new Report();
		try {
			message.setFrom(new InternetAddress(myAccount));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
			message.setSubject("REMINDER");
			String name=rp.generate(apt_id);
			Multipart emailcontent=new MimeMultipart();
			MimeBodyPart textbodypart=new MimeBodyPart();
			textbodypart.setText("MONTHLY CHARGES");
			MimeBodyPart pdfAttachment=new MimeBodyPart();
			pdfAttachment.attachFile("d:/scripts/"+name);
			emailcontent.addBodyPart(textbodypart);
			emailcontent.addBodyPart(pdfAttachment);
			message.setContent(emailcontent);
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}

}
