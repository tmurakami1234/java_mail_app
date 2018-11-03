import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.smtp.SMTPTransport;

public class mailSender {
	public static void main(String args[]) {
          String title,message,destination,youraddress,yourpassword;
          title = "test title";
          message = "test message";
          destination = "room.seven.one.four@gmail.com";
          youraddress = "room.seven.one.four@gmail.com";
          yourpassword = "hukuzatsukei714room";
          mailSend(title,message,destination,youraddress,yourpassword);
	}

	public static void mailSend(String title, String text, String toAddress, 
		String fromAddress, String password) {

		try {
			// プロパティの設定
			Properties props = System.getProperties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");

			Session session = Session.getInstance(props);
			Message msg = new MimeMessage(session);

			// 送信元メールアドレスのセット
			msg.setFrom(new InternetAddress(fromAddress));

			// 送信先メールアドレスのセット
			msg.setRecipients(Message.RecipientType.TO, 
				InternetAddress.parse(toAddress, false));

			// メールタイトル
			msg.setSubject(title);

			// メール本文
			msg.setText(text);

			// 送信日
			msg.setSentDate(new Date());

			// メール送信
			SMTPTransport t = (SMTPTransport) session.getTransport("smtp");
			try {
				t.connect("smtp.gmail.com", fromAddress, password);
				t.sendMessage(msg, msg.getAllRecipients());
			} finally {
				t.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
