/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import entity.Category;
import entity.ProductCategory;
import entity.Products;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class CategoryDAO extends entity.DBContext {

    public ArrayList<Category> getCategorys() {
        ArrayList<Category> list = new ArrayList<>();
        try {
            String sql = "select * from Categories_HE163691";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int CategoryID = rs.getInt("CategoryID");
                String CategoryName = rs.getString("CategoryName");
                String Description = rs.getString("Description");

                Category p = new Category(CategoryID, CategoryName, Description);

                list.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public String getCategoryNameByCid(int cid) {
        try {
            String sql = "select CategoryName from Categories_HE163691 where CategoryID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, cid);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                return rs.getString(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Products> getProductByCategory(String cid) {
        ArrayList<Products> list = new ArrayList<>();
        try {
            String sql = "select * from Products_HE163691 where CategoryID = ?";
            PreparedStatement ps = connection.prepareStatement(sql); //phai extends DBcontext
            ps.setString(1, cid);
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

                Products p = new Products(ProductID, ProductName, CategoryID, StorageCapacity, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued, Image);
                list.add(p);

            }

        } catch (Exception e) {
            e.printStackTrace();

        }
        return list;
    }

    public ArrayList<Products> PagingProductByCategory(int cid, int index) {
        ArrayList<Products> list = new ArrayList<>();
        try {
            String sql = "select * from Products_HE163691 where CategoryID = ?\n"
                    + "order by CategoryID\n"
                    + "offset ? rows fetch next 8 rows only";
            PreparedStatement ps = connection.prepareStatement(sql); //phai extends DBcontext
            ps.setInt(1, cid);
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

                Products p = new Products(ProductID, ProductName, CategoryID, StorageCapacity, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued,Image);
                list.add(p);

            }

        } catch (Exception e) {
            e.printStackTrace();

        }
        return list;
    }

    public ArrayList<ProductCategory> PagingProductCategoryByCategory(int cid, int index) {
        ArrayList<ProductCategory> list = new ArrayList<>();
        try {
            String sql = "select * from Products_HE163691 a INNER JOIN Categories_HE163691 b ON a.CategoryID=b.CategoryID where a.CategoryID = ?\n"
                    + "order by ProductID\n"
                    + "offset ? rows fetch next 10 rows only";
            PreparedStatement ps = connection.prepareStatement(sql); //phai extends DBcontext
            ps.setInt(1, cid);
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

                Products product = new Products(ProductID, ProductName, CategoryID, StorageCapacity, UnitPrice, UnitsInStock, UnitsOnOrder, ReorderLevel, Discontinued,Image);
                Category category = new Category(CategoryID, categoryName);

                list.add(new ProductCategory(product, category));

            }

        } catch (Exception e) {
            e.printStackTrace();

        }
        return list;
    }

    public ArrayList<ProductCategory> PagingProductCategoryByCategoryProductName(int cid,String txt, int index) {
        ArrayList<ProductCategory> list = new ArrayList<>();
        try {
            String sql = "select * from Products_HE163691 as a inner join Categories_HE163691 as b on a.CategoryID = b.CategoryID where a.CategoryID = ? and ProductName like ?\n"
                    + "order by ProductID\n"
                    + "offset ? rows fetch next 10 rows only";
            PreparedStatement ps = connection.prepareStatement(sql); //phai extends DBcontext
            ps.setInt(1, cid);
            ps.setString(2, "%" + txt + "%");
            ps.setInt(3, (index - 1) * 10);
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
            e.printStackTrace();
        }
        return list;
    }

    public int getTotalProductByCategoryProductName(String txt, int cid) {
        try {
            String sql = "select count(*) from Products_HE163691 where CategoryID = ? and ProductName like ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, cid);
            ps.setString(2, "%" + txt + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public int getTotalProductByCategory(int cid) {
        try {
            String sql = "select count(*) from Products_HE163691 where CategoryID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, cid);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public static void main(String[] args) {
        ArrayList<ProductCategory> list = new CategoryDAO().PagingProductCategoryByCategoryProductName(1,"cha", 1);
        for (ProductCategory productCategory : list) {
            System.out.println(productCategory);
        }
    }
}
