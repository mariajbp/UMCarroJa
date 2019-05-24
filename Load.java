import java.util.TreeSet; 
import java.io.Serializable;
import java.io.*; 
import java.io.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Iterator;
import java.io.IOException;
import static java.lang.System.out;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;

public class Load
{
    private File file;
    private BufferedReader br;
    private UMCarroJa umcj;
     
    public Load(String fileName) throws IOException  
    {
        readFile("../logs");
    }
    
    /** 
    *  Método que carrega a informação do ficheiro 
    **/
    private void readFile(String fileName) throws IOException 
    {
      try 
      {
           br = new BufferedReader(new FileReader(fileName));
           String line = null;
           while ((line = br.readLine()) != null) 
           {
              registerData(line); 
           }
      }catch (IOException e) {e.printStackTrace();} finally {br.close();} 
    }
   
    /** 
    *  Método que parse dos dados do ficheiros
    **/
    public void registerData(String c)
    {
       String[] fst = c.split(":");
       String id = fst[0];
       String[] snd = fst[1].split(",");
       switch(id)
       {
           case "NovoProp": umcj.registerNewOwner(fst[0], Integer.parseInt(fst[1]), fst[2],fst[3]);
                            break;
                           
           case "NovoCliente": umcj.registerNewClient(fst[0], Integer.parseInt(fst[1]), fst[2],fst[3], Integer.parseInt(fst[4]), Integer.parseInt(fst[5]));
                               break;
                              
           case "NovoCarro": Vehicle v = umcj.vType(fst[0],fst[1],fst[2],Integer.parseInt(fst[3]),Double.parseDouble(fst[4]),Double.parseDouble(fst[5]),Double.parseDouble(fst[6]),Double.parseDouble(fst[7]),Double.parseDouble(fst[8]),Double.parseDouble(fst[9]));
                             umcj.addVehicleToOwner(Integer.parseInt(fst[3]),v);
                             break;
                             
           case "Aluguer": double w = Double.parseDouble(fst[1]);
                           double z = Double.parseDouble(fst[2]);
                           Point2D pf = new Point2D(w,z);
                           Point2D p = umcj.getLocationbyNif(fst[0]);
                           if((fst[3]) == "MaisPerto")
                           {
                              Vehicle vp = umcj.nearestVehicle(p);
                              Client c = umcj.getClientbyNif(fst[0]);
                              LocalDateTime date = LocalDateTime.now();
                              
                              double x = getLocationX(p);
                              double y = getLocationY(p);
                              double km = p.distanceTo(pf);
                              double estimatedTime = umcj.estimatedTime(x,y,w,z,vp); 
                              double time = umcj.realTime(estimatedTime, vp);
                              double estimatedPrice = umcj.estimatedPrice(x,y,w,z,vp); 
                              double price = umcj.realPrice(estimatedTime,time, estimatedTime);
                              umcj.endRide(c,date.getYear(),date.getMonthValue(),date.getDayOfMonth(),date.getHour(),date.getMinute(),
                                      x,y,w,z,vp,km,time,price,estimatedPrice,vp.getAutonomy(),vp.getRating());
                           }
                           else if((fst[3]) == "MaisBarato")
                                {
                                   Vehicle vb = umcj.nearestVehicle(p);
                                   Client c = umcj.getClientbyNif(fst[0]);
                                   LocalDateTime date = LocalDateTime.now();
                                   
                                   double x = getLocationX(p);
                                   double y = getLocationY(p);
                                   double km = p.distanceTo(pf);
                                   double estimatedTime = umcj.estimatedTime(x,y,w,z,vb); 
                                   double time = umcj.realTime(estimatedTime, vb);
                                   double estimatedPrice = umcj.estimatedPrice(x,y,w,z,vb); 
                                   double price = umcj.realPrice(estimatedTime,time, estimatedTime);
                                   umcj.endRide(c,date.getYear(),date.getMonthValue(),date.getDayOfMonth(),date.getHour(),date.getMinute(),
                                      x,y,w,z,vb,km,time,price,estimatedPrice,vb.getAutonomy(),vb.getRating());
                                }
           
                           
           //253870302,32.034317,-4.158081,Gasolina,MaisPerto
           
           case "Classificar": if(fst[0].contains ("-")) //se é matricula
                               {
                                  Vehicle v = umcj.getVehiclebyPlate(fst[0]);
                                  v.setRating(Integer.parseInt(fst[1]));
                               }
                               else //nif
                               {
                                  Vehicle v = umcj.getVehiclebyNif(fst[0]);
                                  v.setRating(Integer.parseInt(fst[1])); 
                               }
       }      
    }
    
   /**
   * Método que devolve um veículo que corresponde à matricula passada como parametro
   * @param Matricula do veículo
   * @return Veículo registado na aplicação
   **/
   public Vehicle getVehiclebyPlate(String plate) throws VehicleDoesntExistException
   {
       if(!this.vehicles.containsKey(plate))
              throw new  VehicleDoesntExistException("O veículo inserido não existe na nossa base de dados, por favor retifique a informação");
       else
            return this.vehicles.get(plate);
   }
    
   /**
   * Método que devolve um veículo que corresponde ao Nif passado como parametro
   * @param Nif do veículo
   * @return Veículo registado na aplicação
   **/
    public Vehicle getVehiclebyNif(int nif) throws VehicleDoesntExistException
    {
       if(!this.vehicles.containsKey(nif))
              throw new  VehicleDoesntExistException("O veículo inserido não existe na nossa base de dados, por favor retifique a informação");
       else
            return this.vehicles.get(nif);
    }
    
   /**
   * Método que devolve o email de um cliente
   * @param Nif do cliente a procurar
   * @return Email do cliente
   **/
    public Client getClientbyNif(int nif) throws UserDoesntExistException
    {
       Client c;
       if(!this.clients.containsKey(nif))
              throw new  UserDoesntExistException("O veículo inserido não existe na nossa base de dados, por favor retifique a informação");
       else
            c = this.clients.get(nif);
       return c;     
   }
   
   /**
   * Método que devolve o email de um cliente
   * @param Nif do cliente a procurar
   * @return Email do cliente
   **/
    public Point2D getLocationbyNif(int nif) throws UserDoesntExistException
    {
       Client c;
       Point2D p = new Point2D();
       if(!this.clients.containsKey(nif))
              throw new  UserDoesntExistException("O veículo inserido não existe na nossa base de dados, por favor retifique a informação");
       else
            c = this.clients.get(nif);
           p = c.getLocation();
       return p;     
   }
    
   /**
   * Método que devolve a coordenada X de um ponto
   * @param Ponto no espaço 
   * @return Coordenada X
   **/
    public double getLocationX(Point2D p) throws UserDoesntExistException
    {  
       return p.getX();
    }
    
   /**
   * Método que devolve a coordenada Y de um ponto
   * @param Ponto no espaço 
   * @return Coordenada Y
   **/
    public double getLocationY(Point2D p) throws UserDoesntExistException
    { 
       return p.getY();
    }
}  
