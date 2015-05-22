<%--
  Created by IntelliJ IDEA.
  User: Arthur's Notebook
  Date: 5/20/2015
  Time: 3:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Edit User</title>
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
                    <div class="control-label col-xs-3"> <form:label path="id" >ID</form:label> </div>
                    <div class="col-xs-6">

                        <form:input cssClass="form-control" path="id" readonly="true"  value="${userObject.id}"/>
                    </div>
                </div>

                <div class="form-group">
                    <div class="control-label col-xs-3"> <form:label path="Name" >Name</form:label> </div>
                    <div class="col-xs-6">

                        <form:input cssClass="form-control" path="name" value="${userObject.name}"/>
                    </div>
                </div>

                <div class="form-group">
                    <form:label path="createdDate" cssClass="control-label col-xs-3">Created Date</form:label>
                    <div class="col-xs-6">
                        <form:input cssClass="form-control" path="createdDate" readonly="true" value="${userObject.createdDate}"/>
                    </div>
                </div>

                <div class="form-group">
                    <div class="control-label col-xs-3"><form:label path="modifiedDate">Modified Date</form:label></div>
                    <div class="col-xs-6">
                        <form:input cssClass="form-control" path="modifiedDate" readonly="true" value="${userObject.modifiedDate}"/>
                    </div>
                </div>

                <div class="form-group">
                    <div class="row">
                        <div class="col-xs-4">
                        </div>
                        <div class="col-xs-6">
                            <input type="submit" id="saveUser" class="btn btn-primary" value="Save" onclick="return submitUserForm();"/>
                            <a class="btn btn-primary" href="deleteUser?id=${userObject.id}"><b> Delete </b></a>
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
