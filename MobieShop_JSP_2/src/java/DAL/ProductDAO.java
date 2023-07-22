/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import entity.Category;
import entity.DBContext;
import entity.ProductCategory;
import entity.Products;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductDAO extends entity.DBContext {

    public ArrayList<Products> getHotProduct() {
        ArrayList<Products> p = new ArrayList<>();
        try {
            String sql = "select top 4 * from (select COUNT(*) as numberOrder, ProductID from [Order Details_HE163691] \n"
                    + "group by ProductID) as A inner join Products_HE163691 on A.ProductID=Products_HE163691.ProductID ORDER BY numberOrder DESC";
            PreparedStatement ps = connection.prepareStatement(sql); //phai extends DBcontext
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int ProductID = rs.getInt("ProductID");
                String ProductName = rs.getString("ProductName");
                int CategoryID = rs.getInt("CategoryID");
                String StorageCapacity = rs.getString("StorageCapacity");
                double UnitPrice = rs.getDouble("UnitPrice");
                int UnitsInStock = rs.getInt("UnitsInStock");
                int UnitsOnOrder = rs.getInt("UnitsOnOrder");
                int ReorderLevel = rs.getInt("ReorderLevel");
                boolean Discontinued = rs.getBoolean("Discontinued");
                String Image = rs.getString("Image");

                p.add(new Products(ProductID, ProductName, CategoryID, StorageCapacity, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued, Image));

            }

        } catch (Exception e) {
            e.getStackTrace();
        }
        return p;

    }

    public ArrayList<Products> getNewProduct() {
        ArrayList<Products> p = new ArrayList<>();
        try {
            String sql = "select top 4 * from Products_HE163691 order by ProductID desc";
            PreparedStatement ps = connection.prepareStatement(sql); //phai extends DBcontext
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int ProductID = rs.getInt("ProductID");
                String ProductName = rs.getString("ProductName");
                int CategoryID = rs.getInt("CategoryID");
                String StorageCapacity = rs.getString("StorageCapacity");
                double UnitPrice = rs.getDouble("UnitPrice");
                int UnitsInStock = rs.getInt("UnitsInStock");
                int UnitsOnOrder = rs.getInt("UnitsOnOrder");
                int ReorderLevel = rs.getInt("ReorderLevel");
                boolean Discontinued = rs.getBoolean("Discontinued");
                String Image = rs.getString("Image");

                p.add(new Products(ProductID, ProductName, CategoryID, StorageCapacity, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued, Image));

            }

        } catch (Exception e) {
            e.getStackTrace();
        }
        return p;

    }

    public ArrayList<Products> getAllProduct() {
        ArrayList<Products> p = new ArrayList<>();
        try {
            String sql = "select * from Products_HE163691";
            PreparedStatement ps = connection.prepareStatement(sql); //phai extends DBcontext
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int ProductID = rs.getInt("ProductID");
                String ProductName = rs.getString("ProductName");
                int CategoryID = rs.getInt("CategoryID");
                String StorageCapacity = rs.getString("StorageCapacity");
                double UnitPrice = rs.getDouble("UnitPrice");
                int UnitsInStock = rs.getInt("UnitsInStock");
                int UnitsOnOrder = rs.getInt("UnitsOnOrder");
                int ReorderLevel = rs.getInt("ReorderLevel");
                boolean Discontinued = rs.getBoolean("Discontinued");
                String Image = rs.getString("Image");

                p.add(new Products(ProductID, ProductName, CategoryID, StorageCapacity, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued, Image));

            }

        } catch (Exception e) {
            e.getStackTrace();
        }
        return p;

    }

    public ArrayList<ProductCategory> pagingAllProductCategory(int index) {
        ArrayList<ProductCategory> list = new ArrayList<>();
        String sql = "select * from Products_HE163691 a INNER JOIN Categories_HE163691 b ON a.CategoryID=b.CategoryID\n"
                + "order by ProductID\n"
                + "offset ? rows fetch next 10 rows only";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 10);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int ProductID = rs.getInt("ProductID");
                String ProductName = rs.getString("ProductName");
                int CategoryID = rs.getInt("CategoryID");
                String StorageCapacity = rs.getString("StorageCapacity");
                double UnitPrice = rs.getDouble("UnitPrice");
                int UnitsInStock = rs.getInt("UnitsInStock");
                int UnitsOnOrder = rs.getInt("UnitsOnOrder");
                int ReorderLevel = rs.getInt("ReorderLevel");
                boolean Discontinued = rs.getBoolean("Discontinued");
                String Image = rs.getString("Image");

                String categoryName = rs.getString("CategoryName");

                Products product = new Products(ProductID, ProductName, CategoryID, StorageCapacity, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued, Image);
                Category category = new Category(CategoryID, categoryName);

                list.add(new ProductCategory(product, category));
            }
        } catch (Exception e) {

        }

        return list;
    }

    public int getTotalProduct() {
        try {
            String sql = "select count(*) from Products_HE163691 a INNER JOIN Categories_HE163691 b ON a.CategoryID=b.CategoryID";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public ArrayList<Products> SearchProductsByName(String txtSearch) {
        ArrayList<Products> p = new ArrayList<>();
        try {
            String sql = "select * from Products_HE163691 where ProductName like ?";
            PreparedStatement ps = connection.prepareStatement(sql); //phai extends DBcontext
            ps.setString(1, "%" + txtSearch + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int ProductID = rs.getInt("ProductID");
                String ProductName = rs.getString("ProductName");
                int CategoryID = rs.getInt("CategoryID");
                String StorageCapacity = rs.getString("StorageCapacity");
                double UnitPrice = rs.getDouble("UnitPrice");
                int UnitsInStock = rs.getInt("UnitsInStock");
                int UnitsOnOrder = rs.getInt("UnitsOnOrder");
                int ReorderLevel = rs.getInt("ReorderLevel");
                boolean Discontinued = rs.getBoolean("Discontinued");
                String Image = rs.getString("Image");

                p.add(new Products(ProductID, ProductName, CategoryID, StorageCapacity, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued, Image));

            }

        } catch (Exception e) {
            e.getStackTrace();
        }
        return p;

    }

    public ArrayList<ProductCategory> pagingSearchProductCategory(String txt, int index) {
        ArrayList<ProductCategory> list = new ArrayList<>();
        String sql = "select * from Products_HE163691 a INNER JOIN Categories_HE163691 b ON a.CategoryID=b.CategoryID where ProductName like ?\n"
                + "order by ProductID\n"
                + "offset ? rows fetch next 10 rows only";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + txt + "%");
            ps.setInt(2, (index - 1) * 10);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int ProductID = rs.getInt("ProductID");
                String ProductName = rs.getString("ProductName");
                int CategoryID = rs.getInt("CategoryID");
                String StorageCapacity = rs.getString("StorageCapacity");
                double UnitPrice = rs.getDouble("UnitPrice");
                int UnitsInStock = rs.getInt("UnitsInStock");
                int UnitsOnOrder = rs.getInt("UnitsOnOrder");
                int ReorderLevel = rs.getInt("ReorderLevel");
                boolean Discontinued = rs.getBoolean("Discontinued");
                String Image = rs.getString("Image");

                String categoryName = rs.getString("CategoryName");

                Products product = new Products(ProductID, ProductName, CategoryID, StorageCapacity, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued, Image);
                Category category = new Category(CategoryID, categoryName);

                list.add(new ProductCategory(product, category));
            }
        } catch (Exception e) {

        }

        return list;
    }

    public int getTotalProductCategorySearch(String txtSearch) {
        try {
            String sql = "select count(*) from Products_HE163691 a INNER JOIN Categories_HE163691 b ON a.CategoryID=b.CategoryID where ProductName like ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + txtSearch + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public ProductCategory getProductCategoryByProductID(int id) {
        ProductCategory p = null;
        try {
            String sql = "select *  from Products_HE163691 as a , Categories_HE163691 as b  where a.CategoryID=b.CategoryID AND a.ProductID=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int productID = rs.getInt("ProductID");
                String productName = rs.getString("ProductName");
                int categoryID = rs.getInt("CategoryID");
                String StorageCapacity = rs.getString("StorageCapacity");
                double unitPrice = rs.getDouble("UnitPrice");
                int unitsInStock = rs.getInt("UnitsInStock");
                int unitsOnOrder = rs.getInt("UnitsOnOrder");
                int reorderLevel = rs.getInt("ReorderLevel");
                boolean discontinued = rs.getBoolean("Discontinued");
                String Image = rs.getString("Image");

                String categoryName = rs.getString("CategoryName");
                Products product = new Products(productID, productName, categoryID, StorageCapacity, unitPrice, unitsInStock, unitsOnOrder, reorderLevel, discontinued, Image);
                Category category = new Category(categoryID, categoryName);

                p = new ProductCategory(product, category);
            }
        } catch (SQLException e) {
        }
        return p;
    }

    public Products getProductByProductID(int id) {
        try {
            String sql = "select *  from Products_HE163691 where ProductID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int productID = rs.getInt("ProductID");
                String productName = rs.getString("ProductName");
                int categoryID = rs.getInt("CategoryID");
                String StorageCapacity = rs.getString("StorageCapacity");
                double unitPrice = rs.getDouble("UnitPrice");
                int unitsInStock = rs.getInt("UnitsInStock");
                int unitsOnOrder = rs.getInt("UnitsOnOrder");
                int reorderLevel = rs.getInt("ReorderLevel");
                boolean discontinued = rs.getBoolean("Discontinued");
                String Image = rs.getString("Image");

                Products p = new Products(productID, productName, categoryID, StorageCapacity, unitPrice, unitsInStock, unitsOnOrder, reorderLevel, discontinued, Image);
                return p;
            }
        } catch (SQLException e) {
        }
        return null;
    }

    public int getTotalProductSearch(String txtSearch) {
        try {
            String sql = "select count(*) from Products_HE163691 where ProductName like ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + txtSearch + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public ArrayList<Products> pagingProductSearch(String txtSearch, int index) {
        ArrayList<Products> list = new ArrayList<>();
        String sql = "select * from Products_HE163691 where ProductName like ?\n"
                + "order by ProductID\n"
                + "offset ? rows fetch next 8 rows only";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + txtSearch + "%");
            ps.setInt(2, (index - 1) * 8);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int ProductID = rs.getInt("ProductID");
                String ProductName = rs.getString("ProductName");
                int CategoryID = rs.getInt("CategoryID");
                String StorageCapacity = rs.getString("StorageCapacity");
                double UnitPrice = rs.getDouble("UnitPrice");
                int UnitsInStock = rs.getInt("UnitsInStock");
                int UnitsOnOrder = rs.getInt("UnitsOnOrder");
                int ReorderLevel = rs.getInt("ReorderLevel");
                boolean Discontinued = rs.getBoolean("Discontinued");
                String Image = rs.getString("Image");

                list.add(new Products(ProductID, ProductName, CategoryID, StorageCapacity, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued, Image));

            }
        } catch (Exception e) {

        }

        return list;
    }

    public void update(Products p) {
        try {

            String sql = "update Products_HE163691 SET ProductName = ?, CategoryID = ?, "
                    + "StorageCapacity = ?, UnitPrice = ?, UnitsInStock = ?, "
                    + "Discontinued = ?, Image = ? where ProductID = ?";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, p.getProductName());
            ps.setInt(2, p.getCategoryID());
            ps.setString(3, p.getStorageCapacity());
            ps.setDouble(4, p.getUnitPrice());
            ps.setInt(5, p.getUnitsInStock());
            ps.setBoolean(6, p.isDiscontinued());
            ps.setString(7, "img/" + p.getImage());
            ps.setInt(8, p.getProductID());

            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void Delete(int ID) {
        String sql1 = "DELETE FROM Products_HE163691 WHERE ProductID = ?";
        String sql2 = "delete from [Order Details_HE163691] where ProductID = ?";
        try {

            PreparedStatement ps = connection.prepareStatement(sql2);
            ps.setInt(1, ID);
            ps.executeUpdate();

            PreparedStatement ps1 = connection.prepareStatement(sql1);
            ps1.setInt(1, ID);
            ps1.executeUpdate();

        } catch (SQLException e) {
        }
    }

    public void CreateProduct(Products p) {
        String sql = "insert into Products_HE163691(ProductName,CategoryID,StorageCapacity,UnitPrice,"
                + "UnitsInStock,Discontinued,Image)\n"
                + "values(?,?,?,?,?,?,?)";
        try {

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, p.getProductName());
            ps.setInt(2, p.getCategoryID());
            ps.setString(3, p.getStorageCapacity());
            ps.setDouble(4, p.getUnitPrice());
            ps.setInt(5, p.getUnitsInStock());
            ps.setBoolean(6, p.isDiscontinued());
            ps.setString(7, "img/" + p.getImage());
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

}
