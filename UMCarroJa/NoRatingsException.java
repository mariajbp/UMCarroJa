import java.io.Serializable;

public class NoRatingsException extends Exception implements Serializable
{
    public NoRatingsException()
    {
        super();
    }
    
    public NoRatingsException(String message)
    {
        super(message);
    } 
}
