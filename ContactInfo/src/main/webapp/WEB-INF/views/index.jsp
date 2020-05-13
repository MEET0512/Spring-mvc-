<%-- 
    Document   : index
    Created on : 30 Dec, 2019, 9:04:59 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Contact Manager Home</title>
        <spring:url value="/resources/style/bootstrap.css" var="css"/>
        <link href="${css}" rel="stylesheet">
    </head>
    <body>
    
        <div class="container col-8" align="center">
            <h1>Contact List</h1>
            <h3><a href="new" class="btn btn-dark">New Contact</a></h3>
            <table class="table table-bordered" style="margin-top:20px;">
                <tr>
                    <th>No.</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Address</th>
                    <th>Telephone</th>
                    <th>Action</th>
                </tr>
                <c:forEach items="${contacts}" var="contact" varStatus="status">
                    <tr>
                        <td>${status.index+1}</td>
                        <td>${contact.name}</td>
                        <td>${contact.email}</td>
                        <td>${contact.address}</td>
                        <td>${contact.phone}</td>
                        <td>
                            <a href="edit?id=${contact.id}" class="btn btn-success">Edit</a>
                            &nbsp;&nbsp;
                            <a href="delete?id=${contact.id}" class="btn btn-danger">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
