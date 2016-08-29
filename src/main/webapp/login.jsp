<%-- 
    Document   : login
    Created on : 03.08.2016, 0:39:17
    Author     : Dima
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Smart Inventory Tools</title>
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/style_1.css" rel="stylesheet"> 
        <link href="css/font-awesome.css" rel="stylesheet">
    </head>
    <body>
    <body id="login-page">
        <div class="container">
            <div class="row">
                <div class="col-md-12 text-center">
                    <div class="form-login my-login-form">
                        <div id="logo">
                            <i class="fa fa-cog fa-2x my-fa">Admin Inventory Tools</i>
                        </div>
                        <p>Members login</p>
                        <form method="post" class="form-signin">
                            <div class="form-group my-form-group">
                                <input type="text" name="login" placeholder="login" class="form-control input-lg my-input">

                                <input type="password" name="password" placeholder="password" class="form-control input-lg my-input">

                                <input type="submit" value="Sign In" class="btn btn-warning btn-block my-btn">
                                <input type="hidden" name="page" value="login.jsp">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>





        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="js/bootstrap.js"></script>
    </body>
</html>
