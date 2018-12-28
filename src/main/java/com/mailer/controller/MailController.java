package com.mailer.controller;

import com.ci.commons.error.ErrorMessage;
import com.ci.commons.mail.CiMail;
import com.mailer.error.MailErrorCode;
import com.mailer.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {

    @Autowired
    private MailService mailService;

    @PostMapping("/mail")
    public ResponseEntity sendTestMail(@RequestBody CiMail mail) {
        try {
            mailService.prepareAndSend(mail);
            return ResponseEntity.ok(null);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ErrorMessage(e.getMessage(), MailErrorCode.MAIL_ERROR));
        }
    }
}
