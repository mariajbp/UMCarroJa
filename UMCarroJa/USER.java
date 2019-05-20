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
  
  public USER()
  {
     this.email = "";
     this.name = "";
     this.password = "";
     this.address = "";
     this.nif = 0;
  }
     
  public USER(String name, String password, String email, String address, int nif)
  {
    this.email = email;
    this.name = name;
    this.password = password;
    this.address = address;
    this.nif = nif;
  }
    
  public USER(USER u)
  {
       this.email = u.getEmail();
       this.name = u.getName();
       this.password = u.getPassword();
       this.address = u.getAddress();
       this.nif = u.getNif();
  }
    
    /************************* GETTERS *************************/
  public String getEmail(){return this.email;}
  public String getName(){return this.name;}
  public String getPassword(){return this.password;}
  public String getAddress(){return this.address;}
  public int getNif(){return this.nif;}
    
   /************************* SETTERS *************************/
  public void setEmail(String newEmail){this.email = newEmail;}
  public void setNoame(String newName){this.name = newName;}
  public void setPassword(String newPassword){this.password = newPassword;}
  public void setAddress(String newAdd){this.address = newAdd;}
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
