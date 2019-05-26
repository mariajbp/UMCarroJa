import java.lang.Math;
import java.io.Serializable;

/**
* Classe que representa um ponto, pertende exprimir a localização das entidades da aplicação
**/
public class Point2D implements Serializable
{
  /** Coordenada x do espaço **/
  private double x;
  
  /** Coordenada x do espaço **/
  private double y;
  
  /**
  * Construtor vazio que cria o ponto (0,0)
  **/
  public Point2D()
  {
    this(0.0,0.0);
  }
  
  /**
  * Construtor que cria um ponto a partir de parâmetros dados
  * @param Coordenada x do ponto
  * @param Coordenada y do ponto
  **/
  public Point2D(double x, double y)
  {
    this.x = x;
    this.y = y;
  }
  
  /**
  * Construtor que cria um novo ponto a partir de um ponto passado como parâmetro 
  * @param ponto do espaço xOy
  */
  public Point2D(Point2D p)
  {
    this.x = p.getX();
    this.y = p.getY();
  }
  
  /** 
  * Método que devolve a coordenada x de um ponto
  * @return  coordenada x do ponto
  **/
  public double getX(){return this.x;}
  
  /** 
  * Método que devolve a coordenada x de um ponto
  * @return  coordenada y do ponto
  **/
  public double getY(){return this.y;}
  
  /** 
  * Método que define a coordenada x de um ponto a partir de um double recebido como parâmetro
  * @return  coordenada x do ponto
  **/
  public void setX(int newX){this.x = newX;}
  
  /** 
  * Método que define a coordenada y de um ponto a partir de um double recebido como parâmetro
  * @return  coordenada y do ponto
  **/
  public void setY(int newY){this.y = newY;}

  
  /** 
  * Método que determina a distância euclidiana entre dois pontos
  * @param    ponto para determinar a distância
  * @return   distância entre os pontos
  **/
  public double distanceTo(Point2D dest)
  {
    double xfactor = Math.pow(dest.getX(), 2) - Math.pow(this.getX(), 2); //destx² - orix²
    double yfactor = Math.pow(dest.getY(), 2) - Math.pow(this.getY(), 2); //desty² - oriy²
    return Math.sqrt(Math.abs(xfactor + yfactor));
  }
  
  /** 
  * Método que cria uma cópia de um ponto
  * @return  copia do ponto
  **/
  public Point2D clone()
  {
    return new Point2D(this);
  }
  
  /** 
  * Método que converte um ponto numa string
  * @return  Representação textual das coordenadas do ponto
  **/
  public String toString(){
    return "x:" + this.x + " y:" + this.y;
  }
}
