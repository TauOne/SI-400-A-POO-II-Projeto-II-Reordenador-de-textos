package reorderGUI;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JTextArea;

/**
 * Classe para criação o arquivo .csv
 *
 * @author Gabriel Marino 247455
 */
public class Exportacao {

    /**
     * Método unico da classe para criação do arquivo<br>
     * e escrita no mesmo, contendo o mesmo nome do arquivo<br>
     * de origem porém num formato .csv<br>
     * <b>Uso:</b><br>
     * Exportacao.escrever(Mapa(chave String , valor String), String nome do
     * arquivo);<br>
     *
     * @param map Recebe de preferência uma TreeMap para ser escrita no arquivo
     * de destino<br>
     * @param arg Recebe o nome do arquivo no formato .txt a ser convertido em
     * .csv.
     * @author Gabriel Marino 247455
     */
    public static void escrever(JTextArea jText, String name) {
        try {
            FileWriter arq = new FileWriter(name);
            try ( PrintWriter gravarArq = new PrintWriter(arq)){
                gravarArq.print(jText.getText());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
