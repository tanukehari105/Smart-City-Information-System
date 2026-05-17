
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lenovo
 */
abstract public class Admin {
	Connection con;

    private String name;
    private String phoneNo;
    private String gender;
    private String id;
    public Admin() {
    	  //initComponents();
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
   
    
    String getname()
    {
        return name;
    }
    String getphoneNo()
    {
        return phoneNo;
    }
    String getgender()
    {
        return gender;
    }
    String getid()
    {
        return id;
    }

    Admin(String name,String phoneNo,String gender,String id)
    {
        this.name=name;
        this.phoneNo=phoneNo;
        this.gender=gender;
        this.id=id;
             
    }
    
    void dataentry(info_type ob)
    {
    	 
        Statement stmt = null; 
        try {
             con.setAutoCommit(false); 
             System.out.println("Connection to SQL has been established.");
             stmt = con.createStatement();
             String sql = "INSERT INTO allinfo values('"+ob.getinfoType()+"','"+ob.getid()+"','"+ob.getname()+"','"+ob.getphoneNo()+"','"+ob.getlocation()+"')";         
               stmt.executeUpdate(sql);              
               stmt.close();          
               con.commit();          
               con.close(); 
        } catch (SQLException ex) {
            //Logger.getLogger(super_admin.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Fillup The Form");
        }
 
    }
    
    abstract String studentinfo(local_student ob);
    abstract String touristinfo(foreign_tourist ob);
    
   
}
