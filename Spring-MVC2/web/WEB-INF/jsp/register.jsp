<%-- 
    Document   : register
    Created on : 03-Aug-2022, 4:24:58 PM
    Author     : CDAC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="fm"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <center>
      <!--  <form action="userregistration" method="post">
            <input name="username" type="text"><br> <br>
            <input name="password" type="password"><br><br>
            <input id="confirmpassword" type="password"><br><br>
            <input type="submit" value="Register">
        </form>
      -->
      
      <fm:form action="userregistration" method="post">
          <fm:input path="username"/><br>
          <fm:password path="password"/><br><br>        
          <input type="submit" value="Register"/>
      </fm:form>     
      ${msg}
      </center>
    </body>
</html>
