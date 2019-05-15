import java.io.Serializable;
/**
* Representação da classe Gas, subclasse de Vehicle
**/
public class Gas extends Vehicle implements Serializable 
{   
   public Gas()
   { 
       super();
       this.setType("Gasolina");
       this.setSpeed(120);
       this.setPrice(1.7);
   }
   
   public Gas(String type, String brand, String plate, int nif, double speed, double price, double comsuption, double autonomy, double x, double y)
   {
     super(type,brand,plate,nif,speed,price,comsuption,autonomy,x, y);
     this.setType("Gasolina");
     this.setSpeed(120);
     this.setPrice(1.7);
   }
   
   public Gas(Gas g)
   {
       super(g.getType(), g.getBrand(),  g.getPlate(), g.getNif(), g.getSpeed(), g.getPrice(), g.getComsuption(), g.getAutonomy(), g.getX(), g.getY());
       this.setType("Gasolina");
       this.setSpeed(120);
       this.setPrice(1.7);
   }
  
   public Gas clone()
   {
       Gas g = new Gas(this.getType(), this.getBrand(), this.getPlate(), this.getNif(), this.getSpeed(),  this.getPrice(),this.getComsuption(), this.getAutonomy(), this.getX(), this.getY());
       return g;
   }
  
}
