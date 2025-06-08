<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="cs108.store.Product, java.util.*" %>


<%
    HashMap<Product, Integer> cart = (HashMap<Product, Integer>) session.getAttribute("cart");
    if (cart == null) {
        cart = new HashMap<Product, Integer>();
    }
%>
<html>
  <head><title>Your Shopping Cart</title></head>
  <body>
    <h1>Your Cart</h1>
        <ul>
            <% Iterator<Product> keyIterator = cart.keySet().iterator();

            while (keyIterator.hasNext()) {
                Product p = keyIterator.next();
                int q = cart.get(p);
            %>
                <li>
                    <form action="CartServlet" method="post">
                      <input type="text" name="quantity" value="<%= q %>"/>
                    </form>

                <%= p.getName() %> — $<%= p.getPrice() %></li>
            <% } %>
        </ul>
    <p><a href="index.jsp">Back to Store</a></p>




  </body>
</html>