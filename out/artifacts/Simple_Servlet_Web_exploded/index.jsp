<%--
  Created by IntelliJ IDEA.
  User: natay
  Date: 19.08.2017
  Time: 13:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html >
<head>
    <meta charset="UTF-8">
    <title>Sign-Up/Login Form</title>



    <style type="text/css">
        .flable {
            color: gray;
        }

        .status {
            font-family: verdana;
            font-size: 12px;
        }

        .uname {
            color: blue;
        }
    </style>
    <script src="js/jquery.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            $(".uname").change(function(){
                var uname = $(this).val();
                if(uname.length >= 3){
                    $(".status").html("<img src='images/loading.gif'><font color=gray> Checking availability...</font>");
                    $.ajax({
                        type: "POST",
                        url: "check",
                        data: "uname="+ uname,
                        success: function(msg){

                            $(".status").ajaxComplete(function(event, request, settings){

                                $(".status").html(msg);

                            });
                        }
                    });
                }
                else{

                    $(".status").html("<font color=red>Username should be <b>3</b> character long.</font>");
                }

            });
        });
    </script>
    <script type="text/javascript">
        $(document).ready(function(){
            $(".email").change(function(){
                var email = $(this).val();
                if(email.length >= 3){
                    $(".status1").html("<img src='images/loading.gif'><font color=gray> Checking availability...</font>");
                    $.ajax({
                        type: "POST",
                        url: "checkEmail",
                        data: "email="+ email,
                        success: function(msg){

                            $(".status1").ajaxComplete(function(event, request, settings){

                                $(".status1").html(msg);

                            });
                        }
                    });
                }
                else{

                    $(".status1").html("<font color=red>Username should be <b>3</b> character long.</font>");
                }

            });
        });
    </script>

    <link href='https://fonts.googleapis.com/css?family=Titillium+Web:400,300,600' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
    <link rel="stylesheet" href="css/style.css">


</head>

<body>


<div class="form" >

    <ul class="tab-group">
        <li class="tab active"><a href="#signup">Sign Up</a></li>
        <li class="tab"><a href="#login">Log In</a></li>
    </ul>

    <div class="tab-content">
        <div id="signup">
            <h1>Sign Up for Free</h1>

            <form name="kayıt" action="reg" method="post">



                <div class="top-row">

                    <div class="field-wrap">
                        <label>
                            User Name<span class="req">*</span>
                        </label>
                        <input name="uname" type="text" class="uname"  required autocomplete="off" />&nbsp;<span class="status"></span>
                    </div>

                    <div class="field-wrap">
                        <label>
                            First Name<span class="req">*</span>
                        </label>
                        <input name="userfirstname" type="text" required autocomplete="off" />
                    </div>

                    <div class="field-wrap">
                        <label>
                            Last Name<span class="req">*</span>
                        </label>
                        <input  name="userlastname" type="text" required autocomplete="off" />
                    </div>
                </div>

                <div class="field-wrap">
                    <label>
                        Email Address<span class="req">*</span>
                    </label>
                    <input name="useremail" type="text" class="email"  required autocomplete="off" />&nbsp;<span class="status1"></span>

                </div>

                <div class="field-wrap">
                    <label>
                        Set A Password<span class="req">*</span>
                    </label>
                    <input  name="password" type="password"required autocomplete="off"/>
                </div>

                <button  type="submit" class="button button-block"/>Get Started</button>

            </form>

        </div>

        <div id="login">
            <h1>Welcome Back!</h1>

            <form name="giris" action="login" method="post">

                <div class="field-wrap">
                    <label>
                        Email Address and Email <span class="req">*</span>
                    </label>
                    <input name="username" type="text" required autocomplete="off"/>
                </div>

                <div class="field-wrap">
                    <label>
                        Password<span class="req">*</span>
                    </label>
                    <input name="password" type="password"required autocomplete="off"/>
                </div>

                <p class="forgot"><a href="#">Forgot Password?</a></p>
                <button class="button button-block"/>Log In</button><br>
            </form>
            <a href="register.jsp">Kayıt</a>
        </div>

    </div><!-- tab-content -->

</div> <!-- /form -->
<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src="js/index.js"></script>
<script src="js/jquery.js"></script>
</body>
</html>




