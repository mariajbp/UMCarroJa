import java.io.Serializable;


/**
 * DESCREVER ESTA CLASSE DE UMA MANEIRA PANELEIRA 
 */


public abstract class CAR implements Serializable
{
  private double averageVel;
  private double pricekm;
  private double consumption;
  //HISTORICO VAI SER UMA ESTRUTURA
  private int rating;
  /**
  * Construtor por omissão - sem parametros/vazio
  **/
  public CAR()
  {
     this.averageVel = 0.0;
     this.pricekm = 0.0;
     this.consumption = 0.0;
     this.rating = 0;
  }
     
  /**
  * Construtor parametrizado - define um valor incial para 
  * cada variavel
  **/
   
  public Car(double new_averageVel, double new_pricekm, double new_consumption, int new_rating )
  {
     this.averageVel = new_averageVel;
     this.pricekm = new_pricekm;
     this.consumption = new_consumption;
     this.rating = new_rating;
  }
    
  /**
  * Construtor de cópia - recebe um objeto e cria uma cópia dele
  **/
  public Car(Car outro)
  {
     this.averageVel = outro.getAverageVel();
     this.pricekm = outro.getPricekm();
     this.consumption = outro.getConsumption();
     this.rating = outro.getRating();
  }
    
    /************************* GETTERS *************************/
  public double getAverageVel(){return this.averageVel;}
  public double getPricekm(){return this.pricekm;}
  public double getConsumption(){return this.consumption;}
  public int getRating(){return this.rating;}
  
   /************************* SETTERS *************************/
  public void setAverageVel(double newV){this.averageVel = newV;}
  public void setPricekm(double newP){this.pricekm = newP;}
  public void setConsumption(double newC){this.consumption = newC;}
  public void setRating(int newR){this.rating = newR;}

   /************************* CLONE *************************/
  public abstract Car clone();
      
}

