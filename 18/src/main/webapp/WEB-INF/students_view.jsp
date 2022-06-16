<%@ page contentType="text/html" import="java.util.List,main.Student" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
    <head>
	<title>Students APP</title>
	<script type="text/javascript" src="./index.js"></script>
	<style>
	 table#students td {
	     width: 100%;
	     background-color: red;
	 }
	</style>
    </head>
    <body onload="init()">
	<form action="/students" method="POST">
	    <label for="first_name">First Name</label><input type="text" name="first_name" id="first_name" /><br/>
	    <label for="last_name">Last Name</label><input type="text" name="last_name" id="last_name" /><br/>
	    <label for="admission_year">Admission Year</label><input type="text" name="admission_year" id="admission_year" /><br/>
	    <input type="submit" value="Create" />
	</form>
	<form action="/students" method="GET">
	    <label for="first_name">First Name</label><input type="text" name="first_name" id="filter_first_name" /><br/>
	    <label for="last_name">Last Name</label><input type="text" name="last_name" id="filter_last_name" /><br/>
	    <label for="admission_year">Admission Year</label><input type="text" name="admission_year" id="filter_admission_year" /><br/>
	    <input type="submit" value="Search" />
	</form>
	<table id="students">
	    <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Admission Year</th>
	    </tr>
	    <c:forEach items="${students}" var="st">
	      <tr>
	        <td><c:out value="${st.firstName}" /></td>
	        <td><c:out value="${st.lastName}" /></td>
	        <td><c:out value="${st.admissionYear}" /></td>
	      </tr>
	    </c:forEach>
	</table>

    </body>
</html>
