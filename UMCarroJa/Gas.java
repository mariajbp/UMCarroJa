import java.io.Serializable;
/**
* Representação da classe Gas, subclasse de Vehicle
**/
public class Gas extends Vehicle implements Serializable 
{   
   /** Construtor vazio **/
    public Gas()
   { 
       super();
   }
   /** Construtor que cria um novo veiculo do tipo Gas a partir dos parâmetros dados **/
   public Gas(String type, String brand, String plate, int nif, double speed, double price, double comsuption, double autonomy, double x, double y)
   {
     super(type,brand,plate,nif,speed,price,comsuption,autonomy,x, y);
   }
   /** Construtor de cópia que cria uma nova instância do veículo a partir de um veículo passado como parâmetro **/
   public Gas(Gas g)
   {
       super(g.getType(), g.getBrand(),  g.getPlate(), g.getNif(), g.getSpeed(), g.getPrice(), g.getComsuption(), g.getAutonomy(), g.getX(), g.getY());
   }
   /** Método que cria uma cópia de um veículo **/
   public Gas clone()
   {
       Gas g = new Gas(this);
       return g;
   }
  
}
