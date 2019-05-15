import java.io.Serializable;

public class LoginException extends Exception implements Serializable
{
    public LoginException()
    {
        super();
    }
    
    public LoginException(String message)
    {
        super(message);
    }
}
