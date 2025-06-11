import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrdenGUI {
    private JPanel pGeneral;
    private JComboBox comboBox1;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JButton ordenarButton;

    int[] arregloId = new int[20];

    public OrdenGUI() {
        ordenarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if (comboBox1.getSelectedIndex() == 0){
                    textArea1.setText("");
                    textArea2.setText("");
                    burbuja();
                }

                if (comboBox1.getSelectedIndex() == 1){
                    textArea1.setText("");
                    textArea2.setText("");
                    selection();
                }

                if (comboBox1.getSelectedIndex() == 2){
                    textArea1.setText("");
                    textArea2.setText("");
                    insertion();
                }
            }
        });
    }

    public static int alertorio(int max, int min){
        return (int) Math.round(Math.random() * (max- min) + min); //casting forzado
    }

    public int bubbleSort(int [] arr){
        int n = arr.length;
        int iters = 0;
        for (int i = 0; i < n - 1; i++){
            for (int j = 0; j < n - i - 1; j++){
                iters++;
                if (arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return iters;
    }

    public void burbuja(){
        int tam = arregloId.length;
        for (int i = 0; i < tam; i++)
            arregloId[i] = alertorio(255, 1);

        //A. Desordenado
        for (int i = 0; i < tam; i++)
            textArea2.append("\n" + arregloId[i]);

        int pasos = bubbleSort(arregloId);

        //A. Ordenado
        for (int i = 0; i < tam; i++)
            textArea1.append("\n" + arregloId[i]);

        JOptionPane.showMessageDialog(null, "Iteraciones: " + pasos);
    }

    public int selectionSort(int [] arr){
        int n = arr.length;
        int iters = 0;
        int minIdx = 0;
        int i;
        for (i = 0; i < n - 1; i++){
            minIdx = i;
            for (int j = i + 1; j < n; j++){
                iters++;
                if (arr[j] < arr[minIdx]){
                    minIdx = j;
                }
            }
        }
        int temp = arr[minIdx];
        arr[minIdx] = arr[i];
        return iters;
    }

    public void selection(){
        int tam = arregloId.length;
        for (int i = 0; i < tam; i++)
            arregloId[i] = alertorio(255, 1);

        //A. Desordenado
        for (int i = 0; i < tam; i++)
            textArea2.append("\n" + arregloId[i]);

        int pasos = selectionSort(arregloId);

        //A. Ordenado
        for (int i = 0; i < tam; i++)
            textArea1.append("\n" + arregloId[i]);

        JOptionPane.showMessageDialog(null, "Iteraciones: " + pasos);
    }

    public int insertionSort(int [] arr){
        int n = arr.length;
        int iters = 0;

        for (int i = 1; i < n; i++){
            int llave = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > llave){
                arr[j + 1] = arr[j];
                j = j - 1;
                iters++;
            }

            arr[j + 1] = llave;
            iters++;
        }
        return iters;
    }

    public void insertion(){
        int tam = arregloId.length;
        for (int i = 0; i < tam; i++)
            arregloId[i] = alertorio(255, 1);

        //A. Desordenado
        for (int i = 0; i < tam; i++)
            textArea2.append("\n" + arregloId[i]);

        int pasos = insertionSort(arregloId);

        //A. Ordenado
        for (int i = 0; i < tam; i++)
            textArea1.append("\n" + arregloId[i]);

        JOptionPane.showMessageDialog(null, "Iteraciones: " + pasos);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Metodos de Ordenamiento");
        frame.setContentPane(new OrdenGUI().pGeneral);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
