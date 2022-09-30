package registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import java.util.*;

/**
 * Servlet implementation class registrationServlet
 */
@WebServlet("/register")
public class registrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		String username=request.getParameter("name");
		String utype=request.getParameter("utype");
		String umail=request.getParameter("email");
		String password=request.getParameter("pass");
		int len=password.length();
		Encoder encoder=Base64.getEncoder();
		String encrypt=encoder.encodeToString(password.getBytes());
		
	
		
		//password decryption code need to be added
		
		String umobile=request.getParameter("contact");
		
		String location=request.getParameter("location");
		
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project2?useSSL=false","root","1357anik");
			PreparedStatement pst=con.prepareStatement("insert into userdet(username,password,umail,umobile,utype,location) values(?,?,?,?,?,?)");
			Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs=st.executeQuery("select * from userdet where umail='"+umail+"'");
			pst.setString(1, username);
		    pst.setString(2,encrypt);
		    pst.setString(3, umail);
		    pst.setString(4, umobile);
		    pst.setString(5, utype);
		    pst.setString(6, location);
		    RequestDispatcher dispatcher=null;
		 
		    
		    int rowCount = 0;
		    dispatcher=request.getRequestDispatcher("registration.jsp");
		    
		    if(len<4) {
		    	request.setAttribute("status","Failed");
		   
		    }
		    else if(rs.next()) {
		    	request.setAttribute("status","failed");
		   
		    }
		    else {
		    	 rowCount=pst.executeUpdate();
		    	
		    }
		    /*
		     if(len>4){
		     rowCount=pst.executeUpdate();
		     }
		     else{
		     request.setAttribute("status","Failed");
		     }*/
		    
		  
		  
		    
		    if(rowCount>0) {
				
				   /*  String emialRegex="^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
				     Pattern pattern=Pattern.compile(emialRegex);
				     if(umail==null || umail.isEmpty()){
						 request.setAttribute("status","Failed");
					     }
				     else if(pattern.matcher(umail).matches()){
				    	 request.setAttribute("status","Success");
				     }
				     else{
				    	 request.setAttribute("status","Failed");
				     }*/
		    	
		    	request.setAttribute("status","Success");
		    	
		    }
		    else {
		    
		   // request.setAttribute("status","Failed");
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
