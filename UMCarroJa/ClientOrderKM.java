import java.util.Comparator;

public class ClientOrderKM implements Comparator<Client>
{
    public int compare(Client c1, Client c2)
    {
        double x1 = c1.totalKms();
        double x2 =  c2.totalKms();
        
        if(x1 >= x2) return -1;
        return 1;
    }
   
}
