import java.util.*;
import java.io.Serializable;
/**
 * Escreva a descrição da classe Hibrido aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */

public class Hybrid extends CAR implements Serializable 
{
   private static String fuel = "plugin";
    
    public Hybrid()
   {
       super();
   }
   
   public Hybrid(double speed,double price,double consumption, int rating, String plate)
   {
     super(speed,price,consumption,rating,plate);
   }
   
   public Hybrid(Hybrid h)
   {
      super(h);
   }
   
   public  Hybrid clone(){
       return new Hybrid(this); //IMPLEMENTAR DIFERENTE??
    }
}
