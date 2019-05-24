import java.util.*;
import java.io.Serializable;

/**
* Representação abstrata da superclasse Vehicle(contém os dados comuns a todas as viaturas do sistema)
**/
public abstract class Vehicle implements Serializable
{
  private static double deposit = 100;
  
  private String type;
  private String brand;
  private String plate;
  private double speed;
  private double price; 
  private double comsuption;
  private double autonomy;
  private double x;
  private double y;
  Point2D location = new Point2D(x,y);
  private boolean available;
  private int rating;
  private int nif;
 
  
  
  private Set<Ride> rentingHistory;
  
  /** 
  * Construtor vazio que cria uma instância Vehicle  
  **/
  public Vehicle()
  {
     this.type = "ND";
     this.brand = "ND";
     this.plate = "ND";
     this.nif = 0;
     this.speed = 0.0;
     this.price = 0.0;
     this.comsuption = 0.0;
     this.autonomy = 0.0;
     this.x = 0.0;
     this.y= 0.0;
     this.rating = 0;
     this.available = true;
     this.rentingHistory = new TreeSet<Ride>();
  }
  
  /** 
  * Construtor que cria um novo Vehicle a partir dos parâmetros dados 
  **/
  public Vehicle(String type, String brand, String plate, int nif, double speed, double price, double comsuption, double autonomy, double x, double y)
  {
    this.type = type;
    this.brand = brand;
    this.plate = plate;
    this.nif = nif;
    this.speed = speed;
    this.price = price;
    this.comsuption = comsuption;
    this.autonomy = autonomy;
    this.x = x;
    this.y = y;
    this.location = new Point2D();
    this.rating = 0;
    this.available = true;
    this.rentingHistory = new TreeSet<Ride>();
  }
  
  /** 
  * Construtor de cópia que cria uma nova instância Vehicle a partir de um Vehicle passado como parâmetro 
  **/  
  public Vehicle(Vehicle v)
  {
    this.type = v.getType();
    this.brand = v.getBrand();
    this.plate = v.getPlate();
    this.nif = v.getNif();
    this.speed = v.getSpeed();
    this.price = v.getPrice();
    this.autonomy = v.getAutonomy();
    this.comsuption = v.getComsuption();
    this.x = v.getX();
    this.y = v.getY();
    this.location = v.getLocation();
    this.plate = v.getPlate();
    this.available = v.getAvailability();
    this.rating = v.getRating();
    this.rentingHistory = v.getRentingHistoryAll();
  }
    
  /**
  * Método que devolve o tipo de um veículo
  * @returns Tipo do veículo
  **/
  public String getType(){return this.type;}
  
  /**
  * Método que devolve a marca de um veículo
  * @returns Marca do veículo
  **/
  public String getBrand(){return this.brand;}
  
  /**
  * Método que devolve a velocidade média do veículo
  * @returns velocidade média do veículo
  **/
  public double getSpeed(){return this.speed;}
  
  /**
  * Método que devolve o nif de um veículo
  * @returns Nif do veículo
  **/
  public int getNif(){return this.nif;}
  
  /**
  * Método que devolve o tipo de um veículo
  * @returns Tipo do veículo
  **/
  public double getPrice(){return this.price;}
  
  /**
  * Método que devolve a autonomia de um veículo
  * @returns Autonomia do veículo
  **/
  public double getAutonomy(){return this.autonomy;}
  
  /**
  * Método que devolve o consumo de um veículo
  * @returns Consumo do veículo
  **/
  public double getComsuption(){return this.comsuption;}
  
  /**
  * Método que devolve o a coordenada X do veículo
  * @returns Coordenada X do cliente
  **/
  public double getX(){return this.x;}
  
  /**
  * Método que devolve o a coordenada Y do veículo
  * @returns Coordenada Y do cliente
  **/
  public double getY(){return this.y;}
  
  /**
  * Método que devolve a classificação de um veículo
  * @returns Tipo do veículo
  **/
  public int getRating(){return this.rating;}
  
  /**
  * Método que devolve a matricula de um veículo
  * @returns Matricula do veículo
  **/
  public String getPlate(){return  this.plate;}
  
  /**
  * Método que devolve a disponibilidade de um veículo
  * @returns Disponibilidade do veículo
  **/
  public boolean getAvailability(){return this.available;} 
  
  /**
  * Método que devolve a localização de um veículo
  * @returns Localização do veículo
  **/
  public Point2D getLocation(){return this.location.clone();}
  
  /**
  * Método que devolve o deposito de um veículo
  * @returns Deposito do veículo
  **/
  public double getDeposit(){return this.deposit;}
   
  /**
  * Método que devolve o historico de alugueres de um veículo
  * @returns Historico de alugueres de um veículo
  **/
  public Set<Ride> getRentingHistoryAll()
  {
     Set<Ride> aux = new TreeSet<>();
     for(Ride rc: this.rentingHistory){aux.add(rc.clone());}
     return aux;
  }
  
  /**
  * Método que define o tipo de um veículo
  * @param Tipo do veículo
  **/
  public void setType(String newType){this.type = newType;}
  
  /**
  * Método que define a marca de um veículo
  * @param Marca do veículo
  **/
  public void setBrand(String newBrand){this.type = newBrand;}
  
  /**
  * Método que define a velocidade média de um veículo
  * @param Velocidade média do veículo
  **/
  public void setSpeed(double newS){this.speed = newS;}
  
  /**
  * Método que define o nif de um veículo
  * @param Nif do veículo
  **/
  public void setNif(int n){this.nif = n;}
  
