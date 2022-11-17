package reorderGUI;

import java.util.ArrayList;
import java.util.List;

public class ConstantesGlobais
   {
   public static final String autor        = "Prof. Dr. Andre F. de Angelis";
   public static final String escola       = "FT - Faculdade de Tecnologia";
   public static String statusConexao      = "Desconectado";
   public static final String universidade = "Unicamp - Universidade Estadual de Campinas";
   public static final String nome         = "Projeto II - Reordenador de Texto";
   public static final String versao       = "Ver. 1.0";

   public static final String matheus  = "/images/imagem1.jpeg";
   public static final String tauan  = "/images/imagem2.jpeg";
   public static final String wara  = "/images/imagem3.jpeg";
   public static final String gabriel  = "/images/imagem4.jpeg";
   public static final String rodrigo  = "/images/imagem5.jpeg";
   public static String fileName;

   
   public static List<String> textoFinal = new ArrayList();

   /**
    * Creates a String with the informative text for the AboutScreen
    * 
    * @return the informative text
    */
   static String getTextoSobre()
      {
      final StringBuffer text = new StringBuffer();

      text.append("\n");
      text.append(universidade);
      text.append("\n\n");
      text.append(escola);
      text.append("\n\n");
      text.append(autor);
      text.append("\n\n");
      text.append(nome);
      text.append("\n\n");
      text.append(versao);
      text.append("\n");

      return (text.toString());
      }

   /**
    * Creates a String with the informative text for the HelpScreen
    * 
    * @return the informative text
    */
   static String getTextoAjuda()
      {
      StringBuilder text = new StringBuilder();

      text.append("\n");
      text.append("Reordenador de textos.\n");
      text.append("\n");
      text.append("Este programa recebe e reorganiza textos de uma database tanto remota\n");
      text.append("\n");
      text.append("quanto local, por meio de colunas nas tabelas do banco contendo os\n");
      text.append("\n");
      text.append("numeros do grupos (pelo identificador groupId) que se relacionam \n");
      text.append("\n");      
      text.append("com o texto e o numero das linhas (line) representando sua sequencia.\n");
      text.append("\n");
      text.append("Aviso: este programa foi projetado e implementado apenas com fins educacionais.\n");
      text.append("\n");

      return (text.toString());
      }

   /**
    * Creates a String with the name and the version of the program for convenience
    * 
    * @return name and the version of the program as a single string
    */
   static String getNomeVersao()
      {
      return (nome + " - " + versao);
      }
   }
