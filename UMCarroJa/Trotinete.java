import java.io.Serializable;

/**
* Representação da classe Trotinete, subclasse de Vehicle
**/
public class Trotinete extends Vehicle implements Serializable 
{
  public Trotinete()
  {
      super();
  }
    
  public Trotinete(String type, String brand, String plate, int nif, double speed, double price, double comsuption, double autonomy, double x, double y)
  {
      super(type,brand,plate,nif,speed,price,comsuption,autonomy,x, y);
  }
   
   public Trotinete(Trotinete t)
   {
       super(t.getType(), t.getBrand(),  t.getPlate(), t.getNif(), t.getSpeed(), t.getPrice(), t.getComsuption(), t.getAutonomy(), t.getX(), t.getY());
   }
    
    public Trotinete clone()
   {
       Trotinete tr = new Trotinete(this.getType(), this.getBrand(), this.getPlate(), this.getNif(), this.getSpeed(),  this.getPrice(),this.getComsuption(), this.getAutonomy(), this.getX(), this.getY());
       return  tr;
   }
}
