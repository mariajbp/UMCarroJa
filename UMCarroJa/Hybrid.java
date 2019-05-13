import java.io.Serializable;
/**
* Representação da classe Hybrid, subclasse de Vehicle
**/
public class Hybrid extends Vehicle implements Serializable 
{
   private static String fuel = "plugin";
   
   public Hybrid()
   {
       super();
       this.setSpeed(100);
       this.setPrice(1.5);
   }
   
   public Hybrid(double speed,double price,double autonomy,Point2D location, double consumption, int rating, String plate)
   {
      super(speed,price,autonomy, location,consumption,rating,plate);
      this.setSpeed(100);
      this.setPrice(1.5);
   }
   
   public Hybrid(Hybrid h)
   {
      super(h.getSpeed(), h.getPrice(), h.getAutonomy(), h.getLocation(), h.getComsuption(), h.getRating(), h.getPlate());
      this.setSpeed(100);
      this.setPrice(1.5);
   }
   
   public  Hybrid clone()
   {
      Hybrid h = new Hybrid(this.getSpeed(), this.getPrice(), this.getAutonomy(), this.getLocation(), this.getComsuption(), this.getRating(), this.getPlate());
      return h;
   }
}
