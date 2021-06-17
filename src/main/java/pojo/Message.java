package pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Message {
    @JsonProperty("subject")
    private String subject;

    @JsonProperty("messageBody")
    private String messageBody;

    @JsonProperty("messageSearchText")
    private String messageSearchText;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    public String getMessageSearchText() {
        return messageSearchText;
    }

    public void setMessageSearchText(String messageSearchText) {
        this.messageSearchText = messageSearchText;
    }

    @Override
    public String toString() {
        return "Message{" +
                "subject='" + subject + '\'' +
                ", messageBody='" + messageBody + '\'' +
                ", messageSearchText='" + messageSearchText + '\'' +
                '}';
    }
}
