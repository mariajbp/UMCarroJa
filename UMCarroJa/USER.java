import java.io.Serializable;

/**
 * DESCREVER ESTA CLASSE DE UMA MANEIRA PANELEIRA 
 */
public abstract class USER implements Serializable
{
  private String email;
  private String nome;
  private String password;
  private String morada;
  //data

  /**
  * Construtor por omissão - sem parametros/vazio
  **/
  public USER()
  {
     this.email = "";
     this.nome = "";
     this.password = "";
     this.morada = "";
        //data
  }
     
  /**
  * Construtor parametrizado - define um valor incial para 
  * cada variavel
  **/
   
  public USER(String new_email, String new_nome, String new_password, String new_morada)
  {
     this.email = new_email;
     this.nome = new_nome;
     this.password = new_password;
     this.morada = new_morada;
        //data
  }
    
  /**
  * Construtor de cópia - recebe um objeto e cria uma cópia dele
  **/
  public USER(USER outro)
  {
     this.email = outro.getEmail();
     this.nome = outro.getNome();
     this.password = outro.getPassword();
     this.morada = outro.getMorada();
        //data
  }
    
    /************************* GETTERS *************************/
  public String getEmail(){return this.email;}
  public String getNome(){return this.nome;}
  public String getPassword(){return this.password;}
  public String getMorada(){return this.morada;}
    //data
    
   /************************* SETTERS *************************/
  public void setEmail(String newEmail){this.email = newEmail;}
  public void setNome(String newNome){this.nome = newNome;}
  public void setPassword(String newPassword){this.password = newPassword;}
  public void setMorada(String newMorada){this.morada = newMorada;} 
  //data
  
   /************************* CLONE *************************/
  public abstract USER clone();
    
    /************************* EQUALS *************************/
  public boolean equals(Object o)
  {
      if(this == o) return true;
      if(o != null && this.getClass() != o.getClass()) return false;
      USER u = (USER) o;     
       return this.nome == u.getNome() &&
              this.email == u.getEmail() &&
              this.password == u.getPassword() &&
              this.morada == u.getMorada(); //DATA
               
  }
    
    /************************* TOSTRING *************************/
  public String toString()
  {
      return "email: " + email +
             "nome: " + nome +
             "password: " + password +
             "morada: " + morada;
             //data
  }
    
}
