import java.io.Serializable;

/**
* Classe VehicletExistException que devolve uma mensagem caso nenhum veiculo esteja disponivel de momento
**/
public class VehicleExistsException extends Exception implements Serializable
{
    public VehicleExistsException()
    {
        super();
    }
    
    public VehicleExistsException(String message)
    {
        super(message);
    }
}

