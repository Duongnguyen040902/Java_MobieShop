///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package DAL;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//
///**
// *
// * @author duongndhhe163691
// */
//public class DBContext {
//    public Connection connection;
//    /*USE BELOW METHOD FOR YOUR DATABASE CONNECTION FOR BOTH SINGLE AND MULTILPE SQL SERVER INSTANCE(s)*/
//    /*DO NOT EDIT THE BELOW METHOD, YOU MUST USE ONLY THIS ONE FOR YOUR DATABASE CONNECTION*/
//     public Connection getConnection()throws Exception {        
//        String url = "jdbc:sqlserver://"+serverName+":"+portNumber +
//                ";databaseName="+dbName;//+"; integratedSecurity=true";
//        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");         
//        return DriverManager.getConnection(url, userID, password);
////        return DriverManager.getConnection(url);
//    }
//    
//    /*Insert your other code right after this comment*/
//   
//    /*Change/update information of your database connection, DO NOT change name of instance variables in this class*/
//    private final String serverName = "localhost";
//    private final String dbName = "PRJ301_DB";
//    private final String portNumber = "1433";
//    private final String userID = "sa";
//    private final String password = "14012002dtpt";
//}
//class Using {
//    public static void main(String[] args) {
//        try{
//            new DBContext().getConnection();
//            System.out.println("Ket noi thanh cong");
//        } catch(Exception e){
//            System.out.println("Ket Noi that bai" +e.getMessage());
//        }              
//    }
//}
package entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author FPT University - PRJ301
 */
public class DBContext {
    protected Connection connection;
    public DBContext()
    {
        //@Students: You are allowed to edit user, pass, url variables to fit 
        //your system configuration
        //You can also add more methods for Database Interaction tasks. 
        //But we recommend you to do it in another class
        // For example : StudentDBContext extends DBContext , 
        //where StudentDBContext is located in dal package, 
        try {
            String user = "sa";
            String pass = "14012002dtpt";
            String url = "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=PRJ301_SE1705";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //ktra ket noi voi co so du lieu
    public static void main(String[] args) {
        System.out.println(new DBContext().connection);
    }
}