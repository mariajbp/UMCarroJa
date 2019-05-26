import java.time.LocalDateTime;
import java.lang.Comparable;
import java.io.Serializable;

/**
* Representação das carateristicas basicas de uma viagem num carro alugado
**/
public class Ride implements Comparable<Ride>, Serializable
{
    private String clemail;
    private LocalDateTime date;
    private Point2D start; 
    private Point2D destination;
    private double kms;
    private double time;             //tempo que a viagem demorou 
    private double realPrice;
    
    /** 
    * Construtor vazio que cria uma instância Ride  
    **/
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
    
    /** 
    * Construtor que cria uma nova Ride a partir dos parâmetros dados 
    **/
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
    
    /**
    * Método que devolve o email de um cliente
    * @return Email do cliente
    **/
    public String getClEmail(){return this.clemail;}
    
    /**
    * Método que devolve a data da viagem
    * @return Data da viagem
    **/
    public LocalDateTime getDate(){return this.date;} 
    
    /**
    * Método que devolve a localização do inicio da viagem
    * @return Localização do inicio da viagem
    **/
    public Point2D getStart(){return this.start.clone();} 
    
    /**
    * Método que devolve a localização do destino da viagem
    * @return Localização do destino da viagem
    **/
    public Point2D getDestination(){return this.destination.clone();}
    
    /**
    * Método que devolve o numero de kms percorridos na viagem
    * @return Numero de kms percorridos na viagem
    **/
    public double getKms(){return this.kms;}
    
    /**
    * Método que devolve o preço real da viagem
    * @return Preço real da viagem
    **/
    public double getRealPrice(){return this.realPrice;}
    
    /**
    * Método que devolve o tempo real que durou da viagem
    * @return Tempo real que durou da viagem
    **/
    public double getTime(){return this.time;}
    
    /**
    * Método que devolve o email de um cliente
    * @return Email do cliente
    **/
    public void setClEmail(String cle){this.clemail = cle;}
    
    /**
    * Método que devolve a data da viagem
    * @return Data da viagem
    **/
    public void setData(LocalDateTime d){this.date = d;}
    
    
    /**
    * Método que define a localização do destino da viagem
    * @return Localização do inicio da viagem
    **/
    public void setStart(Point2D p){this.start = p.clone();}
    
    /**
    * Método que define a localização do destino da viagem
    * @return Localização do destino da viagem
    **/
    public void setDestination(Point2D d){this.destination = d.clone();}
    
    /**
    * Método que define o numero de kms percorridos na viagem
    * @return Numero de kms percorridos na viagem
    **/
    public void setKms(double k){this.kms = k;}
    
    /**
    * Método que define o preço real da viagem
    * @return Preço real da viagem
    **/
    public void setTime(double t){this.time = t;}
    
    /**
    * Método que define o tempo real que durou da viagem
    * @return Tempo real que durou da viagem
    **/
    public void setRealPrice(double p){this.realPrice = p;}
    
    /**
    * Método que converte uma identificação numa string
    * @return  string com a identificação do utilizador
    **/
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
    
    /** 
    * Método que cria uma cópia de uma identificação de um USER
    **/
    public Ride clone(){return new Ride(this);}
    
    /** 
    * Método que testa se um objeto é igual a uma determinada identificação
    * @param      objeto a ser testado
    * @return     true se o objeto for igual à identificação, false se o objeto passado não for igual à identificação
    **/
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
