import java.io.Serializable;

/**
* Classe VehicleDoesntExistException que devolve uma mensagem caso nenhum veiculo esteja disponivel de momento
**/
public class VehicleDoesntExistException extends Exception implements Serializable
{
    public VehicleDoesntExistException()
    {
        super();
    }
    
    public VehicleDoesntExistException(String message)
    {
        super(message);
    }
}


