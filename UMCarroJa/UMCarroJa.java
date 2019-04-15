import java.util.*;
import java.io.Serializable;

/**
 * Isto é a main
 */
public class UMCarroJa implements Serializable
{
  private int userType; // 1 client // 2 is driver
  private int nVehicles;
  private TreeMap<String, Client> clients;
  private TreeMap<String, Owner> owners; //not sure its needed
  private TreeMap<String, Vehicle> vehicles;
  private double totalProfit; //num determinado periodo
  
  //construtores tostrings clones etc idk if will be used
  
  public int getUserType(){return this.userType;}
  
  public int getNCars(){return this.nVehicles;}
  
  public double getTotalProfit(){return this.totalProfit;}
  
  public void setTotalProfit(double money){this.totalProfit += money;}
  
  public void updateClient(Client c){this.clients.replace(c.getEmail(), c);}

  public void updateDriver(Owner o){this.owners.replace(o.getEmail(), o);}
  
  public Map<String, Client> getClients() throws NoClientsException
  {
    if(this.clients.isEmpty()) throw new NoClientsException("Não existem clientes na base de dados");
    else
    {
      Map<String,Client> neo = new TreeMap<String,Client>();
      for(Map.Entry<String, Client> entrys : this.clients.entrySet())
      {
        neo.put(entrys.getKey(), entrys.getValue());
      }
      return neo;
    }
  }
  
  public Map<String, Owner> getDrivers() throws NoOwnersException
  {
    if(this.owners.isEmpty()) throw new NoOwnersException("Não existem proprietários na base de dados");
    else
    {
      Map<String,Owner> neo = new TreeMap<String, Owner>();
      for(Map.Entry<String,Owner> entrys : this.owners.entrySet())
      {
        neo.put(entrys.getKey(), entrys.getValue());
      }
      return neo;
    }
  }
  
  public Map<String, Vehicle> getVehicles() throws NoCarsAvailableException
  {
    if(this.vehicles.isEmpty()) throw new NoCarsAvailableException("Não existem veículos na base de dados");
    else
    {
      Map<String,Vehicle> neo = new TreeMap<String,Vehicle>();
      for(Map.Entry<String,Vehicle> entrys : this.vehicles.entrySet())
      {
        neo.put(entrys.getKey(), entrys.getValue());
      }
      return neo;
    }
  }
  
  public void addClient(Client neo) throws UserExistsException
  {
    if(this.clients.containsKey(neo.getEmail())) throw new UserExistsException("O cliente já existe");
    this.clients.put(neo.getEmail(), neo);
  }
  
  public void addOwner(Owner neo) throws UserExistsException
  {
    if(this.owners.containsKey(neo.getEmail())) throw new UserExistsException("O proprietário já existe");
    this.owners.put(neo.getEmail(), neo);
  }
  
  public void addVehicle (Vehicle neo) throws VehicleExistsException
  {
    if(this.vehicles.containsKey(neo.getPlate())) throw new VehicleExistsException("O veículo já existe");
    this.vehicles.put(neo.getPlate(),neo);
  }
  
  /**** vai estar no menu dos clientes ****/
  //ALGUGER DO CARRO MAIS PROX DAS SUAS COORDENADAS
  //ALGUGER DO CARRO MAIS barato
  //ALGUGER DO CARRO MAIS barato num distancia que queiram percorrer a pé
  //aluger de um carro especifico
  //aluguer de carro com autonomia desejada
  
  /****vai estar no menu dos proprietários ****/
  //sinalizar se carro está disponivel para aluguer
  //abastecer o carro
  //alterar preço por km
  //aceitar ou rejeitar um aluguer
  //registar o custo de um viagem
 
  
  
  public void printClient(Client c)
  {
    System.out.println(this.clients.get(c.getEmail()).getName());
    System.out.println(this.clients.get(c.getEmail()).getEmail());
    System.out.println(this.clients.get(c.getEmail()).getAddress());
    System.out.println(this.clients.get(c.getEmail()).getBday());
  }
  
  public void printDriver(Owner o)
  {
    System.out.println(this.owners.get(o.getEmail()).getName());
    System.out.println(this.owners.get(o.getEmail()).getEmail());
    System.out.println(this.owners.get(o.getEmail()).getAddress());
    System.out.println(this.owners.get(o.getEmail()).getBday());
  }
  
  
  public void login(String email, String password) throws UserDoesntExistException
  {
    if(this.clients.containsKey(email) != false)
    {
      this.userType = 1;
      if(!password.equals(this.clients.get(email).getPassword())) throw new UserDoesntExistException("Password incorreta");
    }
    else
    {
      if(this.owners.containsKey(email) != false)
      {
        this.userType = 2;
        if(!password.equals(this.owners.get(email).getPassword())) throw new UserDoesntExistException("Password incorreta");
      }
      else throw new UserDoesntExistException("Utilizador não encontrado");
    }
  }
  
  public boolean checkEmail(String email){
    if(!this.clients.isEmpty())
    {
      if(this.clients.containsKey(email)) return true;
      if(!this.owners.isEmpty()) return (this.owners.containsKey(email));
      return false;
    }
    if(!this.owners.isEmpty()) return this.owners.containsKey(email);
    return false;
  }
  
  public static void main(String[] args)
  {
        new App().run();
  }
}
