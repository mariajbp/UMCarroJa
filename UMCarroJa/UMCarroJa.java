import java.util.Map;
import java.util.HashMap;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;
import java.io.Serializable;
import java.io.IOException;
import java.io.*; 
import java.util.stream.Collectors;

/**
*Classe que gere a aplicação, onde estão definidas as principais funções que dão resposta ao enunciado.
**/
public class UMCarroJa implements Serializable
{
   private Map<Integer, Client> clients;            //NIF
   private Map<Integer, Owner> owners;              //NIF
   private Map<String, Vehicle> vehicles;          //Plate
   
   /** 
   * Construtor vazio que cria uma instância UMCarroJa 
   **/
   public UMCarroJa()
   {
       this.clients = new HashMap<Integer,Client>();
       this.owners = new HashMap<Integer,Owner>();
       this.vehicles = new HashMap<String, Vehicle>();
   }
   
   /** 
   * Construtor que cria uma nova instância UMCarroJa a partir de um UMCarroJa passado como parâmetro 
   **/
   public UMCarroJa(UMCarroJa u)
   {
       this.clients = u.getClients();
       this.owners = u.getOwners();
       this.vehicles = u.getVehicles();
   }
   
    
   /** 
   * Método que devolve os veiculos inscritos na aplicação 
   * @returns   HashMap dos veículos inscritos na aplicação
   **/
   public Map<String, Vehicle> getVehicles()
   {
       Map<String, Vehicle> vh = new HashMap<String, Vehicle>();
       for(Map.Entry<String, Vehicle> e : this.vehicles.entrySet()) 
       {   
           Vehicle v = e.getValue().clone();
           vh.put(e.getKey(), v);
        }
       return vh;
   }
   
   /** 
   * Método que define um hashMap a partir de um hashMap passado como parâmetro 
   * @param    HashMap dos veículos inscritos na aplicação
   **/
   public void setVehicles(Map<String, Vehicle> vh)
   {
       this.vehicles.clear();
       for(Map.Entry<String, Vehicle> e : vh.entrySet()) 
       {   
           Vehicle v = e.getValue();
           this.vehicles.put(e.getKey(),v);
        }
   }
   
   /**
   * Método que devolve os clientes inscritos na aplicação
   * @returns   HashMap dos clientes inscritos na aplicação
   **/
   public Map<Integer,Client> getClients()
   {
       Map<Integer,Client> cl = new HashMap<Integer,Client>();
       for(Map.Entry<Integer, Client> c : this.clients.entrySet()) {cl.put(c.getKey(), c.getValue().clone());}
       return cl;
   }
   
   /**
   * Método que define um hashMap a partir de um hashMap passado como parâmetro
   * * @param    HashMap dos clientes inscritos na aplicação
   **/ 
   public void setClients(Map<Integer,Client> cl)
   {
       this.clients.clear();
       for(Map.Entry<Integer,Client> c : cl.entrySet()) {this.clients.put(c.getKey(), c.getValue().clone());}
   }
   
   /**
   * Método que devolve os clientes inscritos na aplicação
   * @returns   HashMap dos proprietários inscritos na aplicação
   **/
   public Map<Integer,Owner> getOwners()
   {
       Map<Integer,Owner> ow = new HashMap<Integer,Owner>();
       for(Map.Entry<Integer, Owner> o : this.owners.entrySet()) {ow.put(o.getKey(), o.getValue().clone());}
       return ow;
   }
   
   /**
   * Método que define um hashMap a partir de um hashMap passado como parâmetro
   * * @param    HashMap dos proprietários inscritos na aplicação
   **/
   public void setOwners(Map<Integer,Owner> ow)
   {
       this.owners.clear();
       for(Map.Entry<Integer,Owner> o : ow.entrySet()) {this.owners.put(o.getKey(), o.getValue().clone());}
   }
   
   /** 
   * Método que devolve uma representação, no formato textual, de uma instância UMCarroJa 
   **/
   public String toString(){return this.vehicles.toString()+"\n"+this.owners.toString()+"\n"+this.clients.toString()+"\n";}
   
   /** 
   * Método que cria uma cópia de uma identificação de um UMCarroJa 
   **/
   public UMCarroJa clone(){return new UMCarroJa(this); }
   
