
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lenovo
 */
public class sqlconnection {
	Connection con;
	 public sqlconnection() {
	       // initComponents();
	        try{
	        	Class.forName("com.mysql.cj.jdbc.Driver");
	            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/smartcity", "root", "Aaft@b22");
	        }
	        catch(ClassNotFoundException e){
	            e.printStackTrace();
	        }
	        catch(SQLException e){
	            e.printStackTrace();
	        }
	    }
	
    
     void connection() throws SQLException
     {
       
        Statement stmt = null;
        con.setAutoCommit(false); 
        System.out.println("Connection to SQL has been established.");
        stmt = con.createStatement();
     }
}
