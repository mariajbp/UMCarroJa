import java.util.*;
import java.io.Serializable;

/**
* Representação da classe propietário, subclasse de USER
**/
public class Owner extends USER implements Serializable
{
  private Set<RentedCar> rentingHistory;
  private Map<String,Vehicle> vh;
  
  /** 
  * Construtor vazio que cria uma instância Owner 
  **/
  public Owner()
  {
      super();
      this.rentingHistory = new TreeSet<RentedCar>();
      this.vh = new HashMap<String, Vehicle>();
  }
  
  /** 
  * Construtor que cria um novo Owner a partir dos parâmetros dados 
  **/
  public Owner(String name, int nif, String email, String address)
  {
     super(name,nif,email,address);
     this.rentingHistory = new TreeSet<RentedCar>();
     this.vh = new HashMap<String, Vehicle>();
  }
  
  /** 
  * Construtor de cópia que cria uma nova instância Owner a partir de um Owner passado como parâmetro 
  **/
  public Owner(Owner o)
  {
      super(o.getName(),o.getNif(),o.getEmail(), o.getAddress());
      this.rentingHistory = o.getRentingHistoryAll();
      this.vh = o.getVehicles();
  }
    
  /**
  * Método que devolve o historico de um proprietário
  * @returns Historico de um proprietário
  **/
  public Set<RentedCar> getRentingHistoryAll()
  {
    Set<RentedCar> aux = new TreeSet<RentedCar>();
    for(RentedCar rc: this.rentingHistory){aux.add(rc.clone());}
    return aux;
  }
  
  /**
  * Método que devolve todos os veículos de um proprietário
  * @returns Todos os veículos de um proprietário
  **/
  public Map<String,Vehicle> getVehicles()
  {
       Map<String,Vehicle> aux = new HashMap<String, Vehicle>();
       for(Map.Entry<String,Vehicle> v: this.vh.entrySet()){ aux.put(v.getKey(), v.getValue().clone());}
       return aux;
  }
  
  
  /**
  * Método que devolve todos os veículos de um proprietário
  * @param Todos os veículos de um proprietário
  **/
  public void setRentingHistory(Set<RentedCar> rc)
  {
      this.rentingHistory.clear();
      for(RentedCar r: rc){this.rentingHistory.add(r.clone());}
  }
  
  /**
  * Método que adiciona um aluguer ao historico
  * @param Aluguer realizado 
  **/
  public void addRentedCar(RentedCar r){this.rentingHistory.add(r.clone());}
  
  /**
  * Método que remove um aluguer ao historico
  * @param Aluguer realizado 
  **/
  public void removeRentedCar(RentedCar r){this.rentingHistory.remove(r);}
  
  /**
  * Método que adiciona um  conjunto de alugueres ao historico
  * @param Aluguer realizado
  **/
  public void addSetRentedCar(Set<RentedCar> h)
  {
      for(RentedCar r : h) this.rentingHistory.add(r.clone());
  }
  
  /**
  * Método que define os veículos de um proprietário
  * @param Veículos de um proprietário
  **/
  public void setVehicles(Map<String,Vehicle> ve)
  {
       this.vh.clear();
       for(Map.Entry<String,Vehicle> v: ve.entrySet()){this.vh.put(v.getKey(), v.getValue().clone()); }
  }
  
  /**
  * Método que adiciona um veículo à lista de veículos do cliente
  * @param Veículo 
  **/
  public void addVehicle(Vehicle v){this.vh.put(v.getPlate(),v.clone());}
  
  /**
  * Método que remove um veículo à lista de veículos do cliente
  * @param Veículo 
  **/
  public void removeVehicle(Vehicle v){ this.vh.remove(v.getPlate());}
  
  
  /** 
  * Método que cria uma cópia de uma identificação de um Owner
  **/
  public Owner clone()
  {
    Owner o = new Owner(this);
    return o;
  }
   
  /** 
  * Método que testa se um objeto é igual a uma determinada identificação
  * @param      Objeto a ser testado
  * @return     True se o objeto for igual à identificação, false se o objeto passado não for igual à identificação
  **/
  public boolean equals(Object o)
  {
      if(this == o) return true;
      if(o == null && this.getClass() != o.getClass()) return false;
      Owner ow = (Owner) o;     
      return super.equals(ow) &&
             this.vh.equals(ow.getVehicles()) &&
             this.rentingHistory.equals(ow.getRentingHistoryAll());      
  } 
    
  /**
  * Método que converte uma identificação numa string
  * @return  string com a identificação do utilizador
  **/
  public String toString()
  {
       StringBuilder sb = new StringBuilder();
       sb.append(super.toString()).append("\n");
       return sb.toString();   
  }  
  
  /**
  * Método que altera a disponibilidade do veículo
  * @param   Veículo a alterar
  * @param   Disponibilidade atual do veículo 
  **/
  public void changeVhAvailability(Vehicle v, boolean av){ this.vh.get(v.getPlate()).setAvailability(av);}
  
  /**
  * Método que altera o preço do veículo
  * @param   Veículo a alterar
  * @param   Novo preço do veículo
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
  public void ownerRating(int newR)
  {
     if(this.rentingHistory.size() == 0)
            this.setRating(newR);
      else
      {
          int nr = (this.getRating() + newR)/(this.rentingHistory.size());
          this.setRating(nr);
        }
  }

}


