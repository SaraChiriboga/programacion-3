import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GrafoGUI {
    private JTable tbMatrizadyacencia;
    private JTextArea txtResultado;
    private JButton agregarVérticeButton;
    private JButton agregarLadoButton;
    private JTextField txtX;
    private JTextField txtY;
    private JTextField txtV1;
    private JTextField txtV2;
    private JButton dibujarGrafoButton;
    private JPanel pGeneral;
    private JPanel pGrafo;
    private JButton BFSButton;
    private JTextField txtInicio;
    private JButton DFSButton;

    private DefaultTableModel modeloTabla;

    private Grafo grafo = new Grafo(20);
    private GrafoPanel grafoPanel = new GrafoPanel(grafo);

    public GrafoGUI() {
        agregarVérticeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    int x = Integer.parseInt(txtX.getText());
                    int y = Integer.parseInt(txtY.getText());
                    String label = grafo.getEtiquetaVerticeSiguiente();
                    Vertice vertice = new Vertice(x, y, label);
                    grafo.anadirVertice(vertice);
                    actualizarModeloTabla();
                    imprimirGrafo();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese coordenadas válidas.");
                }
            }
        });
        agregarLadoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int v1Index = Integer.parseInt(txtV1.getText());
                    int v2Index = Integer.parseInt(txtV2.getText());
                    grafo.anadirLado(v1Index, v2Index);
                    actualizarModeloTabla();
                    imprimirGrafo();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese índices válidos.");
                }
            }
        });
        dibujarGrafoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                grafoPanel.setVisible(true);
                grafoPanel.repaint(); // Redibujar el grafo
                grafoPanel.paintComponent(pGrafo.getGraphics());
            }
        });
        BFSButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int inicio = Integer.parseInt(txtInicio.getText());
                    String bfsResultado = grafo.bfs(inicio);
                    txtResultado.append("BFS desde vertice " + inicio + ": " + bfsResultado + "\n");
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        DFSButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int inicio = Integer.parseInt(txtInicio.getText());
                    String dfsResultado = grafo.dfs(inicio);
                    txtResultado.append("DFS desde vertice " + inicio + ": " + dfsResultado + "\n");
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    private void actualizarModeloTabla() {
        boolean[][] adjMatrix = grafo.getMatrizAdyacencia();
        int vertexCount = grafo.getContarVertice();
        modeloTabla = new DefaultTableModel();
        modeloTabla.setRowCount(0);
        modeloTabla.setColumnCount(0);

        for (int i = 0; i < vertexCount; i++) {
            modeloTabla.addColumn(grafo.getVertices().get(i).etiqueta);
        }

        for (int i = 0; i < vertexCount; i++) {
            Object[] row = new Object[vertexCount];
            for (int j = 0; j < vertexCount; j++) {
                row[j] = adjMatrix[i][j] ? 1 : 0;
            }
            modeloTabla.addRow(row);
        }
        tbMatrizadyacencia.setModel(modeloTabla);
    }

    private void imprimirGrafo() {
        txtResultado.setText(""); // Limpiar el JTextArea
        txtResultado.append("Vertices:\n");
        for (int i = 0; i < grafo.getVertices().size(); i++) {
            txtResultado.append(i + ": " + grafo.getVertices().get(i).toString() + "\n");
        }

        txtResultado.append("\nLados:\n");
        boolean[][] adjMatrix = grafo.getMatrizAdyacencia();
        for (int i = 0; i < grafo.getContarVertice(); i++) {
            for (int j = i + 1; j < grafo.getContarVertice(); j++) {
                if (adjMatrix[i][j]) {
                    txtResultado.append(grafo.getVertices().get(i).etiqueta + " -> " +
                            grafo.getVertices().get(j).etiqueta + "\n");
                }
            }
        }


    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("GrafoGUI");
        frame.setContentPane(new GrafoGUI().pGeneral);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
