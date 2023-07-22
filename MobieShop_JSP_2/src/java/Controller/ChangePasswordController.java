

package Controller;

import DAL.AccountDAO;
import entity.Account;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class ChangePasswordController extends HttpServlet {
  
   

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       request.getRequestDispatcher("../change-password.jsp").forward(request, response);
              
    }
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String email = request.getParameter("txtemail");
        String password = request.getParameter("txtPassword");
        String rePassword = request.getParameter("txtRe-password");
        
        
        if(!password.equals(rePassword)){
            request.setAttribute("msgNotMatch", "Re-Password does not match");
            request.setAttribute("email", email);
            request.getRequestDispatcher("../change-password.jsp").forward(request, response);
        } else {
           new AccountDAO().changePassword(password, email);
           request.setAttribute("msgChangeSuccess", "Change password is succsessful");
           request.getRequestDispatcher("../signin.jsp").forward(request, response);
        }
            
        
        
       
    }
}
