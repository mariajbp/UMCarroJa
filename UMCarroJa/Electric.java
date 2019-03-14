import java.util.*;
import java.io.Serializable;
/**
 * Escreva a descrição da classe Eletrico aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Electric extends Car implements Serializable
{
  private static String fuel = "Electricity";
  
    public Electric(double speed,double price,double consumption, int rating,String fuel)
  {
     super(speed,price,consumption,rating);
  }
      
  public Electric clone()
  {
     return new Electric(this); //IMPLEMENTAR DIFERENTE
  }
}
