import java.io.Serializable;

/**
* Representação da classe Electric, subclasse de Vehicle
**/
public class Electric extends Vehicle implements Serializable 
{ 
  /** Construtor vazio **/
  public Electric()
  {
      super();
  }
  /** Construtor que cria um novo veiculo do tipo Electric a partir dos parâmetros dados **/
  public Electric(String type, String brand, String plate, int nif, double speed, double price, double comsuption, double autonomy, double x, double y)
  {
     super(type,brand,plate,nif,speed,price,comsuption,autonomy,x, y); 
  }
  /** Construtor de cópia que cria uma nova instância do veículo a partir de um veículo passado como parâmetro **/
  public Electric(Electric e)
  {
      super(e.getType(), e.getBrand(),  e.getPlate(), e.getNif(), e.getSpeed(), e.getPrice(), e.getComsuption(), e.getAutonomy(), e.getX(), e.getY());
  }
  /** Método que cria uma cópia de um veículo **/
  public Electric clone()
  {
    Electric e = new Electric(this);
    return e;
  }
}
