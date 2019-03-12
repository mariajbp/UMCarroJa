import java.util.*;
import java.io.Serializable;

/**
 * DESCREVER ESTA CLASSE DE UMA MANEIRA PANELEIRA 
 */
public class Client extends USER implements Serializable
{
  private int x; //CLASSE POINT2D??
  private int y;
  //HISTORICA VAI SER UMA ESTRUTURA QQ

  /**
  * Construtor por omissão - sem parametros/vazio
  **/
  public Client()
  {
     this.x = 0;
     this.y = 0;
  }
     
  /**
  * Construtor parametrizado - define um valor incial para 
  * cada variavel
  **/
   
  public Client(int new_x, int new_y)
  {
     this.x = new_x;
     this.y = new_y;
  }
    
  /**
  * Construtor de cópia - recebe um objeto e cria uma cópia dele
  **/
  public Client(Client outro)
  {
     this.x = outro.getX();
     this.y = outro.getY();
     
  }
    
    /************************* GETTERS *************************/
  public int getX(){return this.x;}
  public int getY(){return this.y;}
  
   /************************* SETTERS *************************/
  public void setX(int newX){this.x = newX;}
  public void setNome(int newY){this.y = newY;}

   /************************* CLONE *************************/
  public Client clone()
  {
    return new Client(this);
  }
    
    /************************* EQUALS *************************/
  public boolean equals(Object o)
  {
      if(this == o) return true;
      if(o != null && this.getClass() != o.getClass()) return false;
      Client c = (Client) o;     
       return this.x == c.getX() &&
              this.y == c.getY() ;
               
  }
    
    /************************* TOSTRING *************************/
  public String toString()
  {
      return "Cordernadas: (" + x + "," + y + ")";
             
  }
    
}