   /** 
   * Método que testa se um objeto é igual a uma determinada identificação
   * @param      Objeto a ser testado
   * @return     True se o objeto for igual à identificação, false se o objeto passado não for igual à identificação
   **/
   public boolean equals(Object o)
   {
       if(this == o) return true;
       if((o == null) || (this.getClass() != o.getClass())) return false; 
       UMCarroJa u = (UMCarroJa) o;
       return  this.vehicles.equals(u.getVehicles()) && this.clients.equals(u.getClients()) && this.owners.equals(u.getOwners());
   }
  

   /**
   * Método que valida o acesso de um utilizador na aplicação através do seu email e password
   * @param     Nif do utilizador
   * @param     Email do utilizador
   * @return    Utilizador inscrito na aplicação
   **/
   public USER validateAcess(int nif, String email) throws LoginException
   {
       boolean cl = this.clients.values().stream().anyMatch(u -> u.getEmail().equals(email) && u.getNif() == nif);
       boolean ow = this.owners.values().stream().anyMatch(u -> u.getEmail().equals(email) && u.getNif() == nif);
       if (!cl && !ow) throw new LoginException("Acesso inválido.");   
       if(cl){return this.clients.get(nif).clone();}
       else{return this.owners.get(nif).clone();}   
   }
   
      
   
   /*** CLIENTES ***/
   /**
   * Método que regista um novo cliente na aplicação
   * @param    Nome do utilizador
   * @param    Nif do utilizador
   * @param    Email do utilizador
   * @param    Morada do utilizador
   * @param    Coordenadas X e Y da localização do utilizador
   * @return   Novo utilizador registado na aplicação
   **/
   public Client registerNewClient(String name, int nif, String email, String  address, double x, double y) throws RegistrationException 
   {
       Client c = new Client(name, nif, email, address, x, y);
       
       try{addCL(c);} 
       catch(UserExistsException e){throw new RegistrationException("Registo Inválido");}
       
       return c.clone();
   } 
   
   /**
   * Método que adiciona um novo cliente na aplicação
   * @param    Cliente a adicionar 
   **/
   public void addCL(Client c) throws UserExistsException 
   {
       if(!this.clients.containsKey(c.getNif())) this.clients.put(c.getNif(), c.clone());
       else throw new UserExistsException("Cliente já existe.");    
   } 
   
   /**
   * Método que remvoe um cliente na aplicação
   * @param    Cliente a remover
   **/
   public void deleteCL(Client c){this.clients.remove(c.getNif());}
   
   /**
   * Método que retorna uma lista com os 10 clientes que mais utilizam o sistema (em vezes)
   * @return    Lista dos 10 Clientes que mais utilizam o sistema (em vezes)
   **/
   public List<Client> top10clientsX()
   {
       Set<Client> clOrder = new TreeSet<Client>(new ClientComparatorX());
       List<Client> clList = new ArrayList<Client>(); 
       
       for(Client c: this.clients.values()){clOrder.add(c.clone());}    
       Iterator<Client> co = clOrder.iterator();
       int i = 0;
       while(co.hasNext() && i<10)
       {
           clList.add(co.next());
           i++;
       }
       return clList;
   }
   
   /**
   * Método que retorna uma lista com os 10 clientes que mais utilizam o sistema (em km)
   * @return      Lista dos 10 Clientes que mais utilizam o sistema (em km)
   **/
   public List<Client> top10clientsKM()
   {
      Set<Client> clOrder = new TreeSet<Client>(new ClientComparatorKM());  
      List<Client> clList = new ArrayList<Client>(); 
       
       for(Client c: this.clients.values()){clOrder.add(c.clone());}    
       Iterator<Client> co = clOrder.iterator();
       int i = 0;
       while(co.hasNext() && i<10)
       {
           clList.add(co.next());
           i++;
       }
       return clList;
   }
   
   
   

      
    
   /*** Proprietários ***/
   /**
   * Método que devolve um proprietário que corresponde ao nif passado como parametro
   * @param       Nif do utilizador
   * @return      Utilizador registado na aplicação
   **/
   public Owner getOwnerByNif(int nif) throws UserDoesntExistException
   {
       if(!this.owners.containsKey(nif))
              throw new  UserDoesntExistException("O nif inserido não existe na nossa base de dados, por favor retifique a informação");
       else
            return this.owners.get(nif);
   }
    
