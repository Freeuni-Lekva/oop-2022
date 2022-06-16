<%@ page contentType="text/html" import="java.util.List,java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
  <head>
    <title>JSP is Easy</title>
  </head>
  <body bgcolor="white">
    <h1>JSP is as easy as ...</h1>
    <%-- Calculate the sum of 1 + 2 + 3 dynamically --%>
    1 + 2 + 3 = <c:out value="${1 + 2 + 3}" />
    <%= 1 + 2 + 3 %>
    <% out.write("6"); %>
    <%
    String[] x = new String[2];
    x[0] = "123";
    x[1] = "234";
    for (String a : x) {
      out.write(a);
      out.write("<br/>");
    }
    List<String> y = new ArrayList<String>();
    %>
  </body>
</html>
