/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import entity.Account;
import entity.AccountCustomer;
import entity.Customer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class AccountDAO extends entity.DBContext {

    public Account getAccount(String email, String pass) {
        Account acc = null;
        try {
            String sql = "select * from Accounts_HE163691 where Email=? and Password=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int AccountID = rs.getInt("AccountID");
                String Email = rs.getString("Email");
                String Password = rs.getString("Password");
                String CustomerID = rs.getString("CustomerID");
                int EmployeeID = rs.getInt("EmployeeID");
                int Role = rs.getInt("Role");
                int QuestionID = rs.getInt("QuestionID");
                String Answer = rs.getString("Answer");
                acc = new Account(AccountID, Email, Password, CustomerID, EmployeeID, Role, QuestionID, Answer);
                return acc;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Account getAccountByEmail(String email, int questionId, String answer) {
        Account acc = null;
        try {
            String sql = "select * from Accounts_HE163691 where Email=? and QuestionID=? and Answer=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            ps.setInt(2, questionId);
            ps.setString(3, answer);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int AccountID = rs.getInt("AccountID");
                String Email = rs.getString("Email");
                String Password = rs.getString("Password");
                String CustomerID = rs.getString("CustomerID");
                int EmployeeID = rs.getInt("EmployeeID");
                int Role = rs.getInt("Role");
                int QuestionID = rs.getInt("QuestionID");
                String Answer = rs.getString("Answer");
                acc = new Account(AccountID, Email, Password, CustomerID, EmployeeID, Role, QuestionID, Answer);
                return acc;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Account CheckEmailExist(String email) {
        Account p = null;
        try {
            String sql = "select * from Accounts_HE163691\n"
                    + "where Email = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                p = new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getString(8));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }

    public void SignUpInAccount(String email, String pass) {
        String sql = "insert into Accounts_HE163691 (Email, [Password])\n"
                + "values(?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, pass);
            //khong tra ve kh can ham result va 
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String randomString(int n) {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            int index
                    = (int) (AlphaNumericString.length()
                    * Math.random());
            sb.append(AlphaNumericString
                    .charAt(index));
        }
        return sb.toString();
    }

    public int CreateAccount(Customer cust, Account acc) {
        int result1 = 0, result2 = 0;
        String sql1 = "insert into Customers_HE163691(CustomerID, CompanyName,ContactName,ContactTitle,Address) values(?,?,?,?,?)";
        String sql2 = "insert into Accounts_HE163691(Email,Password,CustomerID,Role,QuestionID,Answer) values(?,?,?,?,?,?)";
        String a = randomString(5);
        try {
            PreparedStatement ps1 = connection.prepareStatement(sql1);
            PreparedStatement ps2 = connection.prepareStatement(sql2);
            ps1.setString(1, a);
            ps1.setString(2, cust.getCompanyName());
            ps1.setString(3, cust.getContactName());
            ps1.setString(4, cust.getContactTitle());
            ps1.setString(5, cust.getAddress());

            ps2.setString(1, acc.getEmail());
            ps2.setString(2, acc.getPassword());
            ps2.setString(3, a);
            ps2.setInt(4, 2);
            ps2.setInt(5, acc.getQuestionID());
            ps2.setString(6, acc.getAnswer());

            result1 = ps1.executeUpdate(); // tra ve gia tri result1 sô dòng dã insert
            result2 = ps2.executeUpdate(); // tra ve gia tri result2 sô dòng dã insert

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (result1 > 0 && result2 > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public AccountCustomer getAccountCustomersByAccountID(int id) {
        AccountCustomer p = null;
        try {
            String sql = "select * from Accounts_HE163691 as a left join Customers_HE163691 as c on a.CustomerID = c.CustomerID where AccountID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int AccountID = rs.getInt("AccountID");
                String Email = rs.getString("Email");
                String Password = rs.getString("Password");
                String CustomerID = rs.getString("CustomerID");
                int EmployeeID = rs.getInt("EmployeeID");
                int Role = rs.getInt("Role");

                String CompanyName = rs.getString("CompanyName");
                String ContactName = rs.getString("ContactName");
                String ContactTitle = rs.getString("ContactTitle");
                String Address = rs.getString("Address");
                int QuestionID = rs.getInt("QuestionID");
                String Answer = rs.getString("Answer");

                Account account = new Account(AccountID, Email, Password, CustomerID, EmployeeID, Role, QuestionID, Answer);
                Customer customer = new Customer(CustomerID, CompanyName, ContactName, ContactTitle, Address);

                return p = new AccountCustomer(account, customer);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return null;
    }

    public void EditInfo(Customer c) {
        try {
            String sql = "update Customers_HE163691 set CompanyName = ?, ContactName = ?, ContactTitle = ?, Address = ? where CustomerID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, c.getCompanyName());
            ps.setString(2, c.getContactName());
            ps.setString(3, c.getContactTitle());
            ps.setString(4, c.getAddress());
            ps.setString(5, c.getCustomerID());

            //TRA VE DUNG SO HANG DUOC UPDATE
            ps.executeUpdate();

        } catch (Exception e) {
        }
    }

    public void changePassword(String password, String email) {
        String sql = " update Accounts_HE163691 set Password = ? where Email = ?";
               
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, password);
            ps.setString(2, email);
            ps.executeUpdate();

        } catch (Exception e) {

        }
    }
    public void changeSecurity(int questionId, String answer, String email) {
        String sql = "update Accounts_HE163691 set QuestionID = ?, Answer = ? where Email = ?";
               
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, questionId);
            ps.setString(2, answer);
            ps.setString(3, email);
            ps.executeUpdate();

        } catch (Exception e) {

        }
    }
    

    public void CreateCustomer(Customer cust) {
        String sql = "insert into Customers_HE163691(CustomerID, CompanyName,ContactName,ContactTitle,Address) values(?,?,?,?,?)";
        String a = randomString(5);
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, a);
            ps.setString(2, cust.getCompanyName());
            ps.setString(3, cust.getContactName());
            ps.setString(4, cust.getContactTitle());
            ps.setString(5, cust.getAddress());

            ps.executeUpdate();

        } catch (Exception e) {
        }

    }

    public static void main(String[] args) {

//        Customer customer = new Customer("32Ulg", "GGG", "UUU", "TTT", "AAA");
//        new AccountDAO().EditInfo(customer);
//        System.out.println(customer);
         new AccountDAO().getAccount("cust1@gmail.com", "123");
        
        
    }

}
