
public class Acordo {

    private int codigo;
    private String produto;
    private double taxa;
    private Pais comprador;
    private Pais vendedor;

    public Acordo(int cod, String p, double t, Pais comp, Pais vend) {
        this.codigo = cod;
        this.produto = p;
        this.taxa = t;
        this.comprador = comp;
        this.vendedor = vend;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getProduto() {
        return produto;
    }

    public double getTaxa() {
        return taxa;
    }

    public Pais getComprador() {
        return comprador;
    }

    public Pais getVendedor() {
        return vendedor;
    }
}
