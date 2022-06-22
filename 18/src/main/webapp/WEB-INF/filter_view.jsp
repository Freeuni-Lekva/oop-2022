<%@ page contentType="application/json" import="java.util.List,main.Student" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
[
	    <c:forEach var="i" begin="0" end="${num_students}">
	      <c:if test="${i > 0}">
	      ,
	      </c:if>
	      {
	        "first_name": "<c:out value='${students[i].firstName}' />",
	        "last_name": "<c:out value='${students[i].lastName}' />",
	        "admission_year": <c:out value='${students[i].admissionYear}' />
	      }
	    </c:forEach>
]