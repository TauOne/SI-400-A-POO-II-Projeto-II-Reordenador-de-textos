package reorderGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

class JanelaPrincipal extends JFrame implements ActionListener, Runnable
   {
   private static final long serialVersionUID = 1L;
   private JPanel            painelStatus;
   private JLabel            labelStatus;
   private JMenuBar          menuBar;
   private JMenu             menuArquivo;
   private JMenu             menuAjuda;
   private JMenuItem         menuItemSaida;
   private JMenuItem         menuItemAutenticacao;
   private JMenuItem         menuItemAjuda;
   private JMenuItem         menuItemSobre;
   private PainelFundo       painelFundo;
   private JScrollPane       painelRolagem;
   private boolean           rodando;

   JanelaPrincipal() throws HeadlessException
      {
      super(ConstantesGlobais.getNomeVersao());

      this.rodando = false;

      configuraJanela();
      criaAdicionaMenu();
      adicionaOuvinteMenus(this);
      inicializaAdicionaComponentes();
      }

   private void configuraJanela()
      {
      this.setSize((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() * 0.5 / 2), (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.45));
      this.setLocationRelativeTo(null);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setLayout(new BorderLayout(5, 5));
      }

   private void inicializaAdicionaComponentes()
      {
      this.painelStatus = new JPanel();
      this.labelStatus = new JLabel();
      this.painelStatus.add(labelStatus);
      this.painelStatus.setBackground(Color.gray);
      this.painelStatus.setBorder(BorderFactory.createEtchedBorder());
      this.add(painelStatus, BorderLayout.SOUTH);

      this.painelFundo = new PainelFundo();
      this.painelRolagem = new JScrollPane(painelFundo, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
      this.add(painelRolagem, BorderLayout.CENTER);
      }

   void setMsgStatus(String texto)
      {
      this.labelStatus.setText(texto);
      }

   void inicia()
      {
      this.setMsgStatus(ConstantesGlobais.universidade);
      this.setVisible(true);

      this.rodando = true;
      
      Thread serverDispatcher = new Thread(this);
      serverDispatcher.start();
      }

   private void criaAdicionaMenu()
      {
      menuArquivo = new JMenu("Arquivo");

      menuItemAutenticacao = new JMenuItem("Autenticação");
      menuArquivo.add(menuItemAutenticacao);

      menuArquivo.addSeparator();

      menuItemSaida = new JMenuItem("Saida");
      menuArquivo.add(menuItemSaida);

      menuAjuda = new JMenu("Ajuda");

      menuItemAjuda = new JMenuItem("Ajuda");
      menuAjuda.add(menuItemAjuda);

      menuItemSobre = new JMenuItem("Sobre");
      menuAjuda.add(menuItemSobre);

      menuBar = new JMenuBar();
      menuBar.add(menuArquivo);
      menuBar.add(menuAjuda);

      this.setJMenuBar(menuBar);
      }

   void adicionaOuvinteMenus(ActionListener ouvinte)
      {
      for (Component menuPrincipal : this.getJMenuBar().getComponents())
         {
         if (menuPrincipal instanceof JMenu)
            {
            adicionaOuvinteItemMenu(ouvinte, (JMenu) menuPrincipal);
            }
         }
      }

   private void adicionaOuvinteItemMenu(ActionListener ouvinte, JMenu menuPrincipal)
      {
      for (Component alvo : menuPrincipal.getMenuComponents())
         {
         if (alvo instanceof JMenuItem)
            {
            ((JMenuItem) alvo).addActionListener(ouvinte);
            }
         }
      }

   @Override
   public void actionPerformed(ActionEvent evento)
      {
      if (evento.getSource() == menuItemSaida)
         {
         this.rodando = false;
         System.exit(NORMAL);
         }

      if (evento.getSource() == menuItemAjuda)
         {
         (new TelaDeMensagem(this, "Ajuda - " + ConstantesGlobais.getNomeVersao(), ConstantesGlobais.getTextoAjuda())).setVisible(true);
         }

      if (evento.getSource() == menuItemSobre)
         {
         (new TelaDeMensagem(this, "Sobre - " + ConstantesGlobais.getNomeVersao(), ConstantesGlobais.getTextoSobre())).setVisible(true);
         }

      if (evento.getSource() == menuItemAutenticacao)
         {
         painelFundo.setCorFundo(Color.red);
         }
      }

   @Override
   public void run()
      {
      while (this.rodando)
         {
         // Aqui acontece a atualizacao da tela
         painelFundo.repaint();
         try
            {
            // Pausa de 1 seg (1.000 milisegundos) para evitar efeitos indesej�veis na composicao da tela
            Thread.sleep(1000);
            }
         catch (InterruptedException e)
            {
            e.printStackTrace();
            }
         }
      }

   }
