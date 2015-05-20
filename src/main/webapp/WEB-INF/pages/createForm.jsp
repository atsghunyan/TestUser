<%--
  Created by IntelliJ IDEA.
  User: Arthur's Notebook
  Date: 5/19/2015
  Time: 3:59 PM

--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Create User</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

</head>
<body>
<div class="modal-content">

    <div class="panel panel-success">


            <div class="panel-heading">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h3><p align="center">User Details</p></h3>
            </div>


        <div class="panel-body">
            <form:form id="userRegisterForm" cssClass="form-horizontal" modelAttribute="user" method="post" action="saveUser">

                <div class="form-group">
                    <div class="control-label col-xs-3"> <form:label path="Name" >Name</form:label> </div>
                    <div class="col-xs-6">
                        <form:hidden path="id" value="${userObject.id}"/>
                        <form:input cssClass="form-control" path="name" value="${userObject.name}"/>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-xs-6">
                        <form:hidden class="date" path="createdDate" value="${userObject.createdDate}"/>
                    </div>
                </div>

                <div class="form-group">

                    <div class="col-xs-6">
                        <form:hidden class="date" path="modifiedDate" value="${userObject.modifiedDate}"/>
                    </div>
                </div>

                <div class="form-group">
                    <div class="row">
                        <div class="col-xs-4">
                        </div>
                        <div class="col-xs-4">
                            <input type="submit" id="saveUser" class="btn btn-primary" value="Save" onclick="return submitUserForm();"/>
                            <button type="button" class="btn btn-primary" data-dismiss="modal">Cancel</button>
                        </div>
                        <div class="col-xs-4">
                        </div>
                    </div>
                </div>

            </form:form>
        </div>
    </div>

</div>


</body>
</html>
