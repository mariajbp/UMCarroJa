import java.io.Serializable;

/**
* Classe UserExistException que devolve uma mensagem caso nenhum veiculo esteja disponivel de momento
**/
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