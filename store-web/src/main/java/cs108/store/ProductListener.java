package cs108.store;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


// Opening new datasource. Keeping productDAO and datasource in servlet context
@WebListener
public class ProductListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try {
            setUpDatabase();
            BasicDataSource dataSource = new BasicDataSource();
            dataSource.setUrl("jdbc:mysql://localhost/products");
            dataSource.setUsername("root");
            dataSource.setPassword("");

            ProductDAO dao = new ProductDAO(dataSource);
            servletContextEvent.getServletContext().setAttribute("productDAO", dao);
            servletContextEvent.getServletContext().setAttribute("source", dataSource);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    // Sets up database, creates new database and table
    private void setUpDatabase() throws SQLException {
        try {
            BasicDataSource tempSource = new BasicDataSource();
            tempSource.setUrl("jdbc:mysql://localhost/");
            tempSource.setUsername("root");
            tempSource.setPassword("");

            try (Connection connection = tempSource.getConnection();
                 Statement statement = connection.createStatement()) {
                statement.executeUpdate("create database if not exists products");
            }

            tempSource.close();

            BasicDataSource newSource = new BasicDataSource();
            newSource.setUrl("jdbc:mysql://localhost/products");
            newSource.setUsername("root");
            newSource.setPassword("");

            try (Connection connection = newSource.getConnection();
                 Statement statement = connection.createStatement()) {

                statement.executeUpdate("DROP TABLE IF EXISTS products;");
                statement.executeUpdate("CREATE TABLE products (\n" +
                        "    productid CHAR(6),\n" +
                        "     name CHAR(64),\n" +
                        "    imagefile CHAR(64),\n" +
                        "    price DECIMAL(6,2)\n" +
                        ");");


                statement.executeUpdate("INSERT INTO products VALUES\n" +
                        "\t(\"HC\",\"Classic Hoodie\",\"Hoodie.jpg\",40),\n" +
                        "(\"HLE\", \"Limited Edition Hood\",\"LimitedEdHood.jpg\",54.95),\n" +
                        "\t(\"TC\", \"Classic Tee\",\"TShirt.jpg\",13.95),\n" +
                        "\t(\"TS\",\"Seal Tee\",\"SealTShirt.jpg\",19.95),\n" +
                        "\t(\"TLJa\",\"Japanese Tee\",\"JapaneseTShirt.jpg\",17.95),\n" +
                        "\t(\"TLKo\",\"Korean Tee\",\"KoreanTShirt.jpg\",17.95),\n" +
                        "\t(\"TLCh\",\"Chinese Tee\",\"ChineseTShirt.jpg\",17.95),\n" +
                        "\t(\"TLHi\",\"Hindi Tee\",\"HindiTShirt.jpg\",17.95),\n" +
                        "\t(\"TLAr\",\"Arabic Tee\",\"ArabicTShirt.jpg\",17.95),\n" +
                        "\t(\"TLHe\",\"Hebrew Tee\",\"HebrewTShirt.jpg\",17.95),\n" +
                        "\t(\"AKy\",\"Keychain\",\"Keychain.jpg\",2.95),\n" +
                        "\t(\"ALn\",\"Lanyard\",\"Lanyard.jpg\",5.95),\n" +
                        "\t(\"ATherm\",\"Thermos\",\"Thermos.jpg\",19.95),\n" +
                        "\t(\"AMinHm\",\"Mini Football Helmet\",\"MiniHelmet.jpg\",29.95);\n");

            }

            newSource.close();

        } catch (Exception e) {
            throw new SQLException();
        }

    }


    // Drops database and closes connection
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        try {
            BasicDataSource tempSource = new BasicDataSource();
            tempSource.setUrl("jdbc:mysql://localhost/");
            tempSource.setUsername("root");
            tempSource.setPassword("");

            try (Connection connection = tempSource.getConnection();
                 Statement statement = connection.createStatement()) {
                statement.executeUpdate("drop database if exists products");
            }

            tempSource.close();
            Object obj = servletContextEvent.getServletContext().getAttribute("source");
            if (obj instanceof BasicDataSource) {
                ((BasicDataSource) obj).close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
