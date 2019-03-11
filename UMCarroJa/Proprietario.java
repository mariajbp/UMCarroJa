/**
 * DESCREVER ESTA CLASSE DE UMA MANEIRA PANELEIRA 
 */
public class Proprietario
{
  private int rating;
  //HISTORICA VAI SER UMA ESTRUTURA QQ

  /**
  * Construtor por omissão - sem parametros/vazio
  **/
  public Proprietario()
  {
     this.rating= 0;
  }
     
  /**
  * Construtor parametrizado - define um valor incial para 
  * cada variavel
  **/
   
  public Proprietario(int new_rating)
  {
     this.rating = new_rating;
  }
    
  /**
  * Construtor de cópia - recebe um objeto e cria uma cópia dele
  **/
  public Proprietario(Proprietario outro)
  {
     this.rating = outro.getRating();
  }
    
    /************************* GETTERS *************************/
  public int getRating(){return this.rating;}
  
   /************************* SETTERS *************************/
  public void setRating(int newRating){this.rating = newRating;}

   /************************* CLONE *************************/
  public Proprietario clone()
  {
    return new Proprietario(this);
  }
    
    /************************* EQUALS *************************/
  public boolean equals(Object o)
  {
      if(this == o) return true;
      if(o != null && this.getClass() != o.getClass()) return false;
      Proprietario p = (Proprietario) o;     
       return this.rating == p.getRating();
               
  }
    
    /************************* TOSTRING *************************/
  public String toString()
  {
      return "Classificação: " + rating;
             
  }
    
}


