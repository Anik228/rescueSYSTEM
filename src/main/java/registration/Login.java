package registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Base64;
import java.util.Base64.Encoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username=request.getParameter("username");
	 
		String password=request.getParameter("password");
		RequestDispatcher dispatcher=null;
		 if(username==null) {
			  dispatcher =request.getRequestDispatcher("index.jsp");
	 
		  }
		Encoder encoder=Base64.getEncoder();
		String encrypt=encoder.encodeToString(password.getBytes());
		
		
		
		PrintWriter out=response.getWriter();
		out.println(username);
		//Connection con=null;
		HttpSession session=request.getSession();
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project2?useSSL=false","root","1357anik");
			PreparedStatement pst=con.prepareStatement("select * from userdet where username=? and password=?");
			//String query="select umail,umobile,utype from userdet";
			pst.setString(1,username);
			pst.setString(2,encrypt);
			PreparedStatement pst1=con.prepareStatement("select umail,umobile,utype,location from userdet where username='"+username+"'");
			PreparedStatement pst2=con.prepareStatement("select Info1 from donor where username='"+username+"'");//add
			
			ResultSet rs=pst.executeQuery();
			ResultSet rs1=pst1.executeQuery();
			
			ResultSet rs2=pst2.executeQuery();//add
			
			if(rs.next()) {
				session.setAttribute("uname",rs.getString("username"));
				
				dispatcher =request.getRequestDispatcher("index.jsp");
				if(rs1.next()) {
					String umail=rs1.getString("umail");
					String umobile=rs1.getString("umobile");
					String utype=rs1.getString("utype");
					String location=rs1.getString("location");
					if(rs2.next()) {//add
						
						String Info1=rs2.getString("Info1");
						session.setAttribute("info1",Info1);
					}
					
					session.setAttribute("mail",umail);
					session.setAttribute("mobile",umobile);
					session.setAttribute("type",utype);
					session.setAttribute("location",location);
				}
				
			}
			else {
				request.setAttribute("status","Failed");
				dispatcher =request.getRequestDispatcher("login.jsp");
			}
			dispatcher.forward(request, response);
			
			
		}
		catch(Exception e ) {
			
			e.printStackTrace();
		}
	}

}
