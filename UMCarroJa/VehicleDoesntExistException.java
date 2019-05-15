import java.io.Serializable;

public class VehicleDoesntExistException extends Exception implements Serializable
{
    public VehicleDoesntExistException()
    {
        super();
    }
    
    public VehicleDoesntExistException(String message)
    {
        super(message);
    }
}


