package composite;

import java.util.ArrayList;
import java.util.List;

public class Pacote extends ItemPedido{
    private List<ItemPedido> itens = new ArrayList<>();

    public Pacote(String nome){
        super(nome);
    }

    public void adicionarItem(ItemPedido itemPedido){
        itens.add(itemPedido);
    }

    public void removerItem(ItemPedido item){
        itens.remove(item);
    }

    public void exibirDetalhes(){
        System.out.println("Pacote: "+nome);
        for (ItemPedido item : itens){
            item.exibirDetalhes();
        }
    }
}
