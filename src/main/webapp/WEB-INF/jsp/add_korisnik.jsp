<%--
  Created by IntelliJ IDEA.
  User: Marina
  Date: 28.10.2017.
  Time: 22:56
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<%@include file="header.jsp" %>
<h1>Dodaj korisnika</h1>
<div class="container">
    <div class="col-md-6 col-md-offset-3">
        <c:url var="addKorisnik" value="/add_korisnik" ></c:url>
        <form:form method="POST" action="${addKorisnik}" modelAttribute="korisnik">
            <% String success = (String) request.getAttribute("successMsg");%>
            <%= (success != null) ? "<div class=\"alert alert-success\">" + success + "</div>" : ""%>
            <div class="form-group">
                <form:label path="username">Username</form:label>
                <form:input type="username" class="form-control" id="username" placeholder="Username" path="username" />
            </div>

            <div class="form-group">
                <form:label path="password">Password</form:label>
                <form:input type="password" class="form-control" id="password" placeholder="Password" path="password" />
            </div>

            <div class="form-group">
                <form:label path="role">Role</form:label>
                <form:input type="role" class="form-control" id="role" placeholder="Role" path="role" />
            </div>

            <form:input type="hidden" id="id" class="form-control" placeholder="id" path="id" />
            <button type="submit" class="btn btn-primary">ADD</button>
        </form:form>
    </div>
    <div class="col-md-8 col-md-offset-2">
        <c:if test="${!empty korisnici}">

            <table class="table table-striped mojatabela">
                <thead>
                <tr>
                    <th>Username</th>
                    <th>Password</th>
                    <th>Role</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${korisnici}" var="korisnik">

                    <tr>
                        <td>${korisnik.username}</td>
                        <td>${korisnik.password}</td>
                        <td>${korisnik.role}</td>
                        <td><a href="<c:url value='/edit_korisnik/${korisnik.id}' />">edit</a></td>
                        <td><a href="<c:url value='/delete_korisnik/${korisnik.id}' />">delete</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>
    </div>
</div>
<%@include file="footer.jsp" %>
