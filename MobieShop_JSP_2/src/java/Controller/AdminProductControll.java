/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import entity.Category;
import entity.ProductCategory;
import entity.Products;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import DAL.CategoryDAO;
import DAL.ProductDAO;

/**
 *
 * @author ADMIN
 */
public class AdminProductControll extends HttpServlet {
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        if (req.getSession().getAttribute("AccAdminSession") == null) {
            resp.getWriter().print("Access denied");
        } else {
            req.getSession().setAttribute("pagingStatus", 1);

            ArrayList<Category> ListCategory = new CategoryDAO().getCategorys();
            req.setAttribute("ListC", ListCategory);

            //chia trang
            int count = new ProductDAO().getTotalProduct();
            int endPage = count / 10;
            if (count % 10 != 0) {
                endPage++;
            }
            req.setAttribute("endP", endPage);

            if (req.getParameter("index") == null) {
                ArrayList<ProductCategory> list = new ProductDAO().pagingAllProductCategory(1);
                req.setAttribute("listP", list);
                req.setAttribute("tag", 1);
            } else {
                int index = Integer.parseInt(req.getParameter("index"));
                ArrayList<ProductCategory> list = new ProductDAO().pagingAllProductCategory(index);
                req.setAttribute("listP", list);
                req.setAttribute("tag", index);
            }

            req.getRequestDispatcher("../product.jsp").forward(req, resp);
        }
      
        
    } 
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          processRequest(req, resp);
//        if (req.getSession().getAttribute("AccAdminSession") == null) {
//            resp.getWriter().print("Access denied");
//        } else {
//            req.getSession().setAttribute("pagingStatus", 1);
//
//            ArrayList<Category> ListCategory = new CategoryDAO().getCategorys();
//            req.setAttribute("ListC", ListCategory);
//
//            //chia trang
//            int count = new ProductDAO().getTotalProduct();
//            int endPage = count / 10;
//            if (count % 10 != 0) {
//                endPage++;
//            }
//            req.setAttribute("endP", endPage);
//
//            if (req.getParameter("index") == null) {
//                ArrayList<ProductCategory> list = new ProductDAO().pagingAllProductCategory(1);
//                req.setAttribute("listP", list);
//                req.setAttribute("tag", 1);
//            } else {
//                int index = Integer.parseInt(req.getParameter("index"));
//                ArrayList<ProductCategory> list = new ProductDAO().pagingAllProductCategory(index);
//                req.setAttribute("listP", list);
//                req.setAttribute("tag", index);
//            }

//            req.getRequestDispatcher("../product.jsp").forward(req, resp);
//        }
    }

    //req
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          processRequest(req, resp);
//        req.getSession().setAttribute("pagingStatus", 1);
//
//        ArrayList<Category> ListCategory = new CategoryDAO().getCategorys();
//        req.setAttribute("ListC", ListCategory);
//
//        //chia trang
//        int count = new ProductDAO().getTotalProduct();
//        int endPage = count / 10;
//        if (count % 10 != 0) {
//            endPage++;
//        }
//        req.setAttribute("endP", endPage);
//
//        if (req.getParameter("index") == null) {
//            ArrayList<ProductCategory> list = new ProductDAO().pagingAllProductCategory(1);
//            req.setAttribute("listP", list);
//            req.setAttribute("tag", 1);
//        } else {
//            int index = Integer.parseInt(req.getParameter("index"));
//            ArrayList<ProductCategory> list = new ProductDAO().pagingAllProductCategory(index);
//            req.setAttribute("listP", list);
//            req.setAttribute("tag", index);
//        }
//
//        req.getRequestDispatcher("../product.jsp").forward(req, resp);
//    }

}
}
