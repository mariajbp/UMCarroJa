import java.io.*; 
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.io.IOException;
import java.io.FileNotFoundException;

import static java.lang.System.out;

/**
* 
**/

public class App  implements Serializable
{
   private static Menu menu;
   private UMCarroJa umcj; //var que contém todos os dados e métodos da app
   
   //Construtor vazio que cria uma instância App e insere as opções do menu principal
   public App()
   {
       try
       {
           umcj = new UMCarroJa();
           umcj = umcj.loadStatus("DataBase");
       }
       catch(FileNotFoundException e){out.println(e.getMessage());}
       catch(IOException e){out.println(e.getMessage());}
       catch(ClassNotFoundException e){out.println(e.getMessage());}

       String[] s = {"Registar Cliente", "Registar Proprietário", "Login"};
       menu = new Menu(s);
   }
   
   //Método que inicia a aplicação no menu principal
   public void run()
   {
       int op = 0;
       do{
           menu.exec();
           op = menu.getOption();
           
           switch(op)
           {
               case 1: addClient();
                       break;
               case 2: addOwner();
                       break;
               case 3: login();
                       break;     
           }
       }
       while(op != 0);
       
       try
       {
           umcj.escreveEmFicheiroTxt("DataBase");
           umcj.guardaEstado("DataBase");
       }
       catch(FileNotFoundException e){out.println(e.getMessage());}
       catch(IOException e){out.println(e.getMessage());}
   }
   
   
   //Método que realiza o login de um utilizador na aplicação, requisitando a inserção do seu email e password
   public void login()
   {
       Scanner input = new Scanner(System.in);
       String email, password;
       try
       {
           out.println("Email: ");
           email = input.nextLine();
           out.println("Password: ");
           password = input.nextLine();
       
           USER u = umcj.validateAcess(email, password);
       
           if(u instanceof Client) clientArea((Client) u);
           else if(u instanceof Owner) ownerArea((Owner) u);
       }
       catch (LoginException e){out.println(e.getMessage());}
       input.close();
   }
   
   /*** CLIENTES ***/
   //Método que adiciona um cliente à aplicação, requisitando a inserção dos seus dados
   public void addClient()
   {
       Scanner input = new Scanner(System.in);
       String name, password, email, confirmPassword, address;
       double x, y;
       
       try
       {
           out.println("Nome: ");
           name = input.nextLine();
           out.println("Email: ");
           email = input.nextLine();
           do
           {
               out.println("Password: ");
               password = input.nextLine();
               out.println("Confirmar Password: ");
               confirmPassword = input.nextLine();   
               if(!password.equals(confirmPassword)) out.println("Password incorreta.");
           }
           while(!password.equals(confirmPassword));
       
           out.println("Morada: ");
           address = input.nextLine();
           out.println("Coordenada x onde o veículo se encontra: ");
           x = input.nextDouble();
           out.println("Coordenada y onde o veículo se encontra: ");
           y = input.nextDouble();

           Client c = (Client) umcj.registerNewClient(name, email, password, address, x, y); 
           clientArea(c);
       }catch (RegistrationException e){out.println(e.getMessage());}
       
       input.close();
   }
   
   //Menu da área pessoal de um cliente, com as opções que este pode efetuar na aplicação
   public void clientArea(Client c)
   {
       String s[] = {"Alugar um veículo", "Histórico de Alugueres"};
       Menu m = new Menu(s);
       int op = 0;
       do
       {
           m.exec();
           op = m.getOption();
           switch(op){
               case 1: rentVehicle(c); 
                       break;
               case 2: rentingHistory(c);
                       break;
           }
       }
       while(op != 0);
   }
   
