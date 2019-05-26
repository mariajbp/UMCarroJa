import java.io.Serializable;
import java.util.Scanner;
import java.util.List;
import java.util.Arrays;
import java.util.InputMismatchException;
import static java.lang.System.out;

/**
* Classe que implementa um menu em modo texto.
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
  
   //Método para apresentar o menu e ler uma opção.
  public void exec()
  {
      do{
           showMenu();
           this.op = readOption();
      } while (this.op == -1);
  }
    
  //Apresentar o menu 
  private void showMenu() 
  {
        out.println("\n*********** Menu *********** \n");
        for (int i=0; i<this.options.size(); i++) {
            out.print(i+1);
            out.print(" - ");
            out.println(this.options.get(i));
        }
        System.out.println("0 - Sair");
        System.out.println("\n****************************");
  }
  
  //ler opção valida
  private int readOption()
  {
     int op;
     Scanner input = new Scanner(System.in);
     out.print("\nOpção: \n");
     
     try {op = input.nextInt();}
     catch (InputMismatchException e) {op = -1;} //Não foi escrito um int
     if (op<0 || op>this.options.size()) 
     {
            out.println("\nOpção Inválida!");
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
