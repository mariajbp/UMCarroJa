import java.util.Comparator;

/**
* Classe ClientComparatorX que impõem uma ordem quando se quer adicionar um cliente a uma coleção
**/
public class ClientComparatorX implements Comparator<Client>
{
    public int compare(Client c1, Client c2)
    {
        int x1 = orderX(c1);
        int x2 =  orderX(c2);
        
        if(x1 >= x2) return -1;
        return 1;
    }
    
    //Método que calcula o número de viagens de um cliente
    public int orderX(Client c)
    {
        int total = 0;
        for(RentedCar rc : c.getRentingHistoryAll())
        {
            total++;
        }
        return total;
    } 
}
