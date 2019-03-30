import java.util.*;
import java.io.Serializable;
/**
 * Escreva a descrição da classe Eletrico aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Electric extends CAR implements Serializable 
{
  private static String fuel = "Electricity";
  
  public Electric()
   {
       super();
   }
   
    public Electric(double speed,double price,double consumption, int rating,String fuel)
  {
     super(speed,price,consumption,rating);
  }
  
  public Electric(Electric e)
  {
      super(e);
  }
  
  public Electric clone()
  {
    return null;
  }
}
