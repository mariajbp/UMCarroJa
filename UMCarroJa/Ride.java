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
    
    /** Construtor vazio que cria uma instância Ride  **/
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
    /** Construtor que cria uma nova Ride a partir dos parâmetros dados **/
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
    /** Construtor de cópia que cria uma nova instância Ride a partir de uma Ride passado como parâmetro **/
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
    
    /************************* GETTERS *************************/
    public String getClEmail(){return this.clemail;}
    public LocalDateTime getDate(){return this.date;}    
    public Point2D getStart(){return this.start.clone();} 
    public Point2D getDestination(){return this.destination.clone();}
    public double getKms(){return this.kms;}
    public double getRealPrice(){return this.realPrice;}
    public double getTime(){return this.time;}
    
    /************************* SETTERS *************************/
    public void setClEmail(String cle){this.clemail = cle;}
    public void setData(LocalDateTime d){this.date = d;}
    public void setStart(Point2D p){this.start = p.clone();}
    public void setDestination(Point2D d){this.destination = d.clone();}
    public void setKms(double k){this.kms = k;}
    public void setTime(double t){this.time = t;}
    public void setRealPrice(double p){this.realPrice = p;}
    
     /************************* TOSTRING *************************/
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
    
    /************************* CLONE *************************/
    public Ride clone(){return new Ride(this);}
    
    /************************* EQUALS *************************/
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
    
    /**
    * Método que implementa um comparador de Ride através das datas
    * @param Ride r 
    **/
    public int compareTo(Ride r)
    {
        if(this.date.isAfter(r.getDate())) return 1;
        if(this.date.isBefore(r.getDate())) return -1;
        return 0;
    }
}
