import java.io.Serializable;

public class UserDoesntExistException extends Exception implements Serializable
{
    public UserDoesntExistException()
    {
        super();
    }
    
    public UserDoesntExistException(String message)
    {
        super(message);
    }
}
