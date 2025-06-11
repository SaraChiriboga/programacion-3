import javax.swing.*;

public class Cola {
    public Nodo frente, finalCola;
    public int tam;

    public Cola() {
        frente = null;
        finalCola = null;
        tam = 0;
    }

    public boolean estaVacia(){
        return frente == null;
    }

    public void mostrarCola(JTextArea cont){
        if (estaVacia()){
            cont.setText("Cola Vacía!");
        }else {
            StringBuilder colaStr = new StringBuilder();
            Nodo actual = frente;
            while (actual != null){
                colaStr.append(actual.dato)
                        .append("\n");
                actual = actual.sig;
            }

            cont.setText(colaStr.toString());
        }
    }

    public void actualizar(JTextArea cont){
        mostrarCola(cont);
    }

    public void encolar(int dato, JTextArea cont){
        Nodo nuevo = new Nodo(dato);
        if(estaVacia()){
            frente = nuevo;
            finalCola = nuevo;
        }else{
            finalCola.sig = nuevo;
            finalCola = nuevo;
        }
        tam++;
        actualizar(cont);
    }

    public int desencolar(JTextArea cont){
        if (estaVacia()){
            JOptionPane.showMessageDialog(null, "Cola Vacía!");
            return -1;
        }

        int data = frente.dato;
        frente = frente.sig;
        tam--;

        if (frente == null){
            finalCola = null;
        }
        actualizar(cont);
        return data;
    }
}
