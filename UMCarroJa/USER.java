import java.util.*;
import java.io.Serializable;

/**
* Representação abstrata da superclasse da entidade USER (o utilizador da aplicação)
**/
public abstract class USER implements Serializable
{
  private String email; 
  private String name;
  private String address;
  private int nif;
  private int rating;

  
  /** 
  * Construtor vazio que cria uma instância USER  
  **/
  public USER()
  {
     this.email = "";
     this.name = "";
     this.address = "";
     this.nif = 0;
     this.rating = 0;
  } 
  
  /** 
  * Construtor que cria um novo USER a partir dos parâmetros dados 
  **/
  public USER(String name, int nif, String email, String address)
  {
    this.email = email;
    this.name = name;
    this.address = address;
    this.nif = nif;
    this.rating = 0;
  }
  
  /** 
  * Construtor de cópia que cria uma nova instância USER a partir de um USER passado como parâmetro 
  **/
  public USER(USER u)
  {
       this.email = u.getEmail();
       this.name = u.getName();
       this.address = u.getAddress();
       this.nif = u.getNif();
       this.rating = u.getRating();
  }
    
  /**
  * Método que devolve o email de um utilizador
  * @return Email do utilizador
  **/
  public String getEmail(){return this.email;}
  
  /**
  * Método que devolve o nome de um utilizador
  * @return Nome do utilizador
  **/
  public String getName(){return this.name;}
  
  /**
  * Método que devolve a rating de um utilizador
  * @return rating do utilizador
  **/
  public int getRating(){return this.rating;}
  
  /**
  * Método que devolve a morada de um utilizador
  * @return Morada do utilizador
  **/
  public String getAddress(){return this.address;}
  
  /**
  * Método que devolve o nif de um utilizador
  * @return Nif do utilizador
  **/
  public int getNif(){return this.nif;}
  
  /**
  * Método que define o email de um utilizador a partir de uma String passada como parâmetro
  * @param Email do utilizador 
  **/
  public void setEmail(String newEmail){this.email = newEmail;}
  
  /**
  * Método que define o nome de um utilizador a partir de uma String passada como parâmetro
  * @param Nome do utilizador 
  **/
  public void setNome(String newName){this.name = newName;}
  
  /**
  * Método que define o rating de um utilizador a partir de um int passado como parâmetro
  * @param rating do utilizador 
  **/
  public void setRating(int newRating){this.rating = newRating;}
  
  /**
  * Método que define a morada de um utilizador a partir de uma String passada como parâmetro
  * @param Morada do utilizador 
  **/
  public void setAddress(String newAdd){this.address = newAdd;}
  
  /**
  * Método que define o nif de um utilizador a partir de um int passado como parâmetro
  * @param Nif do utilizador 
  **/
  public void setNif(int nif){this.nif = nif;}
  
  /** 
  * Método que cria uma cópia de uma identificação de um USER
  **/
  public abstract USER clone();
    
  /** 
  * Método que testa se um objeto é igual a uma determinada identificação
  * @param      objeto a ser testado
  * @return     True se o objeto for igual à identificação, false se o objeto passado não for igual à identificação
  **/
  public boolean equals(Object o)
  {
      if(this == o) return true;
      if(o == null && this.getClass() != o.getClass()) return false;
      USER u = (USER) o;     
       return this.name == u.getName() &&
              this.email == u.getEmail() &&
              this.rating == u.getRating() &&
              this.address == u.getAddress() &&
              this.nif == u.getNif();
               
  }
    
  /**
  * Método que converte uma identificação numa string
  * @return    String com a identificação do utilizador
  **/
  public String toString()
  {
      return "Email: " + this.email +
             "Nome: " + this.name +
             "Morada: " + this.address +
             "NIF: " + this.nif + 
             "Rating: " + this.rating ;
  } 
}
