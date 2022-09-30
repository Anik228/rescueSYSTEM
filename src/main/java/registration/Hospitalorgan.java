package registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Hospitalorgan")
public class Hospitalorgan extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username=request.getParameter("name");
		 
		String password=request.getParameter("password");
		String info="N/A";
		int no=1;
		RequestDispatcher dispatcher=null;
		
		HttpSession session=request.getSession();
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project2?useSSL=false","root","1357anik");
			PreparedStatement pst=con.prepareStatement("select * from idpassnew where Id=? and pass=?");
			
			pst.setString(1,username);
			pst.setString(2,password);
			
			ResultSet rs=pst.executeQuery();
			/*username="123";
			password="456";*/
			int arr[]=new int[10];
			for(int i=0;i<3;i++) {
		    arr[i] = (int)Math.floor(Math.random()*(10-0+1)+0);
			}
			int arr1[]=new int[10];
			for(int i=0;i<3;i++) {
		    arr1[i] = (int)Math.floor(Math.random()*(10-0+1)+0);
			}
			username=String.valueOf(arr);
			password=String.valueOf(arr1);
			
			
			
			
			
			
			PreparedStatement pst1=con.prepareStatement("update idpassnew set Id=?,  pass=? where No='"+no+"'");
			   pst1.setString(1, username);
			    pst1.setString(2, password);
			    pst1.executeUpdate();
			if(rs.next()) {
				Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
				ResultSet rs1=st.executeQuery("select name, or1,or2,or3 from hospitaldet");
				PrintWriter out=response.getWriter();
				out.print("<h1>Hospital orgran Details</h1>");
				while(rs1.next()) {
					String name=rs1.getString("name");
					/*String utype=rs.getString("utype");
					String umail=rs.getString("umail");
					String umobile=rs.getString("umobile");
					String loc=rs.getString("location");
					String Info1=rs.getString("Info1");*/
					String or1=rs1.getString("or1");
					String or2=rs1.getString("or2");
					String or3=rs1.getString("or3");
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
							+ "            <th>Hospital name</th>\r\n"
							+ "            <th>Organ 1</th>\r\n"
							+ "            <th>Organ 2</th>\r\n"
							+ "            <th>Organ 3</th>\r\n"
							
							+ "         </tr>\r\n"
							+ "         <tr>\r\n"
							+ "            <td>");
					out.print(name);
					out.print("</td>\r\n"
							+ "            <td>");
					out.print(or1);
					out.print("</td>\r\n"
							+ "            <td>");
					
					out.print(or2);
					out.print("</td>\r\n"
							+ "            <td>");
					out.print(or3);
					/*out.print("</td>\r\n"
							+ "            <td>");
					//out.print(loc);
					out.print("</td>\r\n"
							+ "            <td>");
					//out.print(Info1);
					out.print("</td>\r\n"
							+ "            <td>");
					out.print(Info2);*/
						  out.print("  </td> </tr>     </table>\r\n"
							+ "   </body>\r\n"
							+ "</html>\r\n"
							+ "");
					/*out.println("User name :: "+name+"	|||"+"|| User type ::"+utype+" |||"+"|| User mail :: "+umail+" |||"+"|| User mobile ::"+umobile+"  |||"+"|| User location ::"+loc);
					out.println("<br></br>");*/
					
				}
				
				
				
				}
				
			
			else {
				request.setAttribute("status","Failed");
				dispatcher =request.getRequestDispatcher("Hospitalorganlist.jsp");
			}
			dispatcher.forward(request, response);
			
			
		}
		catch(Exception e ) {
			
			e.printStackTrace();
		}
	}
		
	


	}


