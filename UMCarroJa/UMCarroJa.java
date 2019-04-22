import java.util.*;
import java.io.Serializable;
import static java.lang.System.out;

/**
* MAIN
**/
public class UMCarroJa implements Serializable
{
  private int userType; // 1 client // 2 is owner
  private int nVehicles;
  private TreeMap<String, Client> clients;
  private TreeMap<String, Owner> owners; //not sure its needed
  private TreeMap<String, Vehicle> vehicles;
  private TreeSet<Ride> ride;
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
  
  public Map<String, Owner> getOwners() throws NoOwnersException
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
  
  
  /*** Menu dos clientges **/
  public Ride getSpecificCar(String plate)
  {
     Iterator<Ride> it = this.ride.iterator();
     Boolean f = false;
     Ride r = null;
     while(it.hasNext() && !f)
     {
        r = it.next();
        if(r.getVehicle().getPlate().equals(plate)) f = true;
     }
    return r;
  }
  
  //carro mais proximo no geral
  public Ride getClosestCar(Client c)
  {
    Iterator<Ride> it = this.ride.iterator();
    Ride r = null;
    double distance = 0.0; 
    double dst = 0.0;
    int f = 0;
    if(it.hasNext())
    {
      r = it.next();
      distance = r.getLocation().distanceTo(c.getLocation());
    }
    else System.out.println("Não existem carros disponiveis");
    while(it.hasNext())
    {
      r = it.next();
      dst = r.getLocation().distanceTo(c.getLocation());
      if(distance > dst) distance = dst;
    }
    return r;
  }
  
  //carro eletrico mais proximo
  public Ride getClosestElectric(Client c)
  {
    Iterator<Ride> it = this.ride.iterator();
    Ride r = null;
    double distance = 0.0;
    double dst = 0.0;
    int f = 0;
    while(it.hasNext() && f==0)
    {
      r = it.next();
      if(r.getVehicle() instanceof Electric)
      {
        f=1;
        distance = r.getLocation().distanceTo(c.getLocation());
      }
    }
    if(it.hasNext() == false && r.getVehicle() instanceof Electric) return r;
    else if(it.hasNext() == false && !(r.getVehicle() instanceof Electric)) return null;
    while(it.hasNext())
    {
      r = it.next();
      if(r.getVehicle() instanceof Electric)
      {
        dst = r.getLocation().distanceTo(c.getLocation());
        if(distance > dst) distance = dst;
      }
    }
    return r;
  }
  
  public Ride getClosestGas(Client c)
  {
    Iterator<Ride> it = this.ride.iterator();
    Ride r = null;
    double distance = 0.0;
    double dst = 0.0;
    int f = 0;
    while(it.hasNext() && f==0)
    {
      r = it.next();
      if(r.getVehicle() instanceof Gas)
      {
        f=1;
        distance = r.getLocation().distanceTo(c.getLocation());
      }
    }
    if(it.hasNext() == false && r.getVehicle() instanceof Gas) return r;
    else if(it.hasNext() == false && !(r.getVehicle() instanceof Gas)) return null;
    while(it.hasNext())
    {
      r = it.next();
      if(r.getVehicle() instanceof Gas)
      {
        dst = r.getLocation().distanceTo(c.getLocation());
        if(distance > dst) distance = dst;
      }
    }
    return r;
  }
  
  public Ride getClosestHybrid(Client c)
  {
    Iterator<Ride> it = this.ride.iterator();
    Ride r = null;
    double distance = 0.0;
    double dst = 0.0;
    int f = 0;
    while(it.hasNext() && f==0)
    {
      r = it.next();
      if(r.getVehicle() instanceof Hybrid)
      {
        f=1;
        distance = r.getLocation().distanceTo(c.getLocation());
      }
    }
    if(it.hasNext() == false && r.getVehicle() instanceof Hybrid) return r;
    else if(it.hasNext() == false && !(r.getVehicle() instanceof Hybrid)) return null;
    while(it.hasNext())
    {
      r = it.next();
      if(r.getVehicle() instanceof Hybrid)
      {
        dst = r.getLocation().distanceTo(c.getLocation());
        if(distance > dst) distance = dst;
      }
    }
    return r;
  }
  
  
  public Ride DesiredAutonomy(Double autD) //APENAS RETORNA UM CARRO SE A AUTONOMIA FOR IGUAL, ALTERAR PARA PODER SER MAIOR?
  {
    Iterator<Ride> it = this.ride.iterator();
    Ride r = null;
    double autC = 0.0; 
    double dst = 0.0;
    int f = 0;
    if(it.hasNext())
    {
      r = it.next();
      autC = r.getVehicle().getAutonomy();
    }
    else out.println("Não existem carros disponiveis");
    while(it.hasNext())
    {
      r = it.next();
      dst = r.getVehicle().getAutonomy();
      if(autD == dst) return r;
    }
    return r;
  }
  
  /**
  public Ride cheapestCar()
  {
      Iterator<Ride> it = this.ride.iterator();
      Ride r = null;
      double pricekm;
      double price = 0.0;
      if(it.hasNext())
      {
          r = it.next();
          pricekm = (r.getVehicle().getPrice() * r.getVehicle().getConsumption());
      }else out.println("Não existem carros disponiveis");
      while(it.hasNext())
      {
          r = it.next();
          pricekm = (r.getVehicle().getPrice() * r.getVehicle().getConsumption());
          
      }
      
      
      return r;
  }

  
  public Ride cheapestWithWalk(Client c)
  {
      
  }
  
   **/
  
  /****vai estar no menu dos proprietários ****/
  public void signal(Ride r)
  {
      //sinalizar se carro está disponivel para aluguer, é só chamar o isocupied da ride
  }
  
  public void refuelCar()
  {
      //dar update à autonomia do carro
  }
  
  public void acceptORreject()
  {
       //aceitar ou rejeitar um aluguer
  }
  //alterar preço por km
  public void changePriceKM()
  {
      //alterar preço por km
  }
  public void priceRegist()
  {
       //registar o custo de um viagem
  }
  
  
  
  public void printClient(Client c)
  {
    out.println(this.clients.get(c.getEmail()).getName());
    out.println(this.clients.get(c.getEmail()).getEmail());
    out.println(this.clients.get(c.getEmail()).getAddress());
    out.println(this.clients.get(c.getEmail()).getBday());
  }
  
  public void printOwner(Owner o)
  {
    out.println(this.owners.get(o.getEmail()).getName());
    out.println(this.owners.get(o.getEmail()).getEmail());
    out.println(this.owners.get(o.getEmail()).getAddress());
    out.println(this.owners.get(o.getEmail()).getBday());
  }
  
  
  public String insertPlate()
  {
    Scanner input = new Scanner(System.in);
    String plate = null;
    String apl = null;
    if(this.ride.isEmpty()==false)
    {
      Iterator<Ride> it = this.ride.iterator();
      Ride r;
      int f = 0;
      do
      {
        out.print("Escolha a matrícula do carro pretendido: ");
        plate = input.nextLine();
        while(it.hasNext() && f==0)
        {
          r = it.next();
          apl = r.getVehicle().getPlate();
          if(apl.equals(plate)) f=1;
        }
        if(f==0)
        {
          out.println("Matrícula inválida. Tente outra vez!");
          it = this.ride.iterator();
        }
      }while(f==0);
    }
    return plate;
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
  
  public boolean checkEmail(String email)
  {
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
