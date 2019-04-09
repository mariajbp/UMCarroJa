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
  private String date;
  
  public USER()
  {
     this.email = "";
     this.name = "";
     this.password = "";
     this.address = "";
     this.date = "";
  }
     
  public USER(String new_email, String new_name, String new_password, String new_address, String new_date)
  {
    this.email = new_email;
    this.name = new_name;
    this.password = new_password;
    this.address = new_address;
    this.date = new_date;
  }
    
  public USER(USER u)
  {
   this.email = u.getEmail();
   this.name = u.getName();
   this.password = u.getPassword();
   this.address = u.getAddress();
   this.date = u.getDate();
  }
    
    /************************* GETTERS *************************/
  public String getEmail(){return this.email;}
  public String getName(){return this.name;}
  public String getPassword(){return this.password;}
  public String getAddress(){return this.address;}
  public String getDate(){return this.date;}
    
   /************************* SETTERS *************************/
  public void setEmail(String newEmail){this.email = newEmail;}
  public void setNoame(String newName){this.name = newName;}
  public void setPassword(String newPassword){this.password = newPassword;}
  public void setAddress(String newAdd){this.address = newAdd;} 
  public void setDate(String newDate){this.date = newDate;}
  
  
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
              this.date == u.getDate();
               
  }
    
    /************************* TOSTRING *************************/
  public String toString()
  {
      return "email: " + email +
             "nome: " + name +
             "password: " + password +
             "morada: " + address +
             "Data de nascimento " + date;
  }
    
}
