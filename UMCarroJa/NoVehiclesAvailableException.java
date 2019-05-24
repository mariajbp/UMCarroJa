import java.io.Serializable;

/**
* Classe NoVehiclesAvailableException que devolve uma mensagem caso nenhum veiculo esteja disponivel de momento
**/
public class NoVehiclesAvailableException extends Exception implements Serializable
{
    public NoVehiclesAvailableException()
    {
        super();
    }
    
    public NoVehiclesAvailableException(String message)
    {
        super(message);
    }
}
