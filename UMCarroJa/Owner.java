import java.util.*;
import java.io.Serializable;
/**
 * DESCREVER ESTA CLASSE DE UMA MANEIRA PANELEIRA 
 */
public class Owner extends USER implements Serializable
{
  private int rating;
  //HISTORICA VAI SER UMA ESTRUTURA QQ

  public Owner(String email,String name,String password,String address,String date,int rating)
  {
     super(email, name,password,address,date);
     this.rating= 0;
  }
     
  public Owner(int new_rating)
  {
     this.rating = new_rating;
  }
    
  public Owner(Owner o)
  {
     this.rating = o.getRating();
  }
    
    /************************* GETTERS *************************/
  public int getRating(){return this.rating;}
  
   /************************* SETTERS *************************/
  public void setRating(int newRating){this.rating = newRating;}

   /************************* CLONE *************************/
  public Owner clone()
  {
    return new Owner(this); //IMPLEMENTAR DIFERENTE!!!
  }
    
    /************************* EQUALS *************************/
  public boolean equals(Object o)
  {
      if(this == o) return true;
      if(o != null && this.getClass() != o.getClass()) return false;
      Owner p = (Owner) o;     
       return this.rating == p.getRating();
               
  }
    
    /************************* TOSTRING *************************/
  public String toString()
  {
      return "Classificação: " + rating;
             
  }
    
}


