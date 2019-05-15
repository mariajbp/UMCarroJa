import java.util.Map;
import java.util.HashMap;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.function.Supplier;
import java.util.stream.Stream;
import java.io.Serializable;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.*; //ClassNotFoundException

public class UMCarroJa implements Serializable
{
   private Map<String, Client> clients;
   private Map<String, Owner> owners;
   private Map<String, Vehicle> vehicles;
   
   //Construtor vazio que cria uma instância UMCarroJa
   public UMCarroJa()
   {
       this.clients = new HashMap<String,Client>();
       this.owners = new HashMap<String,Owner>();
       this.vehicles = new HashMap<String,Vehicle>();
   }
   
   //Construtor que cria uma nova instância UMCarroJa a partir de um UMCarroJa passado como parâmetro
   public UMCarroJa(UMCarroJa u)
   {
       this.clients = u.getClients();
       this.owners = u.getOwners();
       this.vehicles = u.getVehicles();
   }
   
   //Método que devolve os veiculos inscritos na aplicação
   public Map<String,Vehicle> getVehicles()
   {
       Map<String,Vehicle> vh = new HashMap<String,Vehicle>();
       for(Map.Entry<String, Vehicle> e : this.vehicles.entrySet()) {vh.put(e.getKey(), e.getValue().clone());}
       return vh;
   }
   
   //Método que define um hashMap a partir de um hashMap passado como parâmetro
   public void setVehicles(Map<String,Vehicle> vh)
   {
       this.vehicles.clear();
       for(Map.Entry<String,Vehicle> e : vh.entrySet()) {this.vehicles.put(e.getKey(), e.getValue().clone());}
   }
   
   //Método que devolve os clientes inscritos na aplicação
   public Map<String,Client> getClients()
   {
       Map<String,Client> cl = new HashMap<String,Client>();
       for(Map.Entry<String, Client> c : this.clients.entrySet()) {cl.put(c.getKey(), c.getValue().clone());}
       return cl;
   }
   
   //Método que define um hashMap a partir de um hashMap passado como parâmetro
   public void setClients(Map<String,Client> cl)
   {
       this.clients.clear();
       for(Map.Entry<String,Client> c : cl.entrySet()) {this.clients.put(c.getKey(), c.getValue().clone());}
   }
   
   //Método que devolve os clientes inscritos na aplicação
   public Map<String,Owner> getOwners()
   {
       Map<String,Owner> ow = new HashMap<String,Owner>();
       for(Map.Entry<String, Owner> o : this.owners.entrySet()) {ow.put(o.getKey(), o.getValue().clone());}
       return ow;
   }
   
   //Método que define um hashMap a partir de um hashMap passado como parâmetro
   public void setOwners(Map<String,Owner> ow)
   {
       this.owners.clear();
       for(Map.Entry<String,Owner> o : ow.entrySet()) {this.owners.put(o.getKey(), o.getValue().clone());}
   }
   
   //Devolve uma representação, no formato textual, de uma instância UMCarroJa 
   public String toString(){return this.vehicles.toString()+"\n"+this.owners.toString()+"\n"+this.clients.toString()+"\n";}
   
   //Método que cria uma cópia de uma instância UMCarroJa
   public UMCarroJa clone(){return new UMCarroJa(this); }
   
   //Método que testa se um objeto é igual a uma determinada UMCarroJa
   public boolean equals(Object o)
   {
       if(this == o) return true;
       if((o == null) || (this.getClass() != o.getClass())) return false; 
       UMCarroJa u = (UMCarroJa) o;
       return  this.vehicles.equals(u.getVehicles()) && this.clients.equals(u.getClients()) && this.owners.equals(u.getOwners());
   }
   
   //Método que testa se existe algum utilizador com determinado email
   public boolean emailExists(String email)
   {   
       boolean flag = false;
       if(this.clients.containsKey(email) || this.owners.containsKey(email)){flag = true;}
       return flag;
   }
   
   /*** valida acess to email  HERE **/
    //Método que valida o acesso de um utilizador na aplicação através do seu email e password
   
   public USER validateAcess(String name, String email)
   {
   }

   
      
   
   /*** CLIENTES ***/
   //Método que regista um novo cliente na aplicação
   public Client registerNewClient(String name, String pass, String email, String  address, double x, double y) throws RegistrationException
   {
       Client c = new Client(name, pass, email, address, x, y);
       addCL(c);
       return c.clone();
   }  
   //Método que adiciona um cliente à aplicação
   public void addCL(Client c) throws UserExistsException
   {
       if(!this.clients.containsKey(c.getEmail())) this.clients.put(c.getEmail(), c.clone());
       else throw new UserExistsException("Cliente já existe.");
   }
   
   //Método que retorna uma lista com os 10 clientes que mais utilizam o sistema (em vezes)
   public List<Client> top10clientsX()
   {
       
   }
   