   /**
   * Método que regista um novo cliente na aplicação
   * @param     Nome do utilizador
   * @param     Nif do utilizador
   * @param     Email do utilizador
   * @param     Morada do utilizador
   * @return    Novo utilizador registado na aplicação
   **/
   public void registerNewOwner(String name, int nif, String email, String  address) throws RegistrationException
   {
       Owner o = new Owner(name, nif,  email, address);
       try{addOW(o);}
       catch(UserExistsException e){throw new RegistrationException("Registo Inválido");}

   }  
   
   /**
   * Método que  adiciona um novo proprietário na aplicação
   * @param     Utilizador a adicionar
   **/
   public void addOW(Owner o) throws UserExistsException
   {
       if(!this.owners.containsKey(o.getNif())) this.owners.put(o.getNif(), o.clone());
       else throw new UserExistsException("Proprietário já existe.");    
   }
   
   /**
   * Método que remove o perfil de um proprietário da aplicação
   * @param     Utilizador a remover
   **/
   public void deleteOW(Owner o){this.owners.remove(o.getNif());}
   
   /**
   * Método que retorna uma lista com todos os veículos de um determinado proprietario
   * @param Nif do proprietário
   * @return    Lista de veículos de um determinado proprietário
   **/
   public List<Vehicle> listOfVehicles(int nif) throws UserDoesntExistException
   { 
       if(!this.owners.containsKey(nif)) 
            throw new  UserDoesntExistException("O nif inserido não existe na nossa base de dados, por favor retifique a informação");
       else
       {
           List<Vehicle> v = new ArrayList<Vehicle>();
           for(String plate : vehicles.keySet()) 
           {
                Vehicle vt = vehicles.get(plate);
                if(vt.getNif() == nif){
                    v.add(vt.clone());
                }
            }
           return v;
        }
    }
   
   /**
   * Método que permite o proprietário aceitar ou recusar um aluguer 
   * @param    Cliente que requisitou o aluguer
   * @param    Veículo a alugar
   **/
   public boolean acceptORreject(Client c, Vehicle v) throws UserDoesntExistException
   {
     int nif = v.getNif();
     Owner o = new Owner();
     if(!this.owners.containsKey(nif))
            throw new UserDoesntExistException("O nif inserido não existe na nossa base de dados, por favor retifique a informação");
     else
        return true;
   }
   
   
   
   
   
   /*** Vehicles ***/
   /**
   * Método que permite associar um veículo ao seu proprietário
   * @param    Nif do proprietário
   * @param    Veículo a adicionar
   **/
   public void  addVehicleToOwner(int nif, Vehicle v) throws VehicleExistsException, UserDoesntExistException
   {
       if(!this.owners.containsKey(nif)) 
            throw new  UserDoesntExistException("Este proprietário não existe na nossa base de dados");
       else{
           if(vehicleExists(v.getPlate())) 
                throw new VehicleExistsException("Matrícula já existente.");
           else
           {
               Owner o = this.owners.get(nif);
               String plate = v.getPlate();
               this.vehicles.put(plate, v.clone());
               o.addVehicle(v); 
           }
       }
   }
   
   
   /**
   * Método que verifica se um veículo já existe a partir da sua matrícula
   * @param     Matrícula do veiculo
   * @return    True caso o veículo exista, false caso contrário
   **/
   public boolean vehicleExists(String plate)
   {
     boolean p = false;
     if( this.vehicles.containsKey(plate) )
        return true;
     return p;
    }

   /**
   * Método que verifica o tipo de veículo que se pretende criar e que cria o veículo em questão a partir de funções auxiliares
   * @param    Tipo do veiculo
   * @param    Marca do veiculo
   * @param    Matricula do veiculo
   * @param    Nif do veiculo
   * @param    Velocidade média do veiculo
   * @param    Velocidade do veiculo
   * @param    Consumo do veiculo
   * @param    Autonomia do veiculo
   * @param    Coordenadas X e Y da localização do veiculo
   * @return   Novo veículo
   **/
   public Vehicle vType(String type, String brand, String plate, int nif, double speed, double price, double comsuption, double autonomy, double x, double y) throws InvalidVehicleException,  VehicleExistsException
   {
       Vehicle v;
       if(type.equals("Gasolina")) v = gasRegistration(type,brand, plate, nif, speed, price, comsuption, autonomy, x, y);
       else if(type.equals("Electrico")) v = electricRegistration(type,brand, plate, nif, speed, price, comsuption, autonomy, x, y);
            else if(type.equals("Hibrido")) v = hybridRegistration(type,brand, plate, nif, speed, price, comsuption, autonomy, x, y);
                 else{throw new InvalidVehicleException("Classe de veículo inválida, tente novamente.");}
       return v;
   }
  
