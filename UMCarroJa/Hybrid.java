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
   
   public Hybrid(double speed,double price,double consumption, int rating)
   {
     super(speed,price,consumption,rating);
   }
   
   public Hybrid(Hybrid h)
   {
      super(h);
   }
   
   public  Hybrid clone(){
       return new Hybrid(this); //IMPLEMENTAR DIFERENTE??
    }
}
