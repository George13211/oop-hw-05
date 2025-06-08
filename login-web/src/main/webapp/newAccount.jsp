<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<html>
  <head>
  </head>
  <body>
<%
    String error = (String) request.getAttribute("error");
    if (error != null) {
%>
    <h1>The name ${name} is already in use</h1>
    <p>Please enter another name and password.</p>
<%
    } else {
%>
    <h1>Create New Account</h1>
    <p>Please enter proposed name and password.</p>
<%
    }
%>

    <form action="CreateServlet" method="post">
      <br/>
      User Name: <input type="text" name="name" />
      <br/>
      <br/>
      Password: <input type="password" name="password" />
      <input type="submit" value="Login" />
    </form>

  </body>
</html>