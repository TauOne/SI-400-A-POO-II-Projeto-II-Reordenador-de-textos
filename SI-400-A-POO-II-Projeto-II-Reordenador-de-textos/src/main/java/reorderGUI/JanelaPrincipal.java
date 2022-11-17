package reorderGUI;

import connection.DAO;
import connection.DAOCreator;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class JanelaPrincipal extends JFrame implements ActionListener, Runnable {

    private static final long serialVersionUID = 1L;
    private JPanel painelStatus;
    private JLabel labelStatus;
    private JMenuBar menuBar;
    private JMenu menuArquivo;
    private JMenu menuAjuda;
    private JMenuItem menuItemSaida;
    private JMenuItem menuItemAutenticacao;
    private JMenuItem menuItemAjuda;
    private JMenuItem menuItemSobre;
    private PainelFundo painelFundo;
    private JMenuItem menuItemLimpeza;
    private boolean rodando;

    JanelaPrincipal() throws HeadlessException {
        super(ConstantesGlobais.getNomeVersao());

        this.rodando = false;

        configuraJanela();
        criaAdicionaMenu();
        adicionaOuvinteMenus(this);
        inicializaAdicionaComponentes();
    }

    private void configuraJanela() {
        this.setSize((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() * 0.8), (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.77));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(5, 5));
    }

    private void inicializaAdicionaComponentes() {

        this.painelStatus = new JPanel();
        this.labelStatus = new JLabel();
        this.painelStatus.add(labelStatus);
        this.painelStatus.setBackground(Color.gray);
        this.painelStatus.setBorder(BorderFactory.createEtchedBorder());
        this.add(painelStatus, BorderLayout.SOUTH);

        this.painelFundo = new PainelFundo();
        this.add(painelFundo, BorderLayout.CENTER);

    }

    void setMsgStatus(String texto) {
        this.labelStatus.setText(texto);
    }

    void inicia() {
        this.setMsgStatus(ConstantesGlobais.statusConexao);
        this.setVisible(true);

        this.rodando = true;

        Thread serverDispatcher = new Thread(this);
        serverDispatcher.start();
        DAO database = DAOCreator.factoryDAO("LocalDAO");
        if(!database.getConnection("qualquercoisa", "qualquercoisa").equals(null)){
            ConstantesGlobais.statusConexao = "Conectado";
            for(String linha : database.retrieve()){
                ConstantesGlobais.textoFinal.add(linha);
            }
        }
        
        while (ConstantesGlobais.statusConexao.equals("Desconectado")) {

        }
        for (String linha : ConstantesGlobais.textoFinal) {

            painelFundo.getTxtArea().setText(painelFundo.getTxtArea().getText() + linha);
        }
    }

    private void criaAdicionaMenu() {
        menuArquivo = new JMenu("Arquivo");

        menuItemAutenticacao = new JMenuItem("Autenticação");
        menuArquivo.add(menuItemAutenticacao);

        menuItemLimpeza = new JMenuItem("Limpar");
        menuArquivo.add(menuItemLimpeza);

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

    void adicionaOuvinteMenus(ActionListener ouvinte) {
        for (Component menuPrincipal : this.getJMenuBar().getComponents()) {
            if (menuPrincipal instanceof JMenu) {
                adicionaOuvinteItemMenu(ouvinte, (JMenu) menuPrincipal);
            }
        }
    }

    private void adicionaOuvinteItemMenu(ActionListener ouvinte, JMenu menuPrincipal) {
        for (Component alvo : menuPrincipal.getMenuComponents()) {
            if (alvo instanceof JMenuItem) {
                ((JMenuItem) alvo).addActionListener(ouvinte);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == menuItemSaida) {
            this.rodando = false;
            System.exit(NORMAL);
        }

        if (evento.getSource() == menuItemAjuda) {
            (new TelaDeMensagem(this, "Ajuda - " + ConstantesGlobais.getNomeVersao(), ConstantesGlobais.getTextoAjuda())).setVisible(true);
        }

        if (evento.getSource() == menuItemSobre) {
            (new TelaDeMensagem(this, "Sobre - " + ConstantesGlobais.getNomeVersao(), ConstantesGlobais.getTextoSobre())).setVisible(true);
        }

        if (evento.getSource() == menuItemAutenticacao) {
            new Autenticacao(this);
            painelFundo.limpaConteudo();
        }
        if (evento.getSource() == menuItemLimpeza) {
            painelFundo.limpaConteudo();
        }
    }

    @Override
    public void run() {
        while (this.rodando) {
            //painelFundo.repaint();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
