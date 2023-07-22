/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import entity.Account;
import entity.Customer;
import entity.Questions;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import DAL.AccountDAO;
import DAL.QuestionDAO;

/**
 *
 * @author ADMIN
 */
public class AccountSignUp extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Questions> q = new QuestionDAO().getQuestions();
        req.setAttribute("ListQ", q);
        req.getRequestDispatcher("../signup.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("txtEmail");
        String pass = req.getParameter("txtPass");
        String repass = req.getParameter("txtRePass");
        String answer = req.getParameter("txtAnswer");
        String companyname = req.getParameter("txtCompanyName");
        String contactname = req.getParameter("txtContactName");
        String contacttitle = req.getParameter("txtContactTitle");
        String address = req.getParameter("txtAddress");
        
        ArrayList<Questions> q = new QuestionDAO().getQuestions();
        req.setAttribute("ListQ", q);
    

        req.setAttribute("email", email);
        req.setAttribute("companyname", companyname);
        req.setAttribute("contactname", contactname);
        req.setAttribute("contacttitle", contacttitle);
        req.setAttribute("address", address);
        req.setAttribute("answer", answer);

        // setAttribute rong de in ra message loi~
        if (email.equals("")) {
            req.setAttribute("msgEmail", "");
        }
        if (pass.equals("")) {
            req.setAttribute("msgPass", "");
        }
        if (repass.equals("")) {
            req.setAttribute("msgRePass", "");
        }
        if (companyname.equals("")) {
            req.setAttribute("msgCompanyName", "");
        }
        if (contactname.equals("")) {
            req.setAttribute("msgContactName", "");
        }
        if (contacttitle.equals("")) {
            req.setAttribute("msgContactTitle", "");
        }
        if (address.equals("")) {
            req.setAttribute("msgAddress", "");
        }
        if (answer.equals("")) {
            req.setAttribute("msgAnswer", "");
        }

        if (pass.equals(repass)) {
            if (email.equals("") || pass.equals("") || repass.equals("")
                    || companyname.equals("") || contactname.equals("") || contacttitle.equals("") || address.equals("") || answer.equals("")) {
                req.getRequestDispatcher("../signup.jsp").forward(req, resp);
            } else {
                Account acc = new AccountDAO().CheckEmailExist(email);
                //neu acc chua ton tai thi se them thong tin nguoi dung cua signup
                if (acc == null && !email.isEmpty() && !companyname.isEmpty() && !contactname.isEmpty()
                        && !contacttitle.isEmpty() && !address.isEmpty() && !answer.isEmpty()) {
                    int quesID = Integer.parseInt(req.getParameter("questionID"));
                    Customer cust = new Customer(companyname, contactname, contacttitle, address);
                    acc = new Account(email, pass, quesID, answer);
                    //neu da signup dc thi se gui yeu cau sang signin.jsp va hien thi signin
                    if (new AccountDAO().CreateAccount(cust, acc) > 0) {
                        req.getRequestDispatcher("../signin.jsp").forward(req, resp);
                    } else {
                        req.getRequestDispatcher("../signup.jsp").forward(req, resp);
                    }
                } else if (acc != null) { // neu acc != null luc nay email da ton tai
                    req.setAttribute("msgEmailExist", "Account already exists!");
                    req.getRequestDispatcher("../signup.jsp").forward(req, resp);
                }
            }
        } else {
            req.setAttribute("msg2RePass", "Re-entered password does not match!");
            req.getRequestDispatcher("../signup.jsp").forward(req, resp);
        }

    }
}
