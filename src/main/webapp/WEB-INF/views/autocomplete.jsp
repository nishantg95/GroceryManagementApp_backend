<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!--need this for c: tag  -->

<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>jQuery UI Autocomplete - Custom data and display</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <style>
  #project-label {
    display: block;
    font-weight: bold;
    margin-bottom: 1em;
  }
  #project-icon {
    float: left;
    height: 32px;
    width: 32px;
  }
  #project-description {
    margin: 0;
    padding: 0;
  }
  </style>
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script src="<c:url value='/static/js/scripts/autofill_old.js'/>" type="text/javascript"></script>
</head>
<body>
 
<div id="project-label">Select a project (type "j" for a start):</div>
<img id="project-icon" src="" class="ui-state-default" alt="">
<input id="project">
<input type="hidden" id="project-id">
<p id="project-description"></p>
 
 
</body>
</html>