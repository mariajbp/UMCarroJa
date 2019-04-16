
import java.util.*;
import java.io.File;
import java.io.Serializable;
import java.io.IOException;
import java.util.InputMismatchException;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class App  implements Serializable
{
   private static Menu homeMenu,clientMenu,ownerMenu,signupMenu;
   private Client client;
   private Owner owner;
   private UMCarroJa umcj;
   private int userType;
   
    public void run() 
   {
        StartApp();
        loadMenus();
        try {runHomeMenu();} 
        catch (NullPointerException e){System.out.println("Houve algum problema ao carregar o menu inicial");}
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
        String[] main = {"Iniciar Sessão", "Registar utilizador", "Registar Proprietário"}; //more to be added
          
        String[] client = {"Mostrar perfil", "Mostrar histórico" }; //DATAS NO HISTORICO
            
        String[] owner = {"Mostrar perfil", "Mostrar histórico"};
            
        String[] signUp = {"Cliente","Proprietário"};
            
        homeMenu = new Menu(main);
        clientMenu = new Menu(client);
        ownerMenu = new Menu(owner);
        signupMenu = new Menu(signUp);
   }
        
   private void runHomeMenu()
   {
      Scanner input = new Scanner(System.in);
      int code;
      do
      {
        homeMenu.runHome();
        switch(homeMenu.getOption())
        {
          case 1:
              try {login();} 
              catch (NullPointerException e){System.out.println("Something went wrong. Could not login");}
              break;
                 
          case 2: 
              try {signUp();} 
              catch (NullPointerException e){System.out.println("Something went wrong. Could not sign up");}
              break;
    
         }
      }while(homeMenu.getOption() != 0);
   }
        
   private void runClientMenu() 
   {
     do {
          clientMenu.runClientMenu();
          switch(clientMenu.getOption()) 
          {
               case 1: showClientProfile(this.client.clone()); break;
          }
     }while(clientMenu.getOption() != 0);
   }
        
   private void runOwnerMenu() 
   {
     do {
          ownerMenu.runOwnerMenu();
          switch(ownerMenu.getOption()) 
          {
                 case 1: /**SOMETHING HERE*/; break;
          }
     }while(ownerMenu.getOption() != 0);
   }
        
   /**MORE MENUS TO BE ADDED*/
   private void signUp() 
   {
       String email, name, pass, address, date;
       Point2D location, destination;
       double dest_x, dest_y, local_x, local_y;
       Scanner input = new Scanner(System.in);
       int answer, nd;
        
       signupMenu.runSignUpMenu();
       try{
            if (signupMenu.getOption() == 0) 
            {
                 System.out.println("Canceled");
                 return;
            }
       } catch (NullPointerException e){System.out.println("Sign up was not successfull");}
            
       email = newEmail(); //definido em baixo
       System.out.print("Nome: ");
       name = input.nextLine();
       System.out.print("Password: ");
       pass = input.nextLine();
       System.out.print("Morada: ");
       address = input.nextLine();
       System.out.print("Data de nascimento (dd-mm-yyyy): ");
       date = input.next();
       //incomplete
   }
        
   //obtaining email
   private String newEmail()
   {
       Scanner input = new Scanner(System.in);
       int f = 0;
       String email=" ";
       do{
            System.out.println("Email: ");
            email = input.nextLine();
            //if(/**CHECKAR SE O EMAIL JÁ EXISTE*/) {System.out.println("Esse email já existe. Tente outra vez: ");}
            //else f = 1;
       }while(f==0);
       return email;
   }
       
       /*** LOGIN ***/
   private void login() 
   {
       Scanner input = new Scanner(System.in);
       String email, password;

       System.out.print("Email: ");
       email = input.nextLine();
       System.out.print("Password: ");
       password = input.nextLine();
       
       try
       {
            try
            {
                umcj.login(email, password);
            } catch (NullPointerException e){System.out.println("Problema no login");}
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
       catch(UserDoesntExistException e){System.out.println(e.getMessage());}
   }

   private void saveClientData(String email)
   {
       try
       {
	   Client c = this.umcj.getClients().get(email).clone();
	   this.client = c;
	   this.userType = 1;
       }catch (NoClientsException e){System.out.println("Não foi possivel aceder aos clientes");}
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
     }catch (NoOwnersException e){System.out.println("Não foi possivel aceder aos propriertários");}
   }
       
   private void showOwnerProfile(Owner o)
   {
       this.umcj.printOwner(o); 
   }
   
  
   
   
   
   
   
   
   
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
        System.out.println("Carregado com sucesso.");
             }
       } catch (Exception e) {System.out.println(e.getMessage());}
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
       } catch (Exception e) {System.out.println(e.getMessage());}
   }
}
   

