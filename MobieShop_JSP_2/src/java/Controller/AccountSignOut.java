/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author duongndhhe163691
 */
public class AccountSignOut extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Khi signIn xong va signout thi se xóa session và Hiên thi home
        if (req.getSession().getAttribute("AccSession") != null) {
            req.getSession().removeAttribute("AccSession");
            req.getRequestDispatcher("/home").forward(req, resp);
        } else if (req.getSession().getAttribute("AccAdminSession") != null) {
            req.getSession().removeAttribute("AccAdminSession");
            req.getRequestDispatcher("/home").forward(req, resp);
        }
    }
} 

