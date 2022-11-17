package reorderGUI;

import connection.DAO;
import connection.DAOCreator;
import javax.swing.*;
import java.awt.event.*;

public class Autenticacao extends JDialog {

    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField txtUsuario;
    private JPasswordField txtSenha;
    private JLabel lblUsuario;
    private JLabel lblSenha;

    public Autenticacao(JFrame janelaPrincipal) {
        this.setTitle("Autenticação");
        setContentPane(contentPane);
        this.setSize(380, 170);
        setLocationRelativeTo(janelaPrincipal);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getRootPane().setDefaultButton(buttonOK);
        setModal(true);
        setResizable(true);
        buttonOK.addActionListener(e -> onOK());
        buttonCancel.addActionListener(e -> onCancel());
        setVisible(true);

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
        DAO database = DAOCreator.factoryDAO("LocalDAO");
        if(!database.getConnection(txtUsuario.getText(), txtSenha.getPassword().toString()).equals(null)){
            ConstantesGlobais.statusConexao = "Conectado";
            for(String linha : database.retrieve()){
                ConstantesGlobais.textoFinal.add(linha);
            }
        }
        
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        System.out.println("Cancel");
        dispose();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
