<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE html>
<html lang="en">

  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><tiles:insertAttribute name="title" ignore="true" /></title>
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/css/bootstrap-responsive.min.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/css/svpn.css" rel="stylesheet" />
    <script src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
  </head>

  <body style="background-color:white">
    <div id="container">
      <div id="main_header" class="container">
        <tiles:insertAttribute name="header" />
      </div>
      <div id="main_topmenu" class="container">
        <tiles:insertAttribute name="topMenu" />
      </div>
      <div id="main_body" class="container">
        <tiles:insertAttribute name="body" />
      </div>
      <div id="main_footer" class="container">
        <tiles:insertAttribute name="footer" />
      </div>
    </div>
  </body>

</html>