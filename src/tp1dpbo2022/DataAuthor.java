/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp1dpbo2022;

/**
 *
 * @author Satria Ramadhani
 */
public class DataAuthor
{
    private String img;
    private int id;
    private String name;
    private int total_book;
    
    public DataAuthor()
    {
        
    }
    
    public DataAuthor(int id, String name, int total_book)
    {
        this.id = id;
        this.name = name;
        this.total_book = total_book;
    }

    public int getID()
    {
        return id;
    }
    
    public void setID(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }

    public int getTotalBook()
    {
        return total_book;
    }

    public void setTotalBook(int total_book) {
        this.total_book = total_book;
    }
    
    
}
