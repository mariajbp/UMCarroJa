import java.util.*;
import java.io.File;
import java.io.Serializable;
import java.io.IOException;
import java.util.InputMismatchException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import static java.lang.System.out;

/**
* 
**/

public class App  implements Serializable
{
   private static Menu homeMenu,clientMenu,ownerMenu,signupMenu,signUpVehicleMenu, refuelMenu, specificVehicleMenu;
   private Client client;
   private Owner owner;
   private UMCarroJa umcj;
   private int userType;
   
   public void run() 
   {
        StartApp();
        loadMenus();
        try {runHomeMenu();} 
        catch (NullPointerException e){out.println("Houve algum problema ao carregar o menu inicial");}
        EndApp();
   }
   
   public void UMCJ_App()
   {
       File f = new File("data");
       this.umcj = new UMCarroJa();
       if(!f.exists()) 
       {
           new Test(this.umcj);
       }
   }
    
   private void loadMenus()
   {
        String[] main = {"Iniciar Sessão", "Registar utilizador"}; //more to be added
          
        String[] client = {"Mostrar perfil", "Mostrar histórico" }; //DATAS NO HISTORICO
            
        String[] owner = {"Mostrar perfil", "Mostrar histórico"};
            
        String[] signUp = {"Registar Cliente","Registar Proprietário"};
        
        String[] refuel = {"Reabastecer Carro a Gasolina", "Reabastecer Carro Hibrido", "Reabastecer Carro Elétrico"};
        
        String[] signUpVehicle = {"Registar Carro a Gasolina", "Registar Carro Hibrido", " Registar Carro Elétrico"};
        
        String[] specificVehicle = {"Gasolina","Hibrido","Eletrico"};
            
        homeMenu = new Menu(main);
        clientMenu = new Menu(client);
        ownerMenu = new Menu(owner);
        signupMenu = new Menu(signUp);
        refuelMenu = new Menu(refuel);
        signUpVehicleMenu = new Menu(signUpVehicle);
        specificVehicleMenu = new Menu(specificVehicle);
   }
        
   private void runHomeMenu()
   {
      Scanner input = new Scanner(System.in);
      int code;
      do{
            homeMenu.rHome();
            switch(homeMenu.getOption())
            {
              case 1:
                  try {login();} 
                  catch (NullPointerException e){out.println("Não foi possivel efetuar o login");}
                  break;
                     
              case 2: 
                  try {signUp();} 
                  catch (NullPointerException e){out.println("Não foi possivel efetuar o registo");}
                  break;
        }
      }while(homeMenu.getOption() != 0);
   }
        
   private void runClientMenu() 
   {
     do{
          clientMenu.rClientMenu();
          switch(clientMenu.getOption()) 
          {
               case 1: showClientProfile(this.client.clone()); break;
          }
     }while(clientMenu.getOption() != 0);
   }
        
   private void runOwnerMenu() 
   {
     do {
          ownerMenu.rOwnerMenu();
          switch(ownerMenu.getOption()) 
          {
                 case 1: /**SOMETHING HERE*/; break;
          }
     }while(ownerMenu.getOption() != 0);
   }
    
   private void signUp() 
   {
       String email, name, pass, address, date;
       Point2D location, destination;
       double dest_x, dest_y, local_x, local_y;
       Scanner input = new Scanner(System.in);
       int answer, nd;
        
       signupMenu.rSignUpMenu();
       try{
            if (signupMenu.getOption() == 0) 
            {
                 out.println("Canceled");
                 return;
            }
       } catch (NullPointerException e){out.println("Sign up was not successfull");}
            
       email = newEmail(); //definido em baixo
       out.print("Nome: ");
       name = input.nextLine();
       out.print("Password: ");
       pass = input.nextLine();
       out.print("Morada: ");
       address = input.nextLine();
       out.print("Data de nascimento (dd-mm-yyyy): ");
       date = input.next();
      //to be continued
   }
        
   //obtaining email
   private String newEmail()
   {
       Scanner input = new Scanner(System.in);
       int f = 0;
       String email=" ";
       do{
            out.println("Email: ");
            email = input.nextLine();
            if(this.umcj.checkEmail(email))
            {
		out.println("Esse email já existe. Tente novamente: ");
            }else f = 1;
       }while(f==0);
       return email;
   }
       
