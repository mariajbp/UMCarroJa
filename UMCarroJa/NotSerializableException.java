//TALVEZ NAO SEJA PRECISA

import java.io.Serializable;

public class NotSerializableException extends Exception implements Serializable
{
    public NotSerializableException()
    {
        super();
    }
    
    public NotSerializableException(String message)
    {
        super(message);
    }
}
