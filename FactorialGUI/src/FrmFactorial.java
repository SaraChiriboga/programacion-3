import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmFactorial {
    private JPanel pGeneral;
    private JTextField textField1;
    private JButton calcularButton;
    private JTable table1;

    public FrmFactorial() {
        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fact = textField1.getText();
                try{
                    int numero = Integer.parseInt(fact);
                    long resultado = calcularFactorial(numero);

                    DefaultTableModel model = new DefaultTableModel(new Object[]{"Numero", "Factorial"}, 0);
                    model.addRow(new Object[]{"Numero", "Factorial"});
                    model.addRow(new Object[]{numero, resultado});
                    table1.setModel(model);
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Error!");
                }
            }
        });
    }

    public long calcularFactorial(int num){
        if (num == 0){
            return 1;
        }else{
            return num * calcularFactorial(num - 1);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("FrmFactorial");
        frame.setContentPane(new FrmFactorial().pGeneral);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
