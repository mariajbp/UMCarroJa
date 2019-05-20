import java.io.Serializable;
/**
* Representação da classe Hybrid, subclasse de Vehicle
**/
public class Hybrid extends Vehicle implements Serializable 
{
   
   public Hybrid()
   {
       super();
   }
   
   public Hybrid(String type, String brand, String plate, int nif, double speed, double price, double comsuption, double autonomy, double x, double y)
   {
      super(type,brand,plate,nif,speed,price,comsuption,autonomy,x, y);
   }
   
   public Hybrid(Hybrid h)
   {
      super(h.getType(), h.getBrand(),  h.getPlate(), h.getNif(), h.getSpeed(), h.getPrice(), h.getComsuption(), h.getAutonomy(), h.getX(), h.getY());
   }
   
   public  Hybrid clone()
   {
      Hybrid h = new Hybrid(this);
      return h;
   }
}
