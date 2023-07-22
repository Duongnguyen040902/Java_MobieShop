/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import DAL.AccountDAO;
import DAL.QuestionDAO;
import entity.Account;
import entity.Questions;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author duongndhhe163691
 */
public class AccountProfile3 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if (req.getSession().getAttribute("AccSession") == null) {
            resp.getWriter().print("Access denied");
        } else {
//        Account a = (Account) req.getSession().getAttribute("AccSession");
//        Account account = new AccountDAO().getAccountCustomersByAccountID(a.getAccountID()).getAccount();
//        req.setAttribute("account", account);
        ArrayList<Questions> q = new QuestionDAO().getQuestions();
        req.setAttribute("listQ", q);
        req.getRequestDispatcher("../change-securityquestion.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String pass = req.getParameter("txtYourPassword");
        String answer = req.getParameter("txtAnswer");
        ArrayList<Questions> q = new QuestionDAO().getQuestions();
        req.setAttribute("listQ", q);
        
        Account a = (Account) req.getSession().getAttribute("AccSession");
        if(!pass.equals(a.getPassword())){
            req.setAttribute("incorrectPass", "Incorrect password");
            req.getRequestDispatcher("../change-securityquestion.jsp").forward(req, resp);
        }else{
             int quesID = Integer.parseInt(req.getParameter("questionId"));
             new AccountDAO().changeSecurity(quesID, answer, a.getEmail());
             req.setAttribute("changeSuccsess", "Change security quesstion is success");
             req.getRequestDispatcher("../home").forward(req, resp);
        }
        
        

    }


}
