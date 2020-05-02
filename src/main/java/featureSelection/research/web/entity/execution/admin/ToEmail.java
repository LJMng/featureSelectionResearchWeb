package featureSelection.research.web.entity.execution.admin;

import java.io.Serializable;

public class ToEmail implements Serializable {
    public String toAccount;
    private String subject;
    private String Content;

    public ToEmail(String toAccount, String subject, String content) {
        this.toAccount = toAccount;
        this.subject = subject;
        Content = content;
    }

    public ToEmail() {
    }

    public String getToAccount() {
        return toAccount;
    }

    public void setToAccount(String toAccount) {
        this.toAccount = toAccount;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    @Override
    public String toString() {
        return "ToEmail{" +
                "toAccount='" + toAccount + '\'' +
                ", subject='" + subject + '\'' +
                ", Content='" + Content + '\'' +
                '}';
    }
}
