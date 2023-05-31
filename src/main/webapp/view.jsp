<%@page import="com.js.dto.Mobile"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>MOBILE TABLE</h1>

<table border="3px" cellpadding="10px">
  <tr>
        <th>MOBILE ID</th>
        <th>MOBILE NAME</th>
        <th>BRAND</th>
        <th>PRICE</th>
        <th>DELETE</th>
        <th>UPDATE</th>
  </tr>
  <% ArrayList<Mobile> mobiles = (ArrayList)request.getAttribute("data"); %>
  
  <% for(Mobile m : mobiles) { %>
  <tr>
        <td> <%= m.getId() %></td>
         <td> <%= m.getName() %></td>
          <td> <%= m.getBrand() %></td>
         <td> <%= m.getPrice() %></td>
          <td> <a href="delete?id=<%= m.getId() %>">delete</a> </td>
          <td> <a href="update?id=<%= m.getId() %>">edit</a> </td>
  </tr>
  <% } %>
</table>

</body>
</html>