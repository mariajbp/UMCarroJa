import java.util.*;
import java.io.Serializable;

/**
* Representação das carateristicas basicas de um aluguer 
**/

public class RentedCar implements Serializable
{
      private String ownerEmail;
      private String clientEmail;
      private Vehicle car;
      private double price;
      private Point2D start;
      private Point2D destination;
      private double distance;
      private double autonomy; 
      private double walktime;
      private double expectedtime;
      
     
     public RentedCar(String ownerEmail, String clientEmail, Vehicle car, double price, Point2D destination, Point2D start, double distance, 
                    double autonomy, double walktime, double expectedtime)
     {
         this.ownerEmail = ownerEmail;
     }

     public RentedCar(RentedCar r)
     {
         this.ownerEmail = r.getOwnerEmail();
         this.clientEmail = r.getClientEmail();
         this.car = r.getCar();
         this.price = r.getPrice();
         this.start = r.getStart();
         this.destination = r.getDestination();
         this.distance = r.getDistance();
         this.autonomy = r.getAutonomy();
         this.walktime = r.getWalkTime();
         this.expectedtime = r.getExpectedTime();
     }
     
     /**gets**/
     public String getOwnerEmail(){return this.ownerEmail;}
     public String getClientEmail(){return this.clientEmail;}
     public Vehicle getCar(){return this.car;}
     public double getPrice(){return this.price;}
     public Point2D getStart() {return this.start;}
     public Point2D getDestination() {return this.destination;}
     public double getDistance() {return this.distance;}
     public double getAutonomy() {return this.autonomy;}
     public double getWalkTime() {return this.walktime;}
     public double getExpectedTime() {return this.expectedtime;}
     

     /**sets**/
     public void setOwnerEmail(String ownerEmail) {this.ownerEmail = ownerEmail;}
     public void setClientEmail(String clientEmail) {this.clientEmail = clientEmail;}
     public void setCAR(Vehicle car) {this.car = car;}
     public void setPrice(double price) {this.price = price;}
     public void setStart(Point2D start) {this.start = start;}
     public void setDestination(Point2D destination) {this.destination = destination;}
     public void setDistance(double distance) {this.distance = distance;}
     public void setAutonomy(double autonomy) {this.autonomy = autonomy;}
     public void setWalkTime(double walktime) {this.walktime = walktime;}
     public void setExpectedTime(double expectedtime) {this.expectedtime = expectedtime;}
     
     
     
     
     
     /***Clone***/
     public RentedCar clone()
     {
        RentedCar r = new RentedCar(this.getOwnerEmail(), this.getClientEmail(), this.getCar(),this.getPrice(), this.getStart(), 
                                    this.getDestination(), this.getDistance(), this.getAutonomy(), this.getWalkTime(), this.getExpectedTime());
        return r;
     }
    
      
  
  
  
}
