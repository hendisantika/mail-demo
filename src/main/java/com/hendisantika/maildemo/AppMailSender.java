package com.hendisantika.maildemo;

import com.hendisantika.maildemo.email.Email;
import com.hendisantika.maildemo.email.EmailService;
import com.hendisantika.maildemo.email.EmailTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * Project : mail-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 04/04/18
 * Time: 06.06
 * To change this template use File | Settings | File Templates.
 */
@Component
public class AppMailSender implements ApplicationRunner {

    @Autowired
    EmailService emailService;

    @Override
    public void run(ApplicationArguments args) {

        sendHtmltMail();
        sendTextMail();

    }

    private void sendTextMail() {

        String from = "hendisantika@localhost";
        String to = "hendisantika@yahoo.co.id";
        String subject = "Java Mail with Spring Boot - Plain Text";

        EmailTemplate template = new EmailTemplate("hello-world-plain.txt");

        Map<String, String> replacements = new HashMap<String, String>();
        replacements.put("user", "Hendi Santika");
        replacements.put("today", String.valueOf(new Date()));

        String message = template.getTemplate(replacements);

        Email email = new Email(from, to, subject, message);

        emailService.send(email);
    }

    private void sendHtmltMail() {


        String from = "hendisantika@localhost";
        String to = "hendisantika@yahoo.co.id";
        String subject = "Java Mail with Spring Boot";

        EmailTemplate template = new EmailTemplate("hello-world.html");

        Map<String, String> replacements = new HashMap<String, String>();
        replacements.put("user", "Hendi Santika");
        replacements.put("today", String.valueOf(new Date()));

        String message = template.getTemplate(replacements);

        Email email = new Email(from, to, subject, message);
        email.setHtml(true);
        emailService.send(email);
    }

}