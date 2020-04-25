<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>Asiakaslista</title>
 <link href="../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
 <script src="../webjars/bootstrap/4.0.0/js/bootstrap.min.js" ></script>
 <script src="../webjars/jquery/3.0.0/js/jquery.min.js" ></script>
</head>
<body>
 <div class="container">
  <h2>Asiakaslista</h2>
  <table class="table table-striped">
   <thead>
    <tr>
     <th scope="row">asiakasid</th>
     <th scope="row">nimi</th>
     <th scope="row">puhelinnumero</th>
     <th scope="row">sahkoposti</th>
     <th scope="row">osoite</th>
     <th scope="row">yritys</th>
     <th scope="row">Päivitä</th>
     <th scope="row">Poista</th>
    </tr>
   </thead>
   <tbody>
    <c:forEach items="${asiakas_list }" var="asiakas" >
     <tr>
      <td>${asiakas.asiakasid}</td>
      <td>${asiakas.nimi}</td>
      <td>${asiakas.puhelinnumero}</td>
      <td>${asiakas.sahkoposti}</td>
      <td>${asiakas.osoite}</td>
      <td>${asiakas.yritys}</td>
      <td>
       <spring:url value="/asiakas/update/${asiakas.asiakasid }" var="updateURL" />
       <a class="btn btn-primary" href="${updateURL }" role="button">Päivitä</a>
      </td>
      <td>
       <spring:url value="/asiakas/delete/${asiakas.asiakasid }" var="deleteURL" />
       <a class="btn btn-primary" href="${deleteURL }" role="button">Poista</a>
      </td>
     </tr>
    </c:forEach>
   </tbody>
  </table>
  <spring:url value="/asiakas/add" var="addURL" />
  <a class="btn btn-primary" href="${addURL }" role="button">Lisää uusi asiakas</a>
 </div>
</body>
</html>