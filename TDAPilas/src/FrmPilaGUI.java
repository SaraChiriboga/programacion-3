import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmPilaGUI {
    private JPanel pGeneral;
    private JTextField txtElemento;
    private JTextArea txtResultado;
    private JButton apilarButton;
    private JButton desapilarButton;

    public Pila p = new Pila();

    public FrmPilaGUI() {
        apilarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = txtElemento.getText();
                try{
                    int valor = Integer.parseInt(input);
                    p.apilar(valor, txtResultado);
                    txtElemento.setText("");
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Error en datos!");
                }
            }
        });
        desapilarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p.desapilar(txtResultado);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("FrmPilaGUI");
        frame.setContentPane(new FrmPilaGUI().pGeneral);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
