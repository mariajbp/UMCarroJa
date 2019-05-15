import java.io.Serializable;

public class NoVehiclesAvailableException extends Exception implements Serializable
{
    public NoVehiclesAvailableException()
    {
        super();
    }
    
    public NoVehiclesAvailableException(String message)
    {
        super(message);
    }
}
