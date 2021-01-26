

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		
		out.println("<h1>Product Lookup Service</h1><br>");
		out.println("<form action='' method='POST'>");
		out.println("<label>Enter Product ID: <input type='text' name='prodid'></input></label>");
		out.println("<input type='submit'></input>");
    	out.println("</form>");
		out.println("");
		out.println("");
		
		
		String prodId = req.getParameter("prodid");
		HttpSession session = req.getSession();
		session.setAttribute("prodid", prodId);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String prodId = request.getParameter("prodid");
		
		//TODO: SQL query for prod on DB - print results 
		
		doGet(request, response);
	}

}
