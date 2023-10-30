package Email;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import java.util.Properties;

public class DeleteEmailsFromSender {
    public static void main(String[] args) {
        // Email account configuration
        String username = "luluandskyfireflink@gmail.com";
        String password = "hbhjdovhbwlmphvp";
        String host = "imap.gmail.com"; // IMAP server for receiving emails
        String targetSender = "vijay.bv@fireflink.com"; // Email address to filter by

        // Set the properties
        Properties properties = new Properties();
        properties.setProperty("mail.store.protocol", "imap");
        properties.setProperty("mail.imap.host", host);
        properties.setProperty("mail.imap.port", "993"); // IMAP SSL port
        properties.setProperty("mail.imap.ssl.enable", "true");

        try {
            // Create a session
            Session session = Session.getDefaultInstance(properties);

            // Connect to the email server
            Store store = session.getStore();
            store.connect(username, password);

            // Open the inbox folder
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_WRITE);

            // Fetch and delete emails from the target sender
            Message[] messages = inbox.getMessages(); // Fetch all emails in the inbox

            // Iterate through messages and delete those from the target sender
            for (Message message : messages) {
                String sender = message.getFrom()[0].toString();
                if (sender.contains(targetSender)) {
                    message.setFlag(javax.mail.Flags.Flag.DELETED, true);
                }
            }

            // Expunge the folder to permanently delete flagged messages
            inbox.expunge();

            // Close the folder and store
            inbox.close(true);
            store.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
