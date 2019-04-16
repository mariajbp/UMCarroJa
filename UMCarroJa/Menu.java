import java.io.Serializable;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;

/**
*
**/

public class Menu implements Serializable
{
  private List<String> options;
  private int op; //option
  private int chosenMenu;
  
  public Menu(String[] options)
  {
      this.options = Arrays.asList(options); //prints prettier
      this.op = 0;
  }
  
  //runs home menu
  public void runHome()
  {
    this.chosenMenu = 1;
    do
    {
        showMenu();
        this.op = readOption();
    }while(this.op == -1);
  }
  
  //run cliente menu
  public void runClientMenu() 
  {
     this.chosenMenu = 2;
     do 
     {
        showMenu();
        this.op = readOption();
     } while (this.op == -1);
  }
  
  //run owner menu
  public void runOwnerMenu() 
  {
     this.chosenMenu = 3;
     do 
     {
        showMenu();
        this.op = readOption();
     } while (this.op == -1);
  }

  //run signup menu
  public void runSignUpMenu() 
  {
     this.chosenMenu = 4;
     do 
     {
        showMenu();
        this.op = readOption();
     } while (this.op == -1);
  }
  
  
  
  //Apresentar Menu
  private void showMenu()
  {
      switch(this.chosenMenu)
      {
          case 1: System.out.println("********* Bem-vindo à UMCarrojá! *********\n");
          for(int i = 0; i<this.options.size(); i++)
          {
              System.out.print((i+1));
              System.out.print(" - ");
              System.out.println(this.options.get(i));
          }
          System.out.println("\nClique 0 para sair");
          break;
          
          case 2: System.out.println("\nCliente");
          for (int i=0; i<this.options.size(); i++) {
              System.out.print((i+1));
              System.out.print(" - ");
              System.out.println(this.options.get(i));
          }
          System.out.println("\nClique 0 para sair");
          break;
          
          case 3: System.out.println("\nProprietário");
          for (int i=0; i<this.options.size(); i++) {
              System.out.print((i+1));
              System.out.print(" - ");
              System.out.println(this.options.get(i));
          }
          System.out.println("\nClique 0 para sair");
          break;
          
          case 5: System.out.println("\n Efetuar Registo");
          for (int i=0; i<this.options.size(); i++) {
              System.out.print((i+1));
              System.out.print(" - ");
              System.out.println(this.options.get(i));
          }
          System.out.println( "\nClique 0 para sair");
          break;
      }
  }
  
  //ler opção valida
  private int readOption()
  {
     int option;
     Scanner input = new Scanner(System.in);
    
     System.out.print("Opção: ");
     
     try {option = input.nextInt();}
     catch (InputMismatchException e) {option = -1;} //Não foi escrito um int
     
     if (option<0 || option>this.options.size()) 
     {
            System.out.println("Opção Inválida!");
            op = -1;
     }
        return op;
  }
  
  
  //obter a ultima opção lida
  public int getOption()
  {
      return this.op;
  }
}
