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
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author duongndhhe163691
 */
public class ForgotPassword extends HttpServlet {
  
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Questions> q = new QuestionDAO().getQuestions();
        req.setAttribute("ListQ", q);
        req.getRequestDispatcher("../forgot.jsp").forward(req, resp);

    }

    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
          ArrayList<Questions> q = new QuestionDAO().getQuestions();
          req.setAttribute("ListQ", q);        
          String answer = req.getParameter("txtAnswer");
          req.setAttribute("answer", answer);
          String email = req.getParameter("txtEmail");
          int quesID = Integer.parseInt(req.getParameter("questionId"));
          Account acc = new AccountDAO().CheckEmailExist(email);
          if (answer.equals("")) {
            req.setAttribute("msgAnswer", "Your answer must be filled in");
            req.getRequestDispatcher("../forgot.jsp").forward(req, resp);
           }
          
          if(acc == null){
            req.setAttribute("msgEmailExist", "Email does not exist");  
            req.getRequestDispatcher("../forgot.jsp").forward(req, resp);
          }else{
              Account acc1 = new AccountDAO().getAccountByEmail(email, quesID, answer);
              req.getSession().setAttribute("Acc1Session", acc1);
              if(acc1 == null){
                  req.setAttribute("wrong", "Wrong data");
                  req.getRequestDispatcher("../forgot.jsp").forward(req, resp);  
              }else{ 
                  req.setAttribute("email", acc1.getEmail());        
                  req.getRequestDispatcher("../change-password.jsp").forward(req, resp);
              }
              
          }
                  
          
        
    }

}
