
import java.util.ArrayList;

public class Convencao {

    private ArrayList<Acordo> acordos;
    public Federacao fed;

    public Convencao(Federacao fed) {
        acordos = new ArrayList<Acordo>();
        this.fed = fed;
    }

    public void cadastrarAcordos(int cod, String produto, double taxa, String comprador, String vendedor) { //dois
        Pais c = fed.getPaisPelaSigla(comprador);
        Pais v = fed.getPaisPelaSigla(vendedor);

        boolean heaven = true;
        for (Acordo a : acordos) {
            if (a.getCodigo() == cod) {
                heaven = false;
                break;
            }
        }

        if (c != null && v != null && heaven) {
            Acordo a = new Acordo(cod, produto, taxa, c, v);
            acordos.add(a);
            System.out.println("2:" + cod + ";" + produto + ";" + taxa + ";" + comprador + ";" + vendedor);
        } else {
            if (c == null) {
                System.out.println("2:erro-comprador inexistente.");
            }
            if (v == null) {
                System.out.println("2:erro-vendedor inexistente.");
            }
            if (!heaven) {
                System.out.println("2:erro-codigo repetido.");
            }
        }

    }

    public void consultarAcordoPeloCodigo(int codigo) { //quatro

        boolean encontrado = false;
        for (Acordo a : acordos) {
            if (a.getCodigo() == codigo) {
                System.out.println("4:" + a.getCodigo() + ";" + a.getProduto() + ";" + a.getTaxa() + ";" + a.getComprador().getSigla() + ";" + a.getVendedor().getSigla());
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("4:erro-codigo inexistente.");
        }
    }

    public void consultarAcordoPelaSiglaDoComprador(String comp) { //cinco
        boolean encontrado = false;
        for (int k = 0; k < acordos.size(); k++) {
            if ((acordos.get(k).getComprador().getSigla()).equals(comp)) {
                Acordo a = acordos.get(k);
                System.out.println("5:" + a.getCodigo() + ";" + a.getProduto() + ";" + a.getTaxa() + ";" + a.getComprador().getSigla() + ";" + a.getVendedor().getSigla());
                encontrado = true;
                break;  //faz nao printar todos os acordos
            }
        }
        if (!encontrado) {
            System.out.println("5:erro-sigla inexistente.");
        }

    }

    public void removerAcordosDeUmDeterminadoPaisComprador(String r) { //sete
        boolean removido = false;
        for (int i = acordos.size() - 1; i >= 0; i--) {
            if (acordos.get(i).getComprador().getSigla().equals(r)) {
                acordos.remove(i);
                removido = true;
            }
        }
        if (removido) {
            System.out.println("7:acordos removidos.");
        } else {
            System.out.println("7:erro-nenhum acordo encontrado.");
        }
    }

    public void listarTodosOsAcordos() {
        Acordo j = null;
        if (acordos.size() > 0) {
            for (int k = 0; k < acordos.size(); k++) {
                j = acordos.get(k);
                System.out.println("8:" + j.getCodigo() + ";" + j.getProduto() + ";" + j.getTaxa() + ";" + j.getComprador().getSigla() + ";" + j.getVendedor().getSigla());
            }
        } else {
            System.out.println("8:erro-nenhum acordo cadastrado.");
        }
    }


    /*public void listarNaoVendedores(){
        ArrayList<Pais> paises = new ArrayList<Pais>();
        for(int i = 0; i < fed.getPais().size(); i++) {
            paises.add(fed.getPais().get(i));
        }
        for(int i = 0; i < paises.size(); i++) {
            for(int j = 0; j < acordos.size(); j++) {
                if(paises.get(i).getSigla().equals(acordos.get(j).getVendedor().getSigla())) {
                    paises.remove(i);        
                }
            }
        }
        if(paises.size() == 0) {
            System.out.println("9:erro-nenhum país encontrado.");
        } else {
            for(int k = 0; k < paises.size(); k++) {
                System.out.println("9:" + paises.get(k).getSigla() + ";" + paises.get(k).getNome());
            }
        }
    }*/

    public void nao(){
        boolean hevan = true;
        if (acordos.size() > 0) {
                
            for(int g = 0; g < fed.getPais().size();g++){
                boolean have = false;
                //acordos.get(g).getVendedor().getSigla();
                String h = fed.getPais().get(g).getSigla();
   
                for(int x = 0; x < acordos.size(); x++){
                       
                    if (acordos.get(x).getVendedor().getSigla().equals(h)){
                        have=true;
                     
                        // System.out.println("9:" + h + ";" + fed.getPais().get(g).getNome());
                        
                    }
                    // else{
                    //     System.out.println("9:" + h + ";" + fed.getPais().get(g).getNome());
                    //     break;
                    // }
                }
                if(!have){
                    System.out.println("9:" + h + ";" + fed.getPais().get(g).getNome());
                    hevan = false;
                }   
            }
        }if(acordos.size() == 0){
            for(int r = 0; r < fed.getPais().size(); r++){
                String t = fed.getPais().get(r).getSigla();
                String p = fed.getPais().get(r).getNome();
                System.out.println("9:" + t + ";" + p);
            }
        }if(hevan){
            System.out.println("9:erro-nenhum país encontrado.");
        }

 
        // if (acordos.size() > 0) {
        //     for(int g = 0; g < acordos.size();g++){
        //     String h = acordos.get(g).getVendedor().getSigla();
        //         for(int x = 0; x < fed.getPais().size(); x++){
        //             if (fed.getPais().get(x).getSigla().equals(h)){
                        
        //             }
        //         }
        //     }
        // }
    }
    
    public void listaTodosOsPaisesNaoVendedores() {

        String w;
        String x = "";
        String d;
        boolean have = true;

        if (acordos.size() > 0) {
            for (int k = 0; k < acordos.size(); k++) {
                if (k != 0) {
                    w = acordos.get(k).getVendedor().getSigla();
                    if (x != w) {
                        for (int u = 0; u < fed.getPais().size(); u++) {
                            x = w;
                            if (w != fed.getPais().get(u).getSigla()) {
                                System.out.println("9:" + fed.getPais().get(u).getSigla() + ";" + fed.getPais().get(u).getNome());
                                have = false;
                            }
                        }
                    }
                }
            }
        }
        if (acordos.size() == 0) {
            for (int u = 0; u < fed.getPais().size(); u++) {
                d = fed.getPais().get(u).getSigla();
                System.out.println("9:" + fed.getPais().get(u).getSigla() + ";" + fed.getPais().get(u).getNome());
                have = false;
            }
        }
        if (have) {
            System.out.println("9:erro-nenhum pais encontrado.");
        }
    }

    public void mostrarOPaisComAMaiorQuantidadeDeAcordosComoVendedor() {
        int maior = 0;
        String sigla = "";
        String nome = "";
        if (acordos.size() > 0) {
            for (int k = 0; k < fed.getPais().size(); k++) {
                int cont = 0;
                for (int u = 0; u < acordos.size(); u++) {
                    if (fed.getPais().get(k).getSigla().equals(acordos.get(u).getVendedor().getSigla())) {
                        cont++;
                    }
                }
                if (cont > maior) {
                    maior = cont;
                    sigla = fed.getPais().get(k).getSigla();
                    nome = fed.getPais().get(k).getNome();
                }
            }
            System.out.println("10:" + sigla + ";" + nome + ";" + maior);
        } else {
            System.out.println("10:erro-nenhum pais encontrado.");
        }
    }
}
