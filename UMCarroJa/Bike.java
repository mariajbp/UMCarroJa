import java.io.Serializable;

/**
* Representação da classe Bike, subclasse de Vehicle
**/
public class Bike extends Vehicle implements Serializable 
{
   public Bike()
   {
       super();
   }
   
    public  Bike(String type, String brand, String plate, int nif, double speed, double price, double comsuption, double autonomy, double x, double y)
   {
     super(type,brand,plate,nif,speed,price,comsuption,autonomy,x, y);
   }
   
   public  Bike(Bike b)
   {
       super(b.getType(), b.getBrand(),  b.getPlate(), b.getNif(), b.getSpeed(), b.getPrice(), b.getComsuption(), b.getAutonomy(), b.getX(), b.getY());
   }
    
    public  Bike clone()
   {
       Bike b = new  Bike(this.getType(), this.getBrand(), this.getPlate(), this.getNif(), this.getSpeed(),  this.getPrice(),this.getComsuption(), this.getAutonomy(), this.getX(), this.getY());
       return  b;
   }
}
