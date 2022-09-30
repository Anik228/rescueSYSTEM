<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<link rel="stylesheet" type="text/css" href="styleuser.css">
<title>Document</title>
<style>
body {
	background: rgb(239, 7, 154)
}

.form-control:focus {
	box-shadow: none;
	border-color: #ed2b75
}

.profile-button {
	background: rgb(154, 6, 87);
	box-shadow: none;
	border: none
}

.btn-update {
	width: 105px;
	height: 35px;
	margin-top: -51px;
}

.profile-button:hover {
	background: #d20d6f
}

.profile-button:focus {
	background: #ad0c4a;
	box-shadow: none
}

.profile-button:active {
	background: #ca1566;
	box-shadow: none
}

.back:hover {
	color: #d70f5b;
	cursor: pointer
}

.labels {
	font-size: 11px
}

.add-experience:hover {
	background: #de1253;
	color: #fff;
	cursor: pointer;
	border: solid 1px #d8387b
}
 .button {
        display: inline-block;
        padding: 10px 20px;
        text-align: center;
        text-decoration: none;
        color: #ffffff;
        background-color: #7aa8b7;
        border-radius: 6px;
        outline: none;
        
      }
      marquee{
background-color: darkblue;

}
body {
    background: #6495ed;
}
.center {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 80px;
 
}
</style>
</head>
<body>
<marquee><h1 style="color : white"><i><b>Your Services</b></i></h1></marquee>
	<input type="hidden" id="status"
		value="<%=request.getAttribute("status")%>">
	<div class="container rounded- bg-white mt-5 mb-5">
		<div class="row">
			<div class="col-md-3 border-right">
				<div
					class="d-flex flex-column align-items-center text-center p-3 py-5">
					
					</span><span class="text-black-50">
						
					</span><span> </span>
				</div>
			</div>
			<div class="col-md-5 border-right">

				<!--Form Start-->
				<form action="update" method="post">

					<div class="center">
						<a href="admindonnorupdate.jsp" class ="button">Add Extra user donate details</a>
												
						
					</div>
					<div class="center">
						<a href="temID&PASS.jsp" class ="button">Generate Temporary ID&PASS</a>
													
					</div>
					<div class="center">
						
						<a href="temID&PASSnew.jsp" class ="button">Generate Temporary ID&PASS(Hospital)</a>						
						
					</div>
					<div class="center">
						
						<a href="https://mail.google.com/mail/#inbox?compose=new" target="_blank" class ="button">Send Mail</a>						
						
					</div>
					<div class="center">
						<a href="#" class ="button">TBA</a>
												
						
					</div>
				</form>
				<!--Form End-->
			</div>

		</div>
	</div>
	</div>
	</div>
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="js/main.js"></script>
	<script src="http://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<link rel="stylesheet" href="alert/dist/sweetalert.css">


	<script type="text/javascript">
		var status = document.getElementById("status").value;
		if (status == "Success") {
			swal("Congratulations", "Details Updated", "Success");

		} else if (status == "Failed") {
			swal("Error", "Not updated", "Failed");

		}
	</script>
</body>
</html>