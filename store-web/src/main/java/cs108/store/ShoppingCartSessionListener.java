package cs108.store;

import javax.servlet.http.*;
import javax.servlet.annotation.WebListener;
import java.util.ArrayList;
import java.util.HashMap;

@WebListener
public class ShoppingCartSessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent session) {
        session.getSession().setAttribute("cart", new HashMap<Product, Integer>());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent session) {

    }
}