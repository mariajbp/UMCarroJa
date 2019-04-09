import java.io.Serializable;

public class NoClientsException extends Exception implements Serializable
{
    public NoClientsException()
    {
        super();
    }
    
    public NoClientsException(String message)
    {
        super(message);
    }
}

