import java.util.*;
import java.io.Serializable;
/**
* Representação da classe Electric, subclasse de Vehicle
**/
public class Electric extends Vehicle implements Serializable 
{
  private static String fuel = "Electricity";
   
  public Electric(double speed,double price,double autonomy,Point2D location, double comsuption, int rating, String plate)
  {
     super(speed,price,autonomy, location,comsuption,rating,plate); 
  }
  
  public Electric(Electric e)
  {
      super(e);
  }
  
  public Electric clone()
  {
    Electric e = new Electric(this.getSpeed(), this.getPrice(), this.getAutonomy(), this.getLocation(), this.getComsuption(), this.getRating(), this.getPlate());
    return e;
  }
}
