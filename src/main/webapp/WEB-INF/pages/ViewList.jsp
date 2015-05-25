<%--
  Created by IntelliJ IDEA.
  User: Arthur's Notebook
  Date: 5/15/2015
  Time: 5:12 PM
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Users List</title>
    <!-- Bootstrap CSS -->

    <link href="<c:url value="/static/css/simplePagination.css" />" rel="stylesheet">
    <link href="<c:url value="/static/css/bootstrap.css" />" rel="stylesheet">
    <script type="text/javascript" src="/static/js/jquery-2.1.3.js"></script>
    <script type="text/javascript" src="/static/js/jquery.simplePagination.js"></script>
    <script type="text/javascript" src="/static/js/user.js"></script>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <style type="text/css">

        .bs-example{
            margin: 20px;
        }
    </style>

</head>
<body class=".container-fluid">
<div class="container myrow-container">
    <div class="panel panel-success">
        <div class="panel-heading">
            <h3 class="panel-title">

                <a href="createUser"    data-toggle="modal" data-target="#detailForm"><b>Add User</b></a>
                <a href="showMissings"  data-toggle="modal" data-target="#detailForm"><b>&nbsp;&nbsp;&nbsp;&nbsp;Missing Records</b></a>

            </h3>
        </div>
        <div class="panel-body">
            <c:if test="${empty itemCount}">
                There are no Users
            </c:if>
            <c:if test="${not empty itemCount}">
                <table class="table table-hover table-bordered" id="mytable">
                    <thead style="background-color: #bce8f1;">
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Created Date</th>
                        <th>Modified Date</th>
                        <th>Edit/Delete</th>
                    </tr>
                    </thead>
                    <tbody id ="mytbody" >
                    </tbody>
                </table>

                <div class="pagination" id="paginate"  >
                     <input type="hidden" id="itemCount" value="${itemCount}">
                </div>

            </c:if>
        </div>
    </div>
</div>

<div class="bs-example">
    <!-- Modal HTML -->
    <div class="modal fade" id="detailForm" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">

            </div>
        </div>
    </div>
</div>

</body>
</html>