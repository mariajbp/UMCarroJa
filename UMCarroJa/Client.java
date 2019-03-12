import java.util.*;
import java.io.Serializable;
/**
 * DESCREVER ESTA CLASSE DE UMA MANEIRA PANELEIRA 
 */
public class Client extends USER implements Serializable
{
  private Point2D location;     //variavel de classe
  //private Point2D destination; //variavel de classe faz sentido ter esta??
  
  //historico vai ser uma  estrutura
  
  public Client(String email,String name,String password,String address,String date)
  {
      super(email, name,password,address,date);
  }
  
    
}

