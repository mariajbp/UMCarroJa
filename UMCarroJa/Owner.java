import java.util.*;
import java.io.Serializable;
import java.util.ArrayList;

/**
* Representação da classe propietário, subclasse de USER
**/
public class Owner extends USER implements Serializable
{
  double rating;
  private Set<RentedCar> rentingHistory;
  
  public Owner(String name, String password, String email, String address)
  {
     super(name,password,email,address);
     this.rentingHistory = new TreeSet<RentedCar>();
  }
  
  public Owner(Owner o)
  {
      super(o.getName(),o.getPassword(),o.getEmail(), o.getAddress());
      this.rating = o.getRating();
      this.rentingHistory = o.getRentingHistory();
  }
    
  /************************* GETTERS *************************/
  public double getRating(){return this.rating;}
  
  public Set<RentedCar> getRentingHistory()
  {
    Set<RentedCar> aux = new TreeSet<>();
    for(RentedCar rc: this.rentingHistory){aux.add(rc.clone());}
    return aux;
  }
  
  /************************* SETTERS *************************/
  public void setRating(double r){this.rating = r;}
  
  public void setRentingHistory(Set<RentedCar> rc)
  {
      this.rentingHistory.clear();
      for(RentedCar r: rc){this.rentingHistory.add(r.clone());}
  }
  
  public void addRentedCar(RentedCar r){this.rentingHistory.add(r.clone());}
  
  public void removeRentedCar(RentedCar r){this.rentingHistory.remove(r);}
    
  public void addSetRentedCar(Set<RentedCar> h)
  {
      for(RentedCar r : h) this.rentingHistory.add(r.clone());
  }
  
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


