package composite;

public class Produto extends ItemPedido{
    private double preco;

    public Produto(String nome, double preco){
        super(nome);
        this.preco = preco;
    }

    public void exibirDetalhes(){
        System.out.println("Produto: "+nome+", Preço: "+preco);
    }
}
