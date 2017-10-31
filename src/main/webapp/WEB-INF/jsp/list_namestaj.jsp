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
