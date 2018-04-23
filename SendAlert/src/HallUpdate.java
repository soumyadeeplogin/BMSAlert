

import java.io.IOException;
import java.util.Map;
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
 * Servlet implementation class HallUpdate
 */
public class HallUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HallUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		Map<String, String[]> param = request.getParameterMap();
		if(param.size()>0)
		for(String hall : param.keySet())
		{
			sendMailAlert(hall);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void sendMailAlert(String hall) {
		
		final String username = "<user a gmail account>";
		final String password = "<user the password>";
		String from = username; // change accordingly

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

		// compose the message
		try {
			
			Address[] address = {new InternetAddress("<email>@gmail.com"), 
					new InternetAddress("<email>@gmail.com"), 
					new InternetAddress("<email>@gmail.com"), 
					new InternetAddress("<email>@outlook.in"),
					new InternetAddress("<email>@gmail.com")};
			//Address[] address = {new InternetAddress("soumyadeeplogin@gmail.com")};
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipients(Message.RecipientType.TO, address);
			message.setSubject("Hall Alert - "+ hall);
			message.setText("Tickets for Avenger: Infinity War is now available at " + hall);

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
