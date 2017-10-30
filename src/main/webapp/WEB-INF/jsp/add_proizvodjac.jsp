<%--
  Created by IntelliJ IDEA.
  User: Marina
  Date: 28.10.2017.
  Time: 23:17
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>



<%@include file="header.jsp" %>
<h1>Dodaj prizvodjaca</h1>
<div class="container">
    <div class="col-md-6 col-md-offset-3">
        <c:url var="addProizvodjac" value="/add_proizvodjac" ></c:url>
        <form:form method="POST" action="${addProizvodjac}" modelAttribute="proizvodjac">
            <% String success = (String) request.getAttribute("successMsg");%>
            <%= (success != null) ? "<div class=\"alert alert-success\">" + success + "</div>" : ""%>
            <div class="form-group">
                <form:label path="ime">Ime</form:label>
                <form:input type="ime" class="form-control" id="ime" placeholder="Ime" path="ime" />
            </div>
            <div class="form-group">
                <form:label for="gradId" path="gradId">Grad</form:label>

                <form:select id="slcRole" class="form-control" path="gradId">
                    <form:option value="">SELECT</form:option>
                    <form:options items="${gradovi}" itemValue="id" itemLabel="ime" />
                </form:select>
            </div>

            <form:input type="hidden" id="id" class="form-control" placeholder="id" path="id" />
            <button type="submit" class="btn btn-primary">ADD</button>
        </form:form>
    </div>
    <div class="col-md-8 col-md-offset-2">
        <c:if test="${!empty proizvodjaci}">

            <table class="table table-striped mojatabela">
                <thead>
                <tr>
                    <th>Proizvodjac</th>
                    <th>Grad</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${proizvodjaci}" var="proizvodjac">

                    <tr>
                        <td>${proizvodjac.ime}</td>
                        <td>${proizvodjac.gradId}</td>
                        <td><a href="<c:url value='/edit_proizvodjac/${proizvodjac.id}' />">edit</a></td>
                        <td><a href="<c:url value='/delete_proizvodjac/${proizvodjac.id}' />">delete</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>
    </div>
</div>
<%@include file="footer.jsp" %>