   //Método que disponibiliza a um utilizador o seu histórico de viagens no período de tempo considerado
   public void rentingHistory(Client  c)
   {
       Scanner input = new Scanner(System.in);
       int di, mi, yi, yf, mf, df;
       
       out.println("Data de início [aaaa mm dd] ");
       yi = input.nextInt();
       mi = input.nextInt();
       di = input.nextInt();
       
       out.println("Data final [aaaa mm dd] ");
       yf = input.nextInt();
       mf = input.nextInt();
       df = input.nextInt();
       
       try
       {
           List<RentedCar> h = umcj.rentingResgist(c.getEmail(), yi, mi, di, yf, mf, df);
           out.println("Durante o período submetido efetuou as seguintes viagens:\n "+ h.toString());
       }catch (DateException e){out.println(e.getMessage());}
        
       input.close();
   } 
   
   public void newRent(Client c)
   {
       String[] s = {"Escolher o veículo mais próximo", "Escolher um veículo específico"};
       Menu m = new Menu(s);
       int opt = 0;
       do
       {
           m.exec();
           opt = m.getOption();
           switch(opt)
           {
               case 1: nearestVehicle(c);
                       break;
               case 2: specificVehicle(c);
                       break;
           }
       }
       while(opt != 0);
   }
   
   //Método que retorna uma lista com os 10 clientes que mais utilizam o sistema (em vezes)
   public void top10clientsx()
   {
       List<Client> cl = umcj.top10clientsX();
       out.println("De momento estes são os 10 clientes que mais usaram a aplicação:");
       for(Client c : cl){out.println(c.getName());}
   }
   
   //Método que retorna uma lista com os 10 clientes que mais utilizam o sistema (em km)
   public void top10clientskm()
   {
       List<Client> cl = umcj.top10clientsKM();
       out.println("De momento estes são os 10 clientes que viajaram mais km através da aplicação:");
       for(Client c : cl){out.println(c.getName());}
   }
   
   /*** PROPRIETARIOS ***/
   
    //Método que adiciona um proprietario à aplicação, requisitando a inserção dos seus dados e dos dados do seu veículo
   public void addOwner()
   {
       
   }
   
   public void ownerArea(Owner o)
   {
       String s[] = {"coisas"};
       Menu m = new Menu(s);
       int op = 0;
       do
       {
           m.exec();
           op = m.getOption();
           switch(op)
           {
               //case 1: ;
             
           }
       }
       while(op != 0);
   }
   
   /** VEICULOS **/
   
   //Método que adiciona um veículo requisitando a inserção dos dados do veículo
   public void adicionaVeiculo()
   {
       Scanner input = new Scanner(System.in);
       int nif;
       boolean disponibilidade;
       String email, brand, type, plate;
       double speed, price, comsuption, autonomy, x, y;
       
       try
       {
           out.println("Digite o email do proprietário no qual pretende registar o veículo: ");
           email = input.nextLine();
           out.println("Que tipo de veículo pretende registar? ");
           type = input.nextLine();
           out.println("Marca:");
           brand = input.nextLine();
           out.println("Matricula: [xx-xx-xx]");
           plate = input.nextLine();
           out.println("NIF:");
           nif = input.nextInt();
           out.println("Velocidade média do veículo: ");
           speed = input.nextDouble();
           out.println("Preço base por km: ");
           price = input.nextDouble();
           out.println("Consumo base por km: ");
           comsuption = input.nextDouble();
           out.println("Autonomia: ");
           autonomy = input.nextDouble();
           out.println("Coordenada x onde o veículo se encontra: ");
           x = input.nextDouble();
           out.println("Coordenada y onde o veículo se encontra: ");
           y = input.nextDouble();
           
           /**
           Vehicle v = umcj.vehicleType();
           umcj.addVehicleToOwner(email,v); **/
       }
       catch (VehicleDoesntExistException e){out.println(e.getMessage());}
       catch (InvalidVehicleException e){out.println(e.getMessage()); }
       catch (VehicleExistsException e){out.println(e.getMessage());}
       
       input.close();
   }
   
   
   // Método que seleciona o veículo mais próximo da localização do cliente para a realização de uma viagem
   public void rentNearestVehicle(Client c)
   {}
   
