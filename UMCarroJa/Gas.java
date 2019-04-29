import java.util.*;
import java.io.Serializable;

/**
* Representação da classe Gas, subclasse de Vehicle
**/
public class Gas extends Vehicle implements Serializable 
{
   private static String fuel = "fossil fuel";
  
   public Gas(double speed,double price,double autonomy,Point2D location, double comsuption, int rating, String plate)
   {
     super(speed,price,autonomy, location,comsuption,rating,plate);
   }
   
   public Gas(Gas g)
   {
       super(g);
   }
  
   public Gas clone()
   {
       Gas g = new Gas(this.getSpeed(), this.getPrice(), this.getAutonomy(), this.getLocation(), this.getComsuption(), this.getRating(), this.getPlate());
       return g;
   }
  
}
