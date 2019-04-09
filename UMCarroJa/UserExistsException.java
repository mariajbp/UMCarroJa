import java.io.Serializable;

public class UserExistsException extends Exception implements Serializable
{
    public UserExistsException()
    {
        super();
    }
    
    public UserExistsException(String message)
    {
        super(message);
    }
}