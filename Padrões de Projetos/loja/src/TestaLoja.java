import composite.ItemPedido;
import composite.Pacote;
import composite.Produto;
import facade.LojaFacade;
import observer.Cliente;
import observer.Observador;
import strategy.EnvioExpresso;
import strategy.MetodoEnvio;

public class TestaLoja {
    public static void main(String[] args) {

        LojaFacade lojaFacade = new LojaFacade();
        Observador cliente1 = new Cliente("Cliente 1");
        Observador cliente2 = new Cliente("Cliente 2");
        ItemPedido produto1 = new Produto("Meia", 15.90);
        ItemPedido produto2 = new Produto("Boné", 20.90);
        ItemPedido pacote = new Pacote("Pacote 1");
        pacote.adicionarItem(produto1);
        pacote.adicionarItem(produto2);

        // Define método de envio
        MetodoEnvio envioExpresso = new EnvioExpresso();
        lojaFacade.definirMetodoEnvio(envioExpresso);

        // Adiciona observadores
        lojaFacade.adicionarObservador(cliente1);
        lojaFacade.adicionarObservador(cliente2);

        // Adiciona itens ao pedido
        lojaFacade.adicionarItemPedido(pacote);

        // Notifica os clientes
        lojaFacade.notificarClientes("Novo produto adicionado");

        // Exibe as configurações
        lojaFacade.exibirConfiguracoes();

        // Realizan o pedido
        lojaFacade.realizarPedido();
    }
}

//Neste exemplo, o código simula uma loja.
//O padrão Strategy é usado para definir diferentes estratégias de envio.
//O padrão Observer é aplicado para notificar os clientes sobre atualizações no status dos pedidos.
//O padrão Composite é utilizado para organizar os itens do pedido em uma estrutura hierárquica.
//O padrão Singleton é usado para garantir que exista apenas uma instância das configurações da loja.
//O padrão Facade é empregado para realizar pedidos, notificar clientes e exibir configurações.


