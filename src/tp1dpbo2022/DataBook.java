/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp1dpbo2022;

/**
 *
 * @author Satria Ramadhani
 */
public class DataBook
{
    private String img;
    private int id;
    private String title;
    private String publisher;
    private String author;
    private String description;

    public DataBook()
    {
        
    }
    
    public DataBook(int id, String title, String publisher, String author, String description)
    {
        this.id = id;
        this.title = title;
        this.publisher = publisher;
        this.author = author;
        this.description = description;
    }
    
    public int getID()
    {
        return id;
    }

    public void setID(int id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getPublisher()
    {
        return publisher;
    }

    public void setPublisher(String publisher)
    {
        this.publisher = publisher;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
}
