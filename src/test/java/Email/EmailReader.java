package Email;

import javax.mail.*;
import java.util.Properties;

public class EmailReader {
    public static void main(String[] args) {
        // Email configuration
        String host = "imap.gmail.com";
        String username = "luluandskyfireflink@gmail.com";
        String password = "hbhjdovhbwlmphvp";
        int port = 993; // IMAP port

        // Connect to the email server
        Properties props = new Properties();
        props.setProperty("mail.store.protocol", "imaps");

        try {
            Session session = Session.getInstance(props, null);
            Store store = session.getStore();
            store.connect(host, port, username, password);

            // Open the inbox folder
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);

            // Get the desired email by message number
            int messageNumber = 1; // Replace with the desired message number
            Message message = inbox.getMessage(messageNumber);

            // Get the content of the email
            Object content = message.getContent();

            if (content instanceof Multipart) {
                Multipart multipart = (Multipart) content;

                for (int i = 0; i < multipart.getCount(); i++) {
                    BodyPart bodyPart = multipart.getBodyPart(i);
                    String bodyPartContent = bodyPart.getContent().toString();
                    System.out.println("Body Part " + (i + 1) + ":\n" + bodyPartContent);
                }
            } else if (content instanceof String) {
                String emailContent = (String) content;
                System.out.println("Email Content:\n" + emailContent);
            }

            // Close the connections
            inbox.close(false);
            store.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
