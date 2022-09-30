package registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class locationtrack
 */
@WebServlet("/locationtrack")
public class locationtrack extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String location=request.getParameter("location");
		Connection con=null;
		try {
           Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project2","root","1357anik");
			Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs=st.executeQuery("select * from userdet natural join donor where location='"+location+"'");
			PrintWriter out=response.getWriter();
			out.print("<h1>User Details</h1>");
			while(rs.next()) {
				String name=rs.getString("username");
				String utype=rs.getString("utype");
				String umail=rs.getString("umail");
				String umobile=rs.getString("umobile");
				String loc=rs.getString("location");
				String Info1=rs.getString("Info1");
				String Info2=rs.getString("Info2");
				out.print("<html>\r\n"
						+ "   <head>\r\n"
						+ "      <style>\r\n"
						+ "         table, th, td {\r\n"
						+ "            border: 1px solid black;\r\n"
						+ "            background : burlywood;\r\n"
						+ "            border-collapse: collapse;\r\n"
						
						+ "         }\r\n"
						+ "      </style>\r\n"
						+ "    \r\n"
						+ "   </head>\r\n"
						+ "\r\n"
						+ "   <body>\r\n"
						
						+ "      <table style=\"width:100%\">\r\n"
						+ "         <tr>\r\n"
						+ "            <th>User name</th>\r\n"
						+ "            <th>User Type</th>\r\n"
						+ "            <th>Mail</th>\r\n"
						+ "            <th>Mobile</th>\r\n"
						+ "            <th>User Location</th>\r\n"
						+ "            <th>Use Donate Info1</th>\r\n"  
						+ "            <th>User Donate Info2</th>\r\n"
						+ "         </tr>\r\n"
						+ "         <tr>\r\n"
						+ "            <td>");
				out.print(name);
				out.print("</td>\r\n"
						+ "            <td>");
				out.print(utype);
				out.print("</td>\r\n"
						+ "            <td>");
				
				out.print(umail);
				out.print("</td>\r\n"
						+ "            <td>");
				out.print(umobile);
				out.print("</td>\r\n"
						+ "            <td>");
				out.print(loc);
				out.print("</td>\r\n"
						+ "            <td>");
				out.print(Info1);
				out.print("</td>\r\n"
						+ "            <td>");
				out.print("N/A");
					  out.print("  </td> </tr>     </table>\r\n"
						+ "   </body>\r\n"
						+ "</html>\r\n"
						+ "");
				/*out.println("User name :: "+name+"	|||"+"|| User type ::"+utype+" |||"+"|| User mail :: "+umail+" |||"+"|| User mobile ::"+umobile+"  |||"+"|| User location ::"+loc);
				out.println("<br></br>");*/
				
			}
			
		}
		catch(Exception e) {
			response.getWriter().println(e);
			
		}
		
	}

}
