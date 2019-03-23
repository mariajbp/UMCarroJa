import java.util.*;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * DESCREVER ESTA CLASSE DE UMA MANEIRA PANELEIRA 
 */
public class Owner extends USER implements Serializable
{
  private double rating;

  public Owner()
  {
      this.rating = 0;
  }

  public Owner(String email,String name,String password,String address,String date,double n_rating)

  {
     super(email, name,password,address,date);
     this.rating = n_rating;
  }


  /**
  * Construtor de cópia - recebe um objeto e cria uma cópia dele
  **/
  public Owner(Owner o)
  {
      super(o);
      this.rating = o.getRating();
  }
    
    /************************* GETTERS *************************/
  public double getRating(){return this.rating;}
  
   /************************* SETTERS *************************/
  public void setRating(double newRating){this.rating = newRating;}

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


