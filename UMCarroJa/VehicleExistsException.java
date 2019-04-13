import java.io.Serializable;

public class VehicleExistsException extends Exception implements Serializable
{
    public VehicleExistsException()
    {
        super();
    }
    
    public VehicleExistsException(String message)
    {
        super(message);
    }
}

