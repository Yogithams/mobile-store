<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="font-size: 25px;">

  <h3>ENTER MOBILE DETAILS</h3>
  <form action="savemobile" method="post"  >
<table style="background-color: lightblue; color: darkgreen;" width="400px;" height="400px;">


   <tr>
   <td> Mobile Id :</td>
   <td> <input type="text" name="id">  </td> 
   </tr>
   
    <tr>
   <td> Mobile Name :</td>
   <td> <input type="text" name="name" >  </td> 
   </tr>
   
    <tr>
   <td>Brand :</td>
   <td> <input type="text" name="brand">  </td> 
   </tr>
   
    <tr>
   <td>Price :</td>
   <td> <input type="text" name="price">  </td> 
   </tr>
   
    <tr>
   <td> <input type="submit" value="Save">  </td> 
   </tr>
</table>
</form>

</body>
</html>