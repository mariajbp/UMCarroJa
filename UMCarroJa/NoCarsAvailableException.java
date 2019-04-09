import java.io.Serializable;

public class NoCarsAvailableException extends Exception implements Serializable
{
    public NoCarsAvailableException()
    {
        super();
    }
    
    public NoCarsAvailableException(String message)
    {
        super(message);
    }
}
