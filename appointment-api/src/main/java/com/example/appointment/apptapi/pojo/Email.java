package com.example.appointment.apptapi.pojo;

public class Email {
    private String recipient;
    private String msgBody;
    private String subject;
    

    public Email() {
    }

    public Email(String recipient, String msgBody, String subject) {
        this.recipient = recipient;
        this.msgBody = msgBody;
        this.subject = subject;    
    }

    /**
     * 
     * @return
     */
    public String getRecipient() {
        return recipient;
    }

    /**
     * 
     * @param recipient
     */
    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    /**
     * 
     * @return
     */
    public String getMsgBody() {
        return msgBody;
    }

    public void setMsgBody(String msgBody) {
        this.msgBody = msgBody;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Email [recipient=" + recipient + ", msgBody=" + msgBody + ", subject=" + subject + "]";
    }


}
