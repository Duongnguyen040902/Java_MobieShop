/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import entity.Account;
import entity.Category;
import entity.Customer;
import entity.Products;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import DAL.AccountDAO;
import DAL.CategoryDAO;
import DAL.ProductDAO;

/**
 *
 * @author ADMIN
 */
public class AccountSignIn extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            req.getRequestDispatcher("../signin.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("txtEmail");
        req.setAttribute("txtEmail", email);
        String pass = req.getParameter("txtPass");

        if (email.equals("") || pass.equals("")) {
            req.setAttribute("msgEmailNull", "Email is required");
            req.setAttribute("msgPassNull", "Password is required");
            req.getRequestDispatcher("../signin.jsp").forward(req, resp);
        } else {
            Account acc = new AccountDAO().getAccount(email, pass);

            if (acc != null && acc.getRole() == 2) {
                // Cap session cho account
                req.getSession().setAttribute("AccSession", acc);
                resp.sendRedirect("../home");

            } else if (acc != null && acc.getRole() == 1) {
                req.getSession().setAttribute("AccAdminSession", acc);
                //chuyển hướng đến một URL mới mà không mang theo du liêu
                resp.sendRedirect("../admin/product");
            } else {
                req.setAttribute("msgexist", "Incorrect password or account");
                req.getRequestDispatcher("../signin.jsp").forward(req, resp);
            }
        }
    }

}
