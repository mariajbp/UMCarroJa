import java.io.Serializable;
/**
* Representação da classe Electric, subclasse de Vehicle
**/
public class Electric extends Vehicle implements Serializable 
{
  private static String fuel = "Electricity";
  
  public Electric()
  {
      super();
  }
  
  public Electric(String type, String brand, String plate, int nif, double speed, double price, double comsuption, double autonomy, double x, double y)
  {
     super(type,brand,plate,nif,speed,price,comsuption,autonomy,x, y); 
  }
  
  public Electric(Electric e)
  {
      super(e.getType(), e.getBrand(),  e.getPlate(), e.getNif(), e.getSpeed(), e.getPrice(), e.getComsuption(), e.getAutonomy(), e.getX(), e.getY());
  }
  
  public Electric clone()
  {
    Electric e = new Electric(this.getType(), this.getBrand(), this.getPlate(), this.getNif(), this.getSpeed(),  this.getPrice(),this.getComsuption(), this.getAutonomy(), this.getX(), this.getY());
    return e;
  }
}
