import java.io.Serializable;

/**
* Representação da classe Hybrid, subclasse de Vehicle
**/
public class Hybrid extends Vehicle implements Serializable 
{
   /** Construtor vazio **/ 
   public Hybrid()
   {
       super();
   }
   /** Construtor que cria um novo veiculo do tipo Hybrid a partir dos parâmetros dados **/
   public Hybrid(String type, String brand, String plate, int nif, double speed, double price, double comsuption, double autonomy, double x, double y)
   {
      super(type,brand,plate,nif,speed,price,comsuption,autonomy,x, y);
   }
   /** Construtor de cópia que cria uma nova instância do veículo a partir de um veículo passado como parâmetro **/
   public Hybrid(Hybrid h)
   {
      super(h.getType(), h.getBrand(),  h.getPlate(), h.getNif(), h.getSpeed(), h.getPrice(), h.getComsuption(), h.getAutonomy(), h.getX(), h.getY());
   }
   /** Método que cria uma cópia de um veículo **/
   public  Hybrid clone()
   {
      Hybrid h = new Hybrid(this);
      return h;
   }
}
