import java.util.Comparator;

public class VehicleOrderA implements Comparator<Vehicle>
{
    public int compare(Vehicle v1, Vehicle v2)
    {
        double a1 = v1.getAutonomy();
        double a2 = v2.getAutonomy();
        
        if(a1 >= a2) return -1;
        return 1;
    }
}

