import java.util.*;
import java.io.Serializable;

public class Test implements Serializable
{
   public Test(UMCarroJa umcj)
   {
       Client client1;
       client1 = new Client("cliente1@email.com","cliente 1","password1", "endereço 1","01-01-98", 4, 90);
       
       Hybrid h1;
       h1 = new Hybrid(120,10,5,89);
       
       Electric e1;
       e1 = new Electric(80,5,2,45, "Electricity");
       
       Gas g1;
       g1 = new Gas(12,34,4,24);
       
       
   }
}
