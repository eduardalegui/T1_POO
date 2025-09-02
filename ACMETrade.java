// Imports
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Scanner;

public class ACMETrade {
    private Scanner in = new Scanner(System.in);  
    private PrintStream outPadrao = System.out;  
    private final String nomeArquivoEntrada = "dadosin.txt";  
    private final String nomeArquivoSaida = "dadosout.txt"; 
    private Federacao fed;
    private Convencao con;
    
    public ACMETrade() {
        redirecionaIn();   
        //redirecionaOut(); 
        fed = new Federacao(); 
        con = new Convencao(fed);   
    }

    public void executar(){

        while(true){
            String sigla = in.nextLine();
            
            if(sigla.equals("-1")){
                break;
            }

            String nome = in.nextLine();
            fed.cadastrarPaises(sigla, nome);
        }

        while(true){
            int cod = in.nextInt();
            in.nextLine();
            if(cod == -1){
                break;
            }
            String produto = in.nextLine();
            double taxa = in.nextDouble();
            in.nextLine();
            String comprador = in.nextLine();
            String vendedor = in.nextLine();
            con.cadastrarAcordos(cod, produto, taxa, comprador, vendedor);
        }

            tres();
            quatro();
            cinco();
            seis();
            sete();

            con.listarTodosOsAcordos();
            con.listaTodosOsPaisesVendedores();

    
        //fed.cadastrarPaises(in);

        //String sigla = in.nextLine();
        //String nome = in.nextLine();
        //fed.cadastrarPaises(sigla, nome);

        //con.cadastrarAcordos(in);
        //fed.consultarUmPaisPelaSigla(in);
        //con.consultarAcordoPeloCodigo(in);
        //con.consultarAcordoPelaSiglaDoComprador(in);
        //fed.mudarNomeDeUmDeterminadoPais(in);
        //con.removerAcordosDeUmDeterminadoPaisComprador(in);
        //con.listarTodosOsAcordos();
        //con.listaTodosOsPaisesVendedores();
    }

    private void redirecionaIn() {
        try {
            BufferedReader streamEntrada = new BufferedReader(new FileReader(nomeArquivoEntrada));
            in = new Scanner(streamEntrada);   
        } catch (Exception e) {
            System.out.println(e);
        }
        Locale.setDefault(Locale.ENGLISH);   
        in.useLocale(Locale.ENGLISH); 
    }

    private void redirecionaOut() {
        try {
            PrintStream streamSaida = new PrintStream(new File(nomeArquivoSaida), Charset.forName("UTF-8"));
            System.setOut(streamSaida);             
        } catch (Exception e) {
            System.out.println(e);
        }
        Locale.setDefault(Locale.ENGLISH);   
    }

    private void restauraIn() {
        in = new Scanner(System.in);
    }

    private void restauraOut() {
        System.setOut(outPadrao);
    }

/*
    private void um(){

        System.out.println("===================");
        System.out.print("Digite a sigla do Pais: ");
        String sigla = in.nextLine();
        System.out.print("Digite o nome do Pais: ");
        String nome = in.nextLine();
        fed.cadastrarPaises(sigla, nome);

    }

    private void dois(Federacao fed){
    
        System.out.println("===================");
        System.out.print("Codigo do acordo: ");
        int cod = in.nextInt();
        in.nextLine();

        System.out.print("Digite o nome do produto: ");
        String produto = in.nextLine();

        System.out.print("Digite a taxa: ");
        double taxa = in.nextDouble();
        in.nextLine();

        System.out.print("Digite a sigla do pais comprador: ");
        String comprador = in.nextLine();

        System.out.print("Digite a sigla do pais vendedor: ");
        String vendedor = in.nextLine();

        con.cadastrarAcordos(cod, produto, taxa, comprador, vendedor, fed);
    }

*/

    private void tres(){
        String sigla = in.nextLine();
        fed.consultarUmPaisPelaSigla(sigla);
    }

    private void quatro(){
        int codigo = in.nextInt();
        con.consultarAcordoPeloCodigo(codigo);
    }

    private void cinco(){
        String comp = in.nextLine();
        con.consultarAcordoPelaSiglaDoComprador(comp);
    }

    private void seis(){
        String sigla = in.nextLine();
        String nome = in.nextLine();
       fed.mudarNomeDeUmDeterminadoPais(sigla, nome);
    }

    private void sete(){
        String r = in.nextLine();
        con.removerAcordosDeUmDeterminadoPaisComprador(r);
    }


}

