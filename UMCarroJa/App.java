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
   private Load l;
   
   /** 
   * Construtor vazio que cria uma instância App e insere as opções do menu principal 
   **/
   public App()
   {
       try
       {
           umcj = new UMCarroJa();
           //umcj = umcj.loadStatus("DataBase");}
           l = new Load(umcj, "logs.bak"); 
       }
       catch(FileNotFoundException e){out.println(e.getMessage());}
       catch(IOException e){out.println(e.getMessage());}
       //catch(ClassNotFoundException e){out.println(e.getMessage());}

       String[] s = {"Registar Cliente", "Registar Proprietário", "Login"};
       menu = new Menu(s);
   }
   
   /** 
   * Método que inicia a aplicação no menu principal 
   **/
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
           umcj.writeToTxt("DataBase");
           umcj.saveStatus("DataBase");
       }
       catch(FileNotFoundException e){out.println(e.getMessage());}
       catch(IOException e){out.println(e.getMessage());}
   }
   
   
   /** 
   * Método que realiza o login de um utilizador na aplicação, requisitando a inserção do seu email e password 
   **/ 
   public void login()
   {
       Scanner input = new Scanner(System.in);
       String email;
       int nif;
       try
       {
           out.println("Email: ");
           email = input.nextLine();
           out.println("Password: ");
           nif = input.nextInt();
       
           USER u = umcj.validateAcess(nif, email);
           if(u instanceof Client) clientArea((Client) u);
           else if(u instanceof Owner) ownerArea((Owner) u);
       }
       catch (LoginException e){out.println(e.getMessage());}    
       input.close();
   }
   
  
   
   
   
   
   
   /*** CLIENTES ***/
   /**
   * Método que adiciona um cliente à aplicação, requisitando a inserção dos seus dados 
   **/
   public void addClient()
   {
       Scanner input = new Scanner(System.in);
       String name, email, address;
       double x, y;
       int nif, confirmNif;
       
       try
       {
           out.println("Nome: ");
           name = input.nextLine();
           out.println("Email: ");
           email = input.nextLine();
           do
           {
               out.println("NIF: ");
               nif = input.nextInt();
               out.println("Confirmar NIF: ");
               confirmNif = input.nextInt();   
               if(nif != confirmNif) out.println("NIF incorreto.");
           }
           while(nif != confirmNif);
           input.nextLine();
           
           out.println("Morada: ");
           address = input.nextLine();
           out.println("Coordenada x onde se encontra: ");
           x = input.nextDouble();
           out.println("Coordenada y onde se encontra: ");
           y = input.nextDouble();

           Client c = umcj.registerNewClient(name, nif, email, address, x, y); 
           clientArea(c);
       }catch (RegistrationException e){out.println(e.getMessage());}
       
       input.close();
   }
   
   /** 
   * Menu da área pessoal de um cliente, com as opções que este pode efetuar na aplicação 
   * @param Cliente com sessão iniciada
   **/
   public void clientArea(Client c)
   {
       String s[] = {"Alugar um veículo", "Histórico de Alugueres","Top 10 Clientes -> km ",
                     "Top 10 Clientes -> Uso", "Eliminar Perfil"};
       Menu m = new Menu(s);
       int op = 0;
       do
       {
           m.exec();
           op = m.getOption();
           switch(op){
               case 1: newRent(c);  //sub-menu para realizar um aluguer
                       break;
               case 2: rentingHistory(c.getNif());
                       break;
               case 3: top10clientskm();
                       break;
               case 4: top10clientsx();
                       break;
               case 5: if(deleteClientProfile(c) == 1)
                             op = 0;
           }
       }
       while(op != 0);
   }
   
   /**
   * Método que elimina o perfil de um determinado utilizador da aplicação 
   * @param    Cliente com sessão iniciada
   * @return   Retorna 1 para permitir voltar ao menu principal, caso o perfil não tenha sido possível eliminar o perfil do utilizador retorna 0
   **/
   public int deleteClientProfile(Client c)
   {
       Scanner input = new Scanner(System.in);
       String aux;
       int nif;
       out.println("Tem a certeza que deseja eliminar o seu perfil permanentemente? [sim/nao] ");
       aux = input.nextLine();
       if(aux.equals("sim"))
       {
           out.println("NIF: ");
           nif = input.nextInt();
           if(nif == c.getNif())
           {
               out.println("Perfil eliminado.");
               input.close();
               return 1;
           }
           else
           {
               out.println("NIF incorreto.");
               input.close();
               return 0;
           }
       }
       input.close();
       return 0;
   }
   
   /** 
   * Método que calcula a localização de um utilizador
   * @returns Localização do utilizador
   **/
   public Point2D askDistance()
   {
       Scanner input = new Scanner(System.in);
       out.println("Digite a coordenada x do seu destino:");
       double w = input.nextDouble();
       out.println("Digite a coordenada y do seu destino:");
       double z = input.nextDouble();
       Point2D f = new Point2D(w,z);
       input.close();
       return f;
    }
    
   /**
   * Método que efetua uma viagem/aluguer requisitada pelo cliente 
   **/
   public void rentRequest(Client c, Vehicle v, Point2D f)
   {
       Scanner input = new Scanner(System.in);
       double x, y, w, z, estimatedTime, realTime, realPrice, estimatedPrice;
       int d, m, yr, h, min, rating;
       
       out.println("Data de quando deseja alugar a viatura. [aaaa mm dd]");
       yr = input.nextInt();
       m = input.nextInt();
       d = input.nextInt();
       
       out.println("Hora de quando deseja alugar a viatura. [hh mm]");
       h = input.nextInt();
       min = input.nextInt();
       
       //Localização do Cliente
       out.println("Digite a coordenada x de onde se encontra: ");
       x = input.nextDouble();
       out.println("Digite a coordenada y de onde se encontra: ");
       y = input.nextDouble();
       Point2D i = c.getLocation();
 
       w = f.getX();
       z = f.getY();
       
       double kms = Math.round(i.distanceTo(f));
    
       estimatedPrice = umcj.estimatedPrice(x,y,w,z,v);
       out.println("\nO custo estimado da viagem é "+ estimatedPrice +" euros.");
           
       estimatedTime = umcj.estimatedTime(x,y,w,z,v);
       out.println("O tempo estimado de chegada ao destino pretendido é "+ estimatedTime +" minutos.");
       boolean a = false;
    
       try
       {
           a = umcj.acceptORreject(c, v);
               if(a == true)
           {
                   out.println("\nO seu pedido foi efetuado, esperamos que tenha uma viagem agradável.");
                   realTime = umcj.realTime(estimatedTime, v);
                   
                   realPrice = umcj.realPrice(estimatedTime, realTime, estimatedTime);
                  
                   out.println("\nClassifique o aluguer numa escala de 0 a 100.");
                   rating = input.nextInt();
                   
                   try
                   {
                       umcj.endRide(c, yr, m, d, h, min, x, y, w, z, v, kms, realTime, realPrice, estimatedPrice, v.getAutonomy(), rating);
                       out.println("\nViagem finalizada, Obrigado por utilizar o nosso serviço.");
                   }
                   catch (DateException e){out.println(e.getMessage());}
                   
                   input.close();
           }
           else
           {
                    out.println("O Proprietário não autorizou o seu pedido.");
                    input.close();
           }
        }
       catch(UserDoesntExistException e){out.println(e.getMessage());}
       input.close();
    }
   
   /** 
   * Método que disponibiliza a um utilizador o seu histórico de viagens no período de tempo considerado 
   **/
   public void rentingHistory(int nif)
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
           List<RentedCar> h = umcj.rentingRegist(nif, yi, mi, di, yf, mf, df);
           out.println("Durante o período submetido efetuou as seguintes viagens: \n "+ h.toString());
       }catch (DateException e){out.println(e.getMessage());}
        
       input.close();
   } 
   
   /** SUB-MENU **/
   /** 
   * Sub-menu da área pessoal de um cliente, que contém as opções para um aluguer
   * @param Cliente com sessão iniciada
   **/
   public void newRent(Client c)
   {
       String[] s = {"Escolher o veículo mais próximo", "Escolher um veículo específico", "Escolher o veículo mais barato", 
                     "Escolher o veículo mais barato + caminhada", "Escolher um veículo com a autonomia desejada"};
       Menu m = new Menu(s);
       int opt = 0;
       do
       {
           m.exec();
           opt = m.getOption();
           switch(opt)
           {
               case 1: rentNearestVehicle(c);
                       break;
               case 2: rentSpecificVehicle(c);
                       break;
               case 3: rentCheapestVehicle(c);
                       break;
               case 4: rentCheapWalk(c);
                       break;
               case 5: rentDesiredAutonomy(c);
                       break; 
                      
           }
       }
       while(opt != 0);
   }
   
   /**
   * Método que seleciona o veículo mais próximo da localização do cliente 
   * @param Cliente com sessão iniciada
   **/
   public void rentNearestVehicle(Client c)
   {
       Scanner input = new Scanner(System.in);
       double x, y;
 
       Vehicle v = new Gas();
       Point2D f = askDistance();
       double kms = Math.round(c.getLocation().distanceTo(f));
       
       try
       {
           v = umcj.nearestVehicle(c.getLocation(), kms);
           rentRequest(c, v, f);
       }
       catch (NoVehiclesAvailableException e){out.println(e.getMessage());}
       
       input.close();
   }
    
   /** 
   * Método que seleciona o veículo específico requisitado pelo cliente para a realização de um aluguer 
   * @param Cliente com sessão iniciada
   **/
   public void rentSpecificVehicle(Client c)
   {
       Scanner input = new Scanner(System.in);
       String plate;
       out.println("Digite a matrícula do veículo que deseja (por ex: [HF-12-45])");
       plate = input.nextLine();
       
       Vehicle v = new Gas();
       Point2D f = askDistance();
       double kms = Math.round(c.getLocation().distanceTo(f));
       try
       {
           v = umcj.specificVehicle(plate, kms); 
           rentRequest(c, v, f);
        }
       catch (VehicleDoesntExistException e){System.out.println(e.getMessage());}
       
       input.close();
   }
   
   /** 
   * Método que seleciona o veículo mais barato para a realização de um aluguer
   * @param Cliente com sessão iniciada
   **/
   public void rentCheapestVehicle(Client c)
   {
       Scanner input = new Scanner(System.in);
       Vehicle v = new Gas();
       Point2D f = askDistance();
       double kms = Math.round(c.getLocation().distanceTo(f));
       try
       {
           v = umcj.cheapestVehicle(kms); 
           rentRequest(c, v, f);
        }
       catch (NoVehiclesAvailableException e){System.out.println(e.getMessage());}
       
       input.close();
    }
   
   /** 
   * Método que seleciona o veículo mais barato para a realização de um aluguer dentro de uma distancia a pé 
   * @param Cliente com sessão iniciada
   **/
   public void rentCheapWalk(Client c)
   {
           Scanner input = new Scanner(System.in);
           double walk;
           out.println("Digite a distância que está disposto a andar até ao veículo: ");
           walk = input.nextDouble();
           Vehicle v = new Gas();
           
           Point2D f = askDistance();
           double kms = Math.round(c.getLocation().distanceTo(f));
           try
           {
               v = umcj.cheapestWalkVehicle(walk, c.getLocation(), kms); 
               rentRequest(c, v, f);
            }
           catch (NoVehiclesAvailableException e){System.out.println(e.getMessage());}
           
           input.close();
   }
   
   /** 
   * Método que seleciona o veículo com a autonomia desejada para a realização de um aluguer dentro de uma distancia a pé 
   * @param Cliente com sessão iniciada
   **/
   public void rentDesiredAutonomy(Client c)
   {
           Scanner input = new Scanner(System.in);
           double a;
           out.println("Digite a autonomia desejada: ");
           a = input.nextDouble();
           Vehicle v = new Gas();
           Point2D f = askDistance();

           try
           {
               v = umcj.desiredAutonomyVehicle(a); 
               rentRequest(c, v, f);
            }
           catch (NoVehiclesAvailableException e){System.out.println(e.getMessage());}
           
           input.close();
    }
   
   /**
   * Método que retorna uma lista com os 10 clientes que mais utilizam o sistema (em vezes)
   **/
   public void top10clientsx()
   {
       List<Client> cl = umcj.top10clientsX();
       out.println("De momento estes são os 10 clientes que mais usaram a aplicação: \n");
       for(Client c : cl){out.println(c.getName());}
   }
   
   /**
   * Método que retorna uma lista com os 10 clientes que mais utilizam o sistema (em km)
   **/
   public void top10clientskm()
   {
       List<Client> cl = umcj.top10clientsKM();
       out.println("De momento estes são os 10 clientes que viajaram mais km através da aplicação: \n");
       for(Client c : cl){out.println(c.getName());}
   }
   
   
    
   
   /*** PROPRIETARIOS ***/
   /**
   * Método que adiciona um proprietario à aplicação, requisitando a inserção dos seus dados e dos dados do seu veículo 
   **/
   public void addOwner()
   {
       Scanner input = new Scanner(System.in);
       String name, password, email, address;
       double x, y;
       int nif, confirmNif;
       try
       {
           out.println("Nome: ");
           name = input.nextLine();
           out.println("Email: ");
           email = input.nextLine();
           do
           {
               out.println("NIF: ");
               nif = input.nextInt();
               out.println("Confirmar NIF: ");
               confirmNif = input.nextInt();   
               if(nif != confirmNif) out.println("NIF incorreto.");
           }
           while(nif != confirmNif);
           input.nextLine();
           
           out.println("Morada: ");
           address = input.nextLine();
           

           umcj.registerNewOwner(name, nif, address, email); 
           Owner o = umcj.getOwnerByNif(nif);
           ownerArea(o);
       }catch (RegistrationException | UserDoesntExistException e){out.println(e.getMessage());}
       
       input.close();
   }
   
   /** 
   * Menu da área pessoal de um proprietário, com as opções que este pode efetuar na aplicação 
   * @param Proprietário com sessão iniciada
   **/
   public void ownerArea(Owner o)
   {
       String s[] = {"Adicionar um veículo novo", "Lista dos meus veículos","Top 10 Clientes -> km ",
                     "Top 10 Clientes -> Uso", "Lucro dos meus Carros", 
                     "Eliminar Perfil"};

       Menu m = new Menu(s);
       int op = 0;
       do
       {
           m.exec();
           op = m.getOption();
           switch(op)
           {
               case 1: addVehicle();
                       break;       
               case 2: printVehicles(o);   
                       break;  
               case 3: top10clientskm();
                       break;
               case 4: top10clientsx();
                       break;
               case 5: carProfit(o);
                       break;
               case 6: if(deleteOwnerProfile(o) == 1)
                             op = 0;
                       break;
           }
       }
       while(op != 0);
   }
   
   public void printVehicles(Owner o)
   {
       try
       {
            List<Vehicle> v = this.umcj.listOfVehicles(o.getNif());
            System.out.println("Os meus veículos: \n" + v.toString() );
        }
       catch ( UserDoesntExistException e){out.println(e.getMessage());}
       
    }
   /**
   * Método que elimina o perfil de um determinado utilizador da aplicação 
   * @param    Proprietário com sessão iniciada
   * @return   Retorna 1 para permitir voltar ao menu principal, caso o perfil não tenha sido possível eliminar o perfil do utilizador retorna 0
   **/
   public int deleteOwnerProfile(Owner o)
   {
       Scanner input = new Scanner(System.in);
       String aux;
       int nif;
       out.println("Tem a certeza que deseja eliminar o seu perfil permanentemente? [sim/nao] ");
       aux = input.nextLine();
       if(aux.equals("sim"))
       {
           out.println("NIF: ");
           nif = input.nextInt();
           if(nif == o.getNif())
           {
               out.println("Perfil eliminado.");
               input.close();
               return 1;
           }
           else
           {
               out.println("NIF incorreto.");
               input.close();
               return 0;
           }
       }
       input.close();
       return 0;
   }
   
   /** 
   * Método que adiciona um veículo requisitando a inserção dos dados 
   **/
   public void addVehicle()
   {
       Scanner input = new Scanner(System.in);
       int nif;
       boolean disponibilidade;
       String email, brand, type, plate;
       double speed, price, comsuption, autonomy, x, y;
       
       try
       {
           out.println("Indique o email do proprietário: ");
           email = input.nextLine();
           out.println("Que tipo de veículo pretende registar? ");
           type = input.nextLine();
           out.println("Marca:");
           brand = input.nextLine();
           out.println("Matricula: (por ex: [HF-12-45])");
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
            
           Vehicle v = umcj.vType(type, brand,plate,nif,speed,price,comsuption,autonomy,x,y);
           {umcj.addVehicleToOwner(nif,v);}
       }
       catch ( VehicleExistsException | InvalidVehicleException | UserDoesntExistException e){out.println(e.getMessage()); }
       
       input.close();
   }
   
   /** 
   * Método que fornece o total faturado por um carro num determinado período 
   **/ 
   public void carProfit(Owner o)
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
       
       input.nextLine();
       try
       {
           out.println("Digite a matricula do veiculo que pretende consultar: (por ex: [HF-12-45])");
           plate = input.nextLine();
           
           double total = umcj.carProfit(o.getNif(), plate, yi, mi, di, yf, mf, df);
           
           out.println("No período submetido o veiculo "+ plate +" faturou " +total+ " euros");
       }
       catch ( VehicleDoesntExistException e){out.println(e.getMessage());}
       catch (DateException e){out.println(e.getMessage());}
       input.close();
   }
}