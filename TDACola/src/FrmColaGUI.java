import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmColaGUI {
    private JPanel pGeneral;
    private JTextField txtValor;
    private JTextArea txtResultado;
    private JButton encolarButton;
    private JButton desencolarButton;

    public Cola c = new Cola();

    public FrmColaGUI() {
        encolarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    c.encolar(Integer.parseInt(txtValor.getText()), txtResultado);
                    txtValor.setText("");
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Error!");
                }
            }
        });
        desencolarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c.desencolar(txtResultado);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Colas Modo Gráfico");
        frame.setContentPane(new FrmColaGUI().pGeneral);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
