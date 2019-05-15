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
  private Map<Date, List<RentedCar>> rentingHistory;
  
  public Client()
  {
      super();
      this.x = 0.0;
      this.y = 0.0;
  }
  
  public Client(String name,String password,String email,String address, double x, double y)
  {
      super(name,password,email,address);
      this.x = x;
      this.y = y;
      this.rentingHistory = new TreeMap<Date, List<RentedCar>>();
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
 
  public Map<Date, List<RentedCar>> getRentingHistory()
  {
    Map<Date, List<RentedCar>> neo = new TreeMap<Date, List<RentedCar>>();
    for(Map.Entry<Date, List<RentedCar>> entrys : this.rentingHistory.entrySet())
    {
      neo.put(entrys.getKey(), entrys.getValue());
    }
    return neo;
  }
  
  /************************* SETTERS *************************/
  public void setWalk(double newW){this.walk = newW;}
  public void setX(double x){this.x = x;}
  public void setY(double y){this.y = y;}

  public void setRentingHistory(Map<Date, List<RentedCar>> h)
  {
    this.rentingHistory = new TreeMap<Date, List<RentedCar>>();
    for(Map.Entry<Date, List<RentedCar>> entrys : h.entrySet())
    {
      this.rentingHistory.put(entrys.getKey(), entrys.getValue());
    }
  }
  
  public void addToHistory(Date d, RentedCar rc)
  {
    if(this.rentingHistory.containsKey(d))
    {
      this.rentingHistory.get(d).add(rc.clone());
    } 
    else 
    {
      List<RentedCar> neo = new LinkedList<RentedCar>();
      neo.add(rc.clone());
      this.rentingHistory.put(d, neo);
    }
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
  
  public void printHistoryCL()
  {
    Set<Map.Entry<Date, List<RentedCar>>> r = this.rentingHistory.entrySet();
    if(this.rentingHistory.size()!=0)
    {
      System.out.println("Histórico: " + this.rentingHistory.size());
      for(Map.Entry<Date, List<RentedCar>> elem : r)
      {
        System.out.println("Alugueres realizados em " + elem.getKey().toString());
        for(RentedCar rc : elem.getValue())
        {
          System.out.println(rc.toString());
        }
        System.out.println("-------------------------");
      }
    }
    else System.out.println("Não existe histórico!");
  }
}
