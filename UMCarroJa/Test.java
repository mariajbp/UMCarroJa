import java.util.*;
import java.io.Serializable;

/**
* 


public class Test implements Serializable
{
   public Test(UMCarroJa umcj)
   {
       umcj.setNVehicles(15);
       
       Client client1, client2, client3, client4, client5, client6, client7, client8,client9, client10, client12, client13, client14, client15;
       client1 = new Client("client1@gmail.com","client1","pass1", "casa1","27-10-98", 4, 0);
       client2 = new Client("client2@gmail.com","client2","pass2", "casa2","28-10-98", 2, 20);

       try
       {
          umcj.addClient(client1);
          umcj.addClient(client2);
          //umcj.addClient(client3);
       } catch (UserExistsException e) {System.out.println("Erro ao carregar os clientes");}
       
       Owner owner1, owner2, owner3, owner4, owner5, owner6, owner7, owner8, owner9, owner10, owner11, owner12, owner13, owner14,owner15;
       owner1 = new Owner("mailO1@gmail.com","owner1","querty1","casa o1", "01-01-1995 ", 56.5);
       owner2 = new Owner("mailO2@gmail.com","owner2","querty2","casa o2", "05-02-1990 ", 12.4);
       owner3 = new Owner("mailO3@gmail.com","owner3","querty3","casa o3", "01-4-1994 ", 51.2);
       
       try
       {
          umcj.addOwner(owner1);
          umcj.addOwner(owner1);
          //umcj.addClient(client3);
       } catch (UserExistsException e) {System.out.println("Erro ao carregar os proprietários");}
       
       Hybrid h1, h2, h3, h4, h5;
       // h1 = new Hybrid(100,5,60,1.0,8,0,"plate");
       Electric e1, e2, e3, e4, e5;
       //e1 = new Electric(150,40,20, location,9,54,"plate");
       Gas g1, g2,g3, g4,g5;
       //g1 = new Gas(130,15,68, location,4,95,"plate");

       /**
       try
       {
          //umcj.addVehicle(h1);
          //umcj.addVehicle(e1);
          //umcj.addVehicle(g1);
       } catch(VehicleExistsException e){System.out.println("Erro ao carregar os veiculos");}
       
   }
} **/
