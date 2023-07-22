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
public class CategoryControll extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        
        ArrayList<Category> p = new CategoryDAO().getCategorys();
        req.setAttribute("ListC", p);
        
        int cid = Integer.parseInt(req.getParameter("cid"));
        req.setAttribute("cateId", cid); //phan dung trang 
        
        String Cname = new CategoryDAO().getCategoryNameByCid(cid);
        req.setAttribute("CategoryName", Cname);
         
        //Xu ly paging ben file jsp tuong ung 
        
        //index == null thi mac dinh la trang dau thi cid = 1 va index = 1
        if (req.getParameter("index") == null) {
            ArrayList<Products> list = new CategoryDAO().PagingProductByCategory(cid, 1);
            //Day list product paging theo cate len ListP 
            req.setAttribute("ListP", list);
            req.setAttribute("tag", 1);
        } else { // index se tang dan voi nhung trang tiep theo va luc nay tag = index
            int index = Integer.parseInt(req.getParameter("index"));
            ArrayList<Products> list = new CategoryDAO().PagingProductByCategory(cid, index);
            //Day list product paging theo cate len ListP 
            req.setAttribute("ListP", list);
            req.setAttribute("tag", index);
        }
        
        int count = new CategoryDAO().getTotalProductByCategory(cid);
        int endPage = count / 8;
        if (count % 8 != 0) {
            endPage++;
        }
        req.setAttribute("endP", endPage);

        req.getRequestDispatcher("category.jsp").forward(req, resp);
    }

}
