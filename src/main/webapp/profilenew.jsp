<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css">

<!-- jQuery library -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>

<!-- Latest compiled JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

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

.btn-update{

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
    </style>
</head>
<body>
   <input type="hidden" id="status" value="<%=request.getAttribute("status") %>"> 
    <div class="container rounded bg-white mt-5 mb-5">
        <div class="row">
            <div class="col-md-3 border-right">
                <div class="d-flex flex-column align-items-center text-center p-3 py-5"><img class="rounded-circle mt-5" width="150px" src="images/img-7.jpg"><span class="font-weight-bold"><% out.println(session.getAttribute("uname")); %></span><span class="text-black-50"><% out.println(session.getAttribute("mail")); %></span><span> </span></div>
            </div>
            <div class="col-md-5 border-right">

                <!--Form Start-->
                <form action="update" method="post">

                <div class="p-3 py-5">
                    <div class="d-flex justify-content-between align-items-center mb-3">
                        <h4 class="text-right">Profile Settings</h4>
                    </div>
    
                    <div class="row mt-2">
                        <div class="col-md-6"><label class="labels">Name</label><input type="text" class="form-control" placeholder="your user name" name="name" value="<% out.println(session.getAttribute("uname")); %>"></div>
                       <!--<div class="col-md-6"><label class="labels">Surname</label><input type="text" class="form-control" value='' placeholder="surname"></div>--> 
                    </div>
                    <div class="row mt-3">
                        <div class="col-md-12"><label class="labels">User Type</label><input type="text" class="form-control" placeholder="User Type" name="utype" value="<% out.println(session.getAttribute("type")); %>"></div>
                        <div class="col-md-12"><label class="labels">Mobile Number</label><input type="text" class="form-control" placeholder="enter mobile number" name="mobile" value="<% out.println(session.getAttribute("mobile")); %>"></div>
                        <div class="col-md-12"><label class="labels">District </label><input type="text" class="form-control" placeholder="enter Your district name" value="N/A"></div>
                        <div class="col-md-12"><label class="labels">Postcode</label><input type="text" class="form-control" placeholder="Postal code" value="N/A"></div>
                       
                        <div class="col-md-12"><label class="labels">Address</label><input type="text" class="form-control" placeholder="enter your address" value="<% out.println(session.getAttribute("location")); %>"></div>
                        <div class="col-md-12"><label class="labels">Email ID</label><input type="text" class="form-control" placeholder="enter email id" name="email"value="<% out.println(session.getAttribute("mail")); %>"></div>
                        <div class="col-md-12"><label class="labels">Education</label><input type="text" class="form-control" placeholder="education" value="N/A"></div>
                    </div>
                   <!--<div class="row mt-3">
                        <div class="col-md-6"><label class="labels">Country</label><input type="text" class="form-control" placeholder="country" value=""></div>
                        <div class="col-md-6"><label class="labels">State/Region</label><input type="text" class="form-control" value="" placeholder="state"></div>
                    </div>--> 
                  
                    <div class="mt-5 text-center"><tr>
            <td><input type="submit" name=""></td>
        </tr>
        </div> 
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
    
    var status =document.getElementById("status").value;
    if(status=="Success"){
    	swal("Congratulations","Details Updated","Success");
    	
    }
    else if(status=="Failed"){
    	swal("Error","Not updated","Failed");
    	
    }
    
    </script>
</body>
</html>