  /**
  * Método que define o preço de um veículo
  * @param Preço do veículo
  **/
  public void setPrice(double newP){this.price = newP;}
  
  /**
  * Método que define a autonomia de um veículo
  * @param Autonomia do veículo
  **/
  public void setAutonomy(double newA){this.autonomy = newA;}
  
  /**
  * Método que define o consumo de um veículo
  * @param Consumo do veículo
  **/
  public void setComsuption(double newC){this.comsuption = newC;}
  
  /**
  * Método que define a matricula de um veículo
  * @param Matricula do veículo
  **/
  public void setPlate(String newPlate){this.plate = newPlate;}
  
  /**
  * Método que define a coordenada X da localização do veículo
  * @param Coordenada X da localização do veículo
  **/
  public void setX(double newX){this.x = newX;} 
  
  /**
  * Método que define a coordenada Y da localização do veículo
  * @param Coordenada Y da localização do veículo
  **/
  public void setY(double newY){this.y = newY;}
  
  /**
  * Método que define a disponibilidade do veículo
  * @param Disponibilidade do veículo
  **/
  public void setAvailability(boolean newAV){this.available = newAV;}
  
  /**
  * Método que define a localização do veículo
  * @param Localização do veículo
  **/
  public void setLocation(Point2D p){this.location = p.clone();}
  
  /**
  * Método que define o deposito do veículo
  * @param Deposito do veículo
  **/
  public void setDeposit(int d){this.deposit = d;}
  
  /**
  * Método que define a avaliação do veículo
  * @param Avaliação do veículo
  **/
  public void setRating(int newR)
  {
      int nr = (this.rating + newR)/(this.rentingHistory.size());
      this.rating = nr;
  }
  
  /**
  * Método que define o historico do veículo
  * @param Historico do veículo
  **/
  public void setRentingHistory(Set<Ride> rc)
  {
      this.rentingHistory.clear();
      for(Ride r: rc){this.rentingHistory.add(r.clone());}
  }
  
  /**
  * Método que adiciona um aluguer ao historico
  * @param Viagem realizada pelo veículop
  **/
  public void addRide(Ride r){this.rentingHistory.add(r.clone());}
  
   /**
  * Método que remove um aluguer ao historico
  * @param Viagem realizada pelo veículop
  **/
  public void removeRide(Ride r){this.rentingHistory.remove(r);}
   
   /**
  * Método que adiciona um conjunto de alugueres ao historico
  * @param Viagem realizada pelo veículop
  **/
  public void addSetRide(Set<Ride> h)
  {
      for(Ride r : h) this.rentingHistory.add(r.clone());
  }
  
  /** 
  * Método que cria uma cópia de uma identificação de um Vehicle
  **/
  public abstract Vehicle clone();  

  /** 
  * Método que testa se um objeto é igual a uma determinada identificação
  * @param      objeto a ser testado
  * @return     true se o objeto for igual à identificação, false se o objeto passado não for igual à identificação
  **/
  public boolean equals(Object o)
  {
      if(this == o) return true;
      if(o == null && this.getClass() != o.getClass()) return false;
      Vehicle v = (Vehicle) o;     
       return this.type == v.getType() &&
              this.brand == v.getBrand() &&
              this.plate == v.getPlate() &&
              this.nif == v.getNif() &&
              this.speed == v.getSpeed() &&
              this.price == v.getPrice() &&
              this.comsuption == v.getComsuption() &&
              this.autonomy == v.getAutonomy() &&
              this.location.equals(v.getLocation()) && 
              this.available == v.getAvailability() &&
              this.rating == v.getRating() &&
              this.deposit == v.getDeposit();             
  }
    
  /**
  * Método que converte uma identificação numa string
  * @return  string com a identificação do utilizador
  **/
  public String toString()
  {
      return "Tipo: " + this.type +
             "Marca: " + this.brand +
             "Matrícula: " + this.plate +
             "NIF : " + this.nif +
             "Velocidade média por km: " + speed +
             "Preço base por km: " + price +
             "Consumo de gasolina/bateria por km: " + comsuption +
             "Classificação: " + rating;           
  }
  
  
  /**
  * Método que calcula se a autonomia de um carro é superior a 10%
  * @return true caso a autonomia seja superior, false caso a autonomia seja inferior
  **/
  public boolean hasAutonomy10()
  {
    if(this.autonomy*this.comsuption <= 0.1*this.deposit)
        return false;
    else
        return true;
  }
  
  /**
  * Método que verifica se a autonomia de um carro é suficiente para realizar uma viagem
  * @param   kms a percorrer
  * @return  True se tiver autonomia suficiente, false caso contrário
  **/
  public boolean hasAutonomy(double kms){
      if(this.autonomy >= kms)
        return true;
      else
        return false;
    }
    
    
  /**
  * Método que calcula se a autonomia de um carro é a desejada
  * @return  True caso a autonomia seja igual à desejada, false caso a autonomia insuficiente
  **/
   public boolean desiredAutonomy(double autonomy)
   {
       if(this.autonomy == autonomy)
            return true;
       else 
            return false;
   }
  

  /**
  * Método que calcula se o carro está suficientemente perto para o cliente caminhar até ele
  * @param   Distancia que o cliente está disposto a andar
  * @param   Localização do veículo
  * @param   Localização do Cliente
  * @return  True caso o carro esteja suficientemente perto, false caso contrário
  **/
  public boolean isNear(double walk, Point2D localv, Point2D localc)
  {
       double d = localv.distanceTo(localc);
       if(walk <= d)
            return true;
       else
            return false;
  } 
}