   //Método que retorna uma lista com os 10 clientes que mais utilizam o sistema (em km)
   public List<Client> top10clientsKM()
   {
       
   }
   
   
   /*** Proprietários ***/
   //Método que regista um novo proprietário na aplicação
   public Owner registerNewOwner(String name, String pass, String email, String  address) throws RegistrationException
   {
       Owner o = new Owner(name, pass, email, address);
       addOW(o);
       return o.clone();
   }  
   //Método que adiciona um proprietario à aplicação
   public void addOW(Owner o) throws UserExistsException
   {
       if(!this.owners.containsKey(o.getEmail())) this.owners.put(o.getEmail(), o.clone());
       else throw new UserExistsException("Proprietário já existe.");
   }
   
   //Método que retorna uma lista com todos os veículos de um determinado proprietario
   public List<Vehicle> listOfVehicles(String email) throws UserDoesntExistException
   { 
       if(!this.owners.containsKey(email)) throw new  UserDoesntExistException("O email inserido não existe na nossa base de dados, por favor retifique a informação");
  
       List<Vehicle> v = new ArrayList<Vehicle>();
       Owner o = this.owners.get(email);
       /*
       for(Vehicle v: o.getVehicles().values()) //I AM CONFUSED
       {
           vh.add(v);
       }
       
       return vh; */
   }
   
   
   /*** Vehicles ***/
   
   //Método que verifica se um veículo já existe a partir da sua matrícula
   public boolean vehicleExists(String plate)
   {
      
   }
   
   //Método que verifica o tipo de veículo que se pretende criar e que cria o veículo em questão a partir de funções auxiliares
   public Vehicle vType(String type, String brand, String plate, int nif, double speed, double price, double comsuption, double autonomy, double x, double y) throws InvalidVehicleException
   {
       Vehicle v;
       
       if(type.equals("Gasolina")) v = gasRegistration(type,brand, plate, nif, speed, price, comsuption, autonomy, x, y);
       else if(type.equals("Eletrico")) v = electricRegistration(type,brand, plate, nif, speed, price, comsuption, autonomy, x, y);
            else if(type.equals("Monovolume")) v = hybridRegistration(type,brand, plate, nif, speed, price, comsuption, autonomy, x, y);
                 else throw new InvalidVehicleException("Classe de veículo inválida, tente novamente.");
       
       return v;
   }
   
   //Método que cria um novo carro a gasolina
   public Vehicle gasRegistration(String type, String brand, String plate, int nif, double speed, double price, double comsuption, double autonomy, double x, double y) throws VehicleExistsException
   {         
       if(vehicleExists(plate)) throw new VehicleExistsException("Matrícula já existente.");
       
       Point2D p = new Point2D(x,y);
       Gas g = new Gas(type,brand,plate,nif,speed,price,comsuption,autonomy,x, y);
       
       return g.clone();
   }
   
   //Método que cria um novo carro eletrico
   public Vehicle electricRegistration(String type, String brand, String plate, int nif, double speed, double price, double comsuption, double autonomy, double x, double y) throws VehicleExistsException
   {         
       if(vehicleExists(plate)) throw new VehicleExistsException("Matrícula já existente.");
       
       Point2D p = new Point2D(x,y);
       Electric e = new Electric(type,brand,plate,nif,speed,price,comsuption,autonomy,x, y);
       
       return e.clone();
   }
   
   //Método que cria um novo carro hibrido
   public Vehicle hybridRegistration(String type, String brand, String plate, int nif, double speed, double price, double comsuption, double autonomy, double x, double y) throws VehicleExistsException
   {         
       if(vehicleExists(plate)) throw new VehicleExistsException("Matrícula já existente.");
       
       Point2D p = new Point2D(x,y);
       Hybrid h = new Hybrid(type,brand,plate,nif,speed,price,comsuption,autonomy,x, y);
       
       return h.clone();
   }
   
   //Método que retorna o veículo mais próximo da localização de um determinado cliente
   public Vehicle nearestVehicle(double x, double y) throws NoVehiclesAvailableException
   {
       
   }
   
   //Método que retorna o veículo de uma empresa de táxis requisitado por um determinado cliente
   public Vehicle specificVehicle(String plate) throws VehicleDoesntExistException 
   {
      
   }
   
   //Método que determina o tempo estimado de uma viagem
   public double estimatedTime(double x, double y, double w, double z, Vehicle v)
   {
       Point2D client = new Point2D(x,y);
       Point2D d = new Point2D(w,z);
       double dist1 = v.getLocation().distanceTo(client); //implementar esta cena
       double dist2 = client.distanceTo(d);
       return Math.round((dist1 + dist2) / v.getSpeed());
   }
   
