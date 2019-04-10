import java.io.Serializable;

public class NoOwnersException extends Exception implements Serializable
{
    public NoOwnersException()
    {
        super();
    }
    
    public NoOwnersException(String message)
    {
        super(message);
    }
}
