package reorderGUI;

import java.awt.HeadlessException;

public class Main
   {
   public static void main(String[] args)
      {
      try
         {
         JanelaPrincipal programa = new JanelaPrincipal();
         programa.inicia();
         }
      catch (HeadlessException excecao)
         {
         imprMsgErroETermina("Programa terminado por uma HeadlessException no metodo main()", excecao);
         }
      catch (Exception excecao)
         {
         imprMsgErroETermina("Programa terminado por uma Generic Exception no metodo main()", excecao);
         }
      }

   private static void imprMsgErroETermina(String mensagem, Exception ocorrencia)
      {
      System.out.println("Mensagem de erro:\t" + mensagem);
      System.out.println("Texto da excecao:\t" + ocorrencia.getMessage());
      System.exit(1);
      }
   }
