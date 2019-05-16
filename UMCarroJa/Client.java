import java.util.*;
import java.io.Serializable;
import java.util.ArrayList;

/**
* Representação da classe cliente, subclasse de USER
**/
public class Client extends USER implements Serializable
{
  private double walk;  //4km por hora
  private double x;
  private double y;
  private Set<RentedCar> rentingHistory;
  
  public Client(String name,String password,String email,String address, double x, double y)
  {
      super(name,password,email,address);
      this.x = x;
      this.y = y;
      this.rentingHistory = new TreeSet<RentedCar>();
  }
    
  public Client(Client c)
  {
      super(c.getName(), c.getPassword(), c.getEmail(), c.getAddress());
      this.x = getX();
      this.y = getY();
      this.rentingHistory = c.getRentingHistory();
  }
  
    
  /************************* GETTERS *************************/
  public double getWalk(){return this.walk;}
  public double getX(){return this.x;}
  public double getY(){return this.y;}
 
  public Set<RentedCar> getRentingHistory()
  {
    Set<RentedCar> aux = new TreeSet<>();
    for(RentedCar rc: this.rentingHistory){aux.add(rc.clone());}
    return aux;
  }
  
  
  /************************* SETTERS *************************/
  public void setWalk(double newW){this.walk = newW;}
  public void setX(double x){this.x = x;}
  public void setY(double y){this.y = y;}

  public void setRentingHistory(Set<RentedCar> rc)
  {
      this.rentingHistory.clear();
      for(RentedCar r: rc){this.rentingHistory.add(r.clone());}
  }
  
  public void addRentedCar(RentedCar r){this.rentingHistory.add(r.clone());}
  
  public void removeRentedCar(RentedCar r){this.rentingHistory.remove(r);}
    
  public void addSetRentedCar(Set<RentedCar> h)
  {
      for(RentedCar r : h) this.rentingHistory.add(r.clone());
  }

  /************************* CLONE *************************/
  public Client clone()
  {
    Client c = new Client(this.getName(), this.getPassword(), this.getEmail(), this.getAddress(), this.getX(), this.getY());
    return c;
  }
    
  /************************* EQUALS *************************/
  public boolean equals(Object o)
  {
      if(this == o) return true;
      if(o != null && this.getClass() != o.getClass()) return false;
      Client c = (Client) o;     
      return super.equals(c);
  }
    
  /************************* TOSTRING *************************/
  public String toString()
  {
      return "Distancia que está disposto a percorrer a pé: " + walk;
             
                    
  }
}