   /**
   * Método que cria um novo carro a gasolina
   * @param    Tipo do veiculo
   * @param    Marca do veiculo
   * @param    Matricula do veiculo
   * @param    Nif do veiculo
   * @param    Velocidade média do veiculo
   * @param    Velocidade do veiculo
   * @param    Consumo do veiculo
   * @param    Autonomia do veiculo
   * @param    Coordenadas X e Y da localização do veiculo
   * @return   Novo veículo a gasolina
   **/
   public Vehicle gasRegistration(String type, String brand, String plate, int nif, double speed, double price, double comsuption, double autonomy, double x, double y) throws VehicleExistsException
   {         
       if(vehicleExists(plate))
            throw new VehicleExistsException("Matrícula já existe.");
       else
       {
           Point2D p = new Point2D(x,y);
           Gas g = new Gas(type,brand,plate,nif,speed,price,comsuption,autonomy,x, y);
           return g.clone();
       }
   }
   
   /**
   * Método que cria um novo carro a gasolina
   * @param    Tipo do veiculo
   * @param    Marca do veiculo
   * @param    Matricula do veiculo
   * @param    Nif do veiculo
   * @param    Velocidade média do veiculo
   * @param    Velocidade do veiculo
   * @param    Consumo do veiculo
   * @param    Autonomia do veiculo
   * @param    Coordenadas X e Y da localização do veiculo
   * @return   Novo veículo  eletrico
   **/
   public Vehicle electricRegistration(String type, String brand, String plate, int nif, double speed, double price, double comsuption, double autonomy, double x, double y) throws VehicleExistsException
   {         
       if(vehicleExists(plate)) 
            throw new VehicleExistsException("Matrícula já existe.");
       else
       {
          Point2D p = new Point2D(x,y);
          Electric e = new Electric(type,brand,plate,nif,speed,price,comsuption,autonomy,x, y);
          return e.clone();
       }
   }
   
   /**
   * Método que cria um novo carro a gasolina
   * @param   Tipo do veiculo
   * @param   Marca do veiculo
   * @param   Matricula do veiculo
   * @param   Nif do veiculo
   * @param   Velocidade média do veiculo
   * @param   Velocidade do veiculo
   * @param   Consumo do veiculo
   * @param   Autonomia do veiculo
   * @param   Coordenadas X e Y da localização do veiculo
   * @return  Novo veículo hibrido
   **/
   public Vehicle hybridRegistration(String type, String brand, String plate, int nif, double speed, double price, double comsuption, double autonomy, double x, double y) throws VehicleExistsException
   {         
       if(vehicleExists(plate)) 
            throw new VehicleExistsException("Matrícula já existente.");
       else
       {
           Point2D p = new Point2D(x,y);
           Hybrid h = new Hybrid(type,brand,plate,nif,speed,price,comsuption,autonomy,x, y);
           return h.clone();
       }
   }
   

   /**
   * Método que retorna o veículo mais próximo da localização de um determinado cliente
   * @param   Point 2D da localização do Cliente
   * @param   Quilómetros a percorrer
   * @return  Veículo mais proximo do cliente
   **/
   public Vehicle nearestVehicle(Point2D clLocation, double kms) throws NoVehiclesAvailableException 
   {
       Point2D vLocation;
       double dist = -1;
       Vehicle vh = new Vehicle();
       boolean f = false;
       for(String plate: vehicles.keySet()){
              if(vehicles.get(plate).getAvailability())
              {
                   vLocation = vehicles.get(plate).getLocation();
                   if(dist == -1)
                   {
                        dist = vLocation.distanceTo(clLocation);
                        vh = vehicles.get(plate);
                    }
                   else if(vLocation.distanceTo(clLocation) < dist)
                        {
                           
                           if(vehicles.get(plate).hasAutonomy(kms)){
                               dist = vLocation.distanceTo(clLocation);
                               vh = vehicles.get(plate).clone();
                               if(f == false)
                                    f = true;
                           }
                        }
              }
       }
            
       if(f == false)
            throw new NoVehiclesAvailableException("Não existem veículos disponiveis.");
       else
            return vh;
        
   }
   
