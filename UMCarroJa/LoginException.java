import java.io.Serializable;

/**
* Classe LoginException que devolve uma mensagem caso nenhum veiculo esteja disponivel de momento
**/
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