   //Método que determina o tempo real de uma viagem
   public double realTime(double estimatedTime, Vehicle v)
   {                                       
       double calc = chanceofrain() * 0.003 + chanceoffog() * 0.001 + chanceoftraffic() * 0.0015;
       return Math.round(estimatedTime / calc);
   }
   
   //Método que determina o custo estimado de uma viagem
   public double estimatedPrice(double x, double y, double w, double z, Vehicle v)
   {
       Point2D client = new Point2D(x,y);
       Point2D d = new Point2D(w,z);
       double distance = client.distanceTo(d);
       double estimatedTime = estimatedTime(x, y, w, z, v);
       return Math.round(distance * v.getPrice() + estimatedTime * 0.10 );
   }
   
   //Método que determina o custo real de uma viagem
   public double realPrice(double estimatedTime, double realTime, double estimatedPrice)
   {
       double realPrice;
       if((realTime / estimatedTime) > 1.25)  realPrice = estimatedPrice;
       else realPrice = Math.round( estimatedPrice + (realTime - estimatedTime) * 0.25);
       return realPrice;
   }
   
   public double chanceofrain(){return Math.round(Math.random() * 100);}
   public double chanceoffog(){return Math.round(Math.random() * 100);}
   public double chanceoftraffic(){return Math.round(Math.random() * 100);}
   
   //Método que retorna o total faturado por uma empresa de táxis num determinado período
   public double totalProffit(String plate, int yi, int mi, int di, int yf, int mf, int df) throws DateException, VehicleDoesntExistException
   {
      if(yi < 0 || mi < 1 || mi > 12 || di < 1 || di > 31 || yf < 0 || mf < 1 || mf > 12 || df < 1 || df > 31 || yi > yf || 
         (yi == yf && mi > mf) || (yi == yf && mi == mf && di > df))
          throw new DateException("Formato de data e hora incorreto, por favor tente novamente com uma data e hora válidas.");
        
      if(!this.vehicles.containsKey(plate)) throw new VehicleDoesntExistException("A matricula inserida não existe na nossa base de dados, por favor retifique a informação");
       
      LocalDateTime i = LocalDateTime.of(yi,mi,di,00,00);
      LocalDateTime f = LocalDateTime.of(yf,mf,df,23,59);

      Vehicle v = this.vehicles.get(plate);
      double total = 0;
        
      /** A LOT IS MISSING HERE **/
       
      return total;
   }
   
   /*** VIAGEM/ALUGUER ***/
   
   //Método que regista a viagem efetuada no histórico do veiculo e do cliente 
   public void endRide(Client c, int yr, int m, int d, int h, int min, double x, double y, double w, double z, Vehicle v, double kms, 
                                double timeRide, double custoReal, double custoEst, int classificacao) throws DateException{
       if(y < 0 || m < 1 || m > 12 || d < 1 || d > 31 || h < 0 || h > 23 || min < 0 || min > 59)
           throw new DateException("Formato de data e hora incorreto, por favor tente novamente com uma data e hora válidas.");

       LocalDate date = LocalDate.of(yr,m,d);
       LocalTime time = LocalTime.of(h,min);
       
       Point2D i = new Point2D(x,y);
       Point2D f = new Point2D(w,z);
       
       /**COMPLETE***/
   }
   
   /**Método que retorna o registo de viagens de um utilizador num determinado período
   public List<?> rideRegist(String Email, int yI, int mI, int dI, int yF, int mF, int dF) throws DateException
   {
       
   } **/
   
   
   /*** STATUS ***/
   
   //Método que guarda o estado de uma instância num ficheiro de texto.
   public void escreveEmFicheiroTxt(String fileName) throws IOException 
   {
       PrintWriter fich = new PrintWriter(fileName);
       fich.println("------- UMCJ --------");
       fich.println(this.toString());
       fich.flush();
       fich.close();
   }
   //Método que guarda em ficheiro de objectos o objecto que recebe a mensagem.
   public void guardaEstado(String fileName) throws FileNotFoundException,IOException 
   {
       FileOutputStream fos = new FileOutputStream(fileName);
       ObjectOutputStream oos = new ObjectOutputStream(fos);
       oos.writeObject(this); //guarda-se todo o objecto de uma só vez
       oos.flush();
       oos.close();
   }
    // Método que recupera uma instância de UMCarroJa de um ficheiro de objectos.
   public static UMCarroJa loadStatus(String fileName) throws FileNotFoundException,IOException, ClassNotFoundException 
   {
      FileInputStream fis = new FileInputStream(fileName);
      ObjectInputStream ois = new ObjectInputStream(fis);
      UMCarroJa umcj = (UMCarroJa) ois.readObject();
      ois.close();
      return umcj;
   }
   
   //Corre a aplicação, gerando um menu interativo
   public static void main()
   {
       new App().run();
   }
}