   /**
   * Método que retorna um veículo especifico requisitado por um determinado cliente
   * @param   Matricula do veiculo
   * @param   Quilómetros a percorrer
   * @return  Veículo escolhido
   **/
   public Vehicle specificVehicle(String plate, double kms) throws VehicleDoesntExistException 
   {
      Vehicle v;
      try{
          v = this.getVehiclebyPlate(plate);
          if(v.hasAutonomy(kms))
                return v.clone();
          else
                throw new VehicleDoesntExistException("O Veículo que inseriu não existe na nossa base de dados.");
        }catch(VehicleDoesntExistException e) {throw new VehicleDoesntExistException("O Veículo que inseriu não existe na nossa base de dados.");}
       
   }
   
   /**
   * Método que retorna um veículo mais barato
   * @return   Veículo mais barato da aplicação
   **/
   public Vehicle cheapestVehicle(double kms) throws NoVehiclesAvailableException
   {
      Set<Vehicle> vOrder = new TreeSet<Vehicle>(new VehicleComparatorP()); 
      Vehicle v = new Vehicle();
      
      for(Vehicle c: this.vehicles.values()){vOrder.add(c.clone());} 
      if(vOrder.size() == 0) throw new NoVehiclesAvailableException("Não existem veículos disponiveis");
      else
      {   
          Iterator<Vehicle> i = vOrder.iterator();
          while(i.hasNext())
          {
              v = i.next();
              if(v.hasAutonomy(kms))
                return v;
          }
      }
      return v;
   } 
  
   /**
   * Método que retorna um veículo mais barato dentro de uma distania que o cliente está disposto a caminhar
   * @param   km que o cliente está disposto a caminhar
   * @param   Localização do cliente
   * @return  Veículo escolhido
   **/
   public Vehicle cheapestWalkVehicle(double walk, Point2D localc, double kms) throws NoVehiclesAvailableException
   {
       Set<Vehicle> near;
       near = this.vehicles.values().stream().filter(u -> u.isNear(walk, u.getLocation(), localc)).collect(Collectors.toCollection(TreeSet::new));
       Set<Vehicle> vOrder = new TreeSet<Vehicle>(new VehicleComparatorP()); 
       Vehicle v = new Vehicle();
       
       for(Vehicle c: near){vOrder.add(c.clone());}    
       if(vOrder.size() == 0) throw new NoVehiclesAvailableException("Não existem veículos disponiveis");
       else
       {
          Iterator<Vehicle> i = vOrder.iterator();
          while(i.hasNext())
          {
              v = i.next();
              if(v.hasAutonomy(kms))
                return v;
           }
       }
       return v;
   }
   
   /**
   * Método que retorna um veículo com a autonomia desejada
   * @param   Autonomia desejada
   * @return  Veículo com a autonomia desejada
   **/
   public Vehicle desiredAutonomyVehicle(double autonomy) throws NoVehiclesAvailableException
   {
       Set<Vehicle> desired;
       desired = this.vehicles.values().stream().filter(u -> u.desiredAutonomy(autonomy)).collect(Collectors.toCollection(TreeSet::new));
       Set<Vehicle> vOrder = new TreeSet<Vehicle>(new VehicleComparatorA()); 
       Vehicle v;
       for(Vehicle c: desired){vOrder.add(c.clone());}    
       if(vOrder.size() == 0) throw new NoVehiclesAvailableException("Não existem veículos disponiveis");
       else
       {
          Iterator<Vehicle> i = vOrder.iterator();
          v = i.next();
       }
       return v;
   }
   
   /**
   * Método que determina o tempo estimado de uma viagem
   * @param   Localização X e Y do ponto inicial da viagem
   * @param   Localização X e Y do destino da viagem
   * @param   Veículo alugado para a viagem
   * @return  Tempo estimado
   **/
   public double estimatedTime(double x, double y, double w, double z, Vehicle v)
   {
       Point2D client = new Point2D(x,y);
       Point2D d = new Point2D(w,z);
       double dist1 = v.getLocation().distanceTo(client); 
       double dist2 = client.distanceTo(d);
       return Math.round((dist1 + dist2) / v.getSpeed());
   } 
   
