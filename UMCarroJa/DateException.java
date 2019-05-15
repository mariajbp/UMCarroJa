import java.io.Serializable;

public class DateException extends Exception implements Serializable
{
    public DateException()
    {
        super();
    }
    
    public DateException(String message)
    {
        super(message);
    }
}
