<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
 
<h2>Update your details</h2>
<form action="update" method="post">
    <table>
        <tr>
            <td>Name</td>
            <td><input  name="name" value='<% out.println(session.getAttribute("uname")); %>'></td>
        </tr>
        <tr>
            <td>User Type</td>
            <td><input type="text"  name="utype" value='<% out.println(session.getAttribute("type")); %>'></td>
        </tr>
         <tr>
            <td>Mail</td>
            <td><textarea  name="email"><% out.println(session.getAttribute("mail")); %></textarea></td>
        </tr>
         <tr>
            <td>Mobile</td>
            <td><textarea  name="mobile"><% out.println(session.getAttribute("mobile")); %></textarea></td>
        </tr>
        <tr>
            <td><input type="submit" name=""></td>
        </tr>
        
    </table>
    </form>
</body>
</html>