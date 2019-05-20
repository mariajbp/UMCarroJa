import java.io.Serializable;
/**
* Representação da classe Gas, subclasse de Vehicle
**/
public class Gas extends Vehicle implements Serializable 
{   
   public Gas()
   { 
       super();
   }
   
   public Gas(String type, String brand, String plate, int nif, double speed, double price, double comsuption, double autonomy, double x, double y)
   {
     super(type,brand,plate,nif,speed,price,comsuption,autonomy,x, y);
   }
   
   public Gas(Gas g)
   {
       super(g.getType(), g.getBrand(),  g.getPlate(), g.getNif(), g.getSpeed(), g.getPrice(), g.getComsuption(), g.getAutonomy(), g.getX(), g.getY());
   }
  
   public Gas clone()
   {
       Gas g = new Gas(this);
       return g;
   }
  
}
