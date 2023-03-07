public class SeguroCasa implements Cotacao {

    public double calcularSeguro(double valorVenal) {
        double valorSeguroCasa = valorVenal*0.0075;
        System.out.println("O valor do seguro da sua casa será de R$"+String.format("%.2f",valorSeguroCasa)+" por ano");
        return valorSeguroCasa;
    }
}
