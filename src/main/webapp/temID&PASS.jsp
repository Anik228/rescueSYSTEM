


<%@ page import="java.util.* , java.io.IOException , java.io.PrintWriter,java.sql.*,javax.servlet.*"%>
<!DOCTYPE html>    
<html>    
<head>    
    <title>Login Form</title>    
    
    <style>
    body  
{  
    margin: 0;  
    padding: 0;  
    background-color:#6abadeba;  
    font-family: 'Arial';  
}  
.login{  
        width: 382px;  
        overflow: hidden;  
        margin: auto;  
        margin: 20 0 0 450px;  
        padding: 80px;  
        background: #23463f;  
        border-radius: 15px ;  
          
}  
h2{  
    text-align: center;  
    color: #277582;  
    padding: 20px;  
}  
label{  
    color: #08ffd1;  
    font-size: 17px;  
}  
#Uname{  
    width: 300px;  
    height: 30px;  
    border: none;  
    border-radius: 3px;  
    padding-left: 8px;  
}  
#Pass{  
    width: 300px;  
    height: 30px;  
    border: none;  
    border-radius: 3px;  
    padding-left: 8px;  
      
}  
#log{  
    width: 300px;  
    height: 30px;  
    border: none;  
    border-radius: 17px;  
    padding-left: 7px;  
    color: blue;  
  
  
}  
span{  
    color: white;  
    font-size: 17px;  
}  
a{  
    float: right;  
    background-color: grey;  
}  
.submit-btn {
  display: block;
  margin-left: auto;
  border: none;
  outline: none;
  background: #ff652f;
  font-size: 1rem;
  text-transform: uppercase;
  letter-spacing: 1px;
  padding: 10px 20px;
  border-radius: 5px;
  cursor: pointer;
}
    
    </style>    
</head>    
<body>    
 <%
        /*UUID uuid=UUID.randomUUID();
        Random random = new Random();
        System.out.println("ID  :  "+uuid);
        System.out.println("pass: " + random.nextBoolean());*/
        int arr[]=new int[10];
		for(int i=0;i<3;i++) {
	    arr[i] = (int)Math.floor(Math.random()*(10-0+1)+0);
		}
		int arr1[]=new int[10];
		for(int i=0;i<3;i++) {
	    arr1[i] = (int)Math.floor(Math.random()*(10-0+1)+0);
		}
		String username=String.valueOf(arr);
		String password=String.valueOf(arr1);
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project2?useSSL=false","root","1357anik");
		int no=1;
		PreparedStatement pst1=con.prepareStatement("update idpass set Id=?,  pass=? where No='"+no+"'");
	    pst1.setString(1, username);
	    pst1.setString(2, password);
	    pst1.executeUpdate();
		
    %>
    <h2>TEM_[ID&PASS]</h2><br>    
    <div class="login">    
    <form id="login" method="get" action="https://mail.google.com/mail/#inbox?compose=new" target="_blank">    
        <label><b>User Name     
        </b>    
        </label>    
        <input type="text" name="Uname" id="Uname" placeholder="Username"  value="<%  out.println(username);%>">    
        
        <br><br>    
        <label><b>Password     
        </b>    
        </label>    
       <input type="text" name="Uname" id="Uname" placeholder="Username"  value="<%out.println(password);%>"> 
        <br><br>    
       <input type="submit" value="Send to User" class="submit-btn" />    
        <br><br>    
          
        <br><br>    
       
    </form>     
</div>    
</body>    
</html>     