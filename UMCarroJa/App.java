


public class App
{
    private void loadMenus()
    {
        String[] main = {"Iniciar Sessão", "Registar Utilizador"}; //more to be added
        
        String[] client = {""};
        
        String[] owner = {""};
        
        String[] signUp = {""};
        
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
               catch (/**THIS WILL BE AN EXECPTION*/){System.out.println("Something went wrong. Could not login");}
               break;
               
               case 2: 
               try {signUp();} 
               catch (/**THIS WILL BE AN EXECPTION*/){System.out.println("Something went wrong. Could not sign up");}
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
}
