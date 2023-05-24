package facade;

import composite.ItemPedido;
import composite.Pacote;
import observer.NotificadorPedidos;
import observer.Observador;
import singleton.Configuracoes;
import strategy.EnvioNormal;
import strategy.MetodoEnvio;

public class LojaFacade {
    private MetodoEnvio metodoEnvio;
    private NotificadorPedidos notificadorPedidos;
    private ItemPedido itemPedido;
    private Configuracoes configuracoes;

    public LojaFacade(){
        metodoEnvio = new EnvioNormal();
        notificadorPedidos = new NotificadorPedidos();
        itemPedido = new Pacote("Pacote Principal");
        configuracoes = Configuracoes.getInstancia();
    }

    public void definirMetodoEnvio(MetodoEnvio metodo) {
        metodoEnvio = metodo;
    }

    public void adicionarObservador(Observador observador) {
        notificadorPedidos.adicionarObservador(observador);
    }

    public void removerObservador(Observador observador) {
        notificadorPedidos.removerObservador(observador);
    }

    public void adicionarItemPedido(ItemPedido item) {
        itemPedido.adicionarItem(item);
    }

    public void removerItemPedido(ItemPedido item) {
        itemPedido.removerItem(item);
    }

    public void notificarClientes(String mensagem) {
        notificadorPedidos.notificar(mensagem);
    }

    public void exibirConfiguracoes() {
        configuracoes.exibirConfiguracoes();
    }

    public void realizarPedido() {
        System.out.println("Realizando pedido...");
        metodoEnvio.enviar();
        itemPedido.exibirDetalhes();
        System.out.println("Pedido realizado com sucesso!");
    }
}
