<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>Asiakas</title>
 <link href="http://localhost:8080/webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
 <script src="http://localhost:8080/webjars/bootstrap/4.0.0/js/bootstrap.min.js" ></script>
 <script src="http://localhost:8080/webjars/jquery/3.0.0/js/jquery.min.js" ></script>
</head>
<body>
 <div class="container">
  <spring:url value="/asiakas/save" var="saveURL" />
  <h2>Asiakas</h2>
  <form:form modelAttribute="asiakasForm" method="post" action="${saveURL }" cssClass="form">
   <form:hidden path="asiakasid"/>
   <div class="form-group">
    <lable for="nimi">nimi</lable>
    <form:input path="nimi" cssClass="form-control" id="nimi" />
   </div>
   <div class="form-group">
    <lable for="puhelinnumero">puhelinnumero</lable>
    <form:input path="puhelinnumero" cssClass="form-control" id="puhelinnumero" type="number" step="1"/>
   </div>
   <div class="form-group">
    <lable for="sahkoposti">sahkoposti</lable>
    <form:input path="sahkoposti" cssClass="form-control" id="sahkoposti" />
   </div>
   <div class="form-group">
    <lable for="osoite">osoite</lable>
    <form:input path="osoite" cssClass="form-control" id="osoite" />
   </div>
   <div class="form-group">
    <lable for="yritys">yritys</lable>
    <form:input path="yritys" cssClass="form-control" id="yritys" />
   </div>
   <button type="submit" class="btn btn-primary">Tallenna</button>
  </form:form>
 </div>
</body>



</html>