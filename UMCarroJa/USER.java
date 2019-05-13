import java.util.*;
import java.io.Serializable;

/**
* Representação abstrata da superclasse da entidade USER(o utilizador da aplicação)
**/
public abstract class USER implements Serializable
{
  private String name;
  private String password;
  private String email;
  private String address;
  
  public USER()
  {
     this.email = "";
     this.name = "";
     this.password = "";
     this.address = "";
  }
     
  public USER(String name, String password, String email, String address)
  {
    this.email = email;
    this.name = name;
    this.password = password;
    this.address = address;
  }
    
  public USER(USER u)
  {
   this.email = u.getEmail();
   this.name = u.getName();
   this.password = u.getPassword();
   this.address = u.getAddress();
  }
    
    /************************* GETTERS *************************/
  public String getEmail(){return this.email;}
  public String getName(){return this.name;}
  public String getPassword(){return this.password;}
  public String getAddress(){return this.address;}
    
   /************************* SETTERS *************************/
  public void setEmail(String newEmail){this.email = newEmail;}
  public void setNoame(String newName){this.name = newName;}
  public void setPassword(String newPassword){this.password = newPassword;}
  public void setAddress(String newAdd){this.address = newAdd;} 
  
  
   /************************* CLONE *************************/
  public abstract USER clone();
    
    /************************* EQUALS *************************/
  public boolean equals(Object o)
  {
      if(this == o) return true;
      if(o != null && this.getClass() != o.getClass()) return false;
      USER u = (USER) o;     
       return this.name == u.getName() &&
              this.email == u.getEmail() &&
              this.password == u.getPassword() &&
              this.address == u.getAddress();
               
  }
    
   /************************* TOSTRING *************************/
  public String toString()
  {
      return "email: " + email +
             "nome: " + name +
             "password: " + password +
             "morada: " + address;
  }
    
}
