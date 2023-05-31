<%@page import="com.js.dto.Mobile"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

   <h1>UPDATE YOUR DATA</h1>
     <% Mobile m = (Mobile)request.getAttribute("mobile"); %>
     
 <form action="edit" >
 <table style="background-color: lightblue; color: darkgreen;" width="400px;" height="400px;">


   <tr>
   <td> Mobile Id :</td>
   <td> <input type="text" name="id" value="<%= m.getId() %>" readonly="readonly">  </td> 
   </tr>
   
    <tr>
   <td> Mobile Name :</td>
   <td> <input type="text" name="name" value="<%= m.getName() %>">  </td> 
   </tr>

    <tr>
   <td>Brand :</td>
   <td> <input type="text" name="author" value="<%= m.getBrand() %>">  </td> 
   </tr>
   
    <tr>
   <td> Price :</td>
   <td> <input type="text" name="price" value="<%= m.getPrice() %>">  </td> 
   </tr>
   
    <tr>
   <td> <input type="submit" value="update">  </td> 
   </tr>
</table>
</form>
     
</body>
</html>