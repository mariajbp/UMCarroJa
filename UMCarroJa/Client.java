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
  Point2D location = new Point2D(x,y);
  private Set<RentedCar> rentingHistory;

  /** Construtor vazio que cria uma instância Client  **/
  public Client()
  {
      super();
      this.x = 0.0;
      this.y = 0.0;
      this.location = new Point2D();
      this.rentingHistory = new TreeSet<RentedCar>();

  }
  /** Construtor que cria um novo Client a partir dos parâmetros dados **/
  public Client(String name, int nif, String email, String address, double x, double y)
  {
      super(name,nif,email,address);
      this.x = x;
      this.y = y;
      this.location = new Point2D();
      this.rentingHistory = new TreeSet<RentedCar>();
  }
  /** Construtor de cópia que cria uma nova instância Client a partir de um Client passado como parâmetro **/
  public Client(Client c)
  {
      super(c.getName(), c.getNif(), c.getEmail(), c.getAddress());
      this.x = c.getX();
      this.y = c.getY();
      this.location = c.getLocation();
      this.rentingHistory = c.getRentingHistoryAll();
  }
  
    
  /************************* GETTERS *************************/
  public double getWalk(){return this.walk;}
  public double getX(){return this.x;}
  public double getY(){return this.y;}
  public Point2D getLocation(){return this.location.clone();}
  
  public Set<RentedCar> getRentingHistoryAll()
  {
     Set<RentedCar> aux = new TreeSet<RentedCar>();
     for(RentedCar rc: this.rentingHistory){aux.add(rc.clone());}
     return aux;
  }
  
  
  /************************* SETTERS *************************/
  public void setWalk(double w){this.walk = w;}
  public void setX(double x){this.x = x;}
  public void setY(double y){this.y = y;}
  public void setLocation(Point2D p){this.location = p.clone();}
  
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
    return new Client(this);
  }
    
  /************************* EQUALS *************************/
  public boolean equals(Object o)
  {
      if(this == o) return true;
      if(o == null && this.getClass() != o.getClass()) return false;
      Client c = (Client) o;     
      return super.equals(c) &&
             this.walk == c.getWalk() &&
             this.location.equals(c.getLocation()) &&
             this.rentingHistory.equals(c.getRentingHistoryAll());
  }
    
  /************************* TOSTRING *************************/
  public String toString()
  {
      return "Distancia que está disposto a percorrer a pé: " + walk;
             
                    
  }
  
  /**
  * Método que calcula o total de km percorridos pelo cliente
  * @return total de km percorridos pelo cliente
  **/
  public double totalKms()
  {
     Iterator<RentedCar> it = rentingHistory.iterator();
     double aux = 0.0;
     RentedCar r;
     while(it.hasNext())
     {
        r = it.next();
        aux += r.getKms();
     }
     return aux;
  }
  
  /**
  * Método que calcula a classificação de um cliente 
  **/
  public void clientRating(int newR)
  {
     this.setRating(newR + this.getRating()/(this.rentingHistory.size()));
  }
}
