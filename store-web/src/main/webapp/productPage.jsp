<%@ page import="cs108.store.ProductDAO, cs108.store.Product" %>
<%
    String productId = request.getParameter("id");
    ProductDAO dao = (ProductDAO) application.getAttribute("productDAO");
    Product product = dao.getProductById(productId);
%>

<html>
  <head><title><%= product.getName() %></title></head>
  <body>
    <h1><%= product.getName() %></h1>
    <img src="store-images/<%= product.getImageFile() %>" alt="<%= product.getName() %>" width="200"/>
    <p> $<%= product.getPrice() %></p>

      <form action="cart" method="post">
          <input type="hidden" name="productID" value="<%= product.getId() %>"/>
          <input type="submit" value="Add to Cart"/>
      </form>

    <p><a href="index.jsp">Back to Store</a></p>
  </body>
</html>