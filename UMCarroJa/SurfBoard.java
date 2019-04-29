import java.util.*;
import java.io.Serializable;

/**
* Representação da classe Surfboard, subclasse de Vehicle
**/
public class SurfBoard extends Vehicle implements Serializable 
{
   public SurfBoard()
   {
       super();
   }
    
   public SurfBoard(double speed,double price,double autonomy,Point2D location, double comsuption, int rating, String plate)
   {
     super(speed,price,autonomy, location,comsuption,rating,plate);
   }
   
   public SurfBoard(SurfBoard s)
   {
       super(s.getSpeed(), s.getPrice(), s.getAutonomy(), s.getLocation(), s.getComsuption(), s.getRating(), s.getPlate());
   }
    
    public SurfBoard clone()
   {
       SurfBoard sb = new SurfBoard(this.getSpeed(), this.getPrice(), this.getAutonomy(), this.getLocation(), this.getComsuption(), this.getRating(), this.getPlate());
       return  sb;
   }
}
