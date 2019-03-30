import java.io.Serializable; 
/**
 * Escreva a descrição da classe Gasolina aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Gas extends CAR implements Serializable 
{
   private static String fuel = "fossil fuel";
   
   public Gas()
   {
       super();
   }
   
   public Gas(double speed,double price,double consumption, int rating)
   {
     super(speed,price,consumption,rating);
   }
   
   public Gas(Gas g)
  {
      super(g);
  }
  
  public Gas clone()
  {
    return new Gas(this); //IMPLEMENTAR DIFERENTE!!!
  }
}
