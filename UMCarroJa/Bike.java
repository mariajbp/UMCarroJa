import java.util.*;
import java.io.Serializable;

/**
* Representação da classe Bike, subclasse de Vehicle
**/
public class Bike extends Vehicle implements Serializable 
{
    public  Bike(double speed,double price,double autonomy,Point2D location, double comsuption, int rating, String plate)
   {
     super(speed,price,autonomy, location,comsuption,rating,plate);
   }
   
   public  Bike(Bike b)
   {
       super(b);
   }
    
    public  Bike clone()
   {
       Bike b = new  Bike(this.getSpeed(), this.getPrice(), this.getAutonomy(), this.getLocation(), this.getComsuption(), this.getRating(), this.getPlate());
       return  b;
   }
}
