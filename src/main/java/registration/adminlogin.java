package registration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class adminregistration
 */
@WebServlet("/adminregistration")
public class adminlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username=request.getParameter("username");
		 
		String password=request.getParameter("password");
		RequestDispatcher dispatcher=null;
try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project2?useSSL=false","root","1357anik");
			PreparedStatement pst=con.prepareStatement("select * from admindet where username=? and password=?");
			//String query="select umail,umobile,utype from userdet";
			pst.setString(1,username);
			pst.setString(2,password);
			
			ResultSet rs=pst.executeQuery();
		
			
			if(rs.next()) {
				//session.setAttribute("uname",rs.getString("username"));
				
				dispatcher =request.getRequestDispatcher("adminhomepage.jsp");
				
				
			}
			else {
				request.setAttribute("status","Failed");
				dispatcher =request.getRequestDispatcher("adminlogin.jsp");
			}
			dispatcher.forward(request, response);
			
			
		}
		catch(Exception e ) {
			
			e.printStackTrace();
		}
	}

}
