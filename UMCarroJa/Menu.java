import java.io.Serializable;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

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
  //run cliente menu
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
          case 1: System.out.println("Bem-vindo à UMCarrojá!");
          for(int i = 0; i<this.options.size(); i++)
          {
              System.out.print((i+1));
          }
          System.out.println("Clique 0 para sair");
          break;
          
          case 2: System.out.println("\n Cliente");
          for (int i=0; i<this.options.size(); i++) {
              System.out.print((i+1));
              System.out.print(" - ");
              System.out.println(this.options.get(i));
          }
          System.out.println("Clique 0 para sair");
          break;
          
          case 3: System.out.println("\n Proprietário");
          for (int i=0; i<this.options.size(); i++) {
              System.out.print((i+1));
              System.out.print(" - ");
              System.out.println(this.options.get(i));
          }
          System.out.println("Clique 0 para sair");
          break;
          
          case 5: System.out.println("\n Efetuar Registo");
          for (int i=0; i<this.options.size(); i++) {
              System.out.print((i+1));
              System.out.print(" - ");
              System.out.println(this.options.get(i));
          }
          System.out.println( "Clique 0 para sair");
          break;
      }
  }
  
  //ler opção valida
  private int readOption()
  {
     int option;
     Scanner input = new Scanner(System.in);
      
     System.out.print("Opção: ");
      /**
      try
      {
          option = input.nextInt();
      }
      catch(NOME DA EXCEPTION DO INPUT A CRIAR) // caso não escreve um int manda-a
      {
          option = -1;
      }
      if(op<0 || op>this.options.size())
      {
          System.out.println("Opção Inválida");
          option = -1
      }
      
      */
     return option;
  }
  
  //obter a ultima opção lida
  public int getOption()
  {
      return this.op;
  }
}
