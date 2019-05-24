import java.io.Serializable;

/**
* Classe InvalidVehicleException que devolve uma mensagem caso nenhum veiculo esteja disponivel de momento
**/
public class InvalidVehicleException extends Exception implements Serializable
{
    public InvalidVehicleException()
    {
        super();
    }
    
    public InvalidVehicleException(String message)
    {
        super(message);
    }
}

