import java.util.*;
import java.io.Serializable;
/**
 * Escreva a descrição da classe Hibrido aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */

public class Hybrid extends Vehicle implements Serializable 
{
   private static String fuel = "plugin";

   public Hybrid(double speed,double price,double autonomy,Point2D location, double consumption, int rating, String plate)
   {
     super(speed,price,autonomy, location,consumption,rating,plate);
   }
   
   public Hybrid(Hybrid h)
   {
      super(h);
   }
   
   public  Hybrid clone()
   {
       return new Hybrid(this); //IMPLEMENTAR DIFERENTE??
   }
}
