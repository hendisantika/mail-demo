package com.hendisantika.maildemo.email;

import com.hendisantika.maildemo.util.AppUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : mail-demo
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 04/04/18
 * Time: 06.01
 * To change this template use File | Settings | File Templates.
 */
public class Email {
    private String from;

    private List<String> to;

    private List<String> cc;

    private String subject;

    private String message;

    private boolean isHtml;

    public Email() {
        this.to = new ArrayList<String>();
        this.cc = new ArrayList<String>();
    }

    public Email(String from, String toList, String subject, String message) {
        this();
        this.from = from;
        this.subject = subject;
        this.message = message;
        this.to.addAll(Arrays.asList(splitByComma(toList)));
    }

    public Email(String from, String toList, String ccList, String subject, String message) {
        this();
        this.from = from;
        this.subject = subject;
        this.message = message;
        this.to.addAll(Arrays.asList(splitByComma(toList)));
        this.cc.addAll(Arrays.asList(splitByComma(ccList)));
    }

    /**
     * @return the from
     */
    public String getFrom() {
        return from;
    }

    /**
     * @param from the from to set
     */
    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * @return the to
     */
    public List<String> getTo() {
        return to;
    }

    /**
     * @param to the to to set
     */
    public void setTo(List<String> to) {
        this.to = to;
    }

    /**
     * @return the cc
     */
    public List<String> getCc() {
        return cc;
    }

    /**
     * @param cc the cc to set
     */
    public void setCc(List<String> cc) {
        this.cc = cc;
    }

    /**
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the isHtml
     */
    public boolean isHtml() {
        return isHtml;
    }

    /**
     * @param isHtml the isHtml to set
     */
    public void setHtml(boolean isHtml) {
        this.isHtml = isHtml;
    }

    private String[] splitByComma(String toMultiple) {
        String[] toSplit = toMultiple.split(",");
        return toSplit;
    }

    public String getToAsList() {
        return AppUtil.concatenate(this.to, ",");
    }
}
