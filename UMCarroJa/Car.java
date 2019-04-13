import java.util.*;
import java.io.Serializable;
/**
 * DESCREVER ESTA CLASSE DE UMA MANEIRA PANELEIRA 
 */

public abstract class CAR implements Serializable
{
  private double speed;
  private double price;
  private double consumption;
  private List<CAR> history;
  private int rating;
  private String plate;
  // ADD LOCATION
  
  public CAR()
  {
    this.speed = 0.0;
    this.price = 0.0;
    this.consumption = 0.0;
    this.rating = 0;
    this.plate = "";
  }
     
   
  public CAR(double speed, double price, double consumption, int rating, String plate)
  {
    this.speed = speed;
    this.price = price;
    this.consumption = consumption;
    this.rating = rating;
    this.plate = plate;
  }
    
  public CAR(CAR c)
  {
    this.speed = c.getSpeed();
    this.price = c.getPrice();
    this.consumption = c.getConsumption();
    this.rating = c.getRating();
    this.plate = c.getPlate();
  }
    
    /************************* GETTERS *************************/
  public double getSpeed(){return this.speed;}
  public double getPrice(){return this.price;}
  public double getConsumption(){return this.consumption;}
  public int getRating(){return this.rating;}
  public String getPlate(){return  this.plate;}
  
   /************************* SETTERS *************************/
  public void setSpeed(double newS){this.speed = newS;}
  public void setPrice(double newP){this.price = newP;}
  public void setConsumption(double newC){this.consumption = newC;}
  public void setRating(int newR){this.rating = newR;}
  public void setPlate(String newPlate){this.plate = newPlate;}

   /************************* CLONE *************************/
  public abstract CAR clone();  

    /************************* EQUALS *************************/
  public boolean equals(Object o)
  {
      if(this == o) return true;
      if(o != null && this.getClass() != o.getClass()) return false;
      CAR c = (CAR) o;     
       return this.speed == c.getSpeed() &&
              this.price == c.getPrice() &&
              this.consumption == c.getConsumption() &&
              this.rating == c.getRating();             
  }
    
    /************************* TOSTRING *************************/
  public String toString()
  {
      return "Velocidade média por km: " + speed +
             "Preço base por km: " + price +
             "Consumo de gasolina/bateria por km: " + consumption +
             "Classificação: " + rating;
             
  }
    
}

