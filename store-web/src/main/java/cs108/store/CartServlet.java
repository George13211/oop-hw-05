package cs108.store;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String productId = req.getParameter("productID");
        ProductDAO dao = (ProductDAO) getServletContext().getAttribute("productDAO");
        Product product = dao.getProductById(productId);

        if (product != null) {
            HttpSession session = req.getSession();
            HashMap<Product, Integer> cart = (HashMap<Product, Integer>) session.getAttribute("cart");

            if (cart == null) {
                cart = new HashMap<Product, Integer>();
                session.setAttribute("cart", cart);
            }

            Integer quantity = 1;
            if (cart.get(product) != null) {
                   quantity += cart.get(product);
            }
            cart.put(product, quantity);
        }

        resp.sendRedirect("viewCart.jsp");
    }
}