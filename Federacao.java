    import java.util.ArrayList;
    public class Federacao {
        private ArrayList<Pais> paises;

        public Federacao(){//---------------
            paises = new ArrayList<Pais>();
        }

        public ArrayList<Pais> getPais(){
            return paises;
        }

        /*public boolean verificaSigla(String sigla){
            for(int k = 0; k < paises.size(); k++){
                if(paises.get(k).getSigla().equals(sigla)){
                    c = paises.get(k);
                    return true;
                }
            }
        }*/

        public Pais getPaisPelaSigla(String sigla){

            Pais p = null;
            for(int k = 0; k < paises.size(); k++){
                if(paises.get(k).getSigla().equals(sigla)){
                    p = paises.get(k);
                    return p;
                }
            }
            return p;
        }

        /*public Pais getPaisPelaSigla(String sigla){
            for(Pais p : paises){
                if(p.getSigla().equals(sigla)){
                    return p;
                }
            }
            return null; // retorna null se não encontrou
        }*/

        public void cadastrarPaises(String sigla, String nome) { //um

                boolean have = true;
                
                for(int k = 0; k<paises.size(); k++){
                    if(paises.get(k).getSigla().equals(sigla)){
                        System.out.println("1:erro-sigla repetida.");
                        have = false;
                        break;
                    }
                }
                if(have){
                    Pais y = new Pais(sigla, nome);
                    paises.add(y);
                    System.out.println("1:" + sigla + ";" + nome);
                }
            
        }

        public void consultarUmPaisPelaSigla(String sigla){ //tres
            Pais encontrado = null;
            for(Pais p : paises){
                if(p.getSigla().equals(sigla)){
                    encontrado = p;
                    break;
                }
            }
            if(encontrado != null){
                System.out.println("3:" + encontrado.getSigla() + ";" + encontrado.getNome());
            } else {
                System.out.println("3:erro-sigla inexistente.");
            }
    
        }

        public Pais mudarNomeDeUmDeterminadoPais(String sigla, String nome){ //seis
            Pais c = null;
   
                for(int k = 0; k<paises.size(); k++){
                    if(paises.get(k).getSigla().equals(sigla)){
                        c = paises.get(k);
                        c.setNome(nome);     
                        return c;         
                    }
                }
                return c;
                //trabalhinho legal do yama!
            
        }
    }
