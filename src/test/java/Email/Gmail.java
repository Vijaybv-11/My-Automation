package Email;

import javax.mail.*;
import java.io.IOException;
import java.util.Properties;

public class Gmail {

    public static void main(String[] args) throws MessagingException, InterruptedException, IOException {

        String host = "smtp.gmail.com";
        String userName = "luluandskyfireflink@gmail.com";
        String password = "hbhjdovhbwlmphvp";
        String emailId = "info@fireflink.com";

        Properties props = new Properties();
        props.put("mail.imap.host", host);
        props.put("mail.imap.port", "993");
        props.put("mail.imap.starttls.enable", "true");
        props.put("mail.imap.ssl.trust", host);

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        });

        try {
            Store store = session.getStore("imaps");
            store.connect(host, userName, password);

            Folder folder = store.getFolder("INBOX");
            folder.open(Folder.READ_ONLY);

            Message[] messages = folder.getMessages();
            for (Message message : messages) {
                if (message.getHeader("Message-ID")[0].contains(emailId)) {
                    System.out.println("Subject: " + message.getSubject());
                    System.out.println("From: " + message.getFrom()[0]);
                    System.out.println("To: " + message.getAllRecipients()[0]);
                    System.out.println("Text: " + message.getContentType().toString());
                    System.out.println("Sent Date: " + message.getSentDate());
                    break;
                }
            }

            folder.close(false);
            store.close();
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}