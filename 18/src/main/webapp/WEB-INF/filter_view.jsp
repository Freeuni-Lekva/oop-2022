<%@ page contentType="application/json" import="java.util.List,main.Student" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
[
	    <c:forEach items="${students}" var="st">
	      {
	        "first_name": "<c:out value='${st.firstName}' />",
	        "last_name": "<c:out value='${st.lastName}' />",
	        "admission_year": <c:out value='${st.admissionYear}' />
	      },
	    </c:forEach>
]