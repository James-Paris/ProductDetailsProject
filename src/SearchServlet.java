

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

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
	
	public static final String url = "jdbc:mysql://localhost:3306/simplilearn?createDatabaseIfNotExist=true";
	public static final String user = "root";
	public static final String pass = "";

	private Class<?> forName;
	
       
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
		
		String search = "select * from ecommerce where prodId =";
		
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
		String search = "select * from ecommerce where productId = " + prodId;
		System.out.println("Checkpoint");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			
			if(con != null) {
				System.out.println("[SQL] Connection Successful.");
				
				try(Statement stmnt = con.createStatement()) {
					ResultSet rs = stmnt.executeQuery(search);
					
					while(rs.next()) {
						System.out.println("Res: " + rs.getString("productName"));
					}
					
					
				}
				
				
			} else {
				System.out.println("[SQL] Failed to connect to database.");
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		//TODO: SQL query for prod on DB - print results 
		
		doGet(request, response);
	}

}
