package strategy;

public class EnvioExpresso implements MetodoEnvio{
    public void enviar(){
        System.out.println("Pedido enviado via Pedido Expresso");
    }
}
