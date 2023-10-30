package Email;

import javax.mail.*;
import java.util.Properties;

public class JavaMailAPIDemo {
    public static void main(String[] args) {
        String host = "imap.gmail.com";
        String username = "luluandskyfireflink@gmail.com";
        String password = "hbhjdovhbwlmphvp";
        String emailId = "no-reply@arrka.com";

        Properties props = new Properties();
        props.put("mail.imap.host", host);
        props.put("mail.imap.port", "993");
        props.put("mail.imap.ssl.enable", "true");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Store store = session.getStore("imap");
            store.connect(host, username, password);

            Folder folder = store.getFolder("INBOX");
            folder.open(Folder.READ_ONLY);

            Message[] messages = folder.getMessages();
            for (Message message : messages) {
                if (message.getHeader("Message-ID")[0].contains(emailId)) {
                    Object content = message.getContent();
                    if (content instanceof Multipart) {
                        Multipart multipart = (Multipart) content;
                        for (int i = 0; i < multipart.getCount(); i++) {
                            BodyPart bodyPart = multipart.getBodyPart(i);
                            if (bodyPart.isMimeType("text/html")) {
                                String body = (String) bodyPart.getContent();
                                System.out.println("Email Body (HTML):");
                                System.out.println(body);
                                break;
                            }
                        }
                    } else if (content instanceof String) {
                        String body = (String) content;
                        System.out.println("Email Body (Plain Text):");
                        System.out.println(body);
                    }
                    break;
                }
            }

            folder.close(false);
            store.close();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
