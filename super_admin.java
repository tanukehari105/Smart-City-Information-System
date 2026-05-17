
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class super_admin extends Admin{
    private int experience;
    Connection con;
    int getexperience()
    {
        return experience;
    }
      
    super_admin(String name,String phoneNo,String gender,String id ,int experience)
    {
        super(name,phoneNo,gender,id);
        this.experience=experience;
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
    
    
    
    void deletedata(info_type ob)
    {
        //Connection conn = null;
        
        Statement stmt = null;
        PreparedStatement stm = null;
        String sql="Delete from allinfo WHERE id='" +ob.getid()+"';";
        try
        {
        
            System.out.println("Connection to SQL has been established.");
            stmt = con.createStatement();
            int rs=stmt.executeUpdate(sql);
            
            if(rs==1){
                     JOptionPane.showMessageDialog(null,"Successfully Deleted Profile");
                    
            }
            else{
               JOptionPane.showMessageDialog(null,"Could not deleted profile");
            }

        }
        catch(Exception e)
        {
            //e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Fillup The Form");
        }
    }
    
    String studentinfo(local_student ob)
    {
        if(ob.getgender().equals("male"))
        {
            return "ID: "+ob.getid()+" "+"Name: "+ob.getname()+" "+"Institute: "+ob.getinstitute();
        }
        return null;
    }
    
    String touristinfo(foreign_tourist ob)
    {
        if(ob.getcountry().equals("uk"))
        {
            return "ID: "+ob.getid()+" "+"Name: "+ob.getname()+" "+"Institute: "+ob.getaddress();
        }
        return null;
    }
}
