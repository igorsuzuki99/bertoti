package singleton;

public class Configuracoes {
    private static Configuracoes instancia;
    private String idioma;
    private String tema;

    private Configuracoes() {
    }

    public static Configuracoes getInstancia() {
        if (instancia == null) {
            synchronized (Configuracoes.class) {
                if (instancia == null) {
                    instancia = new Configuracoes();
                }
            }
        }
        return instancia;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public void exibirConfiguracoes() {
        System.out.println("Configurações: Idioma - " + idioma + ", Tema - " + tema);
    }
}
