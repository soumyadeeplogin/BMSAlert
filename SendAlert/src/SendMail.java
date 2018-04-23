
import java.io.IOException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SendMail
 */
public class SendMail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SendMail() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("Chekcing alert");
		request.getSession();
		sendMailAlert();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void sendMailAlert() {
		// String smtpHostServer = "smtp-na.opentext.com";
		// String emailID = "sroy@opentext.com";
		
		final String username = "guineapigvlog@gmail.com";
		//final String password = "xklwzzlkkvmnkfcu";
		final String password = "S0umyad33pl0g!n";


		String to = "soumyadeeplogin@gmail.com";// change accordingly
		String from = "soumyadeeplogin@gmail.com";// change accordingly
		 
		//String host = "smtp-na.opentext.com";// or IP address

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		//Session session = Session.getDefaultInstance(properties);
		
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		// compose the message
		try {
			
			/*Address[] address = {new InternetAddress("soumyadeeplogin@gmail.com"), 
					new InternetAddress("Rathore.amrsingh@gmail.com"), 
					new InternetAddress("rahul726224@gmail.com"), 
					new InternetAddress("amarsingh@outlook.in"),
					new InternetAddress("abhishek.cp.11@gmail.com")};*/
			Address[] address = {new InternetAddress("soumyadeeplogin@gmail.com")};
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipients(Message.RecipientType.TO, address);
			message.setSubject("Ticket Alert:: Avenger: Infinity War");
			message.setText("Tickets for Avenger: Infinity War is now available at Hyderabad. -Soumyadeep Roy");

			// Send message
			Transport.send(message);
			System.out.println("Alert delivered");

		} catch (MessagingException mex) {
			mex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
