import java.util.Comparator;

/**
* Classe VehicleComparatorA que impõem uma ordem quando se quer adicionar um veículo a uma coleção
**/
public class VehicleComparatorA implements Comparator<Vehicle>
{
    public int compare(Vehicle v1, Vehicle v2)
    {
        double a1 = v1.getAutonomy();
        double a2 = v2.getAutonomy();
        
        if(a1 >= a2) return -1;
        return 1;
    }
}

