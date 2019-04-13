import java.util.*;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * DESCREVER ESTA CLASSE DE UMA MANEIRA PANELEIRA 
 */
public class Owner extends USER implements Serializable
{
  private ArrayList<Double> rating;
  double beforeRating;

  public Owner(String email,String name,String password,String address,String date,ArrayList<Double> rating, double beforeRating)
  {
     super(email, name,password,address,date);
     this.rating = new ArrayList<Double>();
     this.beforeRating = beforeRating;
  }
  
  public Owner(Owner o)
  {
      super(o);
      this.rating = new ArrayList<Double>();
      this.beforeRating = o.getBeforeRating();
  }
    
  /************************* GETTERS *************************/
  public ArrayList<Double> getRating() throws NoRatingsException
  {
      if(this.rating.isEmpty()) throw new NoRatingsException("Sem Avaliações");
      else
      {
        ArrayList<Double> neo = new ArrayList<Double>();
        for(double d : this.rating){neo.add(d);}
        return neo;
      }
  }
  
  public double getBeforeRating(){return this.beforeRating;}
  
  /************************* SETTERS *************************/
  public void setRatingList(ArrayList<Double> list)
  {
      for(double d : list){ this.rating.add(d);}
  }
  
  public void setBeforeRating(double bf){this.beforeRating = bf;}
  
    
  public void updateRating()
  {
      double c = 0;
      for(double d : this.rating){c+=d;}
      this.beforeRating = c/this.rating.size();
  }
  
  public void addRating(double n)
  {
      this.rating.add(n);
  }

   /************************* CLONE *************************/
  public Owner clone()
  {
    return new Owner(this); //IMPLEMENTAR DIFERENTE????
  }
  
    
    /************************* EQUALS ********************
   public boolean equals(Object o)
   {
      if(this == o) return true;
      if(o != null && this.getClass() != o.getClass()) return false;
      Owner p = (Owner) o;     
       return this.rating == p.getRating();
               
  } ****/
    
    /************************* TOSTRING ************
  public String toString()
  {
      return "Classificação: " + rating;
             
  }  *************/
}


