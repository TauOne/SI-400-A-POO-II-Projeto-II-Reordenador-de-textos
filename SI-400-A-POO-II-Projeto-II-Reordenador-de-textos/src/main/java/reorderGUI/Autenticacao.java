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
    private JTextField txtSenha;
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
        String i = "LocalDAO";

        System.out.println(txtUsuario.getText() + txtSenha.getText());
        if(txtUsuario.getText().equals("si400_2022") && txtSenha.getText().equals("si400_2022")){
            System.out.println("caiu aqui");
            i = "MariaDBDAO";
        }

        System.out.println(i);
        DAO database = DAOCreator.factoryDAO(i);
        System.out.println(database.getConnection(txtUsuario.getText(),  txtSenha.getText()));

        if(!database.getConnection("qualquercoisa", "qualquercoisa").equals(null)){
            for(String linha : database.retrieve()){
                ConstantesGlobais.textoFinal.add(linha+"\n");
            }
            ConstantesGlobais.statusConexao = "Conectado";
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
