<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="DarkCyan">
<form action="mailmessage.jsp"></form>
<table>

<tr>
<td>
<b>
<font color="Maroon">To:</font>
</b>
</td>
<td>
<b><input type="text" name="mail"></b></br>
</td>
</tr>

<tr>
<td>
<b>
<font color="Maroon">Subject:</font>
</b>
</td>
<td>
<b><input type="text" name="subject"></b></br>
</td>
</tr>


<tr>
<td>
<b>
<font color="Maroon">Message:</font>
</b>
</td>
<td>
<b><textarea rows="12" cols="90" name="mess"></textarea></b></br>
</td>
</tr>


<td>
<input type="submit"  value="Send">
</td>


<td>
<input type="reset"  value="Reset">
</td>

</table>
</body>
</html>