package Controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import DAL.AccountDAO;
import entity.Account;
import entity.Customer;
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
public class AccountProfile2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if (req.getSession().getAttribute("AccSession") == null) {
            resp.getWriter().print("Access denied");
        } else {
        Account a = (Account) req.getSession().getAttribute("AccSession");
        Account account = new AccountDAO().getAccountCustomersByAccountID(a.getAccountID()).getAccount();
        req.setAttribute("account", account);
        req.getRequestDispatcher("../profile-changepassword.jsp").forward(req, resp);
    }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String oldPass = req.getParameter("txtOldPassword");
        String newPass = req.getParameter("txtNewPassword");
        String rePass = req.getParameter("txtRePassword");

        req.setAttribute("oldPass", oldPass);
        req.setAttribute("newPass", newPass);
        req.setAttribute("rePass", rePass);
        Account a = (Account) req.getSession().getAttribute("AccSession");
        if (!oldPass.equals(a.getPassword())) {
            req.setAttribute("wrongPass", "Old Password is incorrect");
            req.getRequestDispatcher("../profile-changepassword.jsp").forward(req, resp);
        } else {
            if (!newPass.equals(rePass)) {
                req.setAttribute("rePassNotMatch", "Passwords do not match");
                req.getRequestDispatcher("../profile-changepassword.jsp").forward(req, resp);
            } else {
                new AccountDAO().changePassword(newPass, a.getEmail());
                
                req.setAttribute("updatePassmsg", "Change password is succsessful");
                req.getRequestDispatcher("../home").forward(req, resp);
            }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
