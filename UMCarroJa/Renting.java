import java.io.Serializable; 
/**
 * 
 */
public class Renting implements Serializable
{
     private double price;
     private Point2D start;
     private Point2D destination;
     private double distance;
     private double autonomy;
     private double walktime;
     private double expectime;
    
     /** o cliente indica as coordenadas x e y em que se encontra e para
     * onde se pretende deslocar;
     */ 
       
       
     /** o cliente decide qual carro pretende alugar (de acordo com as 
     * possibilidades oferecida pela aplicação e descritas anteriormente);
     */
     
     
     /** De seguida é indicado ao cliente se o carro pretendido tem 
     autonomia para efectuar a viagem, e caso o tenha, é indicado o custo 
     estimado da viagem, tendo em conta o deslocamento que é necessário 
     efectuar; */
        
        
     /** Caso o veículo tenha autonomia, o proprietário é notficado do 
     *pedido de aluguer e do tempo que o cliente demora a chegar a pé 
     *ao veiculo. O proprietário poderá aceitar ou não o pedido de 
     *aluguer.*/
    
        
     /**de acordo com a 􏰀abilidade do carro (e de outros factores que pode considerar: 
     * a destreza do condutor, as condições meteorológicas, etc.) é calculado o tempo 
     *real da viagem.*/
     
     /**o carro fica no ponto definido como fim da viagem à espera de novo aluguer*/
     //No final da viagem fazer update da localização do carro = destino dado pelo cliente
     
     /** após a viagem o cliente e o proprietário podem dar uma avaliação ao carro ao cliente,
      *  e 􏰀cam com o registo relativo à viagem guardado nas suas áreas pessoais.
      */
}
