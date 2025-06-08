<%@ page import="cs108.store.ProductDAO, cs108.store.Product, java.util.*" %>
<%
    ProductDAO dao = (ProductDAO) application.getAttribute("productDAO");
    List<Product> products = dao.getAllProducts();
%>
<html>
<head><title>Store Home</title></head>
<body>
    <h1>Student Store</h1>
   <p1>Items available:<p1>
<ul>
  <% for (Product p : products) { %>
    <li>
      <a href="productPage.jsp?id=<%= p.getId() %>">
        <%= p.getName() %>
      </a>
    </li>
  <% } %>
</ul>

</body>
</html>