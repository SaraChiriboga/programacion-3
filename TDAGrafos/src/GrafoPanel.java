import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GrafoPanel extends JPanel {
    private Grafo grafo;

    public GrafoPanel(Grafo grafo) {
        this.grafo = grafo;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(2));

        // Dibujar las aristas
        boolean[][] adjMatrix = grafo.getMatrizAdyacencia();
        ArrayList<Vertice> vertices = grafo.getVertices();

        for (int i = 0; i < grafo.getContarVertice(); i++) {
            for (int j = i + 1; j < grafo.getContarVertice(); j++) {
                if (adjMatrix[i][j]) {
                    Vertice v1 = vertices.get(i);
                    Vertice v2 = vertices.get(j);
                    g2d.drawLine(v1.x, v1.y, v2.x, v2.y);
                }
            }
        }

        // Dibujar los vértices y sus etiquetas
        for (Vertice vertice : vertices) {
            g2d.fillOval(vertice.x - 5, vertice.y - 5, 10, 10);
            g2d.drawString(vertice.etiqueta, vertice.x + 10, vertice.y);
        }
    }
}