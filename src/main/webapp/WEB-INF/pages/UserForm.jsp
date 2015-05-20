<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="author" content="Ranga Reddy">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Employee Information</title>
    <!-- Bootstrap CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <style type="text/css">
        .myrow-container{
            margin: 20px;
        }
    </style>
</head>
<body class=".container-fluid">
<div class="container myrow-container">
    <div class="panel panel-success">
        <div class="panel-heading">
            <h3 class="panel-title">
                Employee Details
            </h3>
            <div align="center"><a href="/getAllEmployees"><h3 class="panel-title">
                Show Employee List
            </h3></a></div>
        </div>
        <div class="panel-body">
            <form:form id="employeeRegisterForm" cssClass="form-horizontal" modelAttribute="employee" method="post" action="saveEmployee">

                <div class="form-group">
                    <div class="control-label col-xs-3"> <form:label path="Name" >Name</form:label> </div>
                    <div class="col-xs-6">
                        <form:hidden path="id" value="${employeeObject.id}"/>
                        <form:input cssClass="form-control" path="name" value="${employeeObject.name}"/>
                    </div>
                </div>

                <div class="form-group">
                    <form:label path="Age" cssClass="control-label col-xs-3">Age</form:label>
                    <div class="col-xs-6">
                        <form:input cssClass="form-control" path="age" value="${employeeObject.age}"/>
                    </div>
                </div>

                <div class="form-group">
                    <div class="control-label col-xs-3"><form:label path="Salary">Salary</form:label></div>
                    <div class="col-xs-6">
                        <form:input cssClass="form-control" path="salary" value="${employeeObject.salary}"/>
                    </div>
                </div>

                <div class="form-group">
                    <div class="row">
                        <div class="col-xs-4">
                        </div>
                        <div class="col-xs-4">
                            <input type="submit" id="saveEmployee" class="btn btn-primary" value="Save" onclick="return submitEmployeeForm();"/>
                        </div>
                        <div class="col-xs-4">
                        </div>
                    </div>
                </div>

            </form:form>
        </div>
    </div>
</div>
<script src="<c:url value="/resources/js/jquery-2.1.3.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/resources/js/employee.js"/>"></script>

</body>
</html>