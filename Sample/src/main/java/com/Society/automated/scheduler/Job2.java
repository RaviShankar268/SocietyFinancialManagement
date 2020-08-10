package com.Society.automated.scheduler;

import java.io.IOException;

import javax.mail.MessagingException;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.Society.automated.allwork.ConvetDao;
import com.Society.automated.mail.SendMail;


public class Job2 implements Job{

	final static Logger logger=LoggerFactory.getLogger(Job2.class);
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		ConvetDao cd=new ConvetDao();
		
		System.out.println("INSIDE MAIL");
		try {
			if(!cd.checkMailDate())
			{
			SendMail sd=new SendMail();
			cd.changeStatus();
			sd.mail();
			//System.out.println("ONE FUNCTION OVER");
			cd.umail();
			logger.info("MAIL SCHEDULING OVER");
			}
			else
			{
				logger.info("MAILS SENT ALREADY");
				//System.out.println("ALREADY SENT");
			}
		} catch (MessagingException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
