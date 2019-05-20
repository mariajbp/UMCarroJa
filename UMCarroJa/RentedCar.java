    import java.util.*;
    import java.io.Serializable;
    import java.time.LocalDateTime;
    
    /**
    * Representação das carateristicas basicas de um aluguer 
    **/
    
    public class RentedCar implements Serializable
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
         
     /** Construtor vazio que cria uma instância RentedCar  **/
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
     /** Construtor que cria um novo RentedCar a partir dos parâmetros dados **/
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
     
     /**gets**/
     public String getOwnerEmail(){return this.ownerEmail;}
     public String getClientEmail(){return this.clientEmail;}
     public Vehicle getCar(){return this.car;}
     public double getPrice(){return this.price;}
     public Point2D getStart() {return this.start;}
     public Point2D getDestination() {return this.destination;}
     public double getAutonomy() {return this.autonomy;}
     public double getExpectedTime() {return this.time;}
     public LocalDateTime getDate() {return this.date;}
     public double getKms() {return this.kms;}
     

     /**sets**/
     public void setOwnerEmail(String ownerEmail) {this.ownerEmail = ownerEmail;}
     public void setClientEmail(String clientEmail) {this.clientEmail = clientEmail;}
     public void setCAR(Vehicle car) {this.car = car;}
     public void setPrice(double price) {this.price = price;}
     public void setStart(Point2D start) {this.start = start;}
     public void setDestination(Point2D destination) {this.destination = destination;}
     public void setAutonomy(double autonomy) {this.autonomy = autonomy;}
     public void setExpectedTime(double time) {this.time = time;}
     public void setDate(LocalDateTime date){this.date = date;}
     public void setKms(double kms){this.kms = kms;}
     
     /**Equals**/
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
     
     /***Clone***/
     public RentedCar clone()
     {
        RentedCar r = new RentedCar(this);
        return r;
     }
    
     
     /**toString**/
     public String toString()
     {
         return "Email do Proprietário: " + this.ownerEmail +
                "Email do Cliente: " + this.clientEmail +
                "Carro: " + this.car + 
                "Preço: " + this.price + 
                "Ponto inicial: " + this.start + 
                "Destino: " + this.destination +
                "Distância: " + this.kms +
                "Autonomia: " + this.autonomy + 
                "Tempo previsto: " + this.time +
                "Data: " + this.date ;
     }
  
  
  
}
