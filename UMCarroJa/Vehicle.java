import java.util.*;
import java.io.Serializable;

/**
* Representação abstrata da superclasse Vehicle(contém os dados comuns a todas as viaturas do sistema)
**/
public abstract class Vehicle implements Serializable
{
  private double speed;
  private double price; 
  private double autonomy;
  private Point2D location; //SAO ATUALIZADAS NO FIM DA VIAGEM PARA O DESTINO DO CLIENTE
  private double comsuption;
  private Map<Date, List<Ride>> history;
  private int rating;
  private String plate;
  
  public Vehicle()
  {
     this.speed = 0.0;
     this.price = 0.0;
     this.autonomy = 0.0;
     //this.location
     this.comsuption = 0.0;
     this.rating = 0;
     this.plate = " ";
  }
     
  public Vehicle(double speed, double price, double autonomy,Point2D location, double comsuption, int rating, String plate)
  {
    this.speed = speed;
    this.price = price;
    this.autonomy = autonomy;
    this.location = location;
    this.comsuption = comsuption;
    this.rating = rating;
    this.plate = plate;
    this.history = new TreeMap<Date, List<Ride>>();
  }
    
  public Vehicle(Vehicle v)
  {
    this.speed = v.getSpeed();
    this.price = v.getPrice();
    this.autonomy = v.getAutonomy();
    this.location = v.getLocation();
    this.comsuption = v.getComsuption();
    this.rating = v.getRating();
    this.plate = v.getPlate();
    this.history = new TreeMap<Date, List<Ride>>();
  }
    
    /************************* GETTERS *************************/
  public double getSpeed(){return this.speed;}
  public double getPrice(){return this.price;}
  public double getAutonomy(){return this.autonomy;}
  public Point2D getLocation(){return this.location;}
  public double getComsuption(){return this.comsuption;}
  public int getRating(){return this.rating;}
  public String getPlate(){return  this.plate;}
  
  public Map<Date, List<Ride>> getRentingHistory()
  {
    Map<Date, List<Ride>> neo = new TreeMap<Date, List<Ride>>();
    for(Map.Entry<Date, List<Ride>> entrys : this.history.entrySet())
    {
      neo.put(entrys.getKey(), entrys.getValue());
    }
    return neo;
  }
  
   /************************* SETTERS *************************/
  public void setSpeed(double newS){this.speed = newS;}
  public void setPrice(double newP){this.price = newP;}
  public void setAutonomy(double newA){this.autonomy = newA;}
  public void setLocation(double x, double y){this.location = new Point2D(x,y);}
  public void setComsuption(double newC){this.comsuption = newC;}
  public void setRating(int newR){this.rating = newR;}
  public void setPlate(String newPlate){this.plate = newPlate;}
  
  public void setRentingHistory(Map<Date, List<Ride>> h)
  {
    this.history = new TreeMap<Date, List<Ride>>();
    for(Map.Entry<Date, List<Ride>> entrys : h.entrySet())
    {
      this.history.put(entrys.getKey(), entrys.getValue());
    }
  }
  
  
  /*** Outros Métodos **/
  public void addToRHistory(Date d, Ride rc)
  {
    if(this.history.containsKey(d))
    {
      this.history.get(d).add(rc.clone());
    } else 
    {
      List<Ride> neo = new LinkedList<Ride>();
      neo.add(rc.clone());
      this.history.put(d, neo);
    }
  }
    
  public double priceKM(double price, double comsuption)
  {
      return price*comsuption;
  }
  
  
  
  
  /************************* CLONE *************************/
  public abstract Vehicle clone();  

  /************************* EQUALS *************************/
  public boolean equals(Object o)
  {
      if(this == o) return true;
      if(o != null && this.getClass() != o.getClass()) return false;
      Vehicle v = (Vehicle) o;     
       return this.speed == v.getSpeed() &&
              this.price == v.getPrice() &&
              this.comsuption == v.getComsuption() &&
              this.rating == v.getRating();             
  }
    
  /************************* TOSTRING *************************/
  public String toString()
  {
      return "Velocidade média por km: " + speed +
             "Preço base por km: " + price +
             "Consumo de gasolina/bateria por km: " + comsuption +
             "Classificação: " + rating;
             
  }
  
  public void printHistoryCAR()
  {
    Set<Map.Entry<Date, List<Ride>>> r = this.history.entrySet();
    if(this.history.size()!=0)
    {
      System.out.println("Histórico: " + this.history.size());
      for(Map.Entry<Date, List<Ride>> elem : r)
      {
        System.out.println("Alugueres realizados em " + elem.getKey().toString());
        for(Ride rc : elem.getValue())
        {
          System.out.println(rc.toString());
        }
        System.out.println("-------------------------");
      }
    }
    else System.out.println("Não existe histórico!");
  }
}

