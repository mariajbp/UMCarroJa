import java.io.Serializable;
/**
* Representação da classe Gas, subclasse de Vehicle
**/
public class Gas extends Vehicle implements Serializable 
{
   private static String fuel = "fossil fuel";
   
   public Gas()
   { 
       super();
       this.setSpeed(120);
       this.setPrice(1.7);
   }
   
   public Gas(double speed,double price,double autonomy,Point2D location, double comsuption, int rating, String plate)
   {
     super(speed,price,autonomy, location,comsuption,rating,plate);
     this.setSpeed(120);
     this.setPrice(1.7);
   }
   
   public Gas(Gas g)
   {
       super(g.getSpeed(), g.getPrice(), g.getAutonomy(), g.getLocation(), g.getComsuption(), g.getRating(), g.getPlate());
       this.setSpeed(120);
       this.setPrice(1.7);
   }
  
   public Gas clone()
   {
       Gas g = new Gas(this.getSpeed(), this.getPrice(), this.getAutonomy(), this.getLocation(), this.getComsuption(), this.getRating(), this.getPlate());
       return g;
   }
  
}
