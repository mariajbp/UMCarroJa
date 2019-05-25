    import java.util.*;
    import java.io.Serializable;
    import java.time.LocalDateTime;
    
    /**
    * Representação das carateristicas basicas de um aluguer 
    **/
    
    public class RentedCar implements Comparable<RentedCar>, Serializable
    {
       private String ownerEmail;
       private String clientEmail;
       private Vehicle car;
       private double price;             //Preço real da viagem
       private Point2D start;
       private Point2D destination;
       private double autonomy;          //Autonomia usada pra viagem
       private double time;              //Tempo que durou 
       private LocalDateTime date;
       private double kms;
         
     /** 
     * Construtor vazio que cria uma instância RentedCar  
     **/
     public RentedCar(String ownerEmail, String clientEmail, Vehicle car, double price, Point2D destination, Point2D start, 
                    double autonomy, double time, LocalDateTime date, double kms)
     {
         this.ownerEmail = ownerEmail;
         this.clientEmail = clientEmail;
         this.car = car;
         this.price = price;
         this.start = start;
         this.destination = destination;
         this.autonomy = autonomy;
         this.time = time;
         this.date = date;
         this.kms = kms;
     }
     
     /** 
     * Construtor que cria um novo RentedCar a partir dos parâmetros dados 
     **/
     public RentedCar(RentedCar r)
     {
         this.ownerEmail = r.getOwnerEmail();
         this.clientEmail = r.getClientEmail();
         this.car = r.getCar();
         this.price = r.getPrice();
         this.start = r.getStart();
         this.destination = r.getDestination();
         this.autonomy = r.getAutonomy();
         this.time = r.getExpectedTime();
         this.date = r.getDate();
         this.kms = r.getKms();
     }
     
     /**
     * Método que devolve o email de um proprietário
     * @return  Email do proprietário
     **/
     public String getOwnerEmail(){return this.ownerEmail;}
     
     /**
     * Método que devolve o email de um cliente
     * @return  Email do cliente
     **/
     public String getClientEmail(){return this.clientEmail;}
     
     /**
     * Método que devolve o carro que foi alugado
     * @return  Carro que foi alugado
     **/
     public Vehicle getCar(){return this.car;}
     
     /**
     * Método que devolve o preço real da viagem
     * @return  Preço real da viagem
     **/
     public double getPrice(){return this.price;}
     
     /**
     * Método que devolve o tempo real que durou da viagem
     * @return  Tempo real que durou da viagem
     **/
     public Point2D getStart() {return this.start;}
     
     /**
     * Método que devolve a localização do destino da viagem
     * @return  Localização do destino da viagem
     **/
     public Point2D getDestination() {return this.destination;}
     
     /**
     * Método que devolve a autonomia do veículo
     * @return  Autonomia do veículo
     **/
     public double getAutonomy() {return this.autonomy;}
     
     /**
     * Método que devolve o tempo esperado da duração viagem
     * @return  Tempo esperado da duração viagem
     **/
     public double getExpectedTime() {return this.time;}
     
     /**
     * Método que devolve a data da viagem
     * @return  Data da viagem
     **/
     public LocalDateTime getDate() {return this.date;}
     
     /**
     * Método que devolve o numero de kms percorridos na viagem
     * @return  Numero de kms percorridos na viagem
     **/
     public double getKms() {return this.kms;}
     

     /**
     * Método que define o email de um proprietário
     * @return  Email do proprietário
     **/
     public void setOwnerEmail(String ownerEmail) {this.ownerEmail = ownerEmail;}
     
     /**
     * Método que define o email de um cliente
     * @return  Email do cliente
     **/
     public void setClientEmail(String clientEmail) {this.clientEmail = clientEmail;}
     
     /**
     * Método que define o carro que foi alugado
     * @return Carro que foi alugado
     **/
     public void setCAR(Vehicle car) {this.car = car;}
     
     /**
     * Método que define o preço real que durou da viagem
     * @return  Preço real que durou da viagem
     **/
     public void setPrice(double price) {this.price = price;}
     
     /**
     * Método que define a localização do destino da viagem
     * @return  Localização do inicio da viagem
     **/
     public void setStart(Point2D start) {this.start = start;}
     
     /**
     * Método que define a localização do destino da viagem
     * @return  Localização do destino da viagem
     **/
     public void setDestination(Point2D destination) {this.destination = destination;}
     
     /**
     * Método que define a autonomia do veículo
     * @return  Autonomia do veículo
     **/
     public void setAutonomy(double autonomy) {this.autonomy = autonomy;}
     
     /**
     * Método que define o tempo esperado da duração viagem
     * @return  Tempo esperado da duração viagem
     **/
     public void setExpectedTime(double time) {this.time = time;}
     
     /**
     * Método que devolve a data da viagem
     * @return  Data da viagem
     **/
     public void setDate(LocalDateTime date){this.date = date;}
     
     /**
     * Método que define o numero de kms percorridos na viagem
     * @return  Numero de kms percorridos na viagem
     **/
     public void setKms(double kms){this.kms = kms;}
     
     /** 
     * Método que testa se um objeto é igual a uma determinada identificação
     * @param      Objeto a ser testado
     * @return     True se o objeto for igual à identificação, false se o objeto passado não for igual à identificação
     **/
     public boolean equals(Object o)
     {
        if(o == this) return true;
        if(o != null && this.getClass() != o.getClass()) return false;
        RentedCar r = (RentedCar) o;
        return this.ownerEmail == r.getOwnerEmail() &&
               this.clientEmail == r.getClientEmail() &&
               this.car == r.getCar() &&
               this.price == r.getPrice() &&
               this.start == r.getStart() &&
               this.destination == r.getDestination() &&
               this.autonomy == r.getAutonomy() &&
               this.time == r.getExpectedTime() &&
               this.date  == r.getDate() &&
               this.kms == r.getKms();
               
     }
     
     /** 
     * Método que cria uma cópia de uma identificação de um USER
     **/
     public RentedCar clone()
     {
        RentedCar r = new RentedCar(this);
        return r;
     }
    
     
     /**
     * Método que converte uma identificação numa string
     * @return  String com a identificação do utilizador
     **/
     public String toString()
     {
         StringBuilder sb = new StringBuilder();
         
         sb.append("Email do Proprietário: ").append(this.ownerEmail).append("\n");
         sb.append("Email do Cliente: ").append(this.clientEmail).append("\n");
         sb.append("Carro: ").append(this.car).append("\n");
         sb.append("Preço: ").append(this.price).append("\n");
         sb.append("Ponto inicial: ").append(this.start).append("\n");
         sb.append("Destino: ").append(this.destination).append("\n");
         sb.append("Distância: ").append(this.kms).append("\n");
         sb.append("Autonomia: ").append(this.autonomy).append("\n");
         sb.append("Tempo previsto: ").append(this.time).append("\n");
         sb.append("Data: ").append(this.date);
         
         return sb.toString();
     }
     
     /**
    * Método que implementa um comparador de RentedCar através das datas
    * @param RentedCar r 
    **/
    public int compareTo(RentedCar r)
    {
        if(this.date.isAfter(r.getDate())) return 1;
        if(this.date.isBefore(r.getDate())) return -1;
        return 0;
    }
}
