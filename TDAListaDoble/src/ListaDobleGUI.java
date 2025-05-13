import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListaDobleGUI {
    private JButton agregarButton;
    private JButton eliminarButton;
    private JButton ordenarButton;
    private JButton buscarButton;
    private JButton mostrarButton;
    private JTextField textField1;
    private JTextArea textArea1;
    private JPanel pGeneral;

    ListaDoble lista = new ListaDoble();

    public ListaDobleGUI() {
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String entrada = textField1.getText();
                try{
                    int dato = Integer.parseInt(entrada);
                    lista.agregar(dato, textArea1);
                    textField1.setText("");
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Error!");
                }
            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String entrada = textField1.getText();
                try{
                    int dato = Integer.parseInt(entrada);
                    lista.eliminar(dato, textArea1);
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
                JOptionPane.showMessageDialog(null, "Lista ordenada!");
            }
        });

        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lista.mostrarLista(textArea1);

            }
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String i = textField1.getText();
                try {
                    int b = Integer.parseInt(i);
                    int pos = lista.buscar(b);
                    if (pos==-1){
                        JOptionPane.showMessageDialog(null, "Elemento no encontrado jijijiji");

                    }else {
                        JOptionPane.showMessageDialog(null, "Elemento: " +b + " encontrado ijjijijij");
                    }
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "ERORR!!!!");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ListaDobleGUI");
        frame.setContentPane(new ListaDobleGUI().pGeneral);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
