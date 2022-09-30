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

/**
 * Servlet implementation class donnarinfo
 */
@WebServlet("/donnarinfo")
public class donnarinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	String username=request.getParameter("name");
	String Info1=request.getParameter("blood");
	String Info2="N/A";
	Connection con=null;
	PrintWriter out=response.getWriter();
	HttpSession session=request.getSession();
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project2?useSSL=false","root","1357anik");
		PreparedStatement pst=con.prepareStatement("insert into donor(username,Info1,Info2) values(?,?,?)");
		Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		pst.setString(1, username);
		
	    pst.setString(2,Info1);
	    pst.setString(3,Info2);
	    int rowCount = 0;
	    RequestDispatcher dispatcher=null;
	    PreparedStatement pst1=con.prepareStatement("select Info1 from donor where username='"+username+"'");
	   
	   
	    
	    	 rowCount=pst.executeUpdate();
	    	 
	    	 ResultSet rs=pst1.executeQuery();
	    	// session.setAttribute("info1",rs.getString("Info1"));
	    	 dispatcher=request.getRequestDispatcher("adddonnorinformation.jsp");
	    	
			    if(rowCount>0) {
					
			    	request.setAttribute("status","Success");
			    	
			    }
			    else {
			    
			     request.setAttribute("status","Failed");
			    }
			    
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


