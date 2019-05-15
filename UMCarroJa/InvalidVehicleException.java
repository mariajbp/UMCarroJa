import java.io.Serializable;

public class InvalidVehicleException extends Exception implements Serializable
{
    public InvalidVehicleException()
    {
        super();
    }
    
    public InvalidVehicleException(String message)
    {
        super(message);
    }
}

