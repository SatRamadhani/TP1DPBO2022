/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp1dpbo2022;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Satria Ramadhani
 */
public class DBConnection
{
    public static Connection con;
    public Statement stm;
    
    public void connect()
    {
        String url = "jdbc:mysql://localhost/db_tp1dpbo2022";
        String user = "root";
        String pass = "";
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
            stm = con.createStatement();
            
            System.out.println("Connection succeeded.");
        } catch (Exception e)
        {
            System.err.println("Connection failed: " + e.getMessage());
        }
    }
    
    
    public DefaultTableModel readBook()
    {
        DefaultTableModel dataTable = null;
        
        try
        {
            this.connect();
            
            Object[] column = {"No", "Image", "Publisher", "Author", "Description"};
            dataTable = new DefaultTableModel(null, column);
            
            String query = "SELECT image, publisher, author, description FROM author";
            ResultSet res = stm.executeQuery(query);
            
            int no = 1;
            while(res.next())
            {
                Object[] result = new Object[5];
                result[0] = no;
                result[1] = res.getBlob("image");
                result[2] = res.getString("publisher");
                result[3] = res.getString("author");
                result[4] = res.getString("description");
                
                System.out.println(result[1]);
                dataTable.addRow(result);
                no++;
            }
        } catch (Exception e)
        {
            System.err.println("Read failed: " + e.getMessage());
        }
        
        return dataTable;
    }
    
    public ResultSet query(String input)
    {
        ResultSet res = null;
        
        try
        {
            this.connect();
            String query = input;
            res = stm.executeQuery(query);
        } catch (Exception e)
        {
            System.err.println("Read failed: " + e.getMessage());
        }
        
        return res;
    }
}
