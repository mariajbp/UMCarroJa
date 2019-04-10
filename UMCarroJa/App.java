import java.util.*;
import java.io.File;
import java.io.Serializable;
import java.io.IOException;
import java.util.InputMismatchException;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class App  implements Serializable
    {
        public void run() 
        {
		StartApp();
		loadMenus();
		try {runHomeMenu();} 
		catch (NullPointerException e){System.out.println("Problema ao carregar Menu inicial");}
		EndApp();
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
            signupMenu = new Menu(signup);
        }
        
        private void runHomeMenu()
        {
           //Scanner input = new Scanner(System.int);
           //int code;
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
                    case 1: /**SOMETHING HERE*/; break;
            }
            }while(clientMenu.getOption() != 0);
        }
        
        private void runOwnerMenu() 
        {
        do {
            OwnerMenu.runOwnerMenu();
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
        
            signUpMenu.runSignUpMenu();
            try{
                 if (signUpMenu.getOption() == 0) 
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
                email = read.nextLine();
                if(/**CHECKAR SE O EMAIL JÁ EXISTE*/) {System.out.println("Esse email já existe. Tente outra vez: ");}
                else flag = 1;
            }while(f==0);
            return email;
       }
       
       /*** LOGIN ***/
       private void login() 
       {
       }

       private void saveClientData(String email)
       {}
       
        private void showClientProfile(Client c)
       {}
       
       private void saveOwnerData(String email)
       {}
       
       private void showOwnerProfile(Owner o)
       {}
       
       public void StartApp(){}

        public void EndApp(){}
       
}
