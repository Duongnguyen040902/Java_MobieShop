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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import DAL.CategoryDAO;
import DAL.ProductDAO;

/**
 *
 * @author ADMIN
 */
public class AdminProductCreateControll extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("AccAdminSession") == null) {
            resp.getWriter().print("Access denied");
        } else {
            req.getSession().setAttribute("productStatus", 1);

            ArrayList<Category> ListCategory = new CategoryDAO().getCategorys();
            req.setAttribute("ListC", ListCategory);

            req.getRequestDispatcher("../create-product.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String StorageCapacity = req.getParameter("txtStorageCapacity");
        boolean discontinued = !(req.getParameter("chkDiscontinued") == null);
        int categoryID = Integer.parseInt(req.getParameter("ddlCategory"));
        String image = req.getParameter("image");
        

        Products productCreate = new Products();
        int check = 0;

        String productName = req.getParameter("txtProductName");

        if (productName.isEmpty()) {
            req.setAttribute("productNameMsg", "productName not allow null");
            check++;
        }
 
        int unitsInStock = Integer.parseInt(req.getParameter("txtUnitsInStock"));
        if (Integer.parseInt(req.getParameter("txtUnitsInStock")) < 0 ) {
            req.setAttribute("unitsInStockMsg", "unitsInStock must greater or equal zero");
            check++;
        }

        double unitPrice = Double.parseDouble(req.getParameter("txtUnitPrice"));
        if (unitPrice < 0) {
            req.setAttribute("unitPriceMsg", "unitPrice must greater or equal zero");
            check++;
        }

        productCreate = new Products(productName, categoryID, StorageCapacity, unitPrice, unitsInStock, discontinued,image);

        if (check != 0) {

            req.setAttribute("product", productCreate);

            ArrayList<Category> ListCategory = new CategoryDAO().getCategorys();
            req.setAttribute("ListC", ListCategory);

            req.getRequestDispatcher("../create-product.jsp").forward(req, resp);
            return;
        }

        new ProductDAO().CreateProduct(productCreate);
        req.setAttribute("createSuccess", "Create product success");

        req.getRequestDispatcher("../admin/product").forward(req, resp);

    }
}
