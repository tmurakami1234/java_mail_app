import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.smtp.SMTPTransport;

public class mailSender {

	 public mailSender(String fromAddress,
                    String fromPassword,
                    String toAddress, 
                    String subject,
                    String message) {

		try {
			Properties props = System.getProperties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");

			Session session = Session.getInstance(props);
			Message msg = new MimeMessage(session);

			msg.setFrom(new InternetAddress(fromAddress));

			msg.setRecipients(Message.RecipientType.TO, 
				InternetAddress.parse(toAddress, false));

			msg.setSubject(subject);

			msg.setText(message);

			msg.setSentDate(new Date());

			SMTPTransport t = (SMTPTransport) session.getTransport("smtp");
			try {
				t.connect("smtp.gmail.com", fromAddress, fromPassword);
				t.sendMessage(msg, msg.getAllRecipients());
			} finally {
				t.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
