import java.io.Serializable; 

/**
* Representação de um viagem
**/
public class Ride implements Serializable
{
    private Vehicle vehicle;
    private Owner owner;
    private Client client;
    // private RentedCar trip;
    private Point2D location;
    private boolean available;
    private double totalProfit;
     
    public Ride(Vehicle vehicle,Owner owner, Client client, Point2D location,/** RentedCar trip,**/ boolean available, double totalProfit)
    {
        this.vehicle = vehicle;
        this.owner = owner;
        this.client = client;
        this.location = location;
        //this.trip = new RentedCar();
        this.available = available;
        this.totalProfit = totalProfit;
    }
    
    public Ride(Ride r)
    {
        this.vehicle = r.getVehicle();
        this.owner = r.getOwner();
        this.client = r.getClient();
        this.location = r.getLocation();
        //TRIP
        this.available = r.isAvailable();
        this.totalProfit = r.getTotalProfit();
    }

    /************************* GETTERS *************************/
    public Vehicle getVehicle(){return this.vehicle;}
    public Owner getOwner(){return this.owner;}
    public Client getClient(){return this.client;}
    public Point2D getLocation(){return this.location;}
    //trip
    public boolean isAvailable(){return this.available;}
    public double getTotalProfit(){return this.totalProfit;}
    
     /************************* SETTERS *************************/
    public void setVehicle(Vehicle v){this.vehicle = v.clone();}
    public void setOwner(Owner o){this.owner = o.clone();} 
    public void setClient(Client c){this.client = c.clone();} 
    //trip
    //availability
    public void setTotalProfit(double money){this.totalProfit += money;}
     
   
    /**Outros métodos**/
    public void chargeClient(Client c, double price)
    {
        c.spentMoney(price);  
        this.totalProfit += price;
    }
    
    
    
    
    /**CLONE**/
    public Ride clone()
    {
        Ride r = new Ride(this.getVehicle(), this.getOwner(), this.getClient(),this.getLocation(), this.isAvailable(), this.getTotalProfit());
        return r;
    }

    public String toString() //ADICIONAR O TIPO DO CARRO
    {
        return "-- O carro: " + this.vehicle.getPlate() + 
               "do proprietário " + this.owner.toString() + 
               "\nOcupado? " + this.availableToString() + 
               ".\n ----------------------------";
    }
     
    /**ToString**/
    public String availableToString()
    {
        String available;
        if(this.available==true) available = "Sim";
        else available = "Não";
        return available;
    }
     
     
     
     /** o cliente indica as coordenadas x e y em que se encontra e para
     * onde se pretende deslocar;
     */ 
       
       
     /** o cliente decide qual carro pretende alugar (de acordo com as 
     * possibilidades oferecida pela aplicação e descritas anteriormente);
     */
     
     
     /** De seguida é indicado ao cliente se o carro pretendido tem 
     autonomia para efectuar a viagem, e caso o tenha, é indicado o custo 
     estimado da viagem, tendo em conta o deslocamento que é necessário 
     efectuar; */
        
        
     /** Caso o veículo tenha autonomia, o proprietário é notficado do 
     *pedido de aluguer e do tempo que o cliente demora a chegar a pé 
     *ao veiculo. O proprietário poderá aceitar ou não o pedido de 
     *aluguer.*/
    
        
     /**de acordo com a 􏰀abilidade do carro (e de outros factores que pode considerar: 
     * a destreza do condutor, as condições meteorológicas, etc.) é calculado o tempo 
     *real da viagem.*/
     
     /**o carro fica no ponto definido como fim da viagem à espera de novo aluguer*/
     //No final da viagem fazer update da localização do carro = destino dado pelo cliente
     
     /** após a viagem o cliente e o proprietário podem dar uma avaliação ao carro ao cliente,
      *  e 􏰀cam com o registo relativo à viagem guardado nas suas áreas pessoais.
      */
}
