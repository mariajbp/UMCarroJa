import java.util.*;
import java.io.Serializable;

public class Ride implements Serializable
{
  private CAR vehicle;
  private Client client;
  private Owner owner;
  private RentedCar trip;
  private Point2D location;
  private boolean available;
  private double totalProfit;
  
  public Ride(Ride r){}
  public Ride(){}
  
  /***gets e sets ***/
  
  
  
  public String availableToString()
  {
    String available;
    if(this.available==true) available = "Sim";
    else available = "Não";
    return available;
  }
}