   //Método que seleciona o veículo específico requisitado pelo cliente para a realização de um aluguer
   public void rentSpecificVehicle(Client c)
   {
       Scanner input = new Scanner(System.in);
       String plate;
       
       out.println("Digite a matrícula do veículo que deseja. [xx-xx-xx]");
       plate = input.nextLine();
       
       try
       {
           Vehicle v = umcj.specificVehicle(plate); 
           //VEIUCOLO DISPONIVEL? AUTONOMIA?
           ride(c,v);
       }
       catch (VehicleDoesntExistException e){System.out.println(e.getMessage());}
       
       input.close();
   }
   
   //Método que fornece o total faturado por um carro num determinado período 
   public void totalProffitV()
   {
       Scanner input = new Scanner(System.in);
       String plate;
       int yi, mi, di, yf, mf, df;
       
       out.println("Data inicial [aaaa mm dd]");
       yi = input.nextInt();
       mi = input.nextInt();
       di = input.nextInt();
       out.println("Data final [aaaa mm dd]");
       yf = input.nextInt();
       mf = input.nextInt();
       df = input.nextInt();
       
       try
       {
           out.println("Digite a matricula do veiculo que pretende consultar:");
           plate = input.nextLine();
           
           double total = umcj.totalProffit(plate, yi, mi, di, yf, mf, df);
           
           out.println("No período submetido o veiculo "+ plate +" faturou " +total+ " euros");
       }
       catch ( VehicleDoesntExistException e){out.println(e.getMessage());}
       catch (DateException e){out.println(e.getMessage());}
       input.close();
   }
   
   
   /*** Método que efetua uma viagem/aluguer requisitada pelo cliente ***/
   public void ride(Client c, Vehicle v)
   {
       Scanner input = new Scanner(System.in);
       double x, y, w, z, estimatedTime, realTime, realPrice, estimatedPrice;
       int d, m, yr, h, min, rating;
       
       out.println("Data de quando deseja efetuar a viagem.[aaaa mm dd]");
       yr = input.nextInt();
       m = input.nextInt();
       d = input.nextInt();
       
       out.println("Hora de quando deseja efetuar a viagem.[hh mm]");
       h = input.nextInt();
       min = input.nextInt();
       
       out.println("Digite a coordenada x onde se encontra,");
       x = input.nextDouble();
       out.println("Digite a coordenada y onde se encontra,");
       y = input.nextDouble();
       Point2D i = new Point2D(x,y);
       
       out.println("Digite a coordenada x do seu destino,");
       w = input.nextDouble();
       out.println("Digite a coordenada y do seu destino,");
       z = input.nextDouble();
       Point2D f = new Point2D(w,z);
       
       double kms = Math.round(i.distanceTo(f));
       
       estimatedTime = umcj.estimatedTime(x,y,w,z,v);
       out.println("O tempo estimado de chegada ao destino pretendido é "+ estimatedTime +" minutos.");
       
       estimatedPrice = umcj.estimatedPrice(x,y,w,z,v);
       out.println("O custo estimado da viagem é "+ estimatedPrice +" euros.");
       
       /**umcj.FAZER A VIAGEM;
       out.println("O seu pedido foi efetuado, esperamos que tenha uma viagem agradável.");
       **/
       realTime = umcj.realTime(estimatedTime, v);
       
       realPrice = umcj.realPrice(estimatedTime, realTime, estimatedTime);
      
       out.println("Classifique o aluguer numa escala de 0 a 100.");
       rating = input.nextInt();
       
       try
       {
           umcj.endRide(c, yr, m, d, h, min, x, y, w, z, v, kms, realTime, realPrice, estimatedPrice, rating);
           out.println("Viagem finalizada, Obrigado por utilizar o nosso serviço.");
       }
       catch (DateException e){out.println(e.getMessage());}
       
       input.close();
   }
}