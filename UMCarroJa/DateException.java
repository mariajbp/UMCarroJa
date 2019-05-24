import java.io.Serializable;

/**
* Classe DateException que devolve uma mensagem caso nenhum veiculo esteja disponivel de momento
**/
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
