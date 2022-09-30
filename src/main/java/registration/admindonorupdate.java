package registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/admindonorupdate")
public class admindonorupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("name");
		String Info2=request.getParameter("organ");
		Connection con=null;
		//PrintWriter out=response.getWriter();
		//HttpSession session=request.getSession();
		try {
             Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project2","root","1357anik");
			//PreparedStatement pst=con.prepareStatement("update userdet set  umail='"+umail+"' where username='"+username+"'");
			 java.sql.Statement st=null;
			 ResultSet rs=null;
			 PreparedStatement pst=null;
		    //RequestDispatcher dispatcher=null;
		    st=con.createStatement();
		    pst=con.prepareStatement("update donor set Info2=? where username='"+username+"'");
		    pst.setString(1,Info2);
		    
		    RequestDispatcher dispatcher=null;
		    pst.executeUpdate();
		    dispatcher=request.getRequestDispatcher("admindonnorupdate.jsp");
		    request.setAttribute("status","Success");
		    dispatcher.forward(request, response);	
		    }
		   
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
