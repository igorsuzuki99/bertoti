package composite;

public abstract class ItemPedido {
    protected String nome;

    public ItemPedido(String nome){
        this.nome=nome;
    }

    public abstract void exibirDetalhes();

    public void adicionarItem(ItemPedido item) {
    }

    public void removerItem(ItemPedido item) {
    }
}
