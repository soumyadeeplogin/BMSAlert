import java.util.HashMap;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class HallsList {
	HashMap<String, Integer> halls;
	
	public HallsList(){
		halls = new  HashMap<>();
	}
	
	public void printHallList()
	{
		if(!halls.isEmpty())
			for(String s:halls.keySet())
				System.out.println(halls.get(s));
	}
	
	public void addHalls(String hall)
	{
		if(!halls.containsKey(hall))
		{
			halls.put(hall, 1);
			sendAlert(hall);
		} else {
			System.out.println("Hall " + hall + " already exists");
		}
	}
	
	public void sendAlert(String hallName)
	{
		final String username = "guineapigvlog@gmail.com";
		final String password = "S0umyad33pl0g!n";

		String from = username;
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			
			Address[] address = {new InternetAddress("soumyadeeplogin@gmail.com"), 
					new InternetAddress("Rathore.amrsingh@gmail.com"), 
					new InternetAddress("rahul726224@gmail.com"), 
					new InternetAddress("amarsingh@outlook.in"),
					new InternetAddress("abhishek.cp.11@gmail.com")};
			
			//Address[] address = {new InternetAddress("soumyadeeplogin@gmail.com")};
			
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipients(Message.RecipientType.TO, address);
			message.setSubject("Avenger: Infinity War - Hall Added");
			message.setText("The hall " + hallName + " is now available for booking.");

			// Send message
			//Transport.send(message);
			System.out.println("Alert delivered :- The hall " + hallName + " is now available for booking.");

		} catch (MessagingException mex) {
			mex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
