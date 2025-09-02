
public class Pais {

    private String sigla;
    private String nome;

    public Pais(String s, String n) {
        this.sigla = s;
        this.nome = n;
    }

    public void setNome(String name) {
        this.nome = name;
    }

    public String getSigla() {
        return sigla;
    }

    public String getNome() {
        return nome;
    }
}
