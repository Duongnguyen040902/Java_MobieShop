/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author ADMIN
 */
public class Products {
    private int ProductID;
    private String ProductName;
    private int CategoryID;
    private String StorageCapacity;
    private double UnitPrice;
    private int UnitsInStock;
    private int UnitsOnOrder;
    private int ReorderLevel;
    private boolean Discontinued;
    private String Image;
    public Products() {
    }

    public Products(int ProductID, String ProductName, int CategoryID, String StorageCapacity, double UnitPrice, int UnitsInStock, boolean Discontinued, String Image) {
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.CategoryID = CategoryID;
        this.StorageCapacity = StorageCapacity;
        this.UnitPrice = UnitPrice;
        this.UnitsInStock = UnitsInStock;
        this.Discontinued = Discontinued;
        this.Image = Image;
    }

    public Products(String ProductName, int CategoryID, String StorageCapacity, double UnitPrice, int UnitsInStock, boolean Discontinued,String Image) {
        this.ProductName = ProductName;
        this.CategoryID = CategoryID;
        this.StorageCapacity = StorageCapacity;
        this.UnitPrice = UnitPrice;
        this.UnitsInStock = UnitsInStock;
        this.Discontinued = Discontinued;
        this.Image = Image;
    }
    
    
    
    
    
    

    public Products(String ProductName, int CategoryID, String StorageCapacity, double UnitPrice, int UnitsInStock, int UnitsOnOrder, int ReorderLevel, boolean Discontinued,String Image) {
        this.ProductName = ProductName;
        this.CategoryID = CategoryID;
        this.StorageCapacity = StorageCapacity;
        this.UnitPrice = UnitPrice;
        this.UnitsInStock = UnitsInStock;
        this.UnitsOnOrder = UnitsOnOrder;
        this.ReorderLevel = ReorderLevel;
        this.Discontinued = Discontinued;
        this.Image = Image;
    }
    
    
    

    public Products(int ProductID, String ProductName, int CategoryID, String StorageCapacity, double UnitPrice, int UnitsInStock, int UnitsOnOrder, int ReorderLevel, boolean Discontinued,String Image) {
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.CategoryID = CategoryID;
        this.StorageCapacity = StorageCapacity;
        this.UnitPrice = UnitPrice;
        this.UnitsInStock = UnitsInStock;
        this.UnitsOnOrder = UnitsOnOrder;
        this.ReorderLevel = ReorderLevel;
        this.Discontinued = Discontinued;
        this.Image = Image;
    }

    public Products(int ProductID, String ProductName, int CategoryID, double UnitPrice,String Image) {
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.CategoryID = CategoryID;
        this.UnitPrice = UnitPrice;
        this.Image = Image;
    }

    public Products(int ProductID, String ProductName, int CategoryID, String StorageCapacity, boolean Discontinued,String Image) {
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.CategoryID = CategoryID;
        this.StorageCapacity = StorageCapacity;
        this.Discontinued = Discontinued;
        this.Image = Image;
    }



    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public int getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(int CategoryID) {
        this.CategoryID = CategoryID;
    }

    public String getStorageCapacity() {
        return StorageCapacity;
    }

    public void setStorageCapacity(String StorageCapacity) {
        this.StorageCapacity = StorageCapacity;
    }


    public double getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(double UnitPrice) {
        this.UnitPrice = UnitPrice;
    }

    public int getUnitsInStock() {
        return UnitsInStock;
    }

    public void setUnitsInStock(int UnitsInStock) {
        this.UnitsInStock = UnitsInStock;
    }

    public int getUnitsOnOrder() {
        return UnitsOnOrder;
    }

    public void setUnitsOnOrder(int UnitsOnOrder) {
        this.UnitsOnOrder = UnitsOnOrder;
    }

    public int getReorderLevel() {
        return ReorderLevel;
    }

    public void setReorderLevel(int ReorderLevel) {
        this.ReorderLevel = ReorderLevel;
    }

    public boolean isDiscontinued() {
        return Discontinued;
    }

    public void setDiscontinued(boolean Discontinued) {
        this.Discontinued = Discontinued;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }
    

    @Override
    public String toString() {
        return "Products{" + "ProductID=" + ProductID + ", ProductName=" + ProductName + ", CategoryID=" + CategoryID + ", StorageCapacity=" + StorageCapacity + ", UnitPrice=" + UnitPrice + ", UnitsInStock=" + UnitsInStock + ", UnitsOnOrder=" + UnitsOnOrder + ", ReorderLevel=" + ReorderLevel + ", Discontinued=" + Discontinued + ", Image=" + Image + '}';
    }

    
    
}
