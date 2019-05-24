import java.io.Serializable;

/**
* Classe UserDoesntExistException que devolve uma mensagem caso nenhum veiculo esteja disponivel de momento
**/
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
