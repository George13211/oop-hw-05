<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
  </head>
  <body>
<%
    String error = (String) request.getAttribute("error");
    if (error != null) {
%>
    <h1>Please Try Again</h1>
    <p>Either your user name or password is incorrect.</p>
    <p>Please try again.<p>
<%
    } else {
%>
    <h1>Welcome to Homework 5</h1>
    <p>Please log in.</p>
<%
    }
%>

    <form action="LoginServlet" method="post">
      User Name: <input type="text" name="name" />
      <br/>
      <br/>
      Password: <input type="password" name="password" />
      <input type="submit" value="Login" />
    </form>

    <p><a href="newAccount.jsp">Create New Account</a></p>
  </body>
</html>