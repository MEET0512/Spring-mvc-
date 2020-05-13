<%-- 
    Document   : contact_form
    Created on : 4 Jan, 2020, 12:31:18 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New/Edit Contact</title>
        <spring:url value="/resources/style/bootstrap.css" var="css"/>
        <link href="${css}" rel="stylesheet">
    </head>
    <body>
        <div class="container col-5">
            <h1 class="h1">New/Edit Contact</h1>
            <div>
                <form:form action="save" method="post" modelAttribute="contact">
                    <form:hidden path="id" />
                    <div class="form-group">
                        <label>Name</label> 
                        <form:input path="name" cssClass="form-control" />       
                    </div>
                    <div class="form-group">
                        <lable>Email:</label> 
                        <form:input path="email" cssClass="form-control" />       
                    </div>
                    <div class="form-group">
                        <label>Address:</label> 
                        <form:input path="address" cssClass="form-control" />       
                    </div>
                    <div class="form-group">
                        <label>Phone no:</label> 
                        <form:input path="phone" cssClass="form-control" />       
                    </div>

                    <input type="submit" value="Save" class="btn btn-primary btn-lg float-right"> 

                </form:form>
            </div
        </div>
    </body>
</html>
