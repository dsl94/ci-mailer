package com.mailer.service;

import com.ci.commons.mail.MailData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.List;
import java.util.Map;

@Service
public class MailContentBuilder {

    @Autowired
    private TemplateEngine templateEngine;

    public String build(String template, List<MailData> data) {
        Context context = new Context();
        for (MailData entry : data) {
            context.setVariable(entry.getKey(), entry.getValue());
        }
        return templateEngine.process(template, context);
    }

}
