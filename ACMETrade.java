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

    public void executar() {

        while (true) {
            String sigla = in.nextLine();

            if (sigla.equals("-1")) {
                break;
            }

            String nome = in.nextLine();
            fed.cadastrarPaises(sigla, nome);
        }

        while (true) {
            int cod = in.nextInt();
            in.nextLine();
            if (cod == -1) {
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
        in.nextLine();
        cinco();
        seis();
        sete();
        con.listarTodosOsAcordos();
        con.listaTodosOsPaisesVendedores();
        con.mostrarOPaisComAMaiorQuantidadeDeAcordosComoVendedor();
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

    private void tres() {
        String sigla = in.nextLine();
        fed.consultarUmPaisPelaSigla(sigla);
    }

    private void quatro() {
        int codigo = in.nextInt();
        con.consultarAcordoPeloCodigo(codigo);

    }

    private void cinco() {
        String comp = in.nextLine();
        con.consultarAcordoPelaSiglaDoComprador(comp);
    }

    private void seis() {

        String sigla = in.nextLine();
        String nome = in.nextLine();
        Pais w = fed.mudarNomeDeUmDeterminadoPais(sigla, nome);
        if (w == null) {
            System.out.println("6:erro-sigla inexistente.");
        } else {
            System.out.println("6:" + w.getSigla() + ";" + w.getNome());
        }
    }

    private void sete() {
        String r = in.nextLine();
        con.removerAcordosDeUmDeterminadoPaisComprador(r);
    }

}
