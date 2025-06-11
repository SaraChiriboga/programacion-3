import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmBusquedas {
    private JTextField textField1;
    private JTextArea textArea1;
    private JButton agregarButton;
    private JButton eliminarButton;
    private JButton ordenarButton;
    private JButton buscarLinealButton;
    private JButton buscarInterpoladoButton;
    private JPanel pGeneral;

    Lista lista = new Lista();

    public FrmBusquedas() {
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = textField1.getText();
                try{
                    int valor = Integer.parseInt(input);
                    lista.agregar(valor, textArea1);
                    textField1.setText("");
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Error!");
                }
            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = textField1.getText();
                try{
                    int valor = Integer.parseInt(input);
                    lista.eliminar(valor, textArea1);
                    textField1.setText("");
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Error!");
                }
            }
        });
        ordenarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lista.ordenarBurbuja(textArea1);
                JOptionPane.showMessageDialog(null, "Lista Ordenada!");
            }
        });
        buscarLinealButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = textField1.getText();
                try{
                    int valor = Integer.parseInt(input);
                    int posicion = lista.buscarLineal(valor, textArea1);
                    if (posicion == -1){
                        JOptionPane.showMessageDialog(null, "Elemento no encontrado!");
                    }else {
                        JOptionPane.showMessageDialog(null, "Elemento: " + valor + "encontrado en la posicion " + posicion);
                    }
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Error!");
                }
            }
        });
        buscarInterpoladoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = textField1.getText();
                try{
                    int valor = Integer.parseInt(input);
                    int posicion = lista.buscarInterpolado(valor, textArea1);
                    if (posicion == -1){
                        JOptionPane.showMessageDialog(null, "Elemento no encontrado!");
                    }else {
                        JOptionPane.showMessageDialog(null, "Elemento: " + valor + " encontrado en la posicion " + posicion);
                    }
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Error!");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Busqueda");
        frame.setContentPane(new FrmBusquedas().pGeneral);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
