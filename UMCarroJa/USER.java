import java.util.*;
import java.io.Serializable;

/**
 * DESCREVER ESTA CLASSE DE UMA MANEIRA PANELEIRA 
 */
public abstract class USER implements Serializable
{
  private String email;
  private String name;
  private String password;
  private String address;
  private String bday;
  
  public USER()
  {
     this.email = "";
     this.name = "";
     this.password = "";
     this.address = "";
     this.bday = "";
  }
     
  public USER(String new_email, String new_name, String new_password, String new_address, String new_bday)
  {
    this.email = new_email;
    this.name = new_name;
    this.password = new_password;
    this.address = new_address;
    this.bday = new_bday;
  }
    
  public USER(USER u)
  {
   this.email = u.getEmail();
   this.name = u.getName();
   this.password = u.getPassword();
   this.address = u.getAddress();
   this.bday = u.getBday();
  }
    
    /************************* GETTERS *************************/
  public String getEmail(){return this.email;}
  public String getName(){return this.name;}
  public String getPassword(){return this.password;}
  public String getAddress(){return this.address;}
  public String getBday(){return this.bday;}
    
   /************************* SETTERS *************************/
  public void setEmail(String newEmail){this.email = newEmail;}
  public void setNoame(String newName){this.name = newName;}
  public void setPassword(String newPassword){this.password = newPassword;}
  public void setAddress(String newAdd){this.address = newAdd;} 
  public void setBday(String newBday){this.bday = newBday;}
  
  
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
              this.address == u.getAddress() &&
              this.bday == u.getBday();
               
  }
    
    /************************* TOSTRING *************************/
  public String toString()
  {
      return "email: " + email +
             "nome: " + name +
             "password: " + password +
             "morada: " + address +
             "Data de nascimento " + bday;
  }
    
}
