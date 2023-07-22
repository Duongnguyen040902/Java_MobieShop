/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import entity.Account;
import entity.Customer;
import entity.OrderDetail;
import entity.Orders;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import jdk.nashorn.internal.runtime.regexp.joni.EncodingHelper;
import DAL.AccountDAO;
import DAL.OrderDAO;

/**
 *
 * @author ADMIN
 */
public class AccountProfile1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("AccSession") == null) {
            resp.getWriter().print("Access denied");
        } else {
            Account a = (Account) req.getSession().getAttribute("AccSession");
            Customer customer = new AccountDAO().getAccountCustomersByAccountID(a.getAccountID()).getCustomer();
            req.setAttribute("customer", customer);

            ArrayList<Orders> order = new OrderDAO().getOrderByCustomerId(customer.getCustomerID());
            req.setAttribute("order", order);
            req.setAttribute("OrderDAO", new OrderDAO());
            req.getRequestDispatcher("../profile1.jsp").forward(req, resp);

        }
    }

}