   /*** LOGIN ***/
   private void login() 
   {
       Scanner input = new Scanner(System.in);
       String email, password;

       out.print("Email: ");
       email = input.nextLine();
       out.print("Password: ");
       password = input.nextLine();
       
       try
       {
            try
            {
                umcj.login(email, password);
            } catch (NullPointerException e){out.println("Problema no login");}
  
            switch (umcj.getUserType()) 
            {
                case 1: saveClientData(email);
                runClientMenu();
                break;
                case 2: saveOwnerData(email);
                runOwnerMenu();
                break;
            }
       }
       catch(UserDoesntExistException e){out.println(e.getMessage());}
   }

   private void saveClientData(String email)
   {
       try
       {
           Client c = this.umcj.getClients().get(email).clone();
           this.client = c;
           this.userType = 1;
       }catch (NoClientsException e){out.println("Não foi possivel aceder aos clientes");}
   }
       
   private void showClientProfile(Client c)
   {
       this.umcj.printClient(c);
   }
       
   private void saveOwnerData(String email)
   {
     try
     {
         Owner o = this.umcj.getOwners().get(email).clone();
         this.owner = o;
         this.userType = 2;
     }catch (NoOwnersException e){out.println("Não foi possivel aceder aos propriertários");}
   }
       
   private void showOwnerProfile(Owner o)
   {
       this.umcj.printOwner(o); 
   }
   
   private void showHistory() //ALTERAR
   {
    switch(this.userType)
    {
        case 1: this.client.printHistoryCL(); break;
        //case 2: this.owner.printHistoryCAR(); break;      
    }
   }
   
   //CLIENTS
   /**
   private void showAvailableCars()
   {
      try{
          for(Ride r: umcj.getVehicles())
          {
             if(r.isAvailable()==false) out.println(r.toString());
          }
    }catch(NoCarsAvailableException e){out.println(e.getMessage());}
   }
   
   
   private void showAllCars()
   {
    try{
        for(Ride r: this.umcj.getVehicles())
        {
        out.println(r.toString());
        }
    }catch(NoCarsAvailableException e)
    {
        System.out.println("Sem Veiculos Disponiveis");
    }
    }
    
   
   
   private void searchCarsByType()
   {
    int option;
    Scanner input = new Scanner(System.in);
    out.println("Opção 1: Gasolina");
    out.println("Opção 2: Hibrido");
    out.println("Opção 3: Elétrico");
    option = input.nextInt();
    switch(option)
    {
        case 1: availableCars(1); break;
        case 2: availableCars(2); break;
        case 3: availableCars(3); break;
        }
    }
   
   private void availableCars(int option)
   {
    try{
        for(Ride r: this.umcj.getVehicles()) //WHY THO
        {
            if(option==1 && (r.getVehicle() instanceof Gas)){out.println(r.toString());}
            if(option==2 && (r.getVehicle() instanceof Hybrid)){out.println(r.toString());}
            if(option==3 && (r.getVehicle() instanceof Electric)){out.println(r.toString());}
        }
    }catch(NoCarsAvailableException e){out.println(e.getMessage());}
   } **/
  
   
   
   private void specificVehicle()
   {
        int ex = 0;
        Scanner input = new Scanner(System.in);
        do{
            specificVehicleMenu.rSpecificVehicleMenu();
            switch(specificVehicleMenu.getOption())
            {
                case 1: specificGas();
                            ex = 1;
                            break;
    
                case 2: specificHybrid();
                            ex = 1;
                            break;
    
                case 3: specificElectric();
                            ex = 1;
                            break;
            }
        }while(specificVehicleMenu.getOption()!=0 && ex == 0);
   }
   
   private void specificGas() //Unfinished
   {
       String answer;
       Scanner input = new Scanner(System.in);
        
       if(this.umcj.getClosestGas(this.client.clone())!=null)
       {
            Ride r = this.umcj.getClosestGas(this.client.clone());
            if(r.isAvailable() == true)
            {
                out.println("");
            }  
       }
    }
   
   private void specificHybrid(){}
   
   private void specificElectric(){}
   
   
   
   
   private void travel(Ride r){}
  
  
   
   
   
   
   
   
   public void StartApp()
   {
       try {
             File f = new File("data");
             if (f.exists())
             {
                 FileInputStream fis = new FileInputStream("data");
                 ObjectInputStream ois = new ObjectInputStream(fis);
                 this.umcj = (UMCarroJa) ois.readObject();
                 ois.close();
                 out.println("Carregado com sucesso.");
             }
       } catch (Exception e) {out.println(e.getMessage());}
   }

   public void EndApp()
   {
       try {
        FileOutputStream fos = new FileOutputStream("data");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this.umcj);
        oos.flush();
        oos.close();
        System.out.println("Guardado");
       } catch (Exception e) {out.println(e.getMessage());}
   }
}
   

