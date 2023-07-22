/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import entity.Category;
import entity.Products;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import DAL.CategoryDAO;
import DAL.ProductDAO;

/**
 *
 * @author ADMIN
 */
public class HomeSearchControll extends HttpServlet {

    @Override
    // Hien thi trang dau tien khi tim kiem voi tag = 1, su dung method post o header
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("UTF-8");
        req.getSession().setAttribute("homeStatus", 3);
        
        String txtSearch = req.getParameter("txt");
        req.setAttribute("txt", txtSearch);
        
        if(txtSearch==""){
            req.setAttribute("allProduct", "ALL PRODUCTS");
        }
        
        ArrayList<Category> ListCategory = new CategoryDAO().getCategorys();
        req.setAttribute("ListC", ListCategory);
        
        //get List ProductSearch with Paging 8 item in 1 page
        ArrayList<Products> s = new ProductDAO().pagingProductSearch(txtSearch, 1);
        req.setAttribute("listS", s);
        req.setAttribute("tag", 1);

        int count = new ProductDAO().getTotalProductSearch(txtSearch);
        int endPage = count / 8;
        if (count % 8 != 0) {
            endPage++;
        }
        req.setAttribute("endP", endPage);
        req.getRequestDispatcher("index.jsp").forward(req, resp);

    }
    
//    Hien thi trang ke tiep khi tim kiem voi tag = index, chay the paging
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("UTF-8");
        
        ArrayList<Category> ListCategory = new CategoryDAO().getCategorys();
        req.setAttribute("ListC", ListCategory);

        int index = Integer.parseInt(req.getParameter("index"));
        req.setAttribute("tag", index);
        
        String txtSearch = req.getParameter("txt"); //lay tu nguoi dung nhap ve tren jsp de search va paging
        req.setAttribute("txt", txtSearch);
        if(txtSearch==""){
            req.setAttribute("allProduct", "ALL PRODUCTS");
        }
        // paging
        int count = new ProductDAO().getTotalProductSearch(txtSearch);
        int endPage = count / 8;
        if (count % 8 != 0) {
            endPage++;
        }
        ArrayList<Products> list = new ProductDAO().pagingProductSearch(txtSearch, index);

        req.setAttribute("txt", txtSearch);
        req.setAttribute("listS", list);
        req.setAttribute("endP", endPage);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

}
