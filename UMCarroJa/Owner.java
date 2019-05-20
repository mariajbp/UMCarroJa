import java.util.*;
import java.io.Serializable;
import java.util.ArrayList;

/**
* Representação da classe propietário, subclasse de USER
**/
public class Owner extends USER implements Serializable
{
  int rating;
  private Set<RentedCar> rentingHistory;
  private Map<String,Vehicle> vh;
  
  public Owner()
  {
      super();
      this.rating = 0;
      this.rentingHistory = new TreeSet<RentedCar>();
      this.vh = new HashMap<String, Vehicle>();
  }
  
  public Owner(String name, String password, String email, String address, int nif)
  {
     super(name,password,email,address,nif);
     this.rating = 0;
     this.rentingHistory = new TreeSet<RentedCar>();
     this.vh = new HashMap<String, Vehicle>();
  }
  
  public Owner(Owner o)
  {
      super(o.getName(),o.getPassword(),o.getEmail(), o.getAddress(), o.getNif());
      this.rating = o.getRating();
      this.rentingHistory = o.getRentingHistoryAll();
      this.vh = o.getVehicles();
  }
    
  /************************* GETTERS *************************/
  public int getRating(){return this.rating;}
  
  public Set<RentedCar> getRentingHistoryAll()
  {
    Set<RentedCar> aux = new TreeSet<RentedCar>();
    for(RentedCar rc: this.rentingHistory){aux.add(rc.clone());}
    return aux;
  }
  
  public Map<String,Vehicle> getVehicles()
  {
       Map<String,Vehicle> aux = new HashMap<String, Vehicle>();
       for(Map.Entry<String,Vehicle> v: this.vh.entrySet()){ aux.put(v.getKey(), v.getValue().clone());}
       return aux;
  }
  
  /************************* SETTERS *************************/
  public void setRating(int newR)
  {
      int nr = (this.rating + newR)/(this.rentingHistory.size());
      this.rating = nr;
  }
  
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
    Owner o = new Owner(this);
    return o;
  }
   
   /************************* EQUALS ********************/
  public boolean equals(Object o)
  {
      if(this == o) return true;
      if(o == null && this.getClass() != o.getClass()) return false;
      Owner ow = (Owner) o;     
      return super.equals(ow) &&
             this.rating == ow.getRating() && 
             this.vh.equals(ow.getVehicles()) &&
             this.rentingHistory.equals(ow.getRentingHistoryAll());      
  } 
    
  /************************* TOSTRING *************************/
  public String toString()
  {
      return "Classificação: " + rating ;       
  }  
  
  //Altera a disponibilidade do veículo 
  public void changeVhAvailability(Vehicle v, boolean av){ this.vh.get(v.getPlate()).setAvailability(av);}
  
  //Altera o preço por km
  public void changePriceKM(Vehicle v, double p){ this.vh.get(v.getPlate()).setPrice(p);}
  

  //Abastece o veiculo 
  public void refuel(String plate)
  {
      Vehicle v = this.vh.get(plate);
      v.setAutonomy(v.getDeposit());
  }
  
  //aceitar ou rejeitar um aluguer 
  public void acceptORreject(Client c, Vehicle v)
  {
    
  }
  
  /*
  //registar o custo de uma viagem
  public void priceReg(String plate, double price)
  {
      
  }
  */
 
  //classificação de acordo com cada um dos seus veiculos
  public void ownerRating()
  {
     int r = this.vh.values().stream().mapToInt(Vehicle::getRating).sum();
     this.rating = r/(this.vh.size());
  }

}


