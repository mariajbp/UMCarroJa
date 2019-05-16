import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
import java.lang.Comparable;
import java.io.Serializable;

public class Ride implements Comparable<Ride>, Serializable
{
    private LocalDateTime date;
    private Point2D start; 
    private Point2D destination;
    private Vehicle v;
    private double kms;
    private double time; //tempo a viagem demorou 
    private double realPrice;
    private double estimatedPrice;
    
    public Ride()
    {
        this.date = LocalDateTime.of(1,1,1,0,0);
        this.start = new Point2D();
        this.destination = new Point2D();
        //this.v = new Vehicle(); ?
        this.kms = 0.0;
        this.time = 0.0;
        this.realPrice = 0.0;
        this.estimatedPrice = 0.0;
    }
    
    public Ride(LocalDate dt, LocalTime t, Point2D p, Point2D d, Vehicle v, double k, double time, double rp, double ep)
    {
        this.date = LocalDateTime.of(dt,t);
        this.start = new Point2D(p);
        this.destination = new Point2D(d);
        this.v = v.clone();
        this.kms = k;
        this.time = time;
        this.realPrice = rp;
        this.estimatedPrice = ep;
    }
    
    public Ride(Ride r)
    {
        this.date = r.getDate();
        this.start = r.getStart();
        this.destination = r.getDestination();
        this.v = r.getVehicle();
        this.kms = r.getKms();
        this.time = r.getTime();
        this.realPrice = r.getRealPrice();
        this.estimatedPrice = r.getEstimatedPrice();
    }

    public LocalDateTime getDate(){return this.date;}    
    public void setData(LocalDateTime d){this.date = d;}
    
    public Point2D getStart(){return this.start.clone();}
    public void setStart(Point2D p){this.start = p.clone();}
    
    public Point2D getDestination(){return this.destination.clone();}
    public void setDestination(Point2D d){this.destination = d.clone();}
   
    public Vehicle getVehicle(){return this.v.clone();}
    public void setVehicle(Vehicle v){this.v = v.clone();}
    
    public double getKms(){return this.kms;}
    public void setKms(double k){this.kms = k;}
    
    public double getTime(){return this.time;}
    public void setTime(double t){this.time = t;}
    
    public double getRealPrice(){return this.realPrice;}
    public void setRealPrice(double p){this.realPrice = p;}
    
    public double getEstimatedPrice(){return this.estimatedPrice;}
    public void setEstimatedPrice(double p){ this.estimatedPrice = p;}
    
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        
        sb.append("Data e Hora: ").append(this.date.toString()+"\n");
        sb.append("Partida: ").append(this.start.toString()+"\n");
        sb.append("Destino: ").append(this.destination.toString()+"\n");
        sb.append("Veiculo:\n").append(this.v.toString());
        sb.append("Kms a viajar: ").append(this.kms+"\n");
        sb.append("Tempo da viagem: ").append(this.time+"\n");
        sb.append("Preco real da Viagem: ").append(this.realPrice+"\n");
        sb.append("Preco estimado da Viagem: ").append(this.estimatedPrice+"\n");
        
        return sb.toString();
    }
    
    public Ride clone(){return new Ride(this);}
    
    public boolean equals(Object o)
    {
        if (this==o) return true;
        if((o==null) || (this.getClass() != o.getClass())) return false;
        
        Ride r = (Ride) o;
        return (this.date.equals(r.getDate()) && 
                this.start.equals(r.getStart()) && 
                this.destination.equals(r.getDestination()) && 
                this.v.equals(r.getVehicle()) && 
                this.kms == r.getKms() && 
                this.time == r.getTime() && 
                this.realPrice == r.getRealPrice() && 
                this.estimatedPrice == r.getEstimatedPrice());
    }
    
    public int compareTo(Ride r)
    {
        if(this.date.isAfter(r.getDate())) return 1;
        if(this.date.isBefore(r.getDate())) return -1;
        return 0;
    }
}
