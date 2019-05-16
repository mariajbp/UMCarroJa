import java.util.*;
import java.io.Serializable;
import java.util.ArrayList;

/**
* Representação da classe propietário, subclasse de USER
**/
public class Owner extends USER implements Serializable
{
  double rating;
  
  public Owner(String name, String password, String email, String address)
  {
     super(name,password,email,address);
  }
  
  public Owner(Owner o)
  {
      super(o.getName(),o.getPassword(),o.getEmail(), o.getAddress());
      this.rating = o.getRating();
  }
    
  /************************* GETTERS *************************/
  public double getRating(){return this.rating;}
  
  /************************* SETTERS *************************/
  public void setRating(double r){this.rating = r;}
  
  
  
   /************************* CLONE *************************/
  public Owner clone()
  {
    Owner o = new Owner(this.getName(), this.getPassword(), this.getEmail(), this.getAddress());
    return o;
  }
  
    
   /************************* EQUALS ********************/
  public boolean equals(Object o)
  {
      if(this == o) return true;
      if(o != null && this.getClass() != o.getClass()) return false;
      Owner ow = (Owner) o;     
       return super.equals(ow) &&
              this.rating == ow.getRating();      
  } 
    
  /************************* TOSTRING ************
  public String toString()
  {
      return "Classificação: " + rating;
             
  }  *************/
}


