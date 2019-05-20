import java.util.*;
import java.io.Serializable;

/**
* Representação abstrata da superclasse da entidade USER(o utilizador da aplicação)
**/
public abstract class USER implements Serializable
{
  private String email; 
  private String name;
  private String password;
  private String address;
  private int nif;
  
  /** Construtor vazio que cria uma instância USER  **/
  public USER()
  {
     this.email = "";
     this.name = "";
     this.password = "";
     this.address = "";
     this.nif = 0;
  } 
  /** Construtor que cria um novo USER a partir dos parâmetros dados **/
  public USER(String name, String password, String email, String address, int nif)
  {
    this.email = email;
    this.name = name;
    this.password = password;
    this.address = address;
    this.nif = nif;
  }
  /** Construtor de cópia que cria uma nova instância USER a partir de um USER passado como parâmetro **/
  public USER(USER u)
  {
       this.email = u.getEmail();
       this.name = u.getName();
       this.password = u.getPassword();
       this.address = u.getAddress();
       this.nif = u.getNif();
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
  * Método que devolve a password de um utilizador
  * @return Password do utilizador
  **/
  public String getPassword(){return this.password;}
  
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
  * Método que define a password de um utilizador a partir de uma String passada como parâmetro
  * @param Password do utilizador 
  **/
  public void setPassword(String newPassword){this.password = newPassword;}
  
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
  
  
   /************************* CLONE *************************/
  public abstract USER clone();
    
    /************************* EQUALS *************************/
  public boolean equals(Object o)
  {
      if(this == o) return true;
      if(o == null && this.getClass() != o.getClass()) return false;
      USER u = (USER) o;     
       return this.name == u.getName() &&
              this.email == u.getEmail() &&
              this.password == u.getPassword() &&
              this.address == u.getAddress() &&
              this.nif == u.getNif();
               
  }
    
   /************************* TOSTRING *************************/
  public String toString()
  {
      return "Email: " + this.email +
             "Nome: " + this.name +
             "Morada: " + this.address +
             "NIF: " + this.nif;
  } 
}
