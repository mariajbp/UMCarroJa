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
   public Electric(double speed,double price,double consumption, int rating)
    {
     super(speed,price,consumption,rating);
    } 
}
