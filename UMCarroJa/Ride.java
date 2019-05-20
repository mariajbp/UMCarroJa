import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
import java.lang.Comparable;
import java.io.Serializable;

public class Ride implements Comparable<Ride>, Serializable
{
    private String clemail;
    private LocalDateTime date;
    private Point2D start; 
    private Point2D destination;
    private double kms;
    private double time;             //tempo que a viagem demorou 
    private double realPrice;
    
    public Ride()
    {
        this.clemail = "ND";
        this.date = LocalDateTime.of(1,1,1,0,0);
        this.start = new Point2D();
        this.destination = new Point2D();
        this.kms = 0.0;
        this.time = 0.0;
        this.realPrice = 0.0;
    }
    
    public Ride(String cle, LocalDateTime t, Point2D p, Point2D d, double k, double time, double rp)
    {
        this.clemail = cle;
        this.date = t;
        this.start = new Point2D(p);
        this.destination = new Point2D(d);
        this.kms = k;
        this.time = time;
        this.realPrice = rp;
    }
    
    public Ride(Ride r)
    {
        this.clemail = r.getClEmail();
        this.date = r.getDate();
        this.start = r.getStart();
        this.destination = r.getDestination();
        this.kms = r.getKms();
        this.time = r.getTime();
        this.realPrice = r.getRealPrice();
    }

    public String getClEmail(){return this.clemail;}
    public void setClEmail(String cle){this.clemail = cle;}
    
    public LocalDateTime getDate(){return this.date;}    
    public void setData(LocalDateTime d){this.date = d;}
    
    public Point2D getStart(){return this.start.clone();}
    public void setStart(Point2D p){this.start = p.clone();}
    
    public Point2D getDestination(){return this.destination.clone();}
    public void setDestination(Point2D d){this.destination = d.clone();}
    
    public double getKms(){return this.kms;}
    public void setKms(double k){this.kms = k;}
    
    public double getTime(){return this.time;}
    public void setTime(double t){this.time = t;}
    
    public double getRealPrice(){return this.realPrice;}
    public void setRealPrice(double p){this.realPrice = p;}
    
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        
        sb.append("Data e Hora: ").append(this.date.toString()+"\n");
        sb.append("Cliente: ").append(this.clemail.toString()+"\n");
        sb.append("Partida: ").append(this.start.toString()+"\n");
        sb.append("Destino: ").append(this.destination.toString()+"\n");
        sb.append("Kms a viajar: ").append(this.kms+"\n");
        sb.append("Tempo da viagem: ").append(this.time+"\n");
        sb.append("Preco real da Viagem: ").append(this.realPrice+"\n");
        
        return sb.toString();
    }
    
    public Ride clone(){return new Ride(this);}
    
    public boolean equals(Object o)
    {
        if (this==o) return true;
        if((o==null) || (this.getClass() != o.getClass())) return false;
        
        Ride r = (Ride) o;
        return (this.clemail == r.getClEmail() &&
                this.date.equals(r.getDate()) && 
                this.start.equals(r.getStart()) && 
                this.destination.equals(r.getDestination()) && 
                this.kms == r.getKms() && 
                this.time == r.getTime() && 
                this.realPrice == r.getRealPrice());
    }
    
    public int compareTo(Ride r)
    {
        if(this.date.isAfter(r.getDate())) return 1;
        if(this.date.isBefore(r.getDate())) return -1;
        return 0;
    }
}
