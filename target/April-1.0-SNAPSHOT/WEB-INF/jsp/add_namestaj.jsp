<%--
  Created by IntelliJ IDEA.
  User: Marina
  Date: 29.10.2017.
  Time: 08:37
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>



<%@include file="header.jsp" %>
<h1>Dodaj namestaj</h1>
<div class="container">
    <div class="col-md-6 col-md-offset-3">
        <c:url var="addNamestaj" value="/add_namestaj" ></c:url>
        <form:form method="POST" action="${addNamestaj}" modelAttribute="namestaj">
            <% String success = (String) request.getAttribute("successMsg");%>
            <%= (success != null) ? "<div class=\"alert alert-success\">" + success + "</div>" : ""%>

            <div class="form-group">
                <form:label path="naziv">Naziv</form:label>
                <form:input type="naziv" class="form-control" id="naziv" placeholder="Naziv" path="naziv" />
            </div>
            <div class="form-group">
                <form:label path="opis">Opis</form:label>
                <form:input type="opis" class="form-control" id="opis" placeholder="Opis" path="opis" />
            </div>
            <div class="form-group">
                <form:label path="cena">Cena</form:label>
                <form:input type="cena" class="form-control" id="cena" placeholder="Cena" path="cena" />
            </div>
            <div class="form-group">
                <form:label path="datumKreiranja">Datum Kreiranja</form:label>
                <form:input type="datumKreiranja" id="datumKreiranja" placeholder="mm/dd/yyyy" class="form-control date-picker" path="datumKreiranja" />
            </div>
            <div class="form-group">
                <form:label for="korisnikId" path="korisnikId">Korisnik</form:label>

                <form:select id="slcRole" class="form-control" path="korisnikId">
                    <form:option value="">SELECT</form:option>
                    <form:options items="${korisnici}" itemValue="id" itemLabel="username" />
                </form:select>
            </div>
            <div class="form-group">
                <form:label for="proizvodjacId" path="proizvodjacId">Proizvodjac</form:label>

                <form:select id="slcRole" class="form-control" path="proizvodjacId">
                    <form:option value="">SELECT</form:option>
                    <form:options items="${proizvodjaci}" itemValue="id" itemLabel="ime" />
                </form:select>
            </div>

            <form:input type="hidden" id="id" class="form-control" placeholder="id" path="id" />
            <button type="submit" class="btn btn-primary">ADD</button>
        </form:form>
    </div>
    <div class="col-md-8 col-md-offset-2">
        <c:if test="${!empty namestaji}">

            <table class="table table-striped mojatabela">
                <thead>
                <tr>
                    <th>Naziv</th>
                    <th>Opis</th>
                    <th>Cena</th>
                    <th>Datum kreiranja</th>
                    <th>Korisnik</th>
                    <th>Proizvodjac</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${namestaji}" var="namestaj">

                    <tr>
                        <td>${namestaj.naziv}</td>
                        <td>${namestaj.opis}</td>
                        <td>${namestaj.cena}</td>
                        <td>${namestaj.datumKreiranja}</td>
                        <td>${namestaj.korisnikId}</td>
                        <td>${namestaj.proizvodjacId}</td>
                        <td><a href="<c:url value='/edit_namestaj/${namestaj.id}' />">edit</a></td>
                        <td><a href="<c:url value='/delete_namestaj/${namestaj.id}' />">delete</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:if>
    </div>
</div>



<%@include file="footer.jsp" %>
