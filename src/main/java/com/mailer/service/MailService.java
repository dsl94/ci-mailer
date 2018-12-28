package com.mailer.service;

import com.ci.commons.mail.CiMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private MailContentBuilder mailContentBuilder;

    public void prepareAndSend(CiMail mail) {
        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom(mail.getFrom());
            messageHelper.setTo(mail.getTo());
            messageHelper.setSubject(mail.getSubject());
            String content = mailContentBuilder.build(mail.getTemplate(), mail.getData());
            messageHelper.setText(content, true);
        };

        javaMailSender.send(messagePreparator);
    }
}
