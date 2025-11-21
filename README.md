*Object Oriented Programming coursework from Stanford's CS108 curriculum.*

See the [assignment PDF](https://github.com/Gdzagaa1/cs108-hw5-web/blob/master/HW05Web.pdf)  for detailed explanation and implementation requirements.
# CS108 HW5 Web

Two Java EE mini–web apps from Stanford CS108 HW5 (see `HW05Web.pdf` for the full assignment). One app covers account login, the other a basic store backed by MySQL.

## Project Overview

This assignment consists of two separate web applications:

1. **User Login System** - A simple authentication system with account creation and login functionality
2. **Student Store** - An e-commerce website with product catalog and shopping cart features

## Technologies Used

- Java Servlets
- JSP (JavaServer Pages)
- MySQL Database
- Apache Tomcat
- JDBC for database connectivity

## What's Inside
- `login-web/` - JSP/Servlet login flow with `AccountManager`, `LoginServlet`, `CreateServlet`, and a context listener that preloads accounts for Patrick and Molly.
- `store-web/` – Student Store demo with a Tomcat listener that seeds a MySQL database, DAO helpers, product/detail JSPs, a cart servlet and a session listener that allocates per-user carts.
- `products.sql` – Standalone SQL script containing the same product catalog as the listener seeds.


## Notes
- These projects follow the workflow described in `HW05Web.pdf`;
- Images under `store-web/src/main/webapp/store-images/` come from The Stanford Store and remain their property.