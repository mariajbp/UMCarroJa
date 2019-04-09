import java.io.Serializable;

public class EmailExistsException extends Exception implements Serializable
{
    public EmailExistsException()
    {
        super();
    }
    
    public EmailExistsException(String message)
    {
        super(message);
    }
}
