import java.util.*;
import java.io.Serializable;

/**
* Representação da classe Trotinete, subclasse de Vehicle
**/
public class Trotinete extends Vehicle implements Serializable 
{
   public Trotinete(double speed,double price,double autonomy,Point2D location, double comsuption, int rating, String plate)
   {
     super(speed,price,autonomy, location,comsuption,rating,plate);
   }
   
   public Trotinete(Trotinete tr)
   {
       super(tr);
   }
    
    public Trotinete clone()
   {
       Trotinete tr = new Trotinete(this.getSpeed(), this.getPrice(), this.getAutonomy(), this.getLocation(), this.getComsuption(), this.getRating(), this.getPlate());
       return  tr;
   }
}
