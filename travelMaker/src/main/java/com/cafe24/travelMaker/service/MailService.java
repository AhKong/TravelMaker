package com.cafe24.travelMaker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import com.cafe24.travelMaker.config.MailHandler;
import com.cafe24.travelMaker.domain.Mail;

@Service
public class MailService {

	@Autowired private JavaMailSender mailSender;
    private static final String FROM_ADDRESS = "devahkong@gmail.com";

    public void sendMail(Mail mail) {
        try {
            MailHandler mailHandler = new MailHandler(mailSender);

            // 받는 사람
            mailHandler.setTo(mail.getAddress());
            // 보내는 사람
            mailHandler.setFrom(MailService.FROM_ADDRESS);
            // 제목
            mailHandler.setSubject(mail.getTitle());
            // HTML Layout
           
            mailHandler.setText(mail.getMessage());
            
            mailHandler.send();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
