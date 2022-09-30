<html>
    <head><title>Know about Anik</title>

   <!-- <style>
        body{

            background: silver
            
        }
        internal css work
    </style>-->
    
    </head>
    <body><marquee><h1 style="color: DarkBlue"><i><b>WELLCOME</b></i></h1></marquee>
    <!--  <img height="300" width="1350" src="img1.JPG">-->
    <br></br>
    <br></br>
    <table border="1" cellspacing="0" cellpadding="0">
        <tr>
            <td style="text-align:center;" height="20" width="150" bgcolor="black"><img style="border-radius : 50%" height="70" width="70" src="images/img-7.jpg"></td>
            <td style="padding-left: 10px" height="150" width="500"><h2><% out.println(session.getAttribute("uname")); %>
            </h2><p>User Type: <% out.println(session.getAttribute("type")); %></p><p>
            
            </p></td>
        </tr>
    </table>
   
    <br></br>
    <table border="1" width="200px" height="auto" cellspacing="0" cellpadding="0">
        <tr>
            <th>Name</th>
            <th>User Type</th>
            <th>Mail</th>
            <th>Mobile</th>
            
        </tr>
        <tr>
            <td><% out.println(session.getAttribute("uname")); %></td>
            <td><% out.println(session.getAttribute("type")); %></td>
            <td><% out.println(session.getAttribute("mail")); %></td>
            <td><% out.println(session.getAttribute("mobile")); %></td>
            
        </tr>
    </table>
   
    <br></br>
     <a href="updateuser.jsp">Update Your details</a>
    

    <!--Use of marquee tag--https://www.youtube.com/watch?v=Rl8_lHbrnaI-->
</html>