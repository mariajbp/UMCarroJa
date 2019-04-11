import java.util.*;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * DESCREVER ESTA CLASSE DE UMA MANEIRA PANELEIRA 
 */
public class Client extends USER implements Serializable
{
  private double walk;  //4km por hora
  private Point2D location;
  private Point2D destination;
  private List<CAR> historyCL; //vai ser de outro tipo idk

  public Client()
  {
      super();
      this.walk = 0.0;   
  }
   
  public Client(String email,String name,String password,String address,String date,int rating, int new_walk)
  {
      super(email, name,password,address,date);
      this.walk = new_walk;
      this.historyCL = new ArrayList<CAR>();
  }
    
  public Client(Client c)
  {
      super(c);
      this.walk = c.getWalk();
  }
    
    /************************* GETTERS *************************/
  public double getWalk(){return this.walk;}
  public Point2D getLocation(){return this.location;}
  public Point2D getDestination(){return this.destination;}
 
  
   /************************* SETTERS *************************/
  public void setWalk(double newW){this.walk = newW;}
  public void setLocation(double x, double y){this.location = new Point2D(x,y);}
  public void setDestination(double x, double y){this.destination = new Point2D(x,y);}

  
   /************************* CLONE *************************/
  public Client clone(){return new Client(this);} //IMPLEMENTAR DIFERENTE?
    
    /************************* EQUALS *************************/
  public boolean equals(Object o)
  {
      if(this == o) return true;
      if(o != null && this.getClass() != o.getClass()) return false;
      Client c = (Client) o;     
       return this.walk == c.getWalk();
  }
    
    /************************* TOSTRING *************************/
  public String toString()
  {
      return "Distancia que pode percorrer a pé: " + walk;         
  }
  
    
}

