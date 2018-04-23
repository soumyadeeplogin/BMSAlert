

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HallsUpdate
 */
public class HallsUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	HallsList hallslist = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HallsUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("Hello World!");
		processHall(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void processHall(HttpServletRequest request, HttpServletResponse response)
	{
		if(hallslist == null)
			hallslist = new HallsList();
		//hallslist.printHallList();
		Map<String, String[]> params = request.getParameterMap();
		
		for(String hall : params.keySet())
		{
			hallslist.addHalls(hall);
		}
		
		try {
			request.getRequestDispatcher("").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
