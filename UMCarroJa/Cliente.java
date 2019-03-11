/**
 * DESCREVER ESTA CLASSE DE UMA MANEIRA PANELEIRA 
 */
public class Cliente
{
  private int x;
  private int y;
  //HISTORICA VAI SER UMA ESTRUTURA QQ

  /**
  * Construtor por omissão - sem parametros/vazio
  **/
  public Cliente()
  {
     this.x = 0;
     this.y = 0;
  }
     
  /**
  * Construtor parametrizado - define um valor incial para 
  * cada variavel
  **/
   
  public Cliente(int new_x, int new_y)
  {
     this.x = new_x;
     this.y = new_y;
  }
    
  /**
  * Construtor de cópia - recebe um objeto e cria uma cópia dele
  **/
  public Cliente(Cliente outro)
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
  public Cliente clone()
  {
    return new Cliente(this);
  }
    
    /************************* EQUALS *************************/
  public boolean equals(Object o)
  {
      if(this == o) return true;
      if(o != null && this.getClass() != o.getClass()) return false;
      Cliente c = (Cliente) o;     
       return this.x == c.getX() &&
              this.y == c.getY() ;
               
  }
    
    /************************* TOSTRING *************************/
  public String toString()
  {
      return "Cordernadas: (" + x + "," + y + ")";
             
  }
    
}

