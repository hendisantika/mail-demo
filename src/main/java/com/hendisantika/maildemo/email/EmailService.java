package com.hendisantika.maildemo.email;

import com.hendisantika.maildemo.util.ApplicationLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Created by IntelliJ IDEA.
 * Project : mail-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 04/04/18
 * Time: 06.02
 * To change this template use File | Settings | File Templates.
 */
@Component
public class EmailService {

    private static final ApplicationLogger logger = ApplicationLogger.getInstance();
    @Autowired
    private JavaMailSender mailSender;

    public void send(Email eParams) {

        if (eParams.isHtml()) {
            try {
                sendHtmlMail(eParams);
            } catch (MessagingException e) {
                logger.error("Could not send email to : {} Error = {}", eParams.getToAsList(), e.getMessage());
            }
        } else {
            sendPlainTextMail(eParams);
        }

    }

    private void sendHtmlMail(Email eParams) throws MessagingException {

        boolean isHtml = true;

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setTo(eParams.getTo().toArray(new String[eParams.getTo().size()]));
        helper.setReplyTo(eParams.getFrom());
        helper.setFrom(eParams.getFrom());
        helper.setSubject(eParams.getSubject());
        helper.setText(eParams.getMessage(), isHtml);

        if (eParams.getCc().size() > 0) {
            helper.setCc(eParams.getCc().toArray(new String[eParams.getCc().size()]));
        }

        mailSender.send(message);
    }

    private void sendPlainTextMail(Email eParams) {

        SimpleMailMessage mailMessage = new SimpleMailMessage();

        eParams.getTo().toArray(new String[eParams.getTo().size()]);
        mailMessage.setTo(eParams.getTo().toArray(new String[eParams.getTo().size()]));
        mailMessage.setReplyTo(eParams.getFrom());
        mailMessage.setFrom(eParams.getFrom());
        mailMessage.setSubject(eParams.getSubject());
        mailMessage.setText(eParams.getMessage());

        if (eParams.getCc().size() > 0) {
            mailMessage.setCc(eParams.getCc().toArray(new String[eParams.getCc().size()]));
        }

        mailSender.send(mailMessage);

    }

}