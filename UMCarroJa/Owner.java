import java.util.*;
import java.io.Serializable;
import java.util.ArrayList;

/**
* Representação da classe propietário, subclasse de USER
**/
public class Owner extends USER implements Serializable
{
  private ArrayList<Double> ratings;
  double acRating;
  
  public Owner()
  {
      acRating = 0;
  }
  
  public Owner(String name, String password, String email, String address, double acRating)
  {
     super(name, password,email,address);
     this.acRating = acRating;
  }
  
  public Owner(Owner o)
  {
      super(o.getName(),o.getPassword(),o.getEmail(), o.getAddress());
      this.ratings = new ArrayList<Double>();
      this.acRating = o.getAcRating();
  }
    
  /************************* GETTERS *************************/
  public ArrayList<Double> getRating() throws NoRatingsException
  {
      if(this.ratings.isEmpty()) throw new NoRatingsException("Sem Avaliações");
      else
      {
        ArrayList<Double> neo = new ArrayList<Double>();
        for(double d : this.ratings){neo.add(d);}
        return neo;
      }
  }

  public double getAcRating(){return this.acRating;}
  
  /************************* SETTERS *************************/
  public void setRatingList(ArrayList<Double> list)
  {
      for(double d : list){ this.ratings.add(d);}
  }
  
  public void setBeforeRating(double bf){this.acRating = bf;}
  
  /*** Outros ***/
  public void updateRating()
  {
      double c = 0;
      for(double d : this.ratings){c+=d;}
      this.acRating = c/this.ratings.size();
  }
  
  public void addRating(double n)
  {
      this.ratings.add(n);
  }
  
  
  
   /************************* CLONE *************************/
  public Owner clone()
  {
    Owner o = new Owner(this.getName(), this.getPassword(), this.getEmail(), this.getAddress(), this.getAcRating());
    return o;
  }
  
    
   /************************* EQUALS ********************/
  public boolean equals(Object o)
  {
      if(this == o) return true;
      if(o != null && this.getClass() != o.getClass()) return false;
      Owner ow = (Owner) o;     
       return super.equals(ow) &&
              this.acRating == ow.getAcRating();      
  } 
    
  /************************* TOSTRING ************
  public String toString()
  {
      return "Classificação: " + acrating;
             
  }  *************/
}


