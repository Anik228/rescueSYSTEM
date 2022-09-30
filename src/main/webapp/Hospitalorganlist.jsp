<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Sign Up Form by Colorlib</title>

<!-- Font Icon -->
<link rel="stylesheet"
	href="fonts/material-icon/css/material-design-iconic-font.min.css">

<!-- Main css -->
<link rel="stylesheet" href="css/style.css">
<style>
.input {

  
  display: block;
  font-family: sans-serif;
  font-size: 14px;
  line-height: 20px;
  margin: 10px 0;
  padding: 2px 20px;
  vertical-align: baseline;
  width: 300px;
}
</style>
</head>
<body>
<input type="hidden" id="status" value="<%=request.getAttribute("status") %>">


	<div class="main">

		<!-- Sign up form -->
		<section class="signup">
			<div class="container">
				<div class="signup-content">
					<div class="signup-form">
						<h2 class="form-title">Use given temporary ID & password</h2>
					
						<form method="post" action="Hospitalorgan" class="register-form"
							id="register-form">
							<div class="form-group">
								<label for="name"><i
									class="zmdi zmdi-account material-icons-name"></i></label> <input
									type="text" name="name" id="name" placeholder="UserId" value="" />
							</div>
							<div class="form-group">
								<label for="password"><i class="zmdi zmdi-lock"></i></label> <input
									type="password" name="password" id="password"
									placeholder="Password" />
							</div>
							
							<div class="form-group">
								<label for="page"><i class="zmdi zmdi-email"></i></label> 
								<div class="input"> <a href="https://mail.google.com/mail/#inbox?compose=new" target="_blank">  Request admin</a><u style="color: red; padding : 2px">(For another donate information)</u></div>
							</div>
							
							
							
							<div class="form-group form-button">
								<input type="submit" name="signup" id="signup"
									class="form-submit" value="Register" />
							</div>
						</form>
					</div>
					
				</div>
			</div>
		</section>
		

	</div>
	
	<!-- JS -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="js/main.js"></script>
    <script src="http://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <link rel="stylesheet" href="alert/dist/sweetalert.css">
    
    
    <script type="text/javascript">
    
    var status =document.getElementById("status").value;
    if(status=="Success"){
    	swal("Congratulations","Details Updated","Success");
    	
    }
    else if(status=="Failed"){
    	swal("Error","Updated failed","Failed");
    	
    }
   
    
    </script>
    


</body>
<!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>