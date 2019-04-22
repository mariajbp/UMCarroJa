import java.util.*;
import java.io.Serializable;
import java.util.ArrayList;

/**
* Representação da classe cliente, subclasse de USER
**/
public class Client extends USER implements Serializable
{
  private double walk;  //4km por hora
  private Point2D location;
  private Point2D destination;
  private double spent;
  private Map<Date, List<RentedCar>> rentingHistory;

  public Client(String email,String name,String password,String address,String date, int walk, double spent)
  {
      super(email, name,password,address,date);
      this.walk = walk;
      this.spent = spent;
      this.rentingHistory = new TreeMap<Date, List<RentedCar>>();
  }
    
  public Client(Client c)
  {
      super(c);
      this.walk = c.getWalk();
      this.spent = c.getSpentMoney();
      this.rentingHistory = c.getRentingHistory();
  }
    
  /************************* GETTERS *************************/
  public double getWalk(){return this.walk;}
  public double getSpentMoney(){return this.spent;}
  public Point2D getLocation(){return this.location;}
  public Point2D getDestination(){return this.destination;}
 
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
  public void setLocation(double x, double y){this.location = new Point2D(x,y);}
  public void setDestination(double x, double y){this.destination = new Point2D(x,y);}

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

  
  
  /*** Outros Metodos ***/
  public void spentMoney(double money)
  {
      this.spent+=money;
  }
  
  
  
  
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
