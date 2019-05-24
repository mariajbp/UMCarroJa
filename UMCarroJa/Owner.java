import java.util.*;
import java.io.Serializable;
import java.util.ArrayList;

/**
* Representação da classe propietário, subclasse de USER
**/
public class Owner extends USER implements Serializable
{
  private Set<RentedCar> rentingHistory;
  private Map<String,Vehicle> vh;
  
  /** Construtor vazio que cria uma instância Owner  **/
  public Owner()
  {
      super();
      this.rentingHistory = new TreeSet<RentedCar>();
      this.vh = new HashMap<String, Vehicle>();
  }
  /** Construtor que cria um novo Owner a partir dos parâmetros dados **/
  public Owner(String name, int nif, String email, String address)
  {
     super(name,nif,email,address);
     this.rentingHistory = new TreeSet<RentedCar>();
     this.vh = new HashMap<String, Vehicle>();
  }
  /** Construtor de cópia que cria uma nova instância Owner a partir de um Owner passado como parâmetro **/
  public Owner(Owner o)
  {
      super(o.getName(),o.getNif(),o.getEmail(), o.getAddress());
      this.rentingHistory = o.getRentingHistoryAll();
      this.vh = o.getVehicles();
  }
    
  /************************* GETTERS *************************/
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
      int nr = (this.getRating() + newR)/(this.rentingHistory.size());
      this.setRating(nr);
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
             this.vh.equals(ow.getVehicles()) &&
             this.rentingHistory.equals(ow.getRentingHistoryAll());      
  } 
    
  /************************* TOSTRING *************************/
  public String toString()
  {
      return "Classificação: "  ;       
  }  
  
  /**
  * Método que altera a disponibilidade do veículo
  * @param Veículo a alterar
  * @param Disponibilidade atual do veículo 
  **/
  public void changeVhAvailability(Vehicle v, boolean av){ this.vh.get(v.getPlate()).setAvailability(av);}
  
  /**
  * Método que altera o preço do veículo
  * @param Veículo a alterar
  * @param Novo preço 
  **/
  public void changePriceKM(Vehicle v, double p){ this.vh.get(v.getPlate()).setPrice(p);}
  
  /**
  * Método que permite o proprietário abastecer o veículo
  * @param Matricula do veículo
  **/
  public void refuel(String plate)
  {
      Vehicle v = this.vh.get(plate);
      v.setAutonomy(v.getDeposit());
  }
    
 
  /**
  * Método que calcula a classificação de um proprietário 
  **/
  public void ownerRating()
  {
     int r = this.vh.values().stream().mapToInt(Vehicle::getRating).sum();
     this.setRating(r/(this.vh.size()));
  }

}


