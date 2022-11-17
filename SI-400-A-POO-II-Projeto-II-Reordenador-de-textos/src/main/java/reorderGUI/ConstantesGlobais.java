package reorderGUI;

import java.util.ArrayList;
import java.util.List;

class ConstantesGlobais
   {
   public static final String autor        = "Prof. Dr. Andre F. de Angelis";
   public static final String escola       = "FT - Faculdade de Tecnologia";
   public static String statusConexao      = "Desconectado";
   public static final String universidade = "Unicamp - Universidade Estadual de Campinas";
   public static final String nome         = "Projeto II - Reordenador de Texto";
   public static final String versao       = "Ver. 1.0";

   public static final String arqLogotipo  = "logouni.jpg";
   
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
      text.append("Programa simples para exemplo de aplicacao Java com interface grafica.\n");
      text.append("\n");
      text.append("Aviso: este programa foi projetado e implementado apenas com fins educacionais.\n");
      text.append("NAO ha garantia de tipo nenhum, implicita ou explicita.\n");
      text.append("\n");
      text.append("NAO use este programa em situacoes onde ele possa causar ou contribuir para\n");
      text.append("   risco de morte, ferimentos ou danos de qualquer natureza.\n");
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
