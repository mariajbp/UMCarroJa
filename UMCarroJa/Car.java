import java.util.*;
import java.io.Serializable;
/**
 * DESCREVER ESTA CLASSE DE UMA MANEIRA PANELEIRA 
 */

public abstract class Car implements Serializable
{
  private double speed;
  private double price;
  private double consumption;
  //HISTORICO VAI SER UMA ESTRUTURA
  private int rating;
  // ADD LOCATION
  
  public Car()
  {
    this.speed = 0.0;
    this.price = 0.0;
    this.consumption = 0.0;
    this.rating = 0;
  }
     
   
  public Car(double new_speed, double new_price, double new_consumption, int new_rating )
  {
    this.speed = new_speed;
    this.price = new_price;
    this.consumption = new_consumption;
    this.rating = new_rating;
  }
    
  public Car(Car c)
  {
    this.speed = c.getSpeed();
    this.price = c.getPrice();
    this.consumption = c.getConsumption();
    this.rating = c.getRating();
  }
    
    /************************* GETTERS *************************/
  public double getSpeed(){return this.speed;}
  public double getPrice(){return this.price;}
  public double getConsumption(){return this.consumption;}
  public int getRating(){return this.rating;}
  
   /************************* SETTERS *************************/
  public void setSpeed(double newS){this.speed = newS;}
  public void setPrice(double newP){this.price = newP;}
  public void setConsumption(double newC){this.consumption = newC;}
  public void setRating(int newR){this.rating = newR;}

   /************************* CLONE *************************/
  public abstract Car clone();  
   
    /************************* EQUALS *************************/
  public boolean equals(Object o)
  {
      if(this == o) return true;
      if(o != null && this.getClass() != o.getClass()) return false;
      Car c = (Car) o;     
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

