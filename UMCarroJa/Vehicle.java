import java.util.*;
import java.io.Serializable;

/**
* Representação abstrata da superclasse Vehicle(contém os dados comuns a todas as viaturas do sistema)
**/
public abstract class Vehicle implements Serializable
{
  private String type;
  private String brand;
  private String plate;
  private int nif;
  private double speed;
  private double price; 
  private double comsuption;
  private double autonomy;
  private double x;
  private double y;
  Point2D location = new Point2D(x,y);
  private boolean available;
  
  private Map<Date, List<Ride>> history;
  private int rating; //dada pelos clientes no final do aluguer
 
  
  public Vehicle()
  {
     this.type = "ND";
     this.brand = "ND";
     this.plate = "ND";
     this.nif = 0;
     this.speed = 0.0;
     this.price = 0.0;
     this.comsuption = 0.0;
     this.autonomy = 0.0;
     this.x = 0.0;
     this.y= 0.0;
     this.rating = 0;
     this.available = true;
  }
     
  public Vehicle(String type, String brand, String plate, int nif, double speed, double price, double comsuption, double autonomy, double x, double y)
  {
    this.type = type;
    this.brand = brand;
    this.plate = plate;
    this.nif = nif;
    this.speed = speed;
    this.price = price;
    this.comsuption = comsuption;
    this.autonomy = autonomy;
    this.x = x;
    this.y = y;
    this.location = new Point2D();
    this.rating = rating;
    this.available = available;
  }
    
  public Vehicle(Vehicle v)
  {
    this.type = v.getType();
    this.brand = v.getBrand();
    this.plate = v.getPlate();
    this.nif = v.getNif();
    this.speed = v.getSpeed();
    this.price = v.getPrice();
    this.autonomy = v.getAutonomy();
    this.comsuption = v.getComsuption();
    this.x = v.getX();
    this.y = v.getY();
    this.location = v.getLocation();
    this.plate = v.getPlate();
    this.available = v.getAvailability();
  }
    
    /************************* GETTERS *************************/
  public String getType(){return this.type;}
  public String getBrand(){return this.brand;}
  public double getSpeed(){return this.speed;}
  public int getNif(){return this.nif;}
  public double getPrice(){return this.price;}
  public double getAutonomy(){return this.autonomy;}
  public double getComsuption(){return this.comsuption;}
  public double getX(){return this.x;}
  public double getY(){return this.y;}
  public int getRating(){return this.rating;}
  public String getPlate(){return  this.plate;}
  public boolean getAvailability(){return this.available;} 
  public Point2D getLocation(){return this.location.clone();}
   
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
  public void setType(String newType){this.type = newType;}
  public void setBrand(String newBrand){this.type = newBrand;} 
  public void setSpeed(double newS){this.speed = newS;}
  public void setPrice(double newP){this.price = newP;}
  public void setAutonomy(double newA){this.autonomy = newA;}
  public void setComsuption(double newC){this.comsuption = newC;}
  public void setRating(int newR){this.rating = newR;}
  public void setPlate(String newPlate){this.plate = newPlate;}
  public void setX(double newX){this.x = newX;} 
  public void setY(double newY){this.y = newY;} 
  public void setAvailability(boolean newAV){this.available = newAV;}
  public void setLocation(Point2D p){this.location = p.clone();}
  
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
  
  //SE AUTONOMIA < 10% ENTÃO AVISA O PROPRIETARIO -> ALTERA AVAILABILITY FICA NÃO DISPONIVEL
  
  //Altera a classificação a partir de uma nova classificação atribuida
  /** ler todas as classificações do seu map de rents e faz a media **/
}

