package Mailinator;

import javax.mail.*;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

public class MailinatorReader {
    public static void main(String[] args) {
        String host = "imap.mailinator.com"; // Mailinator IMAP server
        String username = "YOUR_INBOX_NAME"; // Replace with your Mailinator inbox name
        String password = "YOUR_INBOX_PASSWORD"; // Leave empty if your Mailinator inbox doesn't have a password

        Properties properties = new Properties();
        properties.put("mail.store.protocol", "imap");
        properties.put("mail.imap.host", host);
        properties.put("mail.imap.port", "993");
        properties.put("mail.imap.ssl.enable", "true");

        try {
            Session session = Session.getDefaultInstance(properties);
            Store store = session.getStore("imap");
            store.connect(host, username, password);

            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);

            Message[] messages = inbox.getMessages();

            for (Message message : messages) {
                System.out.println("Subject: " + message.getSubject());
                System.out.println("From: " + message.getFrom()[0]);
                System.out.println("Date: " + message.getSentDate());
                System.out.println("Content: " + getTextFromMessage(message));
                System.out.println("--------------");
            }

            inbox.close(false);
            store.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getTextFromMessage(Message message) throws Exception {
        if (message.isMimeType("text/plain")) {
            return message.getContent().toString();
        } else if (message.isMimeType("multipart/*")) {
            MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
            return getTextFromMimeMultipart(mimeMultipart);
        }
        return "";
    }

    private static String getTextFromMimeMultipart(MimeMultipart mimeMultipart) throws Exception {
        StringBuilder sb = new StringBuilder();
        int count = mimeMultipart.getCount();
        for (int i = 0; i < count; i++) {
            BodyPart bodyPart = mimeMultipart.getBodyPart(i);
            if (bodyPart.isMimeType("text/plain")) {
                sb.append(bodyPart.getContent());
            } else if (bodyPart.isMimeType("text/html")) {
                String html = (String) bodyPart.getContent();
                sb.append(org.jsoup.Jsoup.parse(html).text()); // Using jsoup library to strip HTML tags
            } else if (bodyPart.getContent() instanceof MimeMultipart) {
                sb.append(getTextFromMimeMultipart((MimeMultipart) bodyPart.getContent()));
            }
        }
        return sb.toString();
    }
}

