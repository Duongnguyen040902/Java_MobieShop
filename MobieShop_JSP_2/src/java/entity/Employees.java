/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.sql.Date;

/**
 *
 * @author ADMIN
 */
public class Employees {
    int EmployeeID;
    String LastName;
    String FirstName;
    int DepartmentID;
    String Title;
    Date BirthDate;
    String Address;

    public Employees() {
    }

    public Employees(int EmployeeID, String FirstName) {
        this.EmployeeID = EmployeeID;
        this.FirstName = FirstName;
    }
    
    

    public Employees(int EmployeeID, String LastName, String FirstName, int DepartmentID, String Title, Date BirthDate, String Address) {
        this.EmployeeID = EmployeeID;
        this.LastName = LastName;
        this.FirstName = FirstName;
        this.DepartmentID = DepartmentID;
        this.Title = Title;
        this.BirthDate = BirthDate;
        this.Address = Address;
    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(int EmployeeID) {
        this.EmployeeID = EmployeeID;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public int getDepartmentID() {
        return DepartmentID;
    }

    public void setDepartmentID(int DepartmentID) {
        this.DepartmentID = DepartmentID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }


    public Date getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(Date BirthDate) {
        this.BirthDate = BirthDate;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    @Override
    public String toString() {
        return "Employees{" + "EmployeeID=" + EmployeeID + ", LastName=" + LastName + ", FirstName=" + FirstName + ", DepartmentID=" + DepartmentID + ", Title=" + Title + ", BirthDate=" + BirthDate + ", Address=" + Address + '}';
    }
    
}
