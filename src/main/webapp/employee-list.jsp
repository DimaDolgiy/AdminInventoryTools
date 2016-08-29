<%-- 
    Document   : welcome
    Created on : 03.08.2016, 23:12:06
    Author     : Dima
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" language="java"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>

${(sessionScope.logIn eq null or not sessionScope.logIn)? pageContext.request.getRequestDispatcher("authorization").forward(request, response) : null }

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="css/page-style.css" rel="stylesheet">
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/simple-sidebar.css" rel="stylesheet">
        <link href="css/font-awesome.css" rel="stylesheet">
        <link rel="stylesheet" href="css/jquery.datetimepicker.css"/>
        <title>Employee List</title>

    </head>
    <body>
        <div id="wrapper">

            <!-- Side Bar-->

            <div id="sidebar-wrapper">
                <ul class="sidebar-nav">
                    <li class="sidebar-brand">
                        Admin Inventory Tools
                    </li>

                    <li>
                        <a href="#">Dashboard</a>

                    </li>

                    <li>
                        <a href="view">Employee List</a>
                    </li>

                    <li>
                        <a href="#">Items</a>
                    </li>

                    <li>
                        <a href="#">Log Out</a>
                    </li>

                </ul> 
            </div>
            <!-- /sidebar-wrapper -->

            <!-- Page Content-->

            <div id="page-content-wrapper">

                <!--  Navigation Panel   -->
                <nav class="navbar my-navbar" role="navigation">
                    <div class="navbar-header">
                        <a href="#menu-toggle" id="menu-toggle"><i id="icon" class="fa fa-bars fa-2x" aria-hidden="true"></i></a>
                        <!--Search form-->    
                        <form class="navbar-form navbar-right" role="search">
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Search">
                            </div>
                            <button type="submit" class="btn btn-warning">
                                <span class="glyphicon glyphicon-search"></span>
                            </button>
                        </form>
                        <!--/Search form-->    
                    </div>
                </nav>
                <!--  /Navigation Panel   -->


                <div class="container-fluid">
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="panel panel-info">
                                <div class="panel-heading">
                                    <h4 class="panel-title">Table Employee</h4>
                                </div>
                                <div class="panel-body">
                                    <div class="row">
                                        <!--Action buttons-->
                                        <div class="col-sm-6">
                                            <button class="btn btn-default btn-sm" data-toggle="modal" data-target="#addEmployee"><i class="fa fa-plus" aria-hidden="true"></i> Добавить
                                            </button>
                                            <form method="post" action="view">
                                            <button type="submit" class="btn btn-danger btn-sm" name="delete"><i class="fa fa-trash-o" aria-hidden="true"></i> 
                                            </button>
                                                </form>
                                        </div>
                                        <!--/Action buttons-->

                                    </div>
                                    <!-- Table List-->
                                    <table id="example" class="table table-striped table-bordered my-table" cellspacing="0" width="100%">
                                        <tbody>
                                            <tr>
                                                <th>id</th>
                                                <th>firstName</th>
                                                <th>secondName</th>
                                                <th>lastName</th>
                                                <th>jobPosition</th>
                                                <th>startDate</th>
                                                <th>firedDate</th>
                                            </tr>
                                        </tbody>  
                                        <c:forEach var="employee" items="${employeeList}">
                                            <tr>

                                                <td>
                                                    <button data-toggle="modal" data-target="#showEmployeeDetails" class="btn">
                                                    <span class="glyphicon glyphicon-search"></span>
                                                    </button>
                                                    <input type="checkbox" name="userId" value="${employee.userId}">
                                                    ${employee.userId}
                                                </td>
                                                <td>${employee.firstName}</td>
                                                <td>${employee.secondName}</td>
                                                <td>${employee.lastName}</td>
                                                <td>${employee.jobPosition}</td>
                                                <td>${employee.startDate}</td>
                                                <td>${employee.firedDate}</td>

                                            </tr>
                                        </c:forEach>


                                    </table>
                                </div>
                            </div>
                            <!--/Table List-->
                        </div>
                    </div>
                </div>
            </div>
            <!-- /page-content-wrapper -->
        </div>
        <!-- modal window for add employee to DataBase -->
        <div class="modal fade" id="addEmployee">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form class="form-horizontal" method="post">
                        <div class="modal-header">
                            <h4 class="modal-title">Добавить сотрудника</h4>
                        </div>
                        <div class="modal-body">
                            <!-- form group-->

                            <div class="form-group">
                                <label class="control-label col-sm-4 col-lg-4">Имя</label>
                                <div class="col-sm-6">
                                    <input class="form-control" type="text" name="firstName" maxlength="200">
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="control-label col-sm-4 col-lg-4">Фамилия</label>
                                <div class="col-sm-6">
                                    <input class="form-control" type="text" name="secondName" maxlength="200">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-4 col-lg-4" >Отчество</label>
                                <div class="col-sm-6">
                                    <input class="form-control" type="text" name="lastName" maxlength="200">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-4 col-lg-4" >Должность</label>
                                <div class="col-sm-6">
                                    <input class="form-control" type="text" name="jobPosition" maxlength="200">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-4 col-lg-4" >Дата принятия</label>
                                <div class="col-sm-6">
                                    <input class="form-control" id="startdate" type="text" name="startDate" maxlength="200">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-4 col-lg-4" >Дата увольнения</label>
                                <div class="col-sm-6">
                                    <input class="form-control" id="fireddate" type="text" name="firedDate" maxlength="200">
                                </div>
                            </div>
                            <!-- /form group-->
                        </div>
                        <div class="modal-footer">
                            <button class="btn btn-warning" type="submit" name="insert">Сохранить</button>
                            <button class="btn btn-default" type="button" data-dismiss="modal">Закрыть</button>
                        </div>

                    </form>

                </div>

            </div>
        </div>
        <!-- /modal window for add employee to DataBase -->

        <!-- Take Employee info to modal window -->
        <div class="modal fade" id="showEmployeeDetails">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">Employee Info</h4>
                    </div>
                    <div class="modal-body">
                        <p>take information about employee</p>
                    </div>
                    <div class="modal-footer">
                        <p>кнопки: редактировать, отмена</p>
                    </div>
                </div>
            </div>
        </div>
        <!-- /Take Employee info to modal window -->


        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="js/bootstrap.js"></script>
        <script href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"></script>
        <script src="js/jquery.datetimepicker.full.js"></script>
        <!--  Menu toggle script  -->
        <script>
            $("#menu-toggle").click(function (e) {
                e.preventDefault();
                $("#wrapper").toggleClass("toggled");
            });
        </script>
        <!--  /Menu toggle script  -->
        <!--Script DatePicker--> 
        <script>
            $("#startdate").datetimepicker({
                timepicker: false,
                format: 'Y-m-d',
                lang: 'ru'

            });
        </script>

        <script>
            $("#fireddate").datetimepicker({
                timepicker: false,
                format: 'Y-m-d',
                lang: 'ru'

            });
        </script>
        <!--/Script DatePicker--> 
    </body>
</html>

