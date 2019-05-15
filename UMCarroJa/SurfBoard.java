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
    
   public SurfBoard(String type, String brand, String plate, int nif, double speed, double price, double comsuption, double autonomy, double x, double y)
   {
     super(type,brand,plate,nif,speed,price,comsuption,autonomy,x, y);
   }
   
   public SurfBoard(SurfBoard s)
   {
       super(s.getType(), s.getBrand(),  s.getPlate(), s.getNif(), s.getSpeed(), s.getPrice(), s.getComsuption(), s.getAutonomy(), s.getX(), s.getY());
   }
    
    public SurfBoard clone()
   {
       SurfBoard sb = new SurfBoard(this.getType(), this.getBrand(), this.getPlate(), this.getNif(), this.getSpeed(),  this.getPrice(),this.getComsuption(), this.getAutonomy(), this.getX(), this.getY());
       return  sb;
   }
}
