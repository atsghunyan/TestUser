<%--
  Created by IntelliJ IDEA.
  User: Arthur's Notebook
  Date: 5/20/2015
  Time: 11:29 AM
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
            <h3><p align="center">Missing Records</p></h3>
        </div>


        <div class="panel-body">
            <div class="modal-body">

                <textarea class="form-control" >${message}</textarea>
            </div>
        </div>
    </div>

</div>


</body>
</html>

