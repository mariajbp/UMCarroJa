import java.util.*;
import java.io.Serializable;
/**
 * DESCREVER ESTA CLASSE DE UMA MANEIRA PANELEIRA 
 */
public class Owner extends USER implements Serializable
{
  private int rating;
  //HISTORICA VAI SER UMA ESTRUTURA QQ

<<<<<<< HEAD:UMCarroJa/Owner.java
  /**
  * Construtor por omissão - sem parametros/vazio
  **/
  public Owner()
=======
  public Owner(String email,String name,String password,String address,String date,int rating)
>>>>>>> d014108950af8a6bf7756c4b8fb7399f1ef019a6:UMCarroJa/Owner.java
  {
     super(email, name,password,address,date);
     this.rating= 0;
  }
     
<<<<<<< HEAD:UMCarroJa/Owner.java
  /**
  * Construtor parametrizado - define um valor incial para 
  * cada variavel
  **/
   
=======
>>>>>>> d014108950af8a6bf7756c4b8fb7399f1ef019a6:UMCarroJa/Owner.java
  public Owner(int new_rating)
  {
     this.rating = new_rating;
  }
    
<<<<<<< HEAD:UMCarroJa/Owner.java
  /**
  * Construtor de cópia - recebe um objeto e cria uma cópia dele
  **/
  public Owner(Owner outro)
=======
  public Owner(Owner o)
>>>>>>> d014108950af8a6bf7756c4b8fb7399f1ef019a6:UMCarroJa/Owner.java
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
<<<<<<< HEAD:UMCarroJa/Owner.java
    return new Owner(this);
=======
    return new Owner(this); //IMPLEMENTAR DIFERENTE!!!
>>>>>>> d014108950af8a6bf7756c4b8fb7399f1ef019a6:UMCarroJa/Owner.java
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


