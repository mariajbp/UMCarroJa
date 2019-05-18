import java.util.Comparator;

public class VehicleOrderP implements Comparator<Vehicle>
{
    public int compare(Vehicle v1, Vehicle v2)
    {
        double p1 = v1.getPrice();
        double p2 = v2.getPrice();
        
        if(p1 >= p2) return -1;
        return 1;
    }
}

