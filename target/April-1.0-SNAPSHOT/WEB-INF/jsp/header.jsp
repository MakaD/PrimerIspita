<%-- 
    Document   : header
    Created on : Sep 28, 2016, 5:07:56 PM
    Author     : vasic
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String uri = request.getRequestURI();
    String pageName = uri.substring(uri.lastIndexOf("/") + 1);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
        <script src="https://code.jquery.com/jquery-3.1.1.js" integrity="sha256-16cdPddA6VdVInumRGo6IbivbERE8p7CQR3HzTBuELA=" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css"/>
        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootswatch/3.3.7/flatly/bootstrap.min.css"/>
        <c:url var="css"  value="../css/style.css" />
          <link rel="stylesheet" type="text/css" href="${css}"/>
        
        
        <script>
            $(document).ready(function(){
               $("table").DataTable(); 
            });
        </script>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <nav class="navbar navbar-default">
                <div class="container">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="#">IT355</a>
                    </div>

                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav">
                            <c:url var="index"  value="/" />
                            <c:url var="add_grad"  value="/add_grad" />
                            <c:url var="add_proizvodjac"  value="/add_proizvodjac" />
                            <c:url var="add_namestaj"  value="/add_namestaj" />
                            <c:url var="add_korisnik"  value="/add_korisnik" />
                            <li class="<%=  (pageName.equals("index.jsp")) ? "active" : ""%>"><a href="${index}">Index</a></li>
                            <li class="<%=  (pageName.equals("add_grad.jsp")) ? "active" : ""%>"><a href="${add_grad}">Dodaj grad</a></li>
                            <li class="<%=  (pageName.equals("add_proizvodjac.jsp")) ? "active" : ""%>"><a href="${add_proizvodjac}">Dodaj proizvodjaca</a></li>
                            <li class="<%=  (pageName.equals("add_namestaj.jsp")) ? "active" : ""%>"><a href="${add_namestaj}">Dodaj namestaj</a></li>
                            <li class="<%=  (pageName.equals("add_korisnik.jsp")) ? "active" : ""%>"><a href="${add_korisnik}">Dodaj korisnika</a></li>

                        </ul>
                    </div>
                </div>
            </nav>
