import java.io.Serializable;

public class RegistrationException extends Exception implements Serializable
{
    public RegistrationException()
    {
        super();
    }
    
    public RegistrationException(String message)
    {
        super(message);
    }
}

