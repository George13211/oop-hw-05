package cs108.store;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private final BasicDataSource dataSource;

    public ProductDAO(BasicDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("select * from products")) {
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Product p = new Product(result.getString("productid"), result.getString("name"),
                        result.getString("imagefile"), result.getInt("price"));
                products.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    public Product getProductById(String id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement("select * from products where productid = ?")) {
            statement.setString(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                Product p = new Product(result.getString("productid"), result.getString("name"),
                        result.getString("imagefile"), result.getInt("price"));
                return p;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}