   /**
   * Método que determina o tempo real de uma viagem
   * @param   Localização X e Y do ponto inicial da viagem
   * @param   Localização X e Y do destino da viagem
   * @param   Veículo alugado para a viagem
   * @return  Tempo real
   **/
   public double realTime(double estimatedTime, Vehicle v)
   {                                       
       double calc = chanceofrain() * 0.003 + chanceoffog() * 0.001 + chanceoftraffic() * 0.0015;
       return Math.round(estimatedTime / calc);
   }
   
   /**
   * Método que determina o custo estimado de uma viagem
   * @param   Localização X e Y do ponto inicial da viagem
   * @param   Localização X e Y do destino da viagem
   * @param   Veículo alugado para a viagem
   * @return  Custo estimado
   **/
   public double estimatedPrice(double x, double y, double w, double z, Vehicle v)
   {
       Point2D client = new Point2D(x,y);
       Point2D d = new Point2D(w,z);
       double distance = client.distanceTo(d);
       double estimatedTime = estimatedTime(x, y, w, z, v);
       return Math.round(distance * v.getPrice() + estimatedTime * 0.10 );
   }
   
   /**
   * Método que determina o custo real de uma viagem
   * @param   Localização X e Y do ponto inicial da viagem
   * @param   Localização X e Y do destino da viagem
   * @param   Veículo alugado para a viagem
   * @return  Custo real
   **/
   public double realPrice(double estimatedTime, double realTime, double estimatedPrice)
   {
       double realPrice;
       if((realTime / estimatedTime) > 1.25)  realPrice = estimatedPrice;
       else realPrice = Math.round( estimatedPrice + (realTime - estimatedTime) * 0.25);
       return realPrice;
   }
   
   /**
   * Método que gera um random de 0 a 100 correspondente à probabilidade de chover
   * @return    A probabilidade de chover
   **/ 
   public double chanceofrain(){return (Math.round(Math.random() * 99)) + 1;}
   
   /**
   * Método que gera um random de 0 a 100 correspondente à probabilidade de estar nevoeiro
   * @return    A probabilidade de estar nevoeiro
   **/
   public double chanceoffog(){return (Math.round(Math.random() * 99)) + 1;}
   
   /**
   * Método que gera um random de 0 a 100 correspondente à probabilidade de estar transito
   * @return    A probabilidade de estar transito
   **/
   public double chanceoftraffic(){return (Math.round(Math.random() * 99)) + 1;}
   
   
   /**
   * Método que retorna o total faturado por um veiculo num determinado período
   * @param     Matrícula do veículo 
   * @param     Ano inicial considerado
   * @param     Mês inicial considerado
   * @param     Dia inicial considerado
   * @param     Ano final considerado
   * @param     Mês final considerado
   * @param     Dia final considerado
   * @return    O total faturado
   **/
   public double carProfit(int nif, String plate, int yi, int mi, int di, int yf, int mf, int df) throws DateException, VehicleDoesntExistException
   {
      double total = 0;
       if(yi < 0 || mi < 1 || mi > 12 || di < 1 || di > 31 || yf < 0 || mf < 1 || mf > 12 || df < 1 || df > 31 || yi > yf || 
         (yi == yf && mi > mf) || (yi == yf && mi == mf && di > df))
          throw new DateException("Formato de data e hora incorreto, por favor tente novamente com uma data e hora válidas.");
      else if(!vehicleExists(plate)) 
                throw new VehicleDoesntExistException("A matricula inserida não existe na nossa base de dados, por favor retifique a informação");
           else{ 
                  LocalDateTime i = LocalDateTime.of(yi,mi,di,00,00);
                  LocalDateTime f = LocalDateTime.of(yf,mf,df,23,59);
            
                  Vehicle v, v1;
                 
                  v1 = this.getVehiclebyPlate(plate);
                  v = v1.clone();
                  
                  Ride r;
                  Iterator<Ride> it = v.getRentingHistoryAll().iterator();
                  while(it.hasNext())
                  {
                      r = it.next();  
                      if((r.getDate().isAfter(i) || r.getDate().equals(i)) && (r.getDate().isBefore(f) || r.getDate().equals(f)))
                            total += r.getRealPrice();
                  }
                  
                  return total;
                }
   }
   
