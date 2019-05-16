import java.util.Comparator;

public class ClientOrderKM
{
    public int compare(Client c1, Client c2)
    {
        int x1 = orderKM(c1);
        int x2 =  orderKM(c2);
        
        if(x1 >= x2) return -1;
        return 1;
    }
    
    //Método que calcula o número de km que um cliente viajou
    public int orderKM(Client c)
    {
        int total = 0;
        for(RentedCar rc : c.getRentingHistory())
        {
            total++;
        }
        return total;
    } 
}
