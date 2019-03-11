/**
 * DESCREVER ESTA CLASSE DE UMA MANEIRA PANELEIRA 
 */
public class Carro
{
  private double vmedia;
  private double precokm;
  private double consumo;
  //HISTORICO VAI SER UMA ESTRUTURA
  private int rating;
  /**
  * Construtor por omissão - sem parametros/vazio
  **/
  public Carro()
  {
     this.vmedia = 0.0;
     this.precokm = 0.0;
     this.consumo = 0.0;
     this.rating = 0;
  }
     
  /**
  * Construtor parametrizado - define um valor incial para 
  * cada variavel
  **/
   
  public Carro(double new_vmedia, double new_precokm, double new_consumo, int new_rating )
  {
     this.vmedia = new_vmedia;
     this.precokm = new_precokm;
     this.consumo = new_consumo;
     this.rating = new_rating;
  }
    
  /**
  * Construtor de cópia - recebe um objeto e cria uma cópia dele
  **/
  public Carro(Carro outro)
  {
     this.vmedia = outro.getVmedia();
     this.precokm = outro.getPrecokm();
     this.consumo = outro.getConsumo();
     this.rating = outro.getRating();
  }
    
    /************************* GETTERS *************************/
  public double getVmedia(){return this.vmedia;}
  public double getPrecokm(){return this.precokm;}
  public double getConsumo(){return this.consumo;}
  public int getRating(){return this.rating;}
  
   /************************* SETTERS *************************/
  public void setVmedia(double newV){this.vmedia = newV;}
  public void setPrecokm(double newP){this.precokm = newP;}
  public void setConsumo(double newC){this.consumo = newC;}
  public void setRating(int newR){this.rating = newR;}

   /************************* CLONE *************************/
  public Carro clone()
  {
    return new Carro(this);
  }
    
    /************************* EQUALS *************************/
  public boolean equals(Object o)
  {
      if(this == o) return true;
      if(o != null && this.getClass() != o.getClass()) return false;
      Carro c = (Carro) o;     
       return this.vmedia == c.getVmedia() &&
              this.precokm == c.getPrecokm() &&
              this.consumo == c.getConsumo() &&
              this.rating == c.getRating();             
  }
    
    /************************* TOSTRING *************************/
  public String toString()
  {
      return "Velocidade média por km: " + vmedia +
             "Preço base por km: " + precokm +
             "Consumo de gasolina/bateria por km: " + consumo +
             "Classificação: " + rating;
             
  }
    
}