   /*** VIAGEM/ALUGUER ***/
   /**
   * Método que retorna o registo de viagens de um utilizador num determinado período
   * @param     Nif do utilizador 
   * @param     Ano inicial considerado
   * @param     Mês inicial considerado
   * @param     Dia inicial considerado
   * @param     Ano final considerado
   * @param     Mês final considerado
   * @param     Dia final considerado
   * @return    Lista de viagens efetuadas
   **/
   public List<RentedCar> rentingRegist(int nif, int yi, int mi, int di, int yf, int mf, int df) throws DateException
   {
      if(yi < 0 || mi < 1 || mi > 12 || di < 1 || di > 31 || yf < 0 || mf < 1 || mf > 12 || df < 1 || df > 31 || yi > yf || 
         (yi == yf && mi > mf) || (yi == yf && mi == mf && di > df))
          throw new DateException("Formato de data e hora incorreto, por favor tente novamente com uma data e hora válidas.");
      else{  
          LocalDateTime i = LocalDateTime.of(yi,mi,di,00,00);
          LocalDateTime f = LocalDateTime.of(yf,mf,df,23,59);
          List<RentedCar> r = new ArrayList<RentedCar>();
          
          if(this.clients.containsKey(nif))
          {
               Client c = this.clients.get(nif);
               for(RentedCar rc: c.getRentingHistoryAll())
               {
                  if((rc.getDate().isAfter(i) || rc.getDate().equals(i)) && (rc.getDate().isBefore(f) || rc.getDate().equals(f)))
                       r.add(rc.clone());
               }
          }
          else if (this.owners.containsKey(nif))
          {
              Owner o = this.owners.get(nif);
              for(RentedCar rc: o.getRentingHistoryAll()) 
              {
                  if((rc.getDate().isAfter(i) || rc.getDate().equals(i)) && (rc.getDate().isBefore(f) || rc.getDate().equals(f)))
                       r.add(rc.clone());
              }   
          }
          return r;
      }
   }
   
   /**
   * Método que regista a viagem efetuada no histórico do veiculo e do cliente 
   * @param     Cliente que efetuou o aluguer
   * @param     Ano inicial considerado
   * @param     Mês inicial considerado
   * @param     Dia inicial considerado
   * @param     Ano final considerado
   * @param     Mês final considerado
   * @param     Dia final considerado
   * @param     Coordenadas X e Y da lozalização inicial do cliente
   * @param     Coordenadas X e Y da lozalização final do cliente
   * @param     Veículo alugado
   * @param     Kms percorridos na viagem
   * @param     Tempo que a viagem demorou
   * @param     Custo real da viagem
   * @param     Custo estimado da viagem
   * @param     Autonomia do veículo
   * @param     Classificação do aluguer
   **/
   public void endRide(Client c, int yr, int m, int d, int h, int min, double x, double y, double w, double z, Vehicle v, double kms, 
                                double timeRide, double custoReal, double custoEst, double a, int classificacao) throws DateException{
       if(y < 0 || m < 1 || m > 12 || d < 1 || d > 31 || h < 0 || h > 23 || min < 0 || min > 59)
           throw new DateException("Formato de data e hora incorreto, por favor tente novamente com uma data e hora válidas.");
       else{
           LocalDateTime date = LocalDateTime.of(yr,m,d, h, min);
           
           Point2D i = new Point2D(x,y);
           Point2D f = new Point2D(w,z);
           
           int onif = v.getNif();
           Owner o = this.owners.get(onif);
           
           //Historicos atualizados
           RentedCar rc = new RentedCar(o.getEmail(), c.getEmail(), v, custoReal, f, i, kms, a, date, timeRide);
           Client c1 = clients.get(c.getNif());
           Owner o1  = owners.get(o.getNif());
           c1.addRentedCar(rc);
           o1.addRentedCar(rc);
           
           Ride r = new Ride(c.getEmail(), date, i, f, kms, timeRide, custoReal);
           Vehicle v1 = vehicles.get(v.getPlate());
           v1.addRide(r);
           
           //Caracteristicas do Carro
           if(!v1.hasAutonomy10())
                o1.refuel(v1.getPlate());
                
               v1.setAvailability(true);
               v1.setX(w);
               v1.setY(z);
               v1.setLocation(f);
               v1.setRating(classificacao);
               
           //Classificação do owner
           o1.ownerRating(classificacao);
           
           //Atualiza a posição do cliente
           c1.setX(w);
           c1.setY(z);
           c1.setLocation(f);
           
       }
   }
   
  
   /** LOAD AUX **/
    /**
   * Método que devolve um veículo que corresponde à matricula passada como parametro
   * @param     Matricula do veículo
   * @return    Veículo registado na aplicação
   **/
   public Vehicle getVehiclebyPlate(String plate) throws VehicleDoesntExistException
   {
       if(!this.vehicles.containsKey(plate))
            throw new VehicleDoesntExistException("O veículo inserido não existe na nossa base de dados, por favor retifique a informação");  
       else
        return this.vehicles.get(plate);
   }
    
