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
  private double deposit;                  //Total que pode abastecer (autonomia inicial)
  
  private Set<Ride> rentingHistory;
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
     this.rentingHistory = new TreeSet<Ride>();
     this.deposit = 100;
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
    this.rating = 0;
    this.available = true;
    this.rentingHistory = new TreeSet<Ride>();
    this.deposit = autonomy + 100;
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
    this.rating = v.getRating();
    this.rentingHistory = v.getRentingHistoryAll();
    this.deposit = v.getDeposit();
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
  public double getDeposit(){return this.deposit;}
   
  public Set<Ride> getRentingHistoryAll()
  {
     Set<Ride> aux = new TreeSet<>();
     for(Ride rc: this.rentingHistory){aux.add(rc.clone());}
     return aux;
  }
  
   /************************* SETTERS *************************/
  public void setType(String newType){this.type = newType;}
  public void setBrand(String newBrand){this.type = newBrand;} 
  public void setSpeed(double newS){this.speed = newS;}
  public void setNif(int n){this.nif = n;}
  public void setPrice(double newP){this.price = newP;}
  public void setAutonomy(double newA){this.autonomy = newA;}
  public void setComsuption(double newC){this.comsuption = newC;}
  public void setPlate(String newPlate){this.plate = newPlate;}
  public void setX(double newX){this.x = newX;} 
  public void setY(double newY){this.y = newY;} 
  public void setAvailability(boolean newAV){this.available = newAV;}
  public void setLocation(Point2D p){this.location = p.clone();}
  public void setDeposit(int d){this.deposit = d;}
  public void setRating(int newR)
  {
      int nr = (this.rating + newR)/(this.rentingHistory.size());
      this.rating = nr;
  }
  
  public void setRentingHistory(Set<Ride> rc)
  {
      this.rentingHistory.clear();
      for(Ride r: rc){this.rentingHistory.add(r.clone());}
  }
  
  public void addRide(Ride r){this.rentingHistory.add(r.clone());}
  
  public void removeRide(Ride r){this.rentingHistory.remove(r);}
    
  public void addSetRide(Set<Ride> h)
  {
      for(Ride r : h) this.rentingHistory.add(r.clone());
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
      if(o == null && this.getClass() != o.getClass()) return false;
      Vehicle v = (Vehicle) o;     
       return this.type == v.getType() &&
              this.brand == v.getBrand() &&
              this.plate == v.getPlate() &&
              this.nif == v.getNif() &&
              this.speed == v.getSpeed() &&
              this.price == v.getPrice() &&
              this.comsuption == v.getComsuption() &&
              this.autonomy == v.getAutonomy() &&
              this.location.equals(v.getLocation()) && 
              this.available == v.getAvailability() &&
              this.rating == v.getRating() &&
              this.deposit == v.getDeposit();             
  }
    
  /************************* TOSTRING *************************/
  public String toString()
  {
      return "Tipo: " + this.type +
             "Marca: " + this.brand +
             "Matrícula: " + this.plate +
             "NIF : " + this.nif +
             "Velocidade média por km: " + speed +
             "Preço base por km: " + price +
             "Consumo de gasolina/bateria por km: " + comsuption +
             "Classificação: " + rating;           
  }
  
  
  /**FAZER ISTO EM TODOS **/
  public String toStringHistoryVehicle()
  {
      return "Histórico de Viagens : " + this.rentingHistory.toArray();
  }
  

  //Vê se a autonomia está abaixo dos 10%
  public boolean hasAutonomy()
  {
    if(this.autonomy == 0.1*this.deposit)
        return false;
    else
        return true;
  }
  
   //Método que compara se a autonomia serve
   public boolean hasAutonomy(double autonomy)
   {
       if(this.autonomy == autonomy)
            return true;
       else 
            return false;
   }
  
   //Método auxiliar que calcula se um carro está perto
   public boolean isNear(double walk, Point2D localv, Point2D localc)
   {
       double d = localv.distanceTo(localc);
       if(walk <= d)
            return true;
       else
            return false;
   } 
}

