import java.io.Serializable;

/**
* Classe RegistrationException que devolve uma mensagem caso nenhum veiculo esteja disponivel de momento
**/
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

