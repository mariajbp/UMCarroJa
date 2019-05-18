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
  private Map<String,Vehicle> vh;
  
  public Owner(String name, String password, String email, String address)
  {
     super(name,password,email,address);
     this.rating = rating;
     this.rentingHistory = new TreeSet<RentedCar>();
     this.vh = new HashMap<>();
  }
  
  public Owner(Owner o)
  {
      super(o.getName(),o.getPassword(),o.getEmail(), o.getAddress());
      this.rating = o.getRating();
      this.rentingHistory = o.getRentingHistory();
      this.vh = o.getVehicles();
  }
    
  /************************* GETTERS *************************/
  public double getRating(){return this.rating;}
  
  public Set<RentedCar> getRentingHistory()
  {
    Set<RentedCar> aux = new TreeSet<>();
    for(RentedCar rc: this.rentingHistory){aux.add(rc.clone());}
    return aux;
  }
  
  public Map<String,Vehicle> getVehicles()
  {
       Map<String,Vehicle> aux = new HashMap<>();
       for(Map.Entry<String,Vehicle> v: this.vh.entrySet()){ aux.put(v.getKey(), v.getValue().clone());}
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
  
  public void setVehicles(Map<String,Vehicle> ve)
  {
       this.vh.clear();
       for(Map.Entry<String,Vehicle> v: ve.entrySet()){this.vh.put(v.getKey(), v.getValue().clone()); }
  }
  
  public void addVehicle(Vehicle v){this.vh.put(v.getPlate(),v.clone());}
  
  public void removeVehicle(Vehicle v){ this.vh.remove(v.getPlate());}
  
  
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
              this.rating == ow.getRating() && this.vh.equals(ow.getVehicles());      
  } 
    
  /************************* TOSTRING *************************/
  public String toString()
  {
      return "Classificação: " + rating;       
  }  
  
  //Altera a disponibilidade do veículo 
  public void changeVhAvailability(Vehicle v, boolean av){ this.vh.get(v.getPlate()).setAvailability(av);}
  
  //Altera o preço por km
  public void changePriceKM(Vehicle v, double p){ this.vh.get(v.getPlate()).setPrice(p);}
  

  //Abastece o veiculo 
  
  //aceitar ou rejeitar um aluguer 
  
  //registar o custo de uma viagem
  
  //classificação de acordo com cada um dos seus veiculos
  
  //Altera a classificação a partir de uma nova classificação atribuida
  /** ler todas as classificações do seu set de rents e faz a media **/

}