   /**
   * Método que devolve um veículo que corresponde ao Nif passado como parametro
   * @param     Nif do veículo
   * @return    Veículo registado na aplicação
   **/
    public Vehicle getVehiclebyNif(int nif) throws VehicleDoesntExistException
    {
        Vehicle v = new Vehicle();
        boolean f = false;
           for(String plate : vehicles.keySet()) 
           {
                Vehicle vt = vehicles.get(plate);
                if(vt.getNif() == nif){
                    v = vt.clone();
                    f = true;
                }
            }
           if(f == false)
                   throw new VehicleDoesntExistException("O veículo inserido não existe na nossa base de dados, por favor retifique a informação");   
           else
                return v;
    }
    
   /**
   * Método que devolve o email de um cliente
   * @param     Nif do cliente a procurar
   * @return    Email do cliente
   **/
    public Client getClientbyNif(int nif) throws UserDoesntExistException
    {
       Client c;
       if(!this.clients.containsKey(nif))
              throw new  UserDoesntExistException("O veículo inserido não existe na nossa base de dados, por favor retifique a informação");
       else
            c = this.clients.get(nif).clone();
       return c;     
   }
   
   /**
   * Método que devolve a localização de um cliente
   * @param      Nif do cliente a procurar
   * @return     Localização do cliente
   **/
    public Point2D getLocationbyNif(int nif) throws UserDoesntExistException
    {
       Client c;
       Point2D p = new Point2D();
       if(!this.clients.containsKey(nif))
              throw new  UserDoesntExistException("O veículo inserido não existe na nossa base de dados, por favor retifique a informação");
       else{
            c = this.clients.get(nif);
            p = c.getLocation();
        }
       return p;     
   }
   
   
   public void setRatingLoad(Client c, int r)
   {
       Client c1 = this.clients.get(c.getNif());
       c1.setRating(r);
    }
   
    public void setRatingLoad(Vehicle v, int r)
   {
       Vehicle v1 = this.vehicles.get(v.getPlate());
       v1.setRating(r);
    }
   
   
   
   /*** STATUS ***/
   
   /** 
   * Método que guarda o estado de uma instância num ficheiro de texto
   **/
   public void writeToTxt(String fileName) throws IOException 
   {
       PrintWriter fich = new PrintWriter(fileName);
       fich.println("------- UMCJ --------");
       fich.println(this.toString());
       fich.flush();
       fich.close();
   }
   
   /** 
   * Método que guarda em ficheiro de objectos o objecto que recebe a mensagem
   **/
   public void saveStatus(String fileName) throws FileNotFoundException,IOException 
   {
       FileOutputStream fos = new FileOutputStream(fileName);
       ObjectOutputStream oos = new ObjectOutputStream(fos);
       oos.writeObject(this); //guarda-se todo o objecto de uma só vez
       oos.flush();
       oos.close();
   }
   
   /** 
   * Método que recupera uma instância de UMCarroJa de um ficheiro de objectos 
   **/
   public static UMCarroJa loadStatus(String fileName) throws FileNotFoundException,IOException, ClassNotFoundException 
   {
      FileInputStream fis = new FileInputStream(fileName);
      ObjectInputStream ois = new ObjectInputStream(fis);
      UMCarroJa umcj = (UMCarroJa) ois.readObject();
      ois.close();
      return umcj;
   }
   
   /** 
   * Corre a aplicação, gerando um menu interativo 
   **/
   public static void main()
   {
       new App().run();
   }
}
