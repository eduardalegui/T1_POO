import java.util.ArrayList;
import java.util.Random;

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
        for(Acordo a : acordos){
            if(a.getCodigo() == cod){
                heaven = false;
                break;
            }
        }

        if(c != null && v != null && heaven){
            Acordo a = new Acordo(cod, produto, taxa, c, v);
            acordos.add(a); //  tu não estava adicionando na lista
            System.out.println("2:" + cod + ";"+ produto + ";" + taxa + ";" + comprador + ";" + vendedor );
        } else {
            if(c == null) System.out.println("2:erro-comprador inexistente.");
            if(v == null) System.out.println("2:erro-vendedor inexistente.");
            if(!heaven) System.out.println("2:erro-codigo repetido.");
        }

    }
    

    public void consultarAcordoPeloCodigo(int codigo){ //quatro
 
        boolean encontrado = false;
        for(Acordo a : acordos){
            if(a.getCodigo() == codigo){
                System.out.println("4:" + a.getCodigo() + ";" + a.getProduto() + ";" + a.getTaxa() + ";" + a.getComprador().getSigla() + ";" + a.getVendedor().getSigla());
                encontrado = true;
                break;
            }
        }
        if(!encontrado){
            System.out.println("4:erro-codigo inexistente.");
        }
    }

    public void consultarAcordoPelaSiglaDoComprador(String comp){ //cinco
        boolean encontrado = false;
        for(int k = 0; k < acordos.size(); k++){
            if((acordos.get(k).getComprador().getSigla()).equals(comp)){
                Acordo a = acordos.get(k);
                System.out.println("5:" + a.getCodigo() + ";" + a.getProduto() + ";" + a.getTaxa() + ";" + a.getComprador().getSigla() + ";" + a.getVendedor().getSigla());  
                encontrado = true;
                break;
            }
        }
        if(!encontrado){
            System.out.println("5:erro-sigla inexistente.");
        }

    }

    public void removerAcordosDeUmDeterminadoPaisComprador(String r){ //sete
        boolean removido = false;
        for(int i = acordos.size() - 1; i >= 0; i--){
            if(acordos.get(i).getComprador().getSigla().equals(r)){
                acordos.remove(i);
                removido = true;
            }
        }
        if(removido){
            System.out.println("7:acordos removidos.");
        } else {
            System.out.println("7:erro-nenhum acordo encontrado.");
        }
    }

    public void listarTodosOsAcordos(){ //ok
        Acordo j = null;
        if(acordos.size() > 0){
            for(int k = 0; k<acordos.size();k ++){
                j = acordos.get(k);
                System.out.println("8:" + j.getCodigo() + ";" + j.getProduto() + ";" + j.getTaxa() + ";" + j.getComprador().getSigla() + ";" + j.getVendedor().getSigla());       
            }
        }else{
            System.out.println("8:erro-nenhum acordo cadastrado.");
        }
    }

    public void listaTodosOsPaisesVendedores(){
        String w;
        String x = "";
        if(acordos.size() > 0){
            for(int k = 0; k<acordos.size();k ++){
                w = acordos.get(k).getVendedor().getSigla();
                if(x != w){
                    for(int u = 0; u<fed.getPais().size();u ++){
                        x = w;
                        if(w != fed.getPais().get(u).getSigla()){
                            System.out.println("9:"+ fed.getPais().get(u).getSigla() + ";" + fed.getPais().get(u).getNome()); 
                        }  
                    }
                }
            } 
        }else{
            System.out.println("9:erro-nenhum pais encontrado.");
        }
    }


        // if(fed.getPais().size() > 0){
        //     for(int k = 0; k<fed.getPais().size();k ++){
        //         w = fed.getPais().get(k).getSigla();
        //         for(int u = 0; k<acordos.size();u ++){
        //             if(w != acordos.get(u).getVendedor().getSigla()){
        //                 System.out.println("9:"+ fed.getPais().get(k).getSigla() + ";" + fed.getPais().get(k).getNome()); 
        //             }  
        //         }
        //     } 
        // }else{
        //     System.out.println("9:erro-nenhum pais encontrado.");
        // }


    
    //     if(acordos.size() > 0){
    //     for(int k = 0; k<acordos.size();k ++){
    //         q = acordos.get(k).getVendedor();
    //         e = acordos.get(k).getComprador();
    //         s = q.getSigla();
    //         n = e.getSigla(); 
    //         if(n != acordos.get(k).getVendedor().getSigla()){
    //             System.out.println("9:"+ e.getSigla() + ";" + e.getNome()); 
    //         }  
    //     } 
    // }if (fed.getPais().size() > 0){
    //     for(int k = 0; k<fed.getPais().size();k ++){
    //         w = fed.getPais().get(k).getSigla();
    //         for(int u = 0; k<acordos.size();u ++){
    //             if(w != acordos.get(u).getVendedor().getSigla()){
    //                 System.out.println("9:"+ fed.getPais().get(k).getSigla() + ";" + fed.getPais().get(k).getNome()); 
    //             }  
    //         }
    //     } 
    // }else{
    //     System.out.println("9:erro-nenhum pais encontrado.");
    // }



    // public void listaTodosOsPaisesVendedores(){
    //     Pais q = null;
    //     if(acordos.size() > 0){
    //         for(int k = 0; k<acordos.size();k ++){
    //             q = acordos.get(k).getVendedor();
    //             System.out.println("9:"+ q.getSigla() + ";" + q.getNome());   
    //         } 
    //     }else{
    //         System.out.println("9:erro-nenhum pais encontrado.");
    //     }
    // }

}

/*public void cadastrarAcordos(int cod, String produto, double taxa, String comprador, String vendedor) { //dois
        Pais c = null;
        Pais v = null;
        boolean heaven = true;

        
            for(int k = 0; k < acordos.size(); k++){
                if(cod == acordos.get(k).getCodigo()){
                    heaven = false;
                }
            }

        if(fed.verificaSigla(comprador) && fed.verificaSigla(vendedor) && heaven){
            Acordo a = new Acordo(cod, produto, taxa, c, v);
            System.out.println("2:" + cod + ";"+ produto + ";" + taxa + ";" + comprador + ";" + vendedor + "\n");
        }if(!heaven){
            System.out.println("2:erro-codigo repetido.");
        }if(!fed.verificaSigla(comprador)){
            System.out.println("2:erro-comprador inexistente.");
        }if(!fed.verificaSigla(vendedor)){
            System.out.println("2:erro-vendedor inexistente.");
        }

    }*/