import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmVector2D {
    private JPanel pGeneral;
    private JTextField txtV1x;
    private JTextField txtV1y;
    private JTextField txtV2x;
    private JTextField txtV2y;
    private JButton calcularButton;
    private JButton limpiarButton;
    private JTextArea txtResultado;

    Vector2D v1,v2;

    public FrmVector2D() { //se recomienda hacer un constructor vacío porque los elementos gráficos se instancian
        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                v1 = new Vector2D(Integer.parseInt(txtV1x.getText()), Integer.parseInt(txtV1y.getText()));
                v2 = new Vector2D(Integer.parseInt(txtV2x.getText()), Integer.parseInt(txtV2y.getText()));

                txtResultado.append("\nSumar " + v1.sumar(v2).toString());
                txtResultado.append("\nRestar " + v1.restar(v2).toString());
                txtResultado.append("\nMultiplicar " + v1.multiplicar(v2).toString());
                txtResultado.append("\nDividir " + v1.dividir(v2).toString());
            }
        });

        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtResultado.setText("");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("FrmVector2D");
        frame.setContentPane(new FrmVector2D().pGeneral);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
