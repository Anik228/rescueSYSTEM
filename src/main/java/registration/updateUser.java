package registration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.xdevapi.Statement;

/**
 * Servlet implementation class updateUser
 */
@WebServlet("/update")
public class updateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("name");
		String utype=request.getParameter("utype");
		String umail=request.getParameter("email");
		String umobile=request.getParameter("mobile");
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project2","root","1357anik");
			//PreparedStatement pst=con.prepareStatement("update userdet set  umail='"+umail+"' where username='"+username+"'");
			 java.sql.Statement st=null;
			 ResultSet rs=null;
			 PreparedStatement pst=null;
		    //RequestDispatcher dispatcher=null;
		    st=con.createStatement();
		    pst=con.prepareStatement("update userdet set utype=?,  umail=?, umobile=? where username='"+username+"'");
		    pst.setString(1, utype);
		    pst.setString(2, umail);
		    pst.setString(3, umobile);
		    RequestDispatcher dispatcher=null;
		    pst.executeUpdate();
		    dispatcher=request.getRequestDispatcher("profilenew.jsp");
		    request.setAttribute("status","Success");
		    //response.getWriter().println(username);
		    //dispatcher=request.getRequestDispatcher("registration.jsp");
		   /*if(rowCount>0) {
				
		    	
		    	request.setAttribute("status","Success");
		    	dispatcher =request.getRequestDispatcher("try1.jsp");
		    	
		    }
		    else {
		    	dispatcher =request.getRequestDispatcher("login.jsp");
		    request.setAttribute("status","Failed");
		    }
		    */
		   // dispatcher.forward(request, response);
		    dispatcher.forward(request, response); 
	}
		catch(Exception e)
		{
			//response.getWriter().println(e);
		     request.setAttribute("status","Failed");
			e.printStackTrace();
			
		}
		

}
}
