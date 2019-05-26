import java.util.*;
import java.io.Serializable;
import java.util.ArrayList;

/**
* Representação da classe cliente, subclasse de USER
**/
public class Client extends USER implements Serializable
{
  private double walk;  //4km por hora
  private double x;
  private double y;
  Point2D location = new Point2D(x,y);
  private Set<RentedCar> rentingHistory;

  /** 
  * Construtor vazio que cria uma instância Client  
  **/
  public Client()
  {
      super();
      this.x = 0.0;
      this.y = 0.0;
      this.location = new Point2D();
      this.rentingHistory = new TreeSet<RentedCar>();
  }
  
  /** 
  * Construtor que cria um novo Client a partir dos parâmetros dados 
  **/
  public Client(String name, int nif, String email, String address, double x, double y)
  {
      super(name,nif,email,address);
      this.x = x;
      this.y = y;
      this.location = new Point2D(x,y);
      this.rentingHistory = new TreeSet<RentedCar>();
  }
 
  /** 
  * Construtor de cópia que cria uma nova instância Client a partir de um Client passado como parâmetro 
  **/
  public Client(Client c)
  {
      super(c.getName(), c.getNif(), c.getEmail(), c.getAddress());
      this.x = c.getX();
      this.y = c.getY();
      this.location = c.getLocation();
      this.rentingHistory = c.getRentingHistoryAll();
  }
  
    
  /**
  * Método que devolve o numero de km que um cliente está disposto a caminhar
  * @return Numero de km que um cliente está disposto a caminhar
  **/
  public double getWalk(){return this.walk;}
  
  /**
  * Método que devolve a coordernada X da localização do cliente
  * @return Coordernada X da localização do cliente
  **/
  public double getX(){return this.x;}
  
  /**
  * Método que devolve a coordernada Y da localização do cliente
  * @return Coordernada Y da localização do cliente
  **/
  public double getY(){return this.y;}
  
  /**
  * Método que devolve a localização do cliente
  * @return Localização do cliente
  **/
  public Point2D getLocation(){return this.location.clone();}
  
  /**
  * Método que devolve o historico de alugueres de um cliente
  * @return Historico de alugueres de um cliente
  **/
  public Set<RentedCar> getRentingHistoryAll()
  {
     Set<RentedCar> aux = new TreeSet<RentedCar>();
     for(RentedCar rc: this.rentingHistory){aux.add(rc.clone());}
     return aux;
  }
  
  /**
  * Método que define o numero de km que um cliente está disposto a caminhar a partir de uma número passada como parâmetro
  * @param Numero de km que um cliente está disposto a caminhar
  **/
  public void setWalk(double w){this.walk = w;}
  
  /**
  * Método que define o a coordenada X do cliente
  * @param Coordenada X do cliente
  **/
  public void setX(double x){this.x = x;}
  
  /**
  * Método que define o a coordenada Y do cliente
  * @param Coordenada Y do cliente
  **/
  public void setY(double y){this.y = y;}
  
  /**
  * Método que define o a localização do cliente
  * @param Localização do cliente
  **/
  public void setLocation(Point2D p){this.location = p.clone();}
  
  /**
  * Método que define o historico de alugueres do cliente
  * @param Historico de alugueres do cliente
  **/
  public void setRentingHistory(Set<RentedCar> rc)
  {
      this.rentingHistory.clear();
      for(RentedCar r: rc){this.rentingHistory.add(r.clone());}
  }
  
  /**
  * Método que adiciona um aluguer ao historico
  * @param Aluguer realizado pelo cliente
  **/
  public void addRentedCar(RentedCar rc){this.rentingHistory.add(rc.clone());}
  
  /**
  * Método que remove um aluguer ao historico
  * @param Aluguer realizado pelo cliente
  **/
  public void removeRentedCar(RentedCar rc){this.rentingHistory.remove(rc);}
   
  /** 
  * Método que cria uma cópia de uma identificação de um Client
  **/
  public Client clone()
  {
    return new Client(this);
  }
    
  /** 
  * Método que testa se um objeto é igual a uma determinada identificação
  * @param      Objeto a ser testado
  * @return     True se o objeto for igual à identificação, false se o objeto passado não for igual à identificação
  **/
  public boolean equals(Object o)
  {
      if(this == o) return true;
      if(o == null && this.getClass() != o.getClass()) return false;
      Client c = (Client) o;     
      return super.equals(c) &&
             this.walk == c.getWalk() &&
             this.location.equals(c.getLocation()) &&
             this.rentingHistory.equals(c.getRentingHistoryAll());
  }
    
  /**
  * Método que converte uma identificação numa string
  * @return  string com a identificação do utilizador
  **/
  public String toString()
  {
       StringBuilder sb = new StringBuilder();
       sb.append(super.toString()).append("\n");
       return sb.toString();
  }
  
  /**
  * Método que calcula o total de km percorridos pelo cliente
  * @return Total de km percorridos pelo cliente
  **/
  public double totalKms()
  {
     Iterator<RentedCar> it = rentingHistory.iterator();
     double aux = 0.0;
     RentedCar r;
     while(it.hasNext())
     {
        r = it.next();
        aux += r.getKms();
     }
     return aux;
  }
  
  /**
  * Método que calcula a classificação de um cliente 
  **/
  public void clientRating(int newR)
  {
     if(this.rentingHistory.size() == 0)
            this.setRating(newR);
      else
      {
          int nr = (this.getRating() + newR)/(this.rentingHistory.size());
          this.setRating(nr);
        }
  }
